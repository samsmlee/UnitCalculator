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

    public void enterNumber(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Specify a key");
        }

        switch (key) {
            case ZERO:
                // If "0" is displaying, pressing zero does nothing
                if (currDisplay.toString().equals("0")) {
                    return;
                }
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
                if (currDisplay.toString().equals("0")) {
                    currDisplay.replace(0, key.toString().length(), key.toString());
                } else {
                    currDisplay.append(key);
                }
                display.updateFromUnit(currDisplay.toString());
                break;
            default:
                throw new IllegalArgumentException("Enter a number key");
        }

    }

    public void enterDot() {
        if (!hasDecimalPoint || aboutToReset) {
            if (aboutToReset)
                reset();
            currDisplay.append(Key.DOT);
            hasDecimalPoint = true;
            display.updateFromUnit(currDisplay.toString());
        }
    }

    public void negate() {

        if (aboutToReset) {
            aboutToReset = false;
        }
        // Don't negate if currDisplay is "0"
        if (currDisplay.toString().equals("0")) {
            return;
        }

        if (currDisplay.charAt(0) == '-') {
            // if already negative, then turn to positive
            currDisplay.deleteCharAt(0);
        } else {
            // if positive, then turn to positive
            currDisplay.insert(0, '-');
        }

        display.updateFromUnit(currDisplay.toString());

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

    public void clear() {
        reset();
        display.updateFromUnit(currDisplay.toString());
        display.updateToUnit("");
    }

    public void delete() {
        aboutToReset = false;

        // nothing more to delete, if "0"
        if (currDisplay.toString().equals("0")) {
            return;
        }

        // if the char to delete is a dot, then set hasDecimalPoint to false
        if (currDisplay.charAt(currDisplay.length() - 1) == '.') {
            hasDecimalPoint = false;
        }
        if (currDisplay.length() == 1) {
            reset();
        } else if (currDisplay.toString().equals("-0.")) {
            reset();
        } else if (currDisplay.charAt(0) == '-') {
            if (currDisplay.length() == 2) {
                reset();
            } else {
                currDisplay.deleteCharAt(currDisplay.length() - 1);
            }
        } else {
            currDisplay.deleteCharAt(currDisplay.length() - 1);
        }


        display.updateFromUnit(currDisplay.toString());

    }

    protected void reset() {
        currDisplay = new StringBuilder("0");
        hasDecimalPoint = false;
        aboutToReset = false;
    }
}
