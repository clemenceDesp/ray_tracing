package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

/**
 * The {@link Plane} class represents a plane.
 */
public class Plane implements IFigure {
    /**
     * A point of the plane
     */
    private Point point;
    /**
     * A normal of a plane
     */
    private Vector normal;
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
    private int shininess;
    /**
     * the boolean for if the Plane is checked or not
     */
    private boolean checker;

    /**
     * the length of a side of the squares of the checkerboard
     */
    private double length;

    /**
     * the first color for the checkerboard
     */
    private Color c1;
    /**
     * the second color for the checkerboard
     */
    private Color c2;

    /**
     * Constructor of plane.
     * @param point A point of the plane.
     * @param normal A normal of a plane.
     */
    public Plane(Point point, Vector normal) {
        this.point = point;
        this.normal = normal;
        this.diffuse = null;
        this.specular = null;
        this.shininess = -1;this.checker = false;
    }

    /**
     * Constructor of plane.
     * @param point A point of the plane.
     * @param normal A normal of a plane.
     */
    public Plane(Point point, Vector normal, Color c1, Color c2, double length) {
        this.point = point;
        this.normal = normal;
        this.diffuse = null;
        this.specular = null;
        this.shininess = -1;
        this.checker = true;
        this.c1 = c1;
        this.c2 = c2;
        this.length = length;
    }

    /**
     * check if the plane is checked or not
     * @return checker
     */
    public boolean isChecker() {
        return checker;
    }

    /**
     *
     * @return length
     */
    public double getlength() {
        return length;
    }

    /**
     *
     * @return color
     */
    public Color getC1() {
        return c1;
    }

    /**
     *
     * @return color
     */
    public Color getC2() {
        return c2;
    }

    /**
     * Gives the point of origin of this figure.
     *
     * @return The point of origin of this figure.
     */
    @Override
    public Point getOrigin() {
        return point;
    }

    /**
     * Gives the normal of this figure.
     *
     * @return The normal of this figure.
     */
    public Vector getNormal() {
        return normal;
    }
    
    public double findInteraction(Point lookFrom, Vector d) {
    	double y = d.scalarProduct(this.getNormal());
        if (y==0) {
            return -1;
        }
        return ((this.getOrigin().substraction(lookFrom)).scalarProduct(this.getNormal()))/y;
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
