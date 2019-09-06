package com.studios.noodle.righteousfury;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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



    private EditText mel1Name;
    private EditText mel2Name;
    private EditText mel3Name;
    private EditText mel4Name;
    private EditText mis1Name;
    private EditText mis2Name;
    private EditText mis3Name;
    private EditText mis4Name;

    private EditText mel1Damage_x;
    private EditText mel1Damage_y;
    private EditText mel1Damage_z;
    private EditText mel2Damage_x;
    private EditText mel2Damage_y;
    private EditText mel2Damage_z;
    private EditText mel3Damage_x;
    private EditText mel3Damage_y;
    private EditText mel3Damage_z;
    private EditText mel4Damage_x;
    private EditText mel4Damage_y;
    private EditText mel4Damage_z;
    private EditText mis1Damage_x;
    private EditText mis1Damage_y;
    private EditText mis1Damage_z;
    private EditText mis2Damage_x;
    private EditText mis2Damage_y;
    private EditText mis2Damage_z;
    private EditText mis3Damage_x;
    private EditText mis3Damage_y;
    private EditText mis3Damage_z;
    private EditText mis4Damage_x;
    private EditText mis4Damage_y;
    private EditText mis4Damage_z;

    private EditText mis1Range;
    private EditText mis2Range;
    private EditText mis3Range;
    private EditText mis4Range;

    private EditText mis1ROF_x;
    private EditText mis1ROF_y;
    private EditText mis1ROF_z;
    private EditText mis2ROF_x;
    private EditText mis2ROF_y;
    private EditText mis2ROF_z;
    private EditText mis3ROF_x;
    private EditText mis3ROF_y;
    private EditText mis3ROF_z;
    private EditText mis4ROF_x;
    private EditText mis4ROF_y;
    private EditText mis4ROF_z;

    private EditText mis1Clip;
    private EditText mis2Clip;
    private EditText mis3Clip;
    private EditText mis4Clip;

    private EditText mel1Pen;
    private EditText mel2Pen;
    private EditText mel3Pen;
    private EditText mel4Pen;
    private EditText mis1Pen;
    private EditText mis2Pen;
    private EditText mis3Pen;
    private EditText mis4Pen;

    private EditText mel1SpecialRules;
    private EditText mel2SpecialRules;
    private EditText mel3SpecialRules;
    private EditText mel4SpecialRules;
    private EditText mis1SpecialRules;
    private EditText mis2SpecialRules;
    private EditText mis3SpecialRules;
    private EditText mis4SpecialRules;

    private EditText ammo1Name;
    private EditText ammo2Name;
    private EditText ammo3Name;
    private EditText ammo4Name;

    private EditText ammo1No;
    private EditText ammo2No;
    private EditText ammo3No;
    private EditText ammo4No;

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



    // Variables for the shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";



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



    // Method for saving and loading spinner object's state
    public void loadSpinnerState(Spinner spinner, String sharedPrefsTag){

        // Initialisation of the shared preferences object
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Test to see if the shared prefs have stored a value or null. Loading the correct state
        if (!(sharedPreferences.getString(sharedPrefsTag, "").equals(""))){
            // If not null, fill with the previously saved state
            spinner.setSelection(Integer.parseInt(sharedPreferences.getString(sharedPrefsTag, "")));
        } else {
            // If null, load the first list item
            spinner.setSelection(0);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2inventory, container, false);



        // Creating objects for each element on screen needed
        melWepMasterHideButton  = view.findViewById(R.id.melWepMasterHideImageButton);
        misWepMasterHideButton  = view.findViewById(R.id.misWepMaterHideImageButton);
        ammoMasterHideButton    = view.findViewById(R.id.ammoMainHideImageButton);

        mel1HideButton          = view.findViewById(R.id.melWep1HideImageButton);
        mel2HideButton          = view.findViewById(R.id.melWep2HideImageButton);
        mel3HideButton          = view.findViewById(R.id.melWep3HideImageButton);
        mel4HideButton          = view.findViewById(R.id.melWep4HideImageButton);

        mis1HideButton          = view.findViewById(R.id.misWep1HideImageButton);
        mis2HideButton          = view.findViewById(R.id.misWep2HideImageButton);
        mis3HideButton          = view.findViewById(R.id.misWep3HideImageButton);
        mis4HideButton          = view.findViewById(R.id.misWep4HideImageButton);

        ammo1HideButton         = view.findViewById(R.id.ammoCard1HideImageButton);
        ammo2HideButton         = view.findViewById(R.id.ammoCard2HideImageButton);
        ammo3HideButton         = view.findViewById(R.id.ammoCard3HideImageButton);
        ammo4HideButton         = view.findViewById(R.id.ammoCard4HideImageButton);

        mel1ClassSpinner        = view.findViewById(R.id.melWep1ClassSpinner);
        mel2ClassSpinner        = view.findViewById(R.id.melWep2ClassSpinner);
        mel3ClassSpinner        = view.findViewById(R.id.melWep3ClassSpinner);
        mel4ClassSpinner        = view.findViewById(R.id.melWep4ClassSpinner);

        mis1ClassSpinner        = view.findViewById(R.id.misWep1ClassSpinner);
        mis2ClassSpinner        = view.findViewById(R.id.misWep2ClassSpinner);
        mis3ClassSpinner        = view.findViewById(R.id.misWep3ClassSpinner);
        mis4ClassSpinner        = view.findViewById(R.id.misWep4ClassSpinner);

        mel1TypeSpinner         = view.findViewById(R.id.melWep1TypeSpinner);
        mel2TypeSpinner         = view.findViewById(R.id.melWep2TypeSpinner);
        mel3TypeSpinner         = view.findViewById(R.id.melWep3TypeSpinner);
        mel4TypeSpinner         = view.findViewById(R.id.melWep4TypeSpinner);

        mis1TypeSpinner         = view.findViewById(R.id.misWep1TypeSpinner);
        mis2TypeSpinner         = view.findViewById(R.id.misWep2TypeSpinner);
        mis3TypeSpinner         = view.findViewById(R.id.misWep3TypeSpinner);
        mis4TypeSpinner         = view.findViewById(R.id.misWep4TypeSpinner);

        mis1RLDSpinner          = view.findViewById(R.id.misWep1RLDSpinner);
        mis2RLDSpinner          = view.findViewById(R.id.misWep2RLDSpinner);
        mis3RLDSpinner          = view.findViewById(R.id.misWep3RLDSpinner);
        mis4RLDSpinner          = view.findViewById(R.id.misWep4RLDSpinner);

        ammo1Spinner            = view.findViewById(R.id.ammoCard1TypeSpinner);
        ammo2Spinner            = view.findViewById(R.id.ammoCard2TypeSpinner);
        ammo3Spinner            = view.findViewById(R.id.ammoCard3TypeSpinner);
        ammo4Spinner            = view.findViewById(R.id.ammoCard4TypeSpinner);

        melMasterLayout         = view.findViewById(R.id.melWepSlotLayouts);
        mel1Layout              = view.findViewById(R.id.melWep1Layout);
        mel2Layout              = view.findViewById(R.id.melWep2Layout);
        mel3Layout              = view.findViewById(R.id.melWep3Layout);
        mel4Layout              = view.findViewById(R.id.melWep4Layout);

        misMasterLayout         = view.findViewById(R.id.misWepSlotLayout);
        mis1Layout              = view.findViewById(R.id.misWep1Layout);
        mis2Layout              = view.findViewById(R.id.misWep2Layout);
        mis3Layout              = view.findViewById(R.id.misWep3Layout);
        mis4Layout              = view.findViewById(R.id.misWep4Layout);

        ammoMasterLayout        = view.findViewById(R.id.ammoCardLayout);
        ammo1Layout             = view.findViewById(R.id.ammoCard1Line1Layout);
        ammo2Layout             = view.findViewById(R.id.ammoCard2Line1Layout);
        ammo3Layout             = view.findViewById(R.id.ammoCard3Line1Layout);
        ammo4Layout             = view.findViewById(R.id.ammoCard4Line1Layout);

        mel1Name                = view.findViewById(R.id.melWep1NameEditText);
        mel2Name                = view.findViewById(R.id.melWep2NameEditText);
        mel3Name                = view.findViewById(R.id.melWep3NameEditText);
        mel4Name                = view.findViewById(R.id.melWep4NameEditText);
        mis1Name                = view.findViewById(R.id.misWep1NameEditText);
        mis2Name                = view.findViewById(R.id.misWep2NameEditText);
        mis3Name                = view.findViewById(R.id.misWep3NameEditText);
        mis4Name                = view.findViewById(R.id.misWep4NameEditText);

        mel1Damage_x            = view.findViewById(R.id.melWep1Damage_x_editText);
        mel1Damage_y            = view.findViewById(R.id.melWep1Damage_y_editText);
        mel1Damage_z            = view.findViewById(R.id.melWep1Damage_z_editText);
        mel2Damage_x            = view.findViewById(R.id.melWep2Damage_x_editText);
        mel2Damage_y            = view.findViewById(R.id.melWep2Damage_y_editText);
        mel2Damage_z            = view.findViewById(R.id.melWep2Damage_z_editText);
        mel3Damage_x            = view.findViewById(R.id.melWep3Damage_x_editText);
        mel3Damage_y            = view.findViewById(R.id.melWep3Damage_y_editText);
        mel3Damage_z            = view.findViewById(R.id.melWep3Damage_z_editText);
        mel4Damage_x            = view.findViewById(R.id.melWep4Damage_x_editText);
        mel4Damage_y            = view.findViewById(R.id.melWep4Damage_y_editText);
        mel4Damage_z            = view.findViewById(R.id.melWep4Damage_z_editText);
        mis1Damage_x            = view.findViewById(R.id.misWep1Damage_x_editText);
        mis1Damage_y            = view.findViewById(R.id.misWep1Damage_y_editText);
        mis1Damage_z            = view.findViewById(R.id.misWep1Damage_z_editText);
        mis2Damage_x            = view.findViewById(R.id.misWep2Damage_x_editText);
        mis2Damage_y            = view.findViewById(R.id.misWep2Damage_y_editText);
        mis2Damage_z            = view.findViewById(R.id.misWep2Damage_z_editText);
        mis3Damage_x            = view.findViewById(R.id.misWep3Damage_x_editText);
        mis3Damage_y            = view.findViewById(R.id.misWep3Damage_y_editText);
        mis3Damage_z            = view.findViewById(R.id.misWep3Damage_z_editText);
        mis4Damage_x            = view.findViewById(R.id.misWep4Damage_x_editText);
        mis4Damage_y            = view.findViewById(R.id.misWep4Damage_y_editText);
        mis4Damage_z            = view.findViewById(R.id.misWep4Damage_z_editText);

        mis1Range               = view.findViewById(R.id.misWep1RangeEditText);
        mis2Range               = view.findViewById(R.id.misWep2RangeEditText);
        mis3Range               = view.findViewById(R.id.misWep3RangeEditText);
        mis4Range               = view.findViewById(R.id.misWep4RangeEditText);
        mis1ROF_x               = view.findViewById(R.id.misWep1RoF_x_editText);
        mis1ROF_y               = view.findViewById(R.id.misWep1RoF_y_editText);
        mis1ROF_z               = view.findViewById(R.id.misWep1RoF_z_editText);
        mis2ROF_x               = view.findViewById(R.id.misWep2RoF_x_editText);
        mis2ROF_y               = view.findViewById(R.id.misWep2RoF_y_editText);
        mis2ROF_z               = view.findViewById(R.id.misWep2RoF_z_editText);
        mis3ROF_x               = view.findViewById(R.id.misWep3RoF_x_editText);
        mis3ROF_y               = view.findViewById(R.id.misWep3RoF_y_editText);
        mis3ROF_z               = view.findViewById(R.id.misWep3RoF_z_editText);
        mis4ROF_x               = view.findViewById(R.id.misWep4RoF_x_editText);
        mis4ROF_y               = view.findViewById(R.id.misWep4RoF_y_editText);
        mis4ROF_z               = view.findViewById(R.id.misWep4RoF_z_editText);

        mis1Clip                = view.findViewById(R.id.misWep1ClipEditText);
        mis2Clip                = view.findViewById(R.id.misWep2ClipEditText);
        mis3Clip                = view.findViewById(R.id.misWep3ClipEditText);
        mis4Clip                = view.findViewById(R.id.misWep4ClipEditText);

        mel1Pen                 = view.findViewById(R.id.melWep1PenEditText);
        mel2Pen                 = view.findViewById(R.id.melWep2PenEditText);
        mel3Pen                 = view.findViewById(R.id.melWep3PenEditText);
        mel4Pen                 = view.findViewById(R.id.melWep4PenEditText);
        mis1Pen                 = view.findViewById(R.id.misWep1PenEditText);
        mis2Pen                 = view.findViewById(R.id.misWep2PenEditText);
        mis3Pen                 = view.findViewById(R.id.misWep3PenEditText);
        mis4Pen                 = view.findViewById(R.id.misWep4PenEditText);

        mel1SpecialRules        = view.findViewById(R.id.melWep1SpecialRulesEditText);
        mel2SpecialRules        = view.findViewById(R.id.melWep2SpecialRulesEditText);
        mel3SpecialRules        = view.findViewById(R.id.melWep3SpecialRulesEditText);
        mel4SpecialRules        = view.findViewById(R.id.melWep4SpecialRulesEditText);
        mis1SpecialRules        = view.findViewById(R.id.misWep1SpecialRulesEditText);
        mis2SpecialRules        = view.findViewById(R.id.misWep2SpecialRulesEditText);
        mis3SpecialRules        = view.findViewById(R.id.misWep3SpecialRulesEditText);
        mis4SpecialRules        = view.findViewById(R.id.misWep4SpecialRulesEditText);

        ammo1Name               = view.findViewById(R.id.ammoCard1NameEditText);
        ammo2Name               = view.findViewById(R.id.ammoCard2NameEditText);
        ammo3Name               = view.findViewById(R.id.ammoCard3NameEditText);
        ammo4Name               = view.findViewById(R.id.ammoCard4NameEditText);

        ammo1No                 = view.findViewById(R.id.ammoCard1NoEditText);
        ammo2No                 = view.findViewById(R.id.ammoCard2NoEditText);
        ammo3No                 = view.findViewById(R.id.ammoCard3NoEditText);
        ammo4No                 = view.findViewById(R.id.ammoCard4NoEditText);



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

        // Initialisation of the shared preference object to load character data onResume
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // Saving the values stored in the fields to shared preferences
        mel1Name.setText(sharedPreferences.getString("mel1WepName", ""));
        mel2Name.setText(sharedPreferences.getString("mel2WepName", ""));
        mel3Name.setText(sharedPreferences.getString("mel3WepName", ""));
        mel4Name.setText(sharedPreferences.getString("mel4WepName", ""));
        mis1Name.setText(sharedPreferences.getString("mis1WepName", ""));
        mis2Name.setText(sharedPreferences.getString("mis2WepName", ""));
        mis3Name.setText(sharedPreferences.getString("mis3WepName", ""));
        mis4Name.setText(sharedPreferences.getString("mis4WepName", ""));

        loadSpinnerState(mel1ClassSpinner, "mel1Class");
        loadSpinnerState(mel2ClassSpinner, "mel2Class");
        loadSpinnerState(mel3ClassSpinner, "mel3Class");
        loadSpinnerState(mel4ClassSpinner, "mel4Class");
        loadSpinnerState(mis1ClassSpinner, "mis1Class");
        loadSpinnerState(mis2ClassSpinner, "mis2Class");
        loadSpinnerState(mis3ClassSpinner, "mis3Class");
        loadSpinnerState(mis4ClassSpinner, "mis4Class");

        mel1Damage_x.setText(sharedPreferences.getString("mel1Damage_x",""));
        mel1Damage_y.setText(sharedPreferences.getString("mel1Damage_y",""));
        mel1Damage_z.setText(sharedPreferences.getString("mel1Damage_z",""));
        mel2Damage_x.setText(sharedPreferences.getString("mel2Damage_x",""));
        mel2Damage_y.setText(sharedPreferences.getString("mel2Damage_y",""));
        mel2Damage_z.setText(sharedPreferences.getString("mel2Damage_z",""));
        mel3Damage_x.setText(sharedPreferences.getString("mel3Damage_x",""));
        mel3Damage_y.setText(sharedPreferences.getString("mel3Damage_y",""));
        mel3Damage_z.setText(sharedPreferences.getString("mel3Damage_z",""));
        mel4Damage_x.setText(sharedPreferences.getString("mel4Damage_x",""));
        mel4Damage_y.setText(sharedPreferences.getString("mel4Damage_y",""));
        mel4Damage_z.setText(sharedPreferences.getString("mel4Damage_z",""));
        mis1Damage_x.setText(sharedPreferences.getString("mis1Damage_x",""));
        mis1Damage_y.setText(sharedPreferences.getString("mis1Damage_y",""));
        mis1Damage_z.setText(sharedPreferences.getString("mis1Damage_z",""));
        mis2Damage_x.setText(sharedPreferences.getString("mis2Damage_x",""));
        mis2Damage_y.setText(sharedPreferences.getString("mis2Damage_y",""));
        mis2Damage_z.setText(sharedPreferences.getString("mis2Damage_z",""));
        mis3Damage_x.setText(sharedPreferences.getString("mis3Damage_x",""));
        mis3Damage_y.setText(sharedPreferences.getString("mis3Damage_y",""));
        mis3Damage_z.setText(sharedPreferences.getString("mis3Damage_z",""));
        mis4Damage_x.setText(sharedPreferences.getString("mis4Damage_x",""));
        mis4Damage_y.setText(sharedPreferences.getString("mis4Damage_y",""));
        mis4Damage_z.setText(sharedPreferences.getString("mis4Damage_z",""));

        loadSpinnerState(mel1TypeSpinner, "mel1Type");
        loadSpinnerState(mel2TypeSpinner, "mel2Type");
        loadSpinnerState(mel3TypeSpinner, "mel3Type");
        loadSpinnerState(mel4TypeSpinner, "mel4Type");
        loadSpinnerState(mis1TypeSpinner, "mis1Type");
        loadSpinnerState(mis2TypeSpinner, "mis2Type");
        loadSpinnerState(mis3TypeSpinner, "mis3Type");
        loadSpinnerState(mis4TypeSpinner, "mis4Type");

        mis1Range.setText(sharedPreferences.getString("mis1Range", ""));
        mis2Range.setText(sharedPreferences.getString("mis2Range", ""));
        mis3Range.setText(sharedPreferences.getString("mis3Range", ""));
        mis4Range.setText(sharedPreferences.getString("mis4Range", ""));

        mis1ROF_x.setText(sharedPreferences.getString("mis1ROF_x", ""));
        mis1ROF_y.setText(sharedPreferences.getString("mis1ROF_y", ""));
        mis1ROF_z.setText(sharedPreferences.getString("mis1ROF_z", ""));
        mis2ROF_x.setText(sharedPreferences.getString("mis2ROF_x", ""));
        mis2ROF_y.setText(sharedPreferences.getString("mis2ROF_y", ""));
        mis2ROF_z.setText(sharedPreferences.getString("mis2ROF_z", ""));
        mis3ROF_x.setText(sharedPreferences.getString("mis3ROF_x", ""));
        mis3ROF_y.setText(sharedPreferences.getString("mis3ROF_y", ""));
        mis3ROF_z.setText(sharedPreferences.getString("mis3ROF_z", ""));
        mis4ROF_x.setText(sharedPreferences.getString("mis4ROF_x", ""));
        mis4ROF_y.setText(sharedPreferences.getString("mis4ROF_y", ""));
        mis4ROF_z.setText(sharedPreferences.getString("mis4ROF_z", ""));

        mis1Clip.setText(sharedPreferences.getString("mis1Clip", ""));
        mis2Clip.setText(sharedPreferences.getString("mis2Clip", ""));
        mis3Clip.setText(sharedPreferences.getString("mis3Clip", ""));
        mis4Clip.setText(sharedPreferences.getString("mis4Clip", ""));

        loadSpinnerState(mis1RLDSpinner, "mis1RLD");
        loadSpinnerState(mis2RLDSpinner, "mis2RLD");
        loadSpinnerState(mis3RLDSpinner, "mis3RLD");
        loadSpinnerState(mis4RLDSpinner, "mis4RLD");

        mel1Pen.setText(sharedPreferences.getString("mel1Pen", ""));
        mel2Pen.setText(sharedPreferences.getString("mel2Pen", ""));
        mel3Pen.setText(sharedPreferences.getString("mel3Pen", ""));
        mel4Pen.setText(sharedPreferences.getString("mel4Pen", ""));
        mis1Pen.setText(sharedPreferences.getString("mis1Pen", ""));
        mis2Pen.setText(sharedPreferences.getString("mis2Pen", ""));
        mis3Pen.setText(sharedPreferences.getString("mis3Pen", ""));
        mis4Pen.setText(sharedPreferences.getString("mis4Pen", ""));

        mel1SpecialRules.setText(sharedPreferences.getString("mel1SpecialRules" , ""));
        mel2SpecialRules.setText(sharedPreferences.getString("mel2SpecialRules" , ""));
        mel3SpecialRules.setText(sharedPreferences.getString("mel3SpecialRules" , ""));
        mel4SpecialRules.setText(sharedPreferences.getString("mel4SpecialRules" , ""));

        mis1SpecialRules.setText(sharedPreferences.getString("mis1SpecialRules" , ""));
        mis2SpecialRules.setText(sharedPreferences.getString("mis2SpecialRules" , ""));
        mis3SpecialRules.setText(sharedPreferences.getString("mis3SpecialRules" , ""));
        mis4SpecialRules.setText(sharedPreferences.getString("mis4SpecialRules" , ""));

        ammo1Name.setText(sharedPreferences.getString("ammo1Name", ""));
        ammo2Name.setText(sharedPreferences.getString("ammo2Name", ""));
        ammo3Name.setText(sharedPreferences.getString("ammo3Name", ""));
        ammo4Name.setText(sharedPreferences.getString("ammo4Name", ""));

        loadSpinnerState(ammo1Spinner, "ammo1Type");
        loadSpinnerState(ammo2Spinner, "ammo2Type");
        loadSpinnerState(ammo3Spinner, "ammo3Type");
        loadSpinnerState(ammo4Spinner, "ammo4Type");

        ammo1No.setText(sharedPreferences.getString("ammo1No", ""));
        ammo2No.setText(sharedPreferences.getString("ammo2No", ""));
        ammo3No.setText(sharedPreferences.getString("ammo3No", ""));
        ammo4No.setText(sharedPreferences.getString("ammo4No", ""));
   }



    @Override
    public void onPause() {
        super.onPause();

        // TODO - implement save method
    }
}
