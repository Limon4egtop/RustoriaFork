package com.kutakoff;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
                case "Александр III":
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
                case "Лжедмитрий II":
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
                case "Александр I":
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
                case "Пётр I":
                    url = "file:///android_asset/Petr_first.html";
                    break;
                case "Михаил Федорович":
                    url = "file:///android_asset/Michail_Fedorovich.html";
                    break;
                case "Алексей Михайлович":
                    url = "file:///android_asset/Alexey_Michailovich.html";
                    break;
                case "Борис Годунов":
                    url = "file:///android_asset/Boris_Godunov.html";
                    break;
                case "Лжедмитрий I":
                    url = "file:///android_asset/Lzhedmitriy1.html";
                    break;
                case "Василий IV":
                    url = "file:///android_asset/Vasiliy4.html";
                    break;
                case "Федор III":
                    url = "file:///android_asset/Fedor3.html";
                    break;
                case "Федор I":
                    url = "file:///android_asset/Fedor1.html";
                    break;
                case "Филарет":
                    url = "file:///android_asset/Philaret.html";
                    break;
                case "Василий Голицын":
                    url = "file:///android_asset/Vasiliy_Golicin.html";
                    break;
                case "Ордин-Нащокин":
                    url = "file:///android_asset/Ordin-Nashekin.html";
                    break;
                case "Сталинградская битва":
                    url = "file:///android_asset/Stalingradskaya_bitva.html";
                    break;
                case "Михаил Шеин":
                    url = "file:///android_asset/Michail_Shein.html";
                    break;
                case "Дмитрий Пожарский":
                    url = "file:///android_asset/Dmitriy_Pozharskiy.html";
                    break;
                case "Малюта Скуратов":
                    url = "file:///android_asset/Maluta_Skuratov.html";
                    break;
                case "Григорий Отрепьев":
                    url = "file:///android_asset/Grigoriy_Otrepiev.html";
                    break;
                case "Борис Шереметев":
                    url = "file:///android_asset/Boris_Sheremetiev.html";
                    break;
                case "Владислав IV":
                    url = "file:///android_asset/Vladislav_4.html";
                    break;
                case "Поход Игоря Святославовича на половцев":
                    url = "file:///android_asset/poxod_Igora_Svyatoslavovicha.html";
                    break;
                case "Судебник Ивана III":
                    url = "file:///android_asset/Sudebnik_ivana3.html";
                    break;
                case "Битва на Калке":
                    url = "file:///android_asset/Bitva_na_kalke.html";
                    break;
                case "Битва под Галичем":
                    url = "file:///android_asset/Bitva_pod_galichem.html";
                    break;
                case "Невская битва":
                    url = "file:///android_asset/Nevskaya_bitva.html";
                    break;
                case "Ледовое побоище":
                    url = "file:///android_asset/Ledovoe_poboishe.html";
                    break;
                case "Нашествие Батыя":
                    url = "file:///android_asset/Nashestvie_batiya.html";
                    break;
                case "Долобский съезд":
                    url = "file:///android_asset/Dolobskiy_siezd.html";
                    break;
                case "Основание Москвы":
                    url = "file:///android_asset/Osnovanie_moskvi.html";
                    break;
                case "Киевский поход 1169 года":
                    url = "file:///android_asset/Kievskiy_poxod_1169.html";
                    break;
                case "Раковорская битва":
                    url = "file:///android_asset/Rakovorskaya_bitva.html";
                    break;
                case "Битва на реке Сутени":
                    url = "file:///android_asset/Bitva_na_reke_suteni.html";
                    break;
                case "Салницкая битва":
                    url = "file:///android_asset/Salnickaya_bitva.html";
                    break;
                case "Киевское восстание 1113 года":
                    url = "file:///android_asset/Kievskoe_vosstanie_1113.html";
                    break;
                case "Липицкая битва":
                    url = "file:///android_asset/Lipeckaya_bitva.html";
                    break;
                case "Междоусобная война в Северо-Восточной Руси (1281—1293)":
                    url = "file:///android_asset/Mejdousobnaya_voina_1281_1293.html";
                    break;
                case "Нашествие Едигея":
                    url = "file:///android_asset/Nashestvie_edigeya.html";
                    break;
                case "Шелонская битва(входит в Московско-новгородскую войну)":
                    url = "file:///android_asset/Shelonskaya_bitva.html";
                    break;
                case "Московско-новгородская война (1471)":
                    url = "file:///android_asset/Moskovsko_novgorodskaya_voina.html";
                    break;
                case "Стояние на реке Угре":
                    url = "file:///android_asset/Stoyanie_na_ugre.html";
                    break;
                case "Битва на реке Судоме":
                    url = "file:///android_asset/Bitva_na_sudome.html";
                    break;
                case "Сражение при Листвене":
                    url = "file:///android_asset/Srajenie_pri_listvene.html";
                    break;
                case "Битва на Нежатиной Ниве":
                    url = "file:///android_asset/Bitva_na_nejatinoy_nive.html";
                    break;
                case "Битва на реке Суле":
                    url = "file:///android_asset/Bitva_na_sule.html";
                    break;
                case "Полоцкий поход Мстислава Великого (1127)":
                    url = "file:///android_asset/Polockiy_poxod_mstislava_velikogo.html";
                    break;
                case "Взятие Рязани Батыем":
                    url = "file:///android_asset/Vzyatie_ryazani_batiem.html";
                    break;
                case "Неврюева рать":
                    url = "file:///android_asset/Nevrueva_rat.html";
                    break;
                case "Оборона Киева 1240 года":
                    url = "file:///android_asset/Oborona_kieva_1240.html";
                    break;
                case "Тверское восстание 1327 года":
                    url = "file:///android_asset/Tverskoe_vosstanie_1327.html";
                    break;
                case "Сражение на реке Пьяне":
                    url = "file:///android_asset/Srajenie_na_piane.html";
                    break;
                case "Нашествие Тохтамыша на Москву(1382)":
                    url = "file:///android_asset/Nashestvie_taxtamisha_1382.html";
                    break;
                case "Московско-новгородская война (1477—1478)":
                    url = "file:///android_asset/Moskovsko_novgorodskaya_voina_1477_1478.html";
                    break;
                case "Битва на реке Ведрошь":
                    url = "file:///android_asset/Bitva_na_vedrosh.html";
                    break;
                case "Ливонская война (1558-1583)":
                    url = "file:///android_asset/Livonskaya_bitva.html";
                    break;
                case "Битва при Молодях":
                    url = "file:///android_asset/Bitva_pri_molodyax.html";
                    break;
                case "Плюсское перемирие":
                    url = "file:///android_asset/Plusskoe_peremirie.html";
                    break;
                case "Восстание Болотникова":
                    url = "file:///android_asset/Vosstanie_bolotnikova.html";
                    break;
                case "Битва при Клушине":
                    url = "file:///android_asset/Bitva_pri_klushine.html";
                    break;
                case "Смоленская война":
                    url = "file:///android_asset/Smolenskaya_voina.html";
                    break;
                case "Прутский поход":
                    url = "file:///android_asset/Prutskiy_poxod.html";
                    break;
                case "Отечественная война (1812)":
                    url = "file:///android_asset/Otechestvennaya_voina_1812.html";
                    break;
                case "Русско-персидская война (1826—1828)":
                    url = "file:///android_asset/Russko_persidskaya_voina.html";
                    break;
                case "Битва при Лесной":
                    url = "file:///android_asset/Battle_of_Lesnaya.html";
                    break;
                case "Полтавская битва":
                    url = "file:///android_asset/Poltavskaya_battle.html";
                    break;
                case "Гангутское сражение":
                    url = "file:///android_asset/Battle_of_Gangutskaya.html";
                    break;
                case "Гренгамское сражение":
                    url = "file:///android_asset/Grengamskoe_battle.html";
                    break;
                case "Битва на реке Альте":
                    url = "file:///android_asset/Battle_on_Alte.html";
                    break;
                case "Присоединение Коломны к Москве":
                    url = "file:///android_asset/Joining_Kolomna_to_Moscow.html";
                    break;
                case "Соляной бунт":
                    url = "file:///android_asset/Solt_bunt.html";
                    break;
                case "Русско-турецкая война (1735-1739)":
                    url = "file:///android_asset/Russko_tureckaya_war_1735_1739.html";
                    break;
                case "Восстание Тадеуша Костюшко":
                    url = "file:///android_asset/Vosstanie_Tadeusha_Kostushko.html";
                    break;
            }
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl(url);
        }
    }
}