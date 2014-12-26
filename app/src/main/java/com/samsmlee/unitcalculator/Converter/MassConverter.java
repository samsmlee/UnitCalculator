package com.samsmlee.unitcalculator.Converter;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * Created by Sam on 12/24/2014.
 */
public class MassConverter {

    public static double convert(Unit fromUnit, Unit toUnit, double value) {
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Null unit is not allowed");
        }
        if (!fromUnit.isType(UnitType.MASS)) {
            throw new IllegalArgumentException(MassConverter.class.toString() + " can only convert from a MASS unit");
        }

        if (!toUnit.isType(UnitType.MASS)) {
            throw new IllegalArgumentException(MassConverter.class.toString() + " can only convert to a MASS unit");
        }


        switch (fromUnit.getBase()) {

            case OUNCE:
                return convertFromOunce(toUnit, value);
            case POUND:
                return convertFromPound(toUnit, value);
            case GRAM:
                return convertFromGram(toUnit, value);
            default:
                throw new UnsupportedOperationException("This unit base, " + fromUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromOunce(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case OUNCE:
                return value;
            case POUND:
                return value / 16;
            case GRAM:
                return value / 16 * 453.592;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromPound(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case OUNCE:
                return value * 16;
            case POUND:
                return value;
            case GRAM:
                return value * 453.592;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromGram(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case OUNCE:
                return value / 453.592 * 16;
            case POUND:
                return value / 453.592;
            case GRAM:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
