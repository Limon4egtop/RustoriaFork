package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView all;
    ListView century;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.activity_search);
        all = findViewById(R.id.all);
        century = findViewById(R.id.century);
        editText = findViewById(R.id.txtsearch);
        initList();
        initListCentury();
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
        all.setOnItemClickListener((parent, view, position, id) -> {
            String deyatel_name = (String) parent.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(SearchActivity.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
            editText.setText(deyatel_name);
        });
        century.setOnItemClickListener((parent, view, position, id) -> {
            String deyatel_name = (String) parent.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(SearchActivity.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
            editText.setText(deyatel_name);
        });
        Spinner spinner = findViewById(R.id.chooseCentury);

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.deyatels_search, R.layout.spinner_text);
        adapter1.setDropDownViewResource(R.layout.spinner_dropbox_layout);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    all.setVisibility(View.INVISIBLE);
                    century.setVisibility(View.VISIBLE);
                } else {
                    all.setVisibility(View.VISIBLE);
                    century.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
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
        items = new String[]{"Иван Грозный", "Иван III", "Александр III", "Иван Фёдоров", "Георгий Жуков",
                "Иван I Калита", "Николай II", "Сергий Радонежский", "Лжедмитрий II", "Никита Хрущев",
                "Елизавета Петровна", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Нестор Летописец", "Даниил Московский", "Александр I", "Рюрик", "Олег Вещий",
                "Игорь Ририкович", "Ольга Мудрая", "Святослав Игоревич", "Ярополк Святославич",
                "Владимир Святой(Владимир красное солнышко)", "Святополк Окаянный", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Лжедмитрий I",
                "Василий IV", "Федор III", "Федор I", "Филарет", "Василий Голицын", "Ордин-Нащокин"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        all.setAdapter(adapter);
    }
    public void initListCentury() {
        items = new String[]{"Филарет", "Василий Голицын", "Ордин-Нащокин"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        century.setAdapter(adapter);
    }
}