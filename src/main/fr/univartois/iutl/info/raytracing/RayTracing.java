package fr.univartois.iutl.info.raytracing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.parser.figure.Sphere;
import fr.univartois.iutl.info.raytracing.scene.Scene;

/**
 * @author felix
 *
 */
public class RayTracing {
	/**
	 * @param scene
	 * This code is use to go through every pixel of the image and verify if this pixel is in a figure. If it is, the program colors it in the ambiant color, else the program colors it in black.
	 */
	public RayTracing(Scene scene) {
		Vector v1 = scene.getCamera().getLookFrom().substraction(scene.getCamera().getLookAt());
		Vector w = v1.normalization();
		Vector v2 = scene.getCamera().getUp().vectorProduct(w);
		Vector u = v2.normalization();
		Vector v3 = w.vectorProduct(u);
		Vector v = v3.normalization();
		
		double fovr = (scene.getCamera().getFov()*Math.PI)/180;
		double realheight = 2*Math.tan(fovr/2);
		double pixelheight = realheight/scene.getHeight();
		double realwidth = scene.getWidth()*pixelheight;
		double pixelwidth = realwidth/scene.getWidth();
		
		for (int i=0;i<scene.getHeight();i++) {
			for (int j=0;j<scene.getWidth();j++) {
				double a = -(realwidth/2)+(i+0.5)*pixelwidth;
				double b = (realheight/2)-(j+0.5)*pixelheight;
				Vector v4 = (u.multiplication(a)).addition(v.multiplication(b)).substraction(w);
				Vector d = v4.normalization();
				double t = -1;
				List<Double> tList = new ArrayList<>();
				for (IFigure figure :scene.getFigures()) {
					((Sphere) figure).setO(scene.getCamera().getLookFrom());
					double tTemp = figure.findInteraction(d);
					if (tTemp >= 0) {
						tList.add(tTemp);
					}
				}
					if (!tList.isEmpty()) {
						t = tList.get(0);
						for (int k = 1; k < tList.size(); k++) {
							if (tList.get(k) < t) {
								t = tList.get(k);
							}
						}
					}
					if (t>=0) {
						Color color = new Color((float)scene.getAmbientLigth().getTriplets().getPointA().getX(),(float)scene.getAmbientLigth().getTriplets().getPointA().getY(),(float)scene.getAmbientLigth().getTriplets().getPointA().getZ());
						scene.getImage().setRGB(i,j,color.getRGB());
					}
					else {
						Color color = new Color(0,0,0);						
						scene.getImage().setRGB(j,i,color.getRGB());
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
			e.printStackTrace();
		}
	}
}
