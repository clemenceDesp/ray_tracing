package fr.univartois.iutl.info.raytracing.raytracing;

import fr.univartois.iutl.info.raytracing.scene.Scene;

public abstract class AbstractRayTracing implements IRayTracing {
    IRayTracing rayTracing;
    protected AbstractRayTracing(IRayTracing rayTracing) {
        this.rayTracing = rayTracing;
    }

    /***
     * Calculate pixels of the image
     */
    @Override
    public void calculateImage() {
        rayTracing.calculateImage();
    }

    /***
     * Get the scene
     * @return the scene
     */
    @Override
    public Scene getScene() {
        return rayTracing.getScene();
    }
}
