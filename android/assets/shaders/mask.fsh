#ifdef GL_ES
#define LOWP lowp
precision mediump float;
#else
#define LOWP
#endif
varying LOWP vec4 vColor;
varying vec2 vTexCoord;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform sampler2D u_mask;
void main(void) {
//sample the colour from the first texture
vec4 texColor0 = texture2D(u_texture, vTexCoord);

//sample the colour from the second texture
vec4 texColor1 = texture2D(u_texture1, vTexCoord);

//get the mask; we will only use the alpha channel
// ORIGINAL ES : 
vec4 prueba = texture2D(u_mask, vTexCoord);
float mask = prueba.r;
//float mask = (prueba.r*0)+0.5;
//float mask = texture2D(u_mask, vTexCoord).a;
//float mask = texture2D(u_mask, vTexCoord*2.44f).a;

//interpolate the colours based on the mask
gl_FragColor = vColor * mix(texColor0, texColor1, mask);
//gl_FragColor.a = 0.5;
}