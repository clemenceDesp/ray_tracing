package fr.univartois.iutl.info.raytracing.checkerboard;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public class CalculateChecked implements ICalculateMethod{

    /***
     * calculate the color of the pixel
     * @param point point
     * @param size size
     * @param scene scene
     * @param t t
     * @param d Vector d
     * @param stockFigure stockFigure
     * @param c1 color 1
     * @param c2 color 2
     * @return the color of the pixel
     */
    public Color calculate(Point point, double size, Scene scene, double t, Vector d, IFigure stockFigure, Color c1, Color c2) {
        if (point.getTriplets().getPointA().getX()%(size*2) < size && point.getTriplets().getPointA().getZ()%(size*2) <= size || point.getTriplets().getPointA().getX()%(size*2) > size && point.getTriplets().getPointA().getZ()%(size*2) > size) {
            return c2;
        }
        return c1;
    }
}
