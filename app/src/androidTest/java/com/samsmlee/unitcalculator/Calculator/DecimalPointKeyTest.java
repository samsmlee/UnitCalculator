package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class DecimalPointKeyTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public DecimalPointKeyTest() {
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
    public void testDecimalPointKey0() throws Exception {

        // press Decimal Point right away
        pressKey(R.id.decimal_point_key);
        assertEquals(" 0.", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDecimalPointKey1() throws Exception {

        // press Decimal Point right away, then "1"
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.one_key);
        assertEquals(" 0.1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDecimalPointKey2() throws Exception {

        // press Decimal Point after " 1234"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.decimal_point_key);
        assertEquals(" 1234.", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDecimalPointKey3() throws Exception {

        // press Decimal Point after " 1234", then enter "5"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.five_key);
        assertEquals(" 1234.5", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDecimalPointKey4() throws Exception {

        // press Decimal Point twice after " 1234"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.decimal_point_key);
        assertEquals(" 1234.", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testDecimalPointKey5() throws Exception {

        // press Decimal Point after " 1234.5"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.five_key);
        pressKey(R.id.decimal_point_key);
        assertEquals(" 1234.5", fromScreenContent());
        assertEquals("To", toScreenContent());

    }


    @UiThreadTest
    public void testDecimalPointKey6() throws Exception {

        // press Decimal Point after " 1234" and EQUAL key
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.decimal_point_key);
        assertEquals(" 0.", fromScreenContent());
        assertEquals("1234", toScreenContent());

    }


    @UiThreadTest
    public void testDecimalPointKey7() throws Exception {

        // press Decimal Point after " 1234.5" and EQUAL key
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.decimal_point_key);
        assertEquals(" 0.", fromScreenContent());
        assertEquals("1234.5", toScreenContent());

    }

    @UiThreadTest
    public void testDecimalPointKey8() throws Exception {

        // press Decimal Point after "-1"
        pressKey(R.id.one_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.decimal_point_key);
        assertEquals("-1.", fromScreenContent());
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