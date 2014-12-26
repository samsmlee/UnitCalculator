package com.samsmlee.unitcalculator.Number;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;
import com.samsmlee.unitcalculator.Unit.UnitFactor;

import junit.framework.TestCase;

import java.text.DecimalFormat;

public class NumberTest extends TestCase {


    ///////////////////////////////////////////////////////////////////////////
    // Tests for public Number convert(Unit toUnit)
    ///////////////////////////////////////////////////////////////////////////

    // Null argument case
    public void testConvert_1Unit_NullArgument() throws Exception {
        Number n = new Number(UnitBase.METER, 1);

        try {
            n.convert((Unit)null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }


    // METER to YARD case
    public void testConvert_1Unit_MeterToYard() throws  Exception {
        Number n = new Number(UnitBase.METER, 1);

        Unit toUnit = new Unit(UnitBase.YARD, UnitFactor.ONE);
        Number converted = n.convert(toUnit);

        DecimalFormat df = new DecimalFormat("0.00000");

        String formatted = df.format(converted.getValue());

        assertEquals(1.09361, Double.parseDouble(formatted));

    }


    // GRAM to POUND case
    public void testConvert_1Unit_GramToPound() throws  Exception {
        Number n = new Number(UnitBase.GRAM, 1000);

        Unit toUnit = new Unit(UnitBase.POUND, UnitFactor.ONE);
        Number converted = n.convert(toUnit);

        DecimalFormat df = new DecimalFormat("0.00000");

        String formatted = df.format(converted.getValue());

        assertEquals(2.20462, Double.parseDouble(formatted));

    }


    ///////////////////////////////////////////////////////////////////////////
    // Tests for public Number convert(UnitBase toBase)
    ///////////////////////////////////////////////////////////////////////////
    // Null argument case
    public void testConvert_1UnitBase_NullArgument() throws Exception {
        Number n = new Number(UnitBase.METER, 1);

        try {
            n.convert((UnitBase)null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    // METER to YARD case
    public void testConvert_1UnitBase_MeterToYard() throws  Exception {
        Number n = new Number(UnitBase.METER, 1);

        Number converted = n.convert(UnitBase.YARD);

        DecimalFormat df = new DecimalFormat("0.00000");

        String formatted = df.format(converted.getValue());

        assertEquals(1.09361, Double.parseDouble(formatted));

    }

    // GRAM to POUND case
    public void testConvert_1UnitBase_GramToPound() throws  Exception {
        Number n = new Number(UnitBase.GRAM, 1000);

        Number converted = n.convert(UnitBase.POUND);

        DecimalFormat df = new DecimalFormat("0.00000");

        String formatted = df.format(converted.getValue());

        assertEquals(2.20462, Double.parseDouble(formatted));

    }




}