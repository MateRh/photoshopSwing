package com.mdaszuta.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagesPanel {

    private final JPanel panel = new JPanel();
    private final Dimension imagePanelDimension = new Dimension(640, 360);
    private final BufferedImageCanvas originalImage = createBufferedImageCanvas();
    private final BufferedImageCanvas resultImage = createBufferedImageCanvas();
    private final BufferedImageCanvas additionalResultImage = createBufferedImageCanvas();

    public void setOriginalImage(BufferedImage image) {
        originalImage.setImage(image);
        originalImage.repaint();
        panel.updateUI();
        panel.repaint();
    }

    public void setResultImage(BufferedImage image) {
        resultImage.setImage(image);
        resultImage.repaint();
        panel.updateUI();
        panel.repaint();
    }

    public void setAdditionalResultImage(BufferedImage image) {
        additionalResultImage.setImage(image);
        additionalResultImage.repaint();
        panel.updateUI();
        panel.repaint();
    }

    public JPanel create() {
        panel.setLayout(new GridBagLayout());
        final var constraints = new GridBagConstraints();
        setConstraints(constraints, 0, 0, GridBagConstraints.VERTICAL);
        panel.add(originalImage);
        setConstraints(constraints, 0, 1, GridBagConstraints.VERTICAL);
        panel.add(resultImage);
        setConstraints(constraints, 1, 1, GridBagConstraints.HORIZONTAL);
        panel.add(additionalResultImage);
        panel.updateUI();

        return panel;
    }

    private void setConstraints(GridBagConstraints constraints, int x, int y, int fill) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.fill = fill;
    }

    private BufferedImageCanvas createBufferedImageCanvas() {
        final var canvas = new BufferedImageCanvas();
        canvas.setPreferredSize(imagePanelDimension);
        return canvas;
    }
}
