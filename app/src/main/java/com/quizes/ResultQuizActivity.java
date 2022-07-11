package com.quizes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kutakoff.ChooseActivity;
import com.utilitaryClasses.Count;
import com.kutakoff.R;

public class ResultQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView textResult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        String compliment = "";
        if (Count.isHardQuiz) {
            if (Count.getA() >= 0 && Count.getA() <= 3) {
                compliment = "Попробуй ещё раз!";
            } else if(Count.getA() >= 4 && Count.getA() <= 6) {
                compliment = "Неплохо!";
            } else if (Count.getA() == 7 || Count.getA() == 8) {
                compliment = "Ты хорошо справился!";
            } else if (Count.getA() == 9 || Count.getA() == 10) {
                compliment = "Ты справился отлично!";
            }
            textResult.setText(compliment + "\nТвой результат: " + Count.getA() + "/10.");
        } else if (Count.isSpecialQUiz) {
            if (Count.getA() >= 0 && Count.getA() <= 2) {
                compliment = "Попробуй ещё раз!";
            } else if(Count.getA() == 3 || Count.getA() == 4) {
                compliment = "Неплохо!";
            } else if (Count.getA() == 5) {
                compliment = "Ты хорошо справился!";
            } else if (Count.getA() == 6) {
                compliment = "Ты справился отлично!";
            }
            textResult.setText(compliment + "\nТвой результат: " + Count.getA() + "/6.");
        } else {
            if (Count.getA() >= 0 && Count.getA() < 3) {
                compliment = "Попробуй ещё раз!";
            } else if(Count.getA() == 3) {
                compliment = "Неплохо!";
            } else if (Count.getA() == 4) {
                compliment = "Молодец, ты хорошо справился!";
            } else if (Count.getA() == 5) {
                compliment = "Молодец, ты справился отлично!";
            }
            textResult.setText(compliment + "\nТвой результат: " + Count.getA() + "/5.");
        }
        Count.isHardQuiz = false;
        Count.isSpecialQUiz = false;
        Count.a = 0;
        goHome.setOnClickListener(v -> startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class)));
    }
}