package fr.univartois.iutl.info.raytracing.scene;

import java.util.List;

public class Scene {
    private int height;
    private int width;
    private Light[] light;
    private Figure[] figures;
    private Camera camera;

    public Scene(int height, int width, Light[] light, Figure[] figures, Camera camera) {
        this.height = height;
        this.width = width;
        this.light = light;
        this.figures = figures;
        this.camera = camera;
    }

    /**
     * Gives the height of this scene, in pixels.
     *
     * @return height of this scene, in pixels.
     */
    @Override
    public int getHeight() {
        return 0;
    }

    /**
     * Gives the width of this scene, in pixels.
     *
     * @return width of this scene, in pixels.
     */
    @Override
    public int getWidth() {
        return 0;
    }

    /**
     * Gives the list of all light in this scene.
     *
     * @return list of all light in this scene.
     */
    @Override
    public Light[] getLight() {
        return null;
    }

    /**
     * Gives the list of all figures in this scene.
     *
     * @return list of all figures in this scene.
     */
    @Override
    public Figure[] getFigures() {
        return null;
    }

    /**
     * Gives the camera of this scene.
     *
     * @return camera of this scene.
     */
    @Override
    public Camera getCamera() {
        return null;
    }
}
