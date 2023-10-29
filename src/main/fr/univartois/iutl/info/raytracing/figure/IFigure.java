package fr.univartois.iutl.info.raytracing.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;


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
    
    double findInteraction(Point lookFrom, Vector d);

    /**
     * Gives the diffuse color of the figure.
     *
     * @return The diffuse color of the figure.
     */
    Color getDiffuse();

    /**
     * Gives the reflected light.
     *
     * @return The reflected light.
     */
    Color getSpecular();

    /**
     * Gives the shininess of the figure.
     *
     * @return The shininess of the figure.
     */
    int getShininess();

    /**
     * Changes the diffuse color.
     * @param diffuse The new diffuse color.
     */
    void setDiffuse(Color diffuse);

    /**
     * Changes the reflected light.
     * @param specular The new reflected light.
     */
    void setSpecular(Color specular);

    /**
     * Changes the shininess.
     * @param shininess The new shininess.
     */
    void setShininess(int shininess);
}
