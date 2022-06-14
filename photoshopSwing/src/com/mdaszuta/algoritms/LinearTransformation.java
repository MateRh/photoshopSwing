package com.mdaszuta.algoritms;

import java.awt.*;

public class LinearTransformation implements Algorithm {

    @Override
    public Color process(Color color, AlgorithmParams params) {
        return new Color(processChanel(params.getA(), params.getB(), color.getRed()),
                processChanel(params.getA(), params.getB(), color.getGreen()),
                processChanel(params.getA(), params.getB(), color.getBlue()));
    }

    private float processChanel(float a, float b, int value) {
        final var floatValue = value / 255f;
        return Math.min(Math.max(a * floatValue + b, 0f), 1f);
    }
}
