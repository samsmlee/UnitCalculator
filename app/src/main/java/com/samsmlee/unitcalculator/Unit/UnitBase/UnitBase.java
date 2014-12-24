package com.samsmlee.unitcalculator.Unit.UnitBase;

import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

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



    // TEMPERATURE
    CELSIUS (UnitType.TEMPERATURE),
    FARHENHEIT (UnitType.TEMPERATURE),
    KELVIN (UnitType.TEMPERATURE),

    // VOLUME
    CUBIC_METER (UnitType.VOLUME),
    FLUID_OUNCE (UnitType.VOLUME),


    // WEIGHT
    OUNCE (UnitType.WEIGHT),
    POUND (UnitType.WEIGHT),
    GRAM (UnitType.WEIGHT);

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
}
