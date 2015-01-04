package com.samsmlee.unitcalculator.Converter;


import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/23/2014.
 */
public class LengthConverter {

    public static BigDecimal convert(Unit fromUnit, Unit toUnit, BigDecimal value) {
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


    protected static BigDecimal convertFromMeter(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case METER:
                // as is since METER and METER are same units
                return value;
            case INCH:
                ans = Converter.divide(value, "0.0254");
                return ans;
            case FOOT:
                ans = Converter.divide(value, "0.0254");
                ans = Converter.divide(ans, "12");
                return ans;
            case YARD:
                ans = Converter.divide(value, "0.0254");
                ans = Converter.divide(ans, "12");
                ans = Converter.divide(ans, "3");
                return ans;
            case MILE:
                ans = Converter.divide(value, "0.0254");
                ans = Converter.divide(ans, "12");
                ans = Converter.divide(ans, "3");
                ans = Converter.divide(ans, "1760");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    protected static BigDecimal convertFromInch(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case METER:
                ans = Converter.multiply(value, "0.0254");
                return ans;
            case INCH:
                return value;
            case FOOT:
                ans = Converter.divide(value, "12");
                return ans;
            case YARD:
                ans = Converter.divide(value, "12");
                ans = Converter.divide(ans, "3");
                return ans;
            case MILE:
                ans = Converter.divide(value, "12");
                ans = Converter.divide(ans, "3");
                ans = Converter.divide(ans, "1760");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }


    protected static BigDecimal convertFromFoot(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case METER:
                ans = Converter.multiply(value, "12");
                ans = Converter.multiply(ans, "0.0254");
                return ans;
            case INCH:
                ans = Converter.multiply(value, "12");
                return ans;
            case FOOT:
                return value;
            case YARD:
                ans = Converter.divide(value, "3");
                return ans;
            case MILE:
                ans = Converter.divide(value, "3");
                ans = Converter.divide(ans, "1760");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }

    protected static BigDecimal convertFromYard(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case METER:
                ans = Converter.multiply(value, "3");
                ans = Converter.multiply(ans, "12");
                ans = Converter.multiply(ans, "0.0254");
                return ans;
            case INCH:
                ans = Converter.multiply(value, "3");
                ans = Converter.multiply(ans, "12");
                return ans;
            case FOOT:
                ans = Converter.multiply(value, "3");
                return ans;
            case YARD:
                return value;
            case MILE:
                ans = Converter.divide(value, "1760");
                return ans;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }


    protected static BigDecimal convertFromMile(Unit toUnit, BigDecimal value) {

        BigDecimal ans;
        switch (toUnit.getBase()) {

            case METER:
                ans = Converter.multiply(value, "1760");
                ans = Converter.multiply(ans, "3");
                ans = Converter.multiply(ans, "12");
                ans = Converter.multiply(ans, "0.0254");
                return ans;
            case INCH:
                ans = Converter.multiply(value, "1760");
                ans = Converter.multiply(ans, "3");
                ans = Converter.multiply(ans, "12");
                return ans;
            case FOOT:
                ans = Converter.multiply(value, "1760");
                ans = Converter.multiply(ans, "3");
                return ans;
            case YARD:
                ans = Converter.multiply(value, "1760");
                return ans;
            case MILE:
                return value;
            default:
                throw new UnsupportedOperationException("This unit base, " + toUnit.getBase() + ", is not supported");
        }
    }
}
