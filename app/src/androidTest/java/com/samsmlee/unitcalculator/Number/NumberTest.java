package com.samsmlee.unitcalculator.Number;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;

import junit.framework.TestCase;

public class NumberTest extends TestCase {


    // Null argument case
    public void testConvert_NullArgument() throws Exception {
        Number n = new Number(UnitBase.METER, 1);

        try {
            n.convert((Unit)null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    // meter to yard case
    public void testConvert_MeterToYard() throws  Exception {
        Number n = new Number(UnitBase.METER, 1);

        Number converted = n.convert(UnitBase.YARD);

        assertEquals(1.09361, converted.getValue());

    }


}