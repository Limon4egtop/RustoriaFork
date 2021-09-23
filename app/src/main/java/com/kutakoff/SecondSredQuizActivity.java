package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SecondSredQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sred_quiz);
        RadioButton second_prav = findViewById(R.id.second_prav);
        RadioButton second_neprav = findViewById(R.id.second_neprav);
        RadioButton second_neprav_2 = findViewById(R.id.second_neprav_2);
        RadioButton second_neprav_3 = findViewById(R.id.second_neprav_3);
        Button check = findViewById(R.id.check);
        second_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    second_neprav.setChecked(false);
                    second_neprav_2.setChecked(false);
                    second_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    second_prav.setChecked(false);
                    second_neprav_2.setChecked(false);
                    second_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    second_neprav.setChecked(false);
                    second_neprav_3.setChecked(false);
                    second_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    second_neprav.setChecked(false);
                    second_neprav_2.setChecked(false);
                    second_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(SecondSredQuizActivity.this, ThirdSredQuizActivity.class));
            }
        });
    }
}