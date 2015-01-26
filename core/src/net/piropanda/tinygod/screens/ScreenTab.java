package net.piropanda.tinygod.screens;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenTab {

	protected float x;
	protected Texture bg;
	
	
	public ScreenTab(float x) {
		this.x = x;
		this.bg = TG.Graphics.assets.get("tab-bg.png", Texture.class);
	}
	
	public void tap(float tapx, float tapy) {
	}
	
	public void pan(float x, float y, float deltaX, float deltaY) {
	}
	
	public static boolean inside(float x, float y) {
		if(x >= 20 && x < TG.Display.WIDTH - 20 && y >= 120 && y < TG.Display.HEIGHT - 20) return true;
		return false;
	}
	
	public void update() {
	}
	
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(bg, x, 0);
	}
	
}
