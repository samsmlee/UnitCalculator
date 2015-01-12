package com.samsmlee.unitcalculator.Calculator;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;
import com.samsmlee.unitcalculator.UnitTypeActivity;

public class SignKeyTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity mActivity;

    public SignKeyTest() {
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
    public void testSignKey0() throws Exception {

        // press SIGN key right away. It should do nothing
        pressKey(R.id.sign_key);
        assertEquals("From", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testSignKey1() throws Exception {

        // press SIGN key after "12345"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.sign_key);
        assertEquals("-12345", fromScreenContent());
        assertEquals("To", toScreenContent());

    }
    @UiThreadTest
    public void testSignKey2() throws Exception {

        // press SIGN key after "-12345"
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.sign_key);
        assertEquals(" 12345", fromScreenContent());
        assertEquals("To", toScreenContent());

    }
    @UiThreadTest
    public void testSignKey3() throws Exception {

        // press SIGN key after "0.1"
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.one_key);
        pressKey(R.id.sign_key);
        assertEquals("-0.1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }


    @UiThreadTest
    public void testSignKey4() throws Exception {

        // press SIGN key after "-0.1"
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.sign_key);
        pressKey(R.id.one_key);
        pressKey(R.id.sign_key);
        assertEquals(" 0.1", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testSignKey5() throws Exception {

        // press SIGN key after " 0"
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.delete_key);
        pressKey(R.id.sign_key);
        assertEquals(" 0", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testSignKey6() throws Exception {

        // press SIGN key after " 0."
        pressKey(R.id.decimal_point_key);
        pressKey(R.id.sign_key);
        assertEquals("-0.", fromScreenContent());
        assertEquals("To", toScreenContent());

    }

    @UiThreadTest
    public void testSignKey7() throws Exception {

        // press SIGN key after " 12345" then EQUAL key
        pressKey(R.id.one_key);
        pressKey(R.id.two_key);
        pressKey(R.id.three_key);
        pressKey(R.id.four_key);
        pressKey(R.id.five_key);
        pressKey(R.id.equal_key);
        pressKey(R.id.sign_key);
        assertEquals("-12345", fromScreenContent());
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