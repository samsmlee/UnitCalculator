package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.SimpleUnit;
import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class CalculatorActivity extends ActionBarActivity {
    public static final String ARGUMENT_UNIT_TYPE = "unit_type";
    protected UnitType type;
    protected DisplayUpdater updater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        this.type = (UnitType) intent.getSerializableExtra(UnitTypeActivity.EXTRA_MESSAGE_UNIT_TYPE);


        setContentView(R.layout.activity_calculator);
        updater = new DisplayUpdater((DisplayUpdateListener) getSupportFragmentManager().findFragmentById(R.id.displayFragment));




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public UnitType getType() {
        return type;
    }


    public void enterKey(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View is null");
        }
        String key_str;
        Key key;
        try {
            key_str = (String) ((Button) view).getText();
        } catch (ClassCastException e) {
            throw new ClassCastException("You need to be a Button call this handler");
        }

        if (key_str.isEmpty()) {
            throw new UnsupportedOperationException("The key needs to have a value");
        }
        try {
            key = Key.toKey(this, key_str);

        } catch (IllegalArgumentException e) {
            throw new UnsupportedOperationException("Invalid key");
        }

        switch (key) {
            case ZERO:
            case ONE:
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
                updater.enterNumber(key);
                break;
            case DOT:
                updater.enterDot();
                break;
            case SIGN:
                updater.negate();
                break;
            case EQUAL:
                Spinner fromUnitSpinner = (Spinner) findViewById(R.id.fromUnitSpinner);
                Spinner toUnitSpinner = (Spinner) findViewById(R.id.toUnitSpinner);
                Unit fromUnit = ((SimpleUnit) fromUnitSpinner.getSelectedItem()).getUnit();
                Unit toUnit = ((SimpleUnit) toUnitSpinner.getSelectedItem()).getUnit();
                updater.runConvert(fromUnit, toUnit);
                break;
            case DELETE:
                updater.delete();
                break;
            case CLEAR:
                updater.clear();
                break;
            default:
                throw new UnsupportedOperationException("Invalid key");
        }





    }
}
