package fr.univartois.iutl.info.raytracing;

import fr.univartois.iutl.info.raytracing.light.DirectionalLight;
import fr.univartois.iutl.info.raytracing.light.PunctualLight;
import fr.univartois.iutl.info.raytracing.numeric.*;
import fr.univartois.iutl.info.raytracing.figure.IFigure;
import fr.univartois.iutl.info.raytracing.figure.Plane;
import fr.univartois.iutl.info.raytracing.figure.Sphere;
import fr.univartois.iutl.info.raytracing.figure.Triangle;
import fr.univartois.iutl.info.raytracing.scene.Camera;
import fr.univartois.iutl.info.raytracing.scene.ConcreteSceneBuilder;
import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***
 * The {@link Parser} class has the responsibility of reading a given text file.
 */
public class Parser {
    private Parser() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * A boolean put to false, switching to true if the next plane needs to be checked
     */
    private static boolean checker = false;

    /**
     * The first color of the two which are used in the case of a checked plane
     */
    private static Color c1;

    /**
     * The second color of the two which are used in the case of a checked plane
     */
    private static Color c2;

    /**
     * The length of a checkerboard square
     */
    private static double length;

    /**
     * Array that stores the points created using maxverts and vertex.
     */
    private static Point[] verts = null;
    /**
     * Number of elements in the verts array
     */
    private static int nbVerts = 0;
    /**
     * Array that stores diffuse information.
     */
    private static String[] stockDiffuse;
    /**
     * Array that stores specular information.
     */
    private static String[] stockSpecular;
    /**
     * Array that stores shininess information.
     */
    private static String[] stockShininess;
    /**
     * Scene builder instance
     */
    private static final ConcreteSceneBuilder sceneBuilder = new ConcreteSceneBuilder();

    /**
     * Changes the width and height of the scene.
     * @param line Line that is being read.
     */
    private static void size(String[] line){
        sceneBuilder.setWidth(Integer.parseInt(line[1]));
        sceneBuilder.setHeight(Integer.parseInt(line[2]));
    }

    /**
     * Changes the image name.
     * @param line Line that is being read.
     */
    private static void output(String[] line) {
        sceneBuilder.setOutput(line[1]);
    }

