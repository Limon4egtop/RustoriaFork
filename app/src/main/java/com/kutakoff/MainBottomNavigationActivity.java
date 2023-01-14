package com.kutakoff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.quizes.borodinskoeSrajenie.BorodinskoeSrajenieActivityQuiz;
import com.quizes.krim.KrimQuizMenu;
import com.quizes.main.MainQuizMenu;
import com.quizes.petr1.BitvaPriLesnoyQuizActivity;
import com.quizes.petr1.GangutskoeSrajenieQuizActivity;
import com.quizes.petr1.GrengamskoeSrajenieQuizActivity;
import com.quizes.petr1.PoltavskayaBitvaQuizActivity;
import com.quizes.staliningradskayaBitva.StalingradskayaBitvaQuizActivity;

import org.jetbrains.annotations.NotNull;

public class MainBottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_navigation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_quizzes);

        CardView main = findViewById(R.id.main);
        main.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, MainQuizMenu.class)));

        CardView krimOfRussia = findViewById(R.id.krimOfRussia);
        krimOfRussia.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, KrimQuizMenu.class)));

        CardView borodinskoeSrajenie = findViewById(R.id.borodinskoeSrajenie);
        borodinskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, BorodinskoeSrajenieActivityQuiz.class)));

        CardView stalingradskayaBitva = findViewById(R.id.stalingradskayaBitva);
        stalingradskayaBitva.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, StalingradskayaBitvaQuizActivity.class)));

        CardView bitvaPriLesnoy = findViewById(R.id.bitvaPriLesnoy);
        bitvaPriLesnoy.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, BitvaPriLesnoyQuizActivity.class)));

        CardView gangutskoeSrajenie = findViewById(R.id.gangutskoeSrajenie);
        gangutskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, GangutskoeSrajenieQuizActivity.class)));

        CardView grengamskoeSrajenie = findViewById(R.id.grengamskoeSrajenie);
        grengamskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, GrengamskoeSrajenieQuizActivity.class)));

        CardView poltavskayaBitva = findViewById(R.id.poltavskayaBitva);
        poltavskayaBitva.setOnClickListener(v -> startActivity(new Intent(MainBottomNavigationActivity.this, PoltavskayaBitvaQuizActivity.class)));

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_events:
                        Intent intentE = new Intent(MainBottomNavigationActivity.this, Events.class);
                        intentE.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentE);
                        return true;
                    case R.id.navigation_deyatels:
                        Intent intentD = new Intent(MainBottomNavigationActivity.this, Deyatels.class);
                        intentD.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentD);
                        return true;
                    case R.id.navigation_quizzes:
                        return true;
                }
                return false;
            }
        });
    }
}