package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.light.Light;
import fr.univartois.iutl.info.raytracing.figure.IFigure;

public interface SceneBuilder {
    /***
     * Set the height of the scene
     * @param height the height of the scene
     */
    void setHeight(int height);

    /***
     * Set the width of the scene
     * @param width the width of the scene
     */
    void setWidth(int width);

    /***
     * Adds a light to the scene
     * @param light the light to add
     */
    void addLight(Light light);

    /***
     * Adds a figure to the scene
     * @param figure the figure to add
     */
    void addFigure(IFigure figure);

    /***
     * Set the camera of the scene
     * @param camera the camera to set
     */
    void setCamera(Camera camera);

    /***
     * Set the output of the scene
     * @param output the output to set
     */
    void setOutput(String output);

    /***
     * Set the ambient light of the scene
     * @param ambientLight the ambient light to set
     */
    void setAmbient(Color ambientLight);

    /**
     * Changes the sampling.
     * @param sampling The new sampling.
     * @param numberSampling The number of samples or the size of one side of the grid.
     */
    void setSampling(String sampling, int numberSampling);

    /***
     * Build the scene
     * @return the scene
     */
    Scene build();
}
