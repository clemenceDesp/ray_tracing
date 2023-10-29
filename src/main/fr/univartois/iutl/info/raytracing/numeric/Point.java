package fr.univartois.iutl.info.raytracing.numeric;

/**
 * @author romeo.jacquemin
 *This class represents a mathematic point, which is a translation in a three-dimensional plane
 */
public class Point {

	private Triplets triplets;

	/**
	 * Constructor of Point
	 * @param triplets the coordinates of the point
	 */
	public Point(Triplets triplets) {
		this.triplets=triplets;
	}
	
	
	
	/**
	 * getter of the coordinates of the point
	 * @return the triplets
	 */
	public Triplets getTriplets() {
		return triplets;
	}

	/**
	 * setter of the coordinates of the point
	 * @param triplets the triplets to set
	 */
	public void setTriplets(Triplets triplets) {
		this.triplets = triplets;
	}



	/**
	 * Does the addition between a point and a vector, this find a new point with those coordinates
	 * @param pointB the vector to add
	 * @return the result of the addition
	 */
	public Point addition(Vector pointB) {
		return new Point (triplets.addition(pointB.getTriplets().getPointA()));
	}

	/**
	 * Does the addition between two points, this find a new point with those coordinates
	 * @param pointB the point to add
	 * @return the result of the addition
	 */
	public Vector substraction(Point pointB) {
		return new Vector (triplets.substraction(pointB.getTriplets().getPointA()));
	}

	/**
	 * Does the substraction between two points, this find a new vector with those coordinates
	 * @param pointB the point to substract
	 * @return the result of the substraction
	 */
	public Point substraction(Vector pointB) {
		return new Point (triplets.substraction(pointB.getTriplets().getPointA()));
	}

	/**
	 * Does the substraction between two points, this find a new vector with those coordinates
	 * @param d the double to multiply
	 * @return the result of the multiplication
	 */
	public Point multiplication(double d) {
		return new Point(triplets.multiplication(d));
	}
}
