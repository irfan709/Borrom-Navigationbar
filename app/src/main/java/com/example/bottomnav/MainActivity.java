package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
CoordinatorLayout coordinatorLayout;
FrameLayout container;
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = findViewById(R.id.coorlayout);
        container = findViewById(R.id.container);
        bottomNavigationView = findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int itemId = item.getItemId();
                if (itemId == R.id.home) {
                   getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                }
                else if (itemId == R.id.profile) {
                   getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
                }
                else if (itemId == R.id.settings) {
                   getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingsFragment()).commit();
                }
                return true;
            }
        });
    }
}