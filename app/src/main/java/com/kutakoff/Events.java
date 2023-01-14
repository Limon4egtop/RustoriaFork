package com.kutakoff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Events extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_events);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_quizzes:
                        Intent intentQ = new Intent(Events.this, MainBottomNavigationActivity.class);
                        intentQ.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentQ);
                        return true;
                    case R.id.navigation_deyatels:
                        Intent intentD = new Intent(Events.this, Deyatels.class);
                        intentD.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentD);
                        return true;
                    case R.id.navigation_events:
                        return true;
                }
                return false;
            }
        });
    }
}