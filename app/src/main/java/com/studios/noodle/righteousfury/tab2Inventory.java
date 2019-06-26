package com.studios.noodle.righteousfury;


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

    private EditText    melWep1_NameEditText;
    private EditText    melWep1_ClassEditText;
    private EditText    melWep1_DamageEditText;
    private EditText    melWep1_TypeEditText;
    private EditText    melWep1_PenetrationEditText;
    private EditText    melWep1_SpecialRulesEditText;

    private View        melWep1_Divider1;
    private View        melWep1_Divider2;

    private ImageButton melParentButton;
    private ImageButton melWep1ExpandButton;

    private CardView    meleeCard1;
    private CardView    meleeCard2;
    private CardView    meleeCard3;
    private CardView    meleeCard4;


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


        // Attaching variables to view
        melParentButton                 = view.findViewById(R.id.MeleeParentExpandImageButton);
        melWep1ExpandButton             = view.findViewById(R.id.meWep1_ExpandImageButton);

        melWep1_NameEditText            = view.findViewById(R.id.meWep1_NameEditText);
        melWep1_ClassEditText           = view.findViewById(R.id.meWep1_ClassEditText);
        melWep1_DamageEditText          = view.findViewById(R.id.meWep1_DamageEditText);
        melWep1_TypeEditText            = view.findViewById(R.id.meWep1_TypeEditText);
        melWep1_PenetrationEditText     = view.findViewById(R.id.meWep1_PenEditText);
        melWep1_SpecialRulesEditText    = view.findViewById(R.id.meWep1_SpecialRulesEditText);

        melWep1_NameTextView            = view.findViewById(R.id.meWep1_NameTextView);
        melWep1_ClassTextView           = view.findViewById(R.id.meWep1_ClassTextView);
        melWep1_DamageTextView          = view.findViewById(R.id.meWep1_DamageTextView);
        melWep1_TypeTextView            = view.findViewById(R.id.meWep1_TypeTextView);
        melWep1_PenetrationTextView     = view.findViewById(R.id.meWep1_PenTextView);
        melWep1_SpecialRulesTextView    = view.findViewById(R.id.meWep1_SpecicalRulesTextView);

        meleeCard1                      = view.findViewById(R.id.Melee1Card);

        melWep1_Divider1                = view.findViewById(R.id.meWep1_divider1);
        melWep1_Divider2                = view.findViewById(R.id.meWep1_divider2);


        // Setting all required views to GONE at onCreate
        meleeCard1.setVisibility(View.GONE);

        melWep1_NameTextView.setVisibility(View.GONE);
        melWep1_NameEditText.setVisibility(View.GONE);
        melWep1_Divider1.setVisibility(View.GONE);
        melWep1_ClassTextView.setVisibility(View.GONE);
        melWep1_ClassEditText.setVisibility(View.GONE);
        melWep1_DamageTextView.setVisibility(View.GONE);
        melWep1_DamageEditText.setVisibility(View.GONE);
        melWep1_TypeTextView.setVisibility(View.GONE);
        melWep1_TypeEditText.setVisibility(View.GONE);
        melWep1_PenetrationTextView.setVisibility(View.GONE);
        melWep1_PenetrationEditText.setVisibility(View.GONE);
        melWep1_Divider2.setVisibility(View.GONE);
        melWep1_SpecialRulesTextView.setVisibility(View.GONE);
        melWep1_SpecialRulesEditText.setVisibility(View.GONE);


        // Creating onClick listener to the expand parent melee weapon expand button
        melParentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks its visibility and then reverses it VISIBLE <-> GONE
                if (meleeCard1.getVisibility() == View.VISIBLE){
                    meleeCard1.setVisibility(View.GONE);
                } else {
                    meleeCard1.setVisibility(View.VISIBLE);

                    // Ensures that after parent has been closed, the children default to closed
                    melWep1_NameTextView.setVisibility(View.GONE);
                    melWep1_NameEditText.setVisibility(View.GONE);
                    melWep1_Divider1.setVisibility(View.GONE);
                    melWep1_ClassTextView.setVisibility(View.GONE);
                    melWep1_ClassEditText.setVisibility(View.GONE);
                    melWep1_DamageTextView.setVisibility(View.GONE);
                    melWep1_DamageEditText.setVisibility(View.GONE);
                    melWep1_TypeTextView.setVisibility(View.GONE);
                    melWep1_TypeEditText.setVisibility(View.GONE);
                    melWep1_PenetrationTextView.setVisibility(View.GONE);
                    melWep1_PenetrationEditText.setVisibility(View.GONE);
                    melWep1_Divider2.setVisibility(View.GONE);
                    melWep1_SpecialRulesTextView.setVisibility(View.GONE);
                    melWep1_SpecialRulesEditText.setVisibility(View.GONE);
                }
            }
        });


        // Creating onClick listener to expand the melee slot #1 card
        melWep1ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (melWep1_NameTextView.getVisibility() == View.VISIBLE ){
                    melWep1_NameTextView.setVisibility(View.GONE);
                    melWep1_NameEditText.setVisibility(View.GONE);
                    melWep1_Divider1.setVisibility(View.GONE);
                    melWep1_ClassTextView.setVisibility(View.GONE);
                    melWep1_ClassEditText.setVisibility(View.GONE);
                    melWep1_DamageTextView.setVisibility(View.GONE);
                    melWep1_DamageEditText.setVisibility(View.GONE);
                    melWep1_TypeTextView.setVisibility(View.GONE);
                    melWep1_TypeEditText.setVisibility(View.GONE);
                    melWep1_PenetrationTextView.setVisibility(View.GONE);
                    melWep1_PenetrationEditText.setVisibility(View.GONE);
                    melWep1_Divider2.setVisibility(View.GONE);
                    melWep1_SpecialRulesTextView.setVisibility(View.GONE);
                    melWep1_SpecialRulesEditText.setVisibility(View.GONE);
                } else {
                    melWep1_NameTextView.setVisibility(View.VISIBLE);
                    melWep1_NameEditText.setVisibility(View.VISIBLE);
                    melWep1_Divider1.setVisibility(View.VISIBLE);
                    melWep1_ClassTextView.setVisibility(View.VISIBLE);
                    melWep1_ClassEditText.setVisibility(View.VISIBLE);
                    melWep1_DamageTextView.setVisibility(View.VISIBLE);
                    melWep1_DamageEditText.setVisibility(View.VISIBLE);
                    melWep1_TypeTextView.setVisibility(View.VISIBLE);
                    melWep1_TypeEditText.setVisibility(View.VISIBLE);
                    melWep1_PenetrationTextView.setVisibility(View.VISIBLE);
                    melWep1_PenetrationEditText.setVisibility(View.VISIBLE);
                    melWep1_Divider2.setVisibility(View.VISIBLE);
                    melWep1_SpecialRulesTextView.setVisibility(View.VISIBLE);
                    melWep1_SpecialRulesEditText.setVisibility(View.VISIBLE);
                }
            }
        });

        //Returns the view inflater
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        /* OLD CODE ###########################################################

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



        #################################################################### */

    }


    @Override
    public void onPause() {
        super.onPause();

        /* OLD CODE ##################################################################

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

        ##################################################### */
    }



}
