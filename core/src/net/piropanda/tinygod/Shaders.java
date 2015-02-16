package net.piropanda.tinygod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class Shaders {
	
	public static Shaders instance = new Shaders();
	
	public ShaderProgram hueShader;
	
	public Shaders() {
		
		hueShader = new ShaderProgram(Gdx.files.internal("shaders/hue.vsh"), Gdx.files.internal("shaders/hue.fsh"));
		
	}

}
