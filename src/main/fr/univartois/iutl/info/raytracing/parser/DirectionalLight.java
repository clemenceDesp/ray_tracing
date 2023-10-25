package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;

/**
 * @author felix
 *
 */
public class DirectionalLight implements Light{

	public DirectionalLight(Point coordinates, Color colors) {
		super();
		this.coordinates = coordinates;
		this.colors = colors;
	}

	/**
	 * the coordinates of the light
	 */
	private Point coordinates; 
	
	/**
	 * the colors of the light
	 */
	private Color colors; 
	
	/**
	 * @return the coordinates
	 */
	public Point getCoordinates() {
		return this.coordinates;
	}

	/**
	 * @param coordinates The new coordinates.
	 * set the coordinates
	 */
	public void setCoordinates(Point coordinates) {
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
