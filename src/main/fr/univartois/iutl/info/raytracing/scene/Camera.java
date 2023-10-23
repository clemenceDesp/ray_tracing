package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Point;

public class Camera {
    private final int fov;
    private final Point lookFrom;
    private final Point lookAt;

    public Camera(int fov, Point lookFrom, Point lookAt) {
        this.fov = fov;
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
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
}
