package com.samsmlee.unitcalculator.Converter;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * Created by Sam on 12/24/2014.
 */
public class TemperatureConverter {
    public static double convert(Unit fromUnit, Unit toUnit, double value) {
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
            case FARHENHEIT:
                return convertFromFarhenheit(toUnit, value);
            case KELVIN:
                return convertFromKelvin(toUnit, value);
            default:
                throw new UnsupportedOperationException("This unit base, " + fromUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromCelsius(Unit toUnit, double value) {


        switch (toUnit.getBase()) {

            case CELSIUS:
                return value;
            case FARHENHEIT:
                return value * 9 / 5 + 32;
            case KELVIN:
                return value + 273.15;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromFarhenheit(Unit toUnit, double value) {


        switch (toUnit.getBase()) {

            case CELSIUS:
                return (value - 32) * 5 / 9;
            case FARHENHEIT:
                return value;
            case KELVIN:
                return (value - 32) * 5 / 9 + 273.15;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromKelvin(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case CELSIUS:
                return  value - 273.15;
            case FARHENHEIT:
                return (value - 273.15 - 32) * 5 / 9;
            case KELVIN:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
