package com.studios.noodle.righteousfury;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab2Inventory extends Fragment {

    // Scope-wide Variables
    private TextView melee_weaponName;
    private TextView melee_classType;
    private TextView melee_damageVal;
    private TextView melee_type;
    private TextView melee_penVal;
    private TextView melee_specialRules;

    private TextView missile_weaponName;
    private TextView missile_classType;
    private TextView missile_damageVal;
    private TextView missile_type;
    private TextView missile_penVal;
    private TextView missile_rangeVal;
    private TextView missile_ROF;
    private TextView missile_clipVal;
    private TextView missile_RLD;
    private TextView missile_special_rules;

    private TextView ammoName;
    private TextView ammoVal;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";


    public tab2Inventory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2inventory, container, false);

        // Creating objects for each of the Edit Texts
        // Melee Weapon
        melee_weaponName        = view.findViewById(R.id.meleeNameEditText);
        melee_classType         = view.findViewById(R.id.meleeClassEditText);
        melee_damageVal         = view.findViewById(R.id.meleeDamageEditText);
        melee_type              = view.findViewById(R.id.meleeTypeEditText);
        melee_penVal            = view.findViewById(R.id.meleePenetrationEditText);
        melee_specialRules      = view.findViewById(R.id.meleeSpecialRulesEditText);

        // Missile Weapon
        missile_weaponName      = view.findViewById(R.id.missileNameEditText);
        missile_classType       = view.findViewById(R.id.missileClassEditText);
        missile_damageVal       = view.findViewById(R.id.missileDamageEditText);
        missile_type            = view.findViewById(R.id.missileTypeEditText);
        missile_penVal          = view.findViewById(R.id.missilePenetrationEditText);
        missile_rangeVal        = view.findViewById(R.id.missileRangeEditText);
        missile_ROF             = view.findViewById(R.id.missileROFEditText);
        missile_clipVal         = view.findViewById(R.id.missileClipEditText);
        missile_RLD             = view.findViewById(R.id.missileRLDEditText);
        missile_special_rules   = view.findViewById(R.id.missileSpecialRulesEditText);

        // Ammo Tracking
        ammoName                = view.findViewById(R.id.AmmoNameEditText);
        ammoVal                 = view.findViewById(R.id.AmmoValEditText);

        //Returns the view inflater
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Loads the melee weapon slot #1 with its stats
        melee_weaponName.setText(sharedPreferences.getString("melee_weapon_name", ""));
        melee_classType.setText(sharedPreferences.getString("melee_weapon_class", ""));
        melee_damageVal.setText(sharedPreferences.getString("melee_weapon_damage", ""));
        melee_type.setText(sharedPreferences.getString("melee_weapon_type", ""));
        melee_penVal.setText(sharedPreferences.getString("melee_weapon_penetration", ""));
        melee_specialRules.setText(sharedPreferences.getString("melee_weapon_special_rules", ""));

        // Loads the missile weapon slot #1 with its stats
        missile_weaponName.setText(sharedPreferences.getString("missile_weapon_name", ""));
        missile_classType.setText(sharedPreferences.getString("missile_weapon_class", ""));
        missile_damageVal.setText(sharedPreferences.getString("missile_weapon_damage", ""));
        missile_type.setText(sharedPreferences.getString("missile_weapon_type", ""));
        missile_penVal.setText(sharedPreferences.getString("missile_weapon_penetration", ""));
        missile_rangeVal.setText(sharedPreferences.getString("missile_weapon_range", ""));
        missile_ROF.setText(sharedPreferences.getString("missile_weapon_rof", ""));
        missile_clipVal.setText(sharedPreferences.getString("missile_weapon_clip", ""));
        missile_RLD.setText(sharedPreferences.getString("missile_weapon_rld", ""));
        missile_special_rules.setText(sharedPreferences.getString("missile_weapon_special_rules", ""));

        // Loads the ammo slot #1 with its stats
        ammoName.setText(sharedPreferences.getString("ammo_name", ""));
        ammoVal.setText(sharedPreferences.getString("ammo_val", ""));

    }


    @Override
    public void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Updates the shared preferences with all the character date
        // Melee Weapons
        edit.putString("melee_weapon_name", melee_weaponName.getText().toString().trim());
        edit.putString("melee_weapon_class", melee_classType.getText().toString().trim());
        edit.putString("melee_weapon_damage", melee_damageVal.getText().toString().trim());
        edit.putString("melee_weapon_type", melee_type.getText().toString().trim());
        edit.putString("melee_weapon_penetration", melee_penVal.getText().toString().trim());
        edit.putString("melee_weapon_special_rules", melee_specialRules.getText().toString().trim());

        // Missile Weapons
        edit.putString("missile_weapon_name", missile_weaponName.getText().toString().trim());
        edit.putString("missile_weapon_class", missile_classType.getText().toString().trim());
        edit.putString("missile_weapon_damage", missile_damageVal.getText().toString().trim());
        edit.putString("missile_weapon_type", missile_type.getText().toString().trim());
        edit.putString("missile_weapon_penetration", missile_penVal.getText().toString().trim());
        edit.putString("missile_weapon_range", missile_rangeVal.getText().toString().trim());
        edit.putString("missile_weapon_rof", missile_ROF.getText().toString().trim());
        edit.putString("missile_weapon_clip", missile_clipVal.getText().toString().trim());
        edit.putString("missile_weapon_rld", missile_RLD.getText().toString().trim());
        edit.putString("missile_weapon_special_rules", missile_special_rules.getText().toString().trim());

        // Ammo
        edit.putString("ammo_name", ammoName.getText().toString().trim());
        edit.putString("ammo_val", ammoVal.getText().toString().trim());

        // Applies the changes to the shared preferences file
        edit.apply();
    }

}
