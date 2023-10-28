package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Vector;
import fr.univartois.iutl.info.raytracing.parser.figure.IFigure;
import fr.univartois.iutl.info.raytracing.scene.Scene;

/**
 * @author felix
 *
 */
public class BaseColor implements Calculator {
	public Color calculatorColor(Scene scene, double t, Vector d, IFigure figure, Color cDiffuse) {
		return scene.getAmbientLigth();
	}
}
