package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_hard_quiz);
        RadioButton third_prav = findViewById(R.id.third_prav);
        RadioButton third_neprav = findViewById(R.id.third_neprav);
        RadioButton third_neprav_2 = findViewById(R.id.third_neprav_2);
        RadioButton third_neprav_3 = findViewById(R.id.third_neprav_3);
        Button check = findViewById(R.id.check);
        third_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    third_neprav.setChecked(false);
                    third_neprav_2.setChecked(false);
                    third_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    third_prav.setChecked(false);
                    third_neprav_2.setChecked(false);
                    third_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    third_neprav.setChecked(false);
                    third_neprav_3.setChecked(false);
                    third_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    third_neprav.setChecked(false);
                    third_neprav_2.setChecked(false);
                    third_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(ThirdHardQuizActivity.this, FourthHardQuizActivity.class));
            }
        });
    }
}