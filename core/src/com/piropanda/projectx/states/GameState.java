package com.piropanda.projectx.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState {
	
	protected SpriteBatch batch;
	
	
	public GameState() {
		batch = new SpriteBatch();
	}
	
	public void update(float dt) {
	}
	
	public void render() {
	}
	
	public void resize(int width, int height) {
	}
	
	public void dispose() {
		batch.dispose();
	}

}