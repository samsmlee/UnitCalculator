package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class NumberKeyTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public NumberKeyTest() {
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
    public void testZeroKey0() throws Exception {

        // press ZERO right away
        pressKey(R.id.zero_key);
        assertEquals("From", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testZeroKey1() throws Exception {

        // press ZERO after " 1"
        pressKey(R.id.one_key);
        pressKey(R.id.zero_key);
        assertEquals(" 10", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testZeroKey2() throws Exception {

        // press ZERO after " 0."
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.zero_key);
        assertEquals(" 0.0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testZeroKey3() throws Exception {

        // press ZERO after "-1"
        pressKey(R.id.one_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.zero_key);
        assertEquals("-10", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testZeroKey4() throws Exception {

        // press ZERO after "1" then CLR
        pressKey(R.id.one_key);
        pressKey(R.id.clear_key);
        pressKey(R.id.zero_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("", toScreenContent());

    }

    @UiThreadTest
    public void testZeroKey5() throws Exception {

        // press ZERO after "12345" and EQUAL key
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.zero_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("12345", toScreenContent());

    }

    @UiThreadTest
    public void testOneKey0() throws Exception {

        // press ONE  right away
        pressKey(R.id.one_key);
        assertEquals(" 1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }


    @UiThreadTest
    public void testOneKey1() throws Exception {

        // press ZERO after " 1"
        pressKey(R.id.one_key);
        pressKey(R.id.one_key);
        assertEquals(" 11", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testOneKey2() throws Exception {

        // press ONE after " 0."
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.one_key);
        assertEquals(" 0.1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testOneKey3() throws Exception {

        // press ONE after "-1"
        pressKey(R.id.one_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.one_key);
        assertEquals("-11", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testOneKey4() throws Exception {

        // press ONE after "1" then CLR
        pressKey(R.id.one_key);
        pressKey(R.id.clear_key);
        pressKey(R.id.one_key);
        assertEquals(" 1", fromScreenContent());
        assertEquals("", toScreenContent());


    }

    @UiThreadTest
    public void testOneKey5() throws Exception {

        // press ONE after "12345" and EQUAL key
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.one_key);
        assertEquals(" 1", fromScreenContent());
        assertEquals("12345", toScreenContent());


    }

    @UiThreadTest
    public void testOtherNumberKeys0() throws Exception {

        // press "23456789"
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.six_key);
        pressKey(R.id.seven_key);
        pressKey(R.id.eight_key);
        pressKey(R.id.nine_key);
        assertEquals(" 23456789", fromScreenContent());
        assertEquals("To", toScreenContent());


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