package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

/**
 * @author felix
 *
 */
public class DirectionalLight implements Light{
	/**
	 * the vector of the direction of the light
	 */
	private Vector vector;

	public DirectionalLight(Color colors, Vector vector) {
		super();
		this.colors = colors;
		this.vector = vector;
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
	public Vector getVector() {
		return vector;
	}

	/**
	 * set the vector
	 * @param vector The new vector.
	 */
	public void setVector(Vector vector) {
		this.vector = vector;
	}
	
	/**
	 * @return
	 * return the direction of the vector of the light
	 */
	public Vector getDirection() {
		return (this.vector).normalization();
	}
	
}
