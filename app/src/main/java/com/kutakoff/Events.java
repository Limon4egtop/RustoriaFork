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

import static com.utilitaryClasses.MainMethodsClass.visibilityListItems;

public class Events extends AppCompatActivity {

    private static final ListView[] centuries = new ListView[11]; //all && 11-20
    private final String[][] entriesList = new String[centuries.length][];

    private static ArrayAdapter[] arrayAdapters;
    ArrayAdapter spinnerAdapter, adapterAll, adapterEleven, adapterTwelve,
    adapterThirteen, adapterFourteen, adapterFifteen,
    adapterSixteen, adapterSeventeen, adapterEighteen,
    adapterNineteen, adapterTwenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        /**
         * Переключение на квизы|события|деятели
         */
        CardView quizzes = findViewById(R.id.quizzes);
        ImageView quizzesImage = findViewById(R.id.quizzesImage);

        CardView events = findViewById(R.id.events);
        ImageView eventsImage = findViewById(R.id.eventsImage);

        CardView deyatels = findViewById(R.id.deyatels);
        ImageView deyatelsImage = findViewById(R.id.deyatelsImage);

        quizzes.setOnClickListener(v -> startActivity(new Intent(Events.this, Quizzes.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));
        deyatels.setOnClickListener(v -> startActivity(new Intent(Events.this, Deyatels.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        CardView[] bottomCardViews = {quizzes, events, deyatels};
        ImageView[] bottomImageViews = {quizzesImage, eventsImage, deyatelsImage};
        for (int i = 0; i < bottomCardViews.length; i++) {
            MainMethodsClass.setBottomPanelSize(displayMetrics, bottomCardViews[i], bottomImageViews[i]);
        }

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

        entriesList[0] = getResources().getStringArray(R.array.allEvents);
        entriesList[1] = getResources().getStringArray(R.array.century11);
        entriesList[2] = getResources().getStringArray(R.array.century12);
        entriesList[3] = getResources().getStringArray(R.array.century13);
        entriesList[4] = getResources().getStringArray(R.array.century14);
        entriesList[5] = getResources().getStringArray(R.array.century15);
        entriesList[6] = getResources().getStringArray(R.array.century16);
        entriesList[7] = getResources().getStringArray(R.array.century17);
        entriesList[8] = getResources().getStringArray(R.array.century18);
        entriesList[9] = getResources().getStringArray(R.array.century19);
        entriesList[10] = getResources().getStringArray(R.array.century20);

        arrayAdapters = new ArrayAdapter[]{adapterAll, adapterEleven, adapterTwelve,
                adapterThirteen, adapterFourteen, adapterFifteen,
                adapterSixteen, adapterSeventeen, adapterEighteen,
                adapterNineteen, adapterTwenty};

        fillAdapters();

        SearchView searchView = findViewById(R.id.searchView);
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

        Spinner spinner = findViewById(R.id.chooseCentury);
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
        for (int i = 0; i < entriesList.length; i++) {
            arrayAdapters[i] = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, entriesList[i]);
            centuries[i].setAdapter(arrayAdapters[i]);
        }
    }
}