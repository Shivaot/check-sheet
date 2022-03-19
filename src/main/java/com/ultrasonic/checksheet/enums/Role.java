package com.ultrasonic.checksheet.enums;

/**
 * Shiva Created on 09/03/22
 */
public enum Role {

    ROLE_ADMIN("Admin"), ROLE_OPERATOR("Operator");

    private final String displayValue;

    Role(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
