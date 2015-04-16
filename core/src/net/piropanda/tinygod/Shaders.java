package net.piropanda.tinygod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class Shaders {
	
	public static Shaders instance = new Shaders();
	
	public ShaderProgram hueShader;
	public ShaderProgram maskShader;
	public ShaderProgram vignetteShader;
	public ShaderProgram redShader;
	
	public Shaders() {
		
		hueShader = new ShaderProgram(Gdx.files.internal("shaders/hue.vsh"), Gdx.files.internal("shaders/hue.fsh"));
		
		maskShader = new ShaderProgram(Gdx.files.internal("shaders/mask.vsh").readString(), Gdx.files.internal("shaders/mask.fsh").readString());
		
		maskShader.begin();
		maskShader.setUniformi("u_texture1", 1);
		maskShader.setUniformi("u_mask", 2);
		maskShader.end();
		
		vignetteShader = new ShaderProgram(Gdx.files.internal("shaders/vignette.vsh"), Gdx.files.internal("shaders/vignette.fsh"));
		vignetteShader.pedantic = false;
		
		redShader = new ShaderProgram(Gdx.files.internal("shaders/aux2.vsh"), Gdx.files.internal("shaders/aux2.fsh"));
		redShader.pedantic = false;
		
	}

}
