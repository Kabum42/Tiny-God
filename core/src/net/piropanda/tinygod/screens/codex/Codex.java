package net.piropanda.tinygod.screens.codex;

import java.util.ArrayList;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.creation.Producer;
import net.piropanda.tinygod.screens.providence.Upgrade;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Codex extends Screen {

	public Game gameParent;
	public static final int POSITION = 0;
	
	private int upgradesPerRow = 4;
	
	private float customScroll = 0f;
	private float customScrollMax = 2000f;
	
	private float default_x = 0;
	private float default_y = 0;
	
	private float inertia = 0f;
	
	public Sound soundTap;
	
	private Sprite save_background;
	private Label save_label;
	
	private Sprite stats_background;
	private Label stats_label;
	
	private Sprite language_background;
	private Label language_label;
	
	private Sprite credits_background;
	private Label credits_label;
	
	public Sprite lastSpriteSelected = null;
	public Sprite spriteSelected = null;
	
	public float transition1 = 0f;
	public float transition2 = 0f;
	public float transition3 = 0f;
	public float transition_y = 0f;
	public float transition_x = 0f;
	
	public Codex(Game g) {
		super();
		
		gameParent = g;
		
		soundTap = TG.assets.get("common/tap.mp3", Sound.class);
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		default_x = 0.5f*TG.Display.WIDTH;
		default_y = TG.Display.HEIGHT/2  +120;
		
		float start_y = 60;
		float end_y = 500;
		float number_options = 4;
		number_options++;

		save_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		save_background.setScale(1f/2.75f, 1f/2.75f);
		save_background.setX(0.5f*TG.Display.WIDTH -save_background.getWidth()/2);
		save_background.setY((start_y + (end_y - start_y)*(1f - 1f/number_options)) -save_background.getHeight()/2);

		save_label = new Label("Save", TG.Graphics.font1);
		save_label.setColor(Color.WHITE);
		
		stats_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		stats_background.setScale(1f/2.75f, 1f/2.75f);
		stats_background.setX(0.5f*TG.Display.WIDTH -stats_background.getWidth()/2);
		stats_background.setY((start_y + (end_y - start_y)*(1f - 2f/number_options)) -stats_background.getHeight()/2);

		stats_label = new Label("Statistics", TG.Graphics.font1);
		stats_label.setColor(Color.WHITE);
		
		language_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_background.setScale(1f/2.75f, 1f/2.75f);
		language_background.setX(0.5f*TG.Display.WIDTH -language_background.getWidth()/2);
		language_background.setY((start_y + (end_y - start_y)*(1f - 3f/number_options)) -language_background.getHeight()/2);

		language_label = new Label("Language", TG.Graphics.font1);
		language_label.setColor(Color.WHITE);
		
		credits_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		credits_background.setScale(1f/2.75f, 1f/2.75f);
		credits_background.setX(0.5f*TG.Display.WIDTH -credits_background.getWidth()/2);
		credits_background.setY((start_y + (end_y - start_y)*(1f - 4f/number_options)) -credits_background.getHeight()/2);

		credits_label = new Label("Credits", TG.Graphics.font1);
		credits_label.setColor(Color.WHITE);

		
	}
	
	@Override
	public void act(float dt) {
		
		if (spriteSelected == null) {
			if (transition3 > 0f) {
				transition3 -= dt*10f;
				if (transition3 <= 0f) { transition3 = 0f;}
			}
			else if (transition2 > 0f) {
				transition2 -= dt*10f;
				if (transition2 <= 0f) { transition2 = 0f;}
				lastSpriteSelected.setY((default_y -lastSpriteSelected.getHeight()/2)*transition2 + transition_y*(1f - transition2));
				lastSpriteSelected.setX((default_x -lastSpriteSelected.getWidth()/2)*transition2 + transition_x*(1f - transition2));

			}
			else if (transition1 > 0f) {
				transition1 -= dt*10f;
				if (transition1 <= 0f) { 
					transition1 = 0f;
					lastSpriteSelected = null;
					}
			}
//			else {
//				inertia = inertia/1.05f;
//				customScroll += inertia;
//				if (customScroll > customScrollMax) { customScroll = customScrollMax; }
//				else if (customScroll < 0 ) { customScroll = 0; }
//			}
		}
		else {
			if (transition1 < 1f) {
				transition1 += dt*10f;
				if (transition1 >= 1f) { 
					transition1 = 1f; 
					transition_y = spriteSelected.getY();
					transition_x = spriteSelected.getX();
					}
			}
			else if (transition2 < 1f) {
				transition2 += dt*10f;
				if (transition2 >= 1f) { transition2 = 1f;}
				spriteSelected.setY((default_y -spriteSelected.getHeight()/2)*transition2 + transition_y*(1f - transition2));
				spriteSelected.setX((default_x -spriteSelected.getWidth()/2)*transition2 + transition_x*(1f - transition2));
			}
			else if (transition3 < 1f) {
				transition3 += dt*10f;
				if (transition3 >= 1f) { transition3 = 1f;}
			}
		}
		
		

		inertia = inertia/1.05f;
		customScroll += inertia;
		if (customScroll > customScrollMax) { customScroll = customScrollMax; }
		else if (customScroll < 0 ) { customScroll = 0; }
		
		
		save_label.pack();
		save_label.setX(save_background.getX() +save_background.getWidth()/2 - save_label.getWidth()/2);
		save_label.setY(save_background.getY() +save_background.getHeight()/2 - save_label.getHeight()/2);
		
		stats_label.pack();
		stats_label.setX(stats_background.getX() +stats_background.getWidth()/2 - stats_label.getWidth()/2);
		stats_label.setY(stats_background.getY() +stats_background.getHeight()/2 - stats_label.getHeight()/2);
		
		language_label.pack();
		language_label.setX(language_background.getX() +language_background.getWidth()/2 - language_label.getWidth()/2);
		language_label.setY(language_background.getY() +language_background.getHeight()/2 - language_label.getHeight()/2);
		
		credits_label.pack();
		credits_label.setX(credits_background.getX() +credits_background.getWidth()/2 - credits_label.getWidth()/2);
		credits_label.setY(credits_background.getY() +credits_background.getHeight()/2 - credits_label.getHeight()/2);
		
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		
		save_background.draw(batch, 1f);
		save_label.draw(batch, 1f);
		
		stats_background.draw(batch, 1f);
		stats_label.draw(batch, 1f);
		
		language_background.draw(batch, 1f);
		language_label.draw(batch, 1f);
		
		credits_background.draw(batch, 1f);
		credits_label.draw(batch, 1f);
		
		//super.draw(batch, parentAlpha);
	}
	
	public boolean tap(float x, float y, int count, int button) {

		if (spriteSelected == null && transition1 == 0f) {
			if (isOnSprite(save_background, x, y)) {
				//spriteSelected = save_background;
				soundTap.play(1f);
			}
			else if (isOnSprite(stats_background, x, y)) {
				spriteSelected = stats_background;
				soundTap.play(1f);
			}
			else if (isOnSprite(language_background, x, y)) {
				spriteSelected = language_background;
				soundTap.play(1f);
			}
			else if (isOnSprite(credits_background, x, y)) {
				spriteSelected = credits_background;
				soundTap.play(1f);
			}
		}
		else if (spriteSelected != null && transition3 == 1f) {
			//upgradeSelected.tap(x,  y, count, button);
			if (isOnSprite(spriteSelected, x, y)) {
				lastSpriteSelected = spriteSelected;
				spriteSelected = null;
				soundTap.play(1f);
			}
			
		}
		
		return false;
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		
		//if (upgradeSelected == null && transition1 == 0f) {
			inertia -= deltaY*(40f/480f);
			if (inertia > 60) { inertia = 60; }
			else if (inertia < -60) { inertia = -60; }
		//}
		
	}
	
		private boolean isOnSprite(Sprite s, float x, float y) {
		
		float first_x = s.getX() + s.getWidth()/2 -s.getWidth()/2*s.getScaleX();
		float second_x = s.getX() + s.getWidth()/2 +s.getWidth()/2*s.getScaleX();
		
		float first_y = s.getY() + s.getHeight()/2 +s.getHeight()/2*s.getScaleY();
		float second_y = s.getY() + s.getHeight()/2 -s.getHeight()/2*s.getScaleY();
		
		float modified_x = (x - TG.Display.whiteSpaceX)*(1f/TG.Display.scale) +TG.Display.WIDTH*POSITION;
		float modified_y = -((y -TG.Display.whiteSpaceY)*(1f/TG.Display.scale) -TG.Display.HEIGHT);
		
		if (modified_x >= first_x && modified_x <= second_x &&
				modified_y <= first_y && modified_y >= second_y) {
			return true;
		}
		
		return false;
	}
	
}
