package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Color;
import fr.univartois.iutl.info.raytracing.numeric.Point;

/***
 * A pixel of the scene
 */
public class Pixel {
    /***
     * The point of the pixel
     */
    private Point point;

    /***
     * The color of the pixel
     */
    private Color color;

    /***
     * Create a new pixel
     * @param point the point of the pixel
     * @param color the color of the pixel
     */
    public Pixel(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    /***
     * get the point of the pixel
     * @return the point of the pixel
     */
    public Point getPoint() {
        return point;
    }

    /***
     * get the color of the pixel
     * @return the color of the pixel
     */
    public Color getColor() {
        return color;
    }

    /***
     * set the point of the pixel
     * @param point the point of the pixel
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /***
     * set the color of the pixel
     * @param color the color of the pixel
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
