package fr.univartois.iutl.info.raytracing.raytracing;

import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.awt.image.BufferedImage;

public abstract class AbstractRayTracing implements IRayTracing {
    protected IRayTracing rayTracing;
    protected BufferedImage imageCopy;
    protected AbstractRayTracing(IRayTracing rayTracing) {
        this.rayTracing = rayTracing;
        imageCopy = new BufferedImage(getScene().getWidth(), getScene().getHeight(), BufferedImage.TYPE_INT_RGB);
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
