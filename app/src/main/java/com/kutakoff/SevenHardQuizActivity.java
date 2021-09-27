package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SevenHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_hard_quiz);
        RadioButton seven_prav = findViewById(R.id.seven_prav);
        RadioButton seven_neprav = findViewById(R.id.seven_neprav);
        RadioButton seven_neprav_2 = findViewById(R.id.seven_neprav_2);
        RadioButton seven_neprav_3 = findViewById(R.id.seven_neprav_3);
        Button check = findViewById(R.id.check);
        seven_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    seven_neprav.setChecked(false);
                    seven_neprav_2.setChecked(false);
                    seven_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        seven_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    seven_prav.setChecked(false);
                    seven_neprav_2.setChecked(false);
                    seven_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        seven_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    seven_neprav.setChecked(false);
                    seven_neprav_3.setChecked(false);
                    seven_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        seven_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    seven_neprav.setChecked(false);
                    seven_neprav_2.setChecked(false);
                    seven_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(SevenHardQuizActivity.this, EightHardQuizActivity.class));
            }
        });
    }
}