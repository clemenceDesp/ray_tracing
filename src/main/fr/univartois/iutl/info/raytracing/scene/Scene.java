package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.parser.Light;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;

public class Scene {
    private final int height;
    private final int width;
    private final Light[] light;
    private final IFigure[] figures;
    private final Camera camera;

    public Scene(int height, int width, Light[] light, IFigure[] figures, Camera camera) {
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
    public int getHeight() {
        return height;
    }

    /**
     * Gives the width of this scene, in pixels.
     *
     * @return width of this scene, in pixels.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gives the list of all light in this scene.
     *
     * @return array of all light in this scene.
     */
    public Light[] getLight() {
        return light;
    }

    /**
     * Gives the list of all figures in this scene.
     *
     * @return array of all figures in this scene.
     */
    public IFigure[] getFigures() {
        return figures;
    }

    /**
     * Gives the camera of this scene.
     *
     * @return camera of this scene.
     */
    public Camera getCamera() {
        return camera;
    }
}
