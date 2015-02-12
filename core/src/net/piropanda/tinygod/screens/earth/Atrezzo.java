package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;


public class Atrezzo extends Physical {
	
	private Image planet;
	
	
	public Atrezzo(Image planet, float radius, float angle, String type) {
		this.planet = planet;
		this.radius = radius;
		this.angle = angle;
		
		if (type == "tree") {
			sprite = new Image(TG.Graphics.assets.get("earth/tree.png", Texture.class));
			sprite.setScale(0.40f, 0.40f);
		}
		
		sprite.setOrigin(Align.center);
		
		origin_x = planet.getX() + planet.getWidth()/2 -sprite.getWidth()/2;
		origin_y = planet.getY() +planet.getHeight()/2 -sprite.getHeight()/2;
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);

		this.addActor(sprite);
	}
	
	public void act(float dt) {
		super.act(dt);
		
		sprite.setRotation(planet.getRotation() +angle -90);
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(planet.getRotation()+angle))*(radius + sprite.getWidth()/2*Math.abs(sprite.getScaleX())) ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(planet.getRotation()+angle))*(radius + sprite.getWidth()/2*Math.abs(sprite.getScaleX())) ));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

}
