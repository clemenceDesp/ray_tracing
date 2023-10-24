package fr.univartois.iutl.info.raytracing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public class RayTracing {
	public RayTracing(Scene scene) {
		Vector v1 = scene.getCamera().getLookFrom().substraction(scene.getCamera().getLookAt());
		Vector w = v1.normalization();
		Vector v2 = scene.getCamera().getUp().vectorProduct(w);
		Vector u = v2.normalization();
		Vector v3 = w.vectorProduct(u);
		Vector v = v3.normalization();
		double fovr = (scene.getCamera().getFov()*Math.PI)/180;
		double pixelheight = Math.tan(fovr/2);
		double pixelwidth = (pixelheight*(scene.getWidth()/scene.getHeight()));
		
		for (int i=0;i<scene.getHeight();i++) {
			for (int j=0;j<scene.getWidth();j++) {
				double a = -(scene.getWidth()/2)+(i+0.5)*pixelwidth;
				double b = (scene.getHeight()/2)-(j+0.5)*pixelheight;
				Vector v4 = (u.multiplication(a)).addition(v.multiplication(b)).substraction(w);
				Vector d = v4.normalization();
				for (IFigure figure :scene.getFigures()) {
					double t = figure.findInteraction(d);
					if (t>=0) {
						Color color = new Color((float)scene.getAmbientLigth().getTriplets().getPointA().getX(),(float)scene.getAmbientLigth().getTriplets().getPointA().getY(),(float)scene.getAmbientLigth().getTriplets().getPointA().getZ());
						scene.getImage().setRGB(i,j,color.getRGB());
					}
					else {
						Color color = new Color(0,0,0);						
						scene.getImage().setRGB(i,j,color.getRGB());
					}
				}
			}
		}
		
		try {
			// Retrieve image
			BufferedImage image = scene.getImage();
			File outputfile = new File(scene.getOutput());
			ImageIO.write(image, "png", outputfile);
		}
			
		catch (IOException e) {
			// ...
		}
	}
}
