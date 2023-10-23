package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Point;

/**
 * The {@link Triangle} class represents a triangle.
 */
public class Triangle implements IFigure {
    /**
     * The pointA of the triangle
     */
    protected Point pointA;
    /**
     * The pointB of the triangle
     */
    protected Point pointB;
    /**
     * The pointC of the triangle
     */
    protected Point pointC;

    /**
     * Gives the pointA of this triangle.
     *
     * @return The pointA of this triangle.
     */
    public Point getPointA() {
        return pointA;
    }

    /**
     * Gives the pointB of this triangle.
     *
     * @return The pointB of this triangle.
     */
    public Point getPointB() {
        return pointB;
    }

    /**
     * Gives the pointC of this triangle.
     *
     * @return The pointC of this triangle.
     */
    public Point getPointC() {
        return pointC;
    }

    /**
     * Gives the point of origin of this figure.
     *
     * @return The point of origin of this figure.
     */
    @Override
    public Point getOrigin() {
        return pointA;
    }
}
