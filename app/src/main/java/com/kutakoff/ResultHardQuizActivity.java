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
        if (Count.getA() == 0) {
            textresult.setText("Ваш результат: 0/10. В следующий раз повезёт!");
        }else if (Count.getA() == 1) {
            textresult.setText("Ваш результат: 1/10. В следующий раз повезёт!");
        }else if (Count.getA() == 2) {
            textresult.setText("Ваш результат: 2/10. В следующий раз повезёт!");
        }else if (Count.getA() == 3) {
            textresult.setText("Ваш результат: 3/10. В следующий раз повезёт!");
        }else if (Count.getA() == 4) {
            textresult.setText("Ваш результат: 4/10. Неплохо!");
        }else if (Count.getA() == 5) {
            textresult.setText("Ваш результат: 5/10. Неплохо!");
        }else if (Count.getA() == 6) {
            textresult.setText("Ваш результат: 6/10. Неплохо!");
        }else if (Count.getA() == 7) {
            textresult.setText("Ваш результат: 7/10. Хорошо!");
        }else if (Count.getA() == 8) {
            textresult.setText("Ваш результат: 8/10. Хорошо!");
        }else if (Count.getA() == 9) {
            textresult.setText("Ваш результат: 9/10. Отлично, молодец!");
        }else if (Count.getA() == 10) {
            textresult.setText("Ваш результат: 10/10. Отлично, молодец!");
        }
        Count.a = 0;
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
                Count.first = 0;
                Count.second = 0;
                Count.third = 0;
                Count.fourth = 0;
                Count.fifth = 0;
                Count.sixth = 0;
                Count.seventh = 0;
                Count.eight = 0;
                Count.ninth = 0;
                Count.tenth = 0;
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
        if (Count.first == 1) {
            first = "№1. Не правильно!";
        } else {
            first = "№1. Правильно!";
        }
        if (Count.second == 1) {
            second = "№2. Не правильно!";
        } else {
            second = "№2. Правильно!";
        }
        if (Count.third == 1) {
            third = "№3. Не правильно!";
        } else {
            third = "№3. Правильно!";
        }
        if (Count.fourth == 1) {
            fourth = "№4. Не правильно!";
        } else {
            fourth = "№4. Правильно!";
        }
        if (Count.fifth == 1) {
            fifth = "№5. Не правильно!";
        } else {
            fifth = "№5. Правильно!";
        }
        if (Count.sixth == 1) {
            sixth = "№6. Не правильно!";
        } else {
            sixth = "№6. Правильно!";
        }
        if (Count.seventh == 1) {
            seventh = "№7. Не правильно!";
        } else {
            seventh = "№7. Правильно!";
        }
        if (Count.eight == 1) {
            eight = "№8. Не правильно!";
        } else {
            eight = "№8. Правильно!";
        }
        if (Count.ninth == 1) {
            ninth = "№9. Не правильно!";
        } else {
            ninth = "№9. Правильно!";
        }
        if (Count.tenth == 1) {
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