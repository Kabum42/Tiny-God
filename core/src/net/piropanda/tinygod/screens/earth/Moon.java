package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;


public class Moon extends Physical {
	
	private Earth planet;
	
	public Moon(Earth planet2, float radius2, float angle2) {
		
		planet = planet2;
		radius = radius2;
		angle = angle2;
		
		speed = (float) (-0.2f);
		
		sprite = new Sprite(TG.assets.get("earth/sun.png", Texture.class));
		sprite.setScale(3f/10f);
		
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);
		
		sprite.setColor(new Color((float) 1, 1, 1, 1));

	}
	
	public void act(float dt) {
		super.act(dt);
		
		origin_x = planet.earth.getX() +planet.earth.getWidth()/2*planet.earth.getScaleX() -sprite.getWidth()/2;
		origin_y = planet.earth_y + planet.earth_width/2 -sprite.getHeight()/2;
		
		angle += speed*Gdx.graphics.getDeltaTime()*(20.0f);

		sprite.setRotation(planet.earth_rotation +angle -90);
		sprite.setX(origin_x);
		sprite.setX((float) (origin_x + 0.5f*(Math.cos(Math.toRadians(planet.earth_rotation+angle))*(radius + sprite.getWidth()/2*sprite.getScaleX())) ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(planet.earth_rotation+angle))*(radius + sprite.getWidth()/2*sprite.getScaleX()) ));
	}


}
