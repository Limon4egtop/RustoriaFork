package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class EightHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_hard_quiz);
        RadioButton eight_prav = findViewById(R.id.eight_prav);
        RadioButton eight_neprav = findViewById(R.id.eight_neprav);
        RadioButton eight_neprav_2 = findViewById(R.id.eight_neprav_2);
        RadioButton eight_neprav_3 = findViewById(R.id.eight_neprav_3);
        Button check = findViewById(R.id.check);
        eight_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    eight_neprav.setChecked(false);
                    eight_neprav_2.setChecked(false);
                    eight_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        eight_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    eight_prav.setChecked(false);
                    eight_neprav_2.setChecked(false);
                    eight_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        eight_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    eight_neprav.setChecked(false);
                    eight_neprav_3.setChecked(false);
                    eight_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        eight_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    eight_neprav.setChecked(false);
                    eight_neprav_2.setChecked(false);
                    eight_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(EightHardQuizActivity.this, NineHardQuizActivity.class));
            }
        });
    }
}