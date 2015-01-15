package net.piropanda.tinygod;

import net.piropanda.tinygod.managers.GameStateManager;
import net.piropanda.tinygod.GameInfo;

import com.badlogic.gdx.ApplicationAdapter;
import java.util.Locale;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
		
		GameStateManager.init();
	}
	
	private void loadLanguage() {
		// load and save the current language from json if possible
		String lang = Locale.getDefault().getLanguage() + Locale.getDefault().getCountry();
		/*
		if(lang.equals("ca_ES")) Lang.loadCatalan();
		else if(lang.equals("es_ES")) Lang.loadSpanish();
		else Lang.loadEnglish();
		*/
	}

	@Override
	public void render() {
		float dt = Gdx.graphics.getDeltaTime();
		
		GameStateManager.update(dt);
		GameStateManager.render();
	}
	
	@Override
	public void resize(int width, int height) {
		GameStateManager.resize(width, height);
	}
	
	@Override
	public void pause() {
//		GameStateManager.pause();
	}
	
	@Override
	public void resume() {
//		GameStateManager.resume();
	}
	
	@Override
	public void dispose() {
//		GameStateManager.dispose();
	}
	
	public boolean onBackPressed(){
		// Si devuelves true, la app se minimizará
		return true;
	}
	
}
