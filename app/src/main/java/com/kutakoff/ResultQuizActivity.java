package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
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
        if (Count.getA() == 0) {
            textResult.setText("Ваш результат: 0/5. В следующий раз повезёт!");
        } else if (Count.getA() == 1) {
            textResult.setText("Ваш результат: 1/5. В следующий раз повезёт!");
        } else if (Count.getA() == 2) {
            textResult.setText("Ваш результат: 2/5. В следующий раз повезёт!");
        } else if (Count.getA() == 3) {
            textResult.setText("Ваш результат: 3/5. Неплохо!");
        } else if (Count.getA() == 4) {
            textResult.setText("Ваш результат: 4/5. Хорошо!");
        } else if (Count.getA() == 5) {
            textResult.setText("Ваш результат: 5/5. Хорошо!");
        }
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class));
                Count.a = 0;
            }
        });
    }
}