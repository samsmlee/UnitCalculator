package com.samsmlee.unitcalculator.Calculator;

/**
 * Created by Sam on 12/29/2014.
 */
public interface DisplayUpdateListener {
    void updateFromUnit(String toDisplay);

    void updateToUnit(String toDisplay);

    // This method does not belong in this "Listener" interface,
    //  but it's a simpler/cleaner solution than passing a context in since
    //  the listener probably has a reference to a context.
    int maxLength();
}
