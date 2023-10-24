package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.parser.Light;

/**
 * The {@link IFigure} interface defines the contract to be fulfilled
 * by the different possible figures.
 */
public interface IFigure {
    /**
     * Gives the point of origin of this figure.
     *
     * @return The point of origin of this figure.
     */
    Point getOrigin();

    /**
     * Gives the diffuse color of the object.
     *
     * @return The diffuse color of the object.
     */
    Color getDiffuse();

    /**
     * Gives the reflected light.
     *
     * @return The reflected light.
     */
    Light getSpecular();

    /**
     * Gives the shininess of the object.
     *
     * @return The shininess of the object.
     */
    int getShininess();
}
