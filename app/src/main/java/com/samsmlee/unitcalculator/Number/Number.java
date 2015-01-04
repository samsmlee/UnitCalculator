package com.samsmlee.unitcalculator.Number;

import com.samsmlee.unitcalculator.Unit.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;
import com.samsmlee.unitcalculator.Unit.UnitFactor;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.math.BigDecimal;

/**
 * Created by Sam on 12/23/2014.
 */

public class Number {

    protected Unit unit;
    protected BigDecimal value;
    private final UnitType type;

    public Number(Unit unit, BigDecimal value) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        this.unit = unit;
        this.type = unit.getType();
        this.value = value;
    }

    public Number(Unit unit, String value) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        this.unit = unit;
        this.type = unit.getType();
        this.value = new BigDecimal(value);
    }


    public Number(UnitBase unitBase, UnitFactor unitFactor, BigDecimal value) {

        if (unitBase == null || unitFactor == null )
            throw new IllegalArgumentException("Unit base or factor cannot be null");

        Unit unit = new Unit(unitBase, unitFactor);
        this.unit = unit;
        this.type = unit.getType();
        this.value = value;
    }

    public Number(UnitBase unitBase, BigDecimal value) {

        if (unitBase == null)
            throw new IllegalArgumentException("Unit base cannot be null");

        Unit unit = new Unit(unitBase);
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal newValue) {
        this.value = newValue;
    }

    public Number convert(Unit toUnit) {

        if (toUnit == null) {
            throw new IllegalArgumentException("Cannot convert to a null unit");
        }
        BigDecimal convertedValue = Unit.convert(this.unit, toUnit, this.value);

        return new Number(toUnit, convertedValue);
    }

    // Assumes UnitFactor is UnitFactor.ONE
    public Number convert(UnitBase toBase) {

        if (toBase == null) {
            throw new IllegalArgumentException("Cannot convert to a null unit");
        }

        Unit toUnit = new Unit(toBase, UnitFactor.ONE);

        BigDecimal convertedValue = Unit.convert(this.unit, toUnit, this.value);

        return new Number(toUnit, convertedValue);
    }


}
