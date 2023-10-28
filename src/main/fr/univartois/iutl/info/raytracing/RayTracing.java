package fr.univartois.iutl.info.raytracing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.BaseColor;
import fr.univartois.iutl.info.raytracing.parser.Calculator;
import fr.univartois.iutl.info.raytracing.parser.LambertDecorator;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;


public class RayTracing{
    private final Scene scene;
    private final double realheight;
    private final double realwidth;
    private final double pixelheight;
    private final double pixelwidth;
    private final Vector w;
    private final Vector u;
    private final Vector v;

    private IFigure stockFigure = null;

    public RayTracing(Scene scene) {
        this.scene = scene;

        Vector v1 = scene.getCamera().getLookFrom().substraction(scene.getCamera().getLookAt());
        this.w = v1.normalization();
        Vector v2 = scene.getCamera().getUp().vectorProduct(w);
        this.u = v2.normalization();
        Vector v3 = w.vectorProduct(u);
        this.v = v3.normalization();

        double fovr = (scene.getCamera().getFov() * Math.PI) / 180;
        this.realheight = 2 * Math.tan(fovr / 2);
        this.pixelheight = realheight / scene.getHeight();
        this.realwidth = scene.getWidth() * pixelheight;
        this.pixelwidth = realwidth / scene.getWidth();

        calculateImage();
    }

    /***
     * Calculate pixels of the image
     */
    public void calculateImage() {
        for (int i = 0; i < scene.getHeight(); i++) {
            for (int j = 0; j < scene.getWidth(); j++) {
                double a = -(realwidth / 2) + (j + 0.5) * pixelwidth;
                double b = (realheight / 2) - (i + 0.5) * pixelheight;
                Vector v4 = (u.multiplication(a)).addition(v.multiplication(b)).substraction(w);
                Vector d = v4.normalization();

                double t = getMinT(d);

                if (t >= 0) {
                    if (stockFigure != null && stockFigure.getDiffuse() != null) {
                        Calculator calcul = new LambertDecorator(new BaseColor());
                        fr.univartois.iutl.info.raytracing.numeric.Color color1 = calcul.calculatorColor(scene, t, d, stockFigure, stockFigure.getDiffuse());
                        Color color = new Color((float)color1.getTriplets().getPointA().getX(),(float)color1.getTriplets().getPointA().getY(),(float)color1.getTriplets().getPointA().getZ());
                        scene.getImage().setRGB(j,i,color.getRGB());
                        stockFigure = null;
                    }
                } else {
                    Color color = new Color(0, 0, 0);
                    scene.getImage().setRGB(j, i, color.getRGB());
                }
            }
        }
		try {
			// Retrieve image
			BufferedImage image = scene.getImage();
			File outputfile = new File(scene.getOutput());
			ImageIO.write(image, "png", outputfile);
		}
			
		catch (IOException e) {
			e.printStackTrace();
		}
    }

    private double getMinT(Vector d) {
        double t = -1;
        for (IFigure figure : scene.getFigures()) {
            double tTemp = figure.findInteraction(scene.getCamera().getLookFrom(), d);
            if ((t == -1 && tTemp >= 0) || (tTemp >= 0 && tTemp < t)) {
                stockFigure = figure;
                t = tTemp;
            }
        }
        return t;
    }
}
