package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainCommanders extends AppCompatActivity {
    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_commanders);
        listView = findViewById(R.id.listview);
        ImageView button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String deyatel_name = (String) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", (String) parent.getItemAtPosition(position));
                Intent intent = new Intent(MainCommanders.this, WebViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent, bundle);
            }
        });
    }

    public void searchItem(String textToSearch){
        for(String item:items){
            if(!item.contains(textToSearch)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList(){
        items=new String[]{"Ген. Георгий Жуков", "Павел Артемьев", "Семён Буденный"};
        listItems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this, R.layout.list_item2, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
    }

}