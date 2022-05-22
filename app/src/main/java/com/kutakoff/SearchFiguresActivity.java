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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchFiguresActivity extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    EditText editText;
    ListView all;
    ListView elevenCentury;
    ListView fourteenCentury;
    ListView sixteenCentury;
    ListView seventeenCentury;
    ListView eighteenCentury;
    ListView nineteenCentury;
    ListView twentyCentury;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.activity_search_figures);
        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> onBackPressed());
        editText = findViewById(R.id.txtsearch);
        all = findViewById(R.id.all);
        elevenCentury = findViewById(R.id.elevenCentury);
        fourteenCentury = findViewById(R.id.fourteenCentury);
        sixteenCentury = findViewById(R.id.sixteenCentury);
        seventeenCentury = findViewById(R.id.seventeenCentury);
        eighteenCentury = findViewById(R.id.eighteenCentury);
        nineteenCentury = findViewById(R.id.nineteenCentury);
        twentyCentury = findViewById(R.id.twentyCentury);
        editText = findViewById(R.id.txtsearch);
        all();
        elevenCentury();
        fourteenCentury();
        sixteenCentury();
        seventeenCentury();
        eighteenCentury();
        nineteenCentury();
        twentyCentury();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    all();
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
            Intent intent = new Intent(SearchFiguresActivity.this, WebViewActivity.class);
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
                /**
                 * первый аргумент в методе visibilityListItem() - VISIBLE, остальные INVISIBLE
                 */
                switch (position) {
                    case 0:
                        visibilityListItems(all, elevenCentury, fourteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 1:
                        visibilityListItems(elevenCentury, all, fourteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 2:
                        visibilityListItems(fourteenCentury, all, elevenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 3:
                        visibilityListItems(sixteenCentury, all, elevenCentury, fourteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 4:
                        visibilityListItems(seventeenCentury, all, elevenCentury, fourteenCentury, sixteenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 5:
                        visibilityListItems(eighteenCentury, all, elevenCentury, fourteenCentury, sixteenCentury, seventeenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 6:
                        visibilityListItems(nineteenCentury, all, elevenCentury, fourteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, twentyCentury);
                        break;
                    case 7:
                        visibilityListItems(twentyCentury, all, elevenCentury, fourteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury);
                        break;
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

    public void all() {
        items = new String[]{"Иван Грозный", "Иван III", "Александр III", "Иван Фёдоров", "Георгий Жуков",
                "Иван I Калита", "Николай II", "Сергий Радонежский", "Лжедмитрий II", "Никита Хрущев",
                "Елизавета Петровна", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Нестор Летописец", "Даниил Московский", "Александр I", "Рюрик", "Олег Вещий",
                "Игорь Ририкович", "Ольга Мудрая", "Святослав Игоревич", "Ярополк Святославич",
                "Владимир Святой(Владимир красное солнышко)", "Святополк Окаянный", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Лжедмитрий I",
                "Василий IV", "Федор III", "Федор I", "Филарет", "Василий Голицын", "Ордин-Нащокин",
                "Михаил Шеин", "Дмитрий Пожарский", "Малюта Скуратов", "Григорий Отрепьев", "Борис Шереметев",
                "Владислав IV"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        all.setAdapter(adapter);
    }

    public void elevenCentury() {
        items = new String[]{"Любечский съезд"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        elevenCentury.setAdapter(adapter);
    }

    public void fourteenCentury() {
        items = new String[]{"Куликовская битва"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        fourteenCentury.setAdapter(adapter);
    }

    public void sixteenCentury() {
        items = new String[]{"Смутное время"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        sixteenCentury.setAdapter(adapter);
    }

    public void seventeenCentury() {
        items = new String[]{"Вечный мир с Польшей"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        seventeenCentury.setAdapter(adapter);
    }

    public void eighteenCentury() {
        items = new String[]{"Северная война"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        eighteenCentury.setAdapter(adapter);
    }

    public void nineteenCentury() {
        items = new String[]{"Битва при Красном", "Взятие Парижа", "Отмена крепостного права"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        nineteenCentury.setAdapter(adapter);
    }

    public void twentyCentury() {
        items = new String[]{"Берлинская наступательная операция", "Брусиловский прорыв",
                "Гражданская война 1917-1922 гг.", "Курская битва", "Марш-бросок на Притштину",
                "Нюрмбергский процесс", "Распад СССР", "Расстрел царской семьи", "Сталинградская битва"};
        Arrays.sort(items);
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, listItems);
        twentyCentury.setAdapter(adapter);
    }

    private void visibilityListItems(ListView listViewVISIBLE, ListView listView1, ListView listView2, ListView listView3, ListView listView4, ListView listView5, ListView listView6, ListView listView7) {
        listViewVISIBLE.setVisibility(View.VISIBLE);
        listView1.setVisibility(View.INVISIBLE);
        listView2.setVisibility(View.INVISIBLE);
        listView3.setVisibility(View.INVISIBLE);
        listView4.setVisibility(View.INVISIBLE);
        listView5.setVisibility(View.INVISIBLE);
        listView6.setVisibility(View.INVISIBLE);
        listView7.setVisibility(View.INVISIBLE);
    }
}