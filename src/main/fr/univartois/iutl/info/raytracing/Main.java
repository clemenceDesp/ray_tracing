package fr.univartois.iutl.info.raytracing;

import fr.univartois.iutl.info.raytracing.parser.Parser;
import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        if (args.length>0) {
            Scene scene = Parser.read(args[0]);
            assert scene != null;
            scene.saveImage();
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
