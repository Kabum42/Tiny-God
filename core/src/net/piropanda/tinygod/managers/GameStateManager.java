package net.piropanda.tinygod.managers;

import net.piropanda.tinygod.TinyGod;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.IngameState;
import net.piropanda.tinygod.screens.LoaderState;

public class GameStateManager {

	public static final int LOADER_STATE = 0;
	public static final int INGAME_STATE = 1;

	private static Screen[] gameStates;
	private static Screen currentState;
	
	private static boolean pause;

	
	public GameStateManager() {
	}
	
	public static void init() {
        gameStates = new Screen[2];
 		gameStates[0] = new LoaderState();
 		gameStates[1] = new IngameState();
 		
 		currentState = gameStates[0];
 		
 		TinyGod.googleInterface.login();
	}

	public static void changeState(int state) {
		currentState = gameStates[state];
	}
	
	public static void update(float dt) {
		if(!pause) currentState.update(dt);
	}
	
	public static void render() {
		if(!pause) currentState.render();
	}
	
	public static void resize(int width, int height) {
		for(int i=0; i<gameStates.length; i++) gameStates[i].resize(width, height);
	}
	
	public static void pause() {
		pause = true;
		dispose();
	}
	
	public static void resume() {
		currentState = gameStates[0]; // loader
		((LoaderState)currentState).preload();
		pause = false;
	}
	
	public static void dispose() {
		TinyGod.assetManager.clear();
	}
	
	public static void load() {
		((IngameState)gameStates[INGAME_STATE]).load();
	}

}
