package net.piropanda.tinygod.screens.earth;

import java.util.ArrayList;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

/**
 * Earth
 */
public class Earth extends Screen {
	
	private Sprite bg;
	private Sprite earth;
	
	private ArrayList<Physical> physicals = new ArrayList<Physical>();
	private ArrayList<Physical> physicals_to_render = new ArrayList<Physical>();
	
	private float accumulatedX, accumulatedY;
	private boolean movingX, movingY;
	private static final int MINIMUM_MOVEMENT_THRESHOLD = 30;
	private static final int SWAPING_MOVEMENT_THRESHOLD = 120;
	
	
	public Earth() {
		/*
		canPan = false;

		x = TG.Display.WIDTH * 2;
		
		earth = new Sprite(TG.Graphics.assets.get("earth.png", Texture.class));
		earth.setScale(1.0f, 1.0f);
		earth.setX(x + TG.Display.WIDTH/2 - earth.getWidth()/2);
		float percent_earth_showing = 20;
		earth.setY(-earth.getHeight()/2 -earth.getHeight()*earth.getScaleY()*((50f - percent_earth_showing)/100f));
		//earth.setOriginCenter();
		
		int num_humans = 200;
		int num_capas = 5;

		

		
		
		for (int i = 0; i < num_humans; i++) {
			float radius_distance = 1;
			while (radius_distance >= 0.8) {
				radius_distance = (float) (((float) Math.pow(Math.random()*1, 5))/Math.pow(1, 5));
			}
			physicals.add(new Human(earth, (earth.getWidth()/2)*earth.getScaleX() - ((earth.getWidth()/2)*earth.getScaleX()*radius_distance), (float) (Math.random()*360)));
			//humans.add(new Human(earth, (earth.getWidth()/2)*earth.getScaleX() - ((earth.getWidth()/2)*earth.getScaleX()*0), (float) ((360/20)*i)));
		}
		
		
		for (int i = 0; i < 50; i++) {
			float radius_distance = 1;
			while (radius_distance >= 0.8) {
				radius_distance = (float) (((float) Math.pow(Math.random()*1, 5))/Math.pow(1, 5));
			}
			physicals.add(new Atrezzo(earth, (earth.getWidth()/2)*earth.getScaleX() - ((earth.getWidth()/2)*earth.getScaleX()*radius_distance), (float) (Math.random()*360), "tree"));
			//humans.add(new Human(earth, (earth.getWidth()/2)*earth.getScaleX() - ((earth.getWidth()/2)*earth.getScaleX()*0), (float) ((360/20)*i)));
		}
		
		*/
		
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
	
	@Override
	public void update() {
		
		earth.setRotation((float) (earth.getRotation() + Gdx.graphics.getDeltaTime()*(2.0f)));
		
		if (earth.getRotation() > 360) {
			earth.setRotation(earth.getRotation() -360);
		}
		if (earth.getRotation() < 0) {
			earth.setRotation(earth.getRotation() +360);
		}
		
		for (int i = 0; i < physicals.size(); i++) {
			physicals.get(i).update();
		}
		
	}
	
	@Override
	public void render(SpriteBatch batch, BitmapFont font) {

		//earth.draw(batch);
		//sortedHumansRendering(batch);
		

		
	}
	*/
	
	public void sortedHumansRendering(SpriteBatch batch) {
		
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
			next_physical.draw(batch);
			physicals_to_render.remove(next_physical);
		}
		
	}
	
}
