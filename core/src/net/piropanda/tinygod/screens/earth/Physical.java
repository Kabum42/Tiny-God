package net.piropanda.tinygod.screens.earth;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Physical {
	
	public Sprite sprite;
	public float radius;
	public float angle;
	
	public float origin_x;
	public float origin_y;
	
	public float speed;


	public void act(float dt) {
		
	}

	public void draw(Batch batch) {
		//super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}


}
