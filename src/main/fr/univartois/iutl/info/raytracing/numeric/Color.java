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
		if (triplets.getPointA().getX()<=1 && triplets.getPointA().getY()<=1 && triplets.getPointA().getZ()<=1 && triplets.getPointA().getX()>=0 && triplets.getPointA().getY()>=0 && triplets.getPointA().getZ()>=0) {
			this.triplets = triplets;
		}
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
		Color c = new Color(triplets.addition(pointB.getTriplets().getPointA()));
		if (c.getTriplets().getPointA().getX()<=1 && c.getTriplets().getPointA().getY()<=1 && c.getTriplets().getPointA().getZ()<=1 && c.getTriplets().getPointA().getX()>=0 && c.getTriplets().getPointA().getY()>=0 && c.getTriplets().getPointA().getZ()>=0) {
			return c;
		}
		System.err.println("une des trois coordonnées de la couleur dépasse 1"); 
		return null;
	}
	
	/**
	 * @param d
	 * @return Color
	 * multiplicate the rgb coordinates with an integer
	 */
	public Color multiplication(double d) {
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
