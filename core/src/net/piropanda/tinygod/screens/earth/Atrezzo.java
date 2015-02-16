package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;


public class Atrezzo extends Physical {
	
	private Earth planet;
	
	
	public Atrezzo(Earth planet, float radius, float angle, String type) {
		this.planet = planet;
		this.radius = radius;
		this.angle = angle;
		
		if (type == "tree") {
			sprite = new Sprite(TG.Graphics.assets.get("earth/tree.png", Texture.class));
		}
		
		origin_x = planet.earth_x + planet.earth_width/2 -sprite.getWidth()/2;
		origin_y = planet.earth_y +planet.earth_width/2 -sprite.getHeight()/2;
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);

	}
	
	public void act(float dt) {
		super.act(dt);
		
		origin_x = planet.earth_x + planet.earth_width/2 -sprite.getWidth()/2;
		origin_y = planet.earth_y + planet.earth_width/2 -sprite.getHeight()/2;
		
		sprite.setRotation(planet.earth_rotation +angle -90);
		
		x = (float) (origin_x + Math.cos(Math.toRadians(planet.earth_rotation+angle))*(radius + sprite.getWidth()/2*Math.abs(sprite.getScaleX())) );
		y = (float) (origin_y + Math.sin(Math.toRadians(planet.earth_rotation+angle))*(radius + sprite.getWidth()/2*Math.abs(sprite.getScaleX())) );
		
		sprite.setX(x);
		sprite.setY(y);
	}


}
