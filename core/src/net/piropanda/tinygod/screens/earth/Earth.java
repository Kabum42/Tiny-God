package net.piropanda.tinygod.screens.earth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import net.piropanda.tinygod.Shaders;
//import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.god.God;
import net.piropanda.tinygod.spriter.LibGdxDrawer;
import net.piropanda.tinygod.spriter.LibGdxLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.brashmonkey.spriter.Data;
import com.brashmonkey.spriter.Drawer;
import com.brashmonkey.spriter.FileReference;
import com.brashmonkey.spriter.Loader;
import com.brashmonkey.spriter.Player;
import com.brashmonkey.spriter.SCMLReader;
import com.brashmonkey.spriter.Timeline;
import com.brashmonkey.spriter.Entity.CharacterMap;
import com.brashmonkey.spriter.Timeline.Key.Object;

/**
 * Earth
 */
public class Earth extends Group {
	
	private Screen screen;
	
	public Sprite earth;
	
	public float earth_original_y;
	public float earth_y;
	public float earth_width = 1024;
	public float earth_scale = 1.0f;
	public float earth_rotation = 0;
	
	private ArrayList<Sprite> stars = new ArrayList<Sprite>();
	private ArrayList<Physical> astrals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals_to_render = new ArrayList<Physical>();
	
	private Texture tex1, mask, mask2;
	private Animation maskAnimation;
	private float maskAnimationTime = 0; 
	
	
	private Label label;
	
	private float inertia = 0;
	
	Player player;
	LibGdxLoader loader;
	
	private boolean screenVisible = false;
	private boolean day = true;
	
	public Sound soundCrickets;
	public float soundCricketsPlaying = 0f;
	
	private float astral_position;
	
	
	public Earth(Screen screen2) {
		
		screen = screen2;
		
		ShaderProgram.pedantic = false;
		
		tex1 = new Texture(Gdx.files.internal("shaders/aux_mask.png")); // ESTO ESTA POR SI QUEREMOS PINTAR ALGO EN EL HUECO
		mask = new Texture(Gdx.files.internal("shaders/mask.png")); // ESTA ES LA MASCARA QUE HACE EL HUECO
		mask2 = new Texture(Gdx.files.internal("shaders/mask2.png"));
		
		TextureRegion[] frames = new TextureRegion[16];
		frames[0] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask.png")));
		frames[1] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask2.png")));
		frames[2] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask3.png")));
		frames[3] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask4.png")));
		frames[4] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask5.png")));
		frames[5] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask6.png")));
		frames[6] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask7.png")));
		frames[7] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask6.png")));
		frames[8] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask5.png")));
		frames[9] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask4.png")));
		frames[10] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask3.png")));
		frames[11] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask2.png")));
		frames[12] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask.png")));
		frames[13] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask.png")));
		frames[14] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask.png")));
		frames[15] = new TextureRegion(new Texture(Gdx.files.internal("shaders/mask.png")));
		
		maskAnimation = new Animation(1/24f, frames);
		
		//maskShader = new ShaderProgram(Gdx.files.internal("shaders/mask.vsh").readString(), Gdx.files.internal("shaders/mask.fsh").readString());

//		maskShader.begin();
//		maskShader.setUniformi("u_texture1", 1);
//		maskShader.setUniformi("u_mask", 2);
//		maskShader.end();
		
		//bind mask to glActiveTexture(GL_TEXTURE2)
		mask.bind(2);
		//mask2.bind(2);
		
		//bind dirt to glActiveTexture(GL_TEXTURE1)
		tex1.bind(1);
		
		//now we need to reset glActiveTexture to zero!!!! since sprite batch does not do this for us
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);

		// earth
		float percent_earth_showing = 20;
		earth_original_y = (-earth_width/2 -earth_width*earth_scale*((50f - percent_earth_showing)/100f));
		earth_y = earth_original_y;
		
		
		earth = new Sprite(TG.Graphics.assets.get("earth/earth.png", Texture.class));
		earth.setX(TG.Display.WIDTH*2.5f - earth.getWidth()/2*earth.getScaleX());
		
