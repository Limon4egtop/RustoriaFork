package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ImageView deyatels = findViewById(R.id.deyatels);
        ImageView events = findViewById(R.id.events);
        ImageView quiz = findViewById(R.id.quiz);
        ImageView bitva_80 = findViewById(R.id.bitva_80);
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
        bitva_80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, Gogov_80Activity.class));
            }
        });
    }
}