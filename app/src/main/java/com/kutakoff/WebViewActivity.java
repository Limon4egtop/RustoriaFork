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
                case "Куликовская битва":
                    url = "file:///android_asset/kulikovskaya.html";
                    break;
                case "Иван Грозный":
                    url = "file:///android_asset/Ivan4.html";
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
                case "Вечный мир с Польшей":
                    url = "file:///android_asset/Beskonech_Mir_Poland.html";
                    break;
                case "Распад СССР":
                    url = "file:///android_asset/Raspad_CCCP.html";
                    break;
                case "Брусиловский прорыв":
                    url = "file:///android_asset/Brusilovskiy_Proliv.html";
                    break;
                case "Северная война":
                    url = "file:///android_asset/Severn_War.html";
                    break;
                case "Взятие Парижа":
                    url = "file:///android_asset/Vzyatie_Parizha.html";
                    break;
                case "Марш-бросок на Притштину":
                    url = "file:///android_asset/Marsh_Brosok.html";
                    break;
                case "Смутное время":
                    url = "file:///android_asset/Smutnoe_Time.html";
                    break;
                case "Берлинская наступательная операция":
                    url = "file:///android_asset/Berlinsk.html";
                    break;
                case "Любечский съезд":
                    url = "file:///android_asset/Lybenchenskiy_Sezd.html";
                    break;
                case "Нюрмбергский процесс":
                    url = "file:///android_asset/Nurnbergskiy_Process.html";
                    break;
                case "Детали":
                    url = "file:///android_asset/Moscow_Parad.html";
                    break;
                case "Рюрик":
                    url = "file:///android_asset/Rurik.html";
                    break;
                case "Олег Вещий":
                    url = "file:///android_asset/Oleg_Veschiy.html";
                    break;
                case "Игорь Ририкович":
                    url = "file:///android_asset/Igor_Rurikovich.html";
                    break;
                case "Ольга Мудрая":
                    url = "file:///android_asset/Olga_Mudray.html";
                    break;
                case "Святослав Игоревич":
                    url = "file:///android_asset/Svyatoslav_Igorevich.html";
                    break;
                case "Ярополк Святославич":
                    url = "file:///android_asset/Yaropolk_Svyatoslavich.html";
                    break;
                case "Владимир Святой(Владимир красное солнышко)":
                    url = "file:///android_asset/Vladimir_Red_Sun.html";
                    break;
                case "Святополк Окаянный":
                    url = "file:///android_asset/Svyatopolk_Okayanniy.html";
                    break;
            }
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl(url);
        }
    }
}