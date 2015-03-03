package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.minigames.MiniGame;
import net.piropanda.tinygod.minigames.trexadam.*;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;

public class MiniGames extends Group implements GestureListener {

	public static MiniGames instance = new MiniGames();

	public static MiniGame test = new MiniGame();
	public static MiniGame tRexAdam = new TRexAdam();
	private MiniGame current;
	
	public TRexAdam trexadam;
	
	
	public void load(MiniGame miniGame) {
		Game.instance.setVisible(false);
		this.setVisible(true);
		
		current = miniGame;
		current.load();
		this.addActor(current);
	}

	@Override
	public void act(float dt) {
		super.act(dt);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
	public void unload() {
		this.removeActor(current);
		current = null;
		
		this.setVisible(false);
		Game.instance.setVisible(true);
	}

	/* Gesture Listener */
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(current == null) return false;
		
		current.tap(x, y);
		
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
		if(current == null) return false;
		
		current.pan(x, y, deltaX, deltaY);
		
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
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
