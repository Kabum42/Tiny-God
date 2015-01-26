package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.codex.Codex;
import net.piropanda.tinygod.screens.creation.Creation;
import net.piropanda.tinygod.screens.god.God;
import net.piropanda.tinygod.screens.providence.Providence;
import net.piropanda.tinygod.screens.social.Social;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;

public class Ingame extends GameState {

	private SpriteBatch batch;
	private BitmapFont font;
	private OrthographicCamera camera;
	
	private Texture statusBar;
	
	// screen stuff
	private Screen[] screens;
	private int currentscreen;
	private float accumulatedX, accumulatedY;
	private boolean movingX, movingY;
	private static final int MINIMUM_MOVEMENT_THRESHOLD = 30;
	private static final int SWAPING_MOVEMENT_THRESHOLD = 120;
	
	
	public Ingame() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		camera = new OrthographicCamera(TG.Display.WIDTH, TG.Display.HEIGHT);
		camera.position.set(TG.Display.WIDTH * 2.5f, TG.Display.HEIGHT / 2, 0);

		screens = new Screen[] {
			new Codex(),
			new Providence(),
			new God(),
			new Creation(),
			new Social()
		};
		currentscreen = 2;
		
		statusBar = TG.Graphics.assets.get("status-bar.png", Texture.class);
		
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}
	
	@Override
	public void update() {
		// update screens
		for(int i=0; i<screens.length; i++) screens[i].update();
		
		// ease camera to current screen position
		if(!movingX) {
			float easingPos = TG.Display.WIDTH*currentscreen + TG.Display.WIDTH*0.5f;
			camera.position.x += (easingPos - camera.position.x) * 0.1f;
		}
		
		camera.update();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			// screens
			for(int i=0; i<screens.length; i++) screens[i].render(batch, font);
			// status bar
			float xx = camera.position.x - TG.Display.WIDTH/2;
			float yy = TG.Display.HEIGHT - statusBar.getHeight();
			batch.draw(statusBar, xx, yy);
			font.draw(batch, "Love: " + GameInfo.love, xx + 32, yy + 32);
			font.draw(batch, "LPS: " + GameInfo.lps, xx + 192, yy + 32);
		batch.end();
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {
		screens[currentscreen].tap(x, y);
		
		return true;
	}
	
	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		accumulatedX += deltaX; // the delta on the x-axis goes negative->positive from left to right
		accumulatedY -= deltaY; // the delta on the y-axis goes negative->positive from top to bottom
		
		if(Math.abs(accumulatedX) > Math.abs(accumulatedY) && Math.abs(accumulatedX) > MINIMUM_MOVEMENT_THRESHOLD) movingX = true;
		if(Math.abs(accumulatedX) < Math.abs(accumulatedY) && Math.abs(accumulatedY) > MINIMUM_MOVEMENT_THRESHOLD) movingY = true;
		
		if(movingX) camera.position.x -= deltaX;
		else if(movingY) screens[currentscreen].pan(x, y, deltaX, deltaY);
		
		return true;
	}
	
	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		if(accumulatedX > SWAPING_MOVEMENT_THRESHOLD) currentscreen--;
		if(accumulatedX < -SWAPING_MOVEMENT_THRESHOLD) currentscreen++;
		currentscreen = MathUtils.clamp(currentscreen, 0, 4);
		
		accumulatedX = 0;
		accumulatedY = 0;
		
		movingX = false;
		movingY = false;
		
		return true;
	}
	
}
