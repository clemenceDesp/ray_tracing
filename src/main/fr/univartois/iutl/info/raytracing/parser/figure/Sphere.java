package fr.univartois.iutl.info.raytracing.parser.figure;

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
    
    private Point o;
    
    /**
	 * @return the o
	 */
	public Point getO() {
		return o;
	}

	/**
	 * @param o the o to set
	 */
	public void setO(Point o) {
		this.o = o;
	}

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
    
    public double findInteraction(Vector d) {
    	double b = getO().substraction(getCenter()).multiplication(2).scalarProduct(d);
    	double c = getO().substraction(getCenter()).scalarProduct(getO().substraction(getCenter()));
    	double delta = b*b-4*1*c;
    	if (delta < 0) {
    		return -1;
    	}
    	else if (delta == 0) {
    		if ((-b)/(2*1) > 0) {
    			return (-b)/(2*1);
    		}
    		return -1;
    	}
    	else {
    		double t1 = (-b+Math.sqrt(delta))/(2*1);
    		double t2 = (-b-Math.sqrt(delta))/(2*1);
    		if (t1>t2) {
    			if (t2 > 0) {
    				return t2;
    			}
    			else if (t1 > 0) {
    				return t1;
    			}
    			else {
    				return -1;
    			}
    		}
    		else if (t1 > 0) {
    			return t1;
    		}
    		else if(t2 > 0) {
    			return t2;
    		}
    		return -1;
    	}
    }
}
