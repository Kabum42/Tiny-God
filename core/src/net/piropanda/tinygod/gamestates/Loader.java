package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.managers.GameStateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Loader extends GameState {

	private SpriteBatch batch;
	private ShapeRenderer sr;
	private BitmapFont font;
	private Texture logo;
	
	
	public Loader() {
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		font = new BitmapFont();

		TG.Graphics.assets.load("piropanda-logo.png", Texture.class);
		TG.Graphics.assets.load("status-bar.png", Texture.class);
		TG.Graphics.assets.load("lord-god.png", Texture.class);
		TG.Graphics.assets.load("bg.png", Texture.class);
		TG.Graphics.assets.load("tab-bg.png", Texture.class);
		TG.Graphics.assets.load("tab-btn.png", Texture.class);
		// achievements
		TG.Graphics.assets.load("achievements/achievement-selector.png", Texture.class);
		TG.Graphics.assets.load("achievements/locked-achievement.png", Texture.class);
		TG.Graphics.assets.load("achievements/test.png", Texture.class);
		// producers
		TG.Graphics.assets.load("producers/locked-producer.png", Texture.class);
		TG.Graphics.assets.load("producers/factory.png", Texture.class);
		TG.Graphics.assets.load("producers/hippievan.png", Texture.class);
		TG.Graphics.assets.load("producers/human.png", Texture.class);
		TG.Graphics.assets.load("producers/laboratory.png", Texture.class);
		TG.Graphics.assets.load("producers/prophet.png", Texture.class);
		TG.Graphics.assets.load("producers/servant.png", Texture.class);
		TG.Graphics.assets.load("producers/ship.png", Texture.class);
		TG.Graphics.assets.load("producers/shop.png", Texture.class);
		TG.Graphics.assets.load("producers/spaceship.png", Texture.class);
		TG.Graphics.assets.load("producers/temple.png", Texture.class);
		
		TG.Graphics.assets.load("sun.png", Texture.class);
		TG.Graphics.assets.load("earth.png", Texture.class);
		TG.Graphics.assets.load("earth/AdamMini.png", Texture.class);
		TG.Graphics.assets.load("earth/EveMini.png", Texture.class);
		TG.Graphics.assets.load("tree.png", Texture.class);
	}
	
	@Override
	public void update() {
		if(logo == null && TG.Graphics.assets.isLoaded("piropanda-logo.png")) logo = TG.Graphics.assets.get("piropanda-logo.png", Texture.class);
		
		if(TG.Graphics.assets.update()) {
			if(Gdx.input.justTouched()) GameStateManager.init();
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float progress = TG.Graphics.assets.getProgress();
		int xx = 60;
		int yy = 80;
		int ww = 200;
		int hh = 30;
		
		batch.begin();
			if(logo != null) {
				int logosize = 256;
				int logox = (TG.Display.WIDTH - logosize) / 2;
				int logoy = TG.Display.HEIGHT - logosize - 30;
				batch.draw(logo, logox, logoy, logosize, logosize);
			}
			
			font.setColor(Color.BLACK);
			font.draw(batch, "progress: " + (int)(progress*100) + "%", xx, yy + hh + 20);
		batch.end();
		
		sr.begin(ShapeType.Line);
			sr.setColor(Color.BLACK);
			sr.rect(xx, yy, ww, hh);
		sr.end();
		
		sr.begin(ShapeType.Filled);
			sr.setColor(Color.PURPLE);
			sr.rect(xx, yy + 1, ww * progress - 1, hh - 1);
		sr.end();
	}
	
}
