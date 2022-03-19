package com.ultrasonic.checksheet.enums;

/**
 * Shiva Created on 19/03/22
 */
public enum IE {
    I("I"), E("E");

    private final String displayValue;

    IE(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
