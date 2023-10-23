package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Point;

public class Camera {
    private final int fov;
    private final Point lookFrom;
    private final Point lookAt;
    private final  Point up;

    public Camera(int fov, Point lookFrom, Point lookAt, Point up) {
        this.fov = fov;
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
    }

    public int getFov() {
        return fov;
    }

    public Point getLookFrom() {
        return lookFrom;
    }

    public Point getLookAt() {
        return lookAt;
    }

    public Point getUp() {
        return up;
    }
}