		for (int i = 0; i < 200; i++) {
			Sprite s = new Sprite(TG.Graphics.assets.get("pixel.png", Texture.class));
			s.setScale(2f);
			s.setX((float) (TG.Display.WIDTH*2f + Math.random()*TG.Display.WIDTH));
			s.setY((float) (Math.random()*TG.Display.HEIGHT));
			stars.add(s);
		}
		
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
		
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
			
		FileHandle handle = Gdx.files.internal("spriter/Yahvy/YahvyAnimation.scml");
		SCMLReader scml = new SCMLReader(handle.read());
		Data data = scml.getData();
		loader = new LibGdxLoader(data);
		loader.load(handle.file());
		player = new Player(data.getEntity(0));
		player.setScale(1f/2.75f);
		player.setPosition(TG.Display.WIDTH*2.5f, 300);
		
		
 		
		
		label = new Label("Loading...", TG.Graphics.skin);
		label.setColor(Color.WHITE);
		label.setX(TG.Display.WIDTH*2.5f);
		label.setY(300);
		this.addActor(label);
		
		soundCrickets = Gdx.audio.newSound(Gdx.files.internal("audio/crickets.mp3"));

		
	}
	
	public void act(float dt) {
	    super.act(dt);
	    
	    maskAnimationTime += Gdx.graphics.getDeltaTime();
	    if (maskAnimationTime > maskAnimation.getAnimationDuration()) {
	    	maskAnimationTime -= maskAnimation.getAnimationDuration();
	    }
	    
	    earth.setY(0 -504 -((God)screen).earth_distant +screen.getScrollPane().getVisualScrollY());
	    
	    earth_y = earth_original_y -504 -((God)screen).earth_distant +screen.getScrollPane().getVisualScrollY();
	    
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
			
		
		
		player.update();
		
		
		label.setText("FPS: "+Gdx.graphics.getFramesPerSecond());
		
		if (soundCricketsPlaying > 0) {
			soundCricketsPlaying -= Gdx.graphics.getDeltaTime();
			if (soundCricketsPlaying < 0) {
				soundCricketsPlaying = 0;
			}
		}
		
		
	}
	
	public void draw(Batch batch, float parentAlpha) {
		
	
		super.draw(batch, parentAlpha);
		
		
//		if (Math.random() > 0.5) {
//			mask.bind(2);
//		}
//		else {
//			mask2.bind(2);
//		}
//
//		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
//		batch.setShader(maskShader);
		
		screenVisible = false;
		
		light(earth);
		
		// STARS
		if (day) {
			if (Math.abs(astral_position) > 0.85f) {
				float max_value = (Math.abs(astral_position) -0.85f)/0.2f;
				for (int i = 0; i < stars.size(); i++) {
					stars.get(i).draw(batch, (float) (Math.random()*max_value));
				}
			}
		}
		else {
			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).draw(batch, (float) (Math.random()*1f));
			}
		}
		// END OF STARS
		
		
		for (int i = 0; i < astrals.size(); i++) {
			checkDraw(astrals.get(i), batch);
		}
		
		
		earth.draw(batch);
		
		sortedPhysicalsRendering(batch);
		
		drawSpriter(player, batch);
		
		if (screenVisible && day == false && soundCricketsPlaying <= 0) {
			soundCricketsPlaying = 4.0f;
			soundCrickets.play(0.05f);
		}
		
		
		
		
	}
	
	public void drawSpriter(Player player2, Batch batch) {
		
		CharacterMap[] maps = player2.characterMaps;
		Iterator<Timeline.Key.Object> it = player2.objectIterator();
		
		while(it.hasNext()){
			Timeline.Key.Object object = it.next();
			if(object.ref.hasFile()){
				if(maps != null){
					for(CharacterMap map: maps)
						if(map != null)
							object.ref.set(map.get(object.ref));
				}
				
				Sprite sprite = loader.get(object.ref);
				float newPivotX = (sprite.getWidth() * object.pivot.x);
				float newX = object.position.x - newPivotX;
				float newPivotY = (sprite.getHeight() * object.pivot.y);
				float newY = object.position.y - newPivotY;
				
				sprite.setX(newX);
				sprite.setY(newY);
				
				sprite.setOrigin(newPivotX, newPivotY);
				sprite.setRotation(object.angle);
				
				sprite.setScale(object.scale.x, object.scale.y);
				
				
				
				if (object.ref.file == 0) {
					
					TextureRegion current = maskAnimation.getKeyFrame(maskAnimationTime);
					current.getTexture().bind(2);
			
					Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
					batch.setShader(Shaders.instance.maskShader);
					//batch.draw(sprite.getTexture(), 800, 0, sprite.getTexture().getWidth()/2.75f, sprite.getTexture().getHeight()/2.75f);
					sprite.draw(batch);
					batch.setShader(null);
				}
				else {
					sprite.draw(batch);
				}
				
				
				
			}
		}
		
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
		
		float red2 = 100f/255f;
		float green2 = 200f/255f;
		float blue2 = 255f/255f;
		
		
		if (current.getClass() == Sun.class) {
			
			day = true;
			
			astral_position = (current.sprite.getX() +current.sprite.getWidth()/2  -TG.Display.WIDTH*2.5f)/(200f);
			
			if (Math.abs(astral_position) < 0.7f) {
				// COLOR NORMAL
			}
			else if (Math.abs(astral_position) < 1f) {
				float culmen = 0.7f + (1f - 0.7f)/2;
				red = ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*0.4f;
				
				red2 = (100f + ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*155f)/255f;
				green2 = (200f - ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*100f)/255f;
				blue2 = (255f - ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*200f)/255f;
				
				screen.bgTab2.setColor(200f/255f, 100f/255f, 100f/255f, 1f);

				if (Math.abs(astral_position) > (1f -(1f - 0.7f)/2)) {
					blue = (Math.abs(astral_position) - (1f -(1f - 0.7f)/2))/((1f - 0.7f)/2)*0.5f;
					
					red2 = (0f + ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*255f)/255f;
					green2 = (0f + ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*100f)/255f;
					blue2 = (0f + ((1f - 0.7f)/2 - Math.abs(Math.abs(astral_position)-culmen))/((1f - 0.7f)/2)*55f)/255f;
				}
				
				
			}
			else {
				// DE NOCHE
				
				day = false;
				
				blue = 0.5f;
				
				red2 = 0f;
				green2 = 0f;
				blue2 = 0f;
			}
			
			
		}
		else {
			// DE NOCHE
			
			day = false;
			
			blue = 0.5f;

			red2 = 0f;
			green2 = 0f;
			blue2 = 0f;
		}
		
		s.setColor(1f -green -blue, 1f -red -blue, 1f -red -green, 1f);
		screen.bgTab2.setColor(red2, green2, blue2, 1f);
		
	}
	
	public void checkDraw(Physical p, Batch batch) {
		
		
		if ((p.sprite.getX() +p.sprite.getWidth()/2 -p.sprite.getWidth()/2*Math.abs(p.sprite.getScaleX()) +p.sprite.getHeight()/2 -p.sprite.getHeight()/2*Math.abs(p.sprite.getScaleY())) < (TG.Display.WIDTH*2.0f)
				|| p.sprite.getX() +p.sprite.getWidth()/2 -p.sprite.getWidth()/2*Math.abs(p.sprite.getScaleX()) +p.sprite.getHeight()/2 -p.sprite.getHeight()/2*Math.abs(p.sprite.getScaleY()) > (TG.Display.WIDTH*3.1f) 
				|| p.sprite.getY() < (-p.sprite.getHeight())) {
			// NO SE DIBUJA
		}
		else {
			if (p.getClass() != Moon.class && p.getClass() != Sun.class) {
				// SE TINTAN
				light(p.sprite);
			}
			
			p.draw(batch);
			
			screenVisible = true;
		}
		
	}

	public void pan(float x, float y, float deltaX, float deltaY) {
		
		inertia += deltaX*(40f/480f);
		if (inertia > 60) { inertia = 60; }
		else if (inertia < -60) { inertia = -60; }
		
	}
}
