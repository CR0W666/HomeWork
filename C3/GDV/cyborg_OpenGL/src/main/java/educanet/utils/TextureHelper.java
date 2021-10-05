package educanet.utils;

import educanet.shapes.GameObject;
import educanet.shapes.x2d.Square;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL33;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class TextureHelper {

    public TextureHelper(float[] textures, int frames, String texturePath , GameObject actor,boolean direction ,int ticks) {
        if(textures != null) this.textures = textures;
        else if(direction) this.textures = texturesDefaultR;
        else this.textures = texturesDefaultL;


        tb = BufferUtils.createFloatBuffer(this.textures.length)
                .put(this.textures)
                .flip();

        this.frames = frames;
        this.actor = actor;
        this.texturePath = texturePath;
        this.ticks = ticks;
        tempTicks = ticks;
        moving = false;
        initTextures();
    }

    private final float[] texturesDefaultL = {
            0.0f, 0.0f, //bot left
            0.0f, 1.0f, //top left
            1.0f, 1.0f, //top right
            1.0f, 0.0f, //bot right
    };

    private final float[] texturesDefaultR = {
            1.0f, 0.0f, //bot r
            1.0f, 1.0f, //top r
            0.0f, 1.0f, //top l
            0.0f, 0.0f, //bot l
    };

    private float[] textures;

    private FloatBuffer tb;

    private GameObject actor;
    private String texturePath;
    private int textureIndicesId;
    private int textureId;
    private int currentFrame = 0;
    private int frames;
    private int width;
    private int height;
    private float spriteWidth;
    private float spriteHeight;
    private int ticks;
    private int tempTicks;
    private boolean direction;
    private boolean moving;
    private int movingDelay = 500;
    private int tempDelay = 0;

    public void animate() {
        if(!moving) {
            if (tempDelay <= movingDelay)tempDelay++;
        } else {
            tempDelay = 0;
        }

        if(tempDelay > movingDelay) {
            currentFrame = 4;
        }

        if(currentFrame >= frames) currentFrame = 0;

        calculateSprite();
        softSetTb(textures);
        loadVerts();

            tempTicks--;
            if(tempTicks == 0) {
                currentFrame++;
                tempTicks = ticks;
            }

    }

    private void calculateSprite() {
        float tw = spriteWidth / width;
        float th = spriteHeight / height;
        float tx = (currentFrame % frames) * tw;
        float ty = (currentFrame / frames + 1) * th;

        if(direction) {
            textures = new float[] {
                    tx + tw, ty,
                    tx + tw, ty + th,
                    tx     , ty + th,
                    tx     , ty
            };
        } else {
            textures = new float[] {
                    tx     , ty,
                    tx     , ty + th,
                    tx + tw, ty + th,
                    tx + tw, ty
            };
        }


    }

    public void initTextures() {
        textureIndicesId = GL33.glGenBuffers();
        textureId = GL33.glGenTextures();
        loadImg(texturePath);
    }

    public void loadImg(String filename) {
        try (MemoryStack stack = MemoryStack.stackPush()) {

            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);


            ByteBuffer img = STBImage.stbi_load(filename, w, h, comp, 4);
            if (img != null) {
                width = w.get();
                height = h.get();
                spriteHeight = height;
                spriteWidth = (float)width / frames;

                resizeActor();

                img.flip();
                GL33.glBindTexture(GL33.GL_TEXTURE_2D, textureId);
                GL33.glTexImage2D(GL33.GL_TEXTURE_2D, 0, GL33.GL_RGBA, width, height, 0, GL33.GL_RGBA, GL33.GL_UNSIGNED_BYTE, img);
                GL33.glGenerateMipmap(GL33.GL_TEXTURE_2D);
                STBImage.stbi_image_free(img);

            }
        }
        loadVerts();
    }

    private void resizeActor() {
        float sw = spriteWidth / 100;
        float sh = spriteHeight / 100;

        //actor.setSize(spriteWidth, spriteHeight);
        //actor.setVertices(actor.getVertices());
        if(actor instanceof Square) {
            actor.setVertices(
                    new float[] {  //square origin point is in Bottom Left
                            actor.getPos().x + sw  ,actor.getPos().y + sh, actor.getPos().z, // 0 -> Top    Right
                            actor.getPos().x + sw  ,actor.getPos().y     , actor.getPos().z, // 1 -> Bottom Right
                            actor.getPos().x       ,actor.getPos().y     , actor.getPos().z, // 2 -> Bottom Left
                            actor.getPos().x       ,actor.getPos().y + sh, actor.getPos().z, // 3 -> Top    Left
                    }
            );
        }

    }

    public void loadVerts() {
        // Tell OpenGL we are currently writing to this buffer (vboId)

        GL33.glBindVertexArray(actor.vaoId);
        GL33.glBindBuffer(GL33.GL_ARRAY_BUFFER, textureIndicesId);

        // Send the buffer (positions) to the GPU
        GL33.glBufferData(GL33.GL_ARRAY_BUFFER, tb, GL33.GL_STATIC_DRAW);
        GL33.glVertexAttribPointer(2, 2, GL33.GL_FLOAT, false, 0, 0);
        GL33.glEnableVertexAttribArray(2);
        //MemoryUtil.memFree(tb);
    }



    //region getsets

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }


    public void setTextureBuffer(int length) {

        if (tb != null) MemoryUtil.memFree(tb);

        tb = BufferUtils.createFloatBuffer(length);

    }

    public void softSetTb(float[] textures) {
        tb.clear().put(textures).flip();
    }

    public FloatBuffer getTextureBuffer() { return tb; }

    public int getTextureIndicesId() {
        return textureIndicesId;
    }

    public void setTextureIndicesId(int textureIndicesId) {
        this.textureIndicesId = textureIndicesId;
    }

    public int getTextureId() {
        return textureId;
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    public float[] getTextures() {
        return textures;
    }

    public void setTextures(float[] textures) {
        this.textures = textures;
        initTextures();
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public GameObject getActor() {
        return actor;
    }

    public void setActor(GameObject actor) {
        this.actor = actor;
    }


    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public float getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(float spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public float getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(float spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }
    //endregion


}
