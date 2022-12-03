package com.quizes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kutakoff.ChooseActivity;
import com.utilitaryClasses.Count;
import com.kutakoff.R;

public class ResultQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView textResult = findViewById(R.id.textResult);
        ImageView goHome = findViewById(R.id.goHome);

        if (Count.isSpecialQUiz) {
            switch (Count.getCorrectAnswers()) {
                case 0:
                    progressBar.setProgress(0);
                    textResult.setText(0 + "%");
                    break;
                case 1:
                    progressBar.setProgress(17);
                    textResult.setText(17 + "%");
                    break;
                case 2:
                    progressBar.setProgress(33);
                    textResult.setText(33 + "%");
                    break;
                case 3:
                    progressBar.setProgress(50);
                    textResult.setText(50 + "%");
                    break;
                case 4:
                    progressBar.setProgress(66);
                    textResult.setText(66 + "%");
                    break;
                case 5:
                    progressBar.setProgress(83);
                    textResult.setText(83 + "%");
                    break;
                case 6:
                    progressBar.setProgress(100);
                    textResult.setText(100 + "%");
                    break;
            }
        } else if (Count.isHardQuiz) {
            progressBar.setProgress(Count.getCorrectAnswers() * 10);
            textResult.setText(Count.getCorrectAnswers() * 10 + "%");
        } else {
            progressBar.setProgress(Count.getCorrectAnswers() * 20);
            textResult.setText(Count.getCorrectAnswers() * 20 + "%");
        }
        Count.isHardQuiz = false;
        Count.isSpecialQUiz = false;
        Count.correctAnswers = 0;
        goHome.setOnClickListener(v -> startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class)));
    }
}