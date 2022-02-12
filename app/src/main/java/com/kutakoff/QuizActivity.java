package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView easy = findViewById(R.id.easy);
        ImageView medium = findViewById(R.id.sred);
        ImageView hard = findViewById(R.id.hard);
        ImageView button_back = findViewById(R.id.button_back);
        Spinner spinner = findViewById(R.id.chooseQuiz);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(QuizActivity.this, R.array.quizNames, R.layout.spinner_text);
                arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item); ///todo поменять цвет и размер текста у Spinner.
                spinner.setAdapter(arrayAdapter);
                if (selectedItemPosition == 0) {
                    medium.setVisibility(View.VISIBLE);
                }else if (selectedItemPosition == 1) {
                    medium.setVisibility(View.INVISIBLE);
                } else if (selectedItemPosition == 2) {
                    medium.setVisibility(View.INVISIBLE);
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        button_back.setOnClickListener(v -> onBackPressed());
        easy.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, FirstQuizActivity.class)));
        medium.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, FirstMediumQuizActivity.class)));
        hard.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, FirstHardQuizActivity.class)));
    }
}