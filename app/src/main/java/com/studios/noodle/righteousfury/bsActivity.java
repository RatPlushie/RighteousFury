package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bsActivity extends AppCompatActivity {

    //bsActivity's variables
    private TextView bsTitleVal;
    private TextView ammoVal;

    private int maxFP;
    private int currentFP;

    private String weapon_name;
    private String weapon_class;
    private String weapon_damage;
    private String weapon_type;
    private String weapon_pen;
    private String weapon_range;
    private String weapon_rof;
    private String weapon_clip;
    private String weapon_reload;
    private String weapon_special_rules;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs);

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of objects
        bsTitleVal              = findViewById(R.id.bsValTextView);
        ammoVal                 = findViewById(R.id.ammoQuantityTextView);

        // Retrieving weapon info
        weapon_name             = sharedPreferences.getString("missile_weapon_name", "");
        weapon_class            = sharedPreferences.getString("missile_weapon_class", "");
        weapon_damage           = sharedPreferences.getString("missile_weapon_damage", "");
        weapon_type             = sharedPreferences.getString("missile_weapon_type", "");
        weapon_pen              = sharedPreferences.getString("missile_weapon_penetration", "");
        weapon_range            = sharedPreferences.getString("missile_weapon_range", "");
        weapon_rof              = sharedPreferences.getString("missile_weapon_rof", "");
        weapon_clip             = sharedPreferences.getString("missile_weapon_clip", "");
        weapon_reload           = sharedPreferences.getString("missile_weapon_rld", "");
        weapon_special_rules    = sharedPreferences.getString("missile_weapon_special_rules", "");

        // Display Character's Name
        bsTitleVal.setText(sharedPreferences.getString("character_bs", ""));
        ammoVal.setText(sharedPreferences.getString("ammo_val", ""));

        // Converting the max and current FP values to integers
        maxFP                   = Integer.parseInt(sharedPreferences.getString("character_max_fp", ""));
        currentFP               = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Updated the shared preferences with all the character data
        edit.putString("character_max_fp", Integer.toString(maxFP));
        edit.putString("character_current_fp", Integer.toString(currentFP));

        // Applies the changes to the shared preferences file
        edit.apply();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
