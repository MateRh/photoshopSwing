package com.mdaszuta.algoritms;

public enum AlgorithmType {
    LINEAR_TRANSFORMATION("Transformacja liniowa"),
    POWER_TRANSFORMATION("Transformacja potęgowa"),
    CONTRAST_TYPE_A("Kontrast tryb a"),
    CONTRAST_TYPE_B("Kontrast tryb b"),
    ADAPTIVE_MODE(""),
    MULTIPLY_MODE(""),
    SCREEN_MODE(""),
    SUBTRACTIVE_MODE(""),
    DIFFERENCE_MODE("");

    String name;

    AlgorithmType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
