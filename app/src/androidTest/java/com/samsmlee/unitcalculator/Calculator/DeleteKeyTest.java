package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class DeleteKeyTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public DeleteKeyTest() {
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
    public void testDeleteKey0() throws Exception {

        // press DELETE right away
        pressKey(R.id.delete_key);
        assertEquals("From", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey1() throws Exception {

        // press DELETE after " 10"
        pressKey(R.id.one_key);
        pressKey(R.id.zero_key);
        pressKey(R.id.delete_key);
        assertEquals(" 1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey2() throws Exception {

        // press DELETE after "-10"
        pressKey(R.id.one_key);
        pressKey(R.id.zero_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.delete_key);
        assertEquals("-1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey3() throws Exception {

        // press DELETE twice after " 10"
        pressKey(R.id.one_key);
        pressKey(R.id.zero_key);
        pressKey(R.id.delete_key);
        pressKey(R.id.delete_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey4() throws Exception {

        // press DELETE after "0."
        pressKey(R.id.zero_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.delete_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey5() throws Exception {

        // press DELETE after "-0."
        pressKey(R.id.zero_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.delete_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey6() throws Exception {

        // press DELETE after "-0.0"
        pressKey(R.id.zero_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.zero_key);
        pressKey(R.id.delete_key);
        assertEquals("-0.", fromScreenContent());
        assertEquals("To", toScreenContent());
        pressKey(R.id.delete_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey7() throws Exception {

        // press DELETE after "-1"
        pressKey(R.id.one_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.delete_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDeleteKey8() throws Exception {

        // press DELETE after "12345" and equal sign
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.delete_key);
        assertEquals(" 1234", fromScreenContent());
        assertEquals("12345", toScreenContent());

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