package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Point;

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
}
