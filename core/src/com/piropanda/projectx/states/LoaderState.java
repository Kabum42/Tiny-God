package com.piropanda.projectx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.piropanda.projectx.Lang;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.GameStateManager;

public class LoaderState extends GameState {

	private BitmapFont font;
	private ShapeRenderer sr;
	
	private Sprite pirologo;
	private boolean preloaded, loaded;
	
	
	public LoaderState() {
		super();
		
		batch = new SpriteBatch();	
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		sr = new ShapeRenderer();
		
		loadLogo();
	}

	public boolean isLoaded() { return loaded; }
	
	private void loadLogo() {
		pirologo = new Sprite(new Texture(Gdx.files.internal("piropanda-logo.png")));
		pirologo.scale(-0.5f);
		pirologo.setX((ProjectX.DEFAULT_WIDTH - pirologo.getWidth()) * 0.5f);
		pirologo.setY(ProjectX.DEFAULT_HEIGHT - pirologo.getHeight() + 90);
	}

	@Override
	public void update(float dt) {
		if(!preloaded) {
			preload();
		}
		
		if(ProjectX.assetManager.update()) {
			if(Gdx.input.justTouched()) {
				loaded = true;
				GameStateManager.changeState(GameStateManager.INGAME_STATE);
			}
		}
	}
	
	public void preload() {
		ProjectX.assetManager.load("lord-god.png", Texture.class);

		ProjectX.assetManager.load("status-bar.png", Texture.class);
		ProjectX.assetManager.load("heart16.png", Texture.class);
		ProjectX.assetManager.load("lps16.png", Texture.class);
		ProjectX.assetManager.load("total-lps16.png", Texture.class);

		ProjectX.assetManager.load("bg-stats.png", Texture.class);
		ProjectX.assetManager.load("bg-achievements.png", Texture.class);
		ProjectX.assetManager.load("bg-eye.png", Texture.class);
		ProjectX.assetManager.load("bg-producers.png", Texture.class);
		ProjectX.assetManager.load("bg-upgrades.png", Texture.class);
		
		ProjectX.assetManager.load("producer-black.png", Texture.class);
		ProjectX.assetManager.load("producer-seen.png", Texture.class);
		ProjectX.assetManager.load("producer-servant.png", Texture.class);
		ProjectX.assetManager.load("producer-human.png", Texture.class);
		ProjectX.assetManager.load("producer-prophet.png", Texture.class);
		ProjectX.assetManager.load("producer-temple.png", Texture.class);
		ProjectX.assetManager.load("producer-ship.png", Texture.class);
		ProjectX.assetManager.load("producer-factory.png", Texture.class);
		ProjectX.assetManager.load("producer-laboratory.png", Texture.class);
		ProjectX.assetManager.load("producer-hippievan.png", Texture.class);
		ProjectX.assetManager.load("producer-shop.png", Texture.class);
		ProjectX.assetManager.load("producer-spaceship.png", Texture.class);
		
		preloaded = true;
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		int barWidth = 240;
		int x =  (int) ((ProjectX.DEFAULT_WIDTH - barWidth) * 0.5);
		int y = 100;
		float progress = ProjectX.assetManager.getProgress();
		
		batch.begin();
		pirologo.draw(batch);
		font.draw(batch, Lang.LOADING + "... " + (int) (progress*100) + "%", x, y - 30);
		if(progress == 1f) font.draw(batch, Lang.TAP_TO_CONTINUE, x, y + 50);
		batch.end();

		sr.begin(ShapeType.Filled);
		sr.setColor(Color.PURPLE);
		sr.rect(x, y, progress*barWidth, 20);
		sr.end();
		
		sr.begin(ShapeType.Line);
		sr.setColor(Color.BLACK);
		sr.rect(x, y, barWidth, 20);
		sr.end();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		pirologo.getTexture().dispose();
		font.dispose();
		sr.dispose();
		
		loaded = false;
	}

}
