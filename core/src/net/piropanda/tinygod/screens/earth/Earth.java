package net.piropanda.tinygod.screens.earth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;

//import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
//import com.brashmonkey.spriter.Data;
//import com.brashmonkey.spriter.Player;
//import com.brashmonkey.spriter.SCMLReader;

/**
 * Earth
 */
public class Earth extends Group {
	
	private Screen screen;
	
	private Sprite earth;
	
	public float earth_x;
	public float earth_original_y;
	public float earth_y;
	public float earth_width = 1024;
	public float earth_scale = 1.0f;
	public float earth_rotation = 0;
	
	private ArrayList<Physical> astrals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals_to_render = new ArrayList<Physical>();
	
	Texture tex1, mask, mask2;
	ShaderProgram maskShader;
	
//	private Player player;
	
	private Label label;
	
	private float inertia = 0;
	
	
	public Earth(Screen screen2) {
		
		screen = screen2;
		
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

		// earth
		earth_x = (this.getX() + screen.getScrollPane().getWidth()/2 - earth_width/2);
		float percent_earth_showing = 20;
		earth_original_y = (-earth_width/2 -earth_width*earth_scale*((50f - percent_earth_showing)/100f));
		earth_y = earth_original_y;
		
		
		earth = new Sprite(TG.Graphics.assets.get("earth/earth.png", Texture.class));
		earth.setX(earth_x + earth_width/2 -earth.getWidth()/2);
		
		// astrals
		Sun sun;
		Moon moon;
		
		sun = new Sun(this, (earth_width/2)*earth_scale*(1.1f), 90);
		moon = new Moon(this, (earth_width/2)*earth_scale*(1.1f), 90 + 90);
		astrals.add(sun);
		astrals.add(moon);

		sun = new Sun(this, (earth_width/2)*earth_scale*(1.1f), 90 + 180);
		moon = new Moon(this, (earth_width/2)*earth_scale*(1.1f), 90 + 270);
		astrals.add(sun);
		astrals.add(moon);

		
		// atrezzo

		Atrezzo atrezzo;
		for (int i = 0; i < 200; i++) {
			
			float max_angle = (float) Math.toDegrees(Math.asin(0.4f));
			float angle = (float) (Math.random()*(max_angle));
			float radius_distance = (float) Math.sin(Math.toRadians(angle));
			
			atrezzo = new Atrezzo(this, (earth_width/2)*earth_scale - ((earth_width/2)*earth_scale*radius_distance), (float) (Math.random()*360), "tree");
			physicals.add(atrezzo);
		}

		
		
		// humans
		
		Human human;
		for (int i = 0; i < 200; i++) {
			
			float max_angle = (float) Math.toDegrees(Math.asin(0.4f));
			float angle = (float) (Math.random()*(max_angle));
			float radius_distance = (float) Math.sin(Math.toRadians(angle));
			
			human = new Human(this, (earth_width/2)*earth_scale - ((earth_width/2)*earth_scale*radius_distance), (float) (Math.random()*360));
			physicals.add(human);
		}
		
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		
//		String xmlSCML = null;
//		try {
//			xmlSCML = new String(Files.readAllBytes(Paths.get("bin/spriter/prueba.scml")));
//		} catch (IOException ex) {
//			System.out.println("A LA SHIT");
//		}
//		
//		Data data = new SCMLReader(xmlSCML).getData();
//		player = new Player(data.getEntity(0));
// 		player.setPosition(0, 0);
		
		label = new Label("Loading...", TG.Graphics.skin);
		label.setColor(Color.WHITE);
		label.setX(350);
		label.setY(300);
		this.addActor(label);

		
	}
	
