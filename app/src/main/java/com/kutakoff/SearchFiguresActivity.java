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
    ListView praviteli;
    ListView polkovodci;
    ListView duxovenstvo;
    ListView knyazia;
    ListView tvorchestvo;
    ListView diplomati;
    ListView samozvanci;
    ListView zaxvatchiki;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter adapterAll;
    ArrayAdapter adapterPraviteli;
    ArrayAdapter adapterPolkovodci;
    ArrayAdapter adapterDuxovenstvo;
    ArrayAdapter adapterKnyazia;
    ArrayAdapter adapterTvorchestvo;
    ArrayAdapter adapterDiplomati;
    ArrayAdapter adapterSamozvanci;
    ArrayAdapter adapterZaxvatchiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_figures);
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
        SearchView searchView = findViewById(R.id.searchView);

        button.setOnClickListener(v -> onBackPressed());

        ArrayList<String> listAll = new ArrayList<>();
        ArrayList<String> listPraviteli = new ArrayList<>();
        ArrayList<String> listPolkovodci = new ArrayList<>();
        ArrayList<String> listDuxovenstvo = new ArrayList<>();
        ArrayList<String> listKnyazia = new ArrayList<>();
        ArrayList<String> listTvorchestvo = new ArrayList<>();
        ArrayList<String> listDiplomati = new ArrayList<>();
        ArrayList<String> listSamozvanci = new ArrayList<>();
        ArrayList<String> listZaxvatchiki = new ArrayList<>();

        fillArrayLists(listAll, listPraviteli, listPolkovodci, listDuxovenstvo, listKnyazia, listTvorchestvo, listDiplomati, listSamozvanci, listZaxvatchiki);
        fillAdapters(listAll, listPraviteli, listPolkovodci, listDuxovenstvo, listKnyazia, listTvorchestvo, listDiplomati, listSamozvanci, listZaxvatchiki);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterAll.getFilter().filter(newText);
                adapterPraviteli.getFilter().filter(newText);
                adapterPolkovodci.getFilter().filter(newText);
                adapterDuxovenstvo.getFilter().filter(newText);
                adapterKnyazia.getFilter().filter(newText);
                adapterTvorchestvo.getFilter().filter(newText);
                adapterDiplomati.getFilter().filter(newText);
                adapterSamozvanci.getFilter().filter(newText);
                adapterZaxvatchiki.getFilter().filter(newText);
                return false;
            }
        });

        clickableList(all);
        clickableList(praviteli);
        clickableList(polkovodci);
        clickableList(duxovenstvo);
        clickableList(knyazia);
        clickableList(tvorchestvo);
        clickableList(diplomati);
        clickableList(samozvanci);
        clickableList(zaxvatchiki);

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
                        visibilityListItems(all, praviteli, polkovodci, duxovenstvo, knyazia, tvorchestvo, diplomati, samozvanci, zaxvatchiki);
                        break;
                    case 1:
                        visibilityListItems(praviteli, all, polkovodci, duxovenstvo, knyazia, tvorchestvo, diplomati, samozvanci, zaxvatchiki);
                        break;
                    case 2:
                        visibilityListItems(polkovodci, all, praviteli, duxovenstvo, knyazia, tvorchestvo, diplomati, samozvanci, zaxvatchiki);
                        break;
                    case 3:
                        visibilityListItems(duxovenstvo, all, praviteli, polkovodci, knyazia, tvorchestvo, diplomati, samozvanci, zaxvatchiki);
                        break;
                    case 4:
                        visibilityListItems(knyazia, all, praviteli, polkovodci, duxovenstvo, tvorchestvo, diplomati, samozvanci, zaxvatchiki);
                        break;
                    case 5:
                        visibilityListItems(tvorchestvo, all, praviteli, polkovodci, duxovenstvo, knyazia, diplomati, samozvanci, zaxvatchiki);
                        break;
                    case 6:
                        visibilityListItems(diplomati, all, praviteli, polkovodci, duxovenstvo, knyazia, tvorchestvo, samozvanci, zaxvatchiki);
                        break;
                    case 7:
                        visibilityListItems(samozvanci, all, praviteli, polkovodci, duxovenstvo, knyazia, tvorchestvo, diplomati, zaxvatchiki);
                        break;
                    case 8:
                        visibilityListItems(zaxvatchiki, samozvanci, all, praviteli, polkovodci, duxovenstvo, knyazia, tvorchestvo, diplomati);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void fillArrayLists(ArrayList<String> listAll, ArrayList<String> listPraviteli, ArrayList<String> listPolkovodci, ArrayList<String> listDuxovenstvo, ArrayList<String> listKnyazia, ArrayList<String> listTvorchestvo, ArrayList<String> listDiplomati, ArrayList<String> listSamozvanci, ArrayList<String> listZaxvatchiki) {
        listAll.addAll(Arrays.asList("Иван Грозный", "Иван III", "Александр III", "Иван Фёдоров", "Георгий Жуков",
                "Иван I Калита", "Николай II", "Сергий Радонежский", "Лжедмитрий II", "Никита Хрущев",
                "Елизавета Петровна", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Нестор Летописец", "Даниил Московский", "Александр I", "Рюрик", "Олег Вещий",
                "Игорь Ририкович", "Ольга Мудрая", "Святослав Игоревич", "Ярополк Святославич",
                "Владимир Святой(Владимир красное солнышко)", "Святополк Окаянный", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Лжедмитрий I",
                "Василий IV", "Федор III", "Федор I", "Филарет", "Василий Голицын", "Ордин-Нащокин",
                "Михаил Шеин", "Дмитрий Пожарский", "Малюта Скуратов", "Григорий Отрепьев", "Борис Шереметев",
                "Владислав IV", "Пётр II", "Пётр III"));
        Collections.sort(listAll);

        listPraviteli.addAll(Arrays.asList("Иван Грозный", "Иван III", "Александр III", "Иван I Калита", "Николай II",
                "Никита Хрущев", "Елизавета Петровна", "Александр I", "Рюрик", "Олег Вещий", "Игорь Ририкович",
                "Ольга Мудрая", "Святослав Игоревич", "Владимир Святой(Владимир красное солнышко)", "Пётр I",
                "Михаил Федорович", "Алексей Михайлович", "Борис Годунов", "Василий IV", "Федор III", "Федор I",
                "Пётр II", "Пётр III"));
        Collections.sort(listPraviteli);

        listPolkovodci.addAll(Arrays.asList("Георгий Жуков", "Александр Невский", "Дмитрий Донской", "Климент Ворошилов",
                "Михаил Шеин", "Дмитрий Пожарский", "Малюта Скуратов", "Борис Шереметев"));
        Collections.sort(listPolkovodci);

        listDuxovenstvo.addAll(Arrays.asList("Сергий Радонежский", "Нестор Летописец", "Филарет"));
        Collections.sort(listDuxovenstvo);

        listKnyazia.addAll(Arrays.asList("Александр Невский", "Дмитрий Донской", "Даниил Московский",
                "Ярополк Святославич", "Святополк Окаянный", "Дмитрий Пожарский"));
        Collections.sort(listKnyazia);

        listTvorchestvo.addAll(Arrays.asList("Иван Фёдоров", "Нестор Летописец"));
        Collections.sort(listTvorchestvo);

        listDiplomati.addAll(Arrays.asList("Ордин-Нащокин", "Борис Шереметев"));
        Collections.sort(listDiplomati);

        listSamozvanci.addAll(Arrays.asList("Лжедмитрий I", "Лжедмитрий II"));

        listZaxvatchiki.addAll(Arrays.asList("Владислав IV"));
        Collections.sort(listZaxvatchiki);
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

    private void fillAdapters(ArrayList<String> listAll, ArrayList<String> listPraviteli, ArrayList<String> listPolkovodci, ArrayList<String> listDuxovenstvo, ArrayList<String> listKnyazia, ArrayList<String> listTvorchestvo, ArrayList<String> listDiplomati, ArrayList<String> listSamozvanci, ArrayList<String> listZaxvatchiki) {
        adapterAll = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAll);
        all.setAdapter(adapterAll);

        adapterPraviteli = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listPraviteli);
        praviteli.setAdapter(adapterPraviteli);

        adapterPolkovodci = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listPolkovodci);
        polkovodci.setAdapter(adapterPolkovodci);

        adapterDuxovenstvo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listDuxovenstvo);
        duxovenstvo.setAdapter(adapterDuxovenstvo);

        adapterKnyazia = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listKnyazia);
        knyazia.setAdapter(adapterKnyazia);

        adapterTvorchestvo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTvorchestvo);
        tvorchestvo.setAdapter(adapterTvorchestvo);

        adapterDiplomati = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listDiplomati);
        diplomati.setAdapter(adapterDiplomati);

        adapterSamozvanci = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSamozvanci);
        samozvanci.setAdapter(adapterSamozvanci);

        adapterZaxvatchiki = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listZaxvatchiki);
        zaxvatchiki.setAdapter(adapterZaxvatchiki);
    }
}