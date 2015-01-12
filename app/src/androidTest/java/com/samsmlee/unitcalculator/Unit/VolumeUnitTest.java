package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class VolumeUnitTest extends TestCase {

    protected final Unit cubic_meter = new Unit(UnitBase.CUBIC_METER);
    protected final Unit liter = new Unit(UnitBase.LITER);
    protected final Unit milliliter = new Unit(UnitBase.LITER, UnitFactor.MILLI);
    protected final Unit fluid_ounce = new Unit(UnitBase.FLUID_OUNCE);
    protected final Unit pint = new Unit(UnitBase.PINT);
    protected final Unit quart = new Unit(UnitBase.QUART);
    protected final Unit gallon = new Unit(UnitBase.GALLON);


    //////////////////////////////////////////////////////////////////////////
    //
    //  Volume Conversion unit test cases
    //
    //////////////////////////////////////////////////////////////////////////

    public void testFromCubicMeter() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(cubic_meter, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("1000")).toPlainString(), Unit.convert(cubic_meter, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("1000000")).toPlainString(), Unit.convert(cubic_meter, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("33814.022")).toPlainString(), Unit.convert(cubic_meter, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("2113.3764")).toPlainString(), Unit.convert(cubic_meter, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("1056.6882")).toPlainString(), Unit.convert(cubic_meter, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("264.17205")).toPlainString(), Unit.convert(cubic_meter, gallon, new BigDecimal("1")).toPlainString());

    }

    public void testFromLiter() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(liter, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(liter, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("1000")).toPlainString(), Unit.convert(liter, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("33.814022")).toPlainString(), Unit.convert(liter, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("2.1133764")).toPlainString(), Unit.convert(liter, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("1.0566882")).toPlainString(), Unit.convert(liter, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("0.26417205")).toPlainString(), Unit.convert(liter, gallon, new BigDecimal("1")).toPlainString());

    }

    public void testFromMilliliter() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("0.000001")).toPlainString(), Unit.convert(milliliter, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(milliliter, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(milliliter, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("0.033814022")).toPlainString(), Unit.convert(milliliter, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("0.0021133764")).toPlainString(), Unit.convert(milliliter, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("0.0010566882")).toPlainString(), Unit.convert(milliliter, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("0.00026417205")).toPlainString(), Unit.convert(milliliter, gallon, new BigDecimal("1")).toPlainString());

    }
    public void testFromFluidOunce() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("0.00002957353")).toPlainString(), Unit.convert(fluid_ounce, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("0.029573530")).toPlainString(), Unit.convert(fluid_ounce, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("29.573530")).toPlainString(), Unit.convert(fluid_ounce, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(fluid_ounce, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("0.0625")).toPlainString(), Unit.convert(fluid_ounce, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("0.03125")).toPlainString(), Unit.convert(fluid_ounce, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("0.0078125")).toPlainString(), Unit.convert(fluid_ounce, gallon, new BigDecimal("1")).toPlainString());

    }


    public void testFromPint() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("0.00047317648")).toPlainString(), Unit.convert(pint, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("0.47317648")).toPlainString(), Unit.convert(pint, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("473.17648")).toPlainString(), Unit.convert(pint, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("16")).toPlainString(), Unit.convert(pint, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(pint, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("0.5")).toPlainString(), Unit.convert(pint, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("0.125")).toPlainString(), Unit.convert(pint, gallon, new BigDecimal("1")).toPlainString());

    }

    public void testFromQuart() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("0.00094635297")).toPlainString(), Unit.convert(quart, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("0.94635297")).toPlainString(), Unit.convert(quart, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("946.35297")).toPlainString(), Unit.convert(quart, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("32")).toPlainString(), Unit.convert(quart, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("2")).toPlainString(), Unit.convert(quart, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(quart, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("0.25")).toPlainString(), Unit.convert(quart, gallon, new BigDecimal("1")).toPlainString());

    }

    public void testFromGallon() throws Exception {
        // To CUBIC_METER
        assertEquals((new BigDecimal("0.0037854119")).toPlainString(), Unit.convert(gallon, cubic_meter, new BigDecimal("1")).toPlainString());

        // To LITER
        assertEquals((new BigDecimal("3.7854119")).toPlainString(), Unit.convert(gallon, liter, new BigDecimal("1")).toPlainString());

        // To MILLILITER
        assertEquals((new BigDecimal("3785.4119")).toPlainString(), Unit.convert(gallon, milliliter, new BigDecimal("1")).toPlainString());

        // To FLUID_OUNCE
        assertEquals((new BigDecimal("128")).toPlainString(), Unit.convert(gallon, fluid_ounce, new BigDecimal("1")).toPlainString());

        // To PINT
        assertEquals((new BigDecimal("8")).toPlainString(), Unit.convert(gallon, pint, new BigDecimal("1")).toPlainString());

        // To QUART
        assertEquals((new BigDecimal("4")).toPlainString(), Unit.convert(gallon, quart, new BigDecimal("1")).toPlainString());

        // To GALLON
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(gallon, gallon, new BigDecimal("1")).toPlainString());

    }

}