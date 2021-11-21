package com.kutakoff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView textresult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        ImageView info = findViewById(R.id.info);
        if (Schet.getA() == 0) {
            textresult.setText("Ваш результат: 0/5. В следующий раз повезёт!");
        } else if (Schet.getA() == 1) {
            textresult.setText("Ваш результат: 1/5. В следующий раз повезёт!");
        } else if (Schet.getA() == 2) {
            textresult.setText("Ваш результат: 2/5. В следующий раз повезёт!");
        } else if (Schet.getA() == 3) {
            textresult.setText("Ваш результат: 3/5. Неплохо!");
        } else if (Schet.getA() == 4) {
            textresult.setText("Ваш результат: 4/5. Хорошо!");
        } else if (Schet.getA() == 5) {
            textresult.setText("Ваш результат: 5/5. Отлично, молодец!");
        }
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Schet.a = 0;
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultQuizActivity.this, ChooseActivity.class));
                Schet.first = 0;
                Schet.second = 0;
                Schet.third = 0;
                Schet.fourth = 0;
                Schet.fifth = 0;
            }
        });
    }

    public void onBackPressed() {
        String first = "";
        String second = "";
        String third = "";
        String fourth = "";
        String fifth = "";
            if (Schet.first == 1) {
                first = "№1. Не правильно!";
            } else {
                first = "№1. Правильно!";
            }
            if (Schet.second == 1) {
                second = "№2. Не правильно!";
            } else {
                second = "№2. Правильно!";
            }
            if (Schet.third == 1) {
                third = "№3. Не правильно!";
            } else {
                third = "№3. Правильно!";
            }
            if (Schet.fourth == 1) {
                fourth = "№4. Не правильно!";
            } else {
                fourth = "№4. Правильно!";
            }
            if (Schet.fifth == 1) {
                fifth = "№5. Не правильно!";
            } else {
                fifth = "№5. Правильно!";
            }
        new AlertDialog.Builder(this)
                .setMessage(first + "\n" + second + "\n" + third + "\n" + fourth + "\n" + fifth)

                .setCancelable(false)
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).setNegativeButton("Закрыть", null).show();
    };
}