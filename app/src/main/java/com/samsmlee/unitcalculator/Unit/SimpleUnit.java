package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
* Created by Sam on 1/1/2015.
*/
public enum SimpleUnit {

    METER(UnitBase.METER, UnitFactor.ONE, UnitType.LENGTH),
    CENTIMETER(UnitBase.METER, UnitFactor.CENTI, UnitType.LENGTH),
    KILOMETER(UnitBase.METER, UnitFactor.KILO, UnitType.LENGTH),
    MILLIMETER(UnitBase.METER, UnitFactor.MILLI, UnitType.LENGTH),
    INCH(UnitBase.INCH, UnitFactor.ONE, UnitType.LENGTH),
    FOOT(UnitBase.FOOT, UnitFactor.ONE, UnitType.LENGTH),
    YARD(UnitBase.YARD, UnitFactor.ONE, UnitType.LENGTH),
    MILE(UnitBase.MILE, UnitFactor.ONE, UnitType.LENGTH);

    protected final Unit unit;

    protected final UnitType type;

    SimpleUnit(UnitBase base, UnitFactor factor, UnitType type) {
        if (base == null) {
            throw new IllegalArgumentException("UnitBase cannot be null while constructing a " + getClass().getName());
        }
        if (factor == null) {
            throw new IllegalArgumentException("UnitFactor cannot be null while constructing a " + getClass().getName());
        }

        unit = new Unit(base, factor);
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }


    public UnitType getType() {
        return type;
    }

}
