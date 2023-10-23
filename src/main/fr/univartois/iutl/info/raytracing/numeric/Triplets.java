package fr.univartois.iutl.info.raytracing.numeric;

/**
 * @author romeo.jacquemin
 *
 */
public class Triplets {
	/**
	 * This variable contains the coordinates of the point
	 */
	private Coordinates pointA;
	
	/**
	 * @return pointA
	 * it is used to get the point and its coordinates
	 */
	public Coordinates getPointA() {
		return pointA;
	}

	/**
	 * @param pointA
	 * it is used to set the coordinates of the point
	 */
	public void setPointA(Coordinates pointA) {
		this.pointA = pointA;
	}

	/**
	 * @param pointA
	 * this is the constructor for the class, it takes a set of three coordinates
	 */
	public Triplets(Coordinates pointA) {
		this.pointA = pointA;
	}

	/**
	 * @param pointB
	 * @return Triplets 
	 * It is used to add the coordinates of an other Object with three dimensions coordinates, creating a third Triplets of coordinates
	 */
	public Triplets addition(Coordinates pointB) {
		return new Triplets(new Coordinates(pointA.getX()+pointB.getX(),pointA.getY()+pointB.getY(),pointA.getZ()+pointB.getZ()));
	}
	
	/**
	 * @param pointB
	 * @return Triplets
	 * It is used to substract the coordinates of an other Object with three dimensions coordinates, creating a third Triplets of coordinates
	 */
	public Triplets substraction(Coordinates pointB) {
		return new Triplets(new Coordinates(pointA.getX()-pointB.getX(),pointA.getY()-pointB.getY(),pointA.getZ()-pointB.getZ()));
	}
	
	/**
	 * @param d
	 * @return Triplets
	 * Multiply the triplets to an integer to create a new triplets
	 */
	public Triplets multiplication(int d) {
		return new Triplets(new Coordinates(pointA.getX()*d,pointA.getY()*d,pointA.getZ()*d));
	}
	
	/**
	 * @param pointB
	 * @return double
	 * do the scalar product between two points with three coordinates
	 */
	public double scalarProduct(Coordinates pointB) {
		return pointA.getX()*pointB.getX()+pointA.getY()*pointB.getY()+pointA.getZ()*pointB.getZ();
	}
	
	/**
	 * @param pointB
	 * @return Triplets
	 * do the vector product between two points
	 */
	public Triplets vectorProduct(Coordinates pointB) {
		return new Triplets(new Coordinates(pointA.getY()*pointB.getZ()-pointA.getZ()*pointB.getY(),pointA.getZ()*pointB.getX()-pointA.getX()*pointB.getZ(), pointA.getX()*pointB.getY()-pointA.getY()*pointB.getX()));
		
	}
	
	/**
	 * @param pointB
	 * @return Triplets
	 * do the Schur product between two points
	 */
	public Triplets schurProduct(Coordinates pointB) {
		return new Triplets(new Coordinates(pointA.getX()*pointB.getX(),pointA.getY()*pointB.getY(),pointA.getZ()*pointB.getZ()));
	}
	
	/**
	 * @return double
	 * calculate the length of a vector
	 */
	public double length() {
		return Math.sqrt(pointA.getX()*pointA.getX()+pointA.getY()*pointA.getY()+pointA.getZ()*pointA.getZ());
	}
	
	/**
	 * @return Triplets
	 * normalize a vector
	 */
	public Triplets normalization() {
		return new Triplets(new Coordinates(pointA.getX()/length(),pointA.getY()/length(),pointA.getZ()/length()));
	}
	
}
