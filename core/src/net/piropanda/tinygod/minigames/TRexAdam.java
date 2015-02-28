package net.piropanda.tinygod.minigames;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TRexAdam extends MiniGame {
	
	private Sprite limit_up;
	private Sprite limit_bottom;
	private Sprite test;

	
	@Override
	public void load() {
		super.load();
		
		limit_up = new Sprite(TG.Graphics.assets.get("pixel.png", Texture.class));
		limit_up.setScale(TG.Display.HEIGHT *5, 10);
		limit_up.setColor(0, 0, 0, 1);
		limit_up.setX(-TG.Display.HEIGHT/2 +limit_up.getHeight()*limit_up.getScaleX()/2);
	    limit_up.setY(+TG.Display.WIDTH/2  +limit_up.getWidth()*limit_up.getScaleY()/2);
	    
	    limit_bottom = new Sprite(TG.Graphics.assets.get("pixel.png", Texture.class));
		limit_bottom.setScale(TG.Display.HEIGHT *5, 10);
		limit_bottom.setColor(0, 0, 0, 1);
		limit_bottom.setX(-TG.Display.HEIGHT/2 +limit_bottom.getHeight()*limit_bottom.getScaleX()/2);
		limit_bottom.setY(-TG.Display.WIDTH/2  -limit_bottom.getWidth()*limit_bottom.getScaleY()/2);
		
		test = new Sprite(TG.Graphics.assets.get("pixel.png", Texture.class));
		test.setScale(TG.Display.HEIGHT *5, TG.Display.WIDTH/3);
		test.setColor(0, 0.8f, 0.2f, 1);
		test.setX(-TG.Display.HEIGHT/2 +test.getHeight()*test.getScaleX()/2);
	    test.setY(-test.getWidth()*test.getScaleY());
		
	    System.out.println(test.getWidth()*test.getScaleY());
	    
	    Label label;
	    
	    for (int i = 0; i < (test.getWidth()*test.getScaleX())/100; i++) {
	    	label = new Label(""+i, TG.Graphics.skin);
			label.setColor(Color.BLACK);
			label.setX(-TG.Display.HEIGHT/2 +100*i);
			label.setY(-20);
			this.addActor(label);
	    }
	    
	    
		
		camera.rotate(90);
		
		//this.setRotation(90);
	}

	@Override
	public void act(float dt) {
	    super.act(dt);
	    camera.position.x += Gdx.graphics.getDeltaTime()*100;
	    camera.update();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		test.draw(batch);
		limit_up.draw(batch);
		limit_bottom.draw(batch);
	}
	
	@Override
	public void tap(float x, float y) {
		System.out.println("tapin");
	}
}
