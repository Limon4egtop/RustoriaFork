package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SixHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_hard_quiz);
        RadioButton six_prav = findViewById(R.id.six_prav);
        RadioButton six_neprav = findViewById(R.id.six_neprav);
        RadioButton six_neprav_2 = findViewById(R.id.six_neprav_2);
        RadioButton six_neprav_3 = findViewById(R.id.six_neprav_3);
        Button check = findViewById(R.id.check);
        six_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    six_neprav.setChecked(false);
                    six_neprav_2.setChecked(false);
                    six_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        six_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    six_prav.setChecked(false);
                    six_neprav_2.setChecked(false);
                    six_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        six_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    six_neprav.setChecked(false);
                    six_neprav_3.setChecked(false);
                    six_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        six_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    six_neprav.setChecked(false);
                    six_neprav_2.setChecked(false);
                    six_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(SixHardQuizActivity.this, SevenHardQuizActivity.class));
            }
        });
    }
}