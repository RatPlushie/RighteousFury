package com.studios.noodle.righteousfury;


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

        // Loading of stored character - using string placeholders at the moment
        // Display Character's Name
        charName.setText("Testy mcTestFace");

        // Display Max. HP
        maxHPValue.setText("13");

        // Display Current HP
        currentHPValue.setText("10");

        // Display Max. FP
        maxFPValue.setText("4");

        // Display Current FP
        currentFPValue.setText("3");

        // Display Weapon Skill Value
        wsValue.setText("31");

        // Display Ballistic Skill Value
        bsValue.setText("40");

        // Display Strength Value
        strValue.setText("31");

        // Display Toughness Value
        tValue.setText("38");

        // Display Agility Value
        agValue.setText("33");

        // Display Intelligence Value
        intValue.setText("41");

        // Display Perception Value
        perValue.setText("33");

        // Display Willpower Value
        wpValue.setText("41");

        // Display Fellowship Value
        felValue.setText("26");

    }
}