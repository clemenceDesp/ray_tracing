package fr.univartois.iutl.info.raytracing.rayTracing;

import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.awt.*;
import java.util.List;

public class RayTracingRandom extends AbstractRayTracing{
    protected RayTracingRandom(Scene scene) {
        super(scene);
    }

    @Override
    protected List<Color> getPixelsSample() {
        return null;
    }
}
