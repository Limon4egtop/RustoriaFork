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

public class QuizActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView
            main_easy, main_medium, main_hard,
            second_february_start, krim_easy,
            krim_medium, krim_hard, mainBq,
            poltavskaya_bitva, grengamskoe_srajenie,
            gangutskoe_srajenie, bitva_pri_lesnoy,
            petr1Bq;
    TextView chooseQuizText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        ImageView button_back = findViewById(R.id.button_back);
        mainBq = findViewById(R.id.mainBq);
        petr1Bq = findViewById(R.id.Petr1Bq);
        chooseQuizText = findViewById(R.id.chooseQuizText);

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

        Spinner spinner = findViewById(R.id.chooseQuiz);

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.quizNames, R.layout.spinner_text);
        adapter.setDropDownViewResource(R.layout.spinner_dropbox_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button_back.setOnClickListener(v -> onBackPressed());
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
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        switch (position) {
            case 0:
                main_easy.setVisibility(View.VISIBLE);
                main_medium.setVisibility(View.VISIBLE);
                main_hard.setVisibility(View.VISIBLE);

                second_february_start.setVisibility(View.INVISIBLE);

                krim_easy.setVisibility(View.INVISIBLE);
                krim_medium.setVisibility(View.INVISIBLE);
                krim_hard.setVisibility(View.INVISIBLE);

                mainBq.setVisibility(View.VISIBLE);

                petr1Bq.setVisibility(View.INVISIBLE);
                petr1Bq.setVisibility(View.INVISIBLE);
                gangutskoe_srajenie.setVisibility(View.INVISIBLE);
                poltavskaya_bitva.setVisibility(View.INVISIBLE);
                grengamskoe_srajenie.setVisibility(View.INVISIBLE);
                bitva_pri_lesnoy.setVisibility(View.INVISIBLE);
                break;
            case 1:
                main_easy.setVisibility(View.INVISIBLE);
                main_medium.setVisibility(View.INVISIBLE);
                main_hard.setVisibility(View.INVISIBLE);

                second_february_start.setVisibility(View.VISIBLE);

                krim_easy.setVisibility(View.INVISIBLE);
                krim_medium.setVisibility(View.INVISIBLE);
                krim_hard.setVisibility(View.INVISIBLE);

                mainBq.setVisibility(View.VISIBLE);

                petr1Bq.setVisibility(View.INVISIBLE);
                petr1Bq.setVisibility(View.INVISIBLE);
                gangutskoe_srajenie.setVisibility(View.INVISIBLE);
                poltavskaya_bitva.setVisibility(View.INVISIBLE);
                grengamskoe_srajenie.setVisibility(View.INVISIBLE);
                bitva_pri_lesnoy.setVisibility(View.INVISIBLE);
                break;
            case 2:
                main_easy.setVisibility(View.INVISIBLE);
                main_medium.setVisibility(View.INVISIBLE);
                main_hard.setVisibility(View.INVISIBLE);

                second_february_start.setVisibility(View.INVISIBLE);

                krim_easy.setVisibility(View.VISIBLE);
                krim_medium.setVisibility(View.VISIBLE);
                krim_hard.setVisibility(View.VISIBLE);

                mainBq.setVisibility(View.VISIBLE);

                petr1Bq.setVisibility(View.INVISIBLE);
                gangutskoe_srajenie.setVisibility(View.INVISIBLE);
                poltavskaya_bitva.setVisibility(View.INVISIBLE);
                grengamskoe_srajenie.setVisibility(View.INVISIBLE);
                bitva_pri_lesnoy.setVisibility(View.INVISIBLE);
                break;
            case 3:
                main_easy.setVisibility(View.INVISIBLE);
                main_medium.setVisibility(View.INVISIBLE);
                main_hard.setVisibility(View.INVISIBLE);

                second_february_start.setVisibility(View.INVISIBLE);

                krim_easy.setVisibility(View.INVISIBLE);
                krim_medium.setVisibility(View.INVISIBLE);
                krim_hard.setVisibility(View.INVISIBLE);

                mainBq.setVisibility(View.INVISIBLE);

                petr1Bq.setVisibility(View.VISIBLE);
                gangutskoe_srajenie.setVisibility(View.VISIBLE);
                poltavskaya_bitva.setVisibility(View.VISIBLE);
                grengamskoe_srajenie.setVisibility(View.VISIBLE);
                bitva_pri_lesnoy.setVisibility(View.VISIBLE);
                break;
        }
        chooseQuizText.setText("Квиз: " + parent.getSelectedItem());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}