package com.studios.noodle.righteousfury;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1_Character extends Fragment {

    // #### Temporary stats for a "saved" character ######
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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Outputs the inflater to the return statement
        View view = inflater.inflate(R.layout.tab1_character, container, false);


        // Initialisation of each tab1 buttons
        ImageButton healButton      = view.findViewById(R.id.HPHealButton);
        ImageButton damageButton    = view.findViewById(R.id.HPDamageButton);
        ImageButton fpUpButton      = view.findViewById(R.id.FPPlusButton);
        ImageButton fpDownButton    = view.findViewById(R.id.FPMinusButton);
        ImageButton fpRestoreButton = view.findViewById(R.id.FPRefreshButton);
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
        TextView maxHPValue         = view.findViewById(R.id.HPFractionMax);
        TextView currentHPValue     = view.findViewById(R.id.HPFractionTop);
        TextView maxFPValue         = view.findViewById(R.id.FPFractionMax);
        TextView currentFPValue     = view.findViewById(R.id.FPFractionTop);
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

            }
        });

        // Damage HP Button
        damageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // FP UP Button
        fpUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // FP Down Button
        fpDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // FP Restore to full Button
        fpRestoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
