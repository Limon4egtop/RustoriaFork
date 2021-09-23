package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class FirstSredQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sred_quiz);
        RadioButton first_prav = findViewById(R.id.first_prav);
        RadioButton first_neprav = findViewById(R.id.first_neprav);
        RadioButton first_neprav_2 = findViewById(R.id.first_neprav_2);
        RadioButton first_neprav_3 = findViewById(R.id.first_neprav_3);
        Button check = findViewById(R.id.check);
        first_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    first_neprav.setChecked(false);
                    first_neprav_2.setChecked(false);
                    first_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        first_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    first_prav.setChecked(false);
                    first_neprav_2.setChecked(false);
                    first_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        first_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    first_neprav_3.setChecked(false);
                    first_neprav.setChecked(false);
                    first_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        first_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    first_neprav_2.setChecked(false);
                    first_neprav.setChecked(false);
                    first_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(FirstSredQuizActivity.this, SecondSredQuizActivity.class));
            }
        });
    }
}