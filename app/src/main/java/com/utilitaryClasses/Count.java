package com.utilitaryClasses;

public class Count {

    public static int countOfSkipQuestions = 0;
    public static int correctAnswers = 0;
    public static boolean isHardQuiz = false;
    public static boolean isSpecialQUiz = false;

    public static void plusOneCorrectAnswer() {
        correctAnswers++;
    }

    public static int getCorrectAnswers() {
        return correctAnswers;
    }
}