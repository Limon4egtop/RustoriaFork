package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
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
        ImageView crest = findViewById(R.id.crest);
        ImageView go = findViewById(R.id.go);
        ImageView aboutEvent = findViewById(R.id.aboutEvent);
        ImageView window = findViewById(R.id.window);
        if (Count.windowCount == 0) {
            window.setVisibility(View.VISIBLE);
            crest.setVisibility(View.VISIBLE);
            go.setVisibility(View.VISIBLE);
            aboutEvent.setVisibility(View.VISIBLE);;
            Count.windowCount++;
        } else {
            deyatels.setVisibility(View.VISIBLE);
            events.setVisibility(View.VISIBLE);
            quiz.setVisibility(View.VISIBLE);
        }

        crest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.setVisibility(View.INVISIBLE);
                go.setVisibility(View.INVISIBLE);
                aboutEvent.setVisibility(View.INVISIBLE);
                deyatels.setVisibility(View.VISIBLE);
                events.setVisibility(View.VISIBLE);
                quiz.setVisibility(View.VISIBLE);
                crest.setVisibility(View.INVISIBLE);
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, MainEasyQuizActivity.class));
            }
        });

        aboutEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, ChooseEventsActivity.class));
            }
        });

        deyatels.setOnClickListener(v -> startActivity(new Intent(ChooseActivity.this, SearchActivity.class)));
        events.setOnClickListener(v -> startActivity(new Intent(ChooseActivity.this, ChooseEventsActivity.class)));
        quiz.setOnClickListener(v -> startActivity(new Intent(ChooseActivity.this, QuizActivity.class)));
    }
}