package com.mdaszuta.algoritms;

public class AlgorithmProvider {

    public static Algorithm getAlgorithm(AlgorithmType type) {
        Algorithm algorithm;
        switch (type) {
            case LINEAR_TRANSFORMATION -> algorithm = new LinearTransformation();
            case POWER_TRANSFORMATION -> algorithm = new PowerTransformation();
            case CONTRAST_TYPE_A -> algorithm = new ContrastTypeA();
            case CONTRAST_TYPE_B -> algorithm = new ContrastTypeB();
            case SCREEN_MODE -> algorithm = new ScreenMode();
            case ADAPTIVE_MODE -> algorithm = new AdaptiveMode();
            case MULTIPLY_MODE -> algorithm = new MultiplyMode();
            case SUBTRACTIVE_MODE -> algorithm = new SubtractiveMode();
            case DIFFERENCE_MODE -> algorithm = new DifferenceMode();
            default -> algorithm = new DefaultAlgorithm();
        }
        return algorithm;
    }
}
