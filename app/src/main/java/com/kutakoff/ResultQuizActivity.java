package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        TextView textResult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        if (Count.isHardQuiz) {
            textResult.setText("Ваш результат: " + Count.getA() + "/10.");
        } else if (Count.isSpecialQUiz) {
            textResult.setText("Ваш результат: " + Count.getA() + "/6.");
        } else {
            textResult.setText("Ваш результат: " + Count.getA() + "/5.");
        }
        Count.isHardQuiz = false;
        Count.isSpecialQUiz = false;
        Count.a = 0;
        goHome.setOnClickListener(v -> startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class)));
    }
}