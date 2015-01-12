package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.util.ArrayList;

/**
* Created by Sam on 1/1/2015.
*/
public enum SimpleUnit {

    // LENGTH
    METER(UnitBase.METER, UnitFactor.ONE, UnitType.LENGTH),
    CENTIMETER(UnitBase.METER, UnitFactor.CENTI, UnitType.LENGTH),
    KILOMETER(UnitBase.METER, UnitFactor.KILO, UnitType.LENGTH),
    MILLIMETER(UnitBase.METER, UnitFactor.MILLI, UnitType.LENGTH),
    INCH(UnitBase.INCH, UnitFactor.ONE, UnitType.LENGTH),
    FOOT(UnitBase.FOOT, UnitFactor.ONE, UnitType.LENGTH),
    YARD(UnitBase.YARD, UnitFactor.ONE, UnitType.LENGTH),
    MILE(UnitBase.MILE, UnitFactor.ONE, UnitType.LENGTH),

    // MASS
    METRIC_TON(UnitBase.METRIC_TON, UnitFactor.ONE, UnitType.MASS),
    KILOGRAM(UnitBase.GRAM, UnitFactor.KILO, UnitType.MASS),
    GRAM(UnitBase.GRAM, UnitFactor.ONE, UnitType.MASS),
    MILLIGRAM(UnitBase.GRAM, UnitFactor.MILLI, UnitType.MASS),
    POUND(UnitBase.POUND, UnitFactor.ONE, UnitType.MASS),
    OUNCE(UnitBase.OUNCE, UnitFactor.ONE, UnitType.MASS),
    SHORT_TON(UnitBase.SHORT_TON, UnitFactor.ONE, UnitType.MASS),

    // TEMPERATURE
    FAHRENHEIT(UnitBase.FAHRENHEIT, UnitFactor.ONE, UnitType.TEMPERATURE),
    CELSIUS(UnitBase.CELSIUS, UnitFactor.ONE, UnitType.TEMPERATURE),
    KELVIN(UnitBase.KELVIN, UnitFactor.ONE, UnitType.TEMPERATURE),

    // VOLUME
    CUBIC_METER(UnitBase.CUBIC_METER, UnitFactor.ONE, UnitType.VOLUME),
    LITER(UnitBase.LITER, UnitFactor.ONE, UnitType.VOLUME),
    FLUID_OUNCE(UnitBase.FLUID_OUNCE, UnitFactor.ONE, UnitType.VOLUME),
    PINT(UnitBase.PINT, UnitFactor.ONE, UnitType.VOLUME),
    QUART(UnitBase.QUART, UnitFactor.ONE, UnitType.VOLUME),
    GALLON(UnitBase.GALLON, UnitFactor.ONE, UnitType.VOLUME);

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

    public static SimpleUnit[] valuesByUnitType(UnitType type) {
        if (type == null) {
            throw new IllegalArgumentException("Specify the type");
        }
        ArrayList<SimpleUnit> lengthUnits = new ArrayList<>();

        for (SimpleUnit unit : SimpleUnit.values()) {
            if (unit.getType() == type) {
                lengthUnits.add(unit);
            }
        }
        return lengthUnits.toArray(new SimpleUnit[lengthUnits.size()]);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str.replace('_', ' ');
    }
}
