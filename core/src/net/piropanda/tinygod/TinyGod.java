package net.piropanda.tinygod;

import net.piropanda.tinygod.managers.GameStateManager;

import com.badlogic.gdx.ApplicationAdapter;

public class TinyGod extends ApplicationAdapter {
	
	@Override
	public void create () {
		GameStateManager.load();
	}

	@Override
	public void render () {
		GameStateManager.update();
		GameStateManager.render();
	}
}
