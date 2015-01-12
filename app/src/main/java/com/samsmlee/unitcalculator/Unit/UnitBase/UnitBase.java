package com.samsmlee.unitcalculator.Unit.UnitBase;

import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

import java.util.ArrayList;

/**
 * Created by Sam on 12/24/2014.
 */


public enum UnitBase {


    // LENGTH
    METER (UnitType.LENGTH),
    INCH (UnitType.LENGTH),
    FOOT (UnitType.LENGTH),
    YARD (UnitType.LENGTH),
    MILE (UnitType.LENGTH),

    // MASS
    OUNCE (UnitType.MASS),
    POUND (UnitType.MASS),
    GRAM (UnitType.MASS),
    METRIC_TON (UnitType.MASS),
    SHORT_TON (UnitType.MASS),

    // TEMPERATURE
    CELSIUS (UnitType.TEMPERATURE),
    FAHRENHEIT(UnitType.TEMPERATURE),
    KELVIN (UnitType.TEMPERATURE),

    // VOLUME
    CUBIC_METER (UnitType.VOLUME),
    LITER(UnitType.VOLUME),
    FLUID_OUNCE (UnitType.VOLUME),
    PINT (UnitType.VOLUME),
    QUART (UnitType.VOLUME),
    GALLON (UnitType.VOLUME);

    // Indicates what type of unit this UnitBaseEnum is
    private final UnitType mType;

    UnitBase(UnitType type) throws IllegalArgumentException {
        if (type == null)
            throw new IllegalArgumentException("Type cannot be null");
        mType = type;
    }


    public boolean isType(UnitType type) {

        if (type == null)
            return false;

        return (mType == type);
    }

    public UnitType getType() {
        return mType;
    }

    public UnitBase[] getAllUnitsByType(UnitType type) {
        ArrayList<UnitBase> lengthUnits = new ArrayList<>();

        for (UnitBase u : UnitBase.class.getEnumConstants()) {

            if (u.isType(type)) {
                lengthUnits.add(u);
            }

        }

        return (UnitBase[])lengthUnits.toArray();
    }
}
