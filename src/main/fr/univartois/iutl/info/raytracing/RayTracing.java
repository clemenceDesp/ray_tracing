package fr.univartois.iutl.info.raytracing;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.scene.ConcreteSceneBuilder;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public class RayTracing {
	private Scene scene = new ConcreteSceneBuilder();
	Vector v1 = scene.getCamera().getLookFrom().substraction(scene.getCamera().getLookAt());
	Vector w = v1.normalization();
	Vector v2 = scene.getCamera().getUp().vectorProduct(w);
	Vector u = v2.normalization();
	Vector v3 = w.vectorProduct(u);
	Vector v = v3.normalization();
	double fovr = (scene.getCamera().getFov()*Math.PI)/180;
	double pixelheight = Math.tan(fovr/2);
	double pixelwidth = (pixelheight*(scene.getWidth()/scene.getHeight()));
	
	double a = -(scene.getWidth()/2)+(i+0.5)*pixelwidth;
	double b = (scene.getHeight()/2)-(j+0.5)*pixelheight;
	Vector v4 = (u.multiplication(a)).addition(v.multiplication(b)).substraction(w);
	Vector d = v4.normalization();
	
	try {
		// Retrieve image
		BufferedImage image = getMyImage();
		File outputfile = new File("output.png");
		ImageIO.write(image, "png", outputfile);
	}
		
		} catch (IOException e) {
		// ...
		}
}
