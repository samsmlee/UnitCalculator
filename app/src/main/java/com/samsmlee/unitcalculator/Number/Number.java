package com.samsmlee.unitcalculator.Number;

import com.samsmlee.unitcalculator.Unit.Unit;

import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;


/**
 * Created by Sam on 12/23/2014.
 */

public class Number {

    protected Unit unit;
    protected double value;
    private final UnitType type;

    protected Number(Unit unit, double value) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        this.unit = unit;
        this.type = unit.getType();
        this.value = value;
    }


    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit newUnit) {
        if (!newUnit.isType(this.type))
            throw new IllegalArgumentException("Incompatible type");
        this.unit = newUnit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double newValue) {
        this.value = newValue;
    }

    public Number convert(Unit toUnit) {

        double convertedValue = Unit.convert(this.unit, toUnit, this.value);

        return new Number(toUnit, convertedValue);
    }


}
