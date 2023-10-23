package fr.univartois.iutl.info.raytracing.scene;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSceneBuilder implements SceneBuilder {
    private int height;
    private int width;
    private List<Light> light;
    private List<Figure> figures;
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
        return null;
    }

    @Override
    public SceneBuilder setWidth(int width) {
        return null;
    }

    @Override
    public SceneBuilder addLight(Light light) {
        return null;
    }

    @Override
    public SceneBuilder addFigures(Figure figures) {
        return null;
    }

    @Override
    public SceneBuilder setCamera(Camera camera) {
        return null;
    }

    @Override
    public Scene build() {
        return new Scene(height, width, light.toArray(), figures.toArray(), camera);
    }
}
