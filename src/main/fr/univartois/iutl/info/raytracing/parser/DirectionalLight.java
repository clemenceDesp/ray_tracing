package fr.univartois.iutl.info.raytracing.parser;

import java.awt.Color;
import java.awt.Point;

/**
 * @author felix
 *
 */
public class DirectionalLight implements Light{

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
	 * @param coordinates
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
	 * @param colors
	 */
	public void setColors(Color colors) {
		this.colors=colors;
	}
}
