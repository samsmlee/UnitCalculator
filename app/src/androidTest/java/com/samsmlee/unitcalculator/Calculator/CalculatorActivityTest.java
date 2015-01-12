package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class CalculatorActivityTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public CalculatorActivityTest() {
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
    public void testClearKey0() throws Exception {

        // press CLEAR right away
        pressKey(R.id.clear_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("", toScreenContent());

    }

    @UiThreadTest
    public void testClearKey1() throws Exception {

        // press CLEAR after some input before conversion
        pressKey(R.id.one_key);
        pressKey(R.id.zero_key);
        pressKey(R.id.clear_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("", toScreenContent());

    }

    @UiThreadTest
    public void testClearKey2() throws Exception {

        // press CLEAR after some input and conversion
        pressKey(R.id.one_key);
        pressKey(R.id.zero_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.clear_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("", toScreenContent());

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