package educanet;

import educanet.shapes.x3d.Cube;
import educanet.utils.Camera;
import educanet.utils.FileUtils;
import educanet.utils.KeyboardInput;
import educanet.utils.MouseInput;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL33;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private static final float CAMERA_POS_STEP = 0f;
    /*
    TODO:
        - Camera - I FUCKING HATE THIS
        - Collision logic
        - Color handling
    */

//    public static Matrix4f viewMatrix = new Matrix4f();

    public static Camera camera = new Camera();

    public static MouseInput mInput = new MouseInput();
    public static KeyboardInput kInput = new KeyboardInput();

    public static final int LEVEL_NUMBER = 1;
    public static Cube player;
    public static String levelCode = "";
    public static int numOfObj = 0;
    public static Cube[] objects;


    private static int uniformModelMatrixLocation;
    private static int uniformProjectionMatrixLocation;


    private static int textureId;
    private static int textureIndicesId;


    private static final float[] textureIndices = {
            1.0f, 1.0f,
            1.0f, 0.0f,
            0.0f, 0.0f,
            0.0f, 1.0f
    };


    private static Matrix4f matrix = new Matrix4f()
            .identity();


    // 4x4 -> FloatBuffer of size 16
    private static FloatBuffer matrixFloatBuffer = BufferUtils.createFloatBuffer(16);

    public static void init(long window) {
        initOpenGl();
        getLevel();



        mInput.init(window);
        mInput.input(window);

        if (levelCode != null) {
            objects = new Cube[numOfObj];
            makeObjects();
        }

        makePlayer();

        initTextures();

        matrix.scale(0.5f);

    }

    public static void render(long window) {
        //--------  CAMERA         ------------
        GL33.glUniformMatrix4fv(uniformProjectionMatrixLocation, false, camera.getFb());


        //--------- RENDER OBJECTS ------------
        new Matrix4f().identity().get(matrixFloatBuffer);
        GL33.glUniformMatrix4fv(uniformModelMatrixLocation, false, matrixFloatBuffer);
        for (Cube object : objects) if (object != null) object.draw();

        //--------- RENDER PLAYER ------------
        matrix.get(matrixFloatBuffer);
        GL33.glBindTexture(GL33.GL_TEXTURE_2D, textureId);
        GL33.glUniformMatrix4fv(uniformModelMatrixLocation, false, matrixFloatBuffer);
        if (player != null) player.draw();

    }

    public static void update(long window) {

        playerControls(window);
        Vector3f plrPos = player.getPos();
        System.out.println("Player XYZ: " + plrPos.x + " | " + plrPos.y + " | " + plrPos.z  + " | size: " + player.size);
        if(checkCollision()) {
            onCollision();
        }


        // TODO: Send to GPU only if position updated
        matrix.get(matrixFloatBuffer);
        GL33.glUniformMatrix4fv(uniformModelMatrixLocation, false, matrixFloatBuffer);
    }


    private static boolean checkCollision() {

        for (Cube object : objects) if (object != null) {
            float objXAxisEnd = object.x+object.size*2;
            float plrXAxisEnd = player.x+player.size;

            float objYAxisEnd = object.y+object.size*2;
            float plrYAxisEnd = player.y+player.size;

            float objZAxisEnd = object.z+object.size*2;
            float plrZAxisEnd = player.z+player.size;

            //Z
            //        (player.x > object.x && player.x < objXAxisEnd) || (plrXAxisEnd > object.x && plrXAxisEnd < objXAxisEnd)
            //     && (player.y > object.y && player.y < objYAxisEnd) || (plrYAxisEnd > object.y && plrYAxisEnd < objYAxisEnd)
            //     && (player.z > object.z && player.z < objZAxisEnd) || (plrZAxisEnd > object.z && plrZAxisEnd < objZAxisEnd)
            //
            if(        (player.x > object.x && player.x < objXAxisEnd) || (plrXAxisEnd > object.x && plrXAxisEnd < objXAxisEnd)
                    && (player.y > object.y && player.y < objYAxisEnd) || (plrYAxisEnd > object.y && plrYAxisEnd < objYAxisEnd)

                ) {


                return true;
            }

        }

        return false;
    }

    private static void onCollision() {
        System.out.print(" !!  COLLISION");
    }

    private static void playerControls(long window) {
        matrix = kInput.movement(window, matrix, player);
        updateCam(window);

    }

    public static void updateCam(long window) {

        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_UP)) {
            camera.translate(0f,-0.001f,0f);
        }
        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_DOWN)) {
            camera.translate(0f,0.001f,0f);
        }
        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_LEFT)) {
            camera.translate(0.001f,0f,0f);
        }
        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT)) {
            camera.translate(-0.001f,0f,0f);
        }
        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_C)) {
            camera.translate(0f,0f,0.001f);
        }
        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_V)) {
            camera.translate(0f,0f,-0.001f);
        }


        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_J)) {
            camera.lookAt(0.001f,0f,0f,0f,0f,0f,0f,1f,0f);
        }
        if (kInput.isKeyPressed(window, GLFW.GLFW_KEY_L)) {
            camera.lookAt(0f,0f,0.001f,0f,0f,0f,0f,1f,0f);
        }


    }

    /*
    public static Matrix4f getViewMatrix(Camera camera) {


        viewMatrix.identity();
        // First do the rotation so camera rotates over its position
        viewMatrix.rotate((float)Math.toRadians(rotation.x), new Vector3f(1, 0, 0))
                .rotate((float)Math.toRadians(rotation.y), new Vector3f(0, 1, 0));
        // Then do the translation
        viewMatrix.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        return viewMatrix;
    } */

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

    private static void getLevel() {
        String path = "src/main/resources/levels/lvl" + LEVEL_NUMBER + ".txt";
        File level = new File(path);

        if (level.exists() && level.canRead()) //checks if maze file exists and is readable
            levelCode = FileUtils.readFile(path);

        System.out.println("Level Code:\n" + levelCode); //debug print

        //calculate the num of objects in the level
        Matcher m = Pattern.compile("\r\n|\r|\n").matcher(levelCode); //using matcher to not fill up gc with useless strings from .split();
        while (m.find()) {
            numOfObj++;
        } //increments every new line


    }
    private static void makeObjects() {
        String[] objs = levelCode.split("\n");

        float[] color = new float[] {
                0.0f, 1.0f, 0f, 0f,
                0.0f, 1.0f, 0f, 0f,
                0.0f, 1.0f, 0f, 0f,
                0.0f, 1.0f, 0f, 0f,
                0.0f, 0f, 0.0f, 0f,
                0.0f, 0f, 0.0f, 0f,
                0.0f, 0f, 0.0f, 0f,
                0.0f, 0f, 0.0f, 0f
        };

        for (int i = 0; i < numOfObj; i++) {
            String[] objAtrribs = objs[i].split(";");
            objects[i] = new Cube(Float.parseFloat(objAtrribs[0]),Float.parseFloat(objAtrribs[1]),0f,Float.parseFloat(objAtrribs[2]), color);
        }
    }
    private static void makePlayer() {
        //player = new Cube(-2f,1.35f,0f,0.4f, null, true);
        player = new Cube(0f,0f,0f,0.4f, null);
    }


    private static void initTextures() {
        textureIndicesId = GL33.glGenBuffers();
        textureId = GL33.glGenTextures();
        loadImg("src/main/resources/textures/mnamka.jpg");

    }

    private static void loadImg(String filename) {
        textureId = GL33.glGenTextures();
        try (MemoryStack stack = MemoryStack.stackPush()) {

            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            ByteBuffer img = STBImage.stbi_load(filename, w, h, comp, 3);
            if (img != null) {
                img.flip();
                GL33.glBindTexture(GL33.GL_TEXTURE_2D, textureId);
                GL33.glTexImage2D(GL33.GL_TEXTURE_2D, 0, GL33.GL_RGB, w.get(), h.get(), 0, GL33.GL_RGB, GL33.GL_UNSIGNED_BYTE, img);
                GL33.glGenerateMipmap(GL33.GL_TEXTURE_2D);
                STBImage.stbi_image_free(img);
            }
        }
        loadVerts();
    }

    public static void loadVerts() {
        // Tell OpenGL we are currently writing to this buffer (vboId)
        GL33.glBindBuffer(GL33.GL_ARRAY_BUFFER, textureIndicesId);

        FloatBuffer tb = BufferUtils.createFloatBuffer(textureIndices.length)
                .put(textureIndices)
                .flip();

        // Send the buffer (positions) to the GPU
        GL33.glBufferData(GL33.GL_ARRAY_BUFFER, tb, GL33.GL_STATIC_DRAW);
        GL33.glVertexAttribPointer(2, 2, GL33.GL_FLOAT, false, 0, 0);
        GL33.glEnableVertexAttribArray(2);
        MemoryUtil.memFree(tb);
    }


}
