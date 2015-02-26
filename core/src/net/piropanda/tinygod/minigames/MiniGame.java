package net.piropanda.tinygod.minigames;

import net.piropanda.tinygod.gamestates.MiniGames;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;


public class MiniGame extends Group {

	public void load() {
	}
	
	public void act(float dt) {
		super.act(dt);
	}
	
	public void pan() {
	}
	
	public void tap() {
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
	public void unload() {
		MiniGames.instance.unload();
	}
	
}
