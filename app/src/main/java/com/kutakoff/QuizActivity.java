package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.quizes.krim.*;
import com.quizes.main.*;
import com.quizes.petr1.*;
import com.quizes.staliningradskayaBitva.*;

public class QuizActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static ImageView
            main_easy, main_medium, main_hard,
            second_february_start, krim_easy,
            krim_medium, krim_hard, mainBq,
            poltavskaya_bitva, grengamskoe_srajenie,
            gangutskoe_srajenie, bitva_pri_lesnoy,
            petr1Bq;
    public static TextView main_text, petr_1_text, petr_1_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView button_back = findViewById(R.id.button_back);
        mainBq = findViewById(R.id.mainBq);
        petr1Bq = findViewById(R.id.Petr1Bq);
        main_text = findViewById(R.id.main_text);
        petr_1_text = findViewById(R.id.petr_1_text);
        petr_1_text2 = findViewById(R.id.petr_1_text2);

        /**
         * Объявление квизов
         */
        main_easy = findViewById(R.id.main_easy);
        main_medium = findViewById(R.id.main_medium);
        main_hard = findViewById(R.id.main_hard);

        second_february_start = findViewById(R.id.second_february_start);

        krim_easy = findViewById(R.id.krim_easy);
        krim_medium = findViewById(R.id.krim_medium);
        krim_hard = findViewById(R.id.krim_hard);

        poltavskaya_bitva = findViewById(R.id.poltavskaya_bitva);
        grengamskoe_srajenie = findViewById(R.id.grengamskoe_srajenie);
        gangutskoe_srajenie = findViewById(R.id.gangutskoe_srajenie);
        bitva_pri_lesnoy = findViewById(R.id.bitva_pri_lesnoy);

        button_back.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, ChooseActivity.class)));

        main_easy.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, MainEasyQuizActivity.class)));
        main_medium.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, MainMediumQuizActivity.class)));
        main_hard.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, MainHardQuizActivity.class)));

        second_february_start.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, StalingradskayaBitvaQuizActivity.class)));

        krim_easy.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, KrimEasyQuizActivity.class)));
        krim_medium.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, KrimMediumQuizActivity.class)));
        krim_hard.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, KrimHardQuizActivity.class)));

        bitva_pri_lesnoy.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, BitvaPriLesnoyQuizActivity.class)));
        poltavskaya_bitva.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, PoltavskayaBitvaQuizActivity.class)));
        gangutskoe_srajenie.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, GangutskoeSrajenieQuizActivity.class)));
        grengamskoe_srajenie.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, GrengamskoeSrajenieQuizActivity.class)));

        Spinner spinner = findViewById(R.id.chooseQuiz);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.quizNames, R.layout.spinner_text);
        adapter.setDropDownViewResource(R.layout.spinner_dropbox_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        switch (position) {
            case 0:
                visibilityList(View.VISIBLE, View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
                break;
            case 1:
                visibilityList(View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                break;
            case 2:
                visibilityList(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                break;
            case 3:
                visibilityList(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private static void visibilityList(int generalTextVisible, int generalBqVisible, int mainVisible, int stalVisible, int krimVisible, int petr1Visible) {
        main_easy.setVisibility(mainVisible);
        main_medium.setVisibility(mainVisible);
        main_hard.setVisibility(mainVisible);

        second_february_start.setVisibility(stalVisible);

        krim_easy.setVisibility(krimVisible);
        krim_medium.setVisibility(krimVisible);
        krim_hard.setVisibility(krimVisible);

        petr1Bq.setVisibility(petr1Visible);
        petr1Bq.setVisibility(petr1Visible);
        gangutskoe_srajenie.setVisibility(petr1Visible);
        poltavskaya_bitva.setVisibility(petr1Visible);
        grengamskoe_srajenie.setVisibility(petr1Visible);
        bitva_pri_lesnoy.setVisibility(petr1Visible);
        petr_1_text.setVisibility(petr1Visible);
        petr_1_text2.setVisibility(petr1Visible);

        main_text.setVisibility(generalTextVisible);
        mainBq.setVisibility(generalBqVisible);
    }
}