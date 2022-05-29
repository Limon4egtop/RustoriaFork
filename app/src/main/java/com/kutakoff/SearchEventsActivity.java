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

    //all && 11-20
    ListView[] centuries = new ListView[11];


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
        centuries[0] = findViewById(R.id.all);
        centuries[1] = findViewById(R.id.elevenCentury);
        centuries[2] = findViewById(R.id.twelveCentury);
        centuries[3] = findViewById(R.id.thirteenCentury);
        centuries[4] = findViewById(R.id.fourteenCentury);
        centuries[5] = findViewById(R.id.fifteenCentury);
        centuries[6] = findViewById(R.id.sixteenCentury);
        centuries[7] = findViewById(R.id.seventeenCentury);
        centuries[8] = findViewById(R.id.eighteenCentury);
        centuries[9] = findViewById(R.id.nineteenCentury);
        centuries[10] = findViewById(R.id.twentyCentury);
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

        fillArrayLists(listAll, listEleven, listTwelve, listThirteen, listFourteen, listFifteen, listSixteen, listSeventeen, listEighteen, listNineteen, listTwenty);
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

        for (ListView listView : centuries) {
            clickableList(listView);
        }

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.centuries, R.layout.spinner_text);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropbox_layout);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                visibilityListItems(position);
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
                "Любечский съезд", "Нюрмбергский процесс", "Сталинградская битва",
                "Поход Игоря Святославовича на половцев", "Судебник Ивана III", "Битва на Калке", "Битва под Галичем",
                "Невская битва", "Ледовое побоище", "Нашествие Батыя", "Долобский съезд", "Основание Москвы",
                "Киевский поход 1169 года", "Раковорская битва", "Битва на реке Сутени", "Салницкая битва",
                "Киевское восстание 1113 года", "Липицкая битва", "Междоусобная война в Северо-Восточной Руси (1281—1293)",
                "Нашествие Едигея", "Шелонская битва(входит в Московско-новгородскую войну)",
                "Московско-новгородская война (1471)", "Стояние на реке Угре", "Битва на реке Судоме",
                "Сражение при Листвене", "Битва на Нежатиной Ниве", "Битва на реке Суле", "Полоцкий поход Мстислава Великого (1127)",
                "Взятие Рязани Батыем", "Неврюева рать", "Оборона Киева 1240 года", "Тверское восстание 1327 года",
                "Сражение на реке Пьяне", "Нашествие Тохтамыша на Москву(1382)", "Московско-новгородская война (1477—1478)",
                "Битва на реке Ведрошь", "Ливонская война (1558-1583)", "Битва при Молодях", "Плюсское перемирие",
                "Восстание Болотникова", "Битва при Клушине", "Смоленская война", "Прутский поход", "Отечественная война (1812)",
                "Русско-персидская война (1826—1828)", "Битва при Лесной", "Полтавская битва", "Гангутское сражение",
                "Гренгамское сражение", "Битва на реке Альте", "Присоединение Коломны к Москве", "Соляной бунт",
                "Русско-турецкая война (1735-1739)", "Восстание Тадеуша Костюшко"));
        Collections.sort(all);

        elevenCentury.addAll(Arrays.asList("Любечский съезд", "Битва на реке Судоме", "Сражение при Листвене",
                "Битва на Нежатиной Ниве", "Битва на реке Альте"));
        Collections.sort(elevenCentury);

        twelveCentury.addAll(Arrays.asList("Поход Игоря Святославовича на половцев", "Долобский съезд",
                "Основание Москвы", "Киевский поход 1169 года", "Битва на реке Сутени", "Салницкая битва",
                "Киевское восстание 1113 года", "Битва на реке Суле", "Полоцкий поход Мстислава Великого (1127)"));
        Collections.sort(twelveCentury);

        thirteenCentury.addAll(Arrays.asList("Битва на Калке", "Невская битва", "Ледовое побоище", "Нашествие Батыя",
                "Раковорская битва", "Липицкая битва", "Междоусобная война в Северо-Восточной Руси (1281—1293)",
                "Взятие Рязани Батыем", "Неврюева рать", "Оборона Киева 1240 года"));
        Collections.sort(thirteenCentury);

        fourteenCentury.addAll(Arrays.asList("Куликовская битва", "Тверское восстание 1327 года",
                "Сражение на реке Пьяне", "Нашествие Тохтамыша на Москву(1382)", "Присоединение Коломны к Москве"));
        Collections.sort(fourteenCentury);

        fifteenCentury.addAll(Arrays.asList("Судебник Ивана III", "Битва под Галичем", "Нашествие Едигея",
                "Шелонская битва(входит в Московско-новгородскую войну)", "Московско-новгородская война (1471)",
                "Стояние на реке Угре", "Московско-новгородская война (1477—1478)"));
        Collections.sort(fifteenCentury);

        sixteenCentury.addAll(Arrays.asList("Смутное время", "Битва на реке Ведрошь", "Ливонская война (1558-1583)",
                "Битва при Молодях", "Плюсское перемирие"));
        Collections.sort(sixteenCentury);

        seventeenCentury.addAll(Arrays.asList("Вечный мир с Польшей", "Восстание Болотникова", "Битва при Клушине",
                "Смоленская война", "Соляной бунт"));
        Collections.sort(seventeenCentury);

        eighteenCentury.addAll(Arrays.asList("Северная война", "Прутский поход", "Битва при Лесной", "Полтавская битва",
                "Гангутское сражение", "Гренгамское сражение", "Русско-турецкая война (1735-1739)",
                "Восстание Тадеуша Костюшко"));
        Collections.sort(eighteenCentury);

        nineteenCentury.addAll(Arrays.asList("Битва при Красном", "Взятие Парижа", "Отмена крепостного права",
                "Отечественная война (1812)", "Русско-персидская война (1826—1828)"));
        Collections.sort(nineteenCentury);

        twentyCentury.addAll(Arrays.asList("Берлинская наступательная операция", "Брусиловский прорыв",
                "Гражданская война 1917-1922 гг.", "Курская битва", "Марш-бросок на Притштину",
                "Нюрмбергский процесс", "Распад СССР", "Расстрел царской семьи", "Сталинградская битва"));
        Collections.sort(twentyCentury);
    }

    private void visibilityListItems(int num) {
        for (int i = 0; i < centuries.length; i++) {
            if (i != num) {
                centuries[i].setVisibility(View.INVISIBLE);
            } else {
                centuries[num].setVisibility(View.VISIBLE);
            }
        }
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
        centuries[0].setAdapter(adapterAll);

        adapterEleven = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEleven);
        centuries[1].setAdapter(adapterEleven);

        adapterTwelve = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTwelve);
        centuries[2].setAdapter(adapterTwelve);

        adapterThirteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listThirteen);
        centuries[3].setAdapter(adapterThirteen);

        adapterFourteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listFourteen);
        centuries[4].setAdapter(adapterFourteen);

        adapterFifteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listFifteen);
        centuries[5].setAdapter(adapterFifteen);

        adapterSixteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSixteen);
        centuries[6].setAdapter(adapterSixteen);

        adapterSeventeen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSeventeen);
        centuries[7].setAdapter(adapterSeventeen);

        adapterEighteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEighteen);
        centuries[8].setAdapter(adapterEighteen);

        adapterNineteen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNineteen);
        centuries[9].setAdapter(adapterNineteen);

        adapterTwenty = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTwenty);
        centuries[10].setAdapter(adapterTwenty);
    }
}