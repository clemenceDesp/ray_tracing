package fr.univartois.iutl.info.raytracing;

import fr.univartois.iutl.info.raytracing.parser.Parser;
import fr.univartois.iutl.info.raytracing.scene.Scene;

public class Main {
    public static void main(String[] args) {
        if (args.length>0) {
            Scene scene = Parser.read(args[0]);
            assert scene != null;
            scene.saveImage();
        }
    }
}
