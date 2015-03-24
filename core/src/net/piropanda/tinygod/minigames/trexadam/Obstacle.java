package net.piropanda.tinygod.minigames.trexadam;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Obstacle extends Sprite {
	
	public Sprite sprite;
	
	public Obstacle(float x, float y) {
		
		sprite = new Sprite(TG.assets.get("pixel.png", Texture.class));
		sprite.setScale(30, 30);
		sprite.setColor(0.7f, 0, 0.7f, 1);
		sprite.setX(x);
		sprite.setY(y);
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

}
