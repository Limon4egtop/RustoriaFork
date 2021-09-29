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

public class FirstHardQuizActivity extends AppCompatActivity {

    ViewFlipper flipper;

    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_first_hard_quiz);
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
                SwipeRight();
            }
        });
        RadioButton six_prav = findViewById(R.id.six_prav);
        RadioButton six_neprav = findViewById(R.id.six_neprav);
        RadioButton six_neprav_2 = findViewById(R.id.six_neprav_2);
        RadioButton six_neprav_3 = findViewById(R.id.six_neprav_3);
        Button check_6 = findViewById(R.id.check_6);
        six_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_prav.isChecked()) {
                    check_6.setVisibility(View.VISIBLE);
                    six_neprav.setChecked(false);
                    six_neprav_2.setChecked(false);
                    six_neprav_3.setChecked(false);
                } else {
                    check_6.setVisibility(View.INVISIBLE);
                }
            }
        });
        six_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_neprav.isChecked()) {
                    check_6.setVisibility(View.VISIBLE);
                    six_prav.setChecked(false);
                    six_neprav_2.setChecked(false);
                    six_neprav_3.setChecked(false);
                } else {
                    check_6.setVisibility(View.INVISIBLE);
                }
            }
        });
        six_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_neprav_2.isChecked()) {
                    check_6.setVisibility(View.VISIBLE);
                    six_neprav.setChecked(false);
                    six_neprav_3.setChecked(false);
                    six_prav.setChecked(false);
                } else {
                    check_6.setVisibility(View.INVISIBLE);
                }
            }
        });
        six_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_neprav_3.isChecked()) {
                    check_6.setVisibility(View.VISIBLE);
                    six_neprav.setChecked(false);
                    six_neprav_2.setChecked(false);
                    six_prav.setChecked(false);
                } else {
                    check_6.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (six_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton seven_prav = findViewById(R.id.seven_prav);
        RadioButton seven_neprav = findViewById(R.id.seven_neprav);
        RadioButton seven_neprav_2 = findViewById(R.id.seven_neprav_2);
        RadioButton seven_neprav_3 = findViewById(R.id.seven_neprav_3);
        Button check_7 = findViewById(R.id.check_7);
        seven_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_prav.isChecked()) {
                    check_7.setVisibility(View.VISIBLE);
                    seven_neprav.setChecked(false);
                    seven_neprav_2.setChecked(false);
                    seven_neprav_3.setChecked(false);
                } else {
                    check_7.setVisibility(View.INVISIBLE);
                }
            }
        });
        seven_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_neprav.isChecked()) {
                    check_7.setVisibility(View.VISIBLE);
                    seven_prav.setChecked(false);
                    seven_neprav_2.setChecked(false);
                    seven_neprav_3.setChecked(false);
                } else {
                    check_7.setVisibility(View.INVISIBLE);
                }
            }
        });
        seven_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_neprav_2.isChecked()) {
                    check_7.setVisibility(View.VISIBLE);
                    seven_neprav.setChecked(false);
                    seven_neprav_3.setChecked(false);
                    seven_prav.setChecked(false);
                } else {
                    check_7.setVisibility(View.INVISIBLE);
                }
            }
        });
        seven_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_neprav_3.isChecked()) {
                    check_7.setVisibility(View.VISIBLE);
                    seven_neprav.setChecked(false);
                    seven_neprav_2.setChecked(false);
                    seven_prav.setChecked(false);
                } else {
                    check_7.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seven_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton eight_prav = findViewById(R.id.eight_prav);
        RadioButton eight_neprav = findViewById(R.id.eight_neprav);
        RadioButton eight_neprav_2 = findViewById(R.id.eight_neprav_2);
        RadioButton eight_neprav_3 = findViewById(R.id.eight_neprav_3);
        Button check_8 = findViewById(R.id.check_8);
        eight_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_prav.isChecked()) {
                    check_8.setVisibility(View.VISIBLE);
                    eight_neprav.setChecked(false);
                    eight_neprav_2.setChecked(false);
                    eight_neprav_3.setChecked(false);
                } else {
                    check_8.setVisibility(View.INVISIBLE);
                }
            }
        });
        eight_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_neprav.isChecked()) {
                    check_8.setVisibility(View.VISIBLE);
                    eight_prav.setChecked(false);
                    eight_neprav_2.setChecked(false);
                    eight_neprav_3.setChecked(false);
                } else {
                    check_8.setVisibility(View.INVISIBLE);
                }
            }
        });
        eight_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_neprav_2.isChecked()) {
                    check_8.setVisibility(View.VISIBLE);
                    eight_neprav.setChecked(false);
                    eight_neprav_3.setChecked(false);
                    eight_prav.setChecked(false);
                } else {
                    check_8.setVisibility(View.INVISIBLE);
                }
            }
        });
        eight_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_neprav_3.isChecked()) {
                    check_8.setVisibility(View.VISIBLE);
                    eight_neprav.setChecked(false);
                    eight_neprav_2.setChecked(false);
                    eight_prav.setChecked(false);
                } else {
                    check_8.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eight_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton nine_prav = findViewById(R.id.nine_prav);
        RadioButton nine_neprav = findViewById(R.id.nine_neprav);
        RadioButton nine_neprav_2 = findViewById(R.id.nine_neprav_2);
        RadioButton nine_neprav_3 = findViewById(R.id.nine_neprav_3);
        Button check_9 = findViewById(R.id.check_9);
        nine_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_prav.isChecked()) {
                    check_9.setVisibility(View.VISIBLE);
                    nine_neprav.setChecked(false);
                    nine_neprav_2.setChecked(false);
                    nine_neprav_3.setChecked(false);
                } else {
                    check_9.setVisibility(View.INVISIBLE);
                }
            }
        });
        nine_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_neprav.isChecked()) {
                    check_9.setVisibility(View.VISIBLE);
                    nine_prav.setChecked(false);
                    nine_neprav_2.setChecked(false);
                    nine_neprav_3.setChecked(false);
                } else {
                    check_9.setVisibility(View.INVISIBLE);
                }
            }
        });
        nine_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_neprav_2.isChecked()) {
                    check_9.setVisibility(View.VISIBLE);
                    nine_neprav.setChecked(false);
                    nine_neprav_3.setChecked(false);
                    nine_prav.setChecked(false);
                } else {
                    check_9.setVisibility(View.INVISIBLE);
                }
            }
        });
        nine_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_neprav_3.isChecked()) {
                    check_9.setVisibility(View.VISIBLE);
                    nine_neprav.setChecked(false);
                    nine_neprav_2.setChecked(false);
                    nine_prav.setChecked(false);
                } else {
                    check_9.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine_prav.isChecked()) {
                    Schet.plussa();
                }
                SwipeRight();
            }
        });
        RadioButton ten_prav = findViewById(R.id.ten_prav);
        RadioButton ten_neprav = findViewById(R.id.ten_neprav);
        RadioButton ten_neprav_2 = findViewById(R.id.ten_neprav_2);
        RadioButton ten_neprav_3 = findViewById(R.id.ten_neprav_3);
        Button check_10 = findViewById(R.id.check_10);
        ten_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_prav.isChecked()) {
                    check_10.setVisibility(View.VISIBLE);
                    ten_neprav.setChecked(false);
                    ten_neprav_2.setChecked(false);
                    ten_neprav_3.setChecked(false);
                } else {
                    check_10.setVisibility(View.INVISIBLE);
                }
            }
        });
        ten_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_neprav.isChecked()) {
                    check_10.setVisibility(View.VISIBLE);
                    ten_prav.setChecked(false);
                    ten_neprav_2.setChecked(false);
                    ten_neprav_3.setChecked(false);
                } else {
                    check_10.setVisibility(View.INVISIBLE);
                }
            }
        });
        ten_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_neprav_2.isChecked()) {
                    check_10.setVisibility(View.VISIBLE);
                    ten_neprav.setChecked(false);
                    ten_neprav_3.setChecked(false);
                    ten_prav.setChecked(false);
                } else {
                    check_10.setVisibility(View.INVISIBLE);
                }
            }
        });
        ten_neprav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_neprav_3.isChecked()) {
                    check_10.setVisibility(View.VISIBLE);
                    ten_neprav.setChecked(false);
                    ten_neprav_2.setChecked(false);
                    ten_prav.setChecked(false);
                } else {
                    check_10.setVisibility(View.INVISIBLE);
                }
            }
        });
        check_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ten_prav.isChecked()) {
                    Schet.plussa();
                }
                startActivity(new Intent(FirstHardQuizActivity.this, ResultHardQuizActivity.class));
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