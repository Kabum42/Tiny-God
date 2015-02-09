package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Atrezzo extends Physical {
	
	private Sprite planet;
	
	
	public Atrezzo(Sprite planet2, float radius2, float angle2, String type) {
		
		planet = planet2;
		radius = radius2;
		angle = angle2;
		
		
		if (type == "tree") {
			sprite = new Sprite(TG.Graphics.assets.get("earth/tree.png", Texture.class));
			sprite.setScale(0.40f, 0.40f);
		}
		
		sprite.setOriginCenter();
		
		origin_x = planet.getX() + planet.getWidth()/2 -sprite.getWidth()/2;
		origin_y = planet.getY() +planet.getHeight()/2 -sprite.getHeight()/2;
		
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);
		
		//sprite.setColor(new Color((float) Math.random(), (float) Math.random(), (float) Math.random(), 1));
		
		
	}
	
	public void update() {
		
		sprite.setRotation(planet.getRotation() +angle -90);
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(planet.getRotation()+angle))*(radius + sprite.getWidth()/2*sprite.getScaleX()) ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(planet.getRotation()+angle))*(radius + sprite.getWidth()/2*sprite.getScaleX()) ));
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}

}
