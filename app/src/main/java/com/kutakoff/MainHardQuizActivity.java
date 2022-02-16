package com.kutakoff;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;

public class MainHardQuizActivity extends AppCompatActivity {

    ViewFlipper flipper;
    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main_hard_quiz);
        flipper = findViewById(R.id.viewflipper);
        ImageView start_quiz = findViewById(R.id.start_quiz);
        ImageView button_back = findViewById(R.id.button_back);

        TextView textResult_1 = findViewById(R.id.firstTextResult);
        TextView textResult_2 = findViewById(R.id.secondTextResult);
        TextView textResult_3 = findViewById(R.id.thirdTextResult);
        TextView textResult_4 = findViewById(R.id.fourthTextResult);
        TextView textResult_5 = findViewById(R.id.fifthTextResult);
        TextView textResult_6 = findViewById(R.id.sixthTextResult);
        TextView textResult_7 = findViewById(R.id.seventhTextResult);
        TextView textResult_8 = findViewById(R.id.eightTextResult);
        TextView textResult_9 = findViewById(R.id.ninthTextResult);
        TextView textResult_10 = findViewById(R.id.tenthTextResult);

        RadioButton firstCorrect = findViewById(R.id.first_prav);
        RadioButton firstIncorrect_1 = findViewById(R.id.first_neprav);
        RadioButton firstIncorrect_2 = findViewById(R.id.first_neprav_2);
        RadioButton firstIncorrect_3 = findViewById(R.id.first_neprav_3);
        Button firstCheck = findViewById(R.id.check);
        ImageView firstButtonNext = findViewById(R.id.firstNext);

        RadioButton secondCorrect = findViewById(R.id.second_prav);
        RadioButton secondIncorrect_1 = findViewById(R.id.second_neprav);
        RadioButton secondIncorrect_2 = findViewById(R.id.second_neprav_2);
        RadioButton secondIncorrect_3 = findViewById(R.id.second_neprav_3);
        Button secondCheck = findViewById(R.id.check_2);
        ImageView secondButtonNext = findViewById(R.id.secondNext);

        RadioButton thirdCorrect = findViewById(R.id.third_prav);
        RadioButton thirdIncorrect_1 = findViewById(R.id.third_neprav);
        RadioButton thirdIncorrect_2 = findViewById(R.id.third_neprav_2);
        RadioButton thirdIncorrect_3 = findViewById(R.id.third_neprav_3);
        Button thirdCheck = findViewById(R.id.check_3);
        ImageView thirdButtonNext = findViewById(R.id.thirdNext);

        RadioButton fourthCorrect = findViewById(R.id.fourth_prav);
        RadioButton fourthIncorrect_1 = findViewById(R.id.fourth_neprav);
        RadioButton fourthIncorrect_2 = findViewById(R.id.fourth_neprav_2);
        RadioButton fourthIncorrect_3 = findViewById(R.id.fourth_neprav_3);
        Button fourthCheck = findViewById(R.id.check_4);
        ImageView fourthButtonNext = findViewById(R.id.fourthNext);

        RadioButton fifthCorrect = findViewById(R.id.five_prav);
        RadioButton fifthIncorrect_1 = findViewById(R.id.five_neprav);
        RadioButton fifthIncorrect_2 = findViewById(R.id.five_neprav_2);
        RadioButton fifthIncorrect_3 = findViewById(R.id.five_neprav_3);
        Button fifthCheck = findViewById(R.id.check_5);
        ImageView fifthButtonNext = findViewById(R.id.fifthNext);

        RadioButton sixthCorrect = findViewById(R.id.six_prav);
        RadioButton sixthIncorrect_1 = findViewById(R.id.six_neprav);
        RadioButton sixthIncorrect_2 = findViewById(R.id.six_neprav_2);
        RadioButton sixthIncorrect_3 = findViewById(R.id.six_neprav_3);
        Button sixthCheck = findViewById(R.id.check_6);
        ImageView sixthButtonNext = findViewById(R.id.sixthNext);

        RadioButton seventhCorrect = findViewById(R.id.seven_prav);
        RadioButton seventhIncorrect_1 = findViewById(R.id.seven_neprav);
        RadioButton seventhIncorrect_2 = findViewById(R.id.seven_neprav_2);
        RadioButton seventhIncorrect_3 = findViewById(R.id.seven_neprav_3);
        Button seventhCheck = findViewById(R.id.check_7);
        ImageView seventhButtonNext = findViewById(R.id.seventhNext);

        RadioButton eightCorrect = findViewById(R.id.eight_prav);
        RadioButton eightIncorrect_1 = findViewById(R.id.eight_neprav);
        RadioButton eightIncorrect_2 = findViewById(R.id.eight_neprav_2);
        RadioButton eightIncorrect_3 = findViewById(R.id.eight_neprav_3);
        Button eightCheck = findViewById(R.id.check_8);
        ImageView eightButtonNext = findViewById(R.id.eightNext);

        RadioButton ninthCorrect = findViewById(R.id.nine_prav);
        RadioButton ninthIncorrect_1 = findViewById(R.id.nine_neprav);
        RadioButton ninthIncorrect_2 = findViewById(R.id.nine_neprav_2);
        RadioButton ninthIncorrect_3 = findViewById(R.id.nine_neprav_3);
        Button ninthCheck = findViewById(R.id.check_9);
        ImageView ninthButtonNext = findViewById(R.id.ninthNext);

        RadioButton tenthCorrect = findViewById(R.id.ten_prav);
        RadioButton tenthIncorrect_1 = findViewById(R.id.ten_neprav);
        RadioButton tenthIncorrect_2 = findViewById(R.id.ten_neprav_2);
        RadioButton tenthIncorrect_3 = findViewById(R.id.ten_neprav_3);
        Button tenthCheck = findViewById(R.id.check_10);
        ImageView tenthButtonNext = findViewById(R.id.tenthNext);

        Count.isHardQuiz = true;

        start_quiz.setOnClickListener(v -> SwipeRight());
        button_back.setOnClickListener(v -> onBackPressed());

        AddQuestion(firstCorrect, firstIncorrect_1, firstIncorrect_2, firstIncorrect_3, firstCheck, firstButtonNext, textResult_1);
        AddQuestion(secondCorrect, secondIncorrect_1, secondIncorrect_2, secondIncorrect_3, secondCheck, secondButtonNext, textResult_2);
        AddQuestion(thirdCorrect, thirdIncorrect_1, thirdIncorrect_2, thirdIncorrect_3, thirdCheck, thirdButtonNext, textResult_3);
        AddQuestion(fourthCorrect, fourthIncorrect_1, fourthIncorrect_2, fourthIncorrect_3, fourthCheck, fourthButtonNext, textResult_4);
        AddQuestion(fifthCorrect, fifthIncorrect_1, fifthIncorrect_2, fifthIncorrect_3, fifthCheck, fifthButtonNext, textResult_5);
        AddQuestion(sixthCorrect, sixthIncorrect_1, sixthIncorrect_2, sixthIncorrect_3, sixthCheck, sixthButtonNext, textResult_6);
        AddQuestion(seventhCorrect, seventhIncorrect_1, seventhIncorrect_2, seventhIncorrect_3, seventhCheck, seventhButtonNext, textResult_7);
        AddQuestion(eightCorrect, eightIncorrect_1, eightIncorrect_2, eightIncorrect_3, eightCheck, eightButtonNext, textResult_8);
        AddQuestion(ninthCorrect, ninthIncorrect_1, ninthIncorrect_2, ninthIncorrect_3, ninthCheck, ninthButtonNext, textResult_9);
        AddQuestion(tenthCorrect, tenthIncorrect_1, tenthIncorrect_2, tenthIncorrect_3, tenthCheck, tenthButtonNext, textResult_10);

        animFlipInForward = AnimationUtils.loadAnimation(this, R.anim.flipin);
        animFlipOutForward = AnimationUtils.loadAnimation(this, R.anim.flipout);
        animFlipInBackward = AnimationUtils.loadAnimation(this, R.anim.flipin_reverse);
        animFlipOutBackward = AnimationUtils.loadAnimation(this, R.anim.flipout_reverse);
    }

    private void SwipeRight() {
        flipper.setInAnimation(animFlipInForward);
        flipper.setOutAnimation(animFlipOutForward);
        flipper.showNext();
    }

    private void AddQuestion(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, RadioButton incorrect_3, Button check, ImageView button_next, TextView textResult) {
        correct.setOnClickListener(v -> {
            if (correct.isChecked()) {
                if (!button_next.isShown()) {
                    check.setVisibility(View.VISIBLE);
                }
                incorrect_1.setChecked(false);
                incorrect_2.setChecked(false);
                incorrect_3.setChecked(false);
            }
        });
        incorrect_1.setOnClickListener(v -> {
            if (incorrect_1.isChecked()) {
                if (!button_next.isShown()) {
                    check.setVisibility(View.VISIBLE);
                }
                correct.setChecked(false);
                incorrect_2.setChecked(false);
                incorrect_3.setChecked(false);
            }
        });
        incorrect_2.setOnClickListener(v -> {
            if (incorrect_2.isChecked()) {
                if (!button_next.isShown()) {
                    check.setVisibility(View.VISIBLE);
                }
                incorrect_1.setChecked(false);
                incorrect_3.setChecked(false);
                correct.setChecked(false);
            }
        });
        incorrect_3.setOnClickListener(v -> {
            if (incorrect_3.isChecked()) {
                if (!button_next.isShown()) {
                    check.setVisibility(View.VISIBLE);
                }
                incorrect_1.setChecked(false);
                incorrect_2.setChecked(false);
                correct.setChecked(false);
            }
        });
        check.setOnClickListener(v -> {
            if (correct.isChecked()) {
                Count.plussa();
                textResult.setText("Правильно!");
                textResult.setTextColor(Color.GREEN);
            } else {
                textResult.setText("Не правильно!");
                textResult.setTextColor(Color.RED);
            }
            check.setVisibility(View.INVISIBLE);
            button_next.setVisibility(View.VISIBLE);
            button_next.setOnClickListener(v1 -> {
                Count.count++;
                if (Count.count == 10) {
                    startActivity(new Intent(MainHardQuizActivity.this, ResultQuizActivity.class));
                    Count.count = 1;
                } else {
                    SwipeRight();
                }
            });
        });
    }
}