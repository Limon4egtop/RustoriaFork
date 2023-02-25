package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.utilitaryClasses.MainMethodsClass;
import com.utilitaryClasses.WebViewActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.utilitaryClasses.MainMethodsClass.visibilityListItems;

public class Events extends AppCompatActivity {

    ArrayAdapter spinnerAdapter;
    ArrayAdapter adapterAll, adapterEleven, adapterTwelve,
            adapterThirteen, adapterFourteen, adapterFifteen,
            adapterSixteen, adapterSeventeen, adapterEighteen,
            adapterNineteen, adapterTwenty;

    private static final ListView[] centuries = new ListView[11]; //all && 11-20

    private static final ArrayList[] arrayLists = new ArrayList[11];

    private static ArrayAdapter[] arrayAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        /**
         * Переключение на квизы|события|деятели
         */
        CardView quizzes = findViewById(R.id.quizzes);
        quizzes.setOnClickListener(v -> startActivity(new Intent(Events.this, Quizzes.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));
        ImageView quizzesImage = findViewById(R.id.quizzesImage);

        CardView events = findViewById(R.id.events);
        ImageView eventsImage = findViewById(R.id.eventsImage);

        CardView deyatels = findViewById(R.id.deyatels);
        deyatels.setOnClickListener(v -> startActivity(new Intent(Events.this, Deyatels.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));
        ImageView deyatelsImage = findViewById(R.id.deyatelsImage);

        CardView[] bottomCardViews = {quizzes, events, deyatels};
        ImageView[] bottomImageViews = {quizzesImage, eventsImage, deyatelsImage};
        for (int i = 0; i < bottomCardViews.length; i++) {
            MainMethodsClass.setBottomCardAndImageViewViewSize(displayMetrics, bottomCardViews[i], bottomImageViews[i]);
        }

        Spinner spinner = findViewById(R.id.chooseCentury);

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

        arrayLists[0] = new ArrayList<>(); //все
        arrayLists[1] = new ArrayList<>(); //11
        arrayLists[2] = new ArrayList<>(); //12
        arrayLists[3] = new ArrayList<>(); //13
        arrayLists[4] = new ArrayList<>(); //14
        arrayLists[5] = new ArrayList<>(); //15
        arrayLists[6] = new ArrayList<>(); //16
        arrayLists[7] = new ArrayList<>(); //17
        arrayLists[8] = new ArrayList<>(); //18
        arrayLists[9] = new ArrayList<>(); //19
        arrayLists[10] = new ArrayList<>(); //20

        arrayAdapters = new ArrayAdapter[]{adapterAll, adapterEleven, adapterTwelve,
                adapterThirteen, adapterFourteen, adapterFifteen,
                adapterSixteen, adapterSeventeen, adapterEighteen,
                adapterNineteen, adapterTwenty};

        SearchView searchView = findViewById(R.id.searchView);

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
                visibilityListItems(centuries, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void fillArrayLists() {
        arrayLists[0].addAll(Arrays.asList("Куликовская битва", "Отмена крепостного права", "Гражданская война 1917-1922 гг.",
                "Курская битва", "Битва при Красном", "Холодная война", "Расстрел царской семьи",
                "Вечный мир с Польшей", "Распад СССР", "Брусиловский прорыв", "Северная война",
                "Взятие Парижа", "Марш-бросок на Притштину", "Смутное время", "Берлинская наступательная операция",
                "Любечский съезд", "Нюрмбергский процесс", "Сталинградская битва",
                "Поход Игоря Святославовича на половцев", "Судебник Ивана III", "Битва на Калке", "Битва под Галичем",
                "Невская битва", "Ледовое побоище", "Нашествие Батыя", "Долобский съезд", "Основание Москвы",
                "Киевский поход 1169 года", "Раковорская битва", "Битва на реке Сутени", "Салницкая битва",
                "Киевское восстание 1113 года", "Липицкая битва", "Междоусобная война в Северо-Восточной Руси (1281—1293)",
                "Нашествие Едигея", "Шелонская битва", "Московско-новгородская война (1471)", "Стояние на реке Угре",
                "Битва на реке Судоме", "Сражение при Листвене", "Битва на Нежатиной Ниве", "Битва на реке Суле",
                "Полоцкий поход Мстислава Великого (1127)", "Взятие Рязани Батыем", "Неврюева рать", "Оборона Киева 1240 года",
                "Тверское восстание 1327 года", "Сражение на реке Пьяне", "Нашествие Тохтамыша на Москву(1382)",
                "Московско-новгородская война (1477—1478)", "Битва на реке Ведрошь", "Ливонская война (1558-1583)",
                "Битва при Молодях", "Плюсское перемирие", "Восстание Болотникова", "Битва при Клушине", "Смоленская война",
                "Прутский поход", "Отечественная война (1812)", "Русско-персидская война (1826—1828)", "Битва при Лесной",
                "Полтавская битва", "Гангутское сражение", "Гренгамское сражение", "Битва на реке Альте",
                "Присоединение Коломны к Москве", "Соляной бунт", "Русско-турецкая война (1735-1739)",
                "Восстание Тадеуша Костюшко", "Русско-византийская война (1043)", "Новгородское восстание (1136)",
                "Битва на реке Сити", "Убийство московского князя Юрия Даниловича", "Судебник Ивана IV",
                "Русско-турецкая война (1672—1681)", "Война за польское наследство", "Восстание декабристов",
                "Советско-японская война", "Бородинское сражение", "Изборник 1073 года", "Новгородский погром",
                "Польское восстание (1830-1831)", "Крымская война"));

        arrayLists[1].addAll(Arrays.asList("Любечский съезд", "Битва на реке Судоме", "Сражение при Листвене",
                "Битва на Нежатиной Ниве", "Битва на реке Альте", "Русско-византийская война (1043)",
                "Изборник 1073 года"));

        arrayLists[2].addAll(Arrays.asList("Поход Игоря Святославовича на половцев", "Долобский съезд",
                "Основание Москвы", "Киевский поход 1169 года", "Битва на реке Сутени", "Салницкая битва",
                "Киевское восстание 1113 года", "Битва на реке Суле", "Полоцкий поход Мстислава Великого (1127)",
                "Новгородское восстание (1136)"));

        arrayLists[3].addAll(Arrays.asList("Битва на Калке", "Невская битва", "Ледовое побоище", "Нашествие Батыя",
                "Раковорская битва", "Липицкая битва", "Междоусобная война в Северо-Восточной Руси (1281—1293)",
                "Взятие Рязани Батыем", "Неврюева рать", "Оборона Киева 1240 года", "Битва на реке Сити"));

        arrayLists[4].addAll(Arrays.asList("Куликовская битва", "Тверское восстание 1327 года",
                "Сражение на реке Пьяне", "Нашествие Тохтамыша на Москву(1382)", "Присоединение Коломны к Москве",
                "Убийство московского князя Юрия Даниловича"));

        arrayLists[5].addAll(Arrays.asList("Судебник Ивана III", "Битва под Галичем", "Нашествие Едигея",
                "Шелонская битва(входит в Московско-новгородскую войну)", "Московско-новгородская война (1471)",
                "Стояние на реке Угре", "Московско-новгородская война (1477—1478)"));

        arrayLists[6].addAll(Arrays.asList("Смутное время", "Битва на реке Ведрошь", "Ливонская война (1558-1583)",
                "Битва при Молодях", "Плюсское перемирие", "Судебник Ивана IV", "Новгородский погром"));

        arrayLists[7].addAll(Arrays.asList("Вечный мир с Польшей", "Восстание Болотникова", "Битва при Клушине",
                "Смоленская война", "Соляной бунт", "Русско-турецкая война (1672—1681)"));

        arrayLists[8].addAll(Arrays.asList("Северная война", "Прутский поход", "Битва при Лесной", "Полтавская битва",
                "Гангутское сражение", "Гренгамское сражение", "Русско-турецкая война (1735-1739)",
                "Восстание Тадеуша Костюшко", "Война за польское наследство"));

        arrayLists[9].addAll(Arrays.asList("Битва при Красном", "Взятие Парижа", "Отмена крепостного права",
                "Отечественная война (1812)", "Русско-персидская война (1826—1828)", "Восстание декабристов",
                "Бородинское сражение", "Польское восстание (1830-1831)", "Крымская война"));

        arrayLists[10].addAll(Arrays.asList("Берлинская наступательная операция", "Брусиловский прорыв",
                "Гражданская война 1917-1922 гг.", "Курская битва", "Марш-бросок на Притштину",
                "Нюрмбергский процесс", "Распад СССР", "Расстрел царской семьи", "Сталинградская битва",
                "Советско-японская война"));

        for (ArrayList arrayList : arrayLists) {
            Collections.sort(arrayList);
        }
    }

    private void clickableList(ListView listView) {
        /*
          Метод для перехода в HTML
         */
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(Events.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });
    }

    private void fillAdapters() {
        for (int i = 0; i < arrayAdapters.length; i++) {
            arrayAdapters[i] = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayLists[i]);
            centuries[i].setAdapter(arrayAdapters[i]);
        }
    }
}