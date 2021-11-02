package com.kutakoff;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import java.util.ArrayList;
        import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView = findViewById(R.id.listview);
        editText = findViewById(R.id.txtsearch);
        initList();

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    initList();
                } else {
                    searchItem(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String deyatel_name = (String) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", (String) parent.getItemAtPosition(position));
                Intent intent = new Intent(SearchActivity.this, WebViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent, bundle);
                editText.setText(deyatel_name);
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
        items=new String[]{"Иван Грозный","Иван III","Александр III Миротворец", "Иван Фёдоров", "Георгий Жуков", "Иван I Калита", "Николай II", "Сергий Радонежский", "Лжедмитрий II Тушинский вор", "Никита Хрущев", "Елизавета Петровна", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов", "Нестор Летописец", "Даниил Московский", "Алексaндр I", "Рюрик", "Олег Вещий", "Игорь Ририкович", "Ольга Мудрая", "Святослав Игоревич"};
        listItems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
    }
}