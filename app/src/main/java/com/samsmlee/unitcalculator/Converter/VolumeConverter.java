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
}
