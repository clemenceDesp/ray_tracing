package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

/**
 * @author felix
 *
 */
public class PunctualLight implements Light {
	
	public PunctualLight(Vector coordinates, Color colors) {
		super();
		this.coordinates = coordinates;
		this.colors = colors;
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
}
