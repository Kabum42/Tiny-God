package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.codex.Codex;
import net.piropanda.tinygod.screens.creation.Creation;
import net.piropanda.tinygod.screens.earth.Earth;
import net.piropanda.tinygod.screens.god.God;
import net.piropanda.tinygod.screens.providence.Providence;
import net.piropanda.tinygod.screens.store.Store;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Game extends Group implements GestureListener {

	public static final String NAME = "Game";
	
	private static final int SCREEN_SWAP_THRESHOLD = 100;
	
	public static Game instance = new Game();
	
	private Screen[] screens;
	public Codex codex;
	public Providence providence;
	public God god;
	public Creation creation;
	public Store store;
	
	//public Earth earth;
	
	private float easingPosition;
	
	
	// screen swap
	private boolean movingX;
	private float accumulatedX;
	private int currentScreen;
	
	
	public Game() {
		this.setName(NAME);
	}
	
	public void init() {
		// background
		Image bg = new Image(TG.Graphics.assets.get("screen-background.png", Texture.class));
		bg.setTouchable(Touchable.disabled);
		
		// screens
		screens = new Screen[5];
		
		screens[0] = codex = new Codex();
		screens[1] = providence = new Providence();
		screens[2] = god = new God();
		screens[3] = creation = new Creation();
		screens[4] = store = new Store();
		
		codex.setX(TG.Display.WIDTH * Codex.POSITION);
		providence.setX(TG.Display.WIDTH * Providence.POSITION);
		god.setX(TG.Display.WIDTH * God.POSITION);
		creation.setX(TG.Display.WIDTH * Creation.POSITION);
		store.setX(TG.Display.WIDTH * Store.POSITION);
		
		this.addActor(codex);
		this.addActor(providence);
		this.addActor(god);
		this.addActor(creation);
		this.addActor(store);
		
		this.addActor(bg); // add the background image after the 4 Screen 
		
		// 
		currentScreen = God.POSITION;
		
		// easing position
		teleportTo(currentScreen);
	}
	
	public void act(float dt) {
		if(!this.isVisible()) return;

		super.act(dt);
		
		// ease camera to current screen position
		if(!movingX) {
			float easeTo = easingPosition - this.getStage().getCamera().position.x;
			this.getStage().getCamera().position.x += easeTo * 0.1f;
		}
	}
	
	public void easeTo(int screen) {
		currentScreen = screen;
		easingPosition = currentScreen*TG.Display.WIDTH + TG.Display.WIDTH/2;
	}
	
	public void teleportTo(int screen) {
		easeTo(screen);
		this.getStage().getCamera().position.x = currentScreen*TG.Display.WIDTH + TG.Display.WIDTH/2;
	}
	
	/* Gesture detector */
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		if(screens[currentScreen].canPan && Math.abs(deltaX) > Math.abs(deltaY)) {
			accumulatedX += deltaX;
			movingX = true;
			
			this.getStage().getCamera().position.x -= deltaX;
			this.getStage().getCamera().update();
			
			this.getStage().cancelTouchFocus();
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		if(Math.abs(accumulatedX) >= SCREEN_SWAP_THRESHOLD) {
			if(accumulatedX > 0) currentScreen--;
			if(accumulatedX < 0) currentScreen++;
			currentScreen = MathUtils.clamp(currentScreen, 0, 4);
			
//			easingPosition = currentScreen*TG.Display.WIDTH + TG.Display.WIDTH/2;
			easeTo(currentScreen);
		}
		
		accumulatedX = 0;
		movingX = false;
		
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
	
}
