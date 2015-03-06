package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;


public class Human extends Physical {
	
	private Earth planet;
	private float variation_color;
	

	public Human(Earth planet, float radius, float angle) {
		this.planet = planet;
		this.radius = radius;
		this.angle = angle;
		
		variation_color = (float) (-1 +Math.random()*2);
		
		speed = (float) (0.25 + Math.random()*0.1);
		if (Math.random() > 0.5) {
			speed = -speed;
		}
		
		if (Math.random() > 0.5f) {
			sprite = new Sprite(TG.Graphics.assets.get("earth/AdamMini.png", Texture.class));
		}
		else {
			sprite = new Sprite(TG.Graphics.assets.get("earth/EveMini.png", Texture.class));
		}
		
		sprite.setScale(1f/4f);
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);

	}
	
	public void act(float dt) {
		super.act(dt);
		
		origin_x = planet.earth.getX() +planet.earth.getWidth()/2*planet.earth.getScaleX() -sprite.getWidth()/2;
		origin_y = planet.earth_y + planet.earth_width/2 -sprite.getHeight()/2;
		
		
		if (speed < 0) {
			sprite.setScale(-Math.abs(sprite.getScaleX()), sprite.getScaleY());
		}
		else if (speed > 0) {
			sprite.setScale(Math.abs(sprite.getScaleX()), sprite.getScaleY());
		}
		
		
		angle += speed*Gdx.graphics.getDeltaTime()*(20.0f);
		
		radius += -0.75 + Math.random()*1.5;
		if (radius > (planet.earth_width/2)*planet.earth_scale) {
			radius = (planet.earth_width/2)*planet.earth_scale;
		}
		if (radius < (planet.earth_width/2)*planet.earth_scale*(7f/10f)) {
			radius = (planet.earth_width/2)*planet.earth_scale*(7f/10f);
		}
		
		sprite.setRotation(planet.earth_rotation +angle -90);
		

		
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(planet.earth_rotation+angle))*(radius + sprite.getWidth()/2*Math.abs(sprite.getScaleX())) ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(planet.earth_rotation+angle))*(radius + sprite.getWidth()/2*Math.abs(sprite.getScaleX())) ));

		
		
	}

	@Override
	public void draw(Batch batch) {

		batch.setShader(Shaders.instance.hueShader);
		Shaders.instance.hueShader.setUniformf("hue", variation_color);
		//Shaders.instance.hueShader.setUniformf("saturation", variation_color);
		sprite.draw(batch);
		batch.setShader(null);
		
	}

}
