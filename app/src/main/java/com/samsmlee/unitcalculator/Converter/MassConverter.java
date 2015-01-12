package com.samsmlee.unitcalculator.Converter;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/24/2014.
 */
public class MassConverter {

    public static BigDecimal convert(Unit fromUnit, Unit toUnit, BigDecimal value) {
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

    private static BigDecimal convertFromOunce(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {

            case OUNCE:
                return value;
            case POUND:
                ans = Converter.divide(value, "16");
                return ans;
            case GRAM:
                ans = Converter.divide(value, "16");
                ans = Converter.multiply(ans, "453.59237");
                return ans;
            case SHORT_TON:
                ans = Converter.divide(value, "16");
                ans = Converter.divide(ans, "2000");
                return ans;
            case METRIC_TON:
                ans = Converter.divide(value, "16");
                ans = Converter.multiply(ans, "453.59237");
                ans = Converter.divide(ans, "1000");
                ans = Converter.divide(ans, "1000");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromPound(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {

            case OUNCE:
                ans = Converter.multiply(value, "16");
                return ans;
            case POUND:
                return value;
            case GRAM:
                ans = Converter.multiply(value, "453.59237");
                return ans;
            case SHORT_TON:
                ans = Converter.divide(value, "2000");
                return ans;
            case METRIC_TON:
                ans = Converter.multiply(value, "453.59237");
                ans = Converter.divide(ans, "1000");
                ans = Converter.divide(ans, "1000");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromGram(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {

            case OUNCE:
                ans = Converter.divide(value, "453.59237");
                ans = Converter.multiply(ans, "16");
                return ans;
            case POUND:
                ans = Converter.divide(value, "453.59237");
                return ans;
            case GRAM:
                return value;
            case SHORT_TON:
                ans = Converter.divide(value, "453.59237");
                ans = Converter.divide(ans, "2000");
                return ans;
            case METRIC_TON:
                ans = Converter.divide(value, "1000");
                ans = Converter.divide(ans, "1000");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromShortTon(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {

            case OUNCE:
                ans = Converter.multiply(value, "2000");
                ans = Converter.multiply(ans, "16");
                return ans;
            case POUND:
                ans = Converter.multiply(value, "2000");
                return ans;
            case GRAM:
                ans = Converter.multiply(value, "2000");
                ans = Converter.multiply(ans, "453.59237");
                return ans;
            case SHORT_TON:
                return value;
            case METRIC_TON:
                ans = Converter.multiply(value, "2000");
                ans = Converter.multiply(ans, "453.59237");
                ans = Converter.divide(ans, "1000");
                ans = Converter.divide(ans, "1000");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromMetricTon(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {

            case OUNCE:
                ans = Converter.multiply(value, "1000");
                ans = Converter.multiply(ans, "1000");
                ans = Converter.divide(ans, "453.59237");
                ans = Converter.multiply(ans, "16");
                return ans;
            case POUND:
                ans = Converter.multiply(value, "1000");
                ans = Converter.multiply(ans, "1000");
                ans = Converter.divide(ans, "453.59237");
                return ans;
            case GRAM:
                ans = Converter.multiply(value, "1000");
                ans = Converter.multiply(ans, "1000");
                return ans;
            case SHORT_TON:
                ans = Converter.multiply(value, "1000");
                ans = Converter.multiply(ans, "1000");
                ans = Converter.divide(ans, "453.59237");
                ans = Converter.divide(ans, "2000");
                return ans;
            case METRIC_TON:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
