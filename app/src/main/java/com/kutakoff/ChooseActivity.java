package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView deyatels = findViewById(R.id.deyatels);
        ImageView events = findViewById(R.id.events);
        ImageView quiz = findViewById(R.id.quiz);
        ImageView easy = findViewById(R.id.easy);
        ImageView sred = findViewById(R.id.sred);
        ImageView hard = findViewById(R.id.hard);
        SwitchCompat contrMode = findViewById(R.id.contr_mode);
        deyatels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, SearchActivity.class));
            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, ChooseEventsActivity.class));
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, QuizActivity.class));
            }
        });
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, SecondEasyQuizActivity.class));
            }
        });
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, SecondSredQuizActivity.class));
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, SecondHardQuizActivity.class));
            }
        });
        contrMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contVisible = contrMode.isChecked() ? View.VISIBLE : View.INVISIBLE;
                int contInvisible = contrMode.isChecked() ? View.INVISIBLE : View.VISIBLE;
                deyatels.setVisibility(contInvisible);
                events.setVisibility(contInvisible);
                quiz.setVisibility(contInvisible);
                easy.setVisibility(contVisible);
                sred.setVisibility(contVisible);
                hard.setVisibility(contVisible);
            }
        });
    }
}