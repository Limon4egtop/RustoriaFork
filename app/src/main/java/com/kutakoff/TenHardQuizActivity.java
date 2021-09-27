package com.kutakoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class TenHardQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_hard_quiz);
        RadioButton ten_prav = findViewById(R.id.ten_prav);
        RadioButton ten_neprav = findViewById(R.id.ten_neprav);
        RadioButton ten_neprav_2 = findViewById(R.id.ten_neprav_2);
        RadioButton ten_neprav_3 = findViewById(R.id.ten_neprav_3);
        Button check = findViewById(R.id.check);
        ten_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_prav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    ten_neprav.setChecked(false);
                    ten_neprav_2.setChecked(false);
                    ten_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        ten_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_neprav.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    ten_prav.setChecked(false);
                    ten_neprav_2.setChecked(false);
                    ten_neprav_3.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        ten_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_neprav_2.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    ten_neprav.setChecked(false);
                    ten_neprav_3.setChecked(false);
                    ten_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        ten_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_neprav_3.isChecked()) {
                    check.setVisibility(View.VISIBLE);
                    ten_neprav.setChecked(false);
                    ten_neprav_2.setChecked(false);
                    ten_prav.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(TenHardQuizActivity.this, ResultHardQuizActivity.class));
            }
        });
    }
}