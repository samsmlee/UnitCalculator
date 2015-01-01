package com.samsmlee.unitcalculator.Unit;

import com.samsmlee.unitcalculator.Converter.LengthConverter;
import com.samsmlee.unitcalculator.Converter.MassConverter;
import com.samsmlee.unitcalculator.Converter.TemperatureConverter;
import com.samsmlee.unitcalculator.Converter.VolumeConverter;
import com.samsmlee.unitcalculator.Unit.UnitBase.UnitBase;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * Created by Sam on 12/22/2014.
 */
public class Unit{

    protected final UnitBase base;

    protected final UnitFactor factor;

    public Unit(UnitBase base, UnitFactor mUnitFactor) {
        this.base = base;
        this.factor = mUnitFactor;
    }
    public Unit(UnitBase base) {
        this.base = base;
        this.factor = UnitFactor.ONE;
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

    public boolean equalType(Unit unit) {
        if (unit.getType() == null)
            return false;
        return this.getType() == unit.getType();
    }

    public UnitBase getBase() {
        return base;
    }

    public UnitFactor getFactor() {
        return factor;
    }


    public static double convert(Unit fromUnit, Unit toUnit, double value) {

        if (fromUnit == null) {
            throw new IllegalArgumentException("Cannot convert from a null unit");
        }
        if (toUnit == null) {
            throw new IllegalArgumentException("Cannot convert to a null unit");
        }

        if (!toUnit.equalType(fromUnit))
            throw new IllegalArgumentException("Incompatible type");

        double convertedValue;
        switch (fromUnit.getType()) {

            case LENGTH:
                convertedValue = LengthConverter.convert(fromUnit, toUnit, value);
                break;
            case MASS:
                convertedValue = MassConverter.convert(fromUnit, toUnit, value);
                break;
            case TEMPERATURE:
                convertedValue = TemperatureConverter.convert(fromUnit, toUnit, value);
                break;
            case VOLUME:
                convertedValue = VolumeConverter.convert(fromUnit, toUnit, value);
                break;
            default:
                // This case should not happen unless UnitType enum has changed
                throw new UnsupportedOperationException("This enum value, " + fromUnit.getType() + ", is not supported");
        }

        convertedValue = UnitFactor.convert(fromUnit.getFactor(), toUnit.getFactor(), convertedValue);

        return convertedValue;
    }


}
