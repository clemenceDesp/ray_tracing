package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Coordinates;
import fr.univartois.iutl.info.raytracing.numeric.Triplets;
import fr.univartois.iutl.info.raytracing.parser.Light;
import fr.univartois.iutl.info.raytracing.figure.IFigure;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSceneBuilder implements SceneBuilder {

    /***
     * The height of the scene
     */
    private int height;

    /***
     * The width of the scene
     */
    private int width;

    /***
     * The list of light of the scene
     */
    private final List<Light> light;

    /***
     * The list of figures of the scene
     */
    private final List<IFigure> figures;

    /***
     * The camera of the scene
     */
    private Camera camera;

    /***
     * The output of the scene
     */
    private String output;

    /***
     * The ambient light of the scene
     */
    private Color ambientLight;

    /***
     * The sampling of the scene
     */
    private String sampling;

    /***
     * The number of samples or the size of one side of the grid.
     */
    private int numberSampling;

    /***
     * Create a new scene builder
     */
    public ConcreteSceneBuilder() {
        this.light = new ArrayList<>();
        this.figures = new ArrayList<>();
        this.camera = null;
        this.height = 0;
        this.width = 0;
        this.output = "output.png";
        this.ambientLight = new Color(new Triplets(new Coordinates(0, 0, 0)));
        this.sampling = "middle";
        this.numberSampling = 1;
    }

    /***
     * Set the height of the scene
     * @param height the height of the scene
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Set the width of the scene
     * @param width the width of the scene
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /***
     * Add a light to the scene
     * @param light the light to add
     */
    @Override
    public void addLight(Light light) {
        this.light.add(light);
    }

    /***
     * Add a figure to the scene
     * @param figures the figure to add
     */
    @Override
    public void addFigures(IFigure figures) {
        this.figures.add(figures);
    }

    /***
     * Set the camera of the scene
     * @param camera the camera to set
     */
    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /***
     * Set the output of the scene
     * @param output the output to set
     */
    @Override
    public void setOutput(String output) {
        this.output = output;
    }

    /***
     * Set the ambient light of the scene
     * @param ambientLight the ambient light to set
     */
    @Override
    public void setAmbient(Color ambientLight) {
        this.ambientLight = ambientLight;
    }

    /**
     * Changes the sampling.
     *
     * @param sampling The new sampling.
     * @param numberSampling The number of samples or the size of one side of the grid.
     */
    @Override
    public void setSampling(String sampling, int numberSampling) {
        this.sampling = sampling;
        this.numberSampling = numberSampling;
    }

    /***
     * Build the scene
     * @return the scene
     */
    @Override
    public Scene build() {
        return new Scene(height, width, light.toArray(new Light[0]), figures.toArray(new IFigure[0]), camera, output, ambientLight, sampling, numberSampling);
    }
}
