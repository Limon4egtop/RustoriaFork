package com.kutakoff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.activity_main);
        ImageView start = findViewById(R.id.start);
        start.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ChooseActivity.class)));
    }

    public void goToPresentation(View view) {
        Intent presentationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1JNsmC20o93dHImdG71w2i2x0AUVsc-Z6OLlIw9ZwUKM/edit?usp=sharing"));
        startActivity(presentationIntent);
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите выйти из приложения?")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> finish()).setNegativeButton("Нет", null).show();
    }
}