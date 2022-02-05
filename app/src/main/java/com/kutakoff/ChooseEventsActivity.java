package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class ChooseEventsActivity extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_choose_events);
        listView = findViewById(R.id.listview);
        editText = findViewById(R.id.txtsearch);
        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    initList();
                } else {
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String deyatel_name = (String) parent.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(ChooseEventsActivity.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
            editText.setText(deyatel_name);
        });
    }

    public void searchItem(String textToSearch) {
        for (String item : items) {
            if (!item.contains(textToSearch)) {
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList() {
        items = new String[]{"Куликовская битва", "Отмена крепостного права", "Гражданская война 1917-1922 гг.",
                "Курская битва", "Битва при Красном", "Холодная война", "Расстрел царской семьи",
                "Вечный мир с Польшей", "Распад СССР", "Брусиловский прорыв", "Северная война",
                "Взятие Парижа", "Марш-бросок на Притштину", "Смутное время", "Берлинская наступательная операция",
                "Любечский съезд", "Нюрмбергский процесс"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
    }
}