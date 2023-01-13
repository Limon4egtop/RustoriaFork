package com.quizes.borodinskoeSrajenie;

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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

import com.kutakoff.ChooseQuizActivity;
import com.kutakoff.R;
import com.utilitaryClasses.Count;
import com.utilitaryClasses.WebViewActivity;
import com.quizes.ResultQuizActivity;

import java.util.ArrayList;

import static com.utilitaryClasses.MainMethodsClass.*;

public class BorodinskoeSrajenieActivityQuiz extends AppCompatActivity {

    ViewFlipper flipper;
    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;
    ArrayAdapter adapterInfo;
    ImageView button_back;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_borodinskoe_srajenie_quiz);
        flipper = findViewById(R.id.viewflipper);

        RadioButton firstCorrect = findViewById(R.id.first_prav);
        RadioButton firstIncorrect_1 = findViewById(R.id.first_neprav);
        RadioButton firstIncorrect_2 = findViewById(R.id.first_neprav_2);
        RadioButton firstIncorrect_3 = findViewById(R.id.first_neprav_3);
        button_back = findViewById(R.id.button_back);
        ImageView firstCheck = findViewById(R.id.check);
        ImageView firstButtonNext = findViewById(R.id.firstNext);
        ListView info1 = findViewById(R.id.info1);

        RadioButton secondCorrect = findViewById(R.id.second_prav);
        RadioButton secondIncorrect_1 = findViewById(R.id.second_neprav);
        RadioButton secondIncorrect_2 = findViewById(R.id.second_neprav_2);
        RadioButton secondIncorrect_3 = findViewById(R.id.second_neprav_3);
        ImageView secondCheck = findViewById(R.id.check_2);
        ImageView secondButtonNext = findViewById(R.id.secondNext);
        ListView info2 = findViewById(R.id.info2);

        RadioButton thirdCorrect = findViewById(R.id.third_prav);
        RadioButton thirdIncorrect_1 = findViewById(R.id.third_neprav);
        RadioButton thirdIncorrect_2 = findViewById(R.id.third_neprav_2);
        RadioButton thirdIncorrect_3 = findViewById(R.id.third_neprav_3);
        ImageView thirdCheck = findViewById(R.id.check_3);
        ImageView thirdButtonNext = findViewById(R.id.thirdNext);
        ListView info3 = findViewById(R.id.info3);

        RadioButton fourthCorrect = findViewById(R.id.fourth_prav);
        RadioButton fourthIncorrect_1 = findViewById(R.id.fourth_neprav);
        RadioButton fourthIncorrect_2 = findViewById(R.id.fourth_neprav_2);
        RadioButton fourthIncorrect_3 = findViewById(R.id.fourth_neprav_3);
        ImageView fourthCheck = findViewById(R.id.check_4);
        ImageView fourthButtonNext = findViewById(R.id.fourthNext);
        ListView info4 = findViewById(R.id.info4);

        RadioButton fifthCorrect = findViewById(R.id.five_prav);
        RadioButton fifthIncorrect_1 = findViewById(R.id.five_neprav);
        RadioButton fifthIncorrect_2 = findViewById(R.id.five_neprav_2);
        RadioButton fifthIncorrect_3 = findViewById(R.id.five_neprav_3);
        ImageView fifthCheck = findViewById(R.id.check_5);
        ImageView fifthButtonNext = findViewById(R.id.fifthNext);
        ListView info5 = findViewById(R.id.info5);

        RadioButton sixthCorrect = findViewById(R.id.six_prav);
        RadioButton sixthIncorrect_1 = findViewById(R.id.six_neprav);
        RadioButton sixthIncorrect_2 = findViewById(R.id.six_neprav_2);
        RadioButton sixthIncorrect_3 = findViewById(R.id.six_neprav_3);
        ImageView sixthCheck = findViewById(R.id.check_6);
        ImageView sixthButtonNext = findViewById(R.id.sixthNext);
        ListView info6 = findViewById(R.id.info6);

        RadioButton seventhCorrect = findViewById(R.id.seven_prav);
        RadioButton seventhIncorrect_1 = findViewById(R.id.seven_neprav);
        RadioButton seventhIncorrect_2 = findViewById(R.id.seven_neprav_2);
        RadioButton seventhIncorrect_3 = findViewById(R.id.seven_neprav_3);
        ImageView seventhCheck = findViewById(R.id.check_7);
        ImageView seventhButtonNext = findViewById(R.id.seventhNext);
        ListView info7 = findViewById(R.id.info7);

        RadioButton eightCorrect = findViewById(R.id.eight_prav);
        RadioButton eightIncorrect_1 = findViewById(R.id.eight_neprav);
        RadioButton eightIncorrect_2 = findViewById(R.id.eight_neprav_2);
        RadioButton eightIncorrect_3 = findViewById(R.id.eight_neprav_3);
        ImageView eightCheck = findViewById(R.id.check_8);
        ImageView eightButtonNext = findViewById(R.id.eightNext);
        ListView info8 = findViewById(R.id.info8);

        RadioButton ninthCorrect = findViewById(R.id.nine_prav);
        RadioButton ninthIncorrect_1 = findViewById(R.id.nine_neprav);
        RadioButton ninthIncorrect_2 = findViewById(R.id.nine_neprav_2);
        RadioButton ninthIncorrect_3 = findViewById(R.id.nine_neprav_3);
        ImageView ninthCheck = findViewById(R.id.check_9);
        ImageView ninthButtonNext = findViewById(R.id.ninthNext);
        ListView info9 = findViewById(R.id.info9);

        RadioButton tenthCorrect = findViewById(R.id.ten_prav);
        RadioButton tenthIncorrect_1 = findViewById(R.id.ten_neprav);
        RadioButton tenthIncorrect_2 = findViewById(R.id.ten_neprav_2);
        RadioButton tenthIncorrect_3 = findViewById(R.id.ten_neprav_3);
        ImageView tenthCheck = findViewById(R.id.check_10);
        ImageView tenthButtonNext = findViewById(R.id.tenthNext);
        ListView info10 = findViewById(R.id.info10);

        Count.isHardQuiz = true;

        addQuestion(firstCorrect, firstIncorrect_1, firstIncorrect_2, firstIncorrect_3, firstCheck, firstButtonNext, info1);
