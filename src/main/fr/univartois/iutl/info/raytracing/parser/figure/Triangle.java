package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
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
    private Color specular;
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
    
    public double findInteraction(Point lookFrom, Vector d) {
    	Vector numerator = (this.getPointB().substraction(this.pointA)).vectorProduct(this.getPointC().substraction(this.getPointA()));
        Vector normal = numerator.normalization();
        double y = d.scalarProduct(normal);
        if (y==0) {
            return -1;
        }
        double t = ((this.pointA.substraction(lookFrom)).scalarProduct(normal))/y;
        Point p = lookFrom.addition(d.multiplication(t));
        if (((this.getPointB().substraction(this.getPointA())).vectorProduct(p.substraction(this.getPointA()))).scalarProduct(normal) < 0) {
            return -1;
        }
        if (((this.getPointC().substraction(this.getPointB())).vectorProduct(p.substraction(this.getPointB()))).scalarProduct(normal) < 0) {
            return -1;
        }
        if (((this.getPointA().substraction(this.getPointC())).vectorProduct(p.substraction(this.getPointC()))).scalarProduct(normal) < 0) {
            return -1;
        }
        return t;

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
