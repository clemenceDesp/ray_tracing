package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.parser.Light;

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
     * The diffuse color of the figure
     */
    private Color diffuse;
    /**
     * The reflected light
     */
    private Light specular;
    /**
     * The shininess
     */
    int shininess;

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
        this.diffuse = null;
        this.specular = null;
        this.shininess = -1;
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
}
