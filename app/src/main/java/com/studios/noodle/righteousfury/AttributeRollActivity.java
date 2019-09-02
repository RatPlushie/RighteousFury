package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static com.studios.noodle.righteousfury.tab1Character.SHARED_PREFS;

public class AttributeRollActivity extends AppCompatActivity {

    // AttributeRollActivity Variables
    private TextView activityTitle;
    private TextView activityAttributeVal;
    private TextView modifierValue;
    private TextView currentFatePointValue;
    private TextView rollRequiredVal;
    private TextView rollOutcome;
    private TextView degreeOfOutcome;

    private Button buttonRoll;
    private Button buttonReRoll;
    private Button buttonFP;
    private Button buttonBurn;

    private ImageButton buttonModPlus;
    private ImageButton buttonModMinus;

    private CheckBox unskilledCheckBox;

    private SeekBar modifierSeekBar;

    private ImageView attributeImageView;

    private int currentFP;
    private int diceRoll;
    private int threshold;
    private int degreeResult;
    private int maxFP;
    private int attributeValue;

    private String attributeName;



    // Random Method
    private static final Random random = new Random();
    public static int random(int min, int max){
        return random.nextInt(max) + min;
    }



    public void updateFPDisplay(int mode){
        /* Method called when the amount of fatepoints needs to be changed and displayed

           Modes:-
           0: Initial display
           1: Spend FP
           2: Burn FP
        */

        // Setting up the var to be returned once constructed
        String FPString;

        // Determining how the display will be updated
        switch (mode){
            case 0:
                if (currentFP == 0){
                    // User has no fatepoints, shouldnt be able to use button
                    buttonFP.setEnabled(false);

                    // Building string to display
                    FPString = currentFP + " / " + maxFP;

                    // Setting the text on the display with the created string
                    currentFatePointValue.setText(FPString);
                } else {
                    // Building the string to display
                    FPString = currentFP + " / " + maxFP;

                    // Setting the text on the display with the created string
                    currentFatePointValue.setText(FPString);
                }

                break;

            case 1:
                // Spends on FP
                currentFP --;

                // Have to create string separately for .setText()
                FPString = currentFP + " / " + maxFP;

                // Displaying the updated fate point fraction
                currentFatePointValue.setText(FPString);

                break;

            case 2:
                // Tests to see how best to remove an FP
                if (currentFP == maxFP){
                    currentFP--;
                    maxFP--;
                } else if (currentFP < maxFP){
                    maxFP--;
                }

                // Have to create the string separately for .setText()
                FPString = currentFP + " / " + maxFP;

                // Displaying the updated fate point fraction
                currentFatePointValue.setText(FPString);

                break;
        }
    }



