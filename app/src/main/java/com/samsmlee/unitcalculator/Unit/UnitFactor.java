package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Converter.Converter;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/23/2014.
 */
public enum UnitFactor {

    NANO (7),
    MICRO (6),
    MILLI (3),
    CENTI (2),
    DECI (1),
    ONE (0),
    KILO (-3);

    private final int factor;

    UnitFactor(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }

    public static BigDecimal convert(UnitFactor fromFactor, UnitFactor toFactor, BigDecimal value) {
        if (fromFactor == null || toFactor == null) {
            throw new IllegalArgumentException("Null unit is not allowed");
        }
        BigDecimal ans;
        ans = value.scaleByPowerOfTen(fromFactor.getFactor() * -1);
        ans = ans.scaleByPowerOfTen(toFactor.getFactor());

        return ans;
    }


}
