package fr.univartois.iutl.info.raytracing.raytracing;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AntiAliasingGrid extends AbstractRayTracing{
    private final BufferedImage image;

    public AntiAliasingGrid(IRayTracing rayTracing) {
        super(rayTracing);
        this.image = getScene().getImage();
        gridAntialiasingMethod();
        getScene().setImage(imageCopy);
    }

    private void gridAntialiasingMethod() {
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
        int numberSamplingDiv = numberSampling/2;
        int nb = 0;
        for (int i = -numberSamplingDiv; i < numberSamplingDiv; i++) {
            for (int j = -numberSamplingDiv; j < numberSamplingDiv; j++) {
                if (x + i < 0 || x + i >= image.getWidth() || y + j < 0 || y + j >= image.getHeight()) {
                    continue;
                }
                nb++;
                int color = image.getRGB(x + i, y + j);
                r += (color>>16)&0xFF;
                g += (color>>8)&0xFF;
                b += (color)&0xFF;
            }
        }
        if (numberSampling > 0 && nb != 0) {
            return new Color(r / nb, g / nb, b / nb);
        } else {
            return new Color(r, g, b);
        }
    }
}
