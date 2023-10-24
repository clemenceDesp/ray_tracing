package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.parser.Light;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;

public class Scene {
    private final int height;
    private final int width;
    private final Light[] light;
    private final IFigure[] figures;
    private final Camera camera;
    private final Point[][] image;

    private final String output;

    public Scene(int height, int width, Light[] light, IFigure[] figures, Camera camera, String output) {
        this.height = height;
        this.width = width;
        this.light = light;
        this.figures = figures;
        this.camera = camera;
        this.output = output;
        this.image = new Point[width][height];
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

    public Point[][] getImage() {
        return image;
    }

    public String getOutput() {
        return output;
    }
}
