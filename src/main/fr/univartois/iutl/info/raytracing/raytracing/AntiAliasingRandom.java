package fr.univartois.iutl.info.raytracing.raytracing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AntiAliasingRandom extends AbstractRayTracing{
    private final BufferedImage image;
    private static final Random rand = new Random();

    public AntiAliasingRandom(IRayTracing rayTracing) {
        super(rayTracing);
        this.image = getScene().getImage();
        randomAntialiasingMethod();
        getScene().setImage(imageCopy);
    }

    private void randomAntialiasingMethod() {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                imageCopy.setRGB(x, y, getSmoothPixel(x, y).getRGB());
            }
        }
    }

    private Color getSmoothPixel(int x, int y) {
        int r = 0;
        int g = 0;
        int b = 0;
        int numberSampling = getScene().getNumberSampling();

        for (int nb = 0; nb < numberSampling; nb++) {
            int i = rand.nextInt(-2, 2);
            int j = rand.nextInt(-2, 2);
            if (x + i < 0 || x + i >= image.getWidth() || y + j < 0 || y + j >= image.getHeight()) {
                continue;
            }
            int color = image.getRGB(x + i, y + j);
            r += (color >> 16) & 0xFF;
            g += (color >> 8) & 0xFF;
            b += (color) & 0xFF;
        }
        return new Color(r / numberSampling, g / numberSampling, b / numberSampling);
    }
}
