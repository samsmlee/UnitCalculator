package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class TemperatureUnitTest extends TestCase {

    protected final Unit fahrenheit = new Unit(UnitBase.FAHRENHEIT);
    protected final Unit celsius = new Unit(UnitBase.CELSIUS);
    protected final Unit kelvin = new Unit(UnitBase.KELVIN);


    //////////////////////////////////////////////////////////////////////////
    //
    //  Temperature Conversion unit test cases
    //
    //////////////////////////////////////////////////////////////////////////

    public void testFromFahrenheit() throws Exception {
        // To FAHRENHEIT
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(fahrenheit, fahrenheit, new BigDecimal("1")).toPlainString());

        // To CELSIUS
        assertEquals((new BigDecimal("-17.222222")).toPlainString(), Unit.convert(fahrenheit, celsius, new BigDecimal("1")).toPlainString());

        // To KELVIN
        assertEquals((new BigDecimal("255.927778")).toPlainString(), Unit.convert(fahrenheit, kelvin, new BigDecimal("1")).toPlainString());

    }

    public void testFromCelsius() throws Exception {
        // To FAHRENHEIT
        assertEquals((new BigDecimal("33.8")).toPlainString(), Unit.convert(celsius, fahrenheit, new BigDecimal("1")).toPlainString());

        // To CELSIUS
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(celsius, celsius, new BigDecimal("1")).toPlainString());

        // To KELVIN
        assertEquals((new BigDecimal("274.15")).toPlainString(), Unit.convert(celsius, kelvin, new BigDecimal("1")).toPlainString());


    }

    public void testFromKelvin() throws Exception {
        // To FAHRENHEIT
        assertEquals((new BigDecimal("-457.87")).toPlainString(), Unit.convert(kelvin, fahrenheit, new BigDecimal("1")).toPlainString());

        // To CELSIUS
        assertEquals((new BigDecimal("-272.15")).toPlainString(), Unit.convert(kelvin, celsius, new BigDecimal("1")).toPlainString());

        // To KELVIN
        assertEquals((new BigDecimal("1")).toPlainString(), Unit.convert(kelvin, kelvin, new BigDecimal("1")).toPlainString());

    }

}