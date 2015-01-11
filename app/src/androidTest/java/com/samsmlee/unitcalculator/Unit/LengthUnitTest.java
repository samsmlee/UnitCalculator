package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class LengthUnitTest extends TestCase {

    protected final Unit meter = new Unit(UnitBase.METER);
    protected final Unit centimeter = new Unit(UnitBase.METER, UnitFactor.CENTI);
    protected final Unit kilometer = new Unit(UnitBase.METER, UnitFactor.KILO);
    protected final Unit millimeter = new Unit(UnitBase.METER, UnitFactor.MILLI);
    protected final Unit inch = new Unit(UnitBase.INCH);
    protected final Unit foot = new Unit(UnitBase.FOOT);
    protected final Unit yard = new Unit(UnitBase.YARD);
    protected final Unit mile = new Unit(UnitBase.MILE);


    //////////////////////////////////////////////////////////////////////////
    //
    //  Length Conversion unit test cases
    //
    //////////////////////////////////////////////////////////////////////////

    public void testFromMeter() throws Exception {
        // To METER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(meter, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("100")).toPlainString(), Unit.convert(meter, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(meter, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("1000")).toPlainString(), Unit.convert(meter, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("39.370079")).toPlainString(), Unit.convert(meter, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("3.2808399")).toPlainString(), Unit.convert(meter, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("1.0936133")).toPlainString(), Unit.convert(meter, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.00062137119")).toPlainString(), Unit.convert(meter, mile, new BigDecimal("1")).toPlainString());


    }

    public void testFromCentimeter() throws Exception {
        // To METER
        assertEquals((new BigDecimal("0.01")).toPlainString(), Unit.convert(centimeter, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(centimeter, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("0.00001")).toPlainString(), Unit.convert(centimeter, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("10")).toPlainString(), Unit.convert(centimeter, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("0.39370079")).toPlainString(), Unit.convert(centimeter, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("0.032808399")).toPlainString(), Unit.convert(centimeter, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("0.010936133")).toPlainString(), Unit.convert(centimeter, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.0000062137119")).toPlainString(), Unit.convert(centimeter, mile, new BigDecimal("1")).toPlainString());


    }

    public void testFromKilometer() throws Exception {
        // To METER
        assertEquals((new BigDecimal("1000")).toPlainString(), Unit.convert(kilometer, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("100000")).toPlainString(), Unit.convert(kilometer, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(kilometer, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("1000000")).toPlainString(), Unit.convert(kilometer, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("39370.079")).toPlainString(), Unit.convert(kilometer, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("3280.8399")).toPlainString(), Unit.convert(kilometer, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("1093.6133")).toPlainString(), Unit.convert(kilometer, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.62137119")).toPlainString(), Unit.convert(kilometer, mile, new BigDecimal("1")).toPlainString());


    }


    public void testFromMillimeter() throws Exception {
        // To METER
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(millimeter, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("0.1")).toPlainString(), Unit.convert(millimeter, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("0.000001")).toPlainString(), Unit.convert(millimeter, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(millimeter, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("0.039370079")).toPlainString(), Unit.convert(millimeter, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("0.0032808399")).toPlainString(), Unit.convert(millimeter, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("0.0010936133")).toPlainString(), Unit.convert(millimeter, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.00000062137119")).toPlainString(), Unit.convert(millimeter, mile, new BigDecimal("1")).toPlainString());


    }

    public void testFromInch() throws Exception {
        // To METER
        assertEquals((new BigDecimal("0.0254")).toPlainString(), Unit.convert(inch, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("2.54")).toPlainString(), Unit.convert(inch, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("0.0000254")).toPlainString(), Unit.convert(inch, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("25.4")).toPlainString(), Unit.convert(inch, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(inch, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("0.083333333")).toPlainString(), Unit.convert(inch, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("0.027777778")).toPlainString(), Unit.convert(inch, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.000015782828")).toPlainString(), Unit.convert(inch, mile, new BigDecimal("1")).toPlainString());


    }

    public void testFromFoot() throws Exception {
        // To METER
        assertEquals((new BigDecimal("0.3048")).toPlainString(), Unit.convert(foot, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("30.48")).toPlainString(), Unit.convert(foot, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("0.0003048")).toPlainString(), Unit.convert(foot, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("304.8")).toPlainString(), Unit.convert(foot, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("12")).toPlainString(), Unit.convert(foot, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(foot, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("0.33333333")).toPlainString(), Unit.convert(foot, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.00018939394")).toPlainString(), Unit.convert(foot, mile, new BigDecimal("1")).toPlainString());


    }

    public void testFromYard() throws Exception {
        // To METER
        assertEquals((new BigDecimal("0.9144")).toPlainString(), Unit.convert(yard, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("91.44")).toPlainString(), Unit.convert(yard, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("0.0009144")).toPlainString(), Unit.convert(yard, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("914.4")).toPlainString(), Unit.convert(yard, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("36")).toPlainString(), Unit.convert(yard, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("3")).toPlainString(), Unit.convert(yard, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(yard, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("0.00056818182")).toPlainString(), Unit.convert(yard, mile, new BigDecimal("1")).toPlainString());


    }

    public void testFromMile() throws Exception {
        // To METER
        assertEquals((new BigDecimal("1609.3440")).toPlainString(), Unit.convert(mile, meter, new BigDecimal("1")).toPlainString());

        // To CENTIMETER
        assertEquals((new BigDecimal("160934.40")).toPlainString(), Unit.convert(mile, centimeter, new BigDecimal("1")).toPlainString());

        // To KILOMETER
        assertEquals((new BigDecimal("1.6093440")).toPlainString(), Unit.convert(mile, kilometer, new BigDecimal("1")).toPlainString());

        // To MILLIMETER
        assertEquals((new BigDecimal("1609344.0")).toPlainString(), Unit.convert(mile, millimeter, new BigDecimal("1")).toPlainString());

        // To INCH
        assertEquals((new BigDecimal("63360")).toPlainString(), Unit.convert(mile, inch, new BigDecimal("1")).toPlainString());

        // To FOOT
        assertEquals((new BigDecimal("5280")).toPlainString(), Unit.convert(mile, foot, new BigDecimal("1")).toPlainString());

        // To YARD
        assertEquals((new BigDecimal("1760")).toPlainString(), Unit.convert(mile, yard, new BigDecimal("1")).toPlainString());

        // To MILE
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(mile, mile, new BigDecimal("1")).toPlainString());


    }

}