package com.studios.noodle.righteousfury;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

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
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Initialisation of the save button on the appbar
        ImageButton saveButton = findViewById(R.id.saveImageButton);
        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // A save into the character slot will be performed when the button is pressed


                /* WILL END UP SCRAPPING THIS FOR A GLOBALLY STORED METHOD TO SAVE OVERCALLING

                // Initialisation of each tab1 input textView
                TextView charName = view.findViewById(R.id.CharacterNameEditText);
                TextView maxHPValue = view.findViewById(R.id.HPFractionMax);
                TextView currentHPValue = view.findViewById(R.id.HPFractionTop);
                TextView maxFPValue = view.findViewById(R.id.FPFractionMax);
                TextView currentFPValue = view.findViewById(R.id.FPFractionTop);
                TextView wsValue = view.findViewById(R.id.WSStatValue);
                TextView bsValue = view.findViewById(R.id.BSStatValue);
                TextView strValue = view.findViewById(R.id.STRStatValue);
                TextView tValue = view.findViewById(R.id.TStatValue);
                TextView agValue = view.findViewById(R.id.AGStatValue);
                TextView intValue = view.findViewById(R.id.INTStatValue);
                TextView perValue = view.findViewById(R.id.PERStatValue);
                TextView wpValue = view.findViewById(R.id.WPStatValue);
                TextView felValue = view.findViewById(R.id.FELStatValue);

                // Parsing all relevant save data into their appropriate formats
                // Character Name
                String string_charName = charName.getText().toString();

                // Max Health Point Value
                String string_maxHPValue = maxHPValue.getText().toString();
                int int_maxHPValue = Integer.parseInt(string_maxHPValue);

                // Current Fate Point Value
                String string_currentHPValue = currentHPValue.getText().toString();
                int int_currentHPValue = Integer.parseInt(string_currentHPValue);

                // Max Fate Point Value
                String string_maxFPValue = maxFPValue.getText().toString();
                int int_maxFPValue = Integer.parseInt(string_maxFPValue);

                // Current Fate Point Value
                String string_currentFPValue = currentFPValue.getText().toString();
                int int_currentFPValue = Integer.parseInt(string_currentFPValue);

                // Weapon Skill Value
                String string_wsValue = wsValue.getText().toString();
                int int_wsValue = Integer.parseInt(string_wsValue);

                // Ballistic Skill Value
                String string_bsValue = bsValue.getText().toString();
                int int_bsValue = Integer.parseInt(string_bsValue);

                // Strength Value
                String string_strValue = strValue.getText().toString();
                int int_strValue = Integer.parseInt(string_strValue);

                // Toughness Value
                String string_tValue = tValue.getText().toString();
                int int_tValue = Integer.parseInt(string_tValue);

                // Agility Value
                String string_agValue = agValue.getText().toString();
                int int_agValue = Integer.parseInt(string_agValue);

                // Intelligence Value
                String string_intValue = intValue.getText().toString();
                int int_intValue = Integer.parseInt(string_intValue);

                // Perception Value
                String string_perValue = perValue.getText().toString();
                int int_perValue = Integer.parseInt(string_perValue);

                // Willpower Value
                String string_wpValue = wpValue.getText().toString();
                int int_wpValue = Integer.parseInt(string_wpValue);

                // Fellowship Value
                String string_felValue = felValue.getText().toString();
                int int_felValue = Integer.parseInt(string_felValue);

                */
            }


        });


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
            // Handle the camera action
        } else if (id == R.id.nav_char1) {

        } else if (id == R.id.nav_char2) {

        } else if (id == R.id.nav_char3) {

        } else if (id == R.id.nav_import) {

        } else if (id == R.id.nav_export) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
