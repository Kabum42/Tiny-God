package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Earth
 */
public class Earth extends Screen {
	
	private Texture bg;
	
	
	private Sprite earth;
	private Sprite human;
	
	private float human_x;
	private float human_y;
	
	
	public Earth() {
		Pixmap pix = new Pixmap(TG.Display.WIDTH, TG.Display.HEIGHT, Format.RGBA8888);
		pix.setColor(new Color(0xFF6370ff));
		pix.fill();
		pix.setColor(Color.BLACK);
		pix.drawRectangle(0, 0, TG.Display.WIDTH, TG.Display.HEIGHT);
		bg = new Texture(pix);
		pix.dispose();
		
		x = TG.Display.WIDTH * 4;
		
	
		earth = new Sprite(TG.Graphics.assets.get("earth.png", Texture.class));
		earth.setX(x + TG.Display.WIDTH/2 - earth.getWidth()/2);
		earth.setY(TG.Display.HEIGHT/2 - earth.getHeight()/2);
		earth.setOriginCenter();
		
		earth.setScale(0.5f, 0.5f);
		
		human = new Sprite(TG.Graphics.assets.get("human.png", Texture.class));
		human.setOriginCenter();
		
		human_x = x + TG.Display.WIDTH/2 - human.getWidth()/2;
		human_y = TG.Display.HEIGHT/2 - human.getHeight()/2;
		
		human.setScale(0.25f, 0.25f);
		
		
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
		earth.setRotation(earth.getRotation() + 1);
		if (earth.getRotation() > 360) {
			earth.setRotation(earth.getRotation() -360);
		}
		if (earth.getRotation() < 0) {
			earth.setRotation(earth.getRotation() +360);
		}
		
		human.setRotation(earth.getRotation() -90);
		human.setX((float) (human_x + Math.cos(Math.toRadians(earth.getRotation()))*((earth.getWidth()/2)*earth.getScaleX()+human.getWidth()/2*human.getScaleX()) ));
		human.setY((float) (human_y + Math.sin(Math.toRadians(earth.getRotation()))*((earth.getWidth()/2)*earth.getScaleX()+human.getWidth()/2*human.getScaleX()) ));
		System.out.println(Math.cos(Math.toRadians(earth.getRotation())));
	}
	
	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(bg, x, 0);
		earth.draw(batch);
		human.draw(batch);
		//batch.draw(god, x + centerX - radius, centerY - radius, radius*2, radius*2);
		//font.draw(batch, "GOD", x + 20, TG.Display.HEIGHT - 60);
	}
	
}
