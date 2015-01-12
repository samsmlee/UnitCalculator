package com.samsmlee.unitcalculator.Converter;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/24/2014.
 */
public class TemperatureConverter {
    public static BigDecimal convert(Unit fromUnit, Unit toUnit, BigDecimal value) {
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Null unit is not allowed");
        }
        if (!fromUnit.isType(UnitType.TEMPERATURE)) {
            throw new IllegalArgumentException(TemperatureConverter.class.toString() + " can only convert from a TEMPERATURE unit");
        }

        if (!toUnit.isType(UnitType.TEMPERATURE)) {
            throw new IllegalArgumentException(TemperatureConverter.class.toString() + " can only convert to a TEMPERATURE unit");
        }


        switch (fromUnit.getBase()) {

            case CELSIUS:
                return convertFromCelsius(toUnit, value);
            case FAHRENHEIT:
                return convertFromFahrenheit(toUnit, value);
            case KELVIN:
                return convertFromKelvin(toUnit, value);
            default:
                throw new UnsupportedOperationException("This unit base, " + fromUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromCelsius(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case CELSIUS:
                return value;
            case FAHRENHEIT:
                ans = Converter.multiply(value, "9");
                ans = Converter.divide(ans, "5");
                ans = Converter.add(ans, "32");
                return ans;
            case KELVIN:
                ans = Converter.add(value, "273.15");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromFahrenheit(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case CELSIUS:
                ans = Converter.subtract(value, "32");
                ans = Converter.multiply(ans, "5");
                ans = Converter.divide(ans, "9");
                return ans;
            case FAHRENHEIT:
                return value;
            case KELVIN:
                ans = Converter.subtract(value, "32");
                ans = Converter.multiply(ans, "5");
                ans = Converter.divide(ans, "9");
                ans = Converter.add(ans, "273.15");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromKelvin(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {

            case CELSIUS:
                ans = Converter.subtract(value, "273.15");
                return ans;
            case FAHRENHEIT:
                ans = Converter.subtract(value, "273.15");
                ans = Converter.multiply(ans, "9");
                ans = Converter.divide(ans, "5");
                ans = Converter.add(ans, "32");
                return ans;
            case KELVIN:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
