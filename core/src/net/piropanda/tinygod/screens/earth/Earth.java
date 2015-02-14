package net.piropanda.tinygod.screens.earth;

import java.util.ArrayList;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

/**
 * Earth
 */
public class Earth extends Group {
	
	private ShaderProgram hueShader;
	
	//private Image earth;
	
	public float earth_x;
	public float earth_y;
	public float earth_width = 1024;
	public float earth_scale = 1.0f;
	public float earth_rotation = 0;
	
	private ArrayList<Physical> astrals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals_to_render = new ArrayList<Physical>();
	
	Texture tex1, mask, mask2;
	ShaderProgram maskShader;
	
	
	public Earth() {
		ShaderProgram.pedantic = false;
		
		tex1 = new Texture(Gdx.files.internal("shaders/aux_mask.png")); // ESTO ESTA POR SI QUEREMOS PINTAR ALGO EN EL HUECO
		mask = new Texture(Gdx.files.internal("shaders/mask.png")); // ESTA ES LA MASCARA QUE HACE EL HUECO
		mask2 = new Texture(Gdx.files.internal("shaders/mask2.png"));
		
		maskShader = new ShaderProgram(Gdx.files.internal("shaders/mask.vsh").readString(), Gdx.files.internal("shaders/mask.fsh").readString());

		maskShader.begin();
		maskShader.setUniformi("u_texture1", 1);
		maskShader.setUniformi("u_mask", 2);
		maskShader.end();
		
		//bind mask to glActiveTexture(GL_TEXTURE2)
		mask.bind(2);
		//mask2.bind(2);
		
		//bind dirt to glActiveTexture(GL_TEXTURE1)
		tex1.bind(1);
		
		//now we need to reset glActiveTexture to zero!!!! since sprite batch does not do this for us
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
		
		hueShader = new ShaderProgram(Gdx.files.internal("shaders/hue.vsh"), Gdx.files.internal("shaders/hue.fsh"));
		System.out.println(hueShader.isCompiled());

		// earth
		earth_x = (this.getX() + TG.Display.WIDTH/2 - earth_width/2);
		float percent_earth_showing = 20;
		earth_y = (-earth_width/2 -earth_width*earth_scale*((50f - percent_earth_showing)/100f));
		
		
//		earth = new Image(TG.Graphics.assets.get("earth/earth.png", Texture.class));
//		earth.setScale(1.0f, 1.0f);
//		earth.setX(this.getX() + TG.Display.WIDTH/2 - earth.getWidth()/2);
//		float percent_earth_showing = 20;
//		earth.setY(-earth.getHeight()/2 -earth.getHeight()*earth.getScaleY()*((50f - percent_earth_showing)/100f));
//		earth.setOrigin(Align.center);
		
		// astrals
		Sun sun;
		Moon moon;
		
		sun = new Sun(this, (earth_width/2)*earth_scale*(1.1f), 90);
		astrals.add(sun);
		this.addActor(sun);
		sun.setZIndex(0);
		moon = new Moon(this, (earth_width/2)*earth_scale*(1.1f), 90 + 90);
		astrals.add(moon);
		this.addActor(moon);
		moon.setZIndex(1);
		
		sun = new Sun(this, (earth_width/2)*earth_scale*(1.1f), 90 + 180);
		moon = new Moon(this, (earth_width/2)*earth_scale*(1.1f), 90 + 270);
		astrals.add(sun);
		this.addActor(sun);
		sun.setZIndex(2);
		astrals.add(moon);
		this.addActor(moon);
		moon.setZIndex(3);
		
		// add the earth image
//		this.addActor(earth);
//		earth.setZIndex(4);
		
		// atrezzo

		Atrezzo atrezzo;
		for (int i = 0; i < 200; i++) {
			
			float max_angle = (float) Math.toDegrees(Math.asin(0.4f));
			float angle = (float) (Math.random()*(max_angle));
			float radius_distance = (float) Math.sin(Math.toRadians(angle));
			
			atrezzo = new Atrezzo(this, (earth_width/2)*earth_scale - ((earth_width/2)*earth_scale*radius_distance), (float) (Math.random()*360), "tree");
			physicals.add(atrezzo);
			this.addActor(atrezzo);
		}

		
		
		// humans

		int num_humans = 200;
		
		Human human;
		for (int i = 0; i < num_humans; i++) {
			
			float max_angle = (float) Math.toDegrees(Math.asin(0.4f));
			float angle = (float) (Math.random()*(max_angle));
			float radius_distance = (float) Math.sin(Math.toRadians(angle));
			
			human = new Human(this, (earth_width/2)*earth_scale - ((earth_width/2)*earth_scale*radius_distance), (float) (Math.random()*360));
			physicals.add(human);
			this.addActor(human);
		}

		
	}
	
	public void act(float dt) {
	    super.act(dt);
	    
	    earth_rotation = (float) (earth_rotation + Gdx.graphics.getDeltaTime()*(2.0f));
	    
		
		if (earth_rotation > 360) {
			earth_rotation -= 360;
		}
		if (earth_rotation < 0) {
			earth_rotation += 360;
		}
		
		for (int i = 0; i < astrals.size(); i++) {
			astrals.get(i).act(Gdx.graphics.getDeltaTime());
		}
		
		for (int i = 0; i < physicals.size(); i++) {
			physicals.get(i).act(Gdx.graphics.getDeltaTime());
		}
	}
	
	public void draw(Batch batch, float parentAlpha) {
		
//		batch.setShader(hueShader);
//	    hueShader.begin();
//		hueShader.setUniformf("hue", (float)(-1 + earth_rotation/180));
		super.draw(batch, parentAlpha);
//		hueShader.end();
		
		/*
		if (Math.random() > 0.5) {
			mask.bind(2);
		}
		else {
			mask2.bind(2);
		}

		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
		batch.setShader(maskShader);
		*/
		
		sortedPhysicalsRendering(batch, parentAlpha);
		
		batch.setShader(null);
	}
	
	public void sortedPhysicalsRendering(Batch batch, float parentAlpha) {
		
		int z_current = 5;
		physicals_to_render = (ArrayList<Physical>) physicals.clone();
		
		while(physicals_to_render.size() > 0) {
			Physical next_physical = null;
			
			for (int i = 0; i < physicals_to_render.size(); i++) {
				if (next_physical == null) {
					next_physical = physicals_to_render.get(i);
				}
				else {
					if (physicals_to_render.get(i).radius > next_physical.radius) {
						next_physical = physicals_to_render.get(i);
					}
				}
			}
			next_physical.setZIndex(z_current);
			physicals_to_render.remove(next_physical);
			z_current++;
			next_physical = null;
		}
	}

	public void pan(float x, float y, float deltaX, float deltaY) {
		earth_rotation = earth_rotation - deltaX * 0.085f;
	}
}
