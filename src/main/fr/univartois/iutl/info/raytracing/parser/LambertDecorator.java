package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Coordinates;
import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Triplets;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

/**
 * @author felix
 *
 */
public class LambertDecorator implements Calculator{
	
	private Calculator calculator;
	
	public LambertDecorator(Calculator calculator) {
		this.setCalculator(calculator);
	}
	
	public Color calculatorColor(Scene scene,double t, Vector d, IFigure figure, Color cDiffuse){
		Point p = scene.getCamera().getLookFrom().addition(d.multiplication(t));
		Point cc = figure.getOrigin();
		Vector v = p.substraction(cc);
		Vector n = v.normalization();
		Color color = new Color(new Triplets(new Coordinates(0,0,0)));
		for(Light light:scene.getLight()) {
			Color c = light.getColors();
			double max= 0;
			Vector l;
			if (light instanceof PunctualLight pl) {
				System.out.println(pl);
				l = pl.getPoint().substraction(p);
			} else {
				l = ((DirectionalLight) light).getVector();
			}
			l = l.normalization();
			if (n.scalarProduct(l) > 0) {
				max = n.scalarProduct(l);
			}
			if (max > 1) {
				max = 1;
			}
			color = color.addition(c.multiplication(max));
		}
		return (color.multiplication(cDiffuse)).addition(scene.getAmbientLigth());
		
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

}
