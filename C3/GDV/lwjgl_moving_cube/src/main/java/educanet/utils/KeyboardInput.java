package educanet.utils;

import educanet.shapes.x3d.Cube;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;

public class KeyboardInput {

    public KeyboardInput() {

    }

    public boolean isKeyPressed(long window, int key) {
        return GLFW.glfwGetKey(window, key) == GLFW.GLFW_PRESS;
    }

    public Matrix4f movement(long window, Matrix4f matrix, Cube player) {

        if(isKeyPressed(window, GLFW.GLFW_KEY_SPACE)) {
            System.out.print("");
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_D)) {
            matrix = matrix.translate(0.001f, 0f, 0f);
            player.setPos('x', 0.001f);
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_A)) {
            matrix = matrix.translate(-0.001f, 0f, 0f);
            player.setPos('x', -0.001f);
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_W)) {
            matrix = matrix.translate(0f, 0.001f, 0f);
            player.setPos('y', 0.001f);
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_S)) {
            matrix = matrix.translate(0f, -0.001f, 0f);
            player.setPos('y', -0.001f);
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_Q)) {
            matrix = matrix.rotateY((float) Math.toRadians(0.1f));
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_E)) {
            matrix = matrix.rotateY((float) Math.toRadians(-0.1f));
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_Z)) {
            matrix = matrix.rotateX((float) Math.toRadians(0.1f));
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_X)) {
            matrix = matrix.rotateX((float) Math.toRadians(-0.1f));
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_R)) {
            matrix = matrix.translate(0f, 0f, 0.001f);
            player.setPos('z', 0.001f);
        }
        if(isKeyPressed(window, GLFW.GLFW_KEY_F)) {
            matrix = matrix.translate(0f, 0f, -0.001f);
            player.setPos('z', -0.001f);
        }
        return matrix;
    }
}
