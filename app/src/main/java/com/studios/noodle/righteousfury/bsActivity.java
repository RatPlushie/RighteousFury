package com.studios.noodle.righteousfury;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class bsActivity extends AppCompatActivity {

    // bsActivity vars
    // Text Views for the title card
    private TextView bsTitleVal;

    // Text view for the ammo count display
    private TextView ammoVal;

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

    // Arrays for the ammo and weapon selection
    private ArrayAdapter<CharSequence> adapterWeapon;
    private ArrayAdapter<CharSequence> adapterAmmo;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs);

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

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

        // Spinners
        weaponSelector          = findViewById(R.id.WeaponSelectorSpinner);
        ammoSelector            = findViewById(R.id.AmmoSelectorSpinner);

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

                // Placeholder WIP - displaying a quick toast to show that the correct onItemSelected behaviour shows
                Toast.makeText(getApplicationContext(), "Weapon selector", Toast.LENGTH_SHORT).show();

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

                // Placeholder WIP - displaying a quick toast to show that the correct onItemSelected behaviour shows
                Toast.makeText(getApplicationContext(), "Ammo selector", Toast.LENGTH_SHORT).show();

                // NOTE
                // you can find what is currently selected in the spinner by: weaponSelector.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // TODO - create missile weapon selector

        // TODO - create ammo selector

        // TODO - create ammo counter/tracker

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
