package com.kutakoff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        ImageView start = findViewById(R.id.start);
        start.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ChooseActivity.class)));
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите выйти из приложения?")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> finish()).setNegativeButton("Нет", null).show();
    }
}