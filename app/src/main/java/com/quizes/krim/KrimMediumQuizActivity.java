package com.quizes.krim;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.utilitaryClasses.Count;
import com.kutakoff.R;
import com.quizes.ResultQuizActivity;

import static com.utilitaryClasses.MainMethodsClass.*;

public class KrimMediumQuizActivity extends AppCompatActivity {

    ViewFlipper flipper;
    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_krim_medium_quiz);
        flipper = findViewById(R.id.viewflipper);
        ImageView start_quiz = findViewById(R.id.start_quiz);
        ImageView button_back = findViewById(R.id.button_back);

        RadioButton firstCorrect = findViewById(R.id.first_prav);
        RadioButton firstIncorrect_1 = findViewById(R.id.first_neprav);
        RadioButton firstIncorrect_2 = findViewById(R.id.first_neprav_2);
        RadioButton firstIncorrect_3 = findViewById(R.id.first_neprav_3);
        ImageView firstCheck = findViewById(R.id.check);
        ImageView firstButtonNext = findViewById(R.id.firstNext);

        RadioButton secondCorrect = findViewById(R.id.second_prav);
        RadioButton secondIncorrect_1 = findViewById(R.id.second_neprav);
        RadioButton secondIncorrect_2 = findViewById(R.id.second_neprav_2);
        RadioButton secondIncorrect_3 = findViewById(R.id.second_neprav_3);
        ImageView secondCheck = findViewById(R.id.check_2);
        ImageView secondButtonNext = findViewById(R.id.secondNext);

        RadioButton thirdCorrect = findViewById(R.id.third_prav);
        RadioButton thirdIncorrect_1 = findViewById(R.id.third_neprav);
        RadioButton thirdIncorrect_2 = findViewById(R.id.third_neprav_2);
        RadioButton thirdIncorrect_3 = findViewById(R.id.third_neprav_3);
        ImageView thirdCheck = findViewById(R.id.check_3);
        ImageView thirdButtonNext = findViewById(R.id.thirdNext);

        RadioButton fourthCorrect = findViewById(R.id.fourth_prav);
        RadioButton fourthIncorrect_1 = findViewById(R.id.fourth_neprav);
        RadioButton fourthIncorrect_2 = findViewById(R.id.fourth_neprav_2);
        RadioButton fourthIncorrect_3 = findViewById(R.id.fourth_neprav_3);
        ImageView fourthCheck = findViewById(R.id.check_4);
        ImageView fourthButtonNext = findViewById(R.id.fourthNext);

        RadioButton fifthCorrect = findViewById(R.id.five_prav);
        RadioButton fifthIncorrect_1 = findViewById(R.id.five_neprav);
        RadioButton fifthIncorrect_2 = findViewById(R.id.five_neprav_2);
        RadioButton fifthIncorrect_3 = findViewById(R.id.five_neprav_3);
        ImageView fifthCheck = findViewById(R.id.check_5);
        ImageView fifthButtonNext = findViewById(R.id.fifthNext);

        RadioButton sixCorrect = findViewById(R.id.six_prav);
        RadioButton sixIncorrect_1 = findViewById(R.id.six_neprav);
        RadioButton sixIncorrect_2 = findViewById(R.id.six_neprav_2);
        RadioButton sixIncorrect_3 = findViewById(R.id.six_neprav_3);
        ImageView sixCheck = findViewById(R.id.check_6);
        ImageView sixthButtonNext = findViewById(R.id.sixthNext);

        Count.isSpecialQUiz = true;

        start_quiz.setOnClickListener(v -> SwipeRight());
        button_back.setOnClickListener(v -> startActivity(new Intent(KrimMediumQuizActivity.this, KrimQuizMenu.class)));

        addQuestion(firstCorrect, firstIncorrect_1, firstIncorrect_2, firstIncorrect_3, firstCheck, firstButtonNext);
        addQuestion(secondCorrect, secondIncorrect_1, secondIncorrect_2, secondIncorrect_3, secondCheck, secondButtonNext);
        addQuestion(thirdCorrect, thirdIncorrect_1, thirdIncorrect_2, thirdIncorrect_3, thirdCheck, thirdButtonNext);
        addQuestion(fourthCorrect, fourthIncorrect_1, fourthIncorrect_2, fourthIncorrect_3, fourthCheck, fourthButtonNext);
        addQuestion(fifthCorrect, fifthIncorrect_1, fifthIncorrect_2, fifthIncorrect_3, fifthCheck, fifthButtonNext);
        addQuestion(sixCorrect, sixIncorrect_1, sixIncorrect_2, sixIncorrect_3, sixCheck, sixthButtonNext);

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addQuestion(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, RadioButton incorrect_3, ImageView check, ImageView button_next) {
        correct.setOnClickListener(v -> is4Checked(correct, check, button_next, incorrect_1, incorrect_2, incorrect_3));
        incorrect_1.setOnClickListener(v -> is4Checked(incorrect_1, check, button_next, correct, incorrect_2, incorrect_3));
        incorrect_2.setOnClickListener(v -> is4Checked(incorrect_2, check, button_next, incorrect_1, incorrect_3, correct));
        incorrect_3.setOnClickListener(v -> is4Checked(incorrect_3, check, button_next, incorrect_1, incorrect_2, correct));
        check.setOnClickListener(v -> check(correct, incorrect_1, incorrect_2, incorrect_3, check, button_next));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void check(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, RadioButton incorrect_3, ImageView check, ImageView button_next) {
        if (correct.isChecked()) {
            Count.plusOneCorrectAnswer();
            change4TextColor(incorrect_1, incorrect_2, incorrect_3);
            correct.setBackgroundColor(Color.GREEN);
        } else if (incorrect_1.isChecked()) {
            incorrect_1.setBackgroundColor(Color.RED);
            change4TextColor(correct, incorrect_2, incorrect_3);
        } else if (incorrect_2.isChecked()){
            incorrect_2.setBackgroundColor(Color.RED);
            change4TextColor(correct, incorrect_1, incorrect_3);
        } else {
            incorrect_3.setBackgroundColor(Color.RED);
            change4TextColor(correct, incorrect_1, incorrect_2);
        }
        check.setVisibility(View.INVISIBLE);
        button_next.setVisibility(View.VISIBLE);
        button_next.setOnClickListener(v1 -> {
            Count.countOfSkipQuestions++;
            if (Count.countOfSkipQuestions == 6) {
                startActivity(new Intent(KrimMediumQuizActivity.this, ResultQuizActivity.class));
                Count.countOfSkipQuestions = 0;
            } else {
                SwipeRight();
            }
        });
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите выйти из квиза? Весь прогресс будет утерян.")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> {
                    Count.countOfSkipQuestions = 0;
                    Count.correctAnswers = 0;
                    startActivity(new Intent(KrimMediumQuizActivity.this, KrimQuizMenu.class));
                })
                .setNegativeButton("Нет", null)
                .show();
    }
}