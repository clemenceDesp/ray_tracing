package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.Light;

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
    private Light specular;
    /**
     * The shininess
     */
    int shininess;

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
        this.shininess = -1;
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
}
