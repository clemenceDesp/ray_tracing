package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.scene.Scene;

/**
 * @author felix
 *
 */
public class BaseColor implements Calculator {
	public Color calculatorColor(Scene scene) {
		return scene.getAmbientLigth();
	}
}
