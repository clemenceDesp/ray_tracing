package fr.univartois.iutl.info.raytracing.raytracing;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.awt.*;
import java.util.List;

public abstract class AbstractRayTracing {
    protected AbstractRayTracing(Scene scene) {
        Vector v1 = scene.getCamera().getLookFrom().substraction(scene.getCamera().getLookAt());
        Vector w = v1.normalization();
        Vector v2 = scene.getCamera().getUp().vectorProduct(w);
        Vector u = v2.normalization();
        Vector v3 = w.vectorProduct(u);
        Vector v = v3.normalization();

        double fovr = (scene.getCamera().getFov()*Math.PI)/180;
        double realheight = 2*Math.tan(fovr/2);
        double pixelheight = realheight/scene.getHeight();
        double realwidth = scene.getWidth()*pixelheight;
        double pixelwidth = realwidth/scene.getWidth();

        for (int i=0;i<scene.getHeight();i++) {
            for (int j=0;j<scene.getWidth();j++) {
                double a = -(realwidth/2)+(j+0.5)*pixelwidth;
                double b = (realheight/2)-(i+0.5)*pixelheight;
                Vector v4 = (u.multiplication(a)).addition(v.multiplication(b)).substraction(w);
                Vector d = v4.normalization();

                Color color = new Color(0,0,0);
                List<Color> listColor = getPixelsSample(i, j, scene, d);
                for (Color colorl : listColor) {
                    color = new Color(color.getRed() + colorl.getRed(), color.getGreen() + colorl.getGreen(), color.getBlue() + colorl.getBlue());
                }
                if (!listColor.isEmpty()) {
                    color = new Color(color.getRed()/listColor.size(), color.getGreen()/listColor.size(), color.getBlue()/listColor.size());
                }
                scene.getImage().setRGB(j,i,color.getRGB());
            }
        }
    }

    protected abstract List<Color> getPixelsSample(int i ,int j, Scene scene, Vector d);
}
