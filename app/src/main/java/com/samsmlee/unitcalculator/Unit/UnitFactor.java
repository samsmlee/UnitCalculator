package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Converter.Converter;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/23/2014.
 */
public enum UnitFactor {

    NANO (0.0000001),
    MICRO (0.000001),
    MILLI (0.001),
    CENTI (0.01),
    DECI (0.1),
    ONE (1),
    KILO (1000);

    private final double factor;

    UnitFactor(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }

    public static BigDecimal convert(UnitFactor fromFactor, UnitFactor toFactor, BigDecimal value) {
        if (fromFactor == null || toFactor == null) {
            throw new IllegalArgumentException("Null unit is not allowed");
        }
        BigDecimal ans;
        ans = Converter.multiply(value, (new Double(fromFactor.getFactor())).toString());
        ans = Converter.divide(ans, (new Double(toFactor.getFactor())).toString());

        return ans;
    }


}
