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

    public void enterKey(char key_char) {

        // The display is still showing "0" (the default number)
        if (currDisplay.length() == 1 && currDisplay.charAt(0) == '0') {
            switch (key_char) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (aboutToReset)
                        reset();
                    currDisplay.setCharAt(0, key_char);
                    display.updateFromUnit(currDisplay.toString());
                    break;
                case '.':
                    if (aboutToReset)
                        reset();
                    currDisplay.append(key_char);
                    hasDecimalPoint = true;
                    display.updateFromUnit(currDisplay.toString());
                    break;
            }
        } else {
            switch (key_char) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (aboutToReset) {
                        reset();
                        currDisplay.setCharAt(0, key_char);
                    } else {
                        currDisplay.append(key_char);
                    }
                    display.updateFromUnit(currDisplay.toString());
                    break;
                case '.':
                    if (!hasDecimalPoint || aboutToReset) {

                        if (aboutToReset)
                            reset();
                        currDisplay.append(key_char);
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
