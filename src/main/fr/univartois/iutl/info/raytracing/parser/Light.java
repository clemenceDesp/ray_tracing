package fr.univartois.iutl.info.raytracing.parser;

import java.awt.Color;
import java.awt.Point;
import fr.univartois.iutl.info.raytracing.numeric.Triplets;


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
