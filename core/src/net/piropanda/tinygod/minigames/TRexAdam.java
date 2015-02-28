package net.piropanda.tinygod.minigames;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TRexAdam extends MiniGame {
	
	private Sprite test;
	private Label label;

	
	@Override
	public void load() {
		super.load();
		
		test = new Sprite(TG.Graphics.assets.get("earth/earth.png", Texture.class));
		test.setX(0);
	    test.setY(0);
		
	    label = new Label("Loading...", TG.Graphics.skin);
		label.setColor(Color.BLACK);
		label.setX(0);
		label.setY(0);
		this.addActor(label);
		
		this.setRotation(90);
	}

	@Override
	public void act(float dt) {
	    super.act(dt);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		test.draw(batch);
	}
}
