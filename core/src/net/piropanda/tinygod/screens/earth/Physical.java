package net.piropanda.tinygod.screens.earth;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Physical extends Group {
	
	public Image sprite;
	public float radius;
	public float angle;
	
	public float origin_x;
	public float origin_y;
	
	public float speed;


	public void act(float dt) {
		super.act(dt);
	}

	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}


}
