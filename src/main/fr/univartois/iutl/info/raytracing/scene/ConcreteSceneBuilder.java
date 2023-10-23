package fr.univartois.iutl.info.raytracing.scene;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSceneBuilder implements SceneBuilder {
    private int height;
    private int width;
    private final List<Light> light;
    private final List<Figure> figures;
    private Camera camera;

    public ConcreteSceneBuilder() {
        this.light = new ArrayList<>();
        this.figures = new ArrayList<>();
        this.camera = null;
        this.height = 0;
        this.width = 0;
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
    public void addFigures(Figure figures) {
        this.figures.add(figures);
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public Scene build() {
        return new Scene(height, width, light.toArray(), figures.toArray(), camera);
    }
}
