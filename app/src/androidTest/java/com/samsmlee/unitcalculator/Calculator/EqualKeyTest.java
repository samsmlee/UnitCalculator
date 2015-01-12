package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Spinner;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class EqualKeyTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public EqualKeyTest() {
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
    public void testEqualKey0() throws Exception {

        // press EQUAL right away
        pressKey(R.id.equal_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("0", toScreenContent());

    }

    @UiThreadTest
    public void testEqualKey1() throws Exception {

        // press EQUAL after "12345"
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
    public void testEqualKey2() throws Exception {

        // press EQUAL after "-12345"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.equal_key);
        assertEquals("-12345", fromScreenContent());
        assertEquals("-12345", toScreenContent());

    }

    @UiThreadTest
    public void testEqualKey3() throws Exception {

        // press EQUAL after " 123.45"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        assertEquals(" 123.45", fromScreenContent());
        assertEquals("123.45", toScreenContent());

    }

    @UiThreadTest
    public void testEqualKey4() throws Exception {

        // press EQUAL after "-123.45"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.equal_key);
        assertEquals("-123.45", fromScreenContent());
        assertEquals("-123.45", toScreenContent());

    }

    @UiThreadTest
    public void testEqualKey5() throws Exception {

        // press EQUAL after " 12345", EQUAL, change To Unit Spinner
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        // Set ToUnit Spinner to Centimeter
        ((Spinner)mActivity.findViewById(R.id.toUnitSpinner)).setSelection(1);
        pressKey(R.id.equal_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("1234500", toScreenContent());

    }

    @UiThreadTest
    public void testEqualKey6() throws Exception {

        // press EQUAL after " 12345", EQUAL, and "1"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.one_key);
        pressKey(R.id.equal_key);
        assertEquals(" 1", fromScreenContent());
        assertEquals("1", toScreenContent());

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