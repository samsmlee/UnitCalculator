package com.samsmlee.unitcalculator.Calculator;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Number.Number;

/**
 * Created by Sam on 12/29/2014.
 */
public class DisplayUpdater {

    protected DisplayUpdateListener display;

    protected StringBuilder currDisplay;

    protected boolean hasDecimalPoint;

    protected boolean aboutToReset;

    public DisplayUpdater(DisplayUpdateListener display) {
        if (display == null) {
            throw new IllegalArgumentException("DisplayUpdateListener is required");
        }
        this.display = display;
        currDisplay = new StringBuilder("0");
        hasDecimalPoint = false;
        aboutToReset = false;
    }

    public void enterKey(Key key) {

        // The display is still showing "0" (the default number)
        if (currDisplay.length() == 1 && currDisplay.charAt(0) == '0') {
            switch (key) {
                case ONE:
                case TWO:
                case THREE:
                case FOUR:
                case FIVE:
                case SIX:
                case SEVEN:
                case EIGHT:
                case NINE:
                    if (aboutToReset)
                        reset();
                    currDisplay.replace(0, key.toString().length(), key.toString());
                    display.updateFromUnit(currDisplay.toString());
                    break;
                case DOT:
                    if (aboutToReset)
                        reset();
                    currDisplay.append(key);
                    hasDecimalPoint = true;
                    display.updateFromUnit(currDisplay.toString());
                    break;
            }
        } else {
            switch (key) {
                case ZERO:
                case ONE:
                case TWO:
                case THREE:
                case FOUR:
                case FIVE:
                case SIX:
                case SEVEN:
                case EIGHT:
                case NINE:
                    if (aboutToReset) {
                        reset();
                        currDisplay.replace(0, key.toString().length(), key.toString());
                    } else {
                        currDisplay.append(key);
                    }
                    display.updateFromUnit(currDisplay.toString());
                    break;
                case DOT:
                    if (!hasDecimalPoint || aboutToReset) {

                        if (aboutToReset)
                            reset();
                        currDisplay.append(key);
                        hasDecimalPoint = true;
                        display.updateFromUnit(currDisplay.toString());
                    }
                    break;
            }
        }

    }

    public void runConvert(Unit fromUnit, Unit toUnit) {
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Specify the units");
        }

        Double currNumber = Double.parseDouble(currDisplay.toString());

        Number fromNumber = new Number(fromUnit, currNumber);
        Number toNumber = fromNumber.convert(toUnit);
        String converted = String.valueOf(toNumber.getValue());
        aboutToReset = true;

        display.updateToUnit(converted);
    }

    protected void reset() {
        currDisplay = new StringBuilder("0");
        hasDecimalPoint = false;
        aboutToReset = false;
    }

}
