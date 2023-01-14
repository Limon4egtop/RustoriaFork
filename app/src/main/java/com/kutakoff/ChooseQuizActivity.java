package com.kutakoff;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.quizes.borodinskoeSrajenie.BorodinskoeSrajenieActivityQuiz;
import com.quizes.krim.KrimQuizMenu;
import com.quizes.main.MainQuizMenu;
import com.quizes.petr1.BitvaPriLesnoyQuizActivity;
import com.quizes.petr1.GangutskoeSrajenieQuizActivity;
import com.quizes.petr1.GrengamskoeSrajenieQuizActivity;
import com.quizes.petr1.PoltavskayaBitvaQuizActivity;
import com.quizes.staliningradskayaBitva.StalingradskayaBitvaQuizActivity;

public class ChooseQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CardView main = findViewById(R.id.main);
        main.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, MainQuizMenu.class)));

        CardView krimOfRussia = findViewById(R.id.krimOfRussia);
        krimOfRussia.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, KrimQuizMenu.class)));

        CardView borodinskoeSrajenie = findViewById(R.id.borodinskoeSrajenie);
        borodinskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, BorodinskoeSrajenieActivityQuiz.class)));

        CardView stalingradskayaBitva = findViewById(R.id.stalingradskayaBitva);
        stalingradskayaBitva.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, StalingradskayaBitvaQuizActivity.class)));

        CardView bitvaPriLesnoy = findViewById(R.id.bitvaPriLesnoy);
        bitvaPriLesnoy.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, BitvaPriLesnoyQuizActivity.class)));

        CardView gangutskoeSrajenie = findViewById(R.id.gangutskoeSrajenie);
        gangutskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, GangutskoeSrajenieQuizActivity.class)));

        CardView grengamskoeSrajenie = findViewById(R.id.grengamskoeSrajenie);
        grengamskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, GrengamskoeSrajenieQuizActivity.class)));

        CardView poltavskayaBitva = findViewById(R.id.poltavskayaBitva);
        poltavskayaBitva.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, PoltavskayaBitvaQuizActivity.class)));

        ImageView button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> startActivity(new Intent(ChooseQuizActivity.this, ChooseActivity.class)));
    }
}