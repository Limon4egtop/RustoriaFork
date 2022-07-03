package com.quizes.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import com.utilitaryClasses.Count;
import com.kutakoff.QuizActivity;
import com.kutakoff.R;
import com.quizes.ResultQuizActivity;

import static com.utilitaryClasses.MainMethodsClass.*;

public class MainEasyQuizActivity extends AppCompatActivity {

    ViewFlipper flipper;
    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.activity_main_easy_quiz);
        flipper = findViewById(R.id.viewflipper);
        ImageView start_quiz = findViewById(R.id.start_quiz);
        ImageView button_back = findViewById(R.id.button_back);

        RadioButton firstCorrect = findViewById(R.id.first_prav);
        RadioButton firstIncorrect_1 = findViewById(R.id.first_neprav);
        RadioButton firstIncorrect_2 = findViewById(R.id.first_neprav_2);
        ImageView firstCheck = findViewById(R.id.check);
        ImageView firstButtonNext = findViewById(R.id.firstNext);

        RadioButton secondCorrect = findViewById(R.id.second_prav);
        RadioButton secondIncorrect_1 = findViewById(R.id.second_neprav);
        RadioButton secondIncorrect_2 = findViewById(R.id.second_neprav_2);
        ImageView secondCheck = findViewById(R.id.check_2);
        ImageView secondButtonNext = findViewById(R.id.secondNext);

        RadioButton thirdCorrect = findViewById(R.id.third_prav);
        RadioButton thirdIncorrect_1 = findViewById(R.id.third_neprav);
        RadioButton thirdIncorrect_2 = findViewById(R.id.third_neprav_2);
        ImageView thirdCheck = findViewById(R.id.check_3);
        ImageView thirdButtonNext = findViewById(R.id.thirdNext);

        RadioButton fourthCorrect = findViewById(R.id.fourth_prav);
        RadioButton fourthIncorrect_1 = findViewById(R.id.fourth_neprav);
        RadioButton fourthIncorrect_2 = findViewById(R.id.fourth_neprav_2);
        ImageView fourthCheck = findViewById(R.id.check_4);
        ImageView fourthButtonNext = findViewById(R.id.fourthNext);

        RadioButton fifthCorrect = findViewById(R.id.five_prav);
        RadioButton fifthIncorrect_1 = findViewById(R.id.five_neprav);
        RadioButton fifthIncorrect_2 = findViewById(R.id.five_neprav_2);
        ImageView fifthCheck = findViewById(R.id.check_5);
        ImageView fifthButtonNext = findViewById(R.id.fifthNext);

        Count.isHardQuiz = false;

        start_quiz.setOnClickListener(v -> SwipeRight());
        button_back.setOnClickListener(v -> startActivity(new Intent(MainEasyQuizActivity.this, QuizActivity.class)));

        addQuestion(firstCorrect, firstIncorrect_1, firstIncorrect_2, firstCheck, firstButtonNext);
        addQuestion(secondCorrect, secondIncorrect_1, secondIncorrect_2, secondCheck, secondButtonNext);
        addQuestion(thirdCorrect, thirdIncorrect_1, thirdIncorrect_2, thirdCheck, thirdButtonNext);
        addQuestion(fourthCorrect, fourthIncorrect_1, fourthIncorrect_2, fourthCheck, fourthButtonNext);
        addQuestion(fifthCorrect, fifthIncorrect_1, fifthIncorrect_2, fifthCheck, fifthButtonNext);

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
    private void addQuestion(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, ImageView check, ImageView button_next) {
        correct.setOnClickListener(v -> is3Checked(correct, check, button_next, incorrect_1, incorrect_2));
        incorrect_1.setOnClickListener(v -> is3Checked(incorrect_1, check, button_next, correct, incorrect_2));
        incorrect_2.setOnClickListener(v -> is3Checked(incorrect_2, check, button_next, incorrect_1, correct));
        check.setOnClickListener(v -> check(correct, incorrect_1, incorrect_2, check, button_next));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void check(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, ImageView check, ImageView button_next) {
        if (correct.isChecked()) {
            Count.plussa();
            change3TextColor(incorrect_1, incorrect_2);
            correct.setBackgroundColor(Color.GREEN);
        } else if (incorrect_1.isChecked()) {
            incorrect_1.setBackgroundColor(Color.RED);
            change3TextColor(correct, incorrect_2);
        } else {
            incorrect_2.setBackgroundColor(Color.RED);
            change3TextColor(correct, incorrect_1);
        }
        check.setVisibility(View.INVISIBLE);
        button_next.setVisibility(View.VISIBLE);
        button_next.setOnClickListener(v1 -> {
            Count.count++;
            if (Count.count == 5) {
                startActivity(new Intent(MainEasyQuizActivity.this, ResultQuizActivity.class));
                Count.count = 0;
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
                    Count.count = 0;
                    Count.a = 0;
                    startActivity(new Intent(MainEasyQuizActivity.this, QuizActivity.class));
                })
                .setNegativeButton("Нет", null)
                .show();
    }
}