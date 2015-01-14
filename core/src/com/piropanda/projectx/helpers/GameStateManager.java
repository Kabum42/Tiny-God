package com.piropanda.projectx.helpers;

import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.states.GameState;
import com.piropanda.projectx.states.IngameState;
import com.piropanda.projectx.states.LoaderState;

public class GameStateManager {

	public static final int LOADER_STATE = 0;
	public static final int INGAME_STATE = 1;

	private static GameState[] gameStates;
	private static GameState currentState;
	
	private static boolean pause;

	
	public GameStateManager() {
	}
	
	public static void init() {
        gameStates = new GameState[2];
 		gameStates[0] = new LoaderState();
 		gameStates[1] = new IngameState();
 		
 		currentState = gameStates[0];
 		
 		ProjectX.googleInterface.login();
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
		ProjectX.assetManager.clear();
	}
	
	public static void load() {
		((IngameState)gameStates[INGAME_STATE]).load();
	}

}
