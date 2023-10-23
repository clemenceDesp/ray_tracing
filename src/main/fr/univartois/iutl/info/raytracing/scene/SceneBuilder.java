package fr.univartois.iutl.info.raytracing.scene;

public interface SceneBuilder {
    void setHeight(int height);

    void setWidth(int width);

    void addLight(Light light);

    void addFigures(Figure figures);

    void setCamera(Camera camera);

    Scene build();
}
