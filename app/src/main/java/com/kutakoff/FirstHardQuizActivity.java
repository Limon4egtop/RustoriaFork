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