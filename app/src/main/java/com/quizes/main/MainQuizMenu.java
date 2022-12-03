package com.quizes.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.kutakoff.ChooseQuizActivity;
import com.kutakoff.MainActivity;
import com.kutakoff.QuizActivity;
import com.kutakoff.R;

public class MainQuizMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz_menu);
        ImageView main_easy = findViewById(R.id.main_easy);
        ImageView main_medium = findViewById(R.id.main_medium);
        ImageView main_hard = findViewById(R.id.main_hard);
        main_easy.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, MainEasyQuizActivity.class)));
        main_medium.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, MainMediumQuizActivity.class)));
        main_hard.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, MainHardQuizActivity.class)));

        ImageView button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> startActivity(new Intent(MainQuizMenu.this, ChooseQuizActivity.class)));
    }
}