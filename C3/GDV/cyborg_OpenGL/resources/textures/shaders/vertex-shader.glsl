//#version 330 core
//
//layout (location = 0) in vec3 aPos;
//layout (location = 1) in vec3 aColor;
//layout (location = 2) in vec2 aTexture;
//
//out vec3 outColor;
//out vec2 outTexture;
//
//void main()
//{
//    gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);
//    outColor = aColor;
//    outTexture = aTexture;
//}
#version 330 core

layout (location = 0) in vec3 aPos;
layout (location = 1) in vec4 aColor;
layout (location = 2) in vec2 aTexture;

out vec4 outColor;
out vec2 outTexture;

uniform mat4 modelMatrix;
uniform mat4 projectionMatrix;

void main()
{

    //gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);
    gl_Position = projectionMatrix * modelMatrix * vec4(aPos.x, aPos.y, aPos.z, 1.0);
    //gl_Position = modelMatrix * vec4(aPos.x, aPos.y, aPos.z, 1.0);
    outColor = aColor;
    outTexture = aTexture;
}
