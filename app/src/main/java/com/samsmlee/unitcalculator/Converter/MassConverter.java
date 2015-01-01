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
            case SHORT_TON:
                return convertFromShortTon(toUnit, value);
            case METRIC_TON:
                return convertFromMetricTon(toUnit, value);
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
            case SHORT_TON:
                return value / 16 / 2000;
            case METRIC_TON:
                return value / 16 * 453.592 / 1000 / 1000;
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
            case SHORT_TON:
                return value / 2000;
            case METRIC_TON:
                return value * 453.592 / 1000 / 1000;
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
            case SHORT_TON:
                return value / 453.592 / 2000;
            case METRIC_TON:
                return value / 1000 / 1000;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromShortTon(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case OUNCE:
                return value * 2000 * 16;
            case POUND:
                return value * 2000;
            case GRAM:
                return value * 2000 * 453.592;
            case SHORT_TON:
                return value;
            case METRIC_TON:
                return value * 2000 * 453.592 / 1000 / 1000;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromMetricTon(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case OUNCE:
                return value * 1000 * 1000 / 453.592 * 16;
            case POUND:
                return value * 1000 * 1000 / 453.592;
            case GRAM:
                return value * 1000 * 1000;
            case SHORT_TON:
                return value * 1000 * 1000 / 453.592 / 2000;
            case METRIC_TON:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
