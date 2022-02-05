package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView easy = findViewById(R.id.easy);
        ImageView sred = findViewById(R.id.sred);
        ImageView hard = findViewById(R.id.hard);
        ImageView button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> onBackPressed());
        easy.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, FirstQuizActivity.class)));
        sred.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, FirstMediumQuizActivity.class)));
        hard.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, FirstHardQuizActivity.class)));
    }
}