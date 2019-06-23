package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bsActivity extends AppCompatActivity {

    //bsActivity's variables

    TextView bsTitleVal;

    int maxFP;
    int currentFP;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs);

        // Initialisation of objects
        bsTitleVal = findViewById(R.id.bsValTextView);

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Loading of stored character
        // Display Character's Name
        bsTitleVal.setText(sharedPreferences.getString("character_bs", ""));

        // Converting the max and current FP values to integers
        maxFP       = Integer.parseInt(sharedPreferences.getString("character_max_fp", ""));
        currentFP   = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));
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
