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

    // #### Temporary stats for a "saved" character ######
    String tempName     = "Testy mcTestFace";
    int tempHP          = 13;
    int tempCurrentHP   = 10;
    int tempFP          = 4;
    int tempCurrentFP   = 3;
    int tempWS          = 31;
    int tempBS          = 40;
    int tempSTR         = 31;
    int tempT           = 38;
    int tempAG          = 33;
    int tempINT         = 41;
    int tempPER         = 33;
    int tempWP          = 41;
    int tempFEL         = 26;
    // ###################################################


    public tab1Character() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Outputs the inflater to the return statement
        View view = inflater.inflate(R.layout.fragment_tab1character, container, false);


        // Initialisation of each tab1 buttons
        ImageButton healButton      = view.findViewById(R.id.HPHealButton);
        ImageButton damageButton    = view.findViewById(R.id.HPDamageButton);
        ImageButton fpUpButton      = view.findViewById(R.id.FPUpButton);
        ImageButton fpDownButton    = view.findViewById(R.id.FPDownButton);
        ImageButton wsButton        = view.findViewById(R.id.WSRollButton);
        ImageButton bsButton        = view.findViewById(R.id.BSRollButton);
        ImageButton strButton       = view.findViewById(R.id.STRRollButton);
        ImageButton tButton         = view.findViewById(R.id.TRollButton);
        ImageButton agButton        = view.findViewById(R.id.AgRollButton);
        ImageButton intButton       = view.findViewById(R.id.INTRollButton);
        ImageButton perButton       = view.findViewById(R.id.PERRollButton);
        ImageButton wpButton        = view.findViewById(R.id.WPRollButton);
        ImageButton felButton       = view.findViewById(R.id.FELRollButton);


        // Initialisation of each tab1 input textView
        TextView charName           = view.findViewById(R.id.CharacterNameTextView);
        final TextView maxHPValue         = view.findViewById(R.id.HPFractionMax);
        final TextView currentHPValue     = view.findViewById(R.id.HPFractionTop);
        final TextView maxFPValue         = view.findViewById(R.id.FPFractionMax);
        final TextView currentFPValue     = view.findViewById(R.id.FPFractionTop);
        TextView wsValue            = view.findViewById(R.id.WSStatValue);
        TextView bsValue            = view.findViewById(R.id.BSStatValue);
        TextView strValue           = view.findViewById(R.id.STRStatValue);
        TextView tValue             = view.findViewById(R.id.TStatValue);
        TextView agValue            = view.findViewById(R.id.AGStatValue);
        TextView intValue           = view.findViewById(R.id.INTStatValue);
        TextView perValue           = view.findViewById(R.id.PERStatValue);
        TextView wpValue            = view.findViewById(R.id.WPStatValue);
        TextView felValue           = view.findViewById(R.id.FELStatValue);


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


        // Loading of stored character

        // Display Character's Name
        charName.setText(tempName);

        // Display Max. HP
        maxHPValue.setText(Integer.toString(tempHP));

        // Display Current HP
        currentHPValue.setText(Integer.toString(tempCurrentHP));

        // Display Max. FP
        maxFPValue.setText(Integer.toString(tempFP));

        // Display Current FP
        currentFPValue.setText(Integer.toString(tempCurrentFP));

        // Display Weapon Skill Value
        wsValue.setText(Integer.toString(tempWS));

        // Display Ballistic Skill Value
        bsValue.setText(Integer.toString(tempBS));

        // Display Strength Value
        strValue.setText(Integer.toString(tempSTR));

        // Display Toughness Value
        tValue.setText(Integer.toString(tempT));

        // Display Agility Value
        agValue.setText(Integer.toString(tempAG));

        // Display Intelligence Value
        intValue.setText(Integer.toString(tempINT));

        // Display Perception Value
        perValue.setText(Integer.toString(tempPER));

        // Display Willpower Value
        wpValue.setText(Integer.toString(tempWP));

        // Display Fellowship Value
        felValue.setText(Integer.toString(tempFEL));


        return view;
    }











}