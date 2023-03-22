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

public class Deyatels extends AppCompatActivity {

    private static final ListView[] listViews = new ListView[10];
    private final String[][] entriesList = new String[listViews.length][];

    private static ArrayAdapter[] arrayAdapters;
    ArrayAdapter spinnerAdapter, adapterAll, adapterPraviteli,
            adapterPolkovodci, adapterDuxovenstvo,
            adapterKnyazia, adapterIskusstvo,
            adapterDiplomati, adapterSamozvanci,
            adapterZaxvatchiki, adapterHeroOfSVO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deyatels);

        /**
         * Переключение на квизы|события|деятели
         */
        CardView quizzes = findViewById(R.id.quizzes);
        ImageView quizzesImage = findViewById(R.id.quizzesImage);

        CardView events = findViewById(R.id.events);
        ImageView eventsImage = findViewById(R.id.eventsImage);

        CardView deyatels = findViewById(R.id.deyatels);
        ImageView deyatelsImage = findViewById(R.id.deyatelsImage);

        quizzes.setOnClickListener(v -> startActivity(new Intent(Deyatels.this, Quizzes.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));
        events.setOnClickListener(v -> startActivity(new Intent(Deyatels.this, Events.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        CardView[] bottomCardViews = {quizzes, events, deyatels};
        ImageView[] bottomImageViews = {quizzesImage, eventsImage, deyatelsImage};
        for (int i = 0; i < bottomCardViews.length; i++) {
            MainMethodsClass.setBottomPanelSize(displayMetrics, bottomCardViews[i], bottomImageViews[i]);
        }

        listViews[0] = findViewById(R.id.all);         //все
        listViews[1] = findViewById(R.id.praviteli);   //правители
        listViews[2] = findViewById(R.id.polkovodci);  //полководцы
        listViews[3] = findViewById(R.id.duxovenstvo); //духовенство
        listViews[4] = findViewById(R.id.knyazia);     //князья
        listViews[5] = findViewById(R.id.tvorchestvo); //искусство
        listViews[6] = findViewById(R.id.diplomati);   //дипломаты
        listViews[7] = findViewById(R.id.samozvanci);  //самозванцы
        listViews[8] = findViewById(R.id.zaxvatchiki); //захватчики
        listViews[9] = findViewById(R.id.heroOfSvo); //захватчики

        entriesList[0] = getResources().getStringArray(R.array.allDeyatels);
        entriesList[1] = getResources().getStringArray(R.array.praviteli);
        entriesList[2] = getResources().getStringArray(R.array.polkovodci);
        entriesList[3] = getResources().getStringArray(R.array.duxovenstvo);
        entriesList[4] = getResources().getStringArray(R.array.knyazia);
        entriesList[5] = getResources().getStringArray(R.array.iskusstvo);
        entriesList[6] = getResources().getStringArray(R.array.diplomati);
        entriesList[7] = getResources().getStringArray(R.array.samozvanci);
        entriesList[8] = getResources().getStringArray(R.array.zaxvatchiki);
        entriesList[9] = getResources().getStringArray(R.array.hero_of_SVO);

        arrayAdapters = new ArrayAdapter[]{adapterAll, adapterPraviteli,
                adapterPolkovodci, adapterDuxovenstvo, adapterKnyazia,
                adapterIskusstvo, adapterDiplomati, adapterSamozvanci,
                adapterZaxvatchiki, adapterHeroOfSVO};

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

        for (ListView listView : listViews) {
            clickableList(listView);
        }

        Spinner spinner = findViewById(R.id.chooseFigure);
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

    private void clickableList(ListView listView) {
        /*
          Метод для перехода в HTML
         */
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(Deyatels.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });
    }

    private void fillAdapters() {
        for (int i = 0; i < entriesList.length; i++) {
            arrayAdapters[i] = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, entriesList[i]);
            listViews[i].setAdapter(arrayAdapters[i]);
        }
    }
}