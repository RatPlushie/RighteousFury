package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class bsActivity extends AppCompatActivity {

    /*

BS SKILL TODO:
  x- roll outcome
  x- degrees of succ/fail
  x- hit location


  x- Wep jams roll:    96-100
  x- unskilled:        -20

Wep Modes:- (Can only fire as many bullets as indicated, never more)
  - Single:           +0
  - Semi:             +10, per 2 degrees (Can Jam). Use hit Table to find where
  - Full:             +20, per 2 degrees (Can Jam)

  Battle order:-
    x- Normal BS test
    - Determine Hit location
    - Determine Damage (Rolling a 10 on any die is righteous fury!)
    - list results

    */

    // Body Hit Locations
    private int[] hitHead   = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] hitRArm   = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private int[] hitLArm   = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    private int[] hitBody   = {31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70};
    private int[] hitRLeg   = {71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85};
    private int[] hitLLeg   = {86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};

    private String[] hitOrderHead   = {"Head", "Head", "Arm", "Body", "Arm", "Body"};
    private String[] hitOrderArm    = {"Arm", "Arm", "Body", "Head", "Body", "Arm"};
    private String[] hitOrderBody   = {"Body", "Body", "Arm", "Head", "Arm", "Body"};
    private String[] hitOrderLeg    = {"Leg", "Leg", "Body", "Arm", "Head", "Body"};

    private int BSkillVal;

    private String wep1Name;
    private String wep1Class;
    private String wep1Damage_x;
    private String wep1Damage_y;
    private String wep1Damage_z;
    private String wep1Type;
    private String wep1Range;
    private String wep1RoF_x;
    private String wep1RoF_y;
    private String wep1RoF_z;
    private String wep1Clip;
    private String wep1RLD;
    private String wep1Pen;
    private String wep1SpecialRules;

    private String wep2Name;
    private String wep2Class;
    private String wep2Damage_x;
    private String wep2Damage_y;
    private String wep2Damage_z;
    private String wep2Type;
    private String wep2Range;
    private String wep2RoF_x;
    private String wep2RoF_y;
    private String wep2RoF_z;
    private String wep2Clip;
    private String wep2RLD;
    private String wep2Pen;
    private String wep2SpecialRules;

    private String wep3Name;
    private String wep3Class;
    private String wep3Damage_x;
    private String wep3Damage_y;
    private String wep3Damage_z;
    private String wep3Type;
    private String wep3Range;
    private String wep3RoF_x;
    private String wep3RoF_y;
    private String wep3RoF_z;
    private String wep3Clip;
    private String wep3RLD;
    private String wep3Pen;
    private String wep3SpecialRules;

    private String wep4Name;
    private String wep4Class;
    private String wep4Damage_x;
    private String wep4Damage_y;
    private String wep4Damage_z;
    private String wep4Type;
    private String wep4Range;
    private String wep4RoF_x;
    private String wep4RoF_y;
    private String wep4RoF_z;
    private String wep4Clip;
    private String wep4RLD;
    private String wep4Pen;
    private String wep4SpecialRules;

    private String ammo1Name;
    private String ammo2Name;
    private String ammo3Name;
    private String ammo4Name;

    private int ammo1No;
    private int ammo2No;
    private int ammo3No;
    private int ammo4No;

    private int modifierValue;
    private int rollThreshold;
    private int diceRoll;
    private int degreeResult;

    private int currentFP;
    private int maxFP;

    private int maxAmmo;
    private int clipAmmo;

    private TextView bsTitleVal;
    private TextView wepStatString;
    private TextView ammoMaxDisplay;
    private TextView ammoClipDisplay;
    private TextView ammoDashDisplay;
    private TextView modifierDisplay;
    private TextView rollThresholdDisplay;
    private TextView rollOutcomeDisplay;
    private TextView rollDegreeDisplay;
    private TextView rollHitLocationDisplay;
    private TextView FPDisplay;

    private Button buttonRoll;
    private Button buttonReRoll;
    private Button buttonFPRoll;
    private Button buttonBurnRoll;
    private Button buttonUnjam;
    private Button buttonReload;

    private RadioButton radioManual;
    private RadioButton radioSemi;
    private RadioButton radioFull;

    private Spinner wepSpinner;
    private Spinner ammoSpinner;

    private ImageButton buttonModPlus;
    private ImageButton buttonModMinus;
    private ImageButton buttonHitCounterUp;
    private ImageButton buttonHitCounterDown;

    private CheckBox unskilledCheckBox;

    private SeekBar modifierSeekBar;

    private CardView damageCalcCard;


    // Shared preferences
    public static String SHARED_PREFS = "sharedPrefs";



    // Random Method
    private static final Random random = new Random();
    public static int random(int min, int max){
        return random.nextInt(max) + min;
    }


    // Method for setting the displayed weapon stats for the user
    public void setWepStatString(){

        // Initialising shared preferences for the method
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Creating the array for all non-empty stats
        ArrayList<String> outputStatsArray = new ArrayList<>();

        String wepClass         = "";
        String wepDamage        = "";
        String wepType          = "";
        String wepPen           = "";
        String wepRange         = "";
        String wepRoF           = "";
        String wepClip          = "";
        String wepReload        = "";
        String wepSpecialRules  = "";

        // Determines the string that needs to be built for the selected weapon
        if (wepSpinner.getSelectedItem().toString().equals(sharedPreferences.getString("mis1WepName", ""))){

            wepStatString.setVisibility(View.VISIBLE);

            // If class is empty, do not include in string
            if (!(wep1Class.isEmpty())){
                wepClass = "Class: " + wep1Class;
                outputStatsArray.add(wepClass);
            }

            // If damage is empty (or incomplete), do not include un-needed strings
            if (!(wep1Damage_x.isEmpty() && wep1Damage_y.isEmpty())){
                wepDamage = "Damage: " + wep1Damage_x + "d" + wep1Damage_y;
                if (!(wep1Damage_z.isEmpty())){
                    wepDamage += "+" + wep1Damage_z;
                }
            }
            if (!(wepDamage.isEmpty())){
                outputStatsArray.add(wepDamage);
            }

            // If type is empty, do not include in string
            if (!(wep1Type.isEmpty())){
                wepType = "Type: " + wep1Type;
                outputStatsArray.add(wepType);
            }

            // If penetration is empty, do not include in string
            if (!(wep1Pen.isEmpty())){
                wepPen = "Penetration: " + wep1Pen;
                outputStatsArray.add(wepPen);
            }

            // If range is empty, do not include in string
            if (!(wep1Range.isEmpty())){
                wepRange = "Range: " + wep1Range;
                outputStatsArray.add(wepRange);
            }

            // If RoF is empty, complete string with placeholders
            if (!(wep1RoF_x.isEmpty())){
                wepRoF = "RoF: " + wep1RoF_x + "/";
            } else {
                wepRoF = "RoF: -/";
            }
            if (!(wep1RoF_y.isEmpty())){
                wepRoF += wep1RoF_y + "/";
            } else {
                wepRoF += "-/";
            }
            if (!(wep1RoF_z.isEmpty())){
                wepRoF += wep1RoF_z;
            } else {
                wepRoF += "-";
            }
            outputStatsArray.add(wepRoF);

            // If clip is empty, do not include in string
            if (!(wep1Clip.isEmpty())){
                wepClip = "Clip: " + wep1Clip;
                outputStatsArray.add(wepClip);
            }

            // If reload is empty, do not include in string
            if (!(wep1RLD.isEmpty())){
                wepReload = "Reload: " + wep1RLD;
                outputStatsArray.add(wepReload);
            }

            // If special rules is empty, do not include in string
            if (!(wep1SpecialRules.isEmpty())){
                wepSpecialRules = "Special Rules: " + wep1SpecialRules;
                outputStatsArray.add(wepSpecialRules);
            }

            // String builder for the statString display constructing only what is needed without null values
            StringBuilder statStringBuilder = new StringBuilder();

            // Loop to go through each entry of the array to build the stat string
            for (int i = 0; i < outputStatsArray.size(); i++){

                // Checks to see if "i" is at the end so it doesn't add a comma to the end
                if (!(i + 1 == outputStatsArray.size())){
                    // Adds non-end-of-array element to the stat string with a comma appended
                    statStringBuilder.append(outputStatsArray.get(i));
                    statStringBuilder.append(", ");

                } else {
                    // Adds end-of-array element to the stat string without a comma
                    statStringBuilder.append(outputStatsArray.get(i));
                }
            }

            // Sets the TextView display with the completed string
            wepStatString.setText(statStringBuilder.toString());



        } else if (wepSpinner.getSelectedItem().toString().equals(sharedPreferences.getString("mis2WepName", ""))){

            wepStatString.setVisibility(View.VISIBLE);

            // If class is empty, do not include in string
            if (!(wep2Class.isEmpty())){
                wepClass = "Class: " + wep2Class;
                outputStatsArray.add(wepClass);
            }

            // If damage is empty (or incomplete), do not include un-needed strings
            if (!(wep2Damage_x.isEmpty() && wep2Damage_y.isEmpty())){
                wepDamage = "Damage: " + wep2Damage_x + "d" + wep2Damage_y;
                if (!(wep2Damage_z.isEmpty())){
                    wepDamage += "+" + wep2Damage_z;
                }
            }
            if (!(wepDamage.isEmpty())){
                outputStatsArray.add(wepDamage);
            }

            // If type is empty, do not include in string
            if (!(wep2Type.isEmpty())){
                wepType = "Type: " + wep2Type;
                outputStatsArray.add(wepType);
            }

            // If penetration is empty, do not include in string
            if (!(wep2Pen.isEmpty())){
                wepPen = "Penetration: " + wep2Pen;
                outputStatsArray.add(wepPen);
            }

            // If range is empty, do not include in string
            if (!(wep2Range.isEmpty())){
                wepRange = "Range: " + wep2Range;
                outputStatsArray.add(wepRange);
            }

            // If RoF is empty, complete string with placeholders
            if (!(wep2RoF_x.isEmpty())){
                wepRoF = "RoF: " + wep2RoF_x + "/";
            } else {
                wepRoF = "RoF: -/";
            }
            if (!(wep2RoF_y.isEmpty())){
                wepRoF += wep2RoF_y + "/";
            } else {
                wepRoF += "-/";
            }
            if (!(wep2RoF_z.isEmpty())){
                wepRoF += wep2RoF_z;
            } else {
                wepRoF += "-";
            }
            outputStatsArray.add(wepRoF);

            // If clip is empty, do not include in string
            if (!(wep2Clip.isEmpty())){
                wepClip = "Clip: " + wep2Clip;
                outputStatsArray.add(wepClip);
            }

            // If reload is empty, do not include in string
            if (!(wep2RLD.isEmpty())){
                wepReload = "Reload: " + wep2RLD;
                outputStatsArray.add(wepReload);
            }

            // If special rules is empty, do not include in string
            if (!(wep2SpecialRules.isEmpty())){
                wepSpecialRules = "Special Rules: " + wep2SpecialRules;
                outputStatsArray.add(wepSpecialRules);
            }

            // String builder for the statString display constructing only what is needed without null values
            StringBuilder statStringBuilder = new StringBuilder();

            // Loop to go through each entry of the array to build the stat string
            for (int i = 0; i < outputStatsArray.size(); i++){

                // Checks to see if "i" is at the end so it doesn't add a comma to the end
                if (!(i + 1 == outputStatsArray.size())){
                    // Adds non-end-of-array element to the stat string with a comma appended
                    statStringBuilder.append(outputStatsArray.get(i));
                    statStringBuilder.append(", ");

                } else {
                    // Adds end-of-array element to the stat string without a comma
                    statStringBuilder.append(outputStatsArray.get(i));
                }
            }

            // Sets the TextView display with the completed string
            wepStatString.setText(statStringBuilder.toString());

        } else if (wepSpinner.getSelectedItem().toString().equals(sharedPreferences.getString("mis3WepName", ""))){

            wepStatString.setVisibility(View.VISIBLE);

            // If class is empty, do not include in string
            if (!(wep3Class.isEmpty())){
                wepClass = "Class: " + wep3Class;
                outputStatsArray.add(wepClass);
            }

            // If damage is empty (or incomplete), do not include un-needed strings
            if (!(wep3Damage_x.isEmpty() && wep3Damage_y.isEmpty())){
                wepDamage = "Damage: " + wep3Damage_x + "d" + wep3Damage_y;
                if (!(wep3Damage_z.isEmpty())){
                    wepDamage += "+" + wep3Damage_z;
                }
            }
            if (!(wepDamage.isEmpty())){
                outputStatsArray.add(wepDamage);
            }

            // If type is empty, do not include in string
            if (!(wep3Type.isEmpty())){
                wepType = "Type: " + wep3Type;
                outputStatsArray.add(wepType);
            }

            // If penetration is empty, do not include in string
            if (!(wep3Pen.isEmpty())){
                wepPen = "Penetration: " + wep3Pen;
                outputStatsArray.add(wepPen);
            }

            // If range is empty, do not include in string
            if (!(wep3Range.isEmpty())){
                wepRange = "Range: " + wep3Range;
                outputStatsArray.add(wepRange);
            }

            // If RoF is empty, complete string with placeholders
            if (!(wep3RoF_x.isEmpty())){
                wepRoF = "RoF: " + wep3RoF_x + "/";
            } else {
                wepRoF = "RoF: -/";
            }
            if (!(wep3RoF_y.isEmpty())){
                wepRoF += wep3RoF_y + "/";
            } else {
                wepRoF += "-/";
            }
            if (!(wep3RoF_z.isEmpty())){
                wepRoF += wep3RoF_z;
            } else {
                wepRoF += "-";
            }
            outputStatsArray.add(wepRoF);

            // If clip is empty, do not include in string
            if (!(wep3Clip.isEmpty())){
                wepClip = "Clip: " + wep3Clip;
                outputStatsArray.add(wepClip);
            }

            // If reload is empty, do not include in string
            if (!(wep3RLD.isEmpty())){
                wepReload = "Reload: " + wep3RLD;
                outputStatsArray.add(wepReload);
            }

            // If special rules is empty, do not include in string
            if (!(wep3SpecialRules.isEmpty())){
                wepSpecialRules = "Special Rules: " + wep3SpecialRules;
                outputStatsArray.add(wepSpecialRules);
            }

            // String builder for the statString display constructing only what is needed without null values
            StringBuilder statStringBuilder = new StringBuilder();

            // Loop to go through each entry of the array to build the stat string
            for (int i = 0; i < outputStatsArray.size(); i++){

                // Checks to see if "i" is at the end so it doesn't add a comma to the end
                if (!(i + 1 == outputStatsArray.size())){
                    // Adds non-end-of-array element to the stat string with a comma appended
                    statStringBuilder.append(outputStatsArray.get(i));
                    statStringBuilder.append(", ");

                } else {
                    // Adds end-of-array element to the stat string without a comma
                    statStringBuilder.append(outputStatsArray.get(i));
                }
            }

            // Sets the TextView display with the completed string
            wepStatString.setText(statStringBuilder.toString());

        } else if (wepSpinner.getSelectedItem().toString().equals(sharedPreferences.getString("mis4WepName", ""))){

            wepStatString.setVisibility(View.VISIBLE);

            // If class is empty, do not include in string
            if (!(wep4Class.isEmpty())){
                wepClass = "Class: " + wep4Class;
                outputStatsArray.add(wepClass);
            }

            // If damage is empty (or incomplete), do not include un-needed strings
            if (!(wep4Damage_x.isEmpty() && wep4Damage_y.isEmpty())){
                wepDamage = "Damage: " + wep4Damage_x + "d" + wep4Damage_y;
                if (!(wep4Damage_z.isEmpty())){
                    wepDamage += "+" + wep4Damage_z;
                }
            }
            if (!(wepDamage.isEmpty())){
                outputStatsArray.add(wepDamage);
            }

            // If type is empty, do not include in string
            if (!(wep4Type.isEmpty())){
                wepType = "Type: " + wep4Type;
                outputStatsArray.add(wepType);
            }

            // If penetration is empty, do not include in string
            if (!(wep4Pen.isEmpty())){
                wepPen = "Penetration: " + wep4Pen;
                outputStatsArray.add(wepPen);
            }

            // If range is empty, do not include in string
            if (!(wep4Range.isEmpty())){
                wepRange = "Range: " + wep4Range;
                outputStatsArray.add(wepRange);
            }

            // If RoF is empty, complete string with placeholders
            if (!(wep4RoF_x.isEmpty())){
                wepRoF = "RoF: " + wep4RoF_x + "/";
            } else {
                wepRoF = "RoF: -/";
            }
            if (!(wep4RoF_y.isEmpty())){
                wepRoF += wep4RoF_y + "/";
            } else {
                wepRoF += "-/";
            }
            if (!(wep4RoF_z.isEmpty())){
                wepRoF += wep4RoF_z;
            } else {
                wepRoF += "-";
            }
            outputStatsArray.add(wepRoF);

            // If clip is empty, do not include in string
            if (!(wep4Clip.isEmpty())){
                wepClip = "Clip: " + wep4Clip;
                outputStatsArray.add(wepClip);
            }

            // If reload is empty, do not include in string
            if (!(wep4RLD.isEmpty())){
                wepReload = "Reload: " + wep4RLD;
                outputStatsArray.add(wepReload);
            }

            // If special rules is empty, do not include in string
            if (!(wep4SpecialRules.isEmpty())){
                wepSpecialRules = "Special Rules: " + wep4SpecialRules;
                outputStatsArray.add(wepSpecialRules);
            }

            // String builder for the statString display constructing only what is needed without null values
            StringBuilder statStringBuilder = new StringBuilder();

            // Loop to go through each entry of the array to build the stat string
            for (int i = 0; i < outputStatsArray.size(); i++){

                // Checks to see if "i" is at the end so it doesn't add a comma to the end
                if (!(i + 1 == outputStatsArray.size())){
                    // Adds non-end-of-array element to the stat string with a comma appended
                    statStringBuilder.append(outputStatsArray.get(i));
                    statStringBuilder.append(", ");

                } else {
                    // Adds end-of-array element to the stat string without a comma
                    statStringBuilder.append(outputStatsArray.get(i));
                }
            }

            // Sets the TextView display with the completed string
            wepStatString.setText(statStringBuilder.toString());

        } else {
            // Catch all to hide the TextView should no weapon stats be available
            wepStatString.setVisibility(View.INVISIBLE);
        }
    }


    // Method for setting the displayed ammo stats for the user
    public void setAmmoDisplay(){
        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = this.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Converting the ammo values into usable integers. If they are empty, fill it with a "0"
        if (!(sharedPreferences.getString("ammo1No", "").isEmpty())){
            ammo1No = Integer.parseInt(sharedPreferences.getString("ammo1No",""));
        } else {
            ammo1No = 0;
        }

        if (!(sharedPreferences.getString("ammo2No", "").isEmpty())){
            ammo2No = Integer.parseInt(sharedPreferences.getString("ammo2No",""));
        } else {
            ammo2No = 0;
        }

        if (!(sharedPreferences.getString("ammo3No", "").isEmpty())){
            ammo3No = Integer.parseInt(sharedPreferences.getString("ammo3No",""));
        } else {
            ammo3No = 0;
        }

        if (!(sharedPreferences.getString("ammo4No", "").isEmpty())){
            ammo4No = Integer.parseInt(sharedPreferences.getString("ammo4No",""));
        } else {
            ammo4No = 0;
        }


        // Determines which ammo has been selected
        if (ammoSpinner.getSelectedItem().toString().equals(ammo1Name)){
            // Setting the display of the amount of ammo remaining for ammo1
            ammoMaxDisplay.setText(Integer.toString(ammo1No));

        } else if (ammoSpinner.getSelectedItem().toString().equals(ammo2Name)){
            // Setting the display of the amount of ammo remaining for ammo2
            ammoMaxDisplay.setText(Integer.toString(ammo2No));

        } else if (ammoSpinner.getSelectedItem().toString().equals(ammo3Name)){
            // Setting the display of the amount of ammo remaining for ammo3
            ammoMaxDisplay.setText(Integer.toString(ammo3No));

        } else if (ammoSpinner.getSelectedItem().toString().equals(ammo4Name)){
            // Setting the display of the amount of ammo remaining for ammo4
            ammoMaxDisplay.setText(Integer.toString(ammo4No));
        }

    }


    // Method for setting the FP display
    public void setFPDisplay(int mode){
        /* Mode:
        0: Initialising onCreate
        1: Spend FP
        2: Burn FP
        */

        String FPString;

        switch (mode){
            case 0: // Initialising onCreate

                // User has no FP, shouldn't be able to use button
                if (currentFP == 0){
                    buttonFPRoll.setEnabled(false);

                    // Building string to display
                    FPString = currentFP + "/" + maxFP;

                    // Setting the text on the display with the created FPString
                    FPDisplay.setText(FPString);

                } else {

                    // Building the string to display
                    FPString = currentFP + "/" + maxFP;

                    // Setting the text on the display with the created FPString
                    FPDisplay.setText(FPString);
                }

                break;

            case 1: // Updating the FP display after spending

                // Spends one FP
                currentFP--;

                // Building string to display
                FPString = currentFP + "/" + maxFP;

                // Setting the text on the display with the created FPString
                FPDisplay.setText(FPString);

                break;

            case 2: // updating the FP display after a burn

                // Tests to see how best to remove a FP
                if (currentFP == maxFP){
                    currentFP--;
                    maxFP--;

                } else if (currentFP < maxFP){
                    maxFP--;
                }

                // Building string to display
                FPString = currentFP + "/" + maxFP;

                // Setting the text on the display with the created FPString
                FPDisplay.setText(FPString);

                break;
        }
    }


    // Method for updating the roll threshold value and display
    public void updateThreshold(int attVal){
        // Retrieves the current value of the modifier
        //int modVal =


        // Tests to see if it first has to half the attribute value because of an unskilled roll
        if (unskilledCheckBox.isChecked()){
            // Should it be checked the attribute value will be halved and then updated

            // unskilled penalty
            attVal += -20;

            // Adds to the remaining attribute value to the modifier
            attVal += modifierValue;

            // Sets the new value of the threshold
            rollThreshold = attVal;

            // Tests to see if the new roll threshold is outside possible range of 0 < x > 100
            if (rollThreshold < 1){
                rollThreshold = 1;
            } else if (rollThreshold > 100){
                rollThreshold = 100;
            }

            // Displays the new threshold value
            rollThresholdDisplay.setText(Integer.toString(rollThreshold));

            // Sets the text to a warning colour
            rollThresholdDisplay.setTextColor(getResources().getColor(R.color.warningRed));

        } else if (!unskilledCheckBox.isChecked()){
            // Should the user uncheck the unskilled box the attribute value will be restored and updated

            // Adds the modifier seekbar's value to the attribute value
            attVal += modifierValue;

            // Sets the new value of the threshold
            rollThreshold = attVal;

            // Tests to see if the new roll threshold is outside possible range of 0 < x > 100
            if (rollThreshold < 1){
                rollThreshold = 1;
            } else if (rollThreshold > 100){
                rollThreshold = 100;
            }

            // Displays the new value
            rollThresholdDisplay.setText(Integer.toString(rollThreshold));

            // Sets the text to the default colour
            rollThresholdDisplay.setTextColor(getResources().getColor(R.color.textPrimary));
        }
    }


    // Method for calculating the damage
    public void getDamageCalc(){

        damageCalcCard.setVisibility(View.VISIBLE);


    }


    // Method for rolling the dice
    public void diceRoll (int mode){
           /*
           Mode:-
           0: Standard Roll
           1: Re-Roll
           2: Spend Fate Point Roll
           3: Burn Fate Point Roll
           */

        // Hiding the damage calc card till needed again
        damageCalcCard.setVisibility(View.GONE);

        // Rolls a d100
        diceRoll = random(1, 100);

        // Weapon jam test
        if (diceRoll > 95){

            // Toasts the user that the weapon has misfired
            Toast.makeText(this, "Weapon Jammed", Toast.LENGTH_LONG).show();

            // Negating the display to avoid confusion
            rollOutcomeDisplay.setText(Integer.toString(diceRoll));
            rollDegreeDisplay.setText("-");
            rollHitLocationDisplay.setText("-");

            buttonRoll.setVisibility(View.GONE);
            buttonReRoll.setVisibility(View.GONE);
            buttonFPRoll.setVisibility(View.GONE);
            buttonBurnRoll.setVisibility(View.GONE);
            buttonUnjam.setVisibility(View.VISIBLE);

            return;
        }

            // Determines which, button specific, actions to take
        switch (mode){
            case 0: // Roll

                // Displays the outcome of the dice roll
                rollOutcomeDisplay.setText(Integer.toString(diceRoll));

                // Disables the roll button from being used repeatedly
                buttonRoll.setEnabled(false);

                // Breaks from the switch to work out degrees success/failure & body location
                break;

            case 1: // ReRoll

                // Displays the outcome of the dice roll
                rollOutcomeDisplay.setText(Integer.toString(diceRoll));

                // Currently doesn't have any behaviours assigned, till used it is just a re-usable roll button
                break;

            case 2: // Spend FP

                // Displays the outcome of the dice roll
                rollOutcomeDisplay.setText(Integer.toString(diceRoll));

                // Subtracts one FP and updates the FP display
                setFPDisplay(1);

                // Tests to see if the FP button now needs disabled from lack of FP
                if (currentFP == 0){
                    // User has now no more FP, button will be disabled
                    buttonFPRoll.setEnabled(false);
                }

                // Spending FP is a standard re-roll, breaks from the switch to work out degrees success/failure & body location
                break;

            case 3: // Burn FP

                // Updates the FP display for the user, showing one maximum FP being lost
                setFPDisplay(2);

                // Disabling all the buttons since burning FP is an auto success
                buttonRoll.setEnabled(false);
                buttonReRoll.setEnabled(false);
                buttonFPRoll.setEnabled(false);
                buttonBurnRoll.setEnabled(false);


                // Burning FP is an auto win, dice rolls are not needed
                rollOutcomeDisplay.setText("-");

                // Displays the degrees of success as a basic success
                rollDegreeDisplay.setText(getString(R.string.zero_degrees_of_success));

                // Burning a FP only counts for one successful shot
                getHitLocation(diceRoll, 1);

                // Burning FP is an auto success so it doesn't need to determine the degrees of success/failure
                return;
        }

        if (diceRoll == rollThreshold){ // Just barely a success

            // A success with 0 degrees, displays the degree outcome
            rollDegreeDisplay.setText(getString(R.string.zero_degrees_of_success));

            // Find the location of the hit(s)
            getHitLocation(diceRoll, 0);

            // Method to work on the value of damage
            getDamageCalc();

        } else if (diceRoll > rollThreshold){ // A failed roll

            // Formula to work out the amount of degree(s) of failure
            degreeResult = ((diceRoll - rollThreshold) / 10);

            // Testing to see how many degrees of failure and which text to construct and display
            if (degreeResult == 0){
                // Displays a report of "Zero degrees of failure"
                rollDegreeDisplay.setText(getString(R.string.zero_degrees_of_failure));

                rollHitLocationDisplay.setText("-");

            } else if (degreeResult == 1){
                // Displays a report of "One degree of failure"
                rollDegreeDisplay.setText(getString(R.string.one_degree_of_failure));

                rollHitLocationDisplay.setText("-");

            } else if (degreeResult > 1){
                // Must create the string outside of .setText()
                String outcomeString = degreeResult + " " + getString(R.string.many_degrees_of_failure);

                // Displays a report of "x degrees of failure"
                rollDegreeDisplay.setText(outcomeString);

                rollHitLocationDisplay.setText("-");
            }

        } else if (diceRoll < rollThreshold){ // A successful roll

            // Formula to work out the amount of degree(s) of success
            degreeResult = ((rollThreshold - diceRoll) / 10);

            // Testing to see how many degrees of success and which text to construct and display
            if (degreeResult == 0){
                // Display a report of "Zero degrees of success"
                rollDegreeDisplay.setText(getString(R.string.zero_degrees_of_success));

                // Find the location of the hit(s)
                getHitLocation(diceRoll, degreeResult);

                // Method to work on the value of damage
                getDamageCalc();

            } else if (degreeResult == 1){
                // Displays a report of one degree of success
                rollDegreeDisplay.setText(getString(R.string.one_degree_of_success));

                // Find the location of the hit(s)
                getHitLocation(diceRoll, degreeResult);

                // Method to work on the value of damage
                getDamageCalc();

            } else if (degreeResult > 1){
                // Must create the string outside of .setText()
                String outcomeString = (degreeResult + " " + getString(R.string.many_degrees_of_success));

                // Displays a report of "x degrees of success"
                rollDegreeDisplay.setText(outcomeString);

                // Find the location of the hit(s)
                getHitLocation(diceRoll, degreeResult);

                // Method to work on the value of damage
                getDamageCalc();
            }
        }
    }


    // Method for finding the hit location
    public void getHitLocation (int diceRoll, int degreeSuccess){

        // String array to store the list of hit location outcomes
        ArrayList<String> hitLocationsList = new ArrayList<String>();

        // Variable for picking which side of the body to work on
        int coinFlip = random(0, 2);

        // Variable for the final value of the inverted diceroll
        int invDiceRoll;

        // Checking to see if the dice roll is <10
        if (diceRoll < 10){

            // Flipping the single digit value and storing it as an integer
            invDiceRoll = Integer.parseInt(diceRoll + "0");

        } else { // if it is greater than 9 then the value will have to be inverted fully - DO NOT QUESTION WHY ONLY THIS WAY WORKS, I KNOW THERE'S SIMPLER ONE LINE WAYS OF DOING IT

            // Converting the dice roll to a string
            String diceRollString = Integer.toString(diceRoll);

            // Splitting each "character" of the string into individual items in a list
            String diceRollSplitString[] = diceRollString.split("");

            // Building a new string with the order of the list reversed
            StringBuilder invDiceRollBuilder = new StringBuilder();
            invDiceRollBuilder.append(diceRollSplitString[1]);
            invDiceRollBuilder.append(diceRollSplitString[0]);

            // Storing the constructed inverted string as a usable integer
            invDiceRoll = Integer.parseInt(invDiceRollBuilder.toString().trim());
        }



        // Searching through the list of possible locations to find where the first hit lands
        // Checking if the first location is the head
        for (int i : hitHead){
            if (i == invDiceRoll){
                hitLocationsList.add("Head");
            }
        }

        // Checking if the first location is the R.Arm
        for (int i : hitRArm){
            if (i == invDiceRoll){
                hitLocationsList.add("R.Arm");
            }
        }

        // Checking if the first location is the L.Arm
        for (int i : hitLArm){
            if (i == invDiceRoll){
                hitLocationsList.add("L.Arm");
            }
        }

        // Checking if the first location is the Body
        for (int i : hitBody){
            if (i == invDiceRoll){
                hitLocationsList.add("Body");
            }
        }

        // Checking if the first location is the R.Leg
        for (int i : hitRLeg){
            if (i == invDiceRoll){
                hitLocationsList.add("R.Leg");
            }
        }

        // Checking if the first location is the L.Leg
        for (int i : hitLLeg){
            if (i == invDiceRoll){
                hitLocationsList.add("L.Leg");
            }
        }

        // If the first hit location is the head, iterate through each of the consecutive shots from the hitOrder list
        if (hitLocationsList.get(0).equals(hitOrderHead[0])) {

            // for loop to iterate through each of the entries in the hit order. It will pass over anything that has just the one, already, recorded locations
            for (int i = 1; i <= degreeSuccess; i++){

                if (i >= 5){ // if greater than 5 it will have to repeat the last entry in the hitLocationArray

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderHead[5].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                    // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderHead[5].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                    // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderHead[5]);
                    }


                } else { // Count has not yet reached the end of the locationArray, add list entry normally

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderHead[i].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                    // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderHead[i].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                    // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderHead[i]);
                    }
                }
            }
        }

        // If the first hit location is the R.Arm, iterate through each of the consecutive shots from the hitOrder list
        if (hitLocationsList.get(0).equals("R.Arm")){

            // for loop to iterate through each of the entries in the hit order. It will pass over anything that has just the one, already, recorded locations
            for (int i = 1; i <= degreeSuccess; i++){

                if (i >= 5){ // if greater than 5 it will have to repeat the last entry in the hitLocationArray

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderArm[5].equals("Arm")){

                        hitLocationsList.add("R.Arm");

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderArm[5].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderArm[5]);
                    }

                } else { // Count has not yet reached the end of the locationArray, add list entry normally

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderArm[i].equals("Arm")){

                        hitLocationsList.add("R.Arm");

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderArm[i].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderArm[i]);
                    }
                }
            }
        }

        // If the first hit location is the L.Arm, iterate through each of the consecutive shots from the hitOrder list
        if (hitLocationsList.get(0).equals("L.Arm")){

            // for loop to iterate through each of the entries in the hit order. It will pass over anything that has just the one, already, recorded locations
            for (int i = 1; i <= degreeSuccess; i++){

                if (i >= 5){ // if greater than 5 it will have to repeat the last entry in the hitLocationArray

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderArm[5].equals("Arm")){

                        hitLocationsList.add("L.Arm");

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderArm[5].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderArm[5]);
                    }

                } else { // Count has not yet reached the end of the locationArray, add list entry normally

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderArm[i].equals("Arm")){

                        hitLocationsList.add("L.Arm");

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderArm[i].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderArm[i]);
                    }
                }
            }
        }

        // If the first hit location is the Body, iterate through each of the consecutive shots from the hitOrder list
        if (hitLocationsList.get(0).equals(hitOrderBody[0])){

            // for loop to iterate through each of the entries in the hit order. It will pass over anything that has just the one, already, recorded locations
            for (int i = 1; i <= degreeSuccess; i++){

                if (i >= 5){ // if greater than 5 it will have to repeat the last entry in the hitLocationArray

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderBody[5].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderBody[5].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderBody[5]);
                    }


                } else { // Count has not yet reached the end of the locationArray, add list entry normally

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderBody[i].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderBody[i].equals("Leg")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Leg");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Leg");
                        }

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderBody[i]);
                    }
                }
            }
        }

        // If the first hit location is the R.Leg, iterate through each of the consecutive shots from the hitOrder list
        if (hitLocationsList.get(0).equals("R.Leg")){

            // for loop to iterate through each of the entries in the hit order. It will pass over anything that has just the one, already, recorded locations
            for (int i = 1; i <= degreeSuccess; i++){

                if (i >= 5){ // if greater than 5 it will have to repeat the last entry in the hitLocationArray

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderLeg[5].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderLeg[5].equals("Leg")){

                        hitLocationsList.add("R.Leg");

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderLeg[5]);
                    }


                } else { // Count has not yet reached the end of the locationArray, add list entry normally

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderLeg[i].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderLeg[i].equals("Leg")){

                        hitLocationsList.add("R.Leg");

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderLeg[i]);
                    }
                }
            }
        }

        // If the first hit location is the L.Leg, iterate through each of the consecutive shots from the hitOrder list
        if (hitLocationsList.get(0).equals("L.Leg")){

            // for loop to iterate through each of the entries in the hit order. It will pass over anything that has just the one, already, recorded locations
            for (int i = 1; i <= degreeSuccess; i++){

                if (i >= 5){ // if greater than 5 it will have to repeat the last entry in the hitLocationArray

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderLeg[5].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderLeg[5].equals("Leg")){

                        hitLocationsList.add("L.Leg");

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderLeg[5]);
                    }


                } else { // Count has not yet reached the end of the locationArray, add list entry normally

                    // Checks to see if the entry is an arm and adds the designated one to the list
                    if (hitOrderLeg[i].equals("Arm")){

                        if (coinFlip == 0){ // consider "0" as R.Arm
                            hitLocationsList.add("R.Arm");

                        } else if (coinFlip == 1){ // consider "1" as L.Arm
                            hitLocationsList.add("L.Arm");
                        }

                        // Checks to see if the entry is an leg and adds the designated one to the list
                    } else if (hitOrderLeg[i].equals("Leg")){

                        hitLocationsList.add("L.Leg");

                        // If the entry is not an arm or a leg, add the item to the list
                    } else {

                        hitLocationsList.add(hitOrderLeg[i]);
                    }
                }
            }
        }

        // TODO - write list to string constructor
        String hitLocationString = hitLocationsList.stream().collect(Collectors.joining(", "));

        // Setting the display of the resulting hit locations
        rollHitLocationDisplay.setText(hitLocationString);
    }


    // Method for spending ammo
    public void updateAmmo(int rate){

        ammoMaxDisplay.setText(Integer.parseInt(ammoMaxDisplay.getText().toString().trim()) - rate);
    }


    // Method for updating the ammo counter, and causing a reload
    public void getAmmoDisplay(int clip, int max){

        if (clip == 0 && max != 0){ // Clip needs reloading
            buttonReload.setVisibility(View.VISIBLE);

            buttonRoll.setVisibility(View.GONE);
            buttonReRoll.setVisibility(View.GONE);
            buttonFPRoll.setVisibility(View.GONE);
            buttonBurnRoll.setVisibility(View.GONE);
        } else if ()

            // TODO - write ammo display logic
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs);

        // Initialising shared preferences for onCreate()
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);



        // Attaching the view ID's
        bsTitleVal              = findViewById(R.id.bsValTextView);
        wepStatString           = findViewById(R.id.bs_WeaponStatsTextView);

        ammoMaxDisplay          = findViewById(R.id.ammoMaxValTextView);
        ammoClipDisplay         = findViewById(R.id.ammoCurrentClipTextView);
        ammoDashDisplay         = findViewById(R.id.ammoCounterDash);
        modifierDisplay         = findViewById(R.id.bsRollModifierValTextView);
        rollThresholdDisplay    = findViewById(R.id.rollThresholdTextView);
        rollOutcomeDisplay      = findViewById(R.id.rollOutcomeTextView);
        rollDegreeDisplay       = findViewById(R.id.rollDegreeTextView);
        rollHitLocationDisplay  = findViewById(R.id.rollHitLocationTextView);

        FPDisplay               = findViewById(R.id.bsFPTrackerValTextView);

        wepSpinner              = findViewById(R.id.WeaponSelectorSpinner);
        ammoSpinner             = findViewById(R.id.AmmoSelectorSpinner);

        buttonModPlus           = findViewById(R.id.bsRollModifierPlusImageButton);
        buttonModMinus          = findViewById(R.id.bsRollModifierMinusImageButton);
        buttonRoll              = findViewById(R.id.bsRollButton);
        buttonReRoll            = findViewById(R.id.bsReRollButton);
        buttonFPRoll            = findViewById(R.id.bsFatePointButton);
        buttonBurnRoll          = findViewById(R.id.bsBurnButton);
        buttonUnjam             = findViewById(R.id.bsJamButton);
        buttonHitCounterUp      = findViewById(R.id.damageRollUpImageButton);
        buttonHitCounterDown    = findViewById(R.id.damageRollDownImageButton);
        buttonReload            = findViewById(R.id.bsReloadButton);

        radioManual             = findViewById(R.id.bsRoFManualRadioButton);
        radioSemi               = findViewById(R.id.bsRoFSemiRadioButton);
        radioFull               = findViewById(R.id.bsRoFFullRadioButton);

        modifierSeekBar         = findViewById(R.id.bsRollModifierSeekBar);

        unskilledCheckBox       = findViewById(R.id.unskilledCheckBox);

        damageCalcCard          = findViewById(R.id.damageRollCard);



        // Loading the values of the weapons into variables
        BSkillVal               = Integer.parseInt(sharedPreferences.getString("character_bs", ""));
        currentFP               = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));
        maxFP                   = Integer.parseInt(sharedPreferences.getString("character_max_fp", ""));

        wep1Name                = sharedPreferences.getString("mis1WepName", "");
        wep1Class               = sharedPreferences.getString("mis1ClassString", "");
        wep1Damage_x            = sharedPreferences.getString("mis1Damage_x", "");
        wep1Damage_y            = sharedPreferences.getString("mis1Damage_y", "");
        wep1Damage_z            = sharedPreferences.getString("mis1Damage_z", "");
        wep1Type                = sharedPreferences.getString("mis1TypeString", "");
        wep1Range               = sharedPreferences.getString("mis1Range", "");
        wep1RoF_x               = sharedPreferences.getString("mis1ROF_x", "");
        wep1RoF_y               = sharedPreferences.getString("mis1ROF_y", "");
        wep1RoF_z               = sharedPreferences.getString("mis1ROF_z", "");
        wep1Clip                = sharedPreferences.getString("mis1Clip", "");
        wep1RLD                 = sharedPreferences.getString("mis1RLDString", "");
        wep1Pen                 = sharedPreferences.getString("mis1Pen", "");
        wep1SpecialRules        = sharedPreferences.getString("mis1SpecialRules", "");

        wep2Name                = sharedPreferences.getString("mis2WepName", "");
        wep2Class               = sharedPreferences.getString("mis2ClassString", "");
        wep2Damage_x            = sharedPreferences.getString("mis2Damage_x", "");
        wep2Damage_y            = sharedPreferences.getString("mis2Damage_y", "");
        wep2Damage_z            = sharedPreferences.getString("mis2Damage_z", "");
        wep2Type                = sharedPreferences.getString("mis2TypeString", "");
        wep2Range               = sharedPreferences.getString("mis2Range", "");
        wep2RoF_x               = sharedPreferences.getString("mis2ROF_x", "");
        wep2RoF_y               = sharedPreferences.getString("mis2ROF_y", "");
        wep2RoF_z               = sharedPreferences.getString("mis2ROF_z", "");
        wep2Clip                = sharedPreferences.getString("mis2Clip", "");
        wep2RLD                 = sharedPreferences.getString("mis2RLDString", "");
        wep2Pen                 = sharedPreferences.getString("mis2Pen", "");
        wep2SpecialRules        = sharedPreferences.getString("mis2SpecialRules", "");

        wep3Name                = sharedPreferences.getString("mis3WepName", "");
        wep3Class               = sharedPreferences.getString("mis3ClassString", "");
        wep3Damage_x            = sharedPreferences.getString("mis3Damage_x", "");
        wep3Damage_y            = sharedPreferences.getString("mis3Damage_y", "");
        wep3Damage_z            = sharedPreferences.getString("mis3Damage_z", "");
        wep3Type                = sharedPreferences.getString("mis3TypeString", "");
        wep3Range               = sharedPreferences.getString("mis3Range", "");
        wep3RoF_x               = sharedPreferences.getString("mis3ROF_x", "");
        wep3RoF_y               = sharedPreferences.getString("mis3ROF_y", "");
        wep3RoF_z               = sharedPreferences.getString("mis3ROF_z", "");
        wep3Clip                = sharedPreferences.getString("mis3Clip", "");
        wep3RLD                 = sharedPreferences.getString("mis3RLDString", "");
        wep3Pen                 = sharedPreferences.getString("mis3Pen", "");
        wep3SpecialRules        = sharedPreferences.getString("mis3SpecialRules", "");

        wep4Name                = sharedPreferences.getString("mis4WepName", "");
        wep4Class               = sharedPreferences.getString("mis4ClassString", "");
        wep4Damage_x            = sharedPreferences.getString("mis4Damage_x", "");
        wep4Damage_y            = sharedPreferences.getString("mis4Damage_y", "");
        wep4Damage_z            = sharedPreferences.getString("mis4Damage_z", "");
        wep4Type                = sharedPreferences.getString("mis4TypeString", "");
        wep4Range               = sharedPreferences.getString("mis4Range", "");
        wep4RoF_x               = sharedPreferences.getString("mis4ROF_x", "");
        wep4RoF_y               = sharedPreferences.getString("mis4ROF_y", "");
        wep4RoF_z               = sharedPreferences.getString("mis4ROF_z", "");
        wep4Clip                = sharedPreferences.getString("mis4Clip", "");
        wep4RLD                 = sharedPreferences.getString("mis4RLDString", "");
        wep4Pen                 = sharedPreferences.getString("mis4Pen", "");
        wep4SpecialRules        = sharedPreferences.getString("mis4SpecialRules", "");

        ammo1Name               = sharedPreferences.getString("ammo1Name", "");
        ammo2Name               = sharedPreferences.getString("ammo2Name", "");
        ammo3Name               = sharedPreferences.getString("ammo3Name", "");
        ammo4Name               = sharedPreferences.getString("ammo4Name", "");



        // Check to see if weapon list is empty, if so - disable list
        if (!(wep1Name.isEmpty() && wep2Name.isEmpty() && wep3Name.isEmpty() && wep4Name.isEmpty())){
            // Creating the array to use for the ballistic weapons list drop down menu
            List<String> weaponList = new ArrayList<>();

            // Selecting which weapons to include in the list, discarding empty weapon slots
            if (!(wep1Name.isEmpty())){
                weaponList.add(wep1Name);
            }

            if (!(wep2Name.isEmpty())){
                weaponList.add(wep2Name);
            }

            if (!(wep3Name.isEmpty())){
                weaponList.add(wep3Name);
            }

            if (!(wep4Name.isEmpty())){
                weaponList.add(wep4Name);
            }

            // Attaching the created list to a new arrayAdapter
            ArrayAdapter<String> weaponAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weaponList);
            weaponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            wepSpinner.setAdapter(weaponAdapter);
            wepSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    setWepStatString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        } else {
            wepSpinner.setEnabled(false);
        }



        // Check to see if the ammo list is empty, if so - disable the spinner
        if (!(ammo1Name.isEmpty() && ammo2Name.isEmpty() && ammo3Name.isEmpty() && ammo4Name.isEmpty())){
            // Selecting which ammunition to use in the ammo list drop down menu
            List<String> ammoList = new ArrayList<>();

            if (!(ammo1Name.isEmpty())){
                ammoList.add(ammo1Name);
            }

            if (!(ammo2Name.isEmpty())){
                ammoList.add(ammo2Name);
            }

            if (!(ammo3Name.isEmpty())){
                ammoList.add(ammo3Name);
            }

            if (!(ammo4Name.isEmpty())){
                ammoList.add(ammo4Name);
            }

            // Attaching the ammo list to the arrayAdapter
            ArrayAdapter<String> ammoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ammoList);
            ammoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ammoSpinner.setAdapter(ammoAdapter);
            ammoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    setAmmoDisplay();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        } else {
            ammoSpinner.setEnabled(false);
        }



        // Creating the modifier seekbar
        modifierSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                // Changes the display of the text view showing the user the current modifier
                modifierDisplay.setText(Integer.toString(i - 60));

                // Updates the modifier value
                modifierValue = i - 60;

                // Updates the threshold value display
                updateThreshold(BSkillVal);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        // Creating the onClickListener for the modifier +1 button
        buttonModPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check to ensure modifier value never goes further than 0 < x > 100
                if (modifierValue < 60){

                    // Adds one to the modifier value
                    modifierValue++;

                    // Displays the updated value
                    modifierDisplay.setText(Integer.toString(modifierValue));

                    // Moves the position of the modifier seekbar one notch up
                    modifierSeekBar.setProgress(modifierSeekBar.getProgress() + 1);

                    // Updates the roll Threshold value
                    updateThreshold(BSkillVal);
                }
            }
        });



        // Creating the onClickListener for the modifier -1 button
        buttonModMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checks to ensure the modifier value never goes further than 0 < x > 100
                if (modifierValue > -60){

                    // Subtracts one from the modifier value
                    modifierValue--;

                    // Displays the updated value
                    modifierDisplay.setText(Integer.toString(modifierValue));

                    // Moves the position of the modifier seekbar on notch down
                    modifierSeekBar.setProgress(modifierSeekBar.getProgress() - 1);

                    // Updates the roll threshold value
                    updateThreshold(BSkillVal);
                }

            }
        });



        // Creating onToggleListener for the unskilled checkbox
        unskilledCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateThreshold(BSkillVal);
            }
        });



        // Creating onClickListener for the standard roll
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(0);
            }
        });



        // Creating onClickListener for the re-roll
        buttonReRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(1);
            }
        });



        // Creating onClickListener for the FP re-roll
        buttonFPRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(2);
            }
        });



        // Creating onClickListener for the burn button
        buttonBurnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceRoll(3);
            }
        });



        // Creating onClickListener for the unJam button
        buttonUnjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Simple button acknowledgement so user knows to unjam
                buttonRoll.setVisibility(View.VISIBLE);
                buttonReRoll.setVisibility(View.VISIBLE);
                buttonFPRoll.setVisibility(View.VISIBLE);
                buttonBurnRoll.setVisibility(View.VISIBLE);
                buttonUnjam.setVisibility(View.GONE);

                // Removes one spent ammo
                updateAmmo(1);

            }
        });



        buttonHitCounterUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO - write hit counter up logic
            }
        });



        buttonHitCounterDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // TODO - write hit counter down logic
            }
        });


        buttonReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO - write reload logic

            }
        });



        // Setting the display for the user's BS
        bsTitleVal.setText(Integer.toString(BSkillVal));

        // Setting the initial roll threshold to the default
        rollThreshold = BSkillVal;
        rollThresholdDisplay.setText(Integer.toString(rollThreshold));

        // Setting the initial visibility of the stat string textview to visible
        wepStatString.setVisibility(View.VISIBLE);

        // Setting the initial display for the weapon stat string - if no items in inventory, don't set string
        if (wepSpinner.isEnabled()){
            setWepStatString();
        } else {
            wepStatString.setVisibility(View.GONE);
        }

        // Setting the initial display for the ammo - if no items in inventory, don't set string
        if (ammoSpinner.isEnabled()){
            setAmmoDisplay();
        } else {
            ammoMaxDisplay.setText("-");
        }

        // Setting the initial display for the FP
        setFPDisplay(0);

        // Setting the initial display for the modifier value display to "0"
        modifierValue = 0;
        modifierDisplay.setText(Integer.toString(modifierValue));

        // Setting the initial visibility of the damage card to invisible until it is required
        damageCalcCard.setVisibility(View.GONE);

        // Check if Weapon or Ammo spinner are disabled, if so - disable all button presses
        if (!(wepSpinner.isEnabled() && ammoSpinner.isEnabled())){
            buttonRoll.setEnabled(false);
            buttonReRoll.setEnabled(false);
            buttonFPRoll.setEnabled(false);
            buttonBurnRoll.setEnabled(false);
        }

        // TODO - write ammo count logic
        // Setting the ammo max and clip values, then displaying them
        if (sharedPreferences.getString("ammoMax", "").isEmpty()){
            maxAmmo = 0;
        } else {
            maxAmmo = Integer.parseInt(sharedPreferences.getString("ammoMax", ""));
        }

        if (sharedPreferences.getString("ammoClip", "").isEmpty()){
            clipAmmo = 0;
        } else {
            clipAmmo = Integer.parseInt(sharedPreferences.getString("ammoClip", ""));
        }

        getAmmoDisplay(clipAmmo, maxAmmo);


        /*
        // Writing the initial display of the ammo counter
        if (sharedPreferences.getString("ammoMax", "").isEmpty() ){
            buttonRoll.setEnabled(false);
            buttonReRoll.setEnabled(false);
            buttonFPRoll.setEnabled(false);
            buttonBurnRoll.setEnabled(false);

            ammoClipDisplay.setText(Integer.toString(0));
            ammoMaxDisplay.setText(Integer.toString(0));

            ammoClipDisplay.setTextColor(getResources().getColor(R.color.warningRed));
            ammoDashDisplay.setTextColor(getResources().getColor(R.color.warningRed));
            ammoMaxDisplay.setTextColor(getResources().getColor(R.color.warningRed));

        } else {
            maxAmmo = Integer.parseInt(sharedPreferences.getString("ammoMax", ""));
            ammoMaxDisplay.setText(Integer.toString(maxAmmo));
        }

        if (sharedPreferences.getString("ammoClip", "").isEmpty()){

            // TODO - put reload behaviour method here



        } else {
            clipAmmo = Integer.parseInt(sharedPreferences.getString("ammoClip", ""));
            ammoClipDisplay.setText(Integer.toString(clipAmmo));
        }


        ammoClipDisplay.setText(Integer.toString(clipAmmo));
        ammoMaxDisplay.setText(Integer.toString(maxAmmo));

        ammoClipDisplay.setTextColor(getResources().getColor(R.color.textPrimary));
        ammoDashDisplay.setTextColor(getResources().getColor(R.color.textPrimary));
        ammoMaxDisplay.setTextColor(getResources().getColor(R.color.textPrimary));
        */

        // Ensuring wep jam button is disabled onCreate
        buttonUnjam.setVisibility(View.GONE);



    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO - save FP
        // TODO - save ammo

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