    /**
     * Configures the camera.
     * @param line Line that is being read.
     */
    private static void camera(String[] line) {
        Point lookFrom = new Point(new Triplets(new Coordinates(
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3]))));
        Point lookAt = new Point(new Triplets(new Coordinates(
                Double.parseDouble(line[4]),
                Double.parseDouble(line[5]),
                Double.parseDouble(line[6]))));
        Vector up = new Vector(new Triplets(new Coordinates(
                Double.parseDouble(line[7]),
                Double.parseDouble(line[8]),
                Double.parseDouble(line[9]))));
        int fov = Integer.parseInt(line[10]);
        sceneBuilder.setCamera(new Camera(fov,lookFrom,lookAt,up));
    }

    /**
     * Changes the ambient color.
     * @param line Line that is being read.
     */
    private static void ambient(String[] line) {
        sceneBuilder.setAmbient(new Color(new Triplets(new Coordinates(
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3])))));
    }

    /**
     * Stores the diffuse color of the object.
     * @param line Line that is being read.
     */
    private static void diffuse(String[] line) {
        stockDiffuse = line;
    }

    /**
     * Stores the reflected light.
     * @param line Line that is being read.
     */
    private static void specular(String[] line) {
        stockSpecular = line;
    }

    /**
     * Stores the shininess of the object.
     * @param line Line that is being read.
     */
    private static void shininess(String[] line) {
        stockShininess = line;
    }

    /**
     * Adds a directional light in the scene.
     * @param line Line that is being read.
     */
    private static void directional(String[] line) {
        Vector directional = new Vector(new Triplets(new Coordinates(
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3]))));
        Color color = new Color(new Triplets(new Coordinates(
                Double.parseDouble(line[4]),
                Double.parseDouble(line[5]),
                Double.parseDouble(line[6]))));
        sceneBuilder.addLight(new DirectionalLight(color, directional));
    }

    /**
     * Adds a punctual light in the scene.
     * @param line Line that is being read.
     */
    private static void point(String[] line) {
        Point point = new Point(new Triplets(new Coordinates(
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3]))));
        Color color = new Color(new Triplets(new Coordinates(
                Double.parseDouble(line[4]),
                Double.parseDouble(line[5]),
                Double.parseDouble(line[6]))));
        sceneBuilder.addLight(new PunctualLight(point, color));
    }

    /**
     * Configures the length of the array that stores the points that will be created.
     * @param line Line that is being read.
     */
    private static void maxVerts(String[] line) {
        int nbPoints = Integer.parseInt(line[1]);
        verts = new Point[nbPoints];
    }

    /**
     * Adds a point to the verts array.
     * @param line Line that is being read.
     */
    private static void vertex(String[] line) {
        if (verts != null) {
            verts[nbVerts] = new Point(new Triplets(new Coordinates(
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3]))));
        }
        nbVerts += 1;
    }

    /**
     * Adds a triangle in the scene.
     * @param line Line that is being read.
     */
    private static void tri(String[] line) {
        if (Integer.parseInt(line[1]) < nbVerts && Integer.parseInt(line[2]) < nbVerts && Integer.parseInt(line[3]) < nbVerts) {
            Triangle triangle = new Triangle(verts[Integer.parseInt(line[1])], verts[Integer.parseInt(line[2])], verts[Integer.parseInt(line[3])]);
            particularities(triangle);
            sceneBuilder.addFigure(triangle);
        }
    }

    /**
     * Adds a sphere in the scene.
     * @param line Line that is being read.
     */
    private static void sphere(String[] line) {
        Sphere sphere = new Sphere(new Point(new Triplets(new Coordinates(
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3])))),
                Double.parseDouble(line[4]));
        particularities(sphere);
        sceneBuilder.addFigure(sphere);
    }

    /**
     * Adds a plane in the scene.
     * @param line Line that is being read.
     */
    private static void plane(String[] line) {
        Plane plane;
        if (!checker) {
            plane = new Plane(new Point(new Triplets(new Coordinates(
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3])))),
                    new Vector(new Triplets(new Coordinates(
                            Double.parseDouble(line[4]),
                            Double.parseDouble(line[5]),
                            Double.parseDouble(line[6])))));
        }
        else {
            plane = new Plane(new Point(new Triplets(new Coordinates(
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3])))),
                    new Vector(new Triplets(new Coordinates(
                            Double.parseDouble(line[4]),
                            Double.parseDouble(line[5]),
                            Double.parseDouble(line[6])))),
                    c1, c2,length);
        }

        particularities(plane);
        sceneBuilder.addFigure(plane);
        if (checker) {
            checker = false;
        }
    }

    /**
     * it creates the two colors for the checked plane
     * @param line Line that is being read.
     */
    private static void checker(String[] line) {
        c1 = new Color(new Triplets(new Coordinates(
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3]))));
        c2 = new Color(new Triplets(new Coordinates(
                Double.parseDouble(line[4]),
                Double.parseDouble(line[5]),
                Double.parseDouble(line[6]))));
        length = Double.parseDouble(line[7]);
        checker = true;
    }

    /**
     * Adds particularities to a figure.
     * @param figure Figure which will be modified or not.
     */
    private static void particularities(IFigure figure) {
        if (stockDiffuse != null) {
            figure.setDiffuse(new Color(new Triplets(new Coordinates(
                    Double.parseDouble(stockDiffuse[1]),
                    Double.parseDouble(stockDiffuse[2]),
                    Double.parseDouble(stockDiffuse[3])))));
        }
        if (stockSpecular != null) {
            figure.setSpecular(new Color(new Triplets(new Coordinates(
                    Double.parseDouble(stockSpecular[1]),
                    Double.parseDouble(stockSpecular[2]),
                    Double.parseDouble(stockSpecular[3])))));
        }
        if (stockShininess != null) {
            figure.setShininess(Integer.parseInt(stockShininess[1]));
        }
    }

    /**
     * Changes the sampling of the scene
     * @param line Line that is being read.
     */
    private static void sampling(String[] line) {
        sceneBuilder.setSampling(line[1], Integer.parseInt(line[2]));
    }

    public static Scene read(String fileName) {
        BufferedReader bufferedreader = null;
        FileReader filereader = null;
        try {
            filereader = new FileReader(fileName);
            bufferedreader = new BufferedReader(filereader);
            String strCurrentLine;
            while ((strCurrentLine = bufferedreader.readLine()) != null) {
                String[] line = strCurrentLine.split(" ");
                switch (line[0]) {
                    case "size":
                        size(line);
                        break;
                    case "output":
                        output(line);
                        break;
                    case "camera":
                        camera(line);
                        break;
                    case "ambient":
                        ambient(line);
                        break;
                    case "diffuse":
                        diffuse(line);
                        break;
                    case "specular":
                        specular(line);
                        break;
                    case "shininess":
                        shininess(line);
                        break;
                    case "directional":
                        directional(line);
                        break;
                    case "point":
                        point(line);
                        break;
                    case "maxverts":
                        maxVerts(line);
                        break;
                    case "vertex":
                        vertex(line);
                        break;
                    case "tri":
                        tri(line);
                        break;
                    case "sphere":
                        sphere(line);
                        break;
                    case "plane":
                        plane(line);
                        break;
                    case "sampling":
                        sampling(line);
                        break;
                    case "checker":
                        checker = true;
                        checker(line);
                        break;
                    default:
                        break;
                }
            }
            return sceneBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedreader != null)
                    bufferedreader.close();
                if (filereader != null)
                    filereader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
