package com.studios.noodle.righteousfury;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AttributeRollActivity extends AppCompatActivity {

    TextView activityTile;
    TextView activityAttributeVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_roll);

        // Retrieve the bundle
        Bundle bundle = getIntent().getExtras();

        // Extracting the passed data
        // Extracting the Name of the attribute from the bundle
        String attributeName = bundle.getString("attributeName");

        // Extracting the value of the attribute as an integer
        int attributeVal = Integer.parseInt(bundle.getString("attributeValue"));

        // Setting the title of the roll page to the attribute's name
        activityTile = findViewById(R.id.AttributeTitleTextView);
        activityTile.setText(attributeName);

        // Setting the value of the attribute visually
        activityAttributeVal = findViewById(R.id.AttributeValTextView);
        activityAttributeVal.setText(Integer.toString(attributeVal));

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
