package com.studios.noodle.righteousfury;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab1Character extends Fragment {

    // Scope-wide Variables
    private ImageButton healButton;
    private ImageButton damageButton;
    private ImageButton fpUpButton;
    private ImageButton fpDownButton;
    private ImageButton wsButton;
    private ImageButton bsButton;
    private ImageButton strButton;
    private ImageButton tButton;
    private ImageButton agButton;
    private ImageButton intButton;
    private ImageButton perButton;
    private ImageButton wpButton;
    private ImageButton felButton;

    private TextView charName;
    private TextView maxHPValue;
    private TextView currentHPValue;
    private TextView maxFPValue;
    private TextView currentFPValue;
    private TextView wsValue;
    private TextView bsValue;
    private TextView strValue;
    private TextView tValue;
    private TextView agValue;
    private TextView intValue;
    private TextView perValue;
    private TextView wpValue;
    private TextView felValue;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";


    public tab1Character() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Outputs the inflater to the return statement
        View view = inflater.inflate(R.layout.fragment_tab1character, container, false);


        // Initialisation of each tab1 buttons
        healButton        = view.findViewById(R.id.HPHealButton);
        damageButton      = view.findViewById(R.id.HPDamageButton);
        fpUpButton        = view.findViewById(R.id.FPUpButton);
        fpDownButton      = view.findViewById(R.id.FPDownButton);
        wsButton          = view.findViewById(R.id.WSRollButton);
        bsButton          = view.findViewById(R.id.BSRollButton);
        strButton         = view.findViewById(R.id.STRRollButton);
        tButton           = view.findViewById(R.id.TRollButton);
        agButton          = view.findViewById(R.id.AgRollButton);
        intButton         = view.findViewById(R.id.INTRollButton);
        perButton         = view.findViewById(R.id.PERRollButton);
        wpButton          = view.findViewById(R.id.WPRollButton);
        felButton         = view.findViewById(R.id.FELRollButton);


        // Initialisation of each tab1 input textView
        charName          = view.findViewById(R.id.CharacterNameEditText);
        maxHPValue        = view.findViewById(R.id.HPFractionMax);
        currentHPValue    = view.findViewById(R.id.HPFractionTop);
        maxFPValue        = view.findViewById(R.id.FPFractionMax);
        currentFPValue    = view.findViewById(R.id.FPFractionTop);
        wsValue           = view.findViewById(R.id.WSStatValue);
        bsValue           = view.findViewById(R.id.BSStatValue);
        strValue          = view.findViewById(R.id.STRStatValue);
        tValue            = view.findViewById(R.id.TStatValue);
        agValue           = view.findViewById(R.id.AGStatValue);
        intValue          = view.findViewById(R.id.INTStatValue);
        perValue          = view.findViewById(R.id.PERStatValue);
        wpValue           = view.findViewById(R.id.WPStatValue);
        felValue          = view.findViewById(R.id.FELStatValue);


        // Button actions:
        // Heal HP Button
        healButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Parses the textview into a string, then into an integer
                String string_currentHPValue = currentHPValue.getText().toString();
                int HP = Integer.parseInt(string_currentHPValue);

                String string_maxHPValue = maxHPValue.getText().toString();
                int maxHP = Integer.parseInt(string_maxHPValue);

                // if hp is less than max, heal 1 HP. if not, ignore
                if (HP + 1 <= maxHP){
                    HP++;
                    currentHPValue.setText(Integer.toString(HP));
                }
            }
        });

        // Damage HP Button
        damageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Parses the textview into a string, then into an integer
                String string_currentHPValue = currentHPValue.getText().toString();
                int HP = Integer.parseInt(string_currentHPValue);

                // if hp is not 0, damage by 1HP. if >0 - ignore
                if (HP - 1 >= 0){
                    HP--;
                    currentHPValue.setText(Integer.toString(HP));
                }

            }
        });

        // FP UP Button
        fpUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Parses the textview into a string, then into an integer
                String string_currentFPValue = currentFPValue.getText().toString();
                int FP = Integer.parseInt(string_currentFPValue);

                String string_maxFPValue = maxFPValue.getText().toString();
                int maxFP = Integer.parseInt(string_maxFPValue);

                if (FP + 1 <= maxFP){
                    FP++;
                    currentFPValue.setText(Integer.toString(FP));
                }
            }
        });

        // FP Down Button
        fpDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Parses the textview into a string, then into an integer
                String string_currentFPValue = currentFPValue.getText().toString();
                int FP = Integer.parseInt(string_currentFPValue);

                if (FP -1 >= 0){
                    FP--;
                    currentFPValue.setText(Integer.toString(FP));
                }
            }
        });

        // Weapon Skill Roll Button
        wsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Ballistic Skill Roll Button
        bsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Strength Roll Button
        strButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Toughness Roll Button
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Agility Roll Button
        agButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Intelligence Roll Button
        intButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Perception Roll Button
        perButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Willpower Roll Button
        wpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Fellowship Roll Button
        felButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Returns the view inflater
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Loading of stored character - using string placeholders at the moment
        // Display Character's Name
        charName.setText(sharedPreferences.getString("character_name", ""));

        // Display Max. HP
        maxHPValue.setText(sharedPreferences.getString("character_max_hp", ""));

        // Display Current HP
        // If the currentHPValue text view has no value saved in shared preferences - output "0"
        if (sharedPreferences.getString("character_current_hp", "").equals("")){
            currentHPValue.setText("0");
        } else {
            currentHPValue.setText(sharedPreferences.getString("character_current_hp", ""));
        }

        // Display Max. FP
        maxFPValue.setText(sharedPreferences.getString("character_max_fp", ""));

        // Display Current FP
        // if the currentFPValue text view has no value saved in shared preferences - output "0"
        if (sharedPreferences.getString("character_current_fp", "").equals("")){
            currentFPValue.setText("0");
        } else {
            currentFPValue.setText(sharedPreferences.getString("character_current_fp", ""));
        }

        // Display Weapon Skill Value
        wsValue.setText(sharedPreferences.getString("character_ws", ""));

        // Display Ballistic Skill Value
        bsValue.setText(sharedPreferences.getString("character_bs", ""));

        // Display Strength Value
        strValue.setText(sharedPreferences.getString("character_str", ""));

        // Display Toughness Value
        tValue.setText(sharedPreferences.getString("character_t", ""));

        // Display Agility Value
        agValue.setText(sharedPreferences.getString("character_ag",""));

        // Display Intelligence Value
        intValue.setText(sharedPreferences.getString("character_int", ""));

        // Display Perception Value
        perValue.setText(sharedPreferences.getString("character_per", ""));

        // Display Willpower Value
        wpValue.setText(sharedPreferences.getString("character_wp", ""));

        // Display Fellowship Value
        felValue.setText(sharedPreferences.getString("character_fel", ""));

    }


    @Override
    public void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Updated the shared preferences with all the character data
        edit.putString("character_name", charName.getText().toString().trim());
        edit.putString("character_max_hp", maxHPValue.getText().toString().trim());
        edit.putString("character_current_hp", currentHPValue.getText().toString().trim());
        edit.putString("character_max_fp", maxFPValue.getText().toString().trim());
        edit.putString("character_current_fp", currentFPValue.getText().toString().trim());
        edit.putString("character_ws", wsValue.getText().toString().trim());
        edit.putString("character_bs", bsValue.getText().toString().trim());
        edit.putString("character_str", strValue.getText().toString().trim());
        edit.putString("character_t", tValue.getText().toString().trim());
        edit.putString("character_ag", agValue.getText().toString().trim());
        edit.putString("character_int", intValue.getText().toString().trim());
        edit.putString("character_per", perValue.getText().toString().trim());
        edit.putString("character_wp", wpValue.getText().toString().trim());
        edit.putString("character_fel", felValue.getText().toString().trim());

        // Applies the changes to the shared preferences file
        edit.apply();

    }


}