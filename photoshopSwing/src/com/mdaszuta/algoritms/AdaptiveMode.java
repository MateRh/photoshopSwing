package com.mdaszuta.algoritms;

import java.awt.*;

public class AdaptiveMode implements Algorithm {

    @Override
    public Color process(Color color, Color secondColor, AlgorithmParams params) {
        return new Color(processChanel(color.getRed(), secondColor.getRed()),
                processChanel(color.getGreen(), secondColor.getGreen()),
                processChanel(color.getBlue(), secondColor.getBlue()));
    }

    private float processChanel(int value, int secondValue) {
        final var floatValue = value / 255f;
        final var secondFloatValue = secondValue / 255f;
        return Math.min(Math.max(floatValue + secondFloatValue, 0f), 1f);
    }

    @Override
    public boolean useSecondImage() {
        return true;
    }
}
