package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_hard_quiz);
        TextView textresult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        if (Schet.getA() == 0) {
            textresult.setText("Ваш результат: 0/10. В следующий раз повезёт!");
        }
        if (Schet.getA() == 1) {
            textresult.setText("Ваш результат: 1/10. В следующий раз повезёт!");
        }
        if (Schet.getA() == 2) {
            textresult.setText("Ваш результат: 2/10. В следующий раз повезёт!");
        }
        if (Schet.getA() == 3) {
            textresult.setText("Ваш результат: 3/10. В следующий раз повезёт!");
        }
        if (Schet.getA() == 4) {
            textresult.setText("Ваш результат: 4/10. Неплохо!");
        }
        if (Schet.getA() == 5) {
            textresult.setText("Ваш результат: 5/10. Неплохо!");
        }
        if (Schet.getA() == 6) {
            textresult.setText("Ваш результат: 6/10. Неплохо!");
        }
        if (Schet.getA() == 7) {
            textresult.setText("Ваш результат: 7/10. Хорошо!");
        }
        if (Schet.getA() == 8) {
            textresult.setText("Ваш результат: 8/10. Хорошо!");
        }
        if (Schet.getA() == 9) {
            textresult.setText("Ваш результат: 9/10. Отлично, молодец!");
        }
        if (Schet.getA() == 10) {
            textresult.setText("Ваш результат: 10/10. Отлично, молодец!");
        }
        Schet.a = 0;
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultHardQuizActivity.this, ChooseActivity.class));
            }
        });
    }
}