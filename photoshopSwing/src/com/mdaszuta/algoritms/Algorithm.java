package com.mdaszuta.algoritms;

import java.awt.*;

public interface Algorithm {

    default Color process(Color color, AlgorithmParams params) {
        return Color.BLACK;
    }

    default Color process(Color color, Color secondColor, AlgorithmParams params) {
        return Color.BLACK;
    }

    default boolean useSecondImage() {
        return false;
    }

}
