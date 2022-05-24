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

public class SearchEventsActivity extends AppCompatActivity {

    ListView all;
    ListView elevenCentury;
    ListView twelveCentury;
    ListView thirteenCentury;
    ListView fourteenCentury;
    ListView fifteenCentury;
    ListView sixteenCentury;
    ListView seventeenCentury;
    ListView eighteenCentury;
    ListView nineteenCentury;
    ListView twentyCentury;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter adapterAll;
    ArrayAdapter adapterEleven;
    ArrayAdapter adapterTwelve;
    ArrayAdapter adapterThirteen;
    ArrayAdapter adapterFourteen;
    ArrayAdapter adapterFifteen;
    ArrayAdapter adapterSixteen;
    ArrayAdapter adapterSeventeen;
    ArrayAdapter adapterEighteen;
    ArrayAdapter adapterNineteen;
    ArrayAdapter adapterTwenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);
        Button button = findViewById(R.id.button_back);
        Spinner spinner = findViewById(R.id.chooseCentury1);
        all = findViewById(R.id.all);
        elevenCentury = findViewById(R.id.elevenCentury);
        twelveCentury = findViewById(R.id.twelveCentury);
        thirteenCentury = findViewById(R.id.thirteenCentury);
        fourteenCentury = findViewById(R.id.fourteenCentury);
        fifteenCentury = findViewById(R.id.fifteenCentury);
        sixteenCentury = findViewById(R.id.sixteenCentury);
        seventeenCentury = findViewById(R.id.seventeenCentury);
        eighteenCentury = findViewById(R.id.eighteenCentury);
        nineteenCentury = findViewById(R.id.nineteenCentury);
        twentyCentury = findViewById(R.id.twentyCentury);
        SearchView searchView = findViewById(R.id.searchView);

        button.setOnClickListener(v -> onBackPressed());

        ArrayList<String> listAll = new ArrayList<>();
        ArrayList<String> listEleven = new ArrayList<>();
        ArrayList<String> listTwelve = new ArrayList<>();
        ArrayList<String> listThirteen = new ArrayList<>();
        ArrayList<String> listFourteen = new ArrayList<>();
        ArrayList<String> listFifteen = new ArrayList<>();
        ArrayList<String> listSixteen = new ArrayList<>();
        ArrayList<String> listSeventeen = new ArrayList<>();
        ArrayList<String> listEighteen = new ArrayList<>();
        ArrayList<String> listNineteen = new ArrayList<>();
        ArrayList<String> listTwenty = new ArrayList<>();

        fillArrayLists(listAll, listEleven, listTwelve, listThirteen,listFourteen, listFifteen, listSixteen, listSeventeen, listEighteen, listNineteen, listTwenty);
        fillAdapters(listAll, listEleven, listTwelve, listThirteen, listFourteen, listFifteen, listSixteen, listSeventeen, listEighteen, listNineteen, listTwenty);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterAll.getFilter().filter(newText);
                adapterEleven.getFilter().filter(newText);
                adapterTwelve.getFilter().filter(newText);
                adapterThirteen.getFilter().filter(newText);
                adapterFourteen.getFilter().filter(newText);
                adapterFifteen.getFilter().filter(newText);
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
        clickableList(twelveCentury);
        clickableList(thirteenCentury);
        clickableList(fourteenCentury);
        clickableList(fifteenCentury);
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
                        visibilityListItems(all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 1:
                        visibilityListItems(elevenCentury, all, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 2:
                        visibilityListItems(twelveCentury, all, elevenCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 3:
                        visibilityListItems(thirteenCentury, all, elevenCentury, twelveCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 4:
                        visibilityListItems(fourteenCentury, all, elevenCentury, twelveCentury, thirteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 5:
                        visibilityListItems(fifteenCentury, all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 6:
                        visibilityListItems(sixteenCentury, all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, seventeenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 7:
                        visibilityListItems(seventeenCentury, all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, eighteenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 8:
                        visibilityListItems(eighteenCentury, all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, nineteenCentury, twentyCentury);
                        break;
                    case 9:
                        visibilityListItems(nineteenCentury, all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, twentyCentury);
                        break;
                    case 10:
                        visibilityListItems(twentyCentury, all, elevenCentury, twelveCentury, thirteenCentury, fourteenCentury, fifteenCentury, sixteenCentury, seventeenCentury, eighteenCentury, nineteenCentury);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void fillArrayLists(ArrayList<String> all, ArrayList<String> elevenCentury, ArrayList<String> twelveCentury, ArrayList<String> thirteenCentury, ArrayList<String> fourteenCentury, ArrayList<String> fifteenCentury, ArrayList<String> sixteenCentury, ArrayList<String> seventeenCentury, ArrayList<String> eighteenCentury, ArrayList<String> nineteenCentury, ArrayList<String> twentyCentury) {
        all.addAll(Arrays.asList("Куликовская битва", "Отмена крепостного права", "Гражданская война 1917-1922 гг.",
                "Курская битва", "Битва при Красном", "Холодная война", "Расстрел царской семьи",
                "Вечный мир с Польшей", "Распад СССР", "Брусиловский прорыв", "Северная война",
                "Взятие Парижа", "Марш-бросок на Притштину", "Смутное время", "Берлинская наступательная операция",
                "Любечский съезд", "Нюрмбергский процесс", "Сталинградская битва", "поход Игоря Святославовича на половцев"));
        Collections.sort(all);

        elevenCentury.addAll(Arrays.asList("Любечский съезд"));
        Collections.sort(elevenCentury);

        twelveCentury.addAll(Arrays.asList("поход Игоря Святославовича на половцев"));
        Collections.sort(twelveCentury);

        thirteenCentury.addAll(Arrays.asList("здесь события 13 века"));
        Collections.sort(thirteenCentury);

        fourteenCentury.addAll(Arrays.asList("Куликовская битва"));
        Collections.sort(fourteenCentury);

        fifteenCentury.addAll(Arrays.asList("здесь события 15 века"));
        Collections.sort(fifteenCentury);

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

    private void visibilityListItems(ListView listViewVISIBLE, ListView listView1, ListView listView2, ListView listView3, ListView listView4, ListView listView5, ListView listView6, ListView listView7, ListView listView8, ListView listView9, ListView listView10) {
        listViewVISIBLE.setVisibility(View.VISIBLE);
        listView1.setVisibility(View.INVISIBLE);
        listView2.setVisibility(View.INVISIBLE);
        listView3.setVisibility(View.INVISIBLE);
        listView4.setVisibility(View.INVISIBLE);
        listView5.setVisibility(View.INVISIBLE);
        listView6.setVisibility(View.INVISIBLE);
        listView7.setVisibility(View.INVISIBLE);
        listView8.setVisibility(View.INVISIBLE);
        listView9.setVisibility(View.INVISIBLE);
        listView10.setVisibility(View.INVISIBLE);
    }

    private void clickableList(ListView listView) {
        /**
         * Метод для перехода в HTML
         */
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(SearchEventsActivity.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });
    }

    private void fillAdapters(ArrayList<String> listAll, ArrayList<String> listEleven, ArrayList<String> listTwelve, ArrayList<String> listThirteen, ArrayList<String> listFourteen, ArrayList<String> listFifteen, ArrayList<String> listSixteen, ArrayList<String> listSeventeen, ArrayList<String> listEighteen, ArrayList<String> listNineteen, ArrayList<String> listTwenty) {
        adapterAll = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAll);
        all.setAdapter(adapterAll);

        adapterEleven = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEleven);
        elevenCentury.setAdapter(adapterEleven);

        adapterTwelve = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTwelve);
        twelveCentury.setAdapter(adapterTwelve);

        adapterThirteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listThirteen);
        thirteenCentury.setAdapter(adapterThirteen);

        adapterFourteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listFourteen);
        fourteenCentury.setAdapter(adapterFourteen);

        adapterFifteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listFifteen);
        fifteenCentury.setAdapter(adapterFifteen);

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