package com.studios.noodle.righteousfury;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab2Inventory extends Fragment {

    public tab2Inventory() {
        // Required empty public constructor
    }



    Spinner mel1ClassSpinner;
    Spinner mel1TypeSpinner;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2inventory, container, false);



        // Creating objects for each element on screen needed
        mel1ClassSpinner = view.findViewById(R.id.melWep1ClassSpinner);
        mel1TypeSpinner = view.findViewById(R.id.melWep1TypeSpinner);




        // Creating the array adapter for the weapon classes to convert the string array into a usable form
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.class_array, android.R.layout.simple_spinner_item);

        // Setting the type of drop down menu (Currently from the android layout libraries)
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attaching the array adapter to the spinner
        mel1ClassSpinner.setAdapter(classAdapter);



        // Creating the array adapter for the weapon types to convert the string array into a usable form
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.type_array, android.R.layout.simple_spinner_item);

        // Setting the type of drop down menu (Currently from the android layout libraries)
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attaching the array adapter to the spinner
        mel1TypeSpinner.setAdapter(typeAdapter);



        // OnSelected listener for melee weapon 1's Class
        mel1ClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        // OnSelected listener for melee weapon 1's Type
        mel1TypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //Returns the view inflater
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
    }



    @Override
    public void onPause() {
        super.onPause();
    }
}
