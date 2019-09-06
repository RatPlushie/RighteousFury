package com.studios.noodle.righteousfury;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab2Inventory extends Fragment {

    public tab2Inventory() {
        // Required empty public constructor
    }


    private ImageButton melWepMasterHideButton;
    private ImageButton misWepMasterHideButton;
    private ImageButton ammoMasterHideButton;

    private ImageButton mel1HideButton;
    private ImageButton mel2HideButton;
    private ImageButton mel3HideButton;
    private ImageButton mel4HideButton;

    private ImageButton mis1HideButton;
    private ImageButton mis2HideButton;
    private ImageButton mis3HideButton;
    private ImageButton mis4HideButton;

    private ImageButton ammo1HideButton;
    private ImageButton ammo2HideButton;
    private ImageButton ammo3HideButton;
    private ImageButton ammo4HideButton;

    private Spinner mel1ClassSpinner;
    private Spinner mel2ClassSpinner;
    private Spinner mel3ClassSpinner;
    private Spinner mel4ClassSpinner;
    private Spinner mis1ClassSpinner;
    private Spinner mis2ClassSpinner;
    private Spinner mis3ClassSpinner;
    private Spinner mis4ClassSpinner;

    private Spinner mel1TypeSpinner;
    private Spinner mel2TypeSpinner;
    private Spinner mel3TypeSpinner;
    private Spinner mel4TypeSpinner;
    private Spinner mis1TypeSpinner;
    private Spinner mis2TypeSpinner;
    private Spinner mis3TypeSpinner;
    private Spinner mis4TypeSpinner;

    private Spinner mis1RLDSpinner;
    private Spinner mis2RLDSpinner;
    private Spinner mis3RLDSpinner;
    private Spinner mis4RLDSpinner;

    private Spinner ammo1Spinner;
    private Spinner ammo2Spinner;
    private Spinner ammo3Spinner;
    private Spinner ammo4Spinner;

    private LinearLayout melMasterLayout;
    private LinearLayout misMasterLayout;
    private LinearLayout ammoMasterLayout;

    private LinearLayout mel1Layout;
    private LinearLayout mel2Layout;
    private LinearLayout mel3Layout;
    private LinearLayout mel4Layout;

    private LinearLayout mis1Layout;
    private LinearLayout mis2Layout;
    private LinearLayout mis3Layout;
    private LinearLayout mis4Layout;

    private LinearLayout ammo1Layout;
    private LinearLayout ammo2Layout;
    private LinearLayout ammo3Layout;
    private LinearLayout ammo4Layout;

    // TODO - add all views for the other fields



    // Constructor method for creating and initialising each spinner required on this page
    public void adapterConstructor(int mode, Spinner spinner){
        /* Mode:
            0: Class
            1: Type
            2: Reload
            3: Ammo
        */

        switch (mode){
            case 0: // Class
                // Creating the array adapter for the weapon classes to convert the string array into a usable form
                ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(getContext(), R.array.class_array, android.R.layout.simple_spinner_item);

                // Setting the type of drop down menu (Currently from the android layout libraries)
                classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Attaching the array adapter to the spinner
                spinner.setAdapter(classAdapter);

                // OnSelected listener for Class spinner
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                break;



            case 1: // Type
                // Creating the array adapter for the weapon classes to convert the string array into a usable form
                ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.type_array, android.R.layout.simple_spinner_item);

                // Setting the type of drop down menu (Currently from the android layout libraries)
                typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Attaching the array adapter to the spinner
                spinner.setAdapter(typeAdapter);

                // OnSelected listener for Class spinner -- MAY NOT ACTUALLY NEED THIS
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                break;

            case 2: // Reload
                // Creating the array adapter for the weapon classes to convert the string array into a usable form
                ArrayAdapter<CharSequence> rldAdapter = ArrayAdapter.createFromResource(getContext(), R.array.reload_array, android.R.layout.simple_spinner_item);

                // Setting the type of drop down menu (Currently from the android layout libraries)
                rldAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Attaching the array adapter to the spinner
                spinner.setAdapter(rldAdapter);

                // OnSelected listener for Class spinner -- MAY NOT ACTUALLY NEED THIS
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                break;

            case 3: // Type
                // Creating the array adapter for the weapon classes to convert the string array into a usable form
                ArrayAdapter<CharSequence> ammoAdapter = ArrayAdapter.createFromResource(getContext(), R.array.ammo_type_array, android.R.layout.simple_spinner_item);

                // Setting the type of drop down menu (Currently from the android layout libraries)
                ammoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Attaching the array adapter to the spinner
                spinner.setAdapter(ammoAdapter);

                // OnSelected listener for Class spinner -- MAY NOT ACTUALLY NEED THIS
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                break;



        }
    }

    // Constructor method for creating each collapse/expand button
    public void dropdownToggleConstructor(final ImageButton button, final LinearLayout slotLayout){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (slotLayout.getVisibility() == View.VISIBLE){ // Collapse
                    // Changes the button so the orientation is downwards, denoting the ability to expand the view at a later time
                    button.setImageResource(R.drawable.ic_arrow_down);

                    // Changes the visibility of the slot from visible to gone
                    slotLayout.setVisibility(View.GONE);

                } else if (slotLayout.getVisibility() == View.GONE){  //Expand
                    // Changes the button so the orientation is upwards, denoting the ability to collapse the view at a later time
                    button.setImageResource(R.drawable.ic_arrow_up_black_);

                    // Changes the visibility of the slot from gone to visible
                    slotLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2inventory, container, false);



        // Creating objects for each element on screen needed
        melWepMasterHideButton = view.findViewById(R.id.melWepMasterHideImageButton);
        misWepMasterHideButton = view.findViewById(R.id.misWepMaterHideImageButton);
        ammoMasterHideButton   = view.findViewById(R.id.ammoMainHideImageButton);

        mel1HideButton         = view.findViewById(R.id.melWep1HideImageButton);
        mel2HideButton         = view.findViewById(R.id.melWep2HideImageButton);
        mel3HideButton         = view.findViewById(R.id.melWep3HideImageButton);
        mel4HideButton         = view.findViewById(R.id.melWep4HideImageButton);

        mis1HideButton         = view.findViewById(R.id.misWep1HideImageButton);
        mis2HideButton         = view.findViewById(R.id.misWep2HideImageButton);
        mis3HideButton         = view.findViewById(R.id.misWep3HideImageButton);
        mis4HideButton         = view.findViewById(R.id.misWep4HideImageButton);

        ammo1HideButton        = view.findViewById(R.id.ammoCard1HideImageButton);
        ammo2HideButton        = view.findViewById(R.id.ammoCard2HideImageButton);
        ammo3HideButton        = view.findViewById(R.id.ammoCard3HideImageButton);
        ammo4HideButton        = view.findViewById(R.id.ammoCard4HideImageButton);

        mel1ClassSpinner       = view.findViewById(R.id.melWep1ClassSpinner);
        mel2ClassSpinner       = view.findViewById(R.id.melWep2ClassSpinner);
        mel3ClassSpinner       = view.findViewById(R.id.melWep3ClassSpinner);
        mel4ClassSpinner       = view.findViewById(R.id.melWep4ClassSpinner);

        mis1ClassSpinner       = view.findViewById(R.id.misWep1ClassSpinner);
        mis2ClassSpinner       = view.findViewById(R.id.misWep2ClassSpinner);
        mis3ClassSpinner       = view.findViewById(R.id.misWep3ClassSpinner);
        mis4ClassSpinner       = view.findViewById(R.id.misWep4ClassSpinner);

        mel1TypeSpinner        = view.findViewById(R.id.melWep1TypeSpinner);
        mel2TypeSpinner        = view.findViewById(R.id.melWep2TypeSpinner);
        mel3TypeSpinner        = view.findViewById(R.id.melWep3TypeSpinner);
        mel4TypeSpinner        = view.findViewById(R.id.melWep4TypeSpinner);

        mis1TypeSpinner        = view.findViewById(R.id.misWep1TypeSpinner);
        mis2TypeSpinner        = view.findViewById(R.id.misWep2TypeSpinner);
        mis3TypeSpinner        = view.findViewById(R.id.misWep3TypeSpinner);
        mis4TypeSpinner        = view.findViewById(R.id.misWep4TypeSpinner);

        mis1RLDSpinner         = view.findViewById(R.id.misWep1RLDSpinner);
        mis2RLDSpinner         = view.findViewById(R.id.misWep2RLDSpinner);
        mis3RLDSpinner         = view.findViewById(R.id.misWep3RLDSpinner);
        mis4RLDSpinner         = view.findViewById(R.id.misWep4RLDSpinner);

        ammo1Spinner           = view.findViewById(R.id.ammoCard1TypeSpinner);
        ammo2Spinner           = view.findViewById(R.id.ammoCard2TypeSpinner);
        ammo3Spinner           = view.findViewById(R.id.ammoCard3TypeSpinner);
        ammo4Spinner           = view.findViewById(R.id.ammoCard4TypeSpinner);

        melMasterLayout        = view.findViewById(R.id.melWepSlotLayouts);
        mel1Layout             = view.findViewById(R.id.melWep1Layout);
        mel2Layout             = view.findViewById(R.id.melWep2Layout);
        mel3Layout             = view.findViewById(R.id.melWep3Layout);
        mel4Layout             = view.findViewById(R.id.melWep4Layout);

        misMasterLayout        = view.findViewById(R.id.misWepSlotLayout);
        mis1Layout             = view.findViewById(R.id.misWep1Layout);
        mis2Layout             = view.findViewById(R.id.misWep2Layout);
        mis3Layout             = view.findViewById(R.id.misWep3Layout);
        mis4Layout             = view.findViewById(R.id.misWep4Layout);

        ammoMasterLayout       = view.findViewById(R.id.ammoCardLayout);
        ammo1Layout            = view.findViewById(R.id.ammoCard1Line1Layout);
        ammo2Layout            = view.findViewById(R.id.ammoCard2Line1Layout);
        ammo3Layout            = view.findViewById(R.id.ammoCard3Line1Layout);
        ammo4Layout            = view.findViewById(R.id.ammoCard4Line1Layout);

        // TODO - add variables to each view



        // Setting the collapse/expand functionality to each button
        dropdownToggleConstructor(melWepMasterHideButton, melMasterLayout);
        dropdownToggleConstructor(mel1HideButton, mel1Layout);
        dropdownToggleConstructor(mel2HideButton, mel2Layout);
        dropdownToggleConstructor(mel3HideButton, mel3Layout);
        dropdownToggleConstructor(mel4HideButton, mel4Layout);

        dropdownToggleConstructor(misWepMasterHideButton, misMasterLayout);
        dropdownToggleConstructor(mis1HideButton, mis1Layout);
        dropdownToggleConstructor(mis2HideButton, mis2Layout);
        dropdownToggleConstructor(mis3HideButton, mis3Layout);
        dropdownToggleConstructor(mis4HideButton, mis4Layout);

        dropdownToggleConstructor(ammoMasterHideButton, ammoMasterLayout);
        dropdownToggleConstructor(ammo1HideButton, ammo1Layout);
        dropdownToggleConstructor(ammo2HideButton, ammo2Layout);
        dropdownToggleConstructor(ammo3HideButton, ammo3Layout);
        dropdownToggleConstructor(ammo4HideButton, ammo4Layout);



        // Initialising and attaching the string-arrays to the spinners
        adapterConstructor(0, mel1ClassSpinner);
        adapterConstructor(0, mel2ClassSpinner);
        adapterConstructor(0, mel3ClassSpinner);
        adapterConstructor(0, mel4ClassSpinner);

        adapterConstructor(0, mis1ClassSpinner);
        adapterConstructor(0, mis2ClassSpinner);
        adapterConstructor(0, mis3ClassSpinner);
        adapterConstructor(0, mis4ClassSpinner);

        adapterConstructor(1, mel1TypeSpinner);
        adapterConstructor(1, mel2TypeSpinner);
        adapterConstructor(1, mel3TypeSpinner);
        adapterConstructor(1, mel4TypeSpinner);

        adapterConstructor(1, mis1TypeSpinner);
        adapterConstructor(1, mis2TypeSpinner);
        adapterConstructor(1, mis3TypeSpinner);
        adapterConstructor(1, mis4TypeSpinner);

        adapterConstructor(2, mis1RLDSpinner);
        adapterConstructor(2, mis2RLDSpinner);
        adapterConstructor(2, mis3RLDSpinner);
        adapterConstructor(2, mis4RLDSpinner);

        adapterConstructor(3, ammo1Spinner);
        adapterConstructor(3, ammo2Spinner);
        adapterConstructor(3, ammo3Spinner);
        adapterConstructor(3, ammo4Spinner);



        //Returns the view inflater
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();

        // TODO - implement load method
    }



    @Override
    public void onPause() {
        super.onPause();

        // TODO - implement save method
    }
}
