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
    private TextView weaponName;
    private TextView classType;
    private TextView damageVal;
    private TextView typeVal;
    private TextView penVal;
    private TextView specialRules;

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
        weaponName      = view.findViewById(R.id.nameEditText);
        classType       = view.findViewById(R.id.classEditText);
        damageVal       = view.findViewById(R.id.damageEditText);
        typeVal         = view.findViewById(R.id.typeEditText);
        penVal          = view.findViewById(R.id.penetrationEditText);
        specialRules    = view.findViewById(R.id.specialRulesEditText);


        //Returns the view inflater
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Loads the Weapon slot #1 with its stats - currently just strings as placeholders
        // Name of the weapon
        weaponName.setText(sharedPreferences.getString("melee_weapon_name", ""));

        // Class of weapon
        classType.setText(sharedPreferences.getString("melee_weapon_class", ""));

        // Damage modifier
        damageVal.setText(sharedPreferences.getString("melee_weapon_damage", ""));

        // Type of weapon
        typeVal.setText(sharedPreferences.getString("melee_weapon_type", ""));

        // Amount of penetration
        penVal.setText(sharedPreferences.getString("melee_weapon_penetration", ""));

        // Any special rules
        specialRules.setText(sharedPreferences.getString("melee_weapon_special_rules", ""));


    }


    @Override
    public void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Updates the shared preferences with all the character date
        edit.putString("melee_weapon_name", weaponName.getText().toString().trim());
        edit.putString("melee_weapon_class", classType.getText().toString().trim());
        edit.putString("melee_weapon_damage", damageVal.getText().toString().trim());
        edit.putString("melee_weapon_type", typeVal.getText().toString().trim());
        edit.putString("melee_weapon_penetration", penVal.getText().toString().trim());
        edit.putString("melee_weapon_special_rules", specialRules.getText().toString().trim());

        // Applies the changes to the shared preferences file
        edit.apply();
    }

}
