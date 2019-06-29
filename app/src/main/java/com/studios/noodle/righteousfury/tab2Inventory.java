package com.studios.noodle.righteousfury;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab2Inventory extends Fragment {

    // Scope-wide Variables
    private CardView    meleeCard1;
    private CardView    meleeCard2;
    private CardView    meleeCard3;
    private CardView    meleeCard4;

    private TextView    meleeWeapon1Slot;
    private TextView    meleeWeapon2Slot;
    private TextView    meleeWeapon3Slot;
    private TextView    meleeWeapon4Slot;

    private TextView    melWep1_NameTextView;
    private TextView    melWep1_ClassTextView;
    private TextView    melWep1_DamageTextView;
    private TextView    melWep1_TypeTextView;
    private TextView    melWep1_PenetrationTextView;
    private TextView    melWep1_SpecialRulesTextView;

    private TextView    melWep2_NameTextView;
    private TextView    melWep2_ClassTextView;
    private TextView    melWep2_DamageTextView;
    private TextView    melWep2_TypeTextView;
    private TextView    melWep2_PenetrationTextView;
    private TextView    melWep2_SpecialRulesTextView;

    private TextView    melWep3_NameTextView;
    private TextView    melWep3_ClassTextView;
    private TextView    melWep3_DamageTextView;
    private TextView    melWep3_TypeTextView;
    private TextView    melWep3_PenetrationTextView;
    private TextView    melWep3_SpecialRulesTextView;

    private TextView    melWep4_NameTextView;
    private TextView    melWep4_ClassTextView;
    private TextView    melWep4_DamageTextView;
    private TextView    melWep4_TypeTextView;
    private TextView    melWep4_PenetrationTextView;
    private TextView    melWep4_SpecialRulesTextView;

    private EditText    melWep1_NameEditText;
    private EditText    melWep1_ClassEditText;
    private EditText    melWep1_DamageEditText;
    private EditText    melWep1_TypeEditText;
    private EditText    melWep1_PenetrationEditText;
    private EditText    melWep1_SpecialRulesEditText;

    private EditText    melWep2_NameEditText;
    private EditText    melWep2_ClassEditText;
    private EditText    melWep2_DamageEditText;
    private EditText    melWep2_TypeEditText;
    private EditText    melWep2_PenetrationEditText;
    private EditText    melWep2_SpecialRulesEditText;

    private EditText    melWep3_NameEditText;
    private EditText    melWep3_ClassEditText;
    private EditText    melWep3_DamageEditText;
    private EditText    melWep3_TypeEditText;
    private EditText    melWep3_PenetrationEditText;
    private EditText    melWep3_SpecialRulesEditText;

    private EditText    melWep4_NameEditText;
    private EditText    melWep4_ClassEditText;
    private EditText    melWep4_DamageEditText;
    private EditText    melWep4_TypeEditText;
    private EditText    melWep4_PenetrationEditText;
    private EditText    melWep4_SpecialRulesEditText;

    private View        melWep1_Divider1;
    private View        melWep1_Divider2;

    private View        melWep2_Divider1;
    private View        melWep2_Divider2;

    private View        melWep3_Divider1;
    private View        melWep3_Divider2;

    private View        melWep4_Divider1;
    private View        melWep4_Divider2;

    private ImageButton melParentButton;
    private ImageButton melWep1ExpandButton;
    private ImageButton melWep2ExpandButton;
    private ImageButton melWep3ExpandButton;
    private ImageButton melWep4ExpandButton;

    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";


    private void setMeleeVisibility(int weaponSlot, int visibilityMode){

            // visibilityMode = 0 -> VISIBLE
            // visibilityMode = 4 -> INVISIBLE
            // visibilityMode = 8 -> GONE

            switch (weaponSlot){
                case 1: // Setting melee Weapon slot 1 to required visibility

                    melWep1_NameTextView.setVisibility(visibilityMode);
                    melWep1_NameEditText.setVisibility(visibilityMode);
                    melWep1_Divider1.setVisibility(visibilityMode);
                    melWep1_ClassTextView.setVisibility(visibilityMode);
                    melWep1_ClassEditText.setVisibility(visibilityMode);
                    melWep1_DamageTextView.setVisibility(visibilityMode);
                    melWep1_DamageEditText.setVisibility(visibilityMode);
                    melWep1_TypeTextView.setVisibility(visibilityMode);
                    melWep1_TypeEditText.setVisibility(visibilityMode);
                    melWep1_PenetrationTextView.setVisibility(visibilityMode);
                    melWep1_PenetrationEditText.setVisibility(visibilityMode);
                    melWep1_Divider2.setVisibility(visibilityMode);
                    melWep1_SpecialRulesTextView.setVisibility(visibilityMode);
                    melWep1_SpecialRulesEditText.setVisibility(visibilityMode);

                    break;

                case 2: // Setting melee Weapon slot 2 to required visibility

                    melWep2_NameTextView.setVisibility(visibilityMode);
                    melWep2_NameEditText.setVisibility(visibilityMode);
                    melWep2_Divider1.setVisibility(visibilityMode);
                    melWep2_ClassTextView.setVisibility(visibilityMode);
                    melWep2_ClassEditText.setVisibility(visibilityMode);
                    melWep2_DamageTextView.setVisibility(visibilityMode);
                    melWep2_DamageEditText.setVisibility(visibilityMode);
                    melWep2_TypeTextView.setVisibility(visibilityMode);
                    melWep2_TypeEditText.setVisibility(visibilityMode);
                    melWep2_PenetrationTextView.setVisibility(visibilityMode);
                    melWep2_PenetrationEditText.setVisibility(visibilityMode);
                    melWep2_Divider2.setVisibility(visibilityMode);
                    melWep2_SpecialRulesTextView.setVisibility(visibilityMode);
                    melWep2_SpecialRulesEditText.setVisibility(visibilityMode);

                    break;

                case 3: // Setting melee Weapon slot 3 to required visibility

                    melWep3_NameTextView.setVisibility(visibilityMode);
                    melWep3_NameEditText.setVisibility(visibilityMode);
                    melWep3_Divider1.setVisibility(visibilityMode);
                    melWep3_ClassTextView.setVisibility(visibilityMode);
                    melWep3_ClassEditText.setVisibility(visibilityMode);
                    melWep3_DamageTextView.setVisibility(visibilityMode);
                    melWep3_DamageEditText.setVisibility(visibilityMode);
                    melWep3_TypeTextView.setVisibility(visibilityMode);
                    melWep3_TypeEditText.setVisibility(visibilityMode);
                    melWep3_PenetrationTextView.setVisibility(visibilityMode);
                    melWep3_PenetrationEditText.setVisibility(visibilityMode);
                    melWep3_Divider2.setVisibility(visibilityMode);
                    melWep3_SpecialRulesTextView.setVisibility(visibilityMode);
                    melWep3_SpecialRulesEditText.setVisibility(visibilityMode);

                    break;

                case 4: // Setting melee Weapon slot 4 to required visibility

                    melWep4_NameTextView.setVisibility(visibilityMode);
                    melWep4_NameEditText.setVisibility(visibilityMode);
                    melWep4_Divider1.setVisibility(visibilityMode);
                    melWep4_ClassTextView.setVisibility(visibilityMode);
                    melWep4_ClassEditText.setVisibility(visibilityMode);
                    melWep4_DamageTextView.setVisibility(visibilityMode);
                    melWep4_DamageEditText.setVisibility(visibilityMode);
                    melWep4_TypeTextView.setVisibility(visibilityMode);
                    melWep4_TypeEditText.setVisibility(visibilityMode);
                    melWep4_PenetrationTextView.setVisibility(visibilityMode);
                    melWep4_PenetrationEditText.setVisibility(visibilityMode);
                    melWep4_Divider2.setVisibility(visibilityMode);
                    melWep4_SpecialRulesTextView.setVisibility(visibilityMode);
                    melWep4_SpecialRulesEditText.setVisibility(visibilityMode);

                    break;
            }
    }


    public tab2Inventory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2inventory, container, false);


        // Attaching variables to view
        meleeCard1                      = view.findViewById(R.id.Melee1Card);
        meleeCard2                      = view.findViewById(R.id.Melee2Card);
        meleeCard3                      = view.findViewById(R.id.Melee3Card);
        meleeCard4                      = view.findViewById(R.id.Melee4Card);

        meleeWeapon1Slot                = view.findViewById(R.id.Melee1TitleTextView);
        meleeWeapon2Slot                = view.findViewById(R.id.Melee1TitleTextView);
        meleeWeapon3Slot                = view.findViewById(R.id.Melee1TitleTextView);
        meleeWeapon4Slot                = view.findViewById(R.id.Melee1TitleTextView);

        melParentButton                 = view.findViewById(R.id.MeleeParentExpandImageButton);
        melWep1ExpandButton             = view.findViewById(R.id.meWep1_ExpandImageButton);
        melWep2ExpandButton             = view.findViewById(R.id.meWep2_ExpandImageButton);
        melWep3ExpandButton             = view.findViewById(R.id.meWep3_ExpandImageButton);
        melWep4ExpandButton             = view.findViewById(R.id.meWep4_ExpandImageButton);

        melWep1_NameTextView            = view.findViewById(R.id.meWep1_NameTextView);
        melWep1_ClassTextView           = view.findViewById(R.id.meWep1_ClassTextView);
        melWep1_DamageTextView          = view.findViewById(R.id.meWep1_DamageTextView);
        melWep1_TypeTextView            = view.findViewById(R.id.meWep1_TypeTextView);
        melWep1_PenetrationTextView     = view.findViewById(R.id.meWep1_PenTextView);
        melWep1_SpecialRulesTextView    = view.findViewById(R.id.meWep1_SpecicalRulesTextView);

        melWep2_NameTextView            = view.findViewById(R.id.meWep2_NameTextView);
        melWep2_ClassTextView           = view.findViewById(R.id.meWep2_ClassTextView);
        melWep2_DamageTextView          = view.findViewById(R.id.meWep2_DamageTextView);
        melWep2_TypeTextView            = view.findViewById(R.id.meWep2_TypeTextView);
        melWep2_PenetrationTextView     = view.findViewById(R.id.meWep2_PenTextView);
        melWep2_SpecialRulesTextView    = view.findViewById(R.id.meWep2_SpecicalRulesTextView);

        melWep3_NameTextView            = view.findViewById(R.id.meWep3_NameTextView);
        melWep3_ClassTextView           = view.findViewById(R.id.meWep3_ClassTextView);
        melWep3_DamageTextView          = view.findViewById(R.id.meWep3_DamageTextView);
        melWep3_TypeTextView            = view.findViewById(R.id.meWep3_TypeTextView);
        melWep3_PenetrationTextView     = view.findViewById(R.id.meWep3_PenTextView);
        melWep3_SpecialRulesTextView    = view.findViewById(R.id.meWep3_SpecicalRulesTextView);

        melWep4_NameTextView            = view.findViewById(R.id.meWep4_NameTextView);
        melWep4_ClassTextView           = view.findViewById(R.id.meWep4_ClassTextView);
        melWep4_DamageTextView          = view.findViewById(R.id.meWep4_DamageTextView);
        melWep4_TypeTextView            = view.findViewById(R.id.meWep4_TypeTextView);
        melWep4_PenetrationTextView     = view.findViewById(R.id.meWep4_PenTextView);
        melWep4_SpecialRulesTextView    = view.findViewById(R.id.meWep4_SpecicalRulesTextView);

        melWep1_NameEditText            = view.findViewById(R.id.meWep1_NameEditText);
        melWep1_ClassEditText           = view.findViewById(R.id.meWep1_ClassEditText);
        melWep1_DamageEditText          = view.findViewById(R.id.meWep1_DamageEditText);
        melWep1_TypeEditText            = view.findViewById(R.id.meWep1_TypeEditText);
        melWep1_PenetrationEditText     = view.findViewById(R.id.meWep1_PenEditText);
        melWep1_SpecialRulesEditText    = view.findViewById(R.id.meWep1_SpecialRulesEditText);

        melWep2_NameEditText            = view.findViewById(R.id.meWep2_NameEditText);
        melWep2_ClassEditText           = view.findViewById(R.id.meWep2_ClassEditText);
        melWep2_DamageEditText          = view.findViewById(R.id.meWep2_DamageEditText);
        melWep2_TypeEditText            = view.findViewById(R.id.meWep2_TypeEditText);
        melWep2_PenetrationEditText     = view.findViewById(R.id.meWep2_PenEditText);
        melWep2_SpecialRulesEditText    = view.findViewById(R.id.meWep2_SpecialRulesEditText);

        melWep3_NameEditText            = view.findViewById(R.id.meWep3_NameEditText);
        melWep3_ClassEditText           = view.findViewById(R.id.meWep3_ClassEditText);
        melWep3_DamageEditText          = view.findViewById(R.id.meWep3_DamageEditText);
        melWep3_TypeEditText            = view.findViewById(R.id.meWep3_TypeEditText);
        melWep3_PenetrationEditText     = view.findViewById(R.id.meWep3_PenEditText);
        melWep3_SpecialRulesEditText    = view.findViewById(R.id.meWep3_SpecialRulesEditText);

        melWep4_NameEditText            = view.findViewById(R.id.meWep4_NameEditText);
        melWep4_ClassEditText           = view.findViewById(R.id.meWep4_ClassEditText);
        melWep4_DamageEditText          = view.findViewById(R.id.meWep4_DamageEditText);
        melWep4_TypeEditText            = view.findViewById(R.id.meWep4_TypeEditText);
        melWep4_PenetrationEditText     = view.findViewById(R.id.meWep4_PenEditText);
        melWep4_SpecialRulesEditText    = view.findViewById(R.id.meWep4_SpecialRulesEditText);

        melWep1_Divider1                = view.findViewById(R.id.meWep1_divider1);
        melWep1_Divider2                = view.findViewById(R.id.meWep1_divider2);

        melWep2_Divider1                = view.findViewById(R.id.meWep2_divider1);
        melWep2_Divider2                = view.findViewById(R.id.meWep2_divider2);

        melWep3_Divider1                = view.findViewById(R.id.meWep3_divider1);
        melWep3_Divider2                = view.findViewById(R.id.meWep3_divider2);

        melWep4_Divider1                = view.findViewById(R.id.meWep4_divider1);
        melWep4_Divider2                = view.findViewById(R.id.meWep4_divider2);


        // Setting all required views to GONE at onCreate
        // Parent Cards
        meleeCard1.setVisibility(View.GONE);
        meleeCard2.setVisibility(View.GONE);
        meleeCard3.setVisibility(View.GONE);
        meleeCard4.setVisibility(View.GONE);
        // Melee Weapon slot cards
        setMeleeVisibility(1, 8);
        setMeleeVisibility(2, 8);
        setMeleeVisibility(3, 8);
        setMeleeVisibility(4, 8);


        // Creating onClick listener to the expand parent melee weapon expand button
        melParentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks its visibility and then reverses it VISIBLE <-> GONE
                if (meleeCard1.getVisibility() == View.VISIBLE){
                    meleeCard1.setVisibility(View.GONE);
                    meleeCard2.setVisibility(View.GONE);
                    meleeCard3.setVisibility(View.GONE);
                    meleeCard4.setVisibility(View.GONE);
                } else {
                    meleeCard1.setVisibility(View.VISIBLE);
                    meleeCard2.setVisibility(View.VISIBLE);
                    meleeCard3.setVisibility(View.VISIBLE);
                    meleeCard4.setVisibility(View.VISIBLE);

                    // Ensures that after parent has been closed, the children default to closed
                    setMeleeVisibility(1, 8);
                    setMeleeVisibility(2, 8);
                    setMeleeVisibility(3, 8);
                    setMeleeVisibility(4, 8);
                }
            }
        });


        // Creating onClick listener to expand the melee slot #1 card
        melWep1ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (melWep1_NameTextView.getVisibility() == View.VISIBLE ){
                    setMeleeVisibility(1, 8);
                } else {
                    setMeleeVisibility(1,0);
                }
            }
        });


        // Creating onClick listener to expand the melee slot #2 card
        melWep2ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (melWep2_NameTextView.getVisibility() == View.VISIBLE){
                    setMeleeVisibility(2, 8);
                } else {
                    setMeleeVisibility(2, 0);
                }
            }
        });


        // Creating onClickListener to expand the melee slot #3 card
        melWep3ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (melWep3_NameTextView.getVisibility() == View.VISIBLE){
                    setMeleeVisibility(3, 8);
                } else {
                    setMeleeVisibility(3, 0);
                }
            }
        });


        // Creating onClickListener to expand the melee slot #4 card
        melWep4ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (melWep4_NameTextView.getVisibility() == View.VISIBLE){
                    setMeleeVisibility(4, 8);
                } else {
                    setMeleeVisibility(4, 0);
                }
            }
        });


        // TODO - addTextChangeListener to set the names of the weapon slots to the names of the slotted weapons ie. "Slot 1: The finger blaster"


        //Returns the view inflater
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        melWep1_NameEditText.setText(sharedPreferences.getString("meleeWeapon1_Name", ""));
        melWep1_ClassEditText.setText(sharedPreferences.getString("meleeWeapon1_Class", ""));
        melWep1_DamageEditText.setText(sharedPreferences.getString("meleeWeapon1_Damage", ""));
        melWep1_TypeEditText.setText(sharedPreferences.getString("meleeWeapon1_Type", ""));
        melWep1_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon1_Penetration", ""));
        melWep1_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon1_SpecialRules", ""));

        melWep2_NameEditText.setText(sharedPreferences.getString("meleeWeapon2_Name", ""));
        melWep2_ClassEditText.setText(sharedPreferences.getString("meleeWeapon2_Class", ""));
        melWep2_DamageEditText.setText(sharedPreferences.getString("meleeWeapon2_Damage", ""));
        melWep2_TypeEditText.setText(sharedPreferences.getString("meleeWeapon2_Type", ""));
        melWep2_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon2_Penetration", ""));
        melWep2_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon2_SpecialRules", ""));

        melWep3_NameEditText.setText(sharedPreferences.getString("meleeWeapon3_Name", ""));
        melWep3_ClassEditText.setText(sharedPreferences.getString("meleeWeapon3_Class", ""));
        melWep3_DamageEditText.setText(sharedPreferences.getString("meleeWeapon3_Damage", ""));
        melWep3_TypeEditText.setText(sharedPreferences.getString("meleeWeapon3_Type", ""));
        melWep3_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon3_Penetration", ""));
        melWep3_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon3_SpecialRules", ""));

        melWep4_NameEditText.setText(sharedPreferences.getString("meleeWeapon4_Name", ""));
        melWep4_ClassEditText.setText(sharedPreferences.getString("meleeWeapon4_Class", ""));
        melWep4_DamageEditText.setText(sharedPreferences.getString("meleeWeapon4_Damage", ""));
        melWep4_TypeEditText.setText(sharedPreferences.getString("meleeWeapon4_Type", ""));
        melWep4_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon4_Penetration", ""));
        melWep4_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon4_SpecialRules", ""));

    }


    @Override
    public void onPause() {
        super.onPause();

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Initialisation of the shared preferences editor
        SharedPreferences.Editor edit = sharedPreferences.edit();

        // Updates the shared preferences with all the character data
        // Melee Weapon - Slot 1
        edit.putString("meleeWeapon1_Name", melWep1_NameEditText.getText().toString().trim());
        edit.putString("meleeWeapon1_Class", melWep1_ClassEditText.getText().toString().trim());
        edit.putString("meleeWeapon1_Damage", melWep1_DamageEditText.getText().toString().trim());
        edit.putString("meleeWeapon1_Type", melWep1_TypeEditText.getText().toString().trim());
        edit.putString("meleeWeapon1_Penetration", melWep1_PenetrationEditText.getText().toString().trim());
        edit.putString("meleeWeapon1_SpecialRules", melWep1_SpecialRulesEditText.getText().toString().trim());

        // Melee Weapon - Slot 2
        edit.putString("meleeWeapon2_Name", melWep2_NameEditText.getText().toString().trim());
        edit.putString("meleeWeapon2_Class", melWep2_ClassEditText.getText().toString().trim());
        edit.putString("meleeWeapon2_Damage", melWep2_DamageEditText.getText().toString().trim());
        edit.putString("meleeWeapon2_Type", melWep2_TypeEditText.getText().toString().trim());
        edit.putString("meleeWeapon2_Penetration", melWep2_PenetrationEditText.getText().toString().trim());
        edit.putString("meleeWeapon2_SpecialRules", melWep2_SpecialRulesEditText.getText().toString().trim());

        // Melee Weapon - Slot 3
        edit.putString("meleeWeapon3_Name", melWep3_NameEditText.getText().toString().trim());
        edit.putString("meleeWeapon3_Class", melWep3_ClassEditText.getText().toString().trim());
        edit.putString("meleeWeapon3_Damage", melWep3_DamageEditText.getText().toString().trim());
        edit.putString("meleeWeapon3_Type", melWep3_TypeEditText.getText().toString().trim());
        edit.putString("meleeWeapon3_Penetration", melWep3_PenetrationEditText.getText().toString().trim());
        edit.putString("meleeWeapon3_SpecialRules", melWep3_SpecialRulesEditText.getText().toString().trim());

        // Melee Weapon - Slot 4
        edit.putString("meleeWeapon4_Name", melWep4_NameEditText.getText().toString().trim());
        edit.putString("meleeWeapon4_Class", melWep4_ClassEditText.getText().toString().trim());
        edit.putString("meleeWeapon4_Damage", melWep4_DamageEditText.getText().toString().trim());
        edit.putString("meleeWeapon4_Type", melWep4_TypeEditText.getText().toString().trim());
        edit.putString("meleeWeapon4_Penetration", melWep4_PenetrationEditText.getText().toString().trim());
        edit.putString("meleeWeapon4_SpecialRules", melWep4_SpecialRulesEditText.getText().toString().trim());

        // Applies the changes to the shared preferences file
        edit.apply();
    }



}
