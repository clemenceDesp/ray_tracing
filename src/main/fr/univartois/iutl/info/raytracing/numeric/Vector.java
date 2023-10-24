package fr.univartois.iutl.info.raytracing.numeric;

/**
 * @author romeo.jacquemin
 *This class represents a mathematic vector, which is a translation in a three-dimensional plane
 */
public class Vector {
	
	private Triplets triplets;

	/**
	 * @param triplets
	 */
	public Vector(Triplets triplets) {
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
	 * @return
	 */
	public Vector addition(Vector vectorB) {
		return new Vector(triplets.addition(vectorB.getTriplets().getPointA()));
	}
	
	/**
	 * @param pointB
	 * @return
	 */
	public Vector substraction(Vector pointB) {
		return new Vector(triplets.substraction(pointB.getTriplets().getPointA()));
	}
	
	/**
	 * @param d
	 * @return
	 */
	public Vector multiplication(double d) {
		return new Vector(triplets.multiplication(d));
	}
	
	/**
	 * @param pointB
	 * @return
	 */
	public double scalarProduct(Vector pointB) {
		return triplets.scalarProduct(pointB.getTriplets().getPointA());
	}
	
	/**
	 * @param pointB
	 * @return
	 */
	public Vector vectorProduct(Vector pointB) {
		return new Vector(triplets.vectorProduct(pointB.getTriplets().getPointA()));
	}
	
	/**
	 * @return
	 */
	public double length() {
		return triplets.length();
	}
	
	/**
	 * @return
	 */
	public Vector normalization() {
		return new Vector(triplets.normalization());
	}
}
