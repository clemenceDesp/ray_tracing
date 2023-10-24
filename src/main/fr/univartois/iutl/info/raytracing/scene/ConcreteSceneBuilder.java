package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.parser.Light;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSceneBuilder implements SceneBuilder {
    private int height;
    private int width;
    private final List<Light> light;
    private final List<IFigure> figures;
    private Camera camera;
    private String output;

    public ConcreteSceneBuilder() {
        this.light = new ArrayList<>();
        this.figures = new ArrayList<>();
        this.camera = null;
        this.height = 0;
        this.width = 0;
        this.output = "output.png";
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void addLight(Light light) {
        this.light.add(light);
    }

    @Override
    public void addFigures(IFigure figures) {
        this.figures.add(figures);
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public Scene build() {
        return new Scene(height, width, light.toArray(new Light[0]), figures.toArray(new IFigure[0]), camera, output);
    }
}
