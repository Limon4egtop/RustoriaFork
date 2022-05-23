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

public class TestActivity extends AppCompatActivity {

    ListView all;
    ListView elevenCentury;
    ListView fourteenCentury;
    ListView sixteenCentury;
    ListView seventeenCentury;
    ListView eighteenCentury;
    ListView nineteenCentury;
    ListView twentyCentury;
    ArrayAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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
        searchView = findViewById(R.id.searchView);
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

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAll);
        all.setAdapter(adapter);
        elevenCentury.setAdapter(adapter);
        fourteenCentury.setAdapter(adapter);
        sixteenCentury.setAdapter(adapter);
        seventeenCentury.setAdapter(adapter);
        eighteenCentury.setAdapter(adapter);
        nineteenCentury.setAdapter(adapter);
        twentyCentury.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
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

    private void fillArrayLists(ArrayList<String> all, ArrayList<String> elevenCentury, ArrayList<String> fourteenCentury, ArrayList<String> sixteenCentury, ArrayList<String> seventeenCentury, ArrayList<String> eighteenCentury, ArrayList<String> nineteenCentury, ArrayList<String> twentyCentury) {
        all.addAll(Arrays.asList("Куликовская битва", "Отмена крепостного права", "Гражданская война 1917-1922 гг.",
                "Курская битва", "Битва при Красном", "Холодная война", "Расстрел царской семьи",
                "Вечный мир с Польшей", "Распад СССР", "Брусиловский прорыв", "Северная война",
                "Взятие Парижа", "Марш-бросок на Притштину", "Смутное время", "Берлинская наступательная операция",
                "Любечский съезд", "Нюрмбергский процесс", "Сталинградская битва", "поход Игоря Святославовича на половцев"));
        elevenCentury.addAll(Arrays.asList("10", "11"));
        fourteenCentury.addAll(Arrays.asList("13", "14"));
        sixteenCentury.addAll(Arrays.asList("15", "16"));
        seventeenCentury.addAll(Arrays.asList("16", "17"));
        eighteenCentury.addAll(Arrays.asList("17", "18"));
        nineteenCentury.addAll(Arrays.asList("18", "19"));
        twentyCentury.addAll(Arrays.asList("19", "20"));
    }

    private void clickableList(ListView listView) {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String deyatel_name = (String) parent.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(TestActivity.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });
    }
}