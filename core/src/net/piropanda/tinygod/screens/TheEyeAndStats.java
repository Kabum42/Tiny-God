package net.piropanda.tinygod.screens;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TheEyeAndStats extends Screen {

	private Texture bg;
	
	
	public TheEyeAndStats() {
		bg = TG.Graphics.assets.get("eye/bg.png", Texture.class);
	}

	@Override
	public void update() {
	}
	
	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(bg, 0, 0, TG.Display.WIDTH, TG.Display.HEIGHT);
	}
	
}
