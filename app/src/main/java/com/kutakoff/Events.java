package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.utilitaryClasses.MainMethodsClass;

public class Events extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

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
        quizzes.setOnClickListener(v -> startActivity(new Intent(Events.this, Quizzes.class)));

        CardView events = findViewById(R.id.events);

        CardView deyatels = findViewById(R.id.deyatels);
        deyatels.setOnClickListener(v -> startActivity(new Intent(Events.this, Deyatels.class)));

        CardView[] bottomCardViews = {quizzes, events, deyatels};
        for (CardView cardView : bottomCardViews) {
            MainMethodsClass.setBottomCardViewSize(displayMetrics, cardView);
        }
    }
}