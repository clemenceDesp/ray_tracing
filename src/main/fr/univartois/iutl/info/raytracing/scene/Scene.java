package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.light.Light;
import fr.univartois.iutl.info.raytracing.figure.IFigure;
import fr.univartois.iutl.info.raytracing.raytracing.AntiAliasingGrid;
import fr.univartois.iutl.info.raytracing.raytracing.AntiAliasingRandom;
import fr.univartois.iutl.info.raytracing.raytracing.IRayTracing;
import fr.univartois.iutl.info.raytracing.raytracing.RayTracing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Scene {

    /***
     * The height of the scene
     */
    private final int height;

    /***
     * The width of the scene
     */
    private final int width;

    /***
     * The list of lights of the scene
     */
    private final Light[] lights;

    /***
     * The list of figures of the scene
     */
    private final IFigure[] figures;

    /***
     * The camera of the scene
     */
    private final Camera camera;

    /***
     * The image of the scene
     */
    private BufferedImage image;

    /***
     * The output of the scene
     */
    private final String output;

    /***
     * The ambient light of the scene
     */
    private final Color ambientLight;

    private String sampling;

    private int numberSampling;

    /***
     * Create a new scene
     * @param height the height of the scene
     * @param width the width of the scene
     * @param lights the list of lights of the scene
     * @param figures the list of figures of the scene
     * @param camera the camera of the scene
     * @param output the output of the scene
     * @param ambientLight the ambient light of the scene
     */
    public Scene(int height, int width, Light[] lights, IFigure[] figures, Camera camera, String output, Color ambientLight, String sampling, int numberSampling) {
        this.height = height;
        this.width = width;
        this.lights = lights;
        this.figures = figures;
        this.camera = camera;
        this.output = output;
        this.ambientLight = ambientLight;
        this.sampling = sampling;
        this.numberSampling = numberSampling;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
     * Gives the list of all lights in this scene.
     *
     * @return array of all lights in this scene.
     */
    public Light[] getLights() {
        return lights;
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

    /***
     * Gives the image of this scene
     * @return the image of this scene
     */
    public BufferedImage getImage() {
        return image;
    }

    /***
     * Set the image of this scene
     * @param image the image of this scene
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /***
     * Gives the output of this scene
     * @return the output of this scene
     */
    public String getOutput() {
        return output;
    }

    /***
     * Gives the ambient light of this scene
     * @return the ambient light of this scene
     */
    public Color getAmbientLight() {
        return ambientLight;
    }
    public void saveImage() {
        IRayTracing rayTracing = new RayTracing(this);
        if (sampling.equals("grid"))
            new AntiAliasingGrid(rayTracing);
        else if (sampling.equals("random"))
            new AntiAliasingRandom(rayTracing);
        save();
    }

    private void save() {
        try {
            File outputfile = new File(output);
            ImageIO.write(image, "png", outputfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getSampling() {
        return sampling;
    }

    public int getNumberSampling() {
        return numberSampling;
    }
}
