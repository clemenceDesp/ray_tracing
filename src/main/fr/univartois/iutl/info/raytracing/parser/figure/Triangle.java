package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

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
     * Constructor of triangle.
     * @param pointA The pointA of this triangle.
     * @param pointB The pointB of this triangle.
     * @param pointC The pointC of this triangle.
     */
    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

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
    
    public double findInteraction(Vector d) {
    	throw new UnsupportedOperationException("This function only works with a sphere for now");
    }
}
