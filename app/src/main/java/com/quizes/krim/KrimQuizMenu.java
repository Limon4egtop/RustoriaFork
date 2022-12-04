package com.quizes.krim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

import com.kutakoff.ChooseQuizActivity;
import com.kutakoff.R;

public class KrimQuizMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krim_quiz_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView krim_easy = findViewById(R.id.krim_easy);
        ImageView krim_medium = findViewById(R.id.krim_medium);
        ImageView krim_hard = findViewById(R.id.krim_hard);
        krim_easy.setOnClickListener(v -> startActivity(new Intent(KrimQuizMenu.this, KrimEasyQuizActivity.class)));
        krim_medium.setOnClickListener(v -> startActivity(new Intent(KrimQuizMenu.this, KrimMediumQuizActivity.class)));
        krim_hard.setOnClickListener(v -> startActivity(new Intent(KrimQuizMenu.this, KrimHardQuizActivity.class)));

        ImageView button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> startActivity(new Intent(KrimQuizMenu.this, ChooseQuizActivity.class)));
    }
}