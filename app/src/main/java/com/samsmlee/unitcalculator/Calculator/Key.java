package com.samsmlee.unitcalculator.Calculator;

import android.content.Context;
import android.content.res.Resources;

import com.samsmlee.unitcalculator.R;

/**
 * Created by Sam on 1/1/2015.
 */
public enum Key {
    ZERO ("0"),
    ONE ("1"),
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    DOT ("."),
    EQUAL ("=");

    protected String display;
    Key(String display) {
        this.display = display;
    }


    @Override
    public String toString() {
        return display;
    }

    public static Key toKey(Context context, String value) {
        if (context == null) {
            throw new IllegalArgumentException("context is required");
        }
        if (value == null) {
            throw new IllegalArgumentException("Cannot convert from NULL");
        }

        Key[] keys = Key.values();
        for (Key key : keys) {
            if (value.equals(key.toString())) {
                return key;
            }
        }
        throw new IllegalArgumentException("Invalid Key");

    }

}
