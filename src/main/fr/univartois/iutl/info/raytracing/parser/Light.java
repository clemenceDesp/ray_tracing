package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;

/**
 * @author felix
 *
 */
public interface Light {
	
	/**
	 * @return the coordinates
	 */
	Point getCoordinates();
	/**
	 * @param coordinates
	 */
	void setCoordinates(Point coordinates);
	
	/**
	 * @return the colors
	 */
	Color getColors();
	/**
	 * @param colors
	 */
	void setColors(Color colors);
}
