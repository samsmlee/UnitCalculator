package com.samsmlee.unitcalculator.Converter;


import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * Created by Sam on 12/23/2014.
 */
public class LengthConverter {

    public static double convert(Unit fromUnit, Unit toUnit, double value) {
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Null unit is not allowed");
        }
        if (!fromUnit.isType(UnitType.LENGTH)) {
            throw new IllegalArgumentException(LengthConverter.class.toString() + " can only convert from a LENGTH unit");
        }

        if (!toUnit.isType(UnitType.LENGTH)) {
            throw new IllegalArgumentException(LengthConverter.class.toString() + " can only convert to a LENGTH unit");
        }


        switch (fromUnit.getBase()) {

            case METER:
                return convertFromMeter(toUnit, value);
            case INCH:
                return convertFromInch(toUnit, value);
            case FOOT:
                return convertFromFoot(toUnit, value);
            case YARD:
                return convertFromYard(toUnit, value);
            case MILE:
                return convertFromMile(toUnit, value);
            default:
                throw new UnsupportedOperationException("This unit base, " + fromUnit.getBase() + ", is not supported");
        }
    }


    protected static double convertFromMeter(Unit toUnit, double value) {


        switch (toUnit.getBase()) {

            case METER:
                // as is since METER and METER are same units
                return value;
            case INCH:
                return value / 0.0254;
            case FOOT:
                return value / 0.0254 / 12;
            case YARD:
                return value / 0.0254 / 12 / 3;
            case MILE:
                return value / 0.0254 / 12 / 3 / 1760;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    protected static double convertFromInch(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case METER:
                return value  * 0.0254;
            case INCH:
                return value;
            case FOOT:
                return value / 12;
            case YARD:
                return value / 12 / 3;
            case MILE:
                return value / 12 / 3 / 1760;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }


    protected static double convertFromFoot(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case METER:
                return value * 12 * 0.0254;
            case INCH:
                return value * 12;
            case FOOT:
                return value;
            case YARD:
                return value / 3;
            case MILE:
                return value / 3 / 1760;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    protected static double convertFromYard(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case METER:
                return value * 3 * 12 * 0.0254;
            case INCH:
                return value * 3 * 12;
            case FOOT:
                return value * 3;
            case YARD:
                return value;
            case MILE:
                return value / 1760;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }


    protected static double convertFromMile(Unit toUnit, double value) {

        switch (toUnit.getBase()) {

            case METER:
                return value * 1760 * 3 * 12 * 0.0254;
            case INCH:
                return value * 1760 * 3 * 12;
            case FOOT:
                return value * 1760 * 3;
            case YARD:
                return value * 1760;
            case MILE:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