	public void act(float dt) {
	    super.act(dt);
	    
	    earth.setY(0 -1504 +screen.getScrollPane().getVisualScrollY());
	    
	    earth_y = earth_original_y -1504 +screen.getScrollPane().getVisualScrollY();
	    
	    earth_rotation = (float) (earth_rotation + Gdx.graphics.getDeltaTime()*(2.0f));
	    
	    inertia = inertia/1.02f;
	    earth_rotation -= inertia * 0.15f;
	    
	    for (int i = 0; i < astrals.size(); i++) {
	    	astrals.get(i).angle += inertia * 0.15f;
	    	if (astrals.get(i).angle > 360) {
	    		astrals.get(i).angle -= 360;
	    	}
	    	else if (astrals.get(i).angle < 0) {
	    		astrals.get(i).angle += 360;
	    	}
	    }
	    
		
		if (earth_rotation > 360) {
			earth_rotation -= 360;
		}
		if (earth_rotation < 0) {
			earth_rotation += 360;
		}
		
		int num_astrals = astrals.size();
		for (int i = 0; i < num_astrals; i++) {
			astrals.get(i).act(Gdx.graphics.getDeltaTime());
		}
		
		int num_physicals = physicals.size();
		for (int i = 0; i < num_physicals; i++) {
			physicals.get(i).act(Gdx.graphics.getDeltaTime());
		}
			
		
		
//		player.update();
		
		
		label.setText("FPS: "+Gdx.graphics.getFramesPerSecond());
	}
	
	public void draw(Batch batch, float parentAlpha) {
		
		super.draw(batch, parentAlpha);
		
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
		
		for (int i = 0; i < astrals.size(); i++) {
			checkDraw(astrals.get(i), batch);
		}
		
		light(earth);
		earth.draw(batch);
		
		sortedPhysicalsRendering(batch);
		
	}
	
	public void sortedPhysicalsRendering(Batch batch) {
	
		int num_physicals = physicals.size();
		
		
		
		for (int i = 0; i < num_physicals; i++) {
			checkDraw(physicals.get(i), batch);
		}
		
		
//		physicals_to_render = (ArrayList<Physical>) physicals.clone();
//		
//		while(physicals_to_render.size() > 0) {
//			Physical next_physical = null;
//			
//			for (int i = 0; i < physicals_to_render.size(); i++) {
//				if (next_physical == null) {
//					next_physical = physicals_to_render.get(i);
//				}
//				else {
//					if (physicals_to_render.get(i).radius > next_physical.radius) {
//						next_physical = physicals_to_render.get(i);
//					}
//				}
//			}
//			physicals_to_render.remove(next_physical);
//			checkDraw(next_physical, batch);
//			next_physical = null;
//		}
	}
	
	public void light(Sprite s) {
		
		Physical current = null;
		for (int i = 0; i < astrals.size(); i++) {
			if (current == null) {
				current = astrals.get(i);
			}
			else if (astrals.get(i).sprite.getY() > current.sprite.getY()) {
				current = astrals.get(i);
			}
		}
		
		float red = 0;
		float green = 0;
		float blue = 0;
		
		
		if (current.getClass() == Sun.class) {
			
			float position = (current.sprite.getX() +current.sprite.getWidth()/2  -210)/(213f);
			
			if (Math.abs(position) < 0.7f) {
				// COLOR NORMAL
			}
			else if (Math.abs(position) < 1f) {
				float culmen = 0.7f + (1f - 0.7f)/2;
				red = ((1f - 0.7f)/2 - Math.abs(Math.abs(position)-culmen))/((1f - 0.7f)/2)*0.4f;

				if (Math.abs(position) > (1f -(1f - 0.7f)/2)) {
					blue = (Math.abs(position) - (1f -(1f - 0.7f)/2))/((1f - 0.7f)/2)*0.5f;
				}
				
				
			}
			else {
				// DE NOCHE
				blue = 0.5f;
			}
			
			
		}
		else {
			// DE NOCHE
			blue = 0.5f;
		}
		
		s.setColor(1f -green -blue, 1f -red -blue, 1f -red -green, 1f);
	}
	
	public void checkDraw(Physical p, Batch batch) {
		
		if (p.sprite.getX() < (-p.sprite.getWidth())
				|| p.sprite.getX() > (earth_x +earth_width/2 + screen.getScrollPane().getWidth()/2) 
				|| p.sprite.getY() < (-p.sprite.getHeight())) {
			// NO SE DIBUJA
		}
		else {
			if (p.getClass() != Moon.class && p.getClass() != Sun.class) {
				// SE TINTAN
				light(p.sprite);
			}
			
			p.draw(batch);
		}
		
	}

	public void pan(float x, float y, float deltaX, float deltaY) {
		
		inertia += deltaX*(40f/480f);
		if (inertia > 60) { inertia = 60; }
		else if (inertia < -60) { inertia = -60; }
		
	}
}
