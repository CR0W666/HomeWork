package educanet.utils;

import org.lwjgl.opengl.GL33;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class TextureHelper {
    public void loadImg(String filename) {
        int textureId = GL33.glGenTextures();
        try (MemoryStack stack = MemoryStack.create()) {
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

    }


//    public void loadVerts() {
//        // Tell OpenGL we are currently writing to this buffer (vboId)
//        GL33.glBindBuffer(GL33.GL_ARRAY_BUFFER, vboId);
//
//        tb.clear()
//                .put(textureIndices)
//                .flip();
//
//        // Send the buffer (positions) to the GPU
//        GL33.glBufferData(GL33.GL_ARRAY_BUFFER, tb, GL33.GL_STATIC_DRAW);
//        GL33.glVertexAttribPointer(2, 3, GL33.GL_FLOAT, false, 0, 0);
//        GL33.glEnableVertexAttribArray(0);
//    }


}
