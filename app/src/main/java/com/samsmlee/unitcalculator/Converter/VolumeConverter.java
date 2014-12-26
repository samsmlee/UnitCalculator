package com.samsmlee.unitcalculator.Converter;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * Created by Sam on 12/24/2014.
 */
public class VolumeConverter {
    public static double convert(Unit fromUnit, Unit toUnit, double value) {

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

    private static double convertFromCubicMeter(Unit toUnit, double value) {
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value;
            case LITER:
                return value * 1000;
            case FLUID_OUNCE:
                return value * 33814;
            case PINT:
                return value * 33814 / 16;
            case QUART:
                return value * 33814 / 16 / 2;
            case GALLON:
                return value * 33814 / 16 / 2 / 4;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromLiter(Unit toUnit, double value) {
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value / 1000;
            case LITER:
                return value;
            case FLUID_OUNCE:
                return value * 33.814;
            case PINT:
                return value * 33.814 / 16;
            case QUART:
                return value * 33.814 / 16 / 2;
            case GALLON:
                return value * 33.814 / 16 / 2 / 4;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromFluidOunce(Unit toUnit, double value) {
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value / 33.814 / 1000;
            case LITER:
                return value / 33.814;
            case FLUID_OUNCE:
                return value;
            case PINT:
                return value / 16;
            case QUART:
                return value / 16 / 2;
            case GALLON:
                return value / 16 / 2 / 4;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromPint(Unit toUnit, double value) {
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value * 16 / 33.814 / 1000;
            case LITER:
                return value * 16 / 33.814;
            case FLUID_OUNCE:
                return value * 16;
            case PINT:
                return value;
            case QUART:
                return value / 2;
            case GALLON:
                return value / 2 / 4;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromQuart(Unit toUnit, double value) {
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value * 2 * 16 / 33.814 / 1000;
            case LITER:
                return value * 2 * 16 / 33.814;
            case FLUID_OUNCE:
                return value * 2 * 16;
            case PINT:
                return value * 2;
            case QUART:
                return value;
            case GALLON:
                return value / 4;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    private static double convertFromGallon(Unit toUnit, double value) {
        switch (toUnit.getBase()) {
            case CUBIC_METER:
                return value * 4 * 2 * 16 / 33.814 / 1000;
            case LITER:
                return value * 4 * 2 * 16 / 33.814;
            case FLUID_OUNCE:
                return value * 4 * 2 * 16;
            case PINT:
                return value * 4 * 2;
            case QUART:
                return value * 4;
            case GALLON:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
