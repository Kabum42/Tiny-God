package net.piropanda.tinygod;

import net.piropanda.tinygod.managers.GameStateManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;

public class TinyGod extends ApplicationAdapter {
	
	// POL MOBILE RESOLUTION
	public static int DEFAULT_WIDTH = 320;
	public static int DEFAULT_HEIGHT = 480;
	
	// RUBEN MOBILE RESOLUTION
	//public static int DEFAULT_WIDTH = 480;
	//public static int DEFAULT_HEIGHT = 800;
	
	public static final String TITLE = "Tiny God";

	public static AssetManager assetManager = new AssetManager();
	public static GoogleInterface googleInterface;
	
	
	public TinyGod(GoogleInterface googleInterface) {
        TinyGod.googleInterface = googleInterface;
	}
	
	@Override
	public void create() {
		loadLanguage();
		GameInfo.loadFromJson("");

		GameStateManager.load();
	}
	
	private void loadLanguage() {
		// load and save the current language from Json if possible
//		String lang = Locale.getDefault().getLanguage() + Locale.getDefault().getCountry();
		
//		if(lang.equals("ca_ES")) Lang.loadCatalan();
//		else if(lang.equals("es_ES")) Lang.loadSpanish();
//		else Lang.loadEnglish();
	}

	@Override
	public void render() {
		GameStateManager.update();
		GameStateManager.render();
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
	
	public boolean onBackPressed(){
		// Si devuelves true, la app se minimizará
		return true;
	}
	
}
