package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.studios.noodle.righteousfury.tab1Character.SHARED_PREFS;

public class AttributeRollActivity extends AppCompatActivity {

    // AttributeRollActivity Variables
    private TextView activityTile;
    private TextView activityAttributeVal;
    private TextView modifierValue;
    private TextView currentFatePointValue;
    private TextView rollRequiredVal;
    private TextView rollOutcome;
    private TextView degreeOfOutcome;

    private Button rollButton;
    private Button reRollButton;
    private Button fatepointRollButton;

    private SeekBar modifierSeekBar;

    private ImageView attributeImageView;

    private int currentFP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_roll);

        // Initialisation of the activity's objects
        activityTile                = findViewById(R.id.AttributeTitleTextView);
        activityAttributeVal        = findViewById(R.id.AttributeValTextView);
        modifierValue               = findViewById(R.id.ModifierValTextView);
        currentFatePointValue       = findViewById(R.id.currentFatePointTotalTextView);
        rollRequiredVal             = findViewById(R.id.rollThresholdValTextView);
        rollOutcome                 = findViewById(R.id.rollOutcomeValTextView);
        degreeOfOutcome             = findViewById(R.id.degreeOutcomeVal);
        rollButton                  = findViewById(R.id.rollButton);
        reRollButton                = findViewById(R.id.reRollButton);
        fatepointRollButton         = findViewById(R.id.fatepointRollButton);
        modifierSeekBar             = findViewById(R.id.rollModifierSeekBar);
        attributeImageView          = findViewById(R.id.attributeImageView);


        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Retrieving the amount of fate points the user has and parsing it into an integer
        currentFP = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));

        // Setting the starting amount of fatepoints the user has
        currentFatePointValue.setText("[ " + currentFP + " ]");


        // Retrieve the bundle
        Bundle bundle = getIntent().getExtras();

        // Extracting the passed data
        // Extracting the Name of the attribute from the bundle
        String attributeName = bundle.getString("attributeName");

        // Extracting the value of the attribute as an integer
        final int attributeVal = Integer.parseInt(bundle.getString("attributeValue"));


        // Setting the title of the roll page to the attribute's name
        activityTile.setText(attributeName);

        // Setting the value of the attribute visually
        activityAttributeVal.setText(Integer.toString(attributeVal));


        // Initially setting the roll threshold to the base stat - will be modified on seekbar change afterwards
        rollRequiredVal.setText(bundle.getString("attributeValue"));

        // Call for the seekbar's behaviour
        modifierSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                // sets the Modifier value text view above the seekbar
                modifierValue.setText(Integer.toString(i - 100));

                // Sets the roll threshold text view
                rollRequiredVal.setText(Integer.toString(attributeVal + (i - 100)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Updates the amount of FP points the character currently has to the shared preferences
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
