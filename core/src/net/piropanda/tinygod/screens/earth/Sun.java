package net.piropanda.tinygod.screens.earth;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Sun extends Physical {
	
	private Sprite sprite;
	
	public Sun(Sprite planet2, float radius2, float angle2) {
		
		planet = planet2;
		radius = radius2;
		angle = angle2;
		
		speed = (float) (-0.2f);
		
		sprite = new Sprite(TG.Graphics.assets.get("sun.png", Texture.class));
		sprite.setScale((1.5f/10f), (1.5f/10f));
		sprite.setOriginCenter();
		
		origin_x = planet.getX() + planet.getWidth()/2 -sprite.getWidth()/2;
		origin_y = planet.getY() + planet.getHeight()/2 -sprite.getHeight()/2;
		
		
		sprite.setX(origin_x);
		sprite.setY(origin_y);
		
		sprite.setColor(new Color((float) 1, 1, 0, 1));
		
		
	}
	
	public void update() {
		
		
		
		angle += speed*Gdx.graphics.getDeltaTime()*(20.0f);
		

		sprite.setRotation(planet.getRotation() +angle -90);
		sprite.setX(origin_x);
		sprite.setX((float) (origin_x + 0.5f*(Math.cos(Math.toRadians(planet.getRotation()+angle))*(radius + sprite.getWidth()/2*sprite.getScaleX())) ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(planet.getRotation()+angle))*(radius + sprite.getWidth()/2*sprite.getScaleX()) ));
		
	}

	public void draw(SpriteBatch batch) {
		
		sprite.draw(batch);
		
	}

}
