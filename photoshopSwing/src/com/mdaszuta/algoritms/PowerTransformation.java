package com.mdaszuta.algoritms;

import java.awt.*;

public class PowerTransformation implements Algorithm {

    @Override
    public Color process(Color color, AlgorithmParams params) {
        return new Color(processChanel(params.getA(), params.getB(), color.getRed()),
                processChanel(params.getA(), params.getB(), color.getGreen()),
                processChanel(params.getA(), params.getB(), color.getBlue()));
    }

    private float processChanel(float c, float n, int value) {
        final var floatValue = value / 255d;
        final var result = Double.valueOf(Math.pow(c * floatValue, n));
        return Math.min(Math.max(result.floatValue(), 0f), 1f);
    }
}
