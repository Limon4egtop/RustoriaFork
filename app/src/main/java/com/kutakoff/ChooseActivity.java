package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
        ImageView contrMember = findViewById(R.id.contr_member);
        ImageView contQuiz = findViewById(R.id.cont_quiz);
        SwitchCompat contrMode = findViewById(R.id.contr_mode);
        ImageView contrDetail = findViewById(R.id.contr_detail);
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
        contrDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, DetailsActivity.class));
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
                contrMember.setVisibility(contVisible);
                contQuiz.setVisibility(contVisible);
                contrDetail.setVisibility(contVisible);
            }
        });
    }
}