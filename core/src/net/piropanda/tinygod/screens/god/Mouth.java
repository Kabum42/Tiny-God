package net.piropanda.tinygod.screens.god;

import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mouth {
	
	public God screen;
	public Sprite sprite;
	public float origin_x;
	public float origin_y;
	public int position;
	public float radius = 180;
	public float variation_color;
	
	public Mouth(God aux_screen, int aux_position, float aux_origin_x, float aux_origin_y) {
		
		screen = aux_screen;
		position = aux_position;
		origin_x = aux_origin_x;
		origin_y = aux_origin_y;
		
		variation_color = (float) (-0.15f + Math.random()*0.3f);
		
		sprite = new Sprite(TG.Graphics.assets.get("mouth.png", Texture.class));
		sprite.setScale(1f/2.75f);
		
		
	}
	
	public void act(float dt) {
		
		float angle = ((float)(position+1f)/(float)screen.mouths.size())*360f;
		
		sprite.setRotation(screen.mouth_rotation +angle -90);
		
		//System.out.println(screen.mouth_rotation);
		
		
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation+angle))*(radius) -sprite.getWidth()/2 ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

		
	}
	
	public void draw(Batch batch, float parentAlpha) {
		batch.setShader(Shaders.instance.hueShader);
		Shaders.instance.hueShader.setUniformf("hue", variation_color);
		sprite.draw(batch, parentAlpha);
		batch.setShader(null);
	}

}
