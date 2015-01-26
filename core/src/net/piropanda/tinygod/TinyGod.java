package net.piropanda.tinygod;

import net.piropanda.tinygod.managers.GameStateManager;

import com.badlogic.gdx.ApplicationAdapter;

public class TinyGod extends ApplicationAdapter {

	public static GoogleInterface googleInterface;
	
	
	public TinyGod(GoogleInterface googleInterface) {
        TinyGod.googleInterface = googleInterface;
	}
	
	@Override
	public void create() {
		GameStateManager.load();
		GameInfo.reset();
	}

	@Override
	public void render() {
		GameStateManager.update();
		GameStateManager.render();
		
		GameInfo.update();
	}
	
	@Override
	public void resize(int width, int height) {
	}
	
	@Override
	public void pause() {
	}
	
	@Override
	public void resume() {
	}
	
	@Override
	public void dispose() {
	}
	
	/**
	 * @return true if the application should minimize on a back button press, false otherwise
	 */
	public boolean onBackPressed(){
		return true;
	}
	
}
