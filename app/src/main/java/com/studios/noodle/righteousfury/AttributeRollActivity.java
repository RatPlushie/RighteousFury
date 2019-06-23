package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

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
    private Button burnButton;

    private SeekBar modifierSeekBar;

    private ImageView attributeImageView;

    private int currentFP;
    private int diceRoll;
    private int threshold;
    private int degreeResult;
    private int maxFP;

    private String degreeString;
    private String fatePointTotalString;


    // Random Method
    private static final Random random = new Random();
    public static int random(int min, int max){
        return random.nextInt(max) + min;
    }
    
    public String getDegreeRoll(int diceRoll, int threshold){
        if (diceRoll == threshold){
            // Regular rolled success

            // if true - 0 degrees of success
            degreeString = getString(R.string.zero_degrees_of_success);

        } else if ( diceRoll > threshold){
            // Roll failure

            // Equation to find the amount of degrees of failure, printing an int
            degreeResult = ((diceRoll - threshold) / 10);

            if (degreeResult == 0){

                // prints out a regular report of zero degrees of failure
                degreeString = getString(R.string.zero_degrees_of_failure);

            } else if (degreeResult == 1){

                // prints out a report of one degree of failure
                degreeString = getString(R.string.one_degree_of_failure);

            } else if (degreeResult > 1){

                // Creates a string to be used in the setText return
                degreeString = (degreeResult + " " + getString(R.string.many_degrees_of_failure));
                
            }

        } else if ( diceRoll < threshold) {
            // Roll success

            // Equation to find the amount of degrees of success, printing an int
            degreeResult = ((threshold - diceRoll) / 10);

            if (degreeResult == 0){

                // Prints out a regular report of zero degrees of success
                degreeString = getString(R.string.zero_degrees_of_success);

            } else if (degreeResult == 1){

                // prints out a report of one degree of success
                degreeString = getString(R.string.one_degree_of_success);

            } else if (degreeResult > 1){

                // Creates a string to be used in the setText method since setText doesn't like it
                degreeString = (degreeResult + " " + getString(R.string.many_degrees_of_success));
                
            }
        }
        return degreeString; 
    }


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
        burnButton                  = findViewById(R.id.burnFPButton);
        modifierSeekBar             = findViewById(R.id.rollModifierSeekBar);
        attributeImageView          = findViewById(R.id.attributeImageView);


        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Retrieving the amount of fate points the user has and parsing it into an integer
        currentFP = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));

        // Retrieving the maximum amount of fate points the user has and parsing it into an integer
        maxFP = Integer.parseInt(sharedPreferences.getString("character_max_fp", ""));

        // Setting the starting amount of fatepoints the user has
        if (currentFP == 0){
            fatepointRollButton.setEnabled(false);
            fatePointTotalString = currentFP + " / " + maxFP;
            currentFatePointValue.setText(fatePointTotalString);
        } else {
            fatePointTotalString = currentFP + " / " + maxFP;
            currentFatePointValue.setText(fatePointTotalString);
        }

        // Setting if the burn button is enabled
        if (maxFP == 0){
            burnButton.setEnabled(false);
        }

        // Setting

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

        // Setting the default value of the modifier roll
        modifierValue.setText(Integer.toString(0));

        // Defaults the threshold value to default onCreate;
        threshold = attributeVal;

        // Initially setting the roll threshold to the base stat - will be modified on seekbar change afterwards
        rollRequiredVal.setText(bundle.getString("attributeValue"));

        // Call for the seekbar's behaviour
        modifierSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                // sets the Modifier value text view above the seekbar
                modifierValue.setText(Integer.toString(i - 60));

                // Updates the variable to the new roll threshold amount
                threshold = attributeVal + (i - 60);

                // Sets the roll threshold text view
                rollRequiredVal.setText(Integer.toString(threshold));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        // Call for the roll button - The user only gets one roll before it is locked off
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Saves an int to be used later
                diceRoll = random(0, 100);

                // Sets the text in the Roll outcome card view
                rollOutcome.setText(Integer.toString(diceRoll));

                // Disables the button being pressed any more
                rollButton.setEnabled(false);

                // Set text to the degrees of the outcome
                degreeOfOutcome.setText(getDegreeRoll(diceRoll, threshold));


            }
        });

        // Call for the re-roll button - Placeholder until there is logic to count how many rerolls a player has
        reRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Saves an int to be used later
                diceRoll = random(0, 100);

                // Sets the text in the Roll outcome card view
                rollOutcome.setText(Integer.toString(diceRoll));

                // Sets text to the degrees of the outcome
                degreeOfOutcome.setText(getDegreeRoll(diceRoll, threshold));

                // Counts and reacts to how many re-rolls the player has
            }
        });

        // Call for the fate point spending button
        fatepointRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Saves an int to be used later
                diceRoll = random(0, 100);

                // Sets the text in the Roll outcome card view
                rollOutcome.setText(Integer.toString(diceRoll));

                // Subtract one FP
                currentFP--;

                // Display the remaining amount of fate points
                fatePointTotalString = currentFP + " / " + maxFP;
                currentFatePointValue.setText(fatePointTotalString);

                // Checks if the new value of current fp is now 0
                if (currentFP == 0){
                    // If true then the button will be disabled
                    fatepointRollButton.setEnabled(false);

                }

                // Sets text to the degrees of the outcome
                degreeOfOutcome.setText(getDegreeRoll(diceRoll, threshold));
            }
        });

        // Call for the fate point burning button
        burnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // After use the burn button will be disabled
                burnButton.setEnabled(false);

                // Checks to see how to remove a fate point
                if (currentFP == maxFP){
                    currentFP--;
                    maxFP--;
                } else if (currentFP < maxFP){
                    maxFP--;
                }

                // Burning a fate point immediately calls for a winning state, so dice rolls are irrelevant
                rollRequiredVal.setText("-");
                rollOutcome.setText("-");
                degreeOfOutcome.setText(getString(R.string.zero_degrees_of_success));

                // Updating the value of the current and maxFP counter
                fatePointTotalString = currentFP + " / " + maxFP;
                currentFatePointValue.setText(fatePointTotalString);

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

        // Update the maximum amount of FP points the character currently has to the shared preferences
        edit.putString("character_max_fp", Integer.toString(maxFP));

        // Applies the changes to the shared preferences file
        edit.apply();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}