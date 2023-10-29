package fr.univartois.iutl.info.raytracing.checkerboard;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.light.BaseColor;
import fr.univartois.iutl.info.raytracing.light.LambertDecorator;
import fr.univartois.iutl.info.raytracing.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public class CalculateFull implements ICalculateMethod{
    /**
     * calculate the color of the pixel
     * @param size size
     * @return the color of the pixel
     */
    @Override
    public Color calculate(Point point, double size, Scene scene, double t, Vector d, IFigure stockFigure, Color c1, Color c2) {
        LambertDecorator calcul = new LambertDecorator(new BaseColor());
        return calcul.calculatorColor(scene, t, d, stockFigure, stockFigure.getDiffuse());
    }
}
