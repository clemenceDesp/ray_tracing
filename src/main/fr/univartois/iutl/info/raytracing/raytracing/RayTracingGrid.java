package fr.univartois.iutl.info.raytracing.raytracing;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.awt.*;
import java.util.List;

public class RayTracingGrid extends AbstractRayTracing{
    public RayTracingGrid(Scene scene) {
        super(scene);
    }

    @Override
    protected List<Color> getPixelsSample(int i, int j, Scene scene, Vector d) {
        return null;
    }
}
