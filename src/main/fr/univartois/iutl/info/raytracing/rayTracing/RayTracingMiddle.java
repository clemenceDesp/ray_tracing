package fr.univartois.iutl.info.raytracing.rayTracing;

import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.awt.*;
import java.util.List;

public class RayTracingMiddle extends AbstractRayTracing {
    protected RayTracingMiddle(Scene scene) {
        super(scene);
    }

    @Override
    protected List<Color> getPixelsSample() {
        return null;
    }
}
