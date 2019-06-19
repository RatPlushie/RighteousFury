package com.studios.noodle.righteousfury;


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


    public tab2Inventory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2inventory, container, false);

        // Creating objects for each of the Edit Texts
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

        // Loads the Weapon slot #1 with its stats - currently just strings as placeholders
        // Name of the weapon
        weaponName.setText("Some Stick");

        // Class of weapon
        classType.setText("1h");

        // Damage modifier
        damageVal.setText("1d10+5");

        // Type of weapon
        typeVal.setText("Primative");

        // Amount of penetration
        penVal.setText("2");

        // Any special rules
        specialRules.setText("Shock");


    }
}
