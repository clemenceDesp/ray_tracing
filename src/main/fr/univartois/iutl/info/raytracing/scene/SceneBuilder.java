package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.parser.Light;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;

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
     * Add a light to the scene
     * @param light the light to add
     */
    void addLight(Light light);

    /***
     * Add a figure to the scene
     * @param figures the figure to add
     */
    void addFigures(IFigure figures);

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
     * @param ambientLigth the ambient light to set
     */
    void setAmbient(Color ambientLigth);

    /***
     * Build the scene
     * @return the scene
     */
    Scene build();
}