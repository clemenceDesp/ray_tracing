package fr.univartois.iutl.info.raytracing.numeric;

/**
 * @author romeo.jacquemin
 *This class represents a mathematic point, which is a translation in a three-dimensional plane
 */
public class Point {

	private Triplets triplets;

	/**
	 * @param triplets
	 */
	public Point(Triplets triplets) {
		this.triplets=triplets;
	}
	
	
	
	/**
	 * @return the triplets
	 */
	public Triplets getTriplets() {
		return triplets;
	}

	/**
	 * @param triplets the triplets to set
	 */
	public void setTriplets(Triplets triplets) {
		this.triplets = triplets;
	}



	/**
	 * @param pointB
	 * @return Point
	 * Does the addition between a point and a vector, this find a new point with those coordinates
	 */
	public Point addition(Vector pointB) {
		return new Point (triplets.substraction(pointB.getTriplets().getPointA()));
	}
	
	/**
	 * @param pointB
	 * @return Vector
	 * substracting two points finds the vector to go from point A to point B
	 */
	public Vector substraction(Point pointB) {
		return new Vector (triplets.substraction(pointB.getTriplets().getPointA()));
	}
	
	/**
	 * @param pointB
	 * @return Point
	 * substracting a vector to a point finds a new point at those coordinates
	 */
	public Point substraction(Vector pointB) {
		return new Point (triplets.substraction(pointB.getTriplets().getPointA()));
	}
	
	/**
	 * @param d
	 * @return Point
	 * multiplicate a point with an integer to find a new point
	 */
	public Point multiplication(int d) {
		return new Point(triplets.multiplication(d));
	}
}
