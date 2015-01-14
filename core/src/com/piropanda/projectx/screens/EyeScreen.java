package com.piropanda.projectx.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.GameInfo;
import com.piropanda.projectx.particles.EyeClickParticle;
import com.piropanda.projectx.states.IngameState;

public class EyeScreen extends Screen {

	private float eyeCenterX, eyeCenterY, eyeRadius;
	private ArrayList<EyeClickParticle> particles = new ArrayList<EyeClickParticle>();
	
	
	public EyeScreen(float x) {
		super(x);
		
		eyeCenterX = x + ProjectX.DEFAULT_WIDTH * 0.5f;
		eyeCenterY = 320;
		eyeRadius = 120;
	}
	
	@Override
	public void update(IngameState gs, OrthographicCamera camera) {		
		if(gs.touchDownUp && !gs.movingOnX && !gs.movingOnY) {
			// clicked on the eye
			float mouseX = Gdx.input.getX() + camera.position.x - ProjectX.DEFAULT_WIDTH * 0.5f;
			float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
			double dist = Math.sqrt(Math.pow((mouseX - eyeCenterX), 2) + Math.pow(mouseY - eyeCenterY, 2));
			
			if(dist < eyeRadius) {
				double value = GameInfo.loveClick;
				
				// add new particle
				boolean crit = false;
				
				if(MathUtils.random() < 0.1) {
					value *= 10.0;
					crit = true;
				}
				
				GameInfo.love += value;
				GameInfo.totalLove += value;
				GameInfo.clicks++;
				
				particles.add(new EyeClickParticle((int) mouseX, (int) mouseY, value, crit));
			}
		}
		
		// update particles
		for(int i=0; i<particles.size(); i++) {
			particles.get(i).update(Gdx.graphics.getDeltaTime());
			if(particles.get(i).isDead()) particles.remove(i);
		}
	}
	
	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		// draw the screen background
		batch.draw(ProjectX.assetManager.get("bg-eye.png", Texture.class), x, 0, ProjectX.DEFAULT_WIDTH, height);
		
		// draw the eye
		batch.draw(ProjectX.assetManager.get("lord-god.png", Texture.class), eyeCenterX - eyeRadius, eyeCenterY - eyeRadius);
		
		// draw particles
		for(int i=0; i<particles.size(); i++) particles.get(i).render(batch, font);
	}

}
