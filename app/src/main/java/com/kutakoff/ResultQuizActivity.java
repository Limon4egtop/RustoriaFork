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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        TextView textResult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        for (int aCount = 0; aCount <= 10; aCount++) {
            if (Count.getA() == aCount) {
                if (Count.isHardQuiz == true) {
                    textResult.setText("Ваш результат: " + aCount + "/10.");
                } else {
                    textResult.setText("Ваш результат: " + aCount + "/5.");
                }
            }
        }
        Count.a = 0;
        goHome.setOnClickListener(v -> startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class)));
    }
}