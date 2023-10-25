package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

/**
 * @author felix
 *
 */
public interface Light {
	
	/**
	 * @return the coordinates
	 */
	Vector getCoordinates();
	/**
	 * @param coordinates The new coordinates.
	 * set the coordinates
	 */
	void setCoordinates(Vector coordinates);
	
	/**
	 * @return the colors
	 */
	Color getColors();
	/**
	 * @param colors The new color.
	 */
	void setColors(Color colors);
}
