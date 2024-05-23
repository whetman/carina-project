package com.solvd.gui.constants;

public enum Gender {
    MR("Mr."),
    MRS("Mrs.");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}