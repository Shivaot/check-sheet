package com.ultrasonic.checksheet.enums;

/**
 * Shiva Created on 19/03/22
 */
public enum OkNotOk {
    OK("OK"), NOT_OK("NOT_OK");

    private final String displayValue;

    OkNotOk(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
