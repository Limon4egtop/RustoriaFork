package com.kutakoff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Deyatels extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deyatels);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_deyatels);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_quizzes:
                        Intent intentQ = new Intent(Deyatels.this, MainBottomNavigationActivity.class);
                        intentQ.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentQ);
                        return true;
                    case R.id.navigation_events:
                        Intent intentE = new Intent(Deyatels.this, Events.class);
                        intentE.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentE);
                        return true;
                    case R.id.navigation_deyatels:
                        return true;
                }
                return false;
            }
        });
    }
}