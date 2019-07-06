package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class bsActivity extends AppCompatActivity {

    // bsActivity vars
    // Text Views for the title card
    private TextView bsTitleVal;

    // Text view for the ammo count display
    private TextView ammoVal;

    // Text view for the currently selected weapon display
    private TextView weaponStats;

    // Strings for the modifiers
    private TextView modifierValue;

    // integers for the current and max fp
    private int maxFP;
    private int currentFP;

    // Integers for the ammo quantities
    private int ammo1_Val;

    // Strings for the ballistic weapon stats
    private String weapon1_Name;
    private String weapon1_Class;
    private String weapon1_Damage;
    private String weapon1_Type;
    private String weapon1_Pen;
    private String weapon1_Range;
    private String weapon1_RoF;
    private String weapon1_Clip;
    private String weapon1_Reload;
    private String weapon1_SpecialRules;

    private String weapon2_Name;
    private String weapon2_Class;
    private String weapon2_Damage;
    private String weapon2_Type;
    private String weapon2_Pen;
    private String weapon2_Range;
    private String weapon2_RoF;
    private String weapon2_Clip;
    private String weapon2_Reload;
    private String weapon2_SpecialRules;

    private String weapon3_Name;
    private String weapon3_Class;
    private String weapon3_Damage;
    private String weapon3_Type;
    private String weapon3_Pen;
    private String weapon3_Range;
    private String weapon3_RoF;
    private String weapon3_Clip;
    private String weapon3_Reload;
    private String weapon3_SpecialRules;

    private String weapon4_Name;
    private String weapon4_Class;
    private String weapon4_Damage;
    private String weapon4_Type;
    private String weapon4_Pen;
    private String weapon4_Range;
    private String weapon4_RoF;
    private String weapon4_Clip;
    private String weapon4_Reload;
    private String weapon4_SpecialRules;

    // Strings for the ammo names
    private String ammo1_Name;

    // Spinners for ammo and weapon selection
    private Spinner weaponSelector;
    private Spinner ammoSelector;

    // Seekbars
    private SeekBar bsModifierSeekBar;

    // Arrays for the ammo and weapon selection
    private ArrayAdapter<CharSequence> adapterWeapon;
    private ArrayAdapter<CharSequence> adapterAmmo;

    // Int for Weapon slot selector
    private int weaponSlotSelected;
    private int ammoSlotSelected;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";

    public String getWeaponStatString(int weaponSlot){
        // Method wide variables for writing the string
        String weaponClass;
        String weaponDamage;
        String weaponType;
        String weaponPen;
        String weaponRange;
        String weaponRoF;
        String weaponClip;
        String weaponReload;

        // Switch to decide which weapon stats to write with. listIndex is the position in the spinner list
        switch (weaponSlot){
            case 1: // Uses the weapon #1 slot data
                weaponClass     = weapon1_Class;
                weaponDamage    = weapon1_Damage;
                weaponType      = weapon1_Type;
                weaponPen       = weapon1_Pen;
                weaponRange     = weapon1_Range;
                weaponRoF       = weapon1_RoF;
                weaponClip      = weapon1_Clip;
                weaponReload    = weapon1_Reload;
                break;
            case 2: // Uses the weapon #2 slot data
                weaponClass     = weapon2_Class;
                weaponDamage    = weapon2_Damage;
                weaponType      = weapon2_Type;
                weaponPen       = weapon2_Pen;
                weaponRange     = weapon2_Range;
                weaponRoF       = weapon2_RoF;
                weaponClip      = weapon2_Clip;
                weaponReload    = weapon2_Reload;
                break;
            case 3: // Uses the weapon #3 slot data
                weaponClass     = weapon3_Class;
                weaponDamage    = weapon3_Damage;
                weaponType      = weapon3_Type;
                weaponPen       = weapon3_Pen;
                weaponRange     = weapon3_Range;
                weaponRoF       = weapon3_RoF;
                weaponClip      = weapon3_Clip;
                weaponReload    = weapon3_Reload;
                break;
            case 4: // Uses the weapon #4 slot data
                weaponClass     = weapon4_Class;
                weaponDamage    = weapon4_Damage;
                weaponType      = weapon4_Type;
                weaponPen       = weapon4_Pen;
                weaponRange     = weapon4_Range;
                weaponRoF       = weapon4_RoF;
                weaponClip      = weapon4_Clip;
                weaponReload    = weapon4_Reload;
                break;

                default: // Has a default value in case the initial onCreate call comes empty
                    weaponClass     = "-";
                    weaponDamage    = "-";
                    weaponType      = "-";
                    weaponPen       = "-";
                    weaponRange     = "-";
                    weaponRoF       = "-";
                    weaponClip      = "-";
                    weaponReload    = "-";
        }

        // Creates the string for the return statement
        String outputWeaponStatString = "Class: " + weaponClass
                                        + ", Damage: " + weaponDamage
                                        + ", Type: " + weaponType
                                        + ", Penetration: " + weaponPen
                                        + ", Range: " + weaponRange
                                        + ", Rof: " + weaponRoF
                                        + ", Clip: " + weaponClip
                                        + ", Reload: " + weaponReload;

        return outputWeaponStatString;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs);

        // Initialisation of the shared preference object to load character data onResume
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Retrieving weapon info
        // Slot 1 Weapon
        weapon1_Name            = sharedPreferences.getString("missileWeapon1_Name", "");
        weapon1_Class           = sharedPreferences.getString("missileWeapon1_Class", "");
        weapon1_Damage          = sharedPreferences.getString("missileWeapon1_Damage", "");
        weapon1_Type            = sharedPreferences.getString("missileWeapon1_Type", "");
        weapon1_Pen             = sharedPreferences.getString("missileWeapon1_Penetration", "");
        weapon1_Range           = sharedPreferences.getString("missileWeapon1_Range", "");
        weapon1_RoF             = sharedPreferences.getString("missileWeapon1_RoF", "");
        weapon1_Clip            = sharedPreferences.getString("missileWeapon1_Clip", "");
        weapon1_Reload          = sharedPreferences.getString("missileWeapon1_RLD", "");
        weapon1_SpecialRules    = sharedPreferences.getString("missileWeapon1_SpecialRules", "");

        // Slot 2 Weapon
        weapon2_Name            = sharedPreferences.getString("missileWeapon2_Name", "");
        weapon2_Class           = sharedPreferences.getString("missileWeapon2_Class", "");
        weapon2_Damage          = sharedPreferences.getString("missileWeapon2_Damage", "");
        weapon2_Type            = sharedPreferences.getString("missileWeapon2_Type", "");
        weapon2_Pen             = sharedPreferences.getString("missileWeapon2_Penetration", "");
        weapon2_Range           = sharedPreferences.getString("missileWeapon2_Range", "");
        weapon2_RoF             = sharedPreferences.getString("missileWeapon2_RoF", "");
        weapon2_Clip            = sharedPreferences.getString("missileWeapon2_Clip", "");
        weapon2_Reload          = sharedPreferences.getString("missileWeapon2_RLD", "");
        weapon2_SpecialRules    = sharedPreferences.getString("missileWeapon2_SpecialRules", "");

        // Slot 3 Weapon
        weapon3_Name            = sharedPreferences.getString("missileWeapon3_Name", "");
        weapon3_Class           = sharedPreferences.getString("missileWeapon3_Class", "");
        weapon3_Damage          = sharedPreferences.getString("missileWeapon3_Damage", "");
        weapon3_Type            = sharedPreferences.getString("missileWeapon3_Type", "");
        weapon3_Pen             = sharedPreferences.getString("missileWeapon3_Penetration", "");
        weapon3_Range           = sharedPreferences.getString("missileWeapon3_Range", "");
        weapon3_RoF             = sharedPreferences.getString("missileWeapon3_RoF", "");
        weapon3_Clip            = sharedPreferences.getString("missileWeapon3_Clip", "");
        weapon3_Reload          = sharedPreferences.getString("missileWeapon3_RLD", "");
        weapon3_SpecialRules    = sharedPreferences.getString("missileWeapon3_SpecialRules", "");

        // Slot 4 Weapon
        weapon4_Name            = sharedPreferences.getString("missileWeapon4_Name", "");
        weapon4_Class           = sharedPreferences.getString("missileWeapon4_Class", "");
        weapon4_Damage          = sharedPreferences.getString("missileWeapon4_Damage", "");
        weapon4_Type            = sharedPreferences.getString("missileWeapon4_Type", "");
        weapon4_Pen             = sharedPreferences.getString("missileWeapon4_Penetration", "");
        weapon4_Range           = sharedPreferences.getString("missileWeapon4_Range", "");
        weapon4_RoF             = sharedPreferences.getString("missileWeapon4_RoF", "");
        weapon4_Clip            = sharedPreferences.getString("missileWeapon4_Clip", "");
        weapon4_Reload          = sharedPreferences.getString("missileWeapon4_RLD", "");
        weapon4_SpecialRules    = sharedPreferences.getString("missileWeapon4_SpecialRules", "");

        // Ballistic skill level used by the title card to display their unmodified BS value
        bsTitleVal              = findViewById(R.id.bsValTextView);

        // Ammo info display
        ammoVal                 = findViewById(R.id.ammoQuantityTextView);

        // Weapon info display
        weaponStats             = findViewById(R.id.bs_WeaponStatsTextView);

        // Spinners
        weaponSelector          = findViewById(R.id.WeaponSelectorSpinner);
        ammoSelector            = findViewById(R.id.AmmoSelectorSpinner);

        // Seekbars
        bsModifierSeekBar       = findViewById(R.id.bsRollModifierSeekBar);

        // Textview to display the value of the modifier
        modifierValue           = findViewById(R.id.bsRollModifierValTextView);

        // Converting the max and current FP values to integers
        maxFP                   = Integer.parseInt(sharedPreferences.getString("character_max_fp", ""));
        currentFP               = Integer.parseInt(sharedPreferences.getString("character_current_fp", ""));

        // Setting the display of the character bs stat
        bsTitleVal.setText(sharedPreferences.getString("character_bs", ""));

        // Ammo Slots - Currently only using 1 slot as a placeholder
        ammo1_Name              = sharedPreferences.getString("ammo1_Name", "");
        // Setting the amount of ammo the player has. if no amount is entered then display 0
        if (sharedPreferences.getString("ammo1_Val", "").equals("")){
            ammo1_Val = 0;
        } else {
            ammo1_Val = Integer.parseInt(sharedPreferences.getString("ammo1_Val", ""));
        }

        // Creating the list of ballistic weapons
        List<String> weaponList = new ArrayList<>();
        // If there is no weapon stored in the inventory, do not include it in the list
        if (sharedPreferences.getString("missileWeapon1_Name", "").isEmpty()){
            // Weapon slot 1 is empty, don't include in the list
        } else {
            weaponList.add(sharedPreferences.getString("missileWeapon1_Name", ""));
        }

        if (sharedPreferences.getString("missileWeapon2_Name", "").isEmpty()){
            // Weapon slot 2 is empty, don't include in the list
        } else {
            weaponList.add(sharedPreferences.getString("missileWeapon2_Name", ""));
        }

        if (sharedPreferences.getString("missileWeapon3_Name", "").isEmpty()){
            // Weapon slot 3 is empty, don't include in the list
        } else {
            weaponList.add(sharedPreferences.getString("missileWeapon3_Name", ""));
        }

        if (sharedPreferences.getString("missileWeapon4_Name", "").isEmpty()){
            // Weapon slot 4 is empty, don't include in the list
        } else {
            weaponList.add(sharedPreferences.getString("missileWeapon4_Name", ""));
        }


        // Creating the weapon selector adapter
        ArrayAdapter<String> weaponAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weaponList);
        weaponAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weaponSelector.setAdapter(weaponAdapter);
        weaponSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // override for if any of the entries in the list are selected

                // Changes a global variable to be used as a slot selector later
                weaponSlotSelected = i + 1;

                // Displays the relevant weapon stats to the player on the BS roll page
                weaponStats.setText(getWeaponStatString(weaponSlotSelected));


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Creating the list of ammo types
        List<String> ammoList = new ArrayList<>();
        if (sharedPreferences.getString("ammo1_Name", "").isEmpty()){
            // Ammo slot 1 is empty, don't include in the list
        } else {
            ammoList.add(sharedPreferences.getString("ammo1_Name", ""));
        }


        // Creating the ammo selector adapter
        ArrayAdapter<String> ammoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ammoList);
        ammoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ammoSelector.setAdapter(ammoAdapter);
        ammoSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // override for if any of the entries in the list are selected

                // Changes a global variable to be used as a slot selector later
                ammoSlotSelected = i + 1;

                // On selection of the ammo, this will set the ammo counter's display to the amount in inventory
                ammoVal.setText(sharedPreferences.getString("ammo1_Val", ""));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Setting the initial value of the modifier bar to 0 onCreate
        modifierValue.setText(Integer.toString(0));

        // Creating the modifier seekbar
        bsModifierSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                // Sets the modifier value to the text view above the seekbar
                modifierValue.setText(Integer.toString(i - 60));

                /* TODO - when adding the outcome bars to the bottom. Remeber you will need to add something like these to the bottom similar to AttributeRollActivity

                // Updates the variable to the new roll threshold amount
                threshold = attributeVal + (i - 60);

                // Sets the roll threshold text view
                rollRequiredVal.setText(Integer.toString(threshold));

                */
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        // TODO - create hit location selector (ie. head, chest, foot, ect)

        // TODO - create weapon mode selector (ie. manual, semi-, full- automatic)

        // TODO - re-/store weapon/ammo selection choice



    }

    @Override
    protected void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // TODO - save character data onPause

        /*          OLD CODE ############################################
        // Updated the shared preferences with all the character data
        edit.putString("character_max_fp", Integer.toString(maxFP));
        edit.putString("character_current_fp", Integer.toString(currentFP));

        */

        // Applies the changes to the shared preferences file
        edit.apply();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
