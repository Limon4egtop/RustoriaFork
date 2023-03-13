package com.utilitaryClasses;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

public class MainMethodsClass {

    /**
     * Используется для смены цвета и кликабельности 3-ёх вариантов
     * ответа. Используется в квизах с 3-мя вариантами ответов.
     *
     * @param first  - первый НЕВЫБРАННЫЙ вариант
     * @param second - второй НЕВЫБРАННЫЙ вариант
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void change3TextColor(RadioButton first, RadioButton second) {
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled}, // Disabled
                        new int[]{android.R.attr.state_enabled}   // Enabled
                },
                new int[]{
                        Color.GRAY, // disabled
                        Color.WHITE   // enabled
                });
        RadioButton[] radioButtons = {first, second};
        for (RadioButton radioButton : radioButtons) {
            radioButton.setEnabled(false);
            radioButton.setTextColor(Color.GRAY);
            radioButton.setButtonTintList(colorStateList);
        }
    }


    /**
     * Используется для смены цвета и кликабельности 4-ёх вариантов
     * ответа. Используется в квизах с 4-мя вариантами ответов.
     *
     * @param first  - первый НЕВЫБРАННЫЙ вариант
     * @param second - второй НЕВЫБРАННЫЙ вариант
     * @param third  - третий НЕВЫБРАННЫЙ вариант
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void change4TextColor(RadioButton first, RadioButton second, RadioButton third) {
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled}, // Disabled
                        new int[]{android.R.attr.state_enabled}   // Enabled
                },
                new int[]{
                        Color.GRAY, // disabled
                        Color.WHITE   // enabled
                });
        RadioButton[] radioButtons = {first, second, third};
        for (RadioButton radioButton : radioButtons) {
            radioButton.setEnabled(false);
            radioButton.setTextColor(Color.GRAY);
            radioButton.setButtonTintList(colorStateList);
        }
    }


    /**
     * Убирает остальные 2 вырианта ответа, кроме выбранного.
     * Используется для квизов.
     *
     * @param choose      - выбранный варинат ответа
     * @param check       - кнопка "подтвердить"
     * @param button_next - кнопка "дальше"
     * @param first       - вариант ответа, который уберётся
     * @param second      - вариант ответа, который уберётся
     */
    public static void is3Checked(RadioButton choose, ImageView check, ImageView button_next, RadioButton first, RadioButton second) {
        if (choose.isChecked()) {
            if (!button_next.isShown()) {
                check.setVisibility(View.VISIBLE);
            }
            first.setChecked(false);
            second.setChecked(false);
        }
    }

    /**
     * Убирает остальные 3 вырианта ответа, кроме выбранного.
     * Используется для квизов.
     *
     * @param choose      - выбранный варинат ответа
     * @param check       - кнопка "подтвердить"
     * @param button_next - кнопка "дальше"
     * @param first       - вариант ответа, который уберётся
     * @param second      - вариант ответа, который уберётся
     * @param third       - вариант ответа, который уберётся
     */
    public static void is4Checked(RadioButton choose, ImageView check, ImageView button_next, RadioButton first, RadioButton second, RadioButton third) {
        if (choose.isChecked()) {
            if (!button_next.isShown()) {
                check.setVisibility(View.VISIBLE);
            }
            first.setChecked(false);
            second.setChecked(false);
            third.setChecked(false);
        }
    }

    /**
     * Ставит видимость ListView при выборе подразделов.
     * Используется в списках деятелей/событий
     *
     * @param mass - массив всех ListView
     * @param num  - номер массива, которы будет VISIBLE.
     */
    public static void visibilityListItems(ListView[] mass, int num) {
        for (int i = 0; i < mass.length; i++) {
            if (i != num) {
                mass[i].setVisibility(View.INVISIBLE);
            } else {
                mass[num].setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * МЕТОД ТОЛЬКО ДЛЯ КЛАССОВ: Quizzes, Events, Deyatels
     * Даёт размёр для CardView нижней панели
     * @param displayMetrics - Размер экрана
     * @param cardView - кардвью, который будет изменён
     */
    public static void setBottomPanelSize(DisplayMetrics displayMetrics, CardView cardView, ImageView imageView) {
        ViewGroup.LayoutParams cardViewParams = cardView.getLayoutParams();
        ViewGroup.LayoutParams imageViewParams = imageView.getLayoutParams();
        int universalParam = displayMetrics.widthPixels / 7;
        cardViewParams.height = universalParam;
        cardViewParams.width = universalParam;
        imageViewParams.height = universalParam;
        imageViewParams.width = universalParam;
    }

    /**
     * Метод позваляет задать размёр изображению с кнопкой в зависимости от экорана.
     * @param displayMetrics - рахмер экрана
     * @param imageView - картинка, которая будет изменена
     */
    public static void setImageViewSize(ImageView imageView, DisplayMetrics displayMetrics) {
        ViewGroup.LayoutParams imageViewParams = imageView.getLayoutParams();
        int universalParam = displayMetrics.widthPixels / 3;
        imageViewParams.width = universalParam;
        imageViewParams.height = universalParam;

    }
}
