package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.parser.Light;

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
     * Constructor of sphere.
     * @param center The center of the sphere.
     * @param radius The radius of the sphere.
     */
    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        this.diffuse = null;
        this.specular = null;
        this.shininess = -1;
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

    /**
     * Gives the diffuse color of the figure.
     *
     * @return The diffuse color of the figure.
     */
    @Override
    public Color getDiffuse() {
        return diffuse;
    }

    /**
     * Gives the reflected light.
     *
     * @return The reflected light.
     */
    @Override
    public Light getSpecular() {
        return specular;
    }

    /**
     * Gives the shininess of the figure.
     *
     * @return The shininess of the figure.
     */
    @Override
    public int getShininess() {
        return shininess;
    }
}
