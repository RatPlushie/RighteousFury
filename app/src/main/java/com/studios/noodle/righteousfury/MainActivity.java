package com.studios.noodle.righteousfury;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialisation onCreate of the main activity
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialisation of the tabs
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager Pager = findViewById(R.id.viewpager);
        tabPagerAdapter Tabpageradapter = new tabPagerAdapter((getSupportFragmentManager()));
        Pager.setAdapter(Tabpageradapter);
        tabLayout.setupWithViewPager(Pager);

        // Initialisation of the navigation drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_addplayer) {

            // Placeholder WIP
            Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();

            // TODO - Add ability to add another character slot

        } else if (id == R.id.nav_char1) {

            // Placeholder WIP
            Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();

            // TODO - Add ability to select a different character

        } else if (id == R.id.nav_char2) {

            // Placeholder WIP
            Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();

            // TODO - Add ability to select a different character

        } else if (id == R.id.nav_char3) {

            // Placeholder WIP
            Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();

            // TODO - Add ability to select a different character

        } else if (id == R.id.nav_import) {

            // Placeholder WIP
            Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();

            // TODO - Add ability to import a character's data

        } else if (id == R.id.nav_export) {

            // Placeholder WIP
            Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();

            // TODO - Add ability to export a character's data

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