    public void diceRoll(int mode, int threshold) {
        // TODO - dice roll logic
        /* Method called when a dice roll is required
           Mode:-
           0: Standard Roll
           1: Re-Roll
           2: Spend Fate Point Roll
           3: Burn Fate Point Roll
        */

        // Rolls the d100
        diceRoll = random(0, 100);


        // Determines which, button specific, actions are taken
        switch (mode){
            case 0: // Roll
                // Displays the outcome of the dice roll
                rollOutcome.setText(Integer.toString(diceRoll));

                // Disables the "roll" button from being pressed any more
                buttonRoll.setEnabled(false);

                // Breaks from the switch to work out degree(s) of success/failure
                break;

            case 1: // Re-Roll
                // Displays the outcome of the dice roll
                rollOutcome.setText(Integer.toString(diceRoll));

                // Currently doesn't have any behaviours attached to it and is just a reusable roll
                break;

            case 2: // Spend FP
                // Displays the outcome of the dice roll
                rollOutcome.setText(Integer.toString(diceRoll));

                // Subtracts one FP and updates the FP display
                updateFPDisplay(1);

                // Tests to see if the "Fate Point" button now needs disabled
                if (currentFP == 0){
                    // User has now no more fate points, button will be disabled
                    buttonFP.setEnabled(false);
                }

                // Spending FP is a re-roll, breaks from the switch to work out degree(s) of success/failure
                break;

            case 3: // Burn FP
                updateFPDisplay(2);
                // Disabling all the buttons, Burning is an auto win state
                buttonRoll.setEnabled(false);
                buttonReRoll.setEnabled(false);
                buttonFP.setEnabled(false);
                buttonBurn.setEnabled(false);

                // Burning FP is an auto-win, Dice rolls are un-needed
                rollRequiredVal.setText("-");
                rollOutcome.setText("-");
                degreeOfOutcome.setText(getString(R.string.zero_degrees_of_success));

                // Burning FP is an auto success so it doesnt need to determine the degrees of success/failure
                return;
        }


        // Determining the degrees of success/failure
        if (diceRoll == threshold) {    // Just barely a success

            // A success with 0 degrees, displays the degree outcome
            degreeOfOutcome.setText(getString(R.string.zero_degrees_of_success));

        } else if (diceRoll > threshold) {   // A Failed Roll

            // Formula to work out the amount of degree(s) of failure
            degreeResult = ((diceRoll - threshold) / 10);

            // Testing to see how many degrees of failure and which text to construct and display
            if (degreeResult == 0){
                // Displays a report of "Zero degrees of failure
                degreeOfOutcome.setText(getString(R.string.zero_degrees_of_failure));

            } else if (degreeResult == 1){
                // Displays a report of "One degree of failure
                degreeOfOutcome.setText(getString(R.string.one_degree_of_failure));

            } else if (degreeResult > 1){
                // Must create the string outside of .setText()
                String outcomeString = degreeResult + " " + getString(R.string.many_degrees_of_failure);

                // Displays a report of "X degrees of failure
                degreeOfOutcome.setText(outcomeString);
            }

        } else if (diceRoll < threshold){   // A successful roll

            // Formula to work out the amount of degree(s) of success
            degreeResult = ((threshold - diceRoll) / 10);

            //Testing to see how many degrees of success and which text to construct and display
            if (degreeResult == 0){
                // Displays a report of "Zero degrees of success"
                degreeOfOutcome.setText(getString(R.string.zero_degrees_of_success));

            } else if (degreeResult == 1){
                // Display a report of one degree of success
                degreeOfOutcome.setText(getString(R.string.one_degree_of_success));

            } else if (degreeResult > 1){
                // Must create the string outside of .setText()
                String outcomeString = (degreeResult + " " + getString(R.string.many_degrees_of_success));

                // Displays a report of "X degrees of success"
                degreeOfOutcome.setText(outcomeString);

            }
        }
    }



