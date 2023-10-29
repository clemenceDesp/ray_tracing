package fr.univartois.iutl.info.raytracing.numeric;

import fr.univartois.iutl.info.raytracing.Main;

import java.util.logging.Level;

/**
 * @author romeo.jacquemin
 *This class represents a color in red/green/blue, which is a translation in a three-dimensional plane
 */
public class Color {
	Triplets triplets;

	/**
	 * Constructor of Color
	 * @param triplets the coordinates of the color
	 */
	public Color(Triplets triplets) {
		if (triplets.getPointA().getX()<=1 && triplets.getPointA().getY()<=1 && triplets.getPointA().getZ()<=1 && triplets.getPointA().getX()>=0 && triplets.getPointA().getY()>=0 && triplets.getPointA().getZ()>=0) {
			this.triplets = triplets;
		}
	}

	/**
	 * getter of the coordinates of the color
	 * @return the coordinates of the color
	 */
	public Triplets getTriplets() {
		return triplets;
	}

	/**
	 * setter of the coordinates of the color
	 * @param triplets the coordinates of the color
	 */
	public void setTriplets(Triplets triplets) {
		this.triplets = triplets;
	}

	/**
	 * addition of two colors
	 * @param pointB the color to add
	 * @return the result of the addition
	 */
	public Color addition(Color pointB) {
		Color c = new Color(triplets.addition(pointB.getTriplets().getPointA()));
		if (c.getTriplets().getPointA().getX()<=1 && c.getTriplets().getPointA().getY()<=1 && c.getTriplets().getPointA().getZ()<=1 && c.getTriplets().getPointA().getX()>=0 && c.getTriplets().getPointA().getY()>=0 && c.getTriplets().getPointA().getZ()>=0) {
			return c;
		}
		Main.getLogger().log(Level.WARNING, "une des trois coordonnées de la couleur dépasse 1");
		return null;
	}

	/**
	 * multiplication of a color by a double
	 * @param d the double to multiply
	 * @return the result of the multiplication
	 */
	public Color multiplication(double d) {
		return new Color(triplets.multiplication(d));
	}

	/**
	 * multiplication of two colors
	 * @param pointB the color to multiply
	 * @return the result of the multiplication
	 */
	public Color multiplication(Color pointB) {
		return new Color(triplets.schurProduct(pointB.getTriplets().getPointA()));
	}
}
