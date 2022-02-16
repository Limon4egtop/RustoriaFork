package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
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

        deyatels.setOnClickListener(v -> startActivity(new Intent(ChooseActivity.this, SearchActivity.class)));
        events.setOnClickListener(v -> startActivity(new Intent(ChooseActivity.this, ChooseEventsActivity.class)));
        quiz.setOnClickListener(v -> startActivity(new Intent(ChooseActivity.this, QuizActivity.class)));
    }
}