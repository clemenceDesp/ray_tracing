package fr.univartois.iutl.info.raytracing.parser;

import fr.univartois.iutl.info.raytracing.numeric.*;
import fr.univartois.iutl.info.raytracing.parser.figure.Plane;
import fr.univartois.iutl.info.raytracing.parser.figure.Sphere;
import fr.univartois.iutl.info.raytracing.parser.figure.Triangle;
import fr.univartois.iutl.info.raytracing.scene.Camera;
import fr.univartois.iutl.info.raytracing.scene.ConcreteSceneBuilder;
import fr.univartois.iutl.info.raytracing.scene.Scene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    /**
     * Array that stores the points created using maxverts and vertex.
     */
    private static Point[] verts = null;
    /**
     * Number of elements in the verts array
     */
    private static int nbVerts = 0;
    /**
     * Scene builder instance
     */
    private static ConcreteSceneBuilder sceneBuilder = new ConcreteSceneBuilder();

    /**
     * Changes the width and height of the scene.
     * @param width New width
     * @param height New height
     */
    private static void size(int width, int height){
        sceneBuilder.setWidth(width);
        sceneBuilder.setHeight(height);
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
                    case "#":
                        break;
                    case "size":
                        size(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                        break;
                    case "output":
                        //TODO
                    case "camera":
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
                        break;
                    case "ambient":
                        //TODO
                    case "diffuse":
                        //TODO
                    case "specular":
                        //TODO
                    case "shininess":
                        //TODO
                    case "directional":
                        Point directional = new Point(new Triplets(new Coordinates(
                                Double.parseDouble(line[1]),
                                Double.parseDouble(line[2]),
                                Double.parseDouble(line[3]))));
                        Color color = new Color(new Triplets(new Coordinates(
                                Double.parseDouble(line[4]),
                                Double.parseDouble(line[5]),
                                Double.parseDouble(line[6]))));
                        sceneBuilder.addLight(new DirectionalLight(directional, color));
                        break;
                    case "point":
                        Point point = new Point(new Triplets(new Coordinates(
                                Double.parseDouble(line[1]),
                                Double.parseDouble(line[2]),
                                Double.parseDouble(line[3]))));
                        color = new Color(new Triplets(new Coordinates(
                                Double.parseDouble(line[4]),
                                Double.parseDouble(line[5]),
                                Double.parseDouble(line[6]))));
                        sceneBuilder.addLight(new PunctualLight(point, color));
                        break;
                    case "maxverts":
                        int nbPoints = Integer.parseInt(line[1]);
                        verts = new Point[nbPoints];
                    case "vertex":
                        if (verts != null) {
                            verts[nbVerts] = new Point(new Triplets(new Coordinates(
                                    Double.parseDouble(line[1]),
                                    Double.parseDouble(line[2]),
                                    Double.parseDouble(line[3]))));
                        }
                    case "tri":
                        if (Integer.parseInt(line[1]) < nbVerts && Integer.parseInt(line[2]) < nbVerts && Integer.parseInt(line[3]) < nbVerts) {
                            Triangle triangle = new Triangle(verts[Integer.parseInt(line[1])], verts[Integer.parseInt(line[2])], verts[Integer.parseInt(line[3])]);
                            sceneBuilder.addFigures(triangle);
                        }
                        break;
                    case "sphere":
                        Sphere sphere = new Sphere(new Point(new Triplets(new Coordinates(
                                Double.parseDouble(line[1]),
                                Double.parseDouble(line[2]),
                                Double.parseDouble(line[3])))),
                                Integer.parseInt(line[4]));
                        sceneBuilder.addFigures(sphere);
                        break;
                    case "plane":
                        Plane plane = new Plane(new Point(new Triplets(new Coordinates(
                                Double.parseDouble(line[1]),
                                Double.parseDouble(line[2]),
                                Double.parseDouble(line[3])))),
                                new Vector(new Triplets(new Coordinates(
                                        Double.parseDouble(line[4]),
                                        Double.parseDouble(line[5]),
                                        Double.parseDouble(line[6])))));
                        sceneBuilder.addFigures(plane);
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
    }
}
