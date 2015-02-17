package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.minigames.MiniGame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class MiniGames extends Group {

	public static MiniGames instance = new MiniGames();

	public static MiniGame test = new MiniGame();
	private MiniGame current;
	
	
	public void load(MiniGame miniGame) {
		Game.instance.setVisible(false);
		this.setVisible(true);
		
		current = miniGame;
		current.load();
		this.addActor(current);
	}
	
	public void act(float dt) {
		super.act(dt);
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
	public void unload() {
		this.removeActor(current);
		current = null;
		
		this.setVisible(false);
		Game.instance.setVisible(true);
	}
	
}
