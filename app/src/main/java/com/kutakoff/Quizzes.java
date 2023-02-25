package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.quizes.borodinskoeSrajenie.BorodinskoeSrajenieActivityQuiz;
import com.quizes.krim.KrimQuizMenu;
import com.quizes.main.MainQuizMenu;
import com.quizes.petr1.BitvaPriLesnoyQuizActivity;
import com.quizes.petr1.GangutskoeSrajenieQuizActivity;
import com.quizes.petr1.GrengamskoeSrajenieQuizActivity;
import com.quizes.petr1.PoltavskayaBitvaQuizActivity;
import com.quizes.staliningradskayaBitva.StalingradskayaBitvaQuizActivity;
import com.utilitaryClasses.MainMethodsClass;

public class Quizzes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        NestedScrollView scrollView = findViewById(R.id.scrollView);

        CardView main = findViewById(R.id.main);
        main.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, MainQuizMenu.class)));

        CardView krimOfRussia = findViewById(R.id.krimOfRussia);
        krimOfRussia.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, KrimQuizMenu.class)));

        CardView borodinskoeSrajenie = findViewById(R.id.borodinskoeSrajenie);
        borodinskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, BorodinskoeSrajenieActivityQuiz.class)));

        CardView stalingradskayaBitva = findViewById(R.id.stalingradskayaBitva);
        stalingradskayaBitva.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, StalingradskayaBitvaQuizActivity.class)));

        CardView bitvaPriLesnoy = findViewById(R.id.bitvaPriLesnoy);
        bitvaPriLesnoy.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, BitvaPriLesnoyQuizActivity.class)));

        CardView gangutskoeSrajenie = findViewById(R.id.gangutskoeSrajenie);
        gangutskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, GangutskoeSrajenieQuizActivity.class)));

        CardView grengamskoeSrajenie = findViewById(R.id.grengamskoeSrajenie);
        grengamskoeSrajenie.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, GrengamskoeSrajenieQuizActivity.class)));

        CardView poltavskayaBitva = findViewById(R.id.poltavskayaBitva);
        poltavskayaBitva.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, PoltavskayaBitvaQuizActivity.class)));

        CardView[] cardViews = {main, krimOfRussia, borodinskoeSrajenie, stalingradskayaBitva, bitvaPriLesnoy, gangutskoeSrajenie, grengamskoeSrajenie, poltavskayaBitva};

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        /**
         * Переключение на квизы|события|деятели
         */
        CardView quizzes = findViewById(R.id.quizzes);
        ImageView quizzesImage = findViewById(R.id.quizzesImage);

        CardView events = findViewById(R.id.events);
        events.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, Events.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));
        ImageView eventsImage = findViewById(R.id.eventsImage);

        CardView deyatels = findViewById(R.id.deyatels);
        deyatels.setOnClickListener(v -> startActivity(new Intent(Quizzes.this, Deyatels.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)));
        ImageView deyatelsImage = findViewById(R.id.deyatelsImage);

        CardView[] bottomCardViews = {quizzes, events, deyatels};
        ImageView[] bottomImageViews = {quizzesImage, eventsImage, deyatelsImage};
        for (int i = 0; i < bottomCardViews.length; i++) {
            MainMethodsClass.setBottomCardAndImageViewViewSize(displayMetrics, bottomCardViews[i], bottomImageViews[i]);
        }

        setUpperBqSize(displayMetrics);
        for (CardView cardView : cardViews) {
            setCardViewSize(displayMetrics, cardView);
        }
    }
    private void setCardViewSize(DisplayMetrics displayMetrics, CardView cardView) {
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        int universalParam = displayMetrics.widthPixels / 2 - 80;
        layoutParams.height = universalParam;
        layoutParams.width = universalParam;
    }

    private void setUpperBqSize(DisplayMetrics displayMetrics) {
        ImageView upper_bq = findViewById(R.id.upper_bq);
        ViewGroup.LayoutParams upper_bqParams = upper_bq.getLayoutParams();
        upper_bqParams.height = displayMetrics.heightPixels / 5;
    }
}