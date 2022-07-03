package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.utilitaryClasses.WebViewActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.utilitaryClasses.MainMethodsClass.*;

public class SearchFiguresActivity extends AppCompatActivity {

    ArrayAdapter spinnerAdapter;
    ArrayAdapter adapterAll, adapterPraviteli,
            adapterPolkovodci, adapterDuxovenstvo,
            adapterKnyazia, adapterTvorchestvo,
            adapterDiplomati, adapterSamozvanci,
            adapterZaxvatchiki;

    private static final ListView[] listViews = new ListView[9];

    private static final ArrayList[] arrayLists = new ArrayList[9];

    private static ArrayAdapter[] arrayAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_figures);
        SearchView searchView = findViewById(R.id.searchView);
        Button button_back = findViewById(R.id.button_back);
        Spinner spinner = findViewById(R.id.chooseFigure);

        listViews[0] = findViewById(R.id.all);         //все
        listViews[1] = findViewById(R.id.praviteli);   //правители
        listViews[2] = findViewById(R.id.polkovodci);  //полководцы
        listViews[3] = findViewById(R.id.duxovenstvo); //духовенство
        listViews[4] = findViewById(R.id.knyazia);     //князья
        listViews[5] = findViewById(R.id.tvorchestvo); //творчество
        listViews[6] = findViewById(R.id.diplomati);   //дипломаты
        listViews[7] = findViewById(R.id.samozvanci);  //самозванцы
        listViews[8] = findViewById(R.id.zaxvatchiki); //захватчики

        arrayLists[0] = new ArrayList<>(); //все
        arrayLists[1] = new ArrayList<>(); //правители
        arrayLists[2] = new ArrayList<>(); //полководцы
        arrayLists[3] = new ArrayList<>(); //духовенство
        arrayLists[4] = new ArrayList<>(); //князья
        arrayLists[5] = new ArrayList<>(); //творчество
        arrayLists[6] = new ArrayList<>(); //дипломаты
        arrayLists[7] = new ArrayList<>(); //самозванцы
        arrayLists[8] = new ArrayList<>(); //захватчики

        arrayAdapters = new ArrayAdapter[]{adapterAll, adapterPraviteli,
                adapterPolkovodci, adapterDuxovenstvo, adapterKnyazia,
                adapterTvorchestvo, adapterDiplomati, adapterSamozvanci,
                adapterZaxvatchiki};

        button_back.setOnClickListener(v -> startActivity(new Intent(SearchFiguresActivity.this, ChooseActivity.class)));

        fillArrayLists();
        fillAdapters();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                for (ArrayAdapter arrayAdapter : arrayAdapters) {
                    arrayAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });

        for (ListView listView : listViews) {
            clickableList(listView);
        }

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.figures, R.layout.spinner_text);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropbox_layout);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                visibilityListItems(listViews, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void fillArrayLists() {
        arrayLists[0].addAll(Arrays.asList("Иван Грозный", "Иван III", "Александр III", "Иван Фёдоров", "Георгий Жуков",
                "Иван I Калита", "Николай II", "Сергий Радонежский", "Лжедмитрий II", "Никита Хрущев",
                "Елизавета Петровна", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Нестор Летописец", "Даниил Московский", "Александр I", "Рюрик", "Олег Вещий",
                "Игорь Ририкович", "Ольга Мудрая", "Святослав Игоревич", "Ярополк Святославич",
                "Владимир Святой(Владимир красное солнышко)", "Святополк Окаянный", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Лжедмитрий I",
                "Василий IV", "Федор III", "Федор I", "Филарет", "Василий Голицын", "Ордин-Нащокин",
                "Михаил Шеин", "Дмитрий Пожарский", "Малюта Скуратов", "Григорий Отрепьев", "Борис Шереметев",
                "Владислав IV", "Пётр II", "Пётр III"));

        arrayLists[1].addAll(Arrays.asList("Иван Грозный", "Иван III", "Александр III", "Иван I Калита", "Николай II",
                "Никита Хрущев", "Елизавета Петровна", "Александр I", "Рюрик", "Олег Вещий", "Игорь Ририкович",
                "Ольга Мудрая", "Святослав Игоревич", "Владимир Святой(Владимир красное солнышко)", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Василий IV", "Федор III", "Федор I",
                "Пётр II", "Пётр III"));

        arrayLists[2].addAll(Arrays.asList("Георгий Жуков", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Михаил Шеин", "Дмитрий Пожарский", "Малюта Скуратов", "Борис Шереметев"));

        arrayLists[3].addAll(Arrays.asList("Сергий Радонежский", "Нестор Летописец", "Филарет"));

        arrayLists[4].addAll(Arrays.asList("Александр Невский", "Дмитрий Донской", "Даниил Московский",
                "Ярополк Святославич", "Святополк Окаянный", "Дмитрий Пожарский"));

        arrayLists[5].addAll(Arrays.asList("Иван Фёдоров", "Нестор Летописец"));

        arrayLists[6].addAll(Arrays.asList("Ордин-Нащокин", "Борис Шереметев"));

        arrayLists[7].addAll(Arrays.asList("Лжедмитрий I", "Лжедмитрий II"));

        arrayLists[8].addAll(Arrays.asList("Владислав IV"));

        for (ArrayList<String> arrayList : arrayLists) {
            Collections.sort(arrayList);
        }
    }

    private void clickableList(ListView listView) {
        /**
         * Метод для перехода в HTML
         */
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(SearchFiguresActivity.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });
    }

    private void fillAdapters() {
        for (int i = 0; i < arrayAdapters.length; i++) {
            arrayAdapters[i] = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayLists[i]);
            listViews[i].setAdapter(arrayAdapters[i]);
        }
    }
}