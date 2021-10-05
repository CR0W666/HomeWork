package educanet.shapes.x2d;

import educanet.shapes.GameObject;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL33;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Square extends GameObject {


    public Square(float x, float y, float z, float squareSize, float[] color) {
        super();

        this.indices = new int[] {
                0, 1, 3, // First triangle
                1, 2, 3 // Second triangle
        };

        this.vertices = new float[] {  //square origin point is in Bottom Left
                x + squareSize  ,y + squareSize, z, // 0 -> Top    Right
                x + squareSize  ,y             , z, // 1 -> Bottom Right
                x               ,y             , z, // 2 -> Bottom Left
                x               ,y + squareSize, z, // 3 -> Top    Left
        }; //some help from Filip Makrlík

        if (color == null) {
            //white
            this.color = new float[] {
                    1.0f, 0.5f, 0.5f, 0.7f,
                    1.0f, 0.5f, 0.5f, 0.7f,
                    1.0f, 0.5f, 0.5f, 0.7f,
                    1.0f, 0.5f, 0.5f, 0.7f,
            };
            //transparent
//            this.color = new float[] {
//                    1.0f, 0.5f, 0.5f, 0.0f,
//                    1.0f, 0.5f, 0.5f, 0.0f,
//                    1.0f, 0.5f, 0.5f, 0.0f,
//                    1.0f, 0.5f, 0.5f, 0.0f,
//            };

        } else this.color = color;

        setup();
    }

    public void setSize(float sizeX, float sizeY) {
        this.vertices = new float[] {  //square origin point is in Bottom Left
                x + sizeX  ,y + sizeY, z, // 0 -> Top    Right
                x + sizeX  ,y        , z, // 1 -> Bottom Right
                x          ,y        , z, // 2 -> Bottom Left
                x          ,y + sizeY, z, // 3 -> Top    Left
        }; //some help from Filip Makrlík
    }


    public void update() {

    }

}

