package fr.univartois.iutl.info.raytracing.raytracing;

import fr.univartois.iutl.info.raytracing.scene.Scene;

/***
 * Interface for ray tracing
 * this interface is used to calculate the pixels of the image
 */
public interface IRayTracing {

    /***
     * Calculate pixels of the image
     */
    void calculateImage();

    /***
     * Get the scene
     * @return the scene
     */
    Scene getScene();
}
