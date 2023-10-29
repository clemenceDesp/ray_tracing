package fr.univartois.iutl.info.raytracing.light;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

/**
 * @author felix
 *
 */
public class PunctualLight implements Light {
	/**
	 * the point of the direction of the light
	 */
	private Point point;
	
	public PunctualLight(Point point, Color colors) {
		super();
		this.colors = colors;
		this.point = point;
	}

	/**
	 * the coordinates of the light
	 */
	private Vector coordinates;
	
	/**
	 * the colors of the light
	 */
	private Color colors; 
	
	/**
	 * @return the coordinates
	 */
	public Vector getCoordinates() {
		return this.coordinates;
	}

	/**
	 * @param coordinates The new coordinates.
	 * set the coordinates
	 */
	public void setCoordinates(Vector coordinates) {
		this.coordinates=coordinates;
	}

	/**
	 * @return the colors
	 */
	public Color getColors() {
		return this.colors;
	}

	/**
	 * set the colors
	 * @param colors The new color.
	 */
	public void setColors(Color colors) {
		this.colors=colors;
	}
	
	/**
	 * @return
	 * return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point
	 * set the point
	 */
	public void setPoint(Point point) {
		this.point = point;
	}
	
	/**
	 * @return
	 * return the direction of the vector of the light
	 */
	public Vector getDirection() {
		Vector v = this.point.substraction(this.point);
		return v.normalization();
	}
	
}
