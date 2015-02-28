package net.piropanda.tinygod.minigames;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.MiniGames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class MiniGame extends Group {

	private float timer;
	
	
	public void load() {
		this.setDebug(true, true);
		Table table = new Table(TG.Graphics.skin);
		table.setFillParent(true);
		Label label = new Label("test label", TG.Graphics.skin);
		label.setColor(Color.BLACK);
		table.add(label);
		
		this.addActor(table);

		this.addActor(new Image(new Texture(Gdx.files.internal("piropanda-logo.png"))));
		
		timer = 1f;
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		timer -= Gdx.graphics.getDeltaTime();
		if(timer <= 0) unload();
	}
	
	public void pan() {
	}
	
	public void tap() {
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		System.out.println("drawing");
	}
	
	public void unload() {
		MiniGames.instance.unload();
	}
	
}
