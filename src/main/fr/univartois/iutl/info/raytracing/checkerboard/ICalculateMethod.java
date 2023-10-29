package fr.univartois.iutl.info.raytracing.checkerboard;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public interface ICalculateMethod {

    Color calculate(Point point, double taille, Scene scene, double t, Vector d, IFigure stockFigure, Color c1, Color c2);
}
