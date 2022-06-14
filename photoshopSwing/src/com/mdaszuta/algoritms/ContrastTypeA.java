package com.mdaszuta.algoritms;

import java.awt.*;

public class ContrastTypeA implements Algorithm {
    @Override
    public Color process(Color color, AlgorithmParams params) {
        try {
            return new Color(processChanel(params.getA(), params.getB(), color.getRed()),
                    processChanel(params.getA(), params.getB(), color.getGreen()),
                    processChanel(params.getA(), params.getB(), color.getBlue()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Color.BLACK;
    }

    private float processChanel(float a, float b, int value) {
        final var floatValue = value / 255f;
        float c = a - 0.5f;
        float rValue;
        if (c >= 0) {
            rValue =  (0.5f / (0.5f - c)) * (floatValue - c);
        } else {
            rValue = ((0.5f + c) / 0.5f) * (floatValue - c);
        }
        return Math.min(Math.max(rValue, 0f), 1f);
    }
}
