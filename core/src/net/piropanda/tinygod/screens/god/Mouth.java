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
		//sprite.setScale(sprite.getScaleX()/2);
		
		
	}
	
	public void act(float dt) {
		
		if (screen.mouths.size() >= 1 && screen.mouths.size() <= 3) {
			patternDavid();
		}
		else if (screen.mouths.size() >= 4 && screen.mouths.size() <= 60) {
			patternWiggle();
		}
		else if (screen.mouths.size() >= 61 && screen.mouths.size() <= 100) {
			patternWarp();
		}
		else {
			patternUniverse();
		}
		

		

	}
	
	public void patternDavid() {
		
		float angle = 0;
		
		if (position < 3) {

			radius = 170;
			
			if (screen.mouths.size() > 3) {
				angle = ((float)(position+1f)/(float)(3))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()))*360f;
			}
			
			
			sprite.setScale(1f/2.75f);
			
			sprite.setRotation(-screen.mouth_rotation +angle -90);
			
			sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation+angle))*(radius) -sprite.getWidth()/2 ));
			sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

		}
		else if (position < 6) {
			
			radius = 170;
			

			if (screen.mouths.size() > 6) {
				angle = ((float)(position+1f)/(float)(3))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()-3))*360f;
			}
				
			angle+= 180;

			
			sprite.setScale(1f/2.75f);
			
			sprite.setRotation(screen.mouth_rotation +angle -90);
			
			sprite.setX((float) (origin_x + Math.cos(Math.toRadians(-screen.mouth_rotation+angle))*(radius) -sprite.getWidth()/2 ));
			sprite.setY((float) (origin_y + Math.sin(Math.toRadians(-screen.mouth_rotation+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));
			
		}
		
		
}
	
public void patternWiggle() {

		float angle = 0;
		

		angle = ((float)(position)/(float)(screen.mouths.size()))*360f;
		
		if (angle >= 360) {
			angle -= 360;
		}
		else if (angle < 0) {
			angle += 360;
		}

		
		float aux = -screen.mouth_rotation4+angle;
		// 20 es el numero de picos que tiene
		aux = ((float) Math.toRadians(aux))*20f;
		
		radius = (float) (160 -Math.cos(aux)*20f);
		
		float amount = 30f/screen.mouths.size();
		if (amount > 1.5f) {
			amount = 1.5f;
		}
		if (amount < 0.6f) {
			amount = 0.6f;
		}
		
		sprite.setScale((float) (1f*amount/(2.75f*(1.5f + Math.cos(aux)*0.25f))));
		
		sprite.setRotation(screen.mouth_rotation4 +angle -90);
		
		sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation4+angle))*(radius) -sprite.getWidth()/2 ));
		sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation4+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));
}
	
public void patternWarp() {
		
		float angle = 0;
		
		if (position < 10) {

			radius = 120;
			
			if (screen.mouths.size() > 10) {
				angle = ((float)(position+1f)/(float)(10))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()))*360f;
			}
			
			float aux = -screen.mouth_rotation+angle;
			// 20 es el numero de picos que tiene
			float spikes = screen.mouths.size()%10f;
			if (spikes == 0) { spikes = 10f; }
			aux = ((float) Math.toRadians(aux))*spikes;
			
			radius = (float) (radius -Math.cos(aux)*spikes);
			
			float amount = 30f/10f;
			if (amount > 1.5f) {
				amount = 1.5f;
			}
			
			sprite.setScale((float) (1f*amount/(2.75f*(1.5f + Math.cos(aux)*0.25f))));
			
			sprite.setRotation(screen.mouth_rotation +angle -90);

			
			sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation+angle))*(radius) -sprite.getWidth()/2 ));
			sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

		}
		else if (position < 30) {
			
			radius = 150;
			
			if (screen.mouths.size() > 30) {
				angle = ((float)(position+1f)/(float)(30-10))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()-11))*360f;
			}
			
			float aux = -screen.mouth_rotation2+angle;
			// 20 es el numero de picos que tiene
			float spikes = screen.mouths.size()%15f;
			if (spikes == 0) { spikes = 15f; }
			aux = ((float) Math.toRadians(aux))*spikes;
			
			radius = (float) (radius -Math.cos(aux)*spikes);
			
			float amount = 30f/30f;
			if (amount > 1.5f) {
				amount = 1.5f;
			}
			
			sprite.setScale((float) (1f*amount/(2.75f*(1.5f + Math.cos(aux)*0.25f))));
			
			sprite.setRotation(screen.mouth_rotation2 +angle -90);

			
			sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation2+angle))*(radius) -sprite.getWidth()/2 ));
			sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation2+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

			
		}
		else if (position < 60) {
			
			radius = 170;
			
			if (screen.mouths.size() > 60) {
				angle = ((float)(position+1f)/(float)(60-30))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()-31))*360f;
			}
			
			float aux = -screen.mouth_rotation3+angle;
			// 20 es el numero de picos que tiene
			float spikes = screen.mouths.size()%20f;
			spikes += 4f;
			if (spikes == 4) { spikes = 20f; }
			aux = ((float) Math.toRadians(aux))*spikes;
			
			radius = (float) (radius -Math.cos(aux)*spikes);
			
			float amount = 30f/60f;
			if (amount > 1.5f) {
				amount = 1.5f;
			}
			
			sprite.setScale((float) (1f*amount/(2.75f*(1.5f + Math.cos(aux)*0.25f))));
			
			sprite.setRotation(screen.mouth_rotation3 +angle -90);

			
			sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation3+angle))*(radius) -sprite.getWidth()/2 ));
			sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation3+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

		}
		else if (position < 100) {
			
			radius = 190;
			
			if (screen.mouths.size() > 100) {
				angle = ((float)(position+1f)/(float)(100-60))*360f;
			}
			else {
				angle = ((float)(position+1f)/(float)(screen.mouths.size()-61))*360f;
			}
			
			float aux = -screen.mouth_rotation4+angle;
			// 20 es el numero de picos que tiene
			float spikes = screen.mouths.size()%30f;
			spikes += 10f; 
			if (spikes == 10) { spikes = 30f; }
			aux = ((float) Math.toRadians(aux))*spikes;
			
			radius = (float) (radius -Math.cos(aux)*spikes);
			
			float amount = 30f/(float)screen.mouths.size();
			if (amount > 1.5f) {
				amount = 1.5f;
			}
			
			sprite.setScale((float) (1f*amount/(2.75f*(1.5f + Math.cos(aux)*0.25f))));
			
			sprite.setRotation(screen.mouth_rotation4 +angle -90);
			
			sprite.setX((float) (origin_x + Math.cos(Math.toRadians(screen.mouth_rotation4+angle))*(radius) -sprite.getWidth()/2 ));
			sprite.setY((float) (origin_y + Math.sin(Math.toRadians(screen.mouth_rotation4+angle))*(radius) +screen.getScrollPane().getVisualScrollY()));

		}
	}

	public void patternUniverse() {
		
	}
	
	public void draw(Batch batch, float parentAlpha) {
		

		batch.setShader(Shaders.instance.hueShader);
		Shaders.instance.hueShader.setUniformf("hue", variation_color);
		//Shaders.instance.hueShader.setUniformf("saturation", variation_color);
		sprite.draw(batch);
		batch.setShader(null);

		
	}

}
