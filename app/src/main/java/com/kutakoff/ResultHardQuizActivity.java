package com.kutakoff;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ResultHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_hard_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView textresult = findViewById(R.id.textresult);
        ImageView goHome = findViewById(R.id.goHome);
        ImageView info = findViewById(R.id.info);
        if (Schet.getA() == 0) {
            textresult.setText("Ваш результат: 0/10. В следующий раз повезёт!");
        }else if (Schet.getA() == 1) {
            textresult.setText("Ваш результат: 1/10. В следующий раз повезёт!");
        }else if (Schet.getA() == 2) {
            textresult.setText("Ваш результат: 2/10. В следующий раз повезёт!");
        }else if (Schet.getA() == 3) {
            textresult.setText("Ваш результат: 3/10. В следующий раз повезёт!");
        }else if (Schet.getA() == 4) {
            textresult.setText("Ваш результат: 4/10. Неплохо!");
        }else if (Schet.getA() == 5) {
            textresult.setText("Ваш результат: 5/10. Неплохо!");
        }else if (Schet.getA() == 6) {
            textresult.setText("Ваш результат: 6/10. Неплохо!");
        }else if (Schet.getA() == 7) {
            textresult.setText("Ваш результат: 7/10. Хорошо!");
        }else if (Schet.getA() == 8) {
            textresult.setText("Ваш результат: 8/10. Хорошо!");
        }else if (Schet.getA() == 9) {
            textresult.setText("Ваш результат: 9/10. Отлично, молодец!");
        }else if (Schet.getA() == 10) {
            textresult.setText("Ваш результат: 10/10. Отлично, молодец!");
        }
        Schet.a = 0;
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultHardQuizActivity.this, ChooseActivity.class));
                Schet.first = 0;
                Schet.second = 0;
                Schet.third = 0;
                Schet.fourth = 0;
                Schet.fifth = 0;
                Schet.sixth = 0;
                Schet.seventh = 0;
                Schet.eight = 0;
                Schet.ninth = 0;
                Schet.tenth = 0;
            }
        });
    }

    public void onBackPressed() {
        String first = "";
        String second = "";
        String third = "";
        String fourth = "";
        String fifth = "";
        String sixth = "";
        String seventh = "";
        String eight = "";
        String ninth = "";
        String tenth = "";
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
        if (Schet.sixth == 1) {
            sixth = "№6. Не правильно!";
        } else {
            sixth = "№6. Правильно!";
        }
        if (Schet.seventh == 1) {
            seventh = "№7. Не правильно!";
        } else {
            seventh = "№7. Правильно!";
        }
        if (Schet.eight == 1) {
            eight = "№8. Не правильно!";
        } else {
            eight = "№8. Правильно!";
        }
        if (Schet.ninth == 1) {
            ninth = "№9. Не правильно!";
        } else {
            ninth = "№9. Правильно!";
        }
        if (Schet.tenth == 1) {
            tenth = "№10. Не правильно!";
        } else {
            tenth = "№10. Правильно!";
        }
        new AlertDialog.Builder(this)
                .setMessage(first + "\n" + second + "\n" + third + "\n" + fourth + "\n" + fifth + "\n" + sixth + "\n" + seventh + "\n" + eight + "\n" + ninth + "\n" + tenth)

                .setCancelable(false)
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).setNegativeButton("Закрыть", null).show();
    };
}