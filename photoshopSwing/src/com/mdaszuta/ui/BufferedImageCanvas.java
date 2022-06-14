package com.mdaszuta.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedImageCanvas extends Canvas {

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    private BufferedImage image;

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
