package net.piropanda.tinygod.minigames.trexadam;

import java.util.ArrayList;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.minigames.MiniGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TRexAdam extends MiniGame {
	
	public float game_speed = 200f;
	
	private Sprite limit_up;
	private Sprite limit_bottom;
	private Sprite land;
	private Sprite adam;
	private Sprite trex;
	
	private boolean jumping = false;
	private float acceleration = 0f;
	
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	@Override
	public void load() {
		super.load();
		
		limit_up = new Sprite(TG.assets.get("pixel.png", Texture.class));
		limit_up.setScale(TG.Display.HEIGHT *5, 10);
		limit_up.setColor(0, 0, 0, 1);
		limit_up.setX(-TG.Display.HEIGHT/2 +limit_up.getHeight()*limit_up.getScaleX()/2);
	    limit_up.setY(+TG.Display.WIDTH/2  +limit_up.getWidth()*limit_up.getScaleY()/2);
	    
	    limit_bottom = new Sprite(TG.assets.get("pixel.png", Texture.class));
		limit_bottom.setScale(TG.Display.HEIGHT *5, 10);
		limit_bottom.setColor(0, 0, 0, 1);
		limit_bottom.setX(-TG.Display.HEIGHT/2 +limit_bottom.getHeight()*limit_bottom.getScaleX()/2);
		limit_bottom.setY(-TG.Display.WIDTH/2  -limit_bottom.getWidth()*limit_bottom.getScaleY()/2);
		
		land = new Sprite(TG.assets.get("pixel.png", Texture.class));
		land.setScale(TG.Display.HEIGHT *5, TG.Display.WIDTH/3);
		land.setColor(0, 0.8f, 0.2f, 1);
		land.setX(-TG.Display.HEIGHT/2 +land.getHeight()*land.getScaleX()/2);
	    land.setY(-land.getWidth()*land.getScaleY());
	    
	    adam = new Sprite(TG.assets.get("pixel.png", Texture.class));
		adam.setScale(50, 100);
		adam.setColor(0, 0, 0.7f, 1);
		adam.setX(0);
		adam.setY(-50);
		
		trex = new Sprite(TG.assets.get("pixel.png", Texture.class));
		trex.setScale(100, 200);
		trex.setColor(0.7f, 0, 0, 1);
		trex.setX(-250);
		trex.setY(-50);
		
	    
	    Label label;
	    
	    for (int i = 0; i < (land.getWidth()*land.getScaleX())/200; i++) {
	    	label = new Label(""+i, TG.Graphics.skin);
			label.setColor(Color.BLACK);
			label.setX(-TG.Display.HEIGHT/2 +200*i);
			label.setY(-20);
			this.addActor(label);
			
			Obstacle o = new Obstacle(-TG.Display.HEIGHT/2 +200*i, -100);
			obstacles.add(o);
	    }
	    
	    
		
		camera.rotate(90);
		
		//this.setRotation(90);
	}

	@Override
	public void act(float dt) {
	    super.act(dt);
	    
	    camera.position.x += Gdx.graphics.getDeltaTime()*game_speed;
	    camera.update();
	    
	    trex.setX(trex.getX() + Gdx.graphics.getDeltaTime()*game_speed);
	    adam.setX(adam.getX() + Gdx.graphics.getDeltaTime()*game_speed);
	    
	    if (jumping) {
	    	
	    	acceleration -= 2000 * Gdx.graphics.getDeltaTime();
	    	adam.setY(adam.getY() +acceleration*Gdx.graphics.getDeltaTime());
	    	
	    	if (adam.getY() <= -70) {
	    		adam.setY(-70);
		    	jumping = false;
	    	}
	    }
	    
	    for (int i = 0; i < obstacles.size(); i++) {
	    	obstacles.get(i).update();
	    }
	    
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		land.draw(batch);
		
		for (int i = 0; i < obstacles.size(); i++) {
	    	obstacles.get(i).sprite.draw(batch);
	    }
		
		trex.draw(batch);
		adam.draw(batch);
		
		
		limit_up.draw(batch);
		limit_bottom.draw(batch);
	}
	
	@Override
	public void tap(float x, float y) {
		
	}
	
	@Override
	public void touchDown(float x, float y) {	
		if (!jumping) {
			acceleration = 550f;
			jumping = true;
		}
	}
}
