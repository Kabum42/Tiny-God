varying mediump vec2 vTextureCoordOut;

uniform sampler2D sampler;

void main()
{
  gl_FragColor = texture2D(sampler, vTextureCoordOut);
}