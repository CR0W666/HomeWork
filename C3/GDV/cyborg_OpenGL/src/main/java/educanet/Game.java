package educanet;

import educanet.shapes.GameObject;
import educanet.shapes.x2d.Square;
import educanet.shapes.x3d.Cube;
import educanet.utils.KeyboardInput;
import educanet.utils.TextureHelper;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL33;

import java.nio.FloatBuffer;


public class Game {
    private static int uniformModelMatrixLocation;
    private static int uniformProjectionMatrixLocation;

    public static KeyboardInput kInput = new KeyboardInput();
    public static TextureHelper cyborg;

    private static Matrix4f matrix = new Matrix4f()
            .identity();

    // 4x4 -> FloatBuffer of size 16
    private static FloatBuffer matrixFloatBuffer = BufferUtils.createFloatBuffer(16);


    public static String texturePath = "resources/textures/imgs/Cyborg_run.png";
    public static GameObject baseSquare;


    public static void init(long window) {
        initOpenGl();

        baseSquare = new Square(0f,0f,0f, 1f, null);
        cyborg = new TextureHelper(null, 6, texturePath, (Square) baseSquare, false,200);

    }


    public static void render(long window) {
        matrix.get(matrixFloatBuffer);
        GL33.glBindTexture(GL33.GL_TEXTURE_2D, cyborg.getTextureId());
        GL33.glUniformMatrix4fv(uniformModelMatrixLocation, false, matrixFloatBuffer);

        if (baseSquare != null) baseSquare.draw();

    }

    public static void update(long window) {
        playerControls(window);
        updateSprite();


        matrix.get(matrixFloatBuffer);
        GL33.glUniformMatrix4fv(uniformModelMatrixLocation, false, matrixFloatBuffer);
    }

    private static void updateSprite() {
        cyborg.animate();
        cyborg.setMoving(false);
    }


    private static void playerControls(long window) {
        matrix = kInput.movement(window, matrix, baseSquare, cyborg);
    }

    private static void initOpenGl() {
        // Setup shaders
        Shaders.initShaders();
        GL33.glUseProgram(Shaders.shaderProgramId);
        // Get uniform location
        uniformModelMatrixLocation = GL33.glGetUniformLocation(Shaders.shaderProgramId, "modelMatrix");
        uniformProjectionMatrixLocation = GL33.glGetUniformLocation(Shaders.shaderProgramId, "projectionMatrix");

        // Sending Mat4 to GPU
        matrix.get(matrixFloatBuffer);
        GL33.glUniformMatrix4fv(uniformModelMatrixLocation, false, matrixFloatBuffer);
        GL33.glUniformMatrix4fv(uniformProjectionMatrixLocation, false, matrixFloatBuffer);

    }

}
