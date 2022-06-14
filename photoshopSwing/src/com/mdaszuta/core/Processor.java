package com.mdaszuta.core;

import com.mdaszuta.algoritms.Algorithm;
import com.mdaszuta.algoritms.AlgorithmParams;
import com.mdaszuta.algoritms.AlgorithmProvider;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Processor {

    public void process(BufferedImage image, BufferedImage secondImage, AlgorithmParams params) {
        Algorithm algorithm = AlgorithmProvider.getAlgorithm(params.getType());
        if (algorithm.useSecondImage()) {
            final var maxWidth = Math.max(image.getWidth(), secondImage.getWidth());
            final var maxHeight = Math.max(image.getHeight(), secondImage.getHeight());
            final var mixedImage = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_RGB);
            IntStream.range(0, maxWidth)
                    .parallel()
                    .forEach(x -> {
                        for (int y = 0; y < maxHeight - 1; y++) {
                            final var color = algorithm.process(getColor(image, x, y), getColor(secondImage, x, y), params);
                            mixedImage.setRGB(x, y, color.getRGB());
                        }
                    });
            image.setData(mixedImage.getData());
        } else {
            IntStream.range(0, image.getWidth())
                    .parallel()
                    .forEach(x -> {
                        for (int y = 0; y < image.getHeight() - 1; y++) {
                            final var color = algorithm.process(new Color(image.getRGB(x, y)), params);
                            image.setRGB(x, y, color.getRGB());
                        }
                    });
        }
    }

    private Color getColor(BufferedImage image, int x, int y) {
        if (x >= image.getWidth() || y >= image.getHeight()) {
            return Color.BLACK;
        }
        return new Color(image.getRGB(x, y));
    }

}
