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
	
	public TRexAdam() {
		
		test = new Sprite(TG.Graphics.assets.get("earth/earth.png", Texture.class));
		test.setX(100);
	    test.setY(100);
		
	    label = new Label("Loading...", TG.Graphics.skin);
		label.setColor(Color.BLACK);
		label.setX(150);
		label.setY(100);
		this.addActor(label);
		
		//this.setRotation(90);
	    
	}
	
	public void act(float dt) {
	    super.act(dt);
	    
	    
	}
	
	public void draw(Batch batch, float parentAlpha) {
		
		super.draw(batch, parentAlpha);
		test.draw(batch);
		
		//System.out.println(batch);

	}
}
