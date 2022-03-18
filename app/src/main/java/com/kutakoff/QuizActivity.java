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
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView
    main_easy, main_medium, main_hard,
    second_february_start;
    TextView quizSout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        ImageView button_back = findViewById(R.id.button_back);
        quizSout = findViewById(R.id.quizSout);

        main_easy = findViewById(R.id.main_easy);
        main_medium = findViewById(R.id.main_medium);
        main_hard = findViewById(R.id.main_hard);

        second_february_start = findViewById(R.id.second_february_start);

        Spinner spinner = findViewById(R.id.chooseQuiz);

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.quizNames, R.layout.spinner_text);
        adapter.setDropDownViewResource(R.layout.spinner_dropbox_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button_back.setOnClickListener(v -> onBackPressed());
        main_easy.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, MainEasyQuizActivity.class)));
        main_medium.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, MainMediumQuizActivity.class)));
        main_hard.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, MainHardQuizActivity.class)));

        second_february_start.setOnClickListener(v -> startActivity(new Intent(QuizActivity.this, SecondFebruaryQuiz.class)));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        if (position == 1) {
            main_easy.setVisibility(View.INVISIBLE);
            main_medium.setVisibility(View.INVISIBLE);
            main_hard.setVisibility(View.INVISIBLE);
            second_february_start.setVisibility(View.VISIBLE);
        } else {
            main_easy.setVisibility(View.VISIBLE);
            main_medium.setVisibility(View.VISIBLE);
            main_hard.setVisibility(View.VISIBLE);
            second_february_start.setVisibility(View.INVISIBLE);
        }
        quizSout.setText("Квиз: " + parent.getSelectedItem());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}