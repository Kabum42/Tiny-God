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
		
		//radius = 130 + (float)Math.random()*50;
		
		variation_color = (float) (-0.15f + Math.random()*0.3f);
		
		sprite = new Sprite(TG.assets.get("mouth.png", Texture.class));
		sprite.setScale(1f/2.75f);
		
		
	}
	
	public void act(float dt) {
		
		float angle = 0;
		
		if (position <= 17) {
			
			radius = 180;
			
			if (screen.mouths.size() > 17) {
				angle = ((float)(position+1f)/(float)17)*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)screen.mouths.size())*360f;
			}
		}
		else if (position <= 30) {
			
			radius = 140;
			
			if (screen.mouths.size() > 30) {
				angle = ((float)(position+1f)/(float)(30-17))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()-18))*360f;
			}
		}
		else if (position <= 40) {
			
			radius = 100;
			
			if (screen.mouths.size() > 40) {
				angle = ((float)(position+1f)/(float)(40-30))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()-31))*360f;
			}
			
			
		}
		
		
		
		sprite.setRotation(screen.mouth_rotation +angle -90);
		
		//System.out.println(screen.mouth_rotation);
		
		
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation+angle))*(radius) -sprite.getWidth()/2 ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

		
	}
	
	public void draw(Batch batch, float parentAlpha) {
		
		if (position <= 40) {
			batch.setShader(Shaders.instance.hueShader);
			Shaders.instance.hueShader.setUniformf("hue", variation_color);
			//Shaders.instance.hueShader.setUniformf("saturation", variation_color);
			sprite.draw(batch);
			batch.setShader(null);
		}
		
	}

}
