package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class ChooseActivity extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ImageView deyatels = findViewById(R.id.deyatels);
        ImageView events = findViewById(R.id.events);
        ImageView quiz = findViewById(R.id.quiz);
        ImageView contrMember = findViewById(R.id.contr_member);
        ImageView contQuiz = findViewById(R.id.cont_quiz);
        SwitchCompat contrMode = findViewById(R.id.contr_mode);
        listView1 = findViewById(R.id.listview1);
        initList();
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String deyatel_name = (String) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", (String) parent.getItemAtPosition(position));
                Intent intent = new Intent(ChooseActivity.this, WebViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent, bundle);
            }
        });
        deyatels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, SearchActivity.class));
            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, ChooseEventsActivity.class));
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, QuizActivity.class));
            }
        });
        contrMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, MainCommanders.class));
            }
        });
        contrMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contVisible = contrMode.isChecked() ? View.VISIBLE : View.INVISIBLE;
                int contInvisible = contrMode.isChecked() ? View.INVISIBLE : View.VISIBLE;
                deyatels.setVisibility(contInvisible);
                events.setVisibility(contInvisible);
                quiz.setVisibility(contInvisible);
                contrMember.setVisibility(contVisible);
                contQuiz.setVisibility(contVisible);
                listView1.setVisibility(contVisible);
            }
        });
    }

    public void initList() {
        items = new String[]{"Детали"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_item1, R.id.txtitem, listItems);
        listView1.setAdapter(adapter);
    }

    public void searchItem(String textToSearch) {
        for (String item : items) {
            if (!item.contains(textToSearch)) {
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }
}