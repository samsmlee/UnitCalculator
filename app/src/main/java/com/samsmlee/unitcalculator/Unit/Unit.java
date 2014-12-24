package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * Created by Sam on 12/22/2014.
 */
public class Unit{

    protected UnitBase base;
    protected UnitFactor factor;

    public Unit(UnitBase base, UnitFactor mUnitFactor) {
        this.base = base;
        this.factor = mUnitFactor;
    }

    public UnitType getType()
    {
        return base.getType();
    }

    public boolean isType(UnitType type) {
        if (type == null)
            return false;
        return this.getType() == type;
    }


}
