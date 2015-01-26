package net.piropanda.tinygod.screens.god;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Yahvy
 */
public class God extends Screen {
	
	private Texture bg;
	
	private Texture god;
	private float centerX, centerY, radius;
	
	
	public God() {
		Pixmap pix = new Pixmap(TG.Display.WIDTH, TG.Display.HEIGHT, Format.RGBA8888);
		pix.setColor(new Color(0xFF6370ff));
		pix.fill();
		pix.setColor(Color.BLACK);
		pix.drawRectangle(0, 0, TG.Display.WIDTH, TG.Display.HEIGHT);
		bg = new Texture(pix);
		pix.dispose();
		
		x = TG.Display.WIDTH * 2;
		
		god = TG.Graphics.assets.get("lord-god.png", Texture.class);
		centerX = TG.Display.WIDTH/2;
		centerY = 280;
		radius = 128;
	}
	
	@Override
	public void tap(float tapx, float tapy) {
		GameInfo.addLove(GameInfo.lovePerClick);
	}

	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
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
	}
	
	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(bg, x, 0);
		batch.draw(god, x + centerX - radius, centerY - radius, radius*2, radius*2);
		font.draw(batch, "GOD", x + 20, TG.Display.HEIGHT - 60);
	}
	
}
