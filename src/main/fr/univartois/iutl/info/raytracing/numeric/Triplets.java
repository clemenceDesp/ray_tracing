package fr.univartois.iutl.info.raytracing.numeric;

public class Triplets {
	
	public Coordinates addition(Coordinates pointA, Coordinates pointB) {
		return new Coordinates(pointA.getX()+pointB.getX(),pointA.getY()+pointB.getY(),pointA.getZ()+pointB.getZ());
	}
	
	public Coordinates substraction(Coordinates pointA, Coordinates pointB) {
		return new Coordinates(pointA.getX()-pointB.getX(),pointA.getY()-pointB.getY(),pointA.getZ()-pointB.getZ());
	}
	
	public Coordinates multiplication(Coordinates pointA, int d) {
		return new Coordinates(pointA.getX()*d,pointA.getY()*d,pointA.getZ()*d);
	}
	
	public int scalarProduct(Coordinates pointA, Coordinates pointB) {
		return pointA.getX()*pointB.getX()+pointA.getY()*pointB.getY()+pointA.getZ()*pointB.getZ();
	}
	
	public Coordinates vectorProduct(Coordinates pointA, Coordinates pointB) {
		return new Coordinates(pointA.getY()*pointB.getZ()-pointA.getZ()*pointB.getY(),pointA.getZ()*pointB.getX()-pointA.getX()*pointB.getZ(), pointA.getX()*pointB.getY()-pointA.getY()*pointB.getX());
		
	}
	
	public Coordinates schurProduct(Coordinates pointA, Coordinates pointB) {
		return new Coordinates(pointA.getX()*pointB.getX(),pointA.getY()*pointB.getY(),pointA.getZ()*pointB.getZ());
	}
	
	public int length(Coordinates pointA) {
		return pointA.getX()*pointA.getX()+pointA.getY()*pointA.getY()+pointA.getZ()*pointA.getZ();
	}
	
	public Coordinates normalization(Coordinates pointA) {
		return new Coordinates(pointA.getX()/length(pointA),pointA.getY()/length(pointA),pointA.getZ()/length(pointA));
	}
	
}
