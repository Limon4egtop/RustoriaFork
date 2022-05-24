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

    ListView all;
    ListView elevenCentury;
    ListView fourteenCentury;
    ListView sixteenCentury;
    ListView seventeenCentury;
    ListView eighteenCentury;
    ListView nineteenCentury;
    ListView twentyCentury;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter adapterAll;
    ArrayAdapter adapterEleven;
    ArrayAdapter adapterFourteen;
    ArrayAdapter adapterSixteen;
    ArrayAdapter adapterSeventeen;
    ArrayAdapter adapterEighteen;
    ArrayAdapter adapterNineteen;
    ArrayAdapter adapterTwenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_figures);
        Button button = findViewById(R.id.button_back);
        Spinner spinner = findViewById(R.id.chooseCentury1);
        all = findViewById(R.id.all);
        elevenCentury = findViewById(R.id.elevenCentury);
        fourteenCentury = findViewById(R.id.fourteenCentury);
        sixteenCentury = findViewById(R.id.sixteenCentury);
        seventeenCentury = findViewById(R.id.seventeenCentury);
        eighteenCentury = findViewById(R.id.eighteenCentury);
        nineteenCentury = findViewById(R.id.nineteenCentury);
        twentyCentury = findViewById(R.id.twentyCentury);
        SearchView searchView = findViewById(R.id.searchView);

        button.setOnClickListener(v -> onBackPressed());

        ArrayList<String> listAll = new ArrayList<>();
        ArrayList<String> listEleven = new ArrayList<>();
        ArrayList<String> listFourteen = new ArrayList<>();
        ArrayList<String> listSixteen = new ArrayList<>();
        ArrayList<String> listSeventeen = new ArrayList<>();
        ArrayList<String> listEighteen = new ArrayList<>();
        ArrayList<String> listNineteen = new ArrayList<>();
        ArrayList<String> listTwenty = new ArrayList<>();

        fillArrayLists(listAll, listEleven, listFourteen, listSixteen, listSeventeen, listEighteen, listNineteen, listTwenty);
        fillAdapters(listAll, listEleven, listFourteen, listSixteen, listSeventeen, listEighteen, listNineteen, listTwenty);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterAll.getFilter().filter(newText);
                adapterEleven.getFilter().filter(newText);
                adapterFourteen.getFilter().filter(newText);
                adapterSixteen.getFilter().filter(newText);
                adapterSeventeen.getFilter().filter(newText);
                adapterEighteen.getFilter().filter(newText);
                adapterNineteen.getFilter().filter(newText);
                adapterTwenty.getFilter().filter(newText);
                return false;
            }
        });

        clickableList(all);
        clickableList(elevenCentury);
        clickableList(fourteenCentury);
        clickableList(sixteenCentury);
        clickableList(seventeenCentury);
        clickableList(eighteenCentury);
        clickableList(nineteenCentury);
        clickableList(twentyCentury);

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.centuries, R.layout.spinner_text);
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

    private void fillArrayLists(ArrayList<String> all, ArrayList<String> elevenCentury, ArrayList<String> fourteenCentury, ArrayList<String> sixteenCentury, ArrayList<String> seventeenCentury, ArrayList<String> eighteenCentury, ArrayList<String> nineteenCentury, ArrayList<String> twentyCentury) {
        all.addAll(Arrays.asList("Иван Грозный", "Иван III", "Александр III", "Иван Фёдоров", "Георгий Жуков",
                "Иван I Калита", "Николай II", "Сергий Радонежский", "Лжедмитрий II", "Никита Хрущев",
                "Елизавета Петровна", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Нестор Летописец", "Даниил Московский", "Александр I", "Рюрик", "Олег Вещий",
                "Игорь Ририкович", "Ольга Мудрая", "Святослав Игоревич", "Ярополк Святославич",
                "Владимир Святой(Владимир красное солнышко)", "Святополк Окаянный", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Лжедмитрий I",
                "Василий IV", "Федор III", "Федор I", "Филарет", "Василий Голицын", "Ордин-Нащокин",
                "Михаил Шеин", "Дмитрий Пожарский", "Малюта Скуратов", "Григорий Отрепьев", "Борис Шереметев",
                "Владислав IV"));
        Collections.sort(all);

        elevenCentury.addAll(Arrays.asList("Любечский съезд"));
        Collections.sort(elevenCentury);

        fourteenCentury.addAll(Arrays.asList("Куликовская битва"));
        Collections.sort(fourteenCentury);

        sixteenCentury.addAll(Arrays.asList("Смутное время"));
        Collections.sort(sixteenCentury);

        seventeenCentury.addAll(Arrays.asList("Вечный мир с Польшей"));
        Collections.sort(seventeenCentury);

        eighteenCentury.addAll(Arrays.asList("Северная война"));
        Collections.sort(eighteenCentury);

        nineteenCentury.addAll(Arrays.asList("Битва при Красном", "Взятие Парижа", "Отмена крепостного права"));
        Collections.sort(nineteenCentury);

        twentyCentury.addAll(Arrays.asList("Берлинская наступательная операция", "Брусиловский прорыв",
                "Гражданская война 1917-1922 гг.", "Курская битва", "Марш-бросок на Притштину",
                "Нюрмбергский процесс", "Распад СССР", "Расстрел царской семьи", "Сталинградская битва"));
        Collections.sort(twentyCentury);
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

    private void fillAdapters(ArrayList<String> listAll, ArrayList<String> listEleven, ArrayList<String> listFourteen, ArrayList<String> listSixteen, ArrayList<String> listSeventeen, ArrayList<String> listEighteen, ArrayList<String> listNineteen, ArrayList<String> listTwenty) {
        adapterAll = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAll);
        all.setAdapter(adapterAll);

        adapterEleven = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEleven);
        elevenCentury.setAdapter(adapterEleven);

        adapterFourteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listFourteen);
        fourteenCentury.setAdapter(adapterFourteen);

        adapterSixteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSixteen);
        sixteenCentury.setAdapter(adapterSixteen);

        adapterSeventeen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSeventeen);
        seventeenCentury.setAdapter(adapterSeventeen);

        adapterEighteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEighteen);
        eighteenCentury.setAdapter(adapterEighteen);

        adapterNineteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNineteen);
        nineteenCentury.setAdapter(adapterNineteen);

        adapterTwenty = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTwenty);
        twentyCentury.setAdapter(adapterTwenty);
    }
}