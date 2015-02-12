package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;


public class Human extends Physical {
	
	private Image planet;
	
	private float radius_jump = 0;
	
	private float jumping_time = 0.15f;
	private float jumping;
	private boolean bool_jumping = false;
	
	
	public Human(Image planet, float radius, float angle) {
		this.planet = planet;
		this.radius = radius;
		this.angle = angle;
		
		jumping = (float) (-jumping_time + Math.random()*jumping_time*2);
		
		speed = (float) (0.25 + Math.random()*0.1);
		if (Math.random() > 0.5) {
			speed = -speed;
		}
		
		if (Math.random() > 0.5f) {
			sprite = new Image(TG.Graphics.assets.get("earth/AdamMini.png", Texture.class));
		}
		else {
			sprite = new Image(TG.Graphics.assets.get("earth/EveMini.png", Texture.class));
		}
		sprite.setScale((1f/4f), (1f/4f));
		sprite.setOrigin(Align.center);
		
		origin_x = planet.getX() + planet.getWidth()/2 -sprite.getWidth()/2;
		origin_y = planet.getY() +planet.getHeight()/2 -sprite.getHeight()/2;
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);

		this.addActor(sprite);
	}
	
	public void act(float dt) {
		super.act(dt);
		
		if (speed < 0) {
			sprite.setScale(-Math.abs(sprite.getScaleX()), sprite.getScaleY());
		}
		else if (speed > 0) {
			sprite.setScale(Math.abs(sprite.getScaleX()), sprite.getScaleY());
		}
		
		jumping -= Gdx.graphics.getDeltaTime();
		if (jumping < -jumping_time && !bool_jumping) {
			jumping = jumping_time;
			radius_jump = 3;
			bool_jumping = true;
		}
		else if (jumping < 0 && bool_jumping) {
			radius_jump = 0;
			bool_jumping = false;
		}
		
		angle += speed*Gdx.graphics.getDeltaTime()*(20.0f);
		
		radius += -0.75 + Math.random()*1.5;
		if (radius > (planet.getWidth()/2)*planet.getScaleX()) {
			radius = (planet.getWidth()/2)*planet.getScaleX();
		}
		if (radius < (planet.getWidth()/2)*planet.getScaleX()*(7f/10f)) {
			radius = (planet.getWidth()/2)*planet.getScaleX()*(7f/10f);
		}
		
		sprite.setRotation(planet.getRotation() +angle -90);
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(planet.getRotation()+angle))*(radius + radius_jump + sprite.getWidth()/2*sprite.getScaleX()) ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(planet.getRotation()+angle))*(radius + radius_jump + sprite.getWidth()/2*sprite.getScaleX()) ));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

}
