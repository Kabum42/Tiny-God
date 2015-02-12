package net.piropanda.tinygod.screens.earth;

import java.util.ArrayList;


import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.List;

/**
 * Earth
 */
public class Earth extends Screen {
	
	private ShaderProgram hueShader;
	
	private Sprite bg;
	private Sprite earth;
	
	private ArrayList<Physical> astrals = new ArrayList<Physical>();
	
	private ArrayList<Physical> physicals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals_to_render = new ArrayList<Physical>();
	
	private float accumulatedX, accumulatedY;
	private boolean movingX, movingY;
	private static final int MINIMUM_MOVEMENT_THRESHOLD = 30;
	private static final int SWAPING_MOVEMENT_THRESHOLD = 120;
	
	
	
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
		
		

		

		canPan = false;

		this.setX(TG.Display.WIDTH * 2);
		
		earth = new Sprite(TG.Graphics.assets.get("earth/earth.png", Texture.class));
		earth.setScale(1.0f, 1.0f);
		earth.setX(this.getX() + TG.Display.WIDTH/2 - earth.getWidth()/2);
		float percent_earth_showing = 20;
		earth.setY(-earth.getHeight()/2 -earth.getHeight()*earth.getScaleY()*((50f - percent_earth_showing)/100f));
		
		
		
		astrals.add(new Sun(earth, (earth.getWidth()/2)*earth.getScaleX()*(1.1f), 90));
		astrals.add(new Moon(earth, (earth.getWidth()/2)*earth.getScaleX()*(1.1f), 90 + 90));
		
		astrals.add(new Sun(earth, (earth.getWidth()/2)*earth.getScaleX()*(1.1f), 90 + 180));
		astrals.add(new Moon(earth, (earth.getWidth()/2)*earth.getScaleX()*(1.1f), 90 + 270));
		
		
		int num_humans = 200;
		int num_capas = 5;

		

		
		
		for (int i = 0; i < 50; i++) {
			float radius_distance = 1;
			while (radius_distance >= 0.8) {
				radius_distance = (float) (((float) Math.pow(Math.random()*1, 5))/Math.pow(1, 5));
			}
			physicals.add(new Atrezzo(earth, (earth.getWidth()/2)*earth.getScaleX() - ((earth.getWidth()/2)*earth.getScaleX()*radius_distance), (float) (Math.random()*360), "tree"));
		}
		
		for (int i = 0; i < num_humans; i++) {
			float radius_distance = 1;
			while (radius_distance >= 0.8) {
				radius_distance = (float) (((float) Math.pow(Math.random()*1, 5))/Math.pow(1, 5));
			}
			physicals.add(new Human(earth, (earth.getWidth()/2)*earth.getScaleX() - ((earth.getWidth()/2)*earth.getScaleX()*radius_distance), (float) (Math.random()*360)));
		}
		
		
		
		
		
		
	}
	
	/*
	@Override
	public void tap(float tapx, float tapy) {
		GameInfo.addLove(GameInfo.lovePerClick);
	}

	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		

		earth.setRotation(earth.getRotation() -deltaX*(0.25f));
		
	}

	@Override
	public boolean tab1BtnClicked(float tapx, float tapy) {
		return false;
	}

	@Override
	public boolean tab2BtnClicked(float tapx, float tapy) {
		return false;
	}
	*/
	
	public void act(float dt) {
	    super.act(dt);
	    
	    earth.setRotation((float) (earth.getRotation() + Gdx.graphics.getDeltaTime()*(2.0f)));
		
		if (earth.getRotation() > 360) {
			earth.setRotation(earth.getRotation() -360);
		}
		if (earth.getRotation() < 0) {
			earth.setRotation(earth.getRotation() +360);
		}
		
		for (int i = 0; i < astrals.size(); i++) {
			astrals.get(i).update();
		}
		
		for (int i = 0; i < physicals.size(); i++) {
			physicals.get(i).update();
		}
		
	}
	
	public void draw(Batch batch, float parentAlpha) {
	    
		super.draw(batch, parentAlpha);

	    
	    hueShader.begin();
		hueShader.setUniformf("hue", (float)(-1 + earth.getRotation()/180));
		hueShader.end();
		batch.setShader(hueShader);
		
		
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
			astrals.get(i).draw(batch, parentAlpha);
		}
		
		earth.draw(batch);
		
		sortedPhysicalsRendering(batch, parentAlpha);
		
	}
	
	/*
	@Override
	public void update() {
		
		
	}
	*/
	
	/*
	@Override
	public void render(SpriteBatch batch, BitmapFont font) {

		
		
		
		

		
	}
	*/
	
	
	public void sortedPhysicalsRendering(Batch batch, float parentAlpha) {
		
		
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
			next_physical.draw(batch, parentAlpha);
			physicals_to_render.remove(next_physical);
		}
		
	}
	
}
