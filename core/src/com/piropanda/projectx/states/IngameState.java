package com.piropanda.projectx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.GameInfo;
import com.piropanda.projectx.helpers.NumberFormatter;
import com.piropanda.projectx.screens.AchievementScreen;
import com.piropanda.projectx.screens.EyeScreen;
import com.piropanda.projectx.screens.ProducerScreen;
import com.piropanda.projectx.screens.Screen;
import com.piropanda.projectx.screens.StatScreen;
import com.piropanda.projectx.screens.UpgradeScreen;

public class IngameState extends GameState {

	private static final float MINIMUM_MOVEMENT_SENSIBILITY = 60f;
	private static final float SCREEN_SWAP_SENSIBILITY = 60f;
	
	// camera
	private OrthographicCamera camera;
	private BitmapFont font;
	private float easingPosition, accumulatedMovementX = 0f, accumulatedMovementY = 0f;
	public boolean movingOnX, movingOnY;
	// status bar camera
	private OrthographicCamera hud;
	// screens
	private Screen[] screens;
	private int currentScreen;
	// input
	private boolean lastTouch;
	public boolean touchDown, touchUpDown, touchDownUp;
	

	public IngameState() {
		super();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, ProjectX.DEFAULT_WIDTH, ProjectX.DEFAULT_HEIGHT);
		camera.position.x = ProjectX.DEFAULT_WIDTH * 2.5f;
		camera.update();
		
		hud = new OrthographicCamera();
		hud.setToOrtho(false, ProjectX.DEFAULT_WIDTH, ProjectX.DEFAULT_HEIGHT);
		hud.update();
		
		font = new BitmapFont();
		
		screens = new Screen[] {
			new StatScreen(ProjectX.DEFAULT_WIDTH * 0),
			new AchievementScreen(ProjectX.DEFAULT_WIDTH * 1),
			new EyeScreen(ProjectX.DEFAULT_WIDTH * 2),
			new ProducerScreen(ProjectX.DEFAULT_WIDTH * 3),
			new UpgradeScreen(ProjectX.DEFAULT_WIDTH * 4),
		};
		
		currentScreen = 2;
		easingPosition = screens[currentScreen].x + ProjectX.DEFAULT_WIDTH * 0.5f;
	}

	@Override
	public void update(float dt) {
		handleInput();

		for(int i=0; i<screens.length; i++) screens[i].update(this, camera);
		
		moveCameraY();
		moveCameraX();
		
		GameInfo.update(dt);
		lastTouch = touchDown;
	}
	
	private void handleInput() {
		touchDown = Gdx.input.isTouched();
		touchUpDown = !lastTouch && touchDown;
		touchDownUp = lastTouch && !touchDown;
	}
	
	private void moveCameraX() {
		if(touchDown && !movingOnY) {
			accumulatedMovementX += Gdx.input.getDeltaX();
			
			if(Math.abs(accumulatedMovementX) >= MINIMUM_MOVEMENT_SENSIBILITY) {
				camera.position.x -= Gdx.input.getDeltaX();
				movingOnX = true;
			}
			else easeToPosition();
			
		}
		else {			
			if(Math.abs(accumulatedMovementX) >= SCREEN_SWAP_SENSIBILITY) {
				if(accumulatedMovementX > 0) {
					currentScreen--;
				}
				else {
					currentScreen++;
				}
				
				camera.position.y = ProjectX.DEFAULT_HEIGHT * 0.5f;
			}

			if(currentScreen < 0) currentScreen = 0;
			if(currentScreen > 4) currentScreen = 4;
			easingPosition = currentScreen*ProjectX.DEFAULT_WIDTH + ProjectX.DEFAULT_WIDTH*0.5f;
			easeToPosition();

			movingOnX = false;
			accumulatedMovementX = 0f;
		}
		
//		if(camera.position.x < ProjectX.DEFAULT_WIDTH * 0.5f) camera.position.x = ProjectX.DEFAULT_WIDTH * 0.5f; // clamp camera position on the left
//		if(camera.position.x > ProjectX.DEFAULT_WIDTH * 4.5f) camera.position.x = ProjectX.DEFAULT_WIDTH * 4.5f; // clamp camera position on the right
		camera.update();
	}

	private void moveCameraY() {		
		if(touchDown && !movingOnX) {
			accumulatedMovementY += Gdx.input.getDeltaY();
			
			if(Math.abs(accumulatedMovementY) >= MINIMUM_MOVEMENT_SENSIBILITY) {
				movingOnY = true;
			}
			
			if(movingOnY) {
				screens[currentScreen].offset += Gdx.input.getDeltaY();
				if(screens[currentScreen].offset > 0) screens[currentScreen].offset = 0;
				if(screens[currentScreen].offset < screens[currentScreen].height) screens[currentScreen].offset = screens[currentScreen].height;
			}
		}
		else {
			movingOnY = false;
			accumulatedMovementY = 0;
		}
	}
	
	private void easeToPosition() {
		camera.position.x += (easingPosition - camera.position.x) * 0.1;
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// render screens
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(int i=0; i<screens.length; i++) screens[i].render(batch, font);
		batch.end();
		
		// render hud		
		batch.setProjectionMatrix(hud.combined);
		batch.begin();
		batch.draw(ProjectX.assetManager.get("status-bar.png", Texture.class), 0, 0, ProjectX.DEFAULT_WIDTH, 50);
		batch.draw(ProjectX.assetManager.get("heart16.png", Texture.class), 20, 16);
		batch.draw(ProjectX.assetManager.get("lps16.png", Texture.class), 200, 16);
		font.setColor(Color.BLACK);
		font.draw(batch, NumberFormatter.format(GameInfo.love), 40, 30);
		font.draw(batch, NumberFormatter.format(GameInfo.lps), 220, 30);
		font.setColor(Color.WHITE);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
	}

	@Override
	public void dispose() {
		super.dispose();
		
		font.dispose();
	}
	
	public boolean onBackPressed() {
		return true;
	}
	
	public void load() {
		((ProducerScreen)screens[3]).load(); // producer screen
	}
	
}
