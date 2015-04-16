attribute vec4 position;
attribute vec2 textureCoordIn;
varying vec2 vTextureCoordOut;

uniform mediump mat4 modelViewMatrix;

void main()
{
  gl_Position = modelViewMatrix * position;
  vTextureCoordOut = textureCoordIn;
}