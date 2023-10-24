package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.parser.Light;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;

public interface SceneBuilder {
    void setHeight(int height);

    void setWidth(int width);

    void addLight(Light light);

    void addFigures(IFigure figures);

    void setCamera(Camera camera);
    void setOutput(String output);
    Scene build();
}
