package com.mdaszuta.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public BufferedImage readImage(String path) {
        final var file =  new File(path);
        try {
            System.out.println(path);
            return ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytywania pliku: " + e);
        }
        return null;
    }
}
