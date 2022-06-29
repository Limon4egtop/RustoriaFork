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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchFiguresActivity extends AppCompatActivity {

    ListView all, praviteli, polkovodci,
            duxovenstvo, knyazia, tvorchestvo,
            diplomati, samozvanci, zaxvatchiki;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter adapterAll, adapterPraviteli,
            adapterPolkovodci, adapterDuxovenstvo,
            adapterKnyazia, adapterTvorchestvo,
            adapterDiplomati, adapterSamozvanci,
            adapterZaxvatchiki;

    private static ListView[] listViews;

    private static ArrayList[] arrayLists;

    private static ArrayAdapter[] arrayAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_figures);
        SearchView searchView = findViewById(R.id.searchView);
        Button button = findViewById(R.id.button_back);
        Spinner spinner = findViewById(R.id.chooseFigure);

        all = findViewById(R.id.all);
        praviteli = findViewById(R.id.praviteli);
        polkovodci = findViewById(R.id.polkovodci);
        duxovenstvo = findViewById(R.id.duxovenstvo);
        knyazia = findViewById(R.id.knyazia);
        tvorchestvo = findViewById(R.id.tvorchestvo);
        diplomati = findViewById(R.id.diplomati);
        samozvanci = findViewById(R.id.samozvanci);
        zaxvatchiki = findViewById(R.id.zaxvatchiki);

        ArrayList<String> listAll = new ArrayList<>();
        ArrayList<String> listPraviteli = new ArrayList<>();
        ArrayList<String> listPolkovodci = new ArrayList<>();
        ArrayList<String> listDuxovenstvo = new ArrayList<>();
        ArrayList<String> listKnyazia = new ArrayList<>();
        ArrayList<String> listTvorchestvo = new ArrayList<>();
        ArrayList<String> listDiplomati = new ArrayList<>();
        ArrayList<String> listSamozvanci = new ArrayList<>();
        ArrayList<String> listZaxvatchiki = new ArrayList<>();

        listViews = new ListView[]{all, praviteli, polkovodci, duxovenstvo,
                knyazia, tvorchestvo, diplomati, samozvanci, zaxvatchiki};

        arrayLists = new ArrayList[]{listAll, listPraviteli, listPolkovodci,
                listDuxovenstvo, listKnyazia, listTvorchestvo, listDiplomati,
                listSamozvanci, listZaxvatchiki};

        arrayAdapters = new ArrayAdapter[]{adapterAll, adapterPraviteli,
                adapterPolkovodci, adapterDuxovenstvo, adapterKnyazia,
                adapterTvorchestvo, adapterDiplomati, adapterSamozvanci,
                adapterZaxvatchiki};

        button.setOnClickListener(v -> onBackPressed());

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
                /**
                 * первый аргумент в методе visibilityListItem() - VISIBLE, остальные INVISIBLE
                 */
                switch (position) {
                    case 0:
                        visibilityListItems(listViews[0], listViews[1], listViews[2], listViews[3], listViews[4], listViews[5], listViews[6], listViews[7], listViews[8]);
                        break;
                    case 1:
                        visibilityListItems(listViews[1], listViews[0], listViews[2], listViews[3], listViews[4], listViews[5], listViews[6], listViews[7], listViews[8]);
                        break;
                    case 2:
                        visibilityListItems(listViews[2], listViews[0], listViews[1], listViews[3], listViews[4], listViews[5], listViews[6], listViews[7], listViews[8]);
                        break;
                    case 3:
                        visibilityListItems(listViews[3], listViews[0], listViews[1], listViews[2], listViews[4], listViews[5], listViews[6], listViews[7], listViews[8]);
                        break;
                    case 4:
                        visibilityListItems(listViews[4], listViews[0], listViews[1], listViews[2], listViews[3], listViews[5], listViews[6], listViews[7], listViews[8]);
                        break;
                    case 5:
                        visibilityListItems(listViews[5], listViews[0], listViews[1], listViews[2], listViews[3], listViews[4], listViews[6], listViews[7], listViews[8]);
                        break;
                    case 6:
                        visibilityListItems(listViews[6], listViews[0], listViews[1], listViews[2], listViews[3], listViews[4], listViews[5], listViews[7], listViews[8]);
                        break;
                    case 7:
                        visibilityListItems(listViews[7], listViews[0], listViews[1], listViews[2], listViews[3], listViews[4], listViews[5], listViews[6], listViews[8]);
                        break;
                    case 8:
                        visibilityListItems(listViews[8], listViews[0], listViews[1], listViews[2], listViews[3], listViews[4], listViews[5], listViews[6], listViews[7]);
                }
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

    private void visibilityListItems(ListView listViewVISIBLE, ListView listView1, ListView listView2, ListView listView3, ListView listView4, ListView listView5, ListView listView6, ListView listView7, ListView listView8) {
        listViewVISIBLE.setVisibility(View.VISIBLE);
        listView1.setVisibility(View.INVISIBLE);
        listView2.setVisibility(View.INVISIBLE);
        listView3.setVisibility(View.INVISIBLE);
        listView4.setVisibility(View.INVISIBLE);
        listView5.setVisibility(View.INVISIBLE);
        listView6.setVisibility(View.INVISIBLE);
        listView7.setVisibility(View.INVISIBLE);
        listView8.setVisibility(View.INVISIBLE);
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