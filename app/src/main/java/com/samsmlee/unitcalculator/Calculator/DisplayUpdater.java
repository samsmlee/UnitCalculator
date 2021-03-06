package com.samsmlee.unitcalculator.Calculator;

import com.samsmlee.unitcalculator.Unit.Unit;
import com.samsmlee.unitcalculator.Number.Number;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Sam on 12/29/2014.
 */
public class DisplayUpdater {

    protected DisplayUpdateListener display;

    protected StringBuilder currDisplay;

    protected boolean hasDecimalPoint;

    protected boolean aboutToReset;

    protected final int maxlength;

    public static int MAX_PRECISION = 8;

    public DisplayUpdater(DisplayUpdateListener display) {
        if (display == null) {
            throw new IllegalArgumentException("DisplayUpdateListener is required");
        }
        this.display = display;
        currDisplay = new StringBuilder(" 0");
        hasDecimalPoint = false;
        aboutToReset = false;
        maxlength = display.maxLength();
    }

    public void enterNumber(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Specify a key");
        }

        switch (key) {
            case ZERO:
                // If " 0" is displaying, pressing zero does nothing
                if (currDisplay.toString().equals(" 0")) {
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

                // limit the length of currDisplay
                if (currDisplay.length() >= maxlength) {
                    return;
                }
                if (currDisplay.toString().equals(" 0")) {
                    currDisplay.replace(1, 1 + key.toString().length(), key.toString());
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
            // limit the length of currDisplay
            if (currDisplay.length() >= maxlength) {
                return;
            }
            currDisplay.append(Key.DOT);
            hasDecimalPoint = true;
            display.updateFromUnit(currDisplay.toString());
        }
    }

    public void negate() {

        if (aboutToReset) {
            aboutToReset = false;
        }
        // Don't negate if currDisplay is " 0"
        if (currDisplay.toString().equals(" 0")) {
            return;
        }

        if (currDisplay.charAt(0) == '-') {
            // if already negative, then turn to positive
            currDisplay.setCharAt(0, ' ');
        } else {
            // if positive, then turn to positive
            currDisplay.setCharAt(0, '-');
        }

        display.updateFromUnit(currDisplay.toString());

    }

    public void runConvert(Unit fromUnit, Unit toUnit) {
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Specify the units");
        }

        BigDecimal original = new BigDecimal(currDisplay.toString().trim()).stripTrailingZeros();
        Number fromNumber = new Number(fromUnit, original);
        Number toNumber = fromNumber.convert(toUnit);

        BigDecimal ans = toNumber.getValue();

        if (ans.compareTo(BigDecimal.ZERO) == 0) {
            ans = BigDecimal.ZERO;
        }

        String converted = getStringValue(ans);
        aboutToReset = true;

        display.updateFromUnit(currDisplay.toString());
        display.updateToUnit(converted);
    }

    // This method decides which format of String to use
    private String getStringValue(BigDecimal n) {

        if (n == null) {
            throw new NullPointerException("Cannot be null");
        }
        n = n.stripTrailingZeros();

        if (n.precision() > display.maxLength()) {

            n = new BigDecimal(n.unscaledValue(), n.scale(), new MathContext(MAX_PRECISION, RoundingMode.HALF_UP));
        }

        if (n.scale() < 0 && n.precision() + (-1 * n.scale()) <= MAX_PRECISION) {
            return n.toPlainString();
        }
        return String.valueOf(n);
    }

    public void clear() {
        reset();
        display.updateFromUnit(currDisplay.toString());
        display.updateToUnit("");
    }

    public void delete() {
        aboutToReset = false;

        // nothing more to delete, if " 0"
        if (currDisplay.toString().equals(" 0")) {
            return;
        }

        // if the char to delete is a dot, then set hasDecimalPoint to false
        if (currDisplay.charAt(currDisplay.length() - 1) == '.') {
            hasDecimalPoint = false;
        }
        if (currDisplay.length() == 2) {
            reset();
        } else if (currDisplay.toString().equals("-0.")) {
            reset();
        } else {
            currDisplay.deleteCharAt(currDisplay.length() - 1);
        }


        display.updateFromUnit(currDisplay.toString());

    }

    protected void reset() {
        currDisplay = new StringBuilder(" 0");
        hasDecimalPoint = false;
        aboutToReset = false;
    }
}
