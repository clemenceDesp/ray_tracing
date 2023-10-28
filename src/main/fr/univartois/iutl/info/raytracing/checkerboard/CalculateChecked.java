package fr.univartois.iutl.info.raytracing.checkerboard;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public class CalculateChecked implements ICalculateMethod{

    /**
     * @param taille
     * @param scene
     * @param t
     * @param d
     * @param stockFigure
     * @return
     */
    public Color calculate(Point point, double taille, Scene scene, double t, Vector d, IFigure stockFigure, Color c1, Color c2) {
        if (point.getTriplets().getPointA().getX() != taille && point.getTriplets().getPointA().getZ() != taille) {
            return c1;
        }
        return c2;
    }
}
