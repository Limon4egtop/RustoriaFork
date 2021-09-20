package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        TextView textresult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        if (Schet.getA() == 0) {
            textresult.setText("Ваш результат: 0/5. В следующий раз повезёт!");
        }
        if (Schet.getA() == 1) {
            textresult.setText("Ваш результат: 1/5. В следующий раз повезёт!");
        }
        if (Schet.getA() == 2) {
            textresult.setText("Ваш результат: 2/5. В следующий раз повезёт!");
        }
        if (Schet.getA() == 3) {
            textresult.setText("Ваш результат: 3/5. Неплохо!");
        }
        if (Schet.getA() == 4) {
            textresult.setText("Ваш результат: 4/5. Хорошо!");
        }
        if (Schet.getA() == 5) {
            textresult.setText("Ваш результат: 5/5. Отлично, молодец!");
        }
        Schet.a = 0;
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class));
            }
        });
    }
}