/*        button_back.setOnClickListener(v -> startActivity(new Intent(BorodinskoeSrajenieActivityQuiz.this, ChooseQuizActivity.class)));
        firstCheck.setOnClickListener(v -> button_back.setVisibility(View.INVISIBLE));*/

        addQuestion(secondCorrect, secondIncorrect_1, secondIncorrect_2, secondIncorrect_3, secondCheck, secondButtonNext, info2);
        addQuestion(thirdCorrect, thirdIncorrect_1, thirdIncorrect_2, thirdIncorrect_3, thirdCheck, thirdButtonNext, info3);
        addQuestion(fourthCorrect, fourthIncorrect_1, fourthIncorrect_2, fourthIncorrect_3, fourthCheck, fourthButtonNext, info4);
        addQuestion(fifthCorrect, fifthIncorrect_1, fifthIncorrect_2, fifthIncorrect_3, fifthCheck, fifthButtonNext, info5);
        addQuestion(sixthCorrect, sixthIncorrect_1, sixthIncorrect_2, sixthIncorrect_3, sixthCheck, sixthButtonNext, info6);
        addQuestion(seventhCorrect, seventhIncorrect_1, seventhIncorrect_2, seventhIncorrect_3, seventhCheck, seventhButtonNext, info7);
        addQuestion(eightCorrect, eightIncorrect_1, eightIncorrect_2, eightIncorrect_3, eightCheck, eightButtonNext, info8);
        addQuestion(ninthCorrect, ninthIncorrect_1, ninthIncorrect_2, ninthIncorrect_3, ninthCheck, ninthButtonNext, info9);
        addQuestion(tenthCorrect, tenthIncorrect_1, tenthIncorrect_2, tenthIncorrect_3, tenthCheck, tenthButtonNext, info10);

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
    private void addQuestion(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, RadioButton incorrect_3, ImageView check, ImageView button_next, ListView info) {
        correct.setOnClickListener(v -> is4Checked(correct, check, button_next, incorrect_1, incorrect_2, incorrect_3));
        incorrect_1.setOnClickListener(v -> is4Checked(incorrect_1, check, button_next, correct, incorrect_2, incorrect_3));
        incorrect_2.setOnClickListener(v -> is4Checked(incorrect_2, check, button_next, incorrect_1, incorrect_3, correct));
        incorrect_3.setOnClickListener(v -> is4Checked(incorrect_3, check, button_next, incorrect_1, incorrect_2, correct));
        check.setOnClickListener(v -> check(correct, incorrect_1, incorrect_2, incorrect_3, check, button_next, info));
        addButtonInfo(info);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void check(RadioButton correct, RadioButton incorrect_1, RadioButton incorrect_2, RadioButton incorrect_3, ImageView check, ImageView button_next, ListView info) {

        if (correct.isChecked()) {
            Count.plusOneCorrectAnswer();
            change4TextColor(incorrect_1, incorrect_2, incorrect_3);
            correct.setBackgroundColor(Color.GREEN);
        } else if (incorrect_1.isChecked()) {
            incorrect_1.setBackgroundColor(Color.RED);
            change4TextColor(correct, incorrect_2, incorrect_3);
            info.setVisibility(View.VISIBLE);
        } else if (incorrect_2.isChecked()) {
            incorrect_2.setBackgroundColor(Color.RED);
            change4TextColor(correct, incorrect_1, incorrect_3);
            info.setVisibility(View.VISIBLE);
        } else {
            incorrect_3.setBackgroundColor(Color.RED);
            change4TextColor(correct, incorrect_1, incorrect_2);
            info.setVisibility(View.VISIBLE);
        }
        check.setVisibility(View.INVISIBLE);
        button_next.setVisibility(View.VISIBLE);
        button_next.setOnClickListener(v1 -> {
            Count.countOfSkipQuestions++;
            if (Count.countOfSkipQuestions == 10) {
                startActivity(new Intent(BorodinskoeSrajenieActivityQuiz.this, ResultQuizActivity.class));
                Count.countOfSkipQuestions = 0;
            } else {
                SwipeRight();
            }
        });
    }

    private void addButtonInfo(ListView info) {
        ArrayList<String> infoList = new ArrayList<>();
        infoList.add("Бородинское сражение");
        adapterInfo = new ArrayAdapter(this, android.R.layout.simple_spinner_item, infoList);
        info.setAdapter(adapterInfo);
        info.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(position));
            Intent intent = new Intent(BorodinskoeSrajenieActivityQuiz.this, WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите выйти из квиза? Весь прогресс будет утерян.")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> {
                    Count.countOfSkipQuestions = 0;
                    Count.correctAnswers = 0;
                    startActivity(new Intent(BorodinskoeSrajenieActivityQuiz.this, ChooseQuizActivity.class));
                })
                .setNegativeButton("Нет", null)
                .show();
    }
}