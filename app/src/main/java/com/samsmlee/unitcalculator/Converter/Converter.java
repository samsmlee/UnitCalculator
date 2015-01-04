package com.samsmlee.unitcalculator.Converter;


import com.samsmlee.unitcalculator.Calculator.DisplayUpdater;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Converter
 * Provides all the methods that other Converters need
 */
public class Converter {


    public static BigDecimal add(BigDecimal n1, String n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot add a null value");
        }
        return n1.add(new BigDecimal(n2));
    }
    public static BigDecimal add(String n1, BigDecimal n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot add a null value");
        }
        return (new BigDecimal(n1)).add(n2);
    }


    public static BigDecimal subtract(BigDecimal n1, String n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot subtract a null value");
        }
        return n1.add(new BigDecimal(n2));
    }


    public static BigDecimal subtract(String n1, BigDecimal n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot subtract a null value");
        }
        return (new BigDecimal(n1)).subtract(n2);
    }

    public static BigDecimal multiply(BigDecimal n1, String n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot multiply a null value");
        }
        return n1.multiply(new BigDecimal(n2));
    }

    public static BigDecimal multiply(String n1, BigDecimal n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot multiply a null value");
        }
        return (new BigDecimal(n1)).multiply(n2);
    }

    public static BigDecimal divide(BigDecimal n1, String n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot divide a null value");
        }
        MathContext mc = new MathContext(DisplayUpdater.MAX_PRECISION, RoundingMode.HALF_UP);
        return n1.divide(new BigDecimal(n2), mc);
    }

    public static BigDecimal divide(String n1, BigDecimal n2) {

        if (n1 == null || n2 == null) {
            throw new NullPointerException("Cannot divide a null value");
        }

        MathContext mc = new MathContext(DisplayUpdater.MAX_PRECISION, RoundingMode.HALF_UP);
        return (new BigDecimal(n1)).divide(n2, mc);
    }

}
