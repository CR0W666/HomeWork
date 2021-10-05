//#version 330 core
//
//out vec4 FragColor;
//
//in vec3 outColor;
//in vec2 outTexture;
//
//uniform sampler2D ourTexture;
//
//void main()
//{
//    FragColor = texture(ourTexture, outTexture);
//    //FragColor = vec4(outColor, 1.0f);
//}
#version 330 core

out vec4 FragColor;

in vec2 outTexture;
in vec4 outColor;

uniform sampler2D ourTexture;

void main()
{
    vec4 texColor = texture(ourTexture, outTexture);
    if(texColor.a < 0.1)
    discard;
    FragColor = texColor * outColor;
    //FragColor = texColor;
    //FragColor = outColor;
}

