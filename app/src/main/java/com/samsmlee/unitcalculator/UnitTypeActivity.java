package com.samsmlee.unitcalculator;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.samsmlee.unitcalculator.Calculator.CalculatorActivity;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

public class UnitTypeActivity extends ActionBarActivity {

    public static final String EXTRA_MESSAGE_UNIT_TYPE = "com.samsmlee.unitcalculator.SelectedUnitType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_type);
    }

    public void openLengthCalculator(View view) {
        startCalculator(UnitType.LENGTH);
    }

    public void openMassCalculator(View view) {
        startCalculator(UnitType.MASS);
    }

    public void openTemperatureCalculator(View view) {
        startCalculator(UnitType.TEMPERATURE);
    }

    public void openVolumeCalculator(View view) {
        startCalculator(UnitType.VOLUME);
    }

    protected void startCalculator(UnitType type) {
        if (type == null) {
            throw new IllegalArgumentException("Select a type for the calculator");
        }

        Intent startCalculatorIntent = new Intent(this, CalculatorActivity.class);
        startCalculatorIntent.putExtra(EXTRA_MESSAGE_UNIT_TYPE, type);

        startActivity(startCalculatorIntent);
    }
}
