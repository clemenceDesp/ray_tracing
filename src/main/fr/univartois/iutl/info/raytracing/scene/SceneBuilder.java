package fr.univartois.iutl.info.raytracing.scene;

public interface SceneBuilder {
    SceneBuilder setHeight(int height);

    SceneBuilder setWidth(int width);

    SceneBuilder addLight(Light light);

    SceneBuilder addFigures(Figure figures);

    SceneBuilder setCamera(Camera camera);

    Scene build();
}
