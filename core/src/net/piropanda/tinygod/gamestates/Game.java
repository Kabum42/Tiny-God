package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.codex.Codex;
import net.piropanda.tinygod.screens.creation.Creation;
import net.piropanda.tinygod.screens.god.God;
import net.piropanda.tinygod.screens.providence.Providence;
import net.piropanda.tinygod.screens.store.Store;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Game extends Group implements GestureListener {

	public static final String NAME = "Game";
	public int mode = 0;
	
	// 0 = Normal
	// 1 = Sepia
	
	public ShaderProgram defaultShader = null;
	
	
	
	private static final int SCREEN_SWAP_THRESHOLD = 100;
	
	public static Game instance = new Game();
	
	private Screen[] screens;
	public Codex codex;
	public Providence providence;
	public God god;
	public Creation creation;
	public Store store;
	
	public Sprite background_parallax;
	
	private boolean init;
	
	private float easingPosition;
	
	// screen swap
	private boolean movingX;
	private float accumulatedX;
	private int currentScreen;
	
	public Sound soundSlide;
	
	private Label label;
	private Image bg;
	private Sprite godBackground;
	private Image bg2;
	private Sprite top;
	
	
	public Game() {
		this.setName(NAME);
	}
	
	public void init() {
		GameInfo.reset();
		ProducerInfo.init();
		
		GameInfo.love = 1f;
		GameInfo.totalLove = 1f;
		
		soundSlide = TG.assets.get("common/slide.mp3", Sound.class);
		
		// background
		
		background_parallax = new Sprite(TG.assets.get("background_parallax.png", Texture.class));
		background_parallax.setScale(1f/2.75f, 1f/2.75f);
		background_parallax.setX(2.5f*TG.Display.WIDTH -background_parallax.getWidth()/2);
		background_parallax.setY(0.5f*TG.Display.HEIGHT -background_parallax.getHeight()/2);
		
		//bg = new Image(TG.assets.get("screen-background_01.png", Texture.class));
		//bg.setTouchable(Touchable.disabled);
		
		//godBackground = new Sprite(TG.assets.get("god-bg.png", Texture.class));
		//godBackground.setScale(1f/2.75f);
		//godBackground.setX((TG.Display.WIDTH*2f -godBackground.getWidth()/2 +godBackground.getWidth()/2*godBackground.getScaleX()));
		//godBackground.setY(0 -godBackground.getHeight()/2 +godBackground.getHeight()/2*godBackground.getScaleY());
		
		//bg2 = new Image(TG.assets.get("screen-background_02.png", Texture.class));
		//bg2.setX(TG.Display.WIDTH*3);
		//bg2.setTouchable(Touchable.disabled);
		
		top = new Sprite(TG.assets.get("top.png", Texture.class));
		top.setScale(1f/2.75f);
		top.setY(TG.Display.HEIGHT -top.getHeight()/2 -top.getHeight()/2*top.getScaleY());
		
		// screens
		screens = new Screen[5];
		
		screens[0] = codex = new Codex(this);
		screens[1] = providence = new Providence(this);
		screens[2] = god = new God(this);
		screens[3] = creation = new Creation(this);
		screens[4] = store = new Store(this);
		
		codex.setX(TG.Display.WIDTH 		* Codex.POSITION);
		providence.setX(TG.Display.WIDTH 	* Providence.POSITION);
		god.setX(TG.Display.WIDTH 			* God.POSITION);
		creation.setX(TG.Display.WIDTH 		* Creation.POSITION);
		store.setX(TG.Display.WIDTH 		* Store.POSITION);
		
		this.addActor(codex);
		this.addActor(providence);
		this.addActor(god);
		this.addActor(creation);
		this.addActor(store);
		
		//this.addActor(bg);
		//this.addActor(bg2);
		
		label = new Label("Love: ", TG.Graphics.skin); 
		//label.setFontScale(2f);
		label.setColor(90f/255f, 251f/255f, 163f/255f, 1f);
		label.setY(620);
		this.addActor(label);
		
		// 
		currentScreen = God.POSITION;
		
		// easing position
		teleportTo(currentScreen);
		
		init = true;
	}
	
	public void act(float dt) {
		if(!init) return;
		
		super.act(dt);
		
		GameInfo.update();
		
		//label.setText("Love: " + Math.floor(GameInfo.love));
		label.setText(TG.formattedNumber(GameInfo.love));
		label.pack();
		
		// ease camera to current screen position
		if(!movingX) {
			float easeTo = easingPosition - this.getStage().getCamera().position.x;
			this.getStage().getCamera().position.x += easeTo * 0.1f;
		}
		
		top.setX(this.getStage().getCamera().position.x -top.getWidth()/2);
		label.setX(top.getX() +top.getWidth()/2 -label.getWidth()/2);
		
		
		
		// limite es 1296 en ambos sentidos
		float margin_x = ((background_parallax.getWidth()*background_parallax.getScaleX() -TG.Display.WIDTH)/2f);
		float displacement_x = this.getStage().getCamera().position.x - 1080f;
		if (displacement_x > 1296) { displacement_x = 1296f; }
		else if (displacement_x < -1296) { displacement_x = -1296f; }
		displacement_x = -(displacement_x / 1296f)*margin_x;
		
		background_parallax.setX(this.getStage().getCamera().position.x -background_parallax.getWidth()/2 +displacement_x);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		if (mode == 0) {
			defaultShader = null;
		}
		else if (mode == 1) {
			defaultShader = Shaders.instance.vignetteShader;
		}
		
		batch.setShader(defaultShader);
		
		background_parallax.draw(batch, parentAlpha);
		
		if (Math.abs(this.getStage().getCamera().position.x - (currentScreen*TG.Display.WIDTH + TG.Display.WIDTH/2)) > 5) {
			for (int i = 0; i < screens.length; i++) {
				float min_x_camera = this.getStage().getCamera().position.x - TG.Display.WIDTH/2;
				float max_x_camera = this.getStage().getCamera().position.x + TG.Display.WIDTH/2;
				
				float min_x = i*TG.Display.WIDTH;
				float max_x = (i+1)*TG.Display.WIDTH;
				
				if (max_x > min_x_camera && min_x < max_x_camera) {
					screens[i].draw(batch, parentAlpha);
				}
			}
		}
		else {
			screens[currentScreen].draw(batch, parentAlpha);
		}
		
		
//		bg.draw(batch, parentAlpha);
//		godBackground.draw(batch, parentAlpha);
//		bg2.draw(batch, parentAlpha);
		top.draw(batch, parentAlpha);
		label.draw(batch, parentAlpha);
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
		if(!this.isVisible()) return false;
		
		screens[currentScreen].tap(x, y, count, button);
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
		
		if (Game.instance.isVisible()) {
			
			if(screens[currentScreen].canPan() && Math.abs(deltaX) > Math.abs(deltaY)) {
				accumulatedX += deltaX;
				movingX = true;
				
				this.getStage().getCamera().position.x -= deltaX;
				this.getStage().getCamera().update();
				
				this.getStage().cancelTouchFocus();
				
				return true;
			}
			else if (screens[currentScreen].canPan() && Math.abs(deltaX) < Math.abs(deltaY)) {
				screens[currentScreen].pan(x, y, deltaX, deltaY);
			}
			else if(!screens[currentScreen].canPan()) {
				screens[currentScreen].pan(x, y, deltaX, deltaY);
				return true;
			}
			
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
			soundSlide.play(1f);
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
