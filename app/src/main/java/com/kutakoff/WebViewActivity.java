package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        if (getIntent().getExtras() != null) {
            String deyatel_name = getIntent().getExtras().getString("name");
            String url = "";
            switch (deyatel_name) {
                case "Иван Грозный":
                    url = "file:///android_asset/Ivan4.html";
                    break;
                case "Куликовская битва":
                    url = "file:///android_asset/kulikovskaya.html";
                    break;
                case "Иван III":
                    url = "file:///android_asset/Ivan3.html";
                    break;
                case "Александр III Миротворец":
                    url = "file:///android_asset/Alexander3.html";
                    break;
                case "Иван Фёдоров":
                    url = "file:///android_asset/Ivan_Fedorov.html";
                    break;
                case "Георгий Жуков":
                    url = "file:///android_asset/Georgiy_Zhukov.html";
                    break;
                case "Иван I Калита":
                    url = "file:///android_asset/Ivan_Kalita.html";
                    break;
                case "Николай II":
                    url = "file:///android_asset/Nikolai2.html";
                    break;
                case "Сергий Радонежский":
                    url = "file:///android_asset/Sergiy_Radonezskiy.html";
                    break;
                case "Лжедмитрий II Тушинский вор":
                    url = "file:///android_asset/Lzhedmitriy2.html";
                    break;
                case "Никита Хрущев":
                    url = "file:///android_asset/Nikita_Xrushev.html";
                    break;
                case "Елизавета Петровна":
                    url = "file:///android_asset/Elizaveta_Petrovna.html";
                    break;
                case "Александр Невский":
                    url = "file:///android_asset/Alexander_Nevskiy.html";
                    break;
                case "Дмитрий Донской":
                    url = "file:///android_asset/Dmitriy_Donskoy.html";
                    break;
                case "Климент Ворошилов":
                    url = "file:///android_asset/Kliment_Voroshilov.html";
                    break;
                case "Нестор Летописец":
                    url = "file:///android_asset/Nestor_Letopisec.html";
                    break;
                case "Даниил Московский":
                    url = "file:///android_asset/Daniil_Moscowskiy.html";
                    break;
                case "Алексaндр I":
                    url = "file:///android_asset/Alexander1.html";
                    break;
                case "Отмена крепостного права":
                    url = "file:///android_asset/Krepost_Pravo.html";
                    break;
                case "Гражданская война 1917-1922 гг.":
                    url = "file:///android_asset/Grazhdanskaya_War.html";
                    break;
                case "Курская битва":
                    url = "file:///android_asset/Kurskaya_Bitva.html";
                    break;
                case "Битва при Красном":
                    url = "file:///android_asset/Bitva_Pri_Krasnom.html";
                    break;
                case "Холодная война":
                    url = "file:///android_asset/Cold_War.html";
                    break;
                case "Расстрел царской семьи":
                    url = "file:///android_asset/Rasstrel_Carscoy_Family.html";
                    break;
            }

            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl(url);
        }
    }
}