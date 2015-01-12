package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class MassUnitTest extends TestCase {

    protected final Unit metric_ton = new Unit(UnitBase.METRIC_TON);
    protected final Unit kilogram = new Unit(UnitBase.GRAM, UnitFactor.KILO);
    protected final Unit gram = new Unit(UnitBase.GRAM);
    protected final Unit milligram = new Unit(UnitBase.GRAM, UnitFactor.MILLI);
    protected final Unit pound = new Unit(UnitBase.POUND);
    protected final Unit ounce = new Unit(UnitBase.OUNCE);
    protected final Unit short_ton = new Unit(UnitBase.SHORT_TON);


    //////////////////////////////////////////////////////////////////////////
    //
    //  Length Conversion unit test cases
    //
    //////////////////////////////////////////////////////////////////////////

    public void testFromMetricTon() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(metric_ton, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("1000.000")).toPlainString(), Unit.convert(metric_ton, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("1000000")).toPlainString(), Unit.convert(metric_ton, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("1000000000")).toPlainString(), Unit.convert(metric_ton, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("2204.6226")).toPlainString(), Unit.convert(metric_ton, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("35273.9616")).toPlainString(), Unit.convert(metric_ton, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("1.1023113")).toPlainString(), Unit.convert(metric_ton, short_ton, new BigDecimal("1")).toPlainString());


    }

    public void testFromKilogram() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(kilogram, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(kilogram, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("1000")).toPlainString(), Unit.convert(kilogram, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("1000000")).toPlainString(), Unit.convert(kilogram, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("2.2046226")).toPlainString(), Unit.convert(kilogram, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("35.2739616")).toPlainString(), Unit.convert(kilogram, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("0.0011023113")).toPlainString(), Unit.convert(kilogram, short_ton, new BigDecimal("1")).toPlainString());


    }

    public void testFromGram() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("0.000001")).toPlainString(), Unit.convert(gram, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(gram, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(gram, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("1000")).toPlainString(), Unit.convert(gram, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("0.0022046226")).toPlainString(), Unit.convert(gram, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("0.0352739616")).toPlainString(), Unit.convert(gram, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("0.0000011023113")).toPlainString(), Unit.convert(gram, short_ton, new BigDecimal("1")).toPlainString());


    }


    public void testFromMilligram() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("0.000000001")).toPlainString(), Unit.convert(milligram, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("0.000001")).toPlainString(), Unit.convert(milligram, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("0.001")).toPlainString(), Unit.convert(milligram, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(milligram, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("0.0000022046226")).toPlainString(), Unit.convert(milligram, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("0.0000352739616")).toPlainString(), Unit.convert(milligram, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("0.0000000011023113")).toPlainString(), Unit.convert(milligram, short_ton, new BigDecimal("1")).toPlainString());


    }

    public void testFromPound() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("0.00045359237")).toPlainString(), Unit.convert(pound, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("0.45359237")).toPlainString(), Unit.convert(pound, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("453.59237")).toPlainString(), Unit.convert(pound, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("453592.37")).toPlainString(), Unit.convert(pound, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(pound, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("16")).toPlainString(), Unit.convert(pound, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("0.0005")).toPlainString(), Unit.convert(pound, short_ton, new BigDecimal("1")).toPlainString());


    }

    public void testFromOunce() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("0.000028349523")).toPlainString(), Unit.convert(ounce, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("0.028349523125")).toPlainString(), Unit.convert(ounce, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("28.349523125")).toPlainString(), Unit.convert(ounce, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("28349.523125")).toPlainString(), Unit.convert(ounce, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("0.0625")).toPlainString(), Unit.convert(ounce, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(ounce, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("0.00003125")).toPlainString(), Unit.convert(ounce, short_ton, new BigDecimal("1")).toPlainString());


    }

    public void testFromShortTon() throws Exception {
        // To METRIC_TON
        assertEquals((new BigDecimal("0.90718474")).toPlainString(), Unit.convert(short_ton, metric_ton, new BigDecimal("1")).toPlainString());

        // To KILOGRAM
        assertEquals((new BigDecimal("907.18474000")).toPlainString(), Unit.convert(short_ton, kilogram, new BigDecimal("1")).toPlainString());

        // To GRAM
        assertEquals((new BigDecimal("907184.74000")).toPlainString(), Unit.convert(short_ton, gram, new BigDecimal("1")).toPlainString());

        // To MILLIGRAM
        assertEquals((new BigDecimal("907184740.00")).toPlainString(), Unit.convert(short_ton, milligram, new BigDecimal("1")).toPlainString());

        // To POUND
        assertEquals((new BigDecimal("2000")).toPlainString(), Unit.convert(short_ton, pound, new BigDecimal("1")).toPlainString());

        // To OUNCE
        assertEquals((new BigDecimal("32000")).toPlainString(), Unit.convert(short_ton, ounce, new BigDecimal("1")).toPlainString());

        // To SHORT_TON
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(short_ton, short_ton, new BigDecimal("1")).toPlainString());


    }


}