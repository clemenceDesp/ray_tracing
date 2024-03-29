package fr.univartois.iutl.info.raytracing.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

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
    private Color specular;
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
    
    public double findInteraction(Point lookFrom, Vector d) {
        double b = lookFrom.substraction(getOrigin()).multiplication(2).scalarProduct(d);
        double c = lookFrom.substraction(getOrigin()).scalarProduct(lookFrom.substraction(getOrigin())) - getRadius() * getRadius();
        double delta = b * b - 4 * 1 * c;
        if (delta < 0) {
            return -1;
        } else if (delta == 0) {
            if ((-b) / 2 > 0) {
                return (-b) / 2;
            }
            return -1;
        } else {
            double t1 = (-b + Math.sqrt(delta)) / 2;
            double t2 = (-b - Math.sqrt(delta)) / 2;
            if (t1 > t2) {
                if (t2 > 0) {
                    return t2;
                } else if (t1 > 0) {
                    return t1;
                } else {
                    return -1;
                }
            } else if (t1 > 0) {
                return t1;
            } else if (t2 > 0) {
                return t2;
            }
            return -1;
        }
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
    public Color getSpecular() {
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

    /**
     * Changes the diffuse color.
     *
     * @param diffuse The new diffuse color.
     */
    @Override
    public void setDiffuse(Color diffuse) {
        this.diffuse = diffuse;
    }

    /**
     * Changes the reflected light.
     *
     * @param specular The new reflected light.
     */
    @Override
    public void setSpecular(Color specular) {
        this.specular = specular;
    }

    /**
     * Changes the shininess.
     *
     * @param shininess The new shininess.
     */
    @Override
    public void setShininess(int shininess) {
        this.shininess = shininess;
    }
}
