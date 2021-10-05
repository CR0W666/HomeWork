package educanet.shapes.x3d;

import educanet.shapes.GameObject;
import educanet.shapes.x2d.Square;
import org.joml.Vector3f;

public class Cube extends GameObject{



    public Cube(float x, float y, float z, float cubeSize, float[] color) {
        super();

        this.x = x;
        this.y = y;
        this.z = z;
        this.size = cubeSize;

        this.vertices = new float[] {

                //front
                x + cubeSize    ,y + cubeSize,   z, // 0 -> Top    Right
                x + cubeSize    ,y             , z, // 1 -> Bottom Right
                x               ,y             , z, // 2 -> Bottom Left
                x               ,y + cubeSize,   z, // 3 -> Top    Left

                //back
                x + cubeSize    ,y + cubeSize,   z+cubeSize, // 0 -> Top    Right
                x + cubeSize    ,y             , z+cubeSize, // 1 -> Bottom Right
                x               ,y             , z+cubeSize, // 2 -> Bottom Left
                x               ,y + cubeSize,   z+cubeSize, // 3 -> Top    Left
        };

        this.indices = new int[] {
                //front
                0, 1, 3, // First triangle
                1, 2, 3, // Second triangle

                //back
                4, 5, 7, // third triangle
                5, 6, 7, // fourth triangle

                //right
                4, 5, 0,
                5, 1, 0,

                //left
                3, 2, 7,
                2, 6, 7,

                //top
                4, 0, 7,
                0, 3, 7,

                //bottom
                5, 1, 6,
                1, 2, 6
        };

        if (color == null) {
            this.color = new float[] {
                    1.0f, 1.0f, 0f, 0.2f,
                    1.0f, 1.0f, 0f, 0.2f,
                    1.0f, 1.0f, 0f, 0.2f,
                    1.0f, 1.0f, 0f, 0.2f,
                    1.0f, 0f, 1.0f, 0.2f,
                    1.0f, 0f, 1.0f, 0.2f,
                    1.0f, 0f, 1.0f, 0.2f,
                    1.0f, 0f, 1.0f, 0.2f
            };
        } else this.color = color;


        setup();
    }


    public Vector3f getPos() {
        return new Vector3f(this.x, y, z);
    }

    public void setPos(char axis, float amount) {
        switch (axis) {
            case 'x' -> this.x += amount;
            case 'y' -> this.y += amount;
            case 'z' -> this.z += amount;
        }
    }


    public void update() {

    }




}
