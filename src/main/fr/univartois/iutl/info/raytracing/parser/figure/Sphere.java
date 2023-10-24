package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Point;

/**
 * The {@link Sphere} class represents a sphere.
 */
public class Sphere implements IFigure {
    /**
     * The center of the sphere
     */
    protected Point center;
    /**
     * The radius of the sphere
     */
    protected double radius;

    /**
     * Constructor of sphere.
     * @param center The center of the sphere.
     * @param radius The radius of the sphere.
     */
    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Gives the center of this sphere.
     *
     * @return The center of this sphere.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Gives the radius of this sphere.
     *
     * @return The radius of this sphere.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Gives the point of origin of this figure.
     *
     * @return The point of origin of this figure.
     */
    @Override
    public Point getOrigin() {
        return center;
    }
}
