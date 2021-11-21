package com.kutakoff;


import androidx.appcompat.app.AppCompatActivity;
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

public class FirstQuizActivity extends AppCompatActivity {

    ViewFlipper flipper;
    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_first_quiz);
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
        Button check = findViewById(R.id.check);
        TextView firstTextResult = findViewById(R.id.firstTextResult);
        ImageView firstNext = findViewById(R.id.firstNext);
        first_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_prav.isChecked()) {
                    if (Schet.firstQuiz == 0) {
                        check.setVisibility(View.VISIBLE);
                    }
                    first_neprav.setChecked(false);
                    first_neprav_2.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        first_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_neprav.isChecked()) {
                    if (Schet.firstQuiz == 0) {
                        check.setVisibility(View.VISIBLE);
                    }
                    first_prav.setChecked(false);
                    first_neprav_2.setChecked(false);
                } else {
                    check.setVisibility(View.INVISIBLE);
                }
            }
        });
        first_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_neprav_2.isChecked()) {
                    if (Schet.firstQuiz == 0) {
                        check.setVisibility(View.VISIBLE);
                    }
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
                    firstTextResult.setTextColor(Color.GREEN);
                    firstTextResult.setText("Правильно!");
                } else {
                    Schet.setFirst();
                    firstTextResult.setTextColor(Color.RED);
                    firstTextResult.setText("Не правильно!");
                }
                Schet.setFirstQuiz();
                check.setVisibility(View.INVISIBLE);
                firstNext.setVisibility(View.VISIBLE);
                firstNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Schet.firstQuiz = 0;
                        SwipeRight();
                    }
                });
            }
        });
        RadioButton second_prav = findViewById(R.id.second_prav);
        RadioButton second_neprav = findViewById(R.id.second_neprav);
        RadioButton second_neprav_2 = findViewById(R.id.second_neprav_2);
        Button check_2 = findViewById(R.id.check_2);
        TextView secondTextResult = findViewById(R.id.secondTextResult);
        ImageView secondNext = findViewById(R.id.secondNext);
        second_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_prav.isChecked()) {
                    if (Schet.secondQuiz == 0) {
                        check_2.setVisibility(View.VISIBLE);
                    }
                    second_neprav.setChecked(false);
                    second_neprav_2.setChecked(false);
                } else {
                    check_2.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav.isChecked()) {
                    if (Schet.secondQuiz == 0) {
                        check_2.setVisibility(View.VISIBLE);
                    }
                    second_prav.setChecked(false);
                    second_neprav_2.setChecked(false);
                } else {
                    check_2.setVisibility(View.INVISIBLE);
                }
            }
        });
        second_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second_neprav_2.isChecked()) {
                    if (Schet.secondQuiz == 0) {
                        check_2.setVisibility(View.VISIBLE);
                    }
                    second_neprav.setChecked(false);
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
                    secondTextResult.setTextColor(Color.GREEN);
                    secondTextResult.setText("Правильно!");
                } else {
                    Schet.setSecond();
                    secondTextResult.setTextColor(Color.RED);
                    secondTextResult.setText("Не правильно!");
                }
                Schet.setSecondQuiz();
                check_2.setVisibility(View.INVISIBLE);
                secondNext.setVisibility(View.VISIBLE);
                secondNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Schet.secondQuiz = 0;
                        SwipeRight();
                    }
                });
            }
        });
        RadioButton third_prav = findViewById(R.id.third_prav);
        RadioButton third_neprav = findViewById(R.id.third_neprav);
        RadioButton third_neprav_2 = findViewById(R.id.third_neprav_2);
        Button check_3 = findViewById(R.id.check_3);
        TextView thirdTextResult = findViewById(R.id.thirdTextResult);
        ImageView thirdNext = findViewById(R.id.thirdNext);
        third_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_prav.isChecked()) {
                    if (Schet.thirdQuiz == 0) {
                        check_3.setVisibility(View.VISIBLE);
                    }
                    third_neprav.setChecked(false);
                    third_neprav_2.setChecked(false);
                } else {
                    check_3.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav.isChecked()) {
                    if (Schet.thirdQuiz == 0) {
                        check_3.setVisibility(View.VISIBLE);
                    }
                    third_prav.setChecked(false);
                    third_neprav_2.setChecked(false);
                } else {
                    check_3.setVisibility(View.INVISIBLE);
                }
            }
        });
        third_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (third_neprav_2.isChecked()) {
                    if (Schet.thirdQuiz == 0) {
                        check_3.setVisibility(View.VISIBLE);
                    }
                    third_neprav.setChecked(false);
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
                    thirdTextResult.setTextColor(Color.GREEN);
                    thirdTextResult.setText("Правильно!");
                } else {
                    Schet.setThird();
                    thirdTextResult.setTextColor(Color.RED);
                    thirdTextResult.setText("Не правильно!");
                }
                Schet.setThirdQuiz();
                check_3.setVisibility(View.INVISIBLE);
                thirdNext.setVisibility(View.VISIBLE);
                thirdNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Schet.thirdQuiz = 0;
                        SwipeRight();
                    }
                });
            }
        });
        RadioButton fourth_prav = findViewById(R.id.fourth_prav);
        RadioButton fourth_neprav = findViewById(R.id.fourth_neprav);
        RadioButton fourth_neprav_2 = findViewById(R.id.fourth_neprav_2);
        Button check_4 = findViewById(R.id.check_4);
        TextView fourthTextResult = findViewById(R.id.fourthTextResult);
        ImageView fourthNext = findViewById(R.id.fourthNext);
        fourth_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_prav.isChecked()) {
                    if (Schet.fourthQuiz == 0) {
                        check_4.setVisibility(View.VISIBLE);
                    }
                    fourth_neprav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                } else {
                    check_4.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav.isChecked()) {
                    if (Schet.fourthQuiz == 0) {
                        check_4.setVisibility(View.VISIBLE);
                    }
                    fourth_prav.setChecked(false);
                    fourth_neprav_2.setChecked(false);
                } else {
                    check_4.setVisibility(View.INVISIBLE);
                }
            }
        });
        fourth_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fourth_neprav_2.isChecked()) {
                    if (Schet.fourthQuiz == 0) {
                        check_4.setVisibility(View.VISIBLE);
                    }
                    fourth_neprav.setChecked(false);
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
                    fourthTextResult.setTextColor(Color.GREEN);
                    fourthTextResult.setText("Правильно!");
                } else {
                    Schet.setFourth();
                    fourthTextResult.setTextColor(Color.RED);
                    fourthTextResult.setText("Не правильно!");
                }
                Schet.setFourthQuiz();
                check_4.setVisibility(View.INVISIBLE);
                fourthNext.setVisibility(View.VISIBLE);
                fourthNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Schet.fourthQuiz = 0;
                        SwipeRight();
                    }
                });
            }
        });
        RadioButton five_prav = findViewById(R.id.five_prav);
        RadioButton five_neprav = findViewById(R.id.five_neprav);
        RadioButton five_neprav_2 = findViewById(R.id.five_neprav_2);
        Button check_5 = findViewById(R.id.check_5);
        TextView fifthTextResult = findViewById(R.id.fifthTextResult);
        ImageView fifthNext = findViewById(R.id.fifthNext);
        five_prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_prav.isChecked()) {
                    if (Schet.fifthQuiz == 0) {
                        check_5.setVisibility(View.VISIBLE);
                    }
                    five_neprav.setChecked(false);
                    five_neprav_2.setChecked(false);
                } else {
                    check_5.setVisibility(View.INVISIBLE);
                }
            }
        });
        five_neprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_neprav.isChecked()) {
                    if (Schet.fifthQuiz == 0) {
                        check_5.setVisibility(View.VISIBLE);
                    }
                    five_prav.setChecked(false);
                    five_neprav_2.setChecked(false);
                } else {
                    check_5.setVisibility(View.INVISIBLE);
                }
            }
        });
        five_neprav_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five_neprav_2.isChecked()) {
                    if (Schet.fifthQuiz == 0) {
                        check_5.setVisibility(View.VISIBLE);
                    }
                    five_neprav.setChecked(false);
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
                    fifthTextResult.setTextColor(Color.GREEN);
                    fifthTextResult.setText("Правильно!");
                } else {
                    Schet.setFifth();
                    fifthTextResult.setTextColor(Color.RED);
                    fifthTextResult.setText("Не правильно!");
                }
                Schet.setFifthQuiz();
                check_5.setVisibility(View.INVISIBLE);
                fifthNext.setVisibility(View.VISIBLE);
                fifthNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Schet.fifthQuiz = 0;
                        startActivity(new Intent(FirstQuizActivity.this, ResultQuizActivity.class));
                    }
                });
            }
        });
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
}