    public void updateThreshold(int attVal, int buttonMod){
        // Retrieves the current modifier value
        int modVal = Integer.parseInt(modifierValue.getText().toString().trim());


        // Tests to see if it first has to half the attribute value because of an unskilled roll
        if (unskilledCheckBox.isChecked()){
                // Should the user check the unskilled box the attribute value will be halved and then updated

                // Halves the attribute value
                attVal /= 2;

                // Adds to the remaining attribute value the modifier
                attVal += modVal;

                // For when the user presses the +/- buttons for the modifier selection
                attVal += buttonMod;

                // Displays the new value
                rollRequiredVal.setText(Integer.toString(attVal));

                // Sets the text to the warning colour
                rollRequiredVal.setTextColor(getResources().getColor(R.color.warningRed));

        } else if (!unskilledCheckBox.isChecked()){
                // Should the user uncheck the unskilled box the attribute value will be restored and updated

                attVal += modVal;

                // Displays the new value
                rollRequiredVal.setText(Integer.toString(attVal));

                // Sets the text to the default colour
                rollRequiredVal.setTextColor(getResources().getColor(R.color.textPrimary));
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_roll);

        // Initialisation of the activity's objects
        activityTitle                = findViewById(R.id.AttributeTitleTextView);
        activityAttributeVal        = findViewById(R.id.AttributeValTextView);
        attributeImageView          = findViewById(R.id.attributeImageView);
        modifierValue               = findViewById(R.id.ModifierValTextView);
        currentFatePointValue       = findViewById(R.id.currentFatePointTotalTextView);
        rollRequiredVal             = findViewById(R.id.rollThresholdValTextView);
        rollOutcome                 = findViewById(R.id.rollOutcomeValTextView);
        degreeOfOutcome             = findViewById(R.id.degreeOutcomeVal);

        buttonRoll                  = findViewById(R.id.rollButton);
        buttonReRoll                = findViewById(R.id.reRollButton);
        buttonFP                    = findViewById(R.id.fatepointRollButton);
        buttonBurn                  = findViewById(R.id.burnFPButton);
        buttonModPlus               = findViewById(R.id.attRollModPlusImageButton);
        buttonModMinus              = findViewById(R.id.attRollModMinusImageButton);

        modifierSeekBar             = findViewById(R.id.rollModifierSeekBar);

        unskilledCheckBox           = findViewById(R.id.attUnskilledCheckBox);



        // Initialisation of the shared preference object to load character data
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor (May not be needed)
        SharedPreferences.Editor edit = sharedPreferences.edit();



        // Retrieving the amount of Fate Points the user has and parsing it as an int
        currentFP = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));

        // Retrieving the maximum amount of Fate Points the user has and parsing it as an int
        maxFP     = Integer.parseInt(sharedPreferences.getString("character_max_fp", ""));



        // Retrieving the bundle passed from tab1Character.class
        Bundle bundle = getIntent().getExtras();

        // Extracting the bundled data
        attributeName  = bundle.getString("attributeName");
        attributeValue = Integer.parseInt(bundle.getString("attributeValue"));

        // Displaying the attribute the user is rolling against
        activityTitle.setText(attributeName);

        // Displaying the attribute value the user is rolling with
        activityAttributeVal.setText(Integer.toString(attributeValue));

        // Displaying the default initial value of the roll modifier to 0
        modifierValue.setText(Integer.toString(0));

        // Displaying the default roll threshold (attribute value)
        updateThreshold(attributeValue, 0);

        // Displaying the amount of Fate Points the user has in the TextView
        updateFPDisplay(0);



        // Defaulting the roll threshold value to the attribute value (an unmodified roll)
        threshold = attributeValue;

        // If threshold is outside the possible range, constrain results to range 0 < x <= 100
        if (threshold < 1){
            threshold = 1;
        } else if (threshold > 100){
            threshold = 100;
        }



        // Disabling the "burn" button onCreate if the user has no FP to spend on this action
        if (maxFP == 0){
            buttonBurn.setEnabled(false);
        }

        // Disabling the "fatepoint" button onCreate if the user has no FP to spend on this action
        if (currentFP == 0){
            buttonFP.setEnabled(false);
        }



        // OnSeekBarChange behaviour for the modifier seek bar
        modifierSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Displaying the modifier textview above the seekbar
                modifierValue.setText(Integer.toString(i - 60));

                // Updates the variable to the new roll threshold amount
                threshold = attributeValue + (i - 60);

                // Testing if to see the threshold is outside the possible range of 0 < x > 100
                if (threshold < 1){
                    threshold = 1;
                } else if (threshold > 100){
                    threshold = 100;
                }

                // Displaying the updated roll required value
                updateThreshold(attributeValue, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Don't need
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Don't need
            }
        });



        // OnChange behaviour for the unskilled modifier checkbox
        unskilledCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // Calls for the updateThreshold method to update objects as needed
                updateThreshold(attributeValue, 0);
            }
        });



        // OnClick behaviour for the modifier +1 button
        buttonModPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finds out what the current value of the modifier is as an integer
                int modifierInt = Integer.parseInt(modifierValue.getText().toString().trim());

                // Adds 1 to the int for the new value
                modifierInt += 1;

                // Prevents the user from +1 -ing their way to beyond the max +60 mod
                if (modifierInt <= 60){
                    // Displays the new value with the +1 added
                    modifierValue.setText(Integer.toString(modifierInt));

                    // Updates the threshold value with the +1
                    updateThreshold(attributeValue, 1);
                }
            }
        });



        // OnClick behaviour for the modifier -1 button
        buttonModMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finds out what the current value of the modifier is as an integer
                int modifierInt = Integer.parseInt(modifierValue.getText().toString().trim());

                // Adds 1 to the int for the new value
                modifierInt -= 1;

                // Prevents the user from -1 -ing below -60
                if (modifierInt > -60){
                    // Display the new value with the -1
                    modifierValue.setText(Integer.toString(modifierInt));

                    // Updates the threshold value with the -1
                    updateThreshold(attributeValue, -1);
                }
            }
        });



        // OnClick behaviour for the "roll" button
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(0, threshold);
            }
        });



        // OnClick behaviour for the "reroll" button
        buttonReRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(1, threshold);
            }
        });



        // OnClick behaviour for the "fatepoint" button
        buttonFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(2, threshold);
            }
        });



        // OnClick behaviour for the "burn" button
        buttonBurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(3, threshold);
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
