package fr.univartois.iutl.info.raytracing.raytracing;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RayTracingMiddle extends AbstractRayTracing {
    public RayTracingMiddle(Scene scene) {
        super(scene);
    }

    @Override
    protected List<Color> getPixelsSample(int i, int j, Scene scene, Vector d) {
        List<Double> tList = new ArrayList<>();
        for (IFigure figure : scene.getFigures()) {
            double tTemp = figure.findInteraction(scene.getCamera().getLookFrom(), d);
            if (tTemp >= 0) {
                tList.add(tTemp);
            }
        }
        double t = -1;
        if (!tList.isEmpty()) {
            t = tList.get(0);
            for (int k = 1; k < tList.size(); k++) {
                if (tList.get(k) < t) {
                    t = tList.get(k);
                }
            }
        }
        if (t>=0) {
            Color color = new Color((float)scene.getAmbientLigth().getTriplets().getPointA().getX(),(float)scene.getAmbientLigth().getTriplets().getPointA().getY(),(float)scene.getAmbientLigth().getTriplets().getPointA().getZ());
            return new ArrayList<>(List.of(color));
        }
        return Collections.emptyList();
    }

}
