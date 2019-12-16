package com.example.discover.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.discover.R;
import com.example.discover.loginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.buttom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navLisnner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navLisnner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedfragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedfragment =  new HomeFragment();
                    break;
                case R.id.nav_favorites:
                    selectedfragment = new FavoriteFragment();
                    break;
                case R.id.nav_login:
                    selectedfragment = new loginFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedfragment).commit();
            return true;
        }
    };
}
