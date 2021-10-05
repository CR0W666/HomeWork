package educanet.utils;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class Camera {

    private final Matrix4f transform;

    private FloatBuffer fb;

    public Camera() {
        transform = new Matrix4f()
                .identity()
                .perspective((float) Math.toRadians(60), (800f/600f), 0.01f, 10f)
                .lookAt(0f,0f,2f,0f,0f,0f,0f,1f,0f);
        fb = BufferUtils.createFloatBuffer(16);
    }

    public Camera(Matrix4f transform, FloatBuffer fb) {
        this.transform = transform;
        this.fb = fb;
    }

    public FloatBuffer getFb() {
        return fb;
    }

    public void setFb(FloatBuffer fb) {
        this.fb = fb;
    }

    public Camera translate(float dx, float dy, float dz) {
        transform.translate(dx, dy ,dz);
        transform.get(fb);
        return this;
    }

    public Camera rotate(float ax, float ay, float az) {
        transform.rotateXYZ(ax, ay, az);
        transform.get(fb);
        return this;
    }

    public Camera lookAt(float eyeX,float eyeY,float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {

        transform.lookAt((float) Math.sin(Math.toRadians(0.001f))/99, eyeY, (float) Math.cos(Math.toRadians(0.001f))/100, centerX, centerY, centerZ, upX, upY, upZ);
        transform.get(fb);
        return this;

    }



}
