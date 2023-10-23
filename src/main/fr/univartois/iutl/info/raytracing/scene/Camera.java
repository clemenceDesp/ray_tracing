package fr.univartois.iutl.info.raytracing.scene;

import fr.univartois.iutl.info.raytracing.numeric.Point;
import fr.univartois.iutl.info.raytracing.numeric.Vector;

public class Camera {
    private final int fov;
    private final Point lookFrom;
    private final Point lookAt;
    private final Vector up;

    public Camera(int fov, Point lookFrom, Point lookAt, Vector up) {
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

    public Vector getUp() {
        return up;
    }
}
