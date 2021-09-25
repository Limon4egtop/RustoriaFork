package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class FourthHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_hard_quiz);
        RadioButton fourth_prav = findViewById(R.id.fourth_prav);
        RadioButton fourth_neprav = findViewById(R.id.fourth_neprav);
        RadioButton fourth_neprav_2 = findViewById(R.id.fourth_neprav_2);
        RadioButton fourth_neprav_3 = findViewById(R.id.fourth_neprav_3);
        Button check = findViewById(R.id.check);
        fourth_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    fourth_neprav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                    fourth_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    fourth_prav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                    fourth_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    fourth_neprav.setChecked(false);
                    fourth_neprav_3.setChecked(false);
                    fourth_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    fourth_neprav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                    fourth_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(FourthHardQuizActivity.this, ResultHardQuizActivity.class));
            }
        });
    }
}