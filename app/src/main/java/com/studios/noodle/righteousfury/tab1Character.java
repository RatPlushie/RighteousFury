package com.studios.noodle.righteousfury;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab1Character extends Fragment {

    public tab1Character() {
        // Required empty public constructor
    }



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



    public void navRollActivity(int mode, String attName, TextView attVal){
        /* Method for the user navigating between roll activities
           Mode:-
           0: WS
           1: BS
           2: Str, T, Ag, Int, Per, Wp, Fel
        */

        // Test to see if the user has filled in the required information for the character attributes
        if (!(attVal.getText().toString().trim().isEmpty()) && !(maxFPValue.getText().toString().trim().isEmpty())){

            // Deciding what information needs passed through
            switch (mode){
                case 0: // WS

                    // Create the wsActivity.class specific intent
                    Intent wsIntent = new Intent(getActivity(), wsActivity.class);

                    // Beginning the activity's intent
                    startActivity(wsIntent);

                    // Overrides the default animation to slide in on right
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    break;

                case 1: // BS

                    // Creating the bsActivity.class specific intent
                    Intent bsIntent = new Intent(getActivity(), bsActivity.class);

                    // Starting the activity's intent
                    startActivity(bsIntent);

                    // Overrides the default animation to slide in on right
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    break;

                case 2: // Str, T, Ag, Int, Per, Wp, Fel

                    // Create intent object - to move from this tab to AttributeRollActivity.class
                    Intent attIntent = new Intent(getActivity(), AttributeRollActivity.class);

                    // Creating bundle object
                    Bundle bundle = new Bundle();

                    // Filling the bundle with the required info
                    bundle.putString("attributeName", attName);
                    bundle.putString("attributeValue", attVal.getText().toString().trim());

                    // Adding the bundle to the intent
                    attIntent.putExtras(bundle);

                    // Beginning the activity's intent
                    startActivity(attIntent);

                    // Overrides the default animation to slide in on right
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    break;
            }

        } else {
            if (attVal.getText().toString().trim().isEmpty()) {
                // Toasts to user if they have not filled in attribute EditText yet
                Toast.makeText(getActivity(), "Please enter your " + attName + " stat first", Toast.LENGTH_SHORT).show();
            }
            if (maxFPValue.getText().toString().trim().isEmpty()){
                // Toasts to user if they have not filled in FP EditText yet
                Toast.makeText(getActivity(), "Please enter your FP first", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Outputs the inflater to the return statement
        View view = inflater.inflate(R.layout.fragment_tab1character, container, false);



        // Tab1 Buttons
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

        // Tab1 TextViews
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



        // Heal HP Button
        healButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks to see if the MaxHP field is empty, if so - to ignore further functionality
                if (!(maxHPValue.getText().toString().isEmpty())){
                    // Parses the text view into a string, then into an integer
                    String string_currentHPValue = currentHPValue.getText().toString();
                    int HP = Integer.parseInt(string_currentHPValue);

                    String string_maxHPValue = maxHPValue.getText().toString();
                    int maxHP = Integer.parseInt(string_maxHPValue);

                    // if hp is less than max, heal 1 HP. if not, ignore
                    if (HP + 1 <= maxHP){
                        HP++;
                        currentHPValue.setText(Integer.toString(HP));
                    }
                } else {
                    // Toasts to user if they have not filled in the EditText yet
                    Toast.makeText(getActivity(), "Please enter your HP first", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Damage HP Button
        damageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks to see if the MaxHP field is empty, if so - to ignore further functionality
                if (!(maxHPValue.getText().toString().isEmpty())){
                    // Parses the textview into a string, then into an integer
                    String string_currentHPValue = currentHPValue.getText().toString();
                    int HP = Integer.parseInt(string_currentHPValue);

                    // if hp is not 0, damage by 1HP. if >0 - ignore
                    if (HP - 1 >= 0){
                        HP--;
                        currentHPValue.setText(Integer.toString(HP));
                    }
                } else {
                    // Toasts to user if they have not filled in the EditText yet
                    Toast.makeText(getActivity(), "Please enter your HP first", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // FP UP Button
        fpUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!maxFPValue.getText().toString().isEmpty()){
                    // Parses the textview into a string, then into an integer
                    String string_currentFPValue = currentFPValue.getText().toString();
                    int FP = Integer.parseInt(string_currentFPValue);

                    String string_maxFPValue = maxFPValue.getText().toString();
                    int maxFP = Integer.parseInt(string_maxFPValue);

                    if (FP + 1 <= maxFP){
                        FP++;
                        currentFPValue.setText(Integer.toString(FP));
                    }
                } else {
                    // Toasts to user if they have not filled in the EditText yet
                    Toast.makeText(getActivity(), "Please enter your FP first", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // FP Down Button
        fpDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!maxFPValue.getText().toString().isEmpty()){
                    // Parses the textview into a string, then into an integer
                    String string_currentFPValue = currentFPValue.getText().toString();
                    int FP = Integer.parseInt(string_currentFPValue);

                    if (FP -1 >= 0){
                        FP--;
                        currentFPValue.setText(Integer.toString(FP));
                    }
                } else {
                    // Toasts to user if they have not filled in the EditText yet
                    Toast.makeText(getActivity(), "Please enter your FP first", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Weapon Skill Roll Button
        wsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the weapon skill roll page
                navRollActivity(0, getString(R.string.stat_ws), wsValue);
            }
        });



        // Ballistic Skill Roll Button
        bsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the ballistic skill roll page
                navRollActivity(1, getString(R.string.stat_bs), bsValue);
            }
        });



        // Strength Roll Button
        strButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the strength roll page
                navRollActivity(2, getString(R.string.stat_str), strValue);
            }
        });



        // Toughness Roll Button
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the toughness roll page
                navRollActivity(2, getString(R.string.stat_t), tValue);
            }
        });



        // Agility Roll Button
        agButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the agility roll page
                navRollActivity(2, getString(R.string.stat_ag), agValue);
            }
        });



        // Intelligence Roll Button
        intButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the intelligence roll page
                navRollActivity(2, getString(R.string.stat_int), intValue);
            }
        });



        // Perception Roll Button
        perButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the perception roll page
                navRollActivity(2, getString(R.string.stat_per), perValue);
            }
        });



        // Willpower Roll Button
        wpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the willpower roll page
                navRollActivity(2, getString(R.string.stat_wp), wpValue);
            }
        });



        // Fellowship Roll Button
        felButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigates to the fellowship roll page
                navRollActivity(2, getString(R.string.stat_fel), felValue);
            }
        });

        // On MaxHP change listener
        maxHPValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentHPValue.setText(maxHPValue.getText());
            }
        });

        // On MaxFP change listener
        maxFPValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentFPValue.setText(maxFPValue.getText());
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