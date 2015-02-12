package net.piropanda.tinygod.screens.earth2;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.earth.Atrezzo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Earth2 extends Group {

	private ShaderProgram hueShader;
	private Image earth;
	private float rotation = -1f;
	
	
	public Earth2() {
		initShader();
		
		earth = new Image(TG.Graphics.assets.get("earth/earth.png", Texture.class));
		earth.setX(this.getX() + TG.Display.WIDTH/2 - earth.getWidth()/2);
		float percent_earth_showing = 20;
		earth.setY(-earth.getHeight()/2 -earth.getHeight()*earth.getScaleY()*((50f - percent_earth_showing)/100f));
		this.addActor(earth);
	}
	
	private void initShader() {
		ShaderProgram.pedantic = false;
		
//		tex1 = new Texture(Gdx.files.internal("shaders/aux_mask.png")); // ESTO ESTA POR SI QUEREMOS PINTAR ALGO EN EL HUECO
//		mask = new Texture(Gdx.files.internal("shaders/mask.png")); // ESTA ES LA MASCARA QUE HACE EL HUECO
//		mask2 = new Texture(Gdx.files.internal("shaders/mask2.png"));
//		
//		maskShader = new ShaderProgram(Gdx.files.internal("shaders/mask.vsh").readString(), Gdx.files.internal("shaders/mask.fsh").readString());
//
//		maskShader.begin();
//		maskShader.setUniformi("u_texture1", 1);
//		maskShader.setUniformi("u_mask", 2);
//		maskShader.end();
//		
//		//bind mask to glActiveTexture(GL_TEXTURE2)
//		mask.bind(2);
//		//mask2.bind(2);
//		
//		//bind dirt to glActiveTexture(GL_TEXTURE1)
//		tex1.bind(1);
		
		//now we need to reset glActiveTexture to zero!!!! since sprite batch does not do this for us
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
		
		hueShader = new ShaderProgram(Gdx.files.internal("shaders/hue.vsh"), Gdx.files.internal("shaders/hue.fsh"));
		System.out.println(hueShader.isCompiled());
	}
	
	public void act(float dt) {
		super.act(dt);
		
		rotation += Gdx.graphics.getDeltaTime();
		if(rotation >= 1) rotation = -1;
	}
	
	public void draw(Batch batch, float parentAlpha) {
		batch.setShader(hueShader);
		hueShader.begin();
			hueShader.setUniformf("hue", rotation);
			super.draw(batch, parentAlpha);
		hueShader.end();
		batch.setShader(null);
	}
	
}
