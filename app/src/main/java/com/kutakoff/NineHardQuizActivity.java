package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class NineHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_hard_quiz);
        RadioButton nine_prav = findViewById(R.id.nine_prav);
        RadioButton nine_neprav = findViewById(R.id.nine_neprav);
        RadioButton nine_neprav_2 = findViewById(R.id.nine_neprav_2);
        RadioButton nine_neprav_3 = findViewById(R.id.nine_neprav_3);
        Button check = findViewById(R.id.check);
        nine_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    nine_neprav.setChecked(false);
                    nine_neprav_2.setChecked(false);
                    nine_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        nine_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    nine_prav.setChecked(false);
                    nine_neprav_2.setChecked(false);
                    nine_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        nine_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    nine_neprav.setChecked(false);
                    nine_neprav_3.setChecked(false);
                    nine_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        nine_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    nine_neprav.setChecked(false);
                    nine_neprav_2.setChecked(false);
                    nine_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(NineHardQuizActivity.this, TenHardQuizActivity.class));
            }
        });
    }
}