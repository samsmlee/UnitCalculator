package com.samsmlee.unitcalculator.Converter;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/24/2014.
 */
public class VolumeConverter {
    public static BigDecimal convert(Unit fromUnit, Unit toUnit, BigDecimal value) {

        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Null unit is not allowed");
        }
        if (!fromUnit.isType(UnitType.VOLUME)) {
            throw new IllegalArgumentException(VolumeConverter.class.toString() + " can only convert from a VOLUME unit");
        }

        if (!toUnit.isType(UnitType.VOLUME)) {
            throw new IllegalArgumentException(VolumeConverter.class.toString() + " can only convert to a VOLUME unit");
        }


        switch (fromUnit.getBase()) {

            case CUBIC_METER:
                return convertFromCubicMeter(toUnit, value);
            case LITER:
                return convertFromLiter(toUnit, value);
            case FLUID_OUNCE:
                return convertFromFluidOunce(toUnit, value);
            case PINT:
                return convertFromPint(toUnit, value);
            case QUART:
                return convertFromQuart(toUnit, value);
            case GALLON:
                return convertFromGallon(toUnit, value);
            default:
                throw new UnsupportedOperationException("This unit base, " + fromUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromCubicMeter(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value;
            case LITER:
                ans = Converter.multiply(value, "1000");
                return ans;
            case FLUID_OUNCE:
                ans = Converter.multiply(value, "33814");
                return ans;
            case PINT:
                ans = Converter.multiply(value, "33814");
                ans = Converter.divide(ans, "16");
                return ans;
            case QUART:
                ans = Converter.multiply(value, "33814");
                ans = Converter.divide(ans, "16");
                ans = Converter.divide(ans, "2");
                return ans;
            case GALLON:
                ans = Converter.multiply(value, "33814");
                ans = Converter.divide(ans, "16");
                ans = Converter.divide(ans, "2");
                ans = Converter.divide(ans, "4");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromLiter(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                ans = Converter.divide(value, "1000");
                return ans;
            case LITER:
                return value;
            case FLUID_OUNCE:
                ans = Converter.multiply(value, "33.814");
                return ans;
            case PINT:
                ans = Converter.multiply(value, "33.814");
                ans = Converter.divide(ans, "16");
                return ans;
            case QUART:
                ans = Converter.multiply(value, "33.814");
                ans = Converter.divide(ans, "16");
                ans = Converter.divide(ans, "2");
                return ans;
            case GALLON:
                ans = Converter.multiply(value, "33.814");
                ans = Converter.divide(ans, "16");
                ans = Converter.divide(ans, "2");
                ans = Converter.divide(ans, "4");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromFluidOunce(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                ans = Converter.divide(value, "33.814");
                ans = Converter.divide(ans, "1000");
                return ans;
            case LITER:
                ans = Converter.divide(value, "33.814");
                return ans;
            case FLUID_OUNCE:
                return value;
            case PINT:
                ans = Converter.divide(value, "16");
                return ans;
            case QUART:
                ans = Converter.divide(value, "16");
                ans = Converter.divide(ans, "2");
                return ans;
            case GALLON:
                ans = Converter.divide(value, "16");
                ans = Converter.divide(ans, "2");
                ans = Converter.divide(ans, "4");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromPint(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                ans = Converter.multiply(value, "16");
                ans = Converter.divide(ans, "33.814");
                ans = Converter.divide(ans, "1000");
                return ans;
            case LITER:
                ans = Converter.multiply(value, "16");
                ans = Converter.divide(ans, "33.814");
                return ans;
            case FLUID_OUNCE:
                ans = Converter.multiply(value, "16");
                return ans;
            case PINT:
                return value;
            case QUART:
                ans = Converter.divide(value, "2");
                return ans;
            case GALLON:
                ans = Converter.divide(value, "2");
                ans = Converter.divide(value, "4");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromQuart(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                ans = Converter.multiply(value, "2");
                ans = Converter.multiply(ans, "16");
                ans = Converter.divide(ans, "33.814");
                ans = Converter.divide(ans, "1000");
                return ans;
            case LITER:
                ans = Converter.multiply(value, "2");
                ans = Converter.multiply(ans, "16");
                ans = Converter.divide(ans, "33.814");
                return ans;
            case FLUID_OUNCE:
                ans = Converter.multiply(value, "2");
                ans = Converter.multiply(ans, "16");
                return ans;
            case PINT:
                ans = Converter.multiply(value, "2");
                return ans;
            case QUART:
                return value;
            case GALLON:
                ans = Converter.divide(value, "4");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static BigDecimal convertFromGallon(Unit toUnit, BigDecimal value) {
        BigDecimal ans;
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                ans = Converter.multiply(value, "4");
                ans = Converter.multiply(ans, "2");
                ans = Converter.multiply(ans, "16");
                ans = Converter.divide(ans, "33.814");
                ans = Converter.divide(ans, "1000");
                return ans;
            case LITER:
                ans = Converter.multiply(value, "4");
                ans = Converter.multiply(ans, "2");
                ans = Converter.multiply(ans, "16");
                ans = Converter.divide(ans, "33.814");
                return ans;
            case FLUID_OUNCE:
                ans = Converter.multiply(value, "4");
                ans = Converter.multiply(ans, "2");
                ans = Converter.multiply(ans, "16");
                return ans;
            case PINT:
                ans = Converter.multiply(value, "4");
                ans = Converter.multiply(ans, "2");
                return ans;
            case QUART:
                ans = Converter.multiply(value, "4");
                return ans;
            case GALLON:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
