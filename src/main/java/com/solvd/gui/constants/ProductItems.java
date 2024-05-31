package com.solvd.gui.constants;

public enum ProductItems {

    SHIRT("shirt"),
    SKIRT("skirt"),
    DRESS("dress"),
    BOOK("book");

    private final String value;

    ProductItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
