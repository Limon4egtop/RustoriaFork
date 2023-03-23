package com.quizes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kutakoff.Quizzes;
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
        TextView mark = findViewById(R.id.mark);
        ImageView goHome = findViewById(R.id.goHome);

        if (Count.isSpecialQUiz) {
            switch (Count.getCorrectAnswers()) {
                case 0:
                    progressBar.setProgress(0);
                    textResult.setText(0 + "%");
                    mark.setText("Попробуйте ещё раз.");
                    break;
                case 1:
                    progressBar.setProgress(17);
                    textResult.setText(17 + "%");
                    mark.setText("Попробуйте ещё раз.");
                    break;
                case 2:
                    progressBar.setProgress(33);
                    textResult.setText(33 + "%");
                    mark.setText("Попробуйте ещё раз.");
                    break;
                case 3:
                    progressBar.setProgress(50);
                    textResult.setText(50 + "%");
                    mark.setText("Удоволетворительно.");
                    break;
                case 4:
                    progressBar.setProgress(66);
                    textResult.setText(66 + "%");
                    mark.setText("Удоволетворительно.");
                    break;
                case 5:
                    progressBar.setProgress(83);
                    textResult.setText(83 + "%");
                    mark.setText("Хорошо.");
                    break;
                case 6:
                    progressBar.setProgress(100);
                    textResult.setText(100 + "%");
                    mark.setText("Отлично.");
                    break;
            }
        } else if (Count.isHardQuiz) {
            progressBar.setProgress(Count.getCorrectAnswers() * 10);
            textResult.setText(Count.getCorrectAnswers() * 10 + "%");
            Count.markCount = Count.getCorrectAnswers() * 10;
            if (Count.markCount < 50) {
                mark.setText("Попробуйте ещё раз.");
            } else if (Count.markCount <= 60) {
                mark.setText("Удоволетворительно.");
            } else if (Count.markCount <= 80) {
                mark.setText("Хорошо.");
            } else {
                mark.setText("Отлично.");
            }
        } else {
            progressBar.setProgress(Count.getCorrectAnswers() * 20);
            textResult.setText(Count.getCorrectAnswers() * 20 + "%");
            Count.markCount = Count.getCorrectAnswers() * 20;
            if (Count.markCount <= 40) {
                mark.setText("Попробуйте ещё раз.");
            } else if (Count.markCount <= 60) {
                mark.setText("Удоволетворительно.");
            } else if (Count.markCount <= 80) {
                mark.setText("Хорошо.");
            } else {
                mark.setText("Отлично.");
            }
        }
        Count.isHardQuiz = false;
        Count.isSpecialQUiz = false;
        Count.correctAnswers = 0;
        goHome.setOnClickListener(v -> startActivity(new Intent(ResultQuizActivity.this, Quizzes.class)));
    }
}