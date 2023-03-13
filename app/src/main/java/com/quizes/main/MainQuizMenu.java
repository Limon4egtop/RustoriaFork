package com.quizes.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.kutakoff.Quizzes;
import com.kutakoff.R;
import com.utilitaryClasses.MainMethodsClass;

public class MainQuizMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView main_easy = findViewById(R.id.main_easy);
        ImageView main_medium = findViewById(R.id.main_medium);
        ImageView main_hard = findViewById(R.id.main_hard);
        ImageView[] imageViews = {main_easy, main_medium, main_hard};
        main_easy.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, MainEasyQuizActivity.class)));
        main_medium.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, MainMediumQuizActivity.class)));
        main_hard.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, MainHardQuizActivity.class)));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        for (ImageView imageView : imageViews) {
            MainMethodsClass.setImageViewSize(imageView, displayMetrics);
        }

        ImageView button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, Quizzes.class)));
    }
}