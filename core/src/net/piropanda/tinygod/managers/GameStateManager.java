package net.piropanda.tinygod.managers;

import net.piropanda.tinygod.gamestates.GameState;
import net.piropanda.tinygod.gamestates.Ingame;
import net.piropanda.tinygod.gamestates.Loader;

public class GameStateManager {

	public static GameState current, loader, ingame;
	
	
	public static void load() {
		loader = new Loader();
		change(loader);
	}
	
	public static void init() {
		ingame = new Ingame();
		change(ingame);
	}
	
	public static void change(GameState gs) {
		current = gs;
		update();
	}
	
	public static void update() {
		current.update();
	}

	public static void render() {
		current.render();
	}
	
}
