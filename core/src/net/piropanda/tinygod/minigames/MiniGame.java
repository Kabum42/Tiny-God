package net.piropanda.tinygod.minigames;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.MiniGames;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;


public class MiniGame extends Group {

	protected OrthographicCamera camera;
	
	
	public void load() {
		camera = new OrthographicCamera(TG.Display.WIDTH, TG.Display.HEIGHT);
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
	}
	
	public void pan() {
	}
	
	public void tap() {
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.setProjectionMatrix(camera.combined);
		super.draw(batch, parentAlpha);
	}
	
	public void unload() {
		MiniGames.instance.unload();
	}
	
}
