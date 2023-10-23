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
    public SceneBuilder setHeight(int height) {
        return this.height = height;
    }

    @Override
    public SceneBuilder setWidth(int width) {
        return this.width = width;
    }

    @Override
    public SceneBuilder addLight(Light light) {
        return this.light.add(light);
    }

    @Override
    public SceneBuilder addFigures(Figure figures) {
        return this.figures.add(figures);
    }

    @Override
    public SceneBuilder setCamera(Camera camera) {
        return this.camera = camera;
    }

    @Override
    public Scene build() {
        return new Scene(height, width, light.toArray(), figures.toArray(), camera);
    }
}
