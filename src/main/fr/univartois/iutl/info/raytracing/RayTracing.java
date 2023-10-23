package fr.univartois.iutl.info.raytracing;

import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

public class RayTracing {
	private Scene scene = new Scene();
	Vector v1 = scene.getCamera().lookFrom().substraction(scene.getCamera().lookAt());
	Vector w = v1.normalization();
	Vector v2 = scene.getCamera().lookFrom().substraction(scene.getCamera().lookAt());
	Vector u = v2.normalization();

}
