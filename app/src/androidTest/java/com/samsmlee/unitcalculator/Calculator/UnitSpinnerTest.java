package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Spinner;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class UnitSpinnerTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public UnitSpinnerTest() {
        super(CalculatorActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(false);

        Intent startCalculatorIntent = new Intent(getInstrumentation().getTargetContext(), CalculatorActivity.class);
        startCalculatorIntent.putExtra(UnitTypeActivity.EXTRA_MESSAGE_UNIT_TYPE, UnitType.LENGTH);

        setActivityIntent(startCalculatorIntent);
        mActivity = getActivity();



    }

    public void tearDown() throws Exception {
        mActivity.finish();
        setActivity(null);

    }

    @UiThreadTest
    public void testUnitSpinner0() throws Exception {

        // don't change spinner and calculate. METER to METER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("12345", toScreenContent());

    }

    @UiThreadTest
    public void testUnitSpinner1() throws Exception {

        // change only From Unit spinner and calculate. KILOMETER to METER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        ((Spinner)mActivity.findViewById(R.id.fromUnitSpinner)).setSelection(2);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("12345000", toScreenContent());

    }

    @UiThreadTest
    public void testUnitSpinner2() throws Exception {

        // change only To Unit spinner and calculate. METER to KILOMETER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        ((Spinner)mActivity.findViewById(R.id.toUnitSpinner)).setSelection(2);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("12.345", toScreenContent());

    }

    @UiThreadTest
    public void testUnitSpinner3() throws Exception {

        // change both spinners and calculate. CENTIMETER to KILOMETER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        ((Spinner)mActivity.findViewById(R.id.fromUnitSpinner)).setSelection(1);
        ((Spinner)mActivity.findViewById(R.id.toUnitSpinner)).setSelection(2);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("0.12345", toScreenContent());

    }

    @UiThreadTest
    public void testUnitSpinner4() throws Exception {

        // change only From Unit spinner after EQUAL key. KILOMETER to METER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        ((Spinner)mActivity.findViewById(R.id.fromUnitSpinner)).setSelection(2);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("12345000", toScreenContent());

    }

    @UiThreadTest
    public void testUnitSpinner5() throws Exception {

        // change only To Unit spinner after EQUAL key. METER to KILOMETER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        ((Spinner)mActivity.findViewById(R.id.toUnitSpinner)).setSelection(2);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("12.345", toScreenContent());

    }

    @UiThreadTest
    public void testUnitSpinner6() throws Exception {

        // change both spinners after EQUAL key. CENTIMETER to KILOMETER
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        ((Spinner)mActivity.findViewById(R.id.fromUnitSpinner)).setSelection(1);
        ((Spinner)mActivity.findViewById(R.id.toUnitSpinner)).setSelection(2);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("0.12345", toScreenContent());

    }

    protected void pressKey(final int id) {
        mActivity.findViewById(id).performClick();
    }

    protected String fromScreenContent() {
        return ((TextView)mActivity.findViewById(R.id.fromScreen)).getText().toString();

    }

    protected String toScreenContent() {
        return ((TextView)mActivity.findViewById(R.id.toScreen)).getText().toString();

    }
}