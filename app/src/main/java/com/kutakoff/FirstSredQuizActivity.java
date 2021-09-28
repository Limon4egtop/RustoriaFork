package com.kutakoff;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class FirstSredQuizActivity extends AppCompatActivity {

    ViewFlipper flipper;

    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_first_sred_quiz);
        flipper = findViewById(R.id.viewflipper);
        ImageView start_quiz = findViewById(R.id.start_quiz);
        ImageView button_back = findViewById(R.id.button_back);
        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeRight();
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
                SwipeRight();
            }
        });
        RadioButton second_prav = findViewById(R.id.second_prav);
        RadioButton second_neprav = findViewById(R.id.second_neprav);
        RadioButton second_neprav_2 = findViewById(R.id.second_neprav_2);
        RadioButton second_neprav_3 = findViewById(R.id.second_neprav_3);
        Button check_2 = findViewById(R.id.check_2);
        second_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_prav.isChecked()) {
                    check_2.setVisibility(View.VISIBLE);
                    second_neprav.setChecked(false);
                    second_neprav_2.setChecked(false);
                    second_neprav_3.setChecked(false);
                } else {
                    check_2.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav.isChecked()) {
                    check_2.setVisibility(View.VISIBLE);
                    second_prav.setChecked(false);
                    second_neprav_2.setChecked(false);
                    second_neprav_3.setChecked(false);
                } else {
                    check_2.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav_2.isChecked()) {
                    check_2.setVisibility(View.VISIBLE);
                    second_neprav.setChecked(false);
                    second_neprav_3.setChecked(false);
                    second_prav.setChecked(false);
                } else {
                    check_2.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav_3.isChecked()) {
                    check_2.setVisibility(View.VISIBLE);
                    second_neprav.setChecked(false);
                    second_neprav_2.setChecked(false);
                    second_prav.setChecked(false);
                } else {
                    check_2.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton third_prav = findViewById(R.id.third_prav);
        RadioButton third_neprav = findViewById(R.id.third_neprav);
        RadioButton third_neprav_2 = findViewById(R.id.third_neprav_2);
        RadioButton third_neprav_3 = findViewById(R.id.third_neprav_3);
        Button check_3 = findViewById(R.id.check_3);
        third_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_prav.isChecked()) {
                    check_3.setVisibility(View.VISIBLE);
                    third_neprav.setChecked(false);
                    third_neprav_2.setChecked(false);
                    third_neprav_3.setChecked(false);
                } else {
                    check_3.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav.isChecked()) {
                    check_3.setVisibility(View.VISIBLE);
                    third_prav.setChecked(false);
                    third_neprav_2.setChecked(false);
                    third_neprav_3.setChecked(false);
                } else {
                    check_3.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav_2.isChecked()) {
                    check_3.setVisibility(View.VISIBLE);
                    third_neprav.setChecked(false);
                    third_neprav_3.setChecked(false);
                    third_prav.setChecked(false);
                } else {
                    check_3.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav_3.isChecked()) {
                    check_3.setVisibility(View.VISIBLE);
                    third_neprav.setChecked(false);
                    third_neprav_2.setChecked(false);
                    third_prav.setChecked(false);
                } else {
                    check_3.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton fourth_prav = findViewById(R.id.fourth_prav);
        RadioButton fourth_neprav = findViewById(R.id.fourth_neprav);
        RadioButton fourth_neprav_2 = findViewById(R.id.fourth_neprav_2);
        RadioButton fourth_neprav_3 = findViewById(R.id.fourth_neprav_3);
        Button check_4 = findViewById(R.id.check_4);
        fourth_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_prav.isChecked()) {
                    check_4.setVisibility(View.VISIBLE);
                    fourth_neprav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                    fourth_neprav_3.setChecked(false);
                } else {
                    check_4.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav.isChecked()) {
                    check_4.setVisibility(View.VISIBLE);
                    fourth_prav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                    fourth_neprav_3.setChecked(false);
                } else {
                    check_4.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav_2.isChecked()) {
                    check_4.setVisibility(View.VISIBLE);
                    fourth_neprav.setChecked(false);
                    fourth_neprav_3.setChecked(false);
                    fourth_prav.setChecked(false);
                } else {
                    check_4.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav_3.isChecked()) {
                    check_4.setVisibility(View.VISIBLE);
                    fourth_neprav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                    fourth_prav.setChecked(false);
                } else {
                    check_4.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton five_prav = findViewById(R.id.five_prav);
        RadioButton five_neprav = findViewById(R.id.five_neprav);
        RadioButton five_neprav_2 = findViewById(R.id.five_neprav_2);
        RadioButton five_neprav_3 = findViewById(R.id.five_neprav_3);
        Button check_5 = findViewById(R.id.check_5);
        five_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_prav.isChecked()) {
                    check_5.setVisibility(View.VISIBLE);
                    five_neprav.setChecked(false);
                    five_neprav_2.setChecked(false);
                    five_neprav_3.setChecked(false);
                } else {
                    check_5.setVisibility(View.INVISIBLE);
                }
            }
        });
        five_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_neprav.isChecked()) {
                    check_5.setVisibility(View.VISIBLE);
                    five_prav.setChecked(false);
                    five_neprav_2.setChecked(false);
                    five_neprav_3.setChecked(false);
                } else {
                    check_5.setVisibility(View.INVISIBLE);
                }
            }
        });
        five_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_neprav_2.isChecked()) {
                    check_5.setVisibility(View.VISIBLE);
                    five_neprav.setChecked(false);
                    five_neprav_3.setChecked(false);
                    five_prav.setChecked(false);
                } else {
                    check_5.setVisibility(View.INVISIBLE);
                }
            }
        });
        five_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_neprav_3.isChecked()) {
                    check_5.setVisibility(View.VISIBLE);
                    five_neprav.setChecked(false);
                    five_neprav_2.setChecked(false);
                    five_prav.setChecked(false);
                } else {
                    check_5.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(FirstSredQuizActivity.this, ResultQuizActivity.class));
            }
        });
        animFlipInForward = AnimationUtils.loadAnimation(this, R.anim.flipin);
        animFlipOutForward = AnimationUtils.loadAnimation(this, R.anim.flipout);
        animFlipInBackward = AnimationUtils.loadAnimation(this, R.anim.flipin_reverse);
        animFlipOutBackward = AnimationUtils.loadAnimation(this, R.anim.flipout_reverse);
    }

    private void SwipeLeft() {
        flipper.setInAnimation(animFlipInBackward);
        flipper.setOutAnimation(animFlipOutBackward);
        flipper.showPrevious();
    }

    private void SwipeRight() {
        flipper.setInAnimation(animFlipInForward);
        flipper.setOutAnimation(animFlipOutForward);
        flipper.showNext();
    }
}