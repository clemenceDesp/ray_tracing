package fr.univartois.iutl.info.raytracing.parser.figure;

import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

/**
 * The {@link Plane} class represents a plane.
 */
public class Plane implements IFigure {
    /**
     * A point of the plane
     */
    protected Point point;
    /**
     * A normal of a plane
     */
    protected Vector normal;

    /**
     * Constructor of plane.
     * @param point A point of the plane.
     * @param normal A normal of a plane.
     */
    public Plane(Point point, Vector normal) {
        this.point = point;
        this.normal = normal;
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
    
    public double findInteraction(Vector d) {
    	throw new UnsupportedOperationException("This function only works with a sphere for now");
    }
    
}
