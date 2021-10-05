#version 330 core

out vec4 FragColor;
in vec2 outTexture;

//in vec4 outColor;

uniform sampler2D ourTexture;

void main()
{
    FragColor = texture(ourTexture, outTexture);
    //FragColor = vec4(outColor.x, outColor.y, outColor.z, 0.5);
}
