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
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab2Inventory extends Fragment {

    // Scope-wide Variables
    // Card Views
    private CardView    meleeCard1;
    private CardView    meleeCard2;
    private CardView    meleeCard3;
    private CardView    meleeCard4;

    private CardView    missileCard1;
    private CardView    missileCard2;
    private CardView    missileCard3;
    private CardView    missileCard4;

    // Text Views for the child card names
    private TextView    meleeWeapon1Slot;
    private TextView    meleeWeapon2Slot;
    private TextView    meleeWeapon3Slot;
    private TextView    meleeWeapon4Slot;

    private TextView    missileWeapon1Slot;
    private TextView    missileWeapon2Slot;
    private TextView    missileWeapon3Slot;
    private TextView    missileWeapon4Slot;

    // Text Views for the 4 melee weapon children
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

    // Text Views for the 4 missile weapon children
    private TextView    misWep1_NameTextView;
    private TextView    misWep1_ClassTextView;
    private TextView    misWep1_DamageTextView;
    private TextView    misWep1_TypeTextView;
    private TextView    misWep1_PenetrationTextView;
    private TextView    misWep1_RangeTextView;
    private TextView    misWep1_RoFTextView;
    private TextView    misWep1_ClipTextView;
    private TextView    misWep1_RLDTextView;
    private TextView    misWep1_SpecialRulesTextView;

    private TextView    misWep2_NameTextView;
    private TextView    misWep2_ClassTextView;
    private TextView    misWep2_DamageTextView;
    private TextView    misWep2_TypeTextView;
    private TextView    misWep2_PenetrationTextView;
    private TextView    misWep2_RangeTextView;
    private TextView    misWep2_RoFTextView;
    private TextView    misWep2_ClipTextView;
    private TextView    misWep2_RLDTextView;
    private TextView    misWep2_SpecialRulesTextView;

    private TextView    misWep3_NameTextView;
    private TextView    misWep3_ClassTextView;
    private TextView    misWep3_DamageTextView;
    private TextView    misWep3_TypeTextView;
    private TextView    misWep3_PenetrationTextView;
    private TextView    misWep3_RangeTextView;
    private TextView    misWep3_RoFTextView;
    private TextView    misWep3_ClipTextView;
    private TextView    misWep3_RLDTextView;
    private TextView    misWep3_SpecialRulesTextView;

    private TextView    misWep4_NameTextView;
    private TextView    misWep4_ClassTextView;
    private TextView    misWep4_DamageTextView;
    private TextView    misWep4_TypeTextView;
    private TextView    misWep4_PenetrationTextView;
    private TextView    misWep4_RangeTextView;
    private TextView    misWep4_RoFTextView;
    private TextView    misWep4_ClipTextView;
    private TextView    misWep4_RLDTextView;
    private TextView    misWep4_SpecialRulesTextView;

    // Edit Texts for the 4 melee weapon children
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

    // Edit Texts for the 4 missile weapon children
    private EditText    misWep1_NameEditText;
    private EditText    misWep1_ClassEditText;
    private EditText    misWep1_DamageEditText;
    private EditText    misWep1_TypeEditText;
    private EditText    misWep1_PenetrationEditText;
    private EditText    misWep1_RangeEditText;
    private EditText    misWep1_RoFEditText;
    private EditText    misWep1_ClipEditText;
    private EditText    misWep1_RLDEditText;
    private EditText    misWep1_SpecialRulesEditText;

    private EditText    misWep2_NameEditText;
    private EditText    misWep2_ClassEditText;
    private EditText    misWep2_DamageEditText;
    private EditText    misWep2_TypeEditText;
    private EditText    misWep2_PenetrationEditText;
    private EditText    misWep2_RangeEditText;
    private EditText    misWep2_RoFEditText;
    private EditText    misWep2_ClipEditText;
    private EditText    misWep2_RLDEditText;
    private EditText    misWep2_SpecialRulesEditText;

    private EditText    misWep3_NameEditText;
    private EditText    misWep3_ClassEditText;
    private EditText    misWep3_DamageEditText;
    private EditText    misWep3_TypeEditText;
    private EditText    misWep3_PenetrationEditText;
    private EditText    misWep3_RangeEditText;
    private EditText    misWep3_RoFEditText;
    private EditText    misWep3_ClipEditText;
    private EditText    misWep3_RLDEditText;
    private EditText    misWep3_SpecialRulesEditText;

    private EditText    misWep4_NameEditText;
    private EditText    misWep4_ClassEditText;
    private EditText    misWep4_DamageEditText;
    private EditText    misWep4_TypeEditText;
    private EditText    misWep4_PenetrationEditText;
    private EditText    misWep4_RangeEditText;
    private EditText    misWep4_RoFEditText;
    private EditText    misWep4_ClipEditText;
    private EditText    misWep4_RLDEditText;
    private EditText    misWep4_SpecialRulesEditText;

    // Ammo Edit Texts
    private EditText    ammo1_NameEditText;
    private EditText    ammo1_ValEditText;

    // Dividers for the 4 melee weapon children
    private View        melWep1_Divider1;
    private View        melWep1_Divider2;

    private View        melWep2_Divider1;
    private View        melWep2_Divider2;

    private View        melWep3_Divider1;
    private View        melWep3_Divider2;

    private View        melWep4_Divider1;
    private View        melWep4_Divider2;

    // Dividers for the 4 missile weapon children
    private View        misWep1_Divider1;
    private View        misWep1_Divider2;
    private View        misWep1_Divider3;

    private View        misWep2_Divider1;
    private View        misWep2_Divider2;
    private View        misWep2_Divider3;

    private View        misWep3_Divider1;
    private View        misWep3_Divider2;
    private View        misWep3_Divider3;

    private View        misWep4_Divider1;
    private View        misWep4_Divider2;
    private View        misWep4_Divider3;

    // Image buttons for the melee weapons
    private ImageButton melParentButton;
    private ImageButton melWep1ExpandButton;
    private ImageButton melWep2ExpandButton;
    private ImageButton melWep3ExpandButton;
    private ImageButton melWep4ExpandButton;

    // Image buttons for the missile weapons
    private ImageButton misParentButton;
    private ImageButton misWep1ExpandButton;
    private ImageButton misWep2ExpandButton;
    private ImageButton misWep3ExpandButton;
    private ImageButton misWep4ExpandButton;

    // Image buttons for the ammo;
    private ImageButton ammoMasterAddItemButton;


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

    private void setMissileVisibility(int weaponSlot, int visibilityMode){

        // visibilityMode = 0 -> VISIBLE
        // visibilityMode = 4 -> INVISIBLE
        // visibilityMode = 8 -> GONE

        switch (weaponSlot){
            case 1: // Setting missile weapon slot 1 to required visibility

                misWep1_NameTextView.setVisibility(visibilityMode);
                misWep1_NameEditText.setVisibility(visibilityMode);
                misWep1_Divider1.setVisibility(visibilityMode);
                misWep1_ClassTextView.setVisibility(visibilityMode);
                misWep1_ClassEditText.setVisibility(visibilityMode);
                misWep1_DamageTextView.setVisibility(visibilityMode);
                misWep1_DamageEditText.setVisibility(visibilityMode);
                misWep1_TypeTextView.setVisibility(visibilityMode);
                misWep1_TypeEditText.setVisibility(visibilityMode);
                misWep1_PenetrationTextView.setVisibility(visibilityMode);
                misWep1_PenetrationEditText.setVisibility(visibilityMode);
                misWep1_Divider2.setVisibility(visibilityMode);
                misWep1_RangeTextView.setVisibility(visibilityMode);
                misWep1_RangeEditText.setVisibility(visibilityMode);
                misWep1_RoFTextView.setVisibility(visibilityMode);
                misWep1_RoFEditText.setVisibility(visibilityMode);
                misWep1_ClipTextView.setVisibility(visibilityMode);
                misWep1_ClipEditText.setVisibility(visibilityMode);
                misWep1_RLDTextView.setVisibility(visibilityMode);
                misWep1_RLDEditText.setVisibility(visibilityMode);
                misWep1_Divider3.setVisibility(visibilityMode);
                misWep1_SpecialRulesTextView.setVisibility(visibilityMode);
                misWep1_SpecialRulesEditText.setVisibility(visibilityMode);

                break;

            case 2:

                misWep2_NameTextView.setVisibility(visibilityMode);
                misWep2_NameEditText.setVisibility(visibilityMode);
                misWep2_Divider1.setVisibility(visibilityMode);
                misWep2_ClassTextView.setVisibility(visibilityMode);
                misWep2_ClassEditText.setVisibility(visibilityMode);
                misWep2_DamageTextView.setVisibility(visibilityMode);
                misWep2_DamageEditText.setVisibility(visibilityMode);
                misWep2_TypeTextView.setVisibility(visibilityMode);
                misWep2_TypeEditText.setVisibility(visibilityMode);
                misWep2_PenetrationTextView.setVisibility(visibilityMode);
                misWep2_PenetrationEditText.setVisibility(visibilityMode);
                misWep2_Divider2.setVisibility(visibilityMode);
                misWep2_RangeTextView.setVisibility(visibilityMode);
                misWep2_RangeEditText.setVisibility(visibilityMode);
                misWep2_RoFTextView.setVisibility(visibilityMode);
                misWep2_RoFEditText.setVisibility(visibilityMode);
                misWep2_ClipTextView.setVisibility(visibilityMode);
                misWep2_ClipEditText.setVisibility(visibilityMode);
                misWep2_RLDTextView.setVisibility(visibilityMode);
                misWep2_RLDEditText.setVisibility(visibilityMode);
                misWep2_Divider3.setVisibility(visibilityMode);
                misWep2_SpecialRulesTextView.setVisibility(visibilityMode);
                misWep2_SpecialRulesEditText.setVisibility(visibilityMode);

                break;

            case 3:

                misWep3_NameTextView.setVisibility(visibilityMode);
                misWep3_NameEditText.setVisibility(visibilityMode);
                misWep3_Divider1.setVisibility(visibilityMode);
                misWep3_ClassTextView.setVisibility(visibilityMode);
                misWep3_ClassEditText.setVisibility(visibilityMode);
                misWep3_DamageTextView.setVisibility(visibilityMode);
                misWep3_DamageEditText.setVisibility(visibilityMode);
                misWep3_TypeTextView.setVisibility(visibilityMode);
                misWep3_TypeEditText.setVisibility(visibilityMode);
                misWep3_PenetrationTextView.setVisibility(visibilityMode);
                misWep3_PenetrationEditText.setVisibility(visibilityMode);
                misWep3_Divider2.setVisibility(visibilityMode);
                misWep3_RangeTextView.setVisibility(visibilityMode);
                misWep3_RangeEditText.setVisibility(visibilityMode);
                misWep3_RoFTextView.setVisibility(visibilityMode);
                misWep3_RoFEditText.setVisibility(visibilityMode);
                misWep3_ClipTextView.setVisibility(visibilityMode);
                misWep3_ClipEditText.setVisibility(visibilityMode);
                misWep3_RLDTextView.setVisibility(visibilityMode);
                misWep3_RLDEditText.setVisibility(visibilityMode);
                misWep3_Divider3.setVisibility(visibilityMode);
                misWep3_SpecialRulesTextView.setVisibility(visibilityMode);
                misWep3_SpecialRulesEditText.setVisibility(visibilityMode);

                break;

            case 4:

                misWep4_NameTextView.setVisibility(visibilityMode);
                misWep4_NameEditText.setVisibility(visibilityMode);
                misWep4_Divider1.setVisibility(visibilityMode);
                misWep4_ClassTextView.setVisibility(visibilityMode);
                misWep4_ClassEditText.setVisibility(visibilityMode);
                misWep4_DamageTextView.setVisibility(visibilityMode);
                misWep4_DamageEditText.setVisibility(visibilityMode);
                misWep4_TypeTextView.setVisibility(visibilityMode);
                misWep4_TypeEditText.setVisibility(visibilityMode);
                misWep4_PenetrationTextView.setVisibility(visibilityMode);
                misWep4_PenetrationEditText.setVisibility(visibilityMode);
                misWep4_Divider2.setVisibility(visibilityMode);
                misWep4_RangeTextView.setVisibility(visibilityMode);
                misWep4_RangeEditText.setVisibility(visibilityMode);
                misWep4_RoFTextView.setVisibility(visibilityMode);
                misWep4_RoFEditText.setVisibility(visibilityMode);
                misWep4_ClipTextView.setVisibility(visibilityMode);
                misWep4_ClipEditText.setVisibility(visibilityMode);
                misWep4_RLDTextView.setVisibility(visibilityMode);
                misWep4_RLDEditText.setVisibility(visibilityMode);
                misWep4_Divider3.setVisibility(visibilityMode);
                misWep4_SpecialRulesTextView.setVisibility(visibilityMode);
                misWep4_SpecialRulesEditText.setVisibility(visibilityMode);

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
        // Melee children cards
        meleeCard1                      = view.findViewById(R.id.Melee1Card);
        meleeCard2                      = view.findViewById(R.id.Melee2Card);
        meleeCard3                      = view.findViewById(R.id.Melee3Card);
        meleeCard4                      = view.findViewById(R.id.Melee4Card);

        // Missile children cards
        missileCard1                    = view.findViewById(R.id.Missile1Card);
        missileCard2                    = view.findViewById(R.id.Missile2Card);
        missileCard3                    = view.findViewById(R.id.Missile3Card);
        missileCard4                    = view.findViewById(R.id.Missile4Card);

        // Text Views for the melee slot titles
        meleeWeapon1Slot                = view.findViewById(R.id.Melee1TitleTextView);
        meleeWeapon2Slot                = view.findViewById(R.id.Melee1TitleTextView);
        meleeWeapon3Slot                = view.findViewById(R.id.Melee1TitleTextView);
        meleeWeapon4Slot                = view.findViewById(R.id.Melee1TitleTextView);

        // Text Views for the missile slot titles
        missileWeapon1Slot              = view.findViewById(R.id.Missile1TitleTextView);
        missileWeapon2Slot              = view.findViewById(R.id.Missile2TitleTextView);
        missileWeapon3Slot              = view.findViewById(R.id.Missile3TitleTextView);
        missileWeapon4Slot              = view.findViewById(R.id.Missile4TitleTextView);

        // Image buttons for the melee weapons
        melParentButton                 = view.findViewById(R.id.MeleeParentExpandImageButton);
        melWep1ExpandButton             = view.findViewById(R.id.meWep1_ExpandImageButton);
        melWep2ExpandButton             = view.findViewById(R.id.meWep2_ExpandImageButton);
        melWep3ExpandButton             = view.findViewById(R.id.meWep3_ExpandImageButton);
        melWep4ExpandButton             = view.findViewById(R.id.meWep4_ExpandImageButton);

        // Image buttons for the missile weapons
        misParentButton                 = view.findViewById(R.id.MissileParentExandImageButton);
        misWep1ExpandButton             = view.findViewById(R.id.miWep1_ExpandImageButton);
        misWep2ExpandButton             = view.findViewById(R.id.miWep2_ExpandImageButton);
        misWep3ExpandButton             = view.findViewById(R.id.miWep3_ExpandImageButton);
        misWep4ExpandButton             = view.findViewById(R.id.miWep4_ExpandImageButton);

        // Image buttons for the ammo list
        ammoMasterAddItemButton         = view.findViewById(R.id.AmmoMasterAddImageButton);

        // Text Views for the melee weapon children
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

        // Text Views for the missile weapon children
        misWep1_NameTextView            = view.findViewById(R.id.miWep1_NameTextView);
        misWep1_ClassTextView           = view.findViewById(R.id.miWep1_ClassTextView);
        misWep1_DamageTextView          = view.findViewById(R.id.miWep1_DamageTextView);
        misWep1_TypeTextView            = view.findViewById(R.id.miWep1_TypeTextView);
        misWep1_PenetrationTextView     = view.findViewById(R.id.miWep1_PenTextView);
        misWep1_RangeTextView           = view.findViewById(R.id.miWep1_RangeTextView);
        misWep1_RoFTextView             = view.findViewById(R.id.miWep1_RoFTextView);
        misWep1_ClipTextView            = view.findViewById(R.id.miWep1_ClipTextView);
        misWep1_RLDTextView             = view.findViewById(R.id.miWep1_RLDTextView);
        misWep1_SpecialRulesTextView    = view.findViewById(R.id.miWep1_SpecialRulesTextView);

        misWep2_NameTextView            = view.findViewById(R.id.miWep2_NameTextView);
        misWep2_ClassTextView           = view.findViewById(R.id.miWep2_ClassTextView);
        misWep2_DamageTextView          = view.findViewById(R.id.miWep2_DamageTextView);
        misWep2_TypeTextView            = view.findViewById(R.id.miWep2_TypeTextView);
        misWep2_PenetrationTextView     = view.findViewById(R.id.miWep2_PenTextView);
        misWep2_RangeTextView           = view.findViewById(R.id.miWep2_RangeTextView);
        misWep2_RoFTextView             = view.findViewById(R.id.miWep2_RoFTextView);
        misWep2_ClipTextView            = view.findViewById(R.id.miWep2_ClipTextView);
        misWep2_RLDTextView             = view.findViewById(R.id.miWep2_RLDTextView);
        misWep2_SpecialRulesTextView    = view.findViewById(R.id.miWep2_SpecialRulesTextView);

        misWep3_NameTextView            = view.findViewById(R.id.miWep3_NameTextView);
        misWep3_ClassTextView           = view.findViewById(R.id.miWep3_ClassTextView);
        misWep3_DamageTextView          = view.findViewById(R.id.miWep3_DamageTextView);
        misWep3_TypeTextView            = view.findViewById(R.id.miWep3_TypeTextView);
        misWep3_PenetrationTextView     = view.findViewById(R.id.miWep3_PenTextView);
        misWep3_RangeTextView           = view.findViewById(R.id.miWep3_RangeTextView);
        misWep3_RoFTextView             = view.findViewById(R.id.miWep3_RoFTextView);
        misWep3_ClipTextView            = view.findViewById(R.id.miWep3_ClipTextView);
        misWep3_RLDTextView             = view.findViewById(R.id.miWep3_RLDTextView);
        misWep3_SpecialRulesTextView    = view.findViewById(R.id.miWep3_SpecialRulesTextView);

        misWep4_NameTextView            = view.findViewById(R.id.miWep4_NameTextView);
        misWep4_ClassTextView           = view.findViewById(R.id.miWep4_ClassTextView);
        misWep4_DamageTextView          = view.findViewById(R.id.miWep4_DamageTextView);
        misWep4_TypeTextView            = view.findViewById(R.id.miWep4_TypeTextView);
        misWep4_PenetrationTextView     = view.findViewById(R.id.miWep4_PenTextView);
        misWep4_RangeTextView           = view.findViewById(R.id.miWep4_RangeTextView);
        misWep4_RoFTextView             = view.findViewById(R.id.miWep4_RoFTextView);
        misWep4_ClipTextView            = view.findViewById(R.id.miWep4_ClipTextView);
        misWep4_RLDTextView             = view.findViewById(R.id.miWep4_RLDTextView);
        misWep4_SpecialRulesTextView    = view.findViewById(R.id.miWep4_SpecialRulesTextView);

        // Edit Texts for the 4 melee weapon children
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

        // Edit Texts for the 4 missile weapon children
        misWep1_NameEditText            = view.findViewById(R.id.miWep1_NameEditText);
        misWep1_ClassEditText           = view.findViewById(R.id.miWep1_ClassEditText);
        misWep1_DamageEditText          = view.findViewById(R.id.miWep1_DamageEditText);
        misWep1_TypeEditText            = view.findViewById(R.id.miWep1_TypeEditText);
        misWep1_PenetrationEditText     = view.findViewById(R.id.miWep1_PenEditText);
        misWep1_RangeEditText           = view.findViewById(R.id.miWep1_RangeEditText);
        misWep1_RoFEditText             = view.findViewById(R.id.miWep1_RoFEditText);
        misWep1_ClipEditText            = view.findViewById(R.id.miWep1_ClipEditText);
        misWep1_RLDEditText             = view.findViewById(R.id.miWep1_RLDEditText);
        misWep1_SpecialRulesEditText    = view.findViewById(R.id.miWep1_SpecialRulesEditText);

        misWep2_NameEditText            = view.findViewById(R.id.miWep2_NameEditText);
        misWep2_ClassEditText           = view.findViewById(R.id.miWep2_ClassEditText);
        misWep2_DamageEditText          = view.findViewById(R.id.miWep2_DamageEditText);
        misWep2_TypeEditText            = view.findViewById(R.id.miWep2_TypeEditText);
        misWep2_PenetrationEditText     = view.findViewById(R.id.miWep2_PenEditText);
        misWep2_RangeEditText           = view.findViewById(R.id.miWep2_RangeEditText);
        misWep2_RoFEditText             = view.findViewById(R.id.miWep2_RoFEditText);
        misWep2_ClipEditText            = view.findViewById(R.id.miWep2_ClipEditText);
        misWep2_RLDEditText             = view.findViewById(R.id.miWep2_RLDEditText);
        misWep2_SpecialRulesEditText    = view.findViewById(R.id.miWep2_SpecialRulesEditText);

        misWep3_NameEditText            = view.findViewById(R.id.miWep3_NameEditText);
        misWep3_ClassEditText           = view.findViewById(R.id.miWep3_ClassEditText);
        misWep3_DamageEditText          = view.findViewById(R.id.miWep3_DamageEditText);
        misWep3_TypeEditText            = view.findViewById(R.id.miWep3_TypeEditText);
        misWep3_PenetrationEditText     = view.findViewById(R.id.miWep3_PenEditText);
        misWep3_RangeEditText           = view.findViewById(R.id.miWep3_RangeEditText);
        misWep3_RoFEditText             = view.findViewById(R.id.miWep3_RoFEditText);
        misWep3_ClipEditText            = view.findViewById(R.id.miWep3_ClipEditText);
        misWep3_RLDEditText             = view.findViewById(R.id.miWep3_RLDEditText);
        misWep3_SpecialRulesEditText    = view.findViewById(R.id.miWep3_SpecialRulesEditText);

        misWep4_NameEditText            = view.findViewById(R.id.miWep4_NameEditText);
        misWep4_ClassEditText           = view.findViewById(R.id.miWep4_ClassEditText);
        misWep4_DamageEditText          = view.findViewById(R.id.miWep4_DamageEditText);
        misWep4_TypeEditText            = view.findViewById(R.id.miWep4_TypeEditText);
        misWep4_PenetrationEditText     = view.findViewById(R.id.miWep4_PenEditText);
        misWep4_RangeEditText           = view.findViewById(R.id.miWep4_RangeEditText);
        misWep4_RoFEditText             = view.findViewById(R.id.miWep4_RoFEditText);
        misWep4_ClipEditText            = view.findViewById(R.id.miWep4_ClipEditText);
        misWep4_RLDEditText             = view.findViewById(R.id.miWep4_RLDEditText);
        misWep4_SpecialRulesEditText    = view.findViewById(R.id.miWep4_SpecialRulesEditText);

        // Text views for the ammo list
        ammo1_NameEditText              = view.findViewById(R.id.Ammo1_NameEditText);
        ammo1_ValEditText               = view.findViewById(R.id.Ammo1_ValEditText);

        // Dividers for the four melee weapons children
        melWep1_Divider1                = view.findViewById(R.id.meWep1_divider1);
        melWep1_Divider2                = view.findViewById(R.id.meWep1_divider2);

        melWep2_Divider1                = view.findViewById(R.id.meWep2_divider1);
        melWep2_Divider2                = view.findViewById(R.id.meWep2_divider2);

        melWep3_Divider1                = view.findViewById(R.id.meWep3_divider1);
        melWep3_Divider2                = view.findViewById(R.id.meWep3_divider2);

        melWep4_Divider1                = view.findViewById(R.id.meWep4_divider1);
        melWep4_Divider2                = view.findViewById(R.id.meWep4_divider2);

        // Dividers for the four missile weapons children
        misWep1_Divider1                = view.findViewById(R.id.miWep1_divider1);
        misWep1_Divider2                = view.findViewById(R.id.miWep1_divider2);
        misWep1_Divider3                = view.findViewById(R.id.miWep1_divider3);

        misWep2_Divider1                = view.findViewById(R.id.miWep2_divider1);
        misWep2_Divider2                = view.findViewById(R.id.miWep2_divider2);
        misWep2_Divider3                = view.findViewById(R.id.miWep2_divider3);

        misWep3_Divider1                = view.findViewById(R.id.miWep3_divider1);
        misWep3_Divider2                = view.findViewById(R.id.miWep3_divider2);
        misWep3_Divider3                = view.findViewById(R.id.miWep3_divider3);

        misWep4_Divider1                = view.findViewById(R.id.miWep4_divider1);
        misWep4_Divider2                = view.findViewById(R.id.miWep4_divider2);
        misWep4_Divider3                = view.findViewById(R.id.miWep4_divider3);


        // Setting all required views to GONE at onCreate
        // Melee parent cards
        meleeCard1.setVisibility(View.GONE);
        meleeCard2.setVisibility(View.GONE);
        meleeCard3.setVisibility(View.GONE);
        meleeCard4.setVisibility(View.GONE);

        // Missile parent cards
        missileCard1.setVisibility(View.GONE);
        missileCard2.setVisibility(View.GONE);
        missileCard3.setVisibility(View.GONE);
        missileCard4.setVisibility(View.GONE);

        // Melee Weapon slot cards
        setMeleeVisibility(1, 8);
        setMeleeVisibility(2, 8);
        setMeleeVisibility(3, 8);
        setMeleeVisibility(4, 8);

        // Missile weapon slot cards
        setMissileVisibility(1, 8);
        setMissileVisibility(2, 8);
        setMissileVisibility(3, 8);
        setMissileVisibility(4, 8);


        // Creating onClick listener to the expand parent melee weapon card
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

        // Creating onClick listener to expand the parent missile weapon card
        misParentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( missileCard1.getVisibility() == View.VISIBLE){
                    // Checks its visibility and then reverses it VISIBLE <-> GONE
                    missileCard1.setVisibility(View.GONE);
                    missileCard2.setVisibility(View.GONE);
                    missileCard3.setVisibility(View.GONE);
                    missileCard4.setVisibility(View.GONE);
                } else {
                    missileCard1.setVisibility(View.VISIBLE);
                    missileCard2.setVisibility(View.VISIBLE);
                    missileCard3.setVisibility(View.VISIBLE);
                    missileCard4.setVisibility(View.VISIBLE);

                    // Ensures that after the parent has been closed, the children all default to closed too
                    setMissileVisibility(1, 8);
                    setMissileVisibility(2, 8);
                    setMissileVisibility(3, 8);
                    setMissileVisibility(4, 8);
                }
            }
        });

        misWep1ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (misWep1_NameTextView.getVisibility() == View.VISIBLE){
                    setMissileVisibility(1, 8);
                } else {
                    setMissileVisibility(1, 0);
                }
            }
        });

        misWep2ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (misWep2_NameTextView.getVisibility() == View.VISIBLE){
                    setMissileVisibility(2, 8);
                } else {
                    setMissileVisibility(2, 0);
                }
            }
        });

        misWep3ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (misWep3_NameTextView.getVisibility() == View.VISIBLE){
                    setMissileVisibility(3, 8);
                } else {
                    setMissileVisibility(3, 0);
                }
            }
        });

        misWep4ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( misWep4_NameTextView.getVisibility() == View.VISIBLE){
                    setMissileVisibility(4, 8);
                } else {
                    setMissileVisibility(4, 0);
                }
            }
        });

        ammoMasterAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO - add logic here for the button press of "add ammo item"
                // Placeholder WIP
                Toast.makeText(getActivity(), "Work in progress", Toast.LENGTH_SHORT).show();

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

        // Loading melee weapon 1 slot
        melWep1_NameEditText.setText(sharedPreferences.getString("meleeWeapon1_Name", ""));
        melWep1_ClassEditText.setText(sharedPreferences.getString("meleeWeapon1_Class", ""));
        melWep1_DamageEditText.setText(sharedPreferences.getString("meleeWeapon1_Damage", ""));
        melWep1_TypeEditText.setText(sharedPreferences.getString("meleeWeapon1_Type", ""));
        melWep1_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon1_Penetration", ""));
        melWep1_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon1_SpecialRules", ""));

        // Loading melee weapon 2 slot
        melWep2_NameEditText.setText(sharedPreferences.getString("meleeWeapon2_Name", ""));
        melWep2_ClassEditText.setText(sharedPreferences.getString("meleeWeapon2_Class", ""));
        melWep2_DamageEditText.setText(sharedPreferences.getString("meleeWeapon2_Damage", ""));
        melWep2_TypeEditText.setText(sharedPreferences.getString("meleeWeapon2_Type", ""));
        melWep2_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon2_Penetration", ""));
        melWep2_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon2_SpecialRules", ""));

        // Loading melee weapon 3 slot
        melWep3_NameEditText.setText(sharedPreferences.getString("meleeWeapon3_Name", ""));
        melWep3_ClassEditText.setText(sharedPreferences.getString("meleeWeapon3_Class", ""));
        melWep3_DamageEditText.setText(sharedPreferences.getString("meleeWeapon3_Damage", ""));
        melWep3_TypeEditText.setText(sharedPreferences.getString("meleeWeapon3_Type", ""));
        melWep3_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon3_Penetration", ""));
        melWep3_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon3_SpecialRules", ""));

        // Loading melee weapon 4 slot
        melWep4_NameEditText.setText(sharedPreferences.getString("meleeWeapon4_Name", ""));
        melWep4_ClassEditText.setText(sharedPreferences.getString("meleeWeapon4_Class", ""));
        melWep4_DamageEditText.setText(sharedPreferences.getString("meleeWeapon4_Damage", ""));
        melWep4_TypeEditText.setText(sharedPreferences.getString("meleeWeapon4_Type", ""));
        melWep4_PenetrationEditText.setText(sharedPreferences.getString("meleeWeapon4_Penetration", ""));
        melWep4_SpecialRulesEditText.setText(sharedPreferences.getString("meleeWeapon4_SpecialRules", ""));

        // Loading missile weapon 1 slot
        misWep1_NameEditText.setText(sharedPreferences.getString("missileWeapon1_Name", ""));
        misWep1_ClassEditText.setText(sharedPreferences.getString("missileWeapon1_Class", ""));
        misWep1_DamageEditText.setText(sharedPreferences.getString("missileWeapon1_Damage", ""));
        misWep1_TypeEditText.setText(sharedPreferences.getString("missileWeapon1_Type", ""));
        misWep1_PenetrationEditText.setText(sharedPreferences.getString("missileWeapon1_Penetration", ""));
        misWep1_RangeEditText.setText(sharedPreferences.getString("missileWeapon1_Range", ""));
        misWep1_RoFEditText.setText(sharedPreferences.getString("missileWeapon1_RoF", ""));
        misWep1_ClipEditText.setText(sharedPreferences.getString("missileWeapon1_Clip", ""));
        misWep1_RLDEditText.setText(sharedPreferences.getString("missileWeapon1_RLD", ""));
        misWep1_SpecialRulesEditText.setText(sharedPreferences.getString("missileWeapon1_SpecialRules", ""));

        // Loading missile weapon 2 slot
        misWep2_NameEditText.setText(sharedPreferences.getString("missileWeapon2_Name", ""));
        misWep2_ClassEditText.setText(sharedPreferences.getString("missileWeapon2_Class", ""));
        misWep2_DamageEditText.setText(sharedPreferences.getString("missileWeapon2_Damage", ""));
        misWep2_TypeEditText.setText(sharedPreferences.getString("missileWeapon2_Type", ""));
        misWep2_PenetrationEditText.setText(sharedPreferences.getString("missileWeapon2_Penetration", ""));
        misWep2_RangeEditText.setText(sharedPreferences.getString("missileWeapon2_Range", ""));
        misWep2_RoFEditText.setText(sharedPreferences.getString("missileWeapon2_RoF", ""));
        misWep2_ClipEditText.setText(sharedPreferences.getString("missileWeapon2_Clip", ""));
        misWep2_RLDEditText.setText(sharedPreferences.getString("missileWeapon2_RLD", ""));
        misWep2_SpecialRulesEditText.setText(sharedPreferences.getString("missileWeapon2_SpecialRules", ""));

        // Loading missile weapon 3 slot
        misWep3_NameEditText.setText(sharedPreferences.getString("missileWeapon3_Name", ""));
        misWep3_ClassEditText.setText(sharedPreferences.getString("missileWeapon3_Class", ""));
        misWep3_DamageEditText.setText(sharedPreferences.getString("missileWeapon3_Damage", ""));
        misWep3_TypeEditText.setText(sharedPreferences.getString("missileWeapon3_Type", ""));
        misWep3_PenetrationEditText.setText(sharedPreferences.getString("missileWeapon3_Penetration", ""));
        misWep3_RangeEditText.setText(sharedPreferences.getString("missileWeapon3_Range", ""));
        misWep3_RoFEditText.setText(sharedPreferences.getString("missileWeapon3_RoF", ""));
        misWep3_ClipEditText.setText(sharedPreferences.getString("missileWeapon3_Clip", ""));
        misWep3_RLDEditText.setText(sharedPreferences.getString("missileWeapon3_RLD", ""));
        misWep3_SpecialRulesEditText.setText(sharedPreferences.getString("missileWeapon3_SpecialRules", ""));

        // Loading missile weapon 4 slot
        misWep4_NameEditText.setText(sharedPreferences.getString("missileWeapon4_Name", ""));
        misWep4_ClassEditText.setText(sharedPreferences.getString("missileWeapon4_Class", ""));
        misWep4_DamageEditText.setText(sharedPreferences.getString("missileWeapon4_Damage", ""));
        misWep4_TypeEditText.setText(sharedPreferences.getString("missileWeapon4_Type", ""));
        misWep4_PenetrationEditText.setText(sharedPreferences.getString("missileWeapon4_Penetration", ""));
        misWep4_RangeEditText.setText(sharedPreferences.getString("missileWeapon4_Range", ""));
        misWep4_RoFEditText.setText(sharedPreferences.getString("missileWeapon4_RoF", ""));
        misWep4_ClipEditText.setText(sharedPreferences.getString("missileWeapon4_Clip", ""));
        misWep4_RLDEditText.setText(sharedPreferences.getString("missileWeapon4_RLD", ""));
        misWep4_SpecialRulesEditText.setText(sharedPreferences.getString("missileWeapon4_SpecialRules", ""));

        // Loading ammo list
        ammo1_NameEditText.setText(sharedPreferences.getString("ammo1_Name", ""));
        ammo1_ValEditText.setText(sharedPreferences.getString("ammo1_Val", ""));

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

        // Missile Weapon - Slot 1
        edit.putString("missileWeapon1_Name", misWep1_NameEditText.getText().toString().trim());
        edit.putString("missileWeapon1_Class", misWep1_ClassEditText.getText().toString().trim());
        edit.putString("missileWeapon1_Damage", misWep1_DamageEditText.getText().toString().trim());
        edit.putString("missileWeapon1_Type", misWep1_TypeEditText.getText().toString().trim());
        edit.putString("missileWeapon1_Penetration", misWep1_PenetrationEditText.getText().toString().trim());
        edit.putString("missileWeapon1_Range", misWep1_RangeEditText.getText().toString().trim());
        edit.putString("missileWeapon1_RoF", misWep1_RoFEditText.getText().toString().trim());
        edit.putString("missileWeapon1_Clip", misWep1_ClipEditText.getText().toString().trim());
        edit.putString("missileWeapon1_RLD", misWep1_RLDEditText.getText().toString().trim());
        edit.putString("missileWeapon1_SpecialRules", misWep1_SpecialRulesEditText.getText().toString().trim());

        // Missile Weapon - Slot 2
        edit.putString("missileWeapon2_Name", misWep2_NameEditText.getText().toString().trim());
        edit.putString("missileWeapon2_Class", misWep2_ClassEditText.getText().toString().trim());
        edit.putString("missileWeapon2_Damage", misWep2_DamageEditText.getText().toString().trim());
        edit.putString("missileWeapon2_Type", misWep2_TypeEditText.getText().toString().trim());
        edit.putString("missileWeapon2_Penetration", misWep2_PenetrationEditText.getText().toString().trim());
        edit.putString("missileWeapon2_Range", misWep2_RangeEditText.getText().toString().trim());
        edit.putString("missileWeapon2_RoF", misWep2_RoFEditText.getText().toString().trim());
        edit.putString("missileWeapon2_Clip", misWep2_ClipEditText.getText().toString().trim());
        edit.putString("missileWeapon2_RLD", misWep2_RLDEditText.getText().toString().trim());
        edit.putString("missileWeapon2_SpecialRules", misWep2_SpecialRulesEditText.getText().toString().trim());

        // Missile Weapon - Slot 3
        edit.putString("missileWeapon3_Name", misWep3_NameEditText.getText().toString().trim());
        edit.putString("missileWeapon3_Class", misWep3_ClassEditText.getText().toString().trim());
        edit.putString("missileWeapon3_Damage", misWep3_DamageEditText.getText().toString().trim());
        edit.putString("missileWeapon3_Type", misWep3_TypeEditText.getText().toString().trim());
        edit.putString("missileWeapon3_Penetration", misWep3_PenetrationEditText.getText().toString().trim());
        edit.putString("missileWeapon3_Range", misWep3_RangeEditText.getText().toString().trim());
        edit.putString("missileWeapon3_RoF", misWep3_RoFEditText.getText().toString().trim());
        edit.putString("missileWeapon3_Clip", misWep3_ClipEditText.getText().toString().trim());
        edit.putString("missileWeapon3_RLD", misWep3_RLDEditText.getText().toString().trim());
        edit.putString("missileWeapon3_SpecialRules", misWep3_SpecialRulesEditText.getText().toString().trim());

        // Missile Weapon - Slot 4
        edit.putString("missileWeapon4_Name", misWep4_NameEditText.getText().toString().trim());
        edit.putString("missileWeapon4_Class", misWep4_ClassEditText.getText().toString().trim());
        edit.putString("missileWeapon4_Damage", misWep4_DamageEditText.getText().toString().trim());
        edit.putString("missileWeapon4_Type", misWep4_TypeEditText.getText().toString().trim());
        edit.putString("missileWeapon4_Penetration", misWep4_PenetrationEditText.getText().toString().trim());
        edit.putString("missileWeapon4_Range", misWep4_RangeEditText.getText().toString().trim());
        edit.putString("missileWeapon4_RoF", misWep4_RoFEditText.getText().toString().trim());
        edit.putString("missileWeapon4_Clip", misWep4_ClipEditText.getText().toString().trim());
        edit.putString("missileWeapon4_RLD", misWep4_RLDEditText.getText().toString().trim());
        edit.putString("missileWeapon4_SpecialRules", misWep4_SpecialRulesEditText.getText().toString().trim());

        // Ammo
        edit.putString("ammo1_Name", ammo1_NameEditText.getText().toString().trim());
        edit.putString("ammo1_Val", ammo1_ValEditText.getText().toString().trim());

        // Applies the changes to the shared preferences file
        edit.apply();
    }



}
