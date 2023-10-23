package fr.univartois.iutl.info.raytracing.numeric;

/**
 * @author romeo.jacquemin
 *This class represents a color in red/green/blue, which is a translation in a three-dimensional plane
 */
public class Color {
	Triplets triplets;
	
	/**
	 * @param triplets
	 */
	public Color(Triplets triplets) {
		this.triplets = triplets;
	}

	/**
	 * @return
	 */
	public Triplets getTriplets() {
		return triplets;
	}

	/**
	 * @param triplets
	 */
	public void setTriplets(Triplets triplets) {
		this.triplets = triplets;
	}
	
	/**
	 * @param pointB
	 * @return Color
	 * adds two color's rgb coordinates
	 */
	public Color addition(Color pointB) {
		return new Color(triplets.addition(pointB.getTriplets().getPointA()));
	}
	
	/**
	 * @param d
	 * @return Color
	 * multiplicate the rgb coordinates with an integer
	 */
	public Color multiplication(int d) {
		return new Color(triplets.multiplication(d));
	}
	
	/**
	 * @param pointB
	 * @return Color
	 * does the Schur product between two colors
	 */
	public Color multiplication(Color pointB) {
		return new Color(triplets.schurProduct(pointB.getTriplets().getPointA()));
	}
}
