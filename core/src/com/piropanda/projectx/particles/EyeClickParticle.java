package com.piropanda.projectx.particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.helpers.NumberFormatter;

public class EyeClickParticle {
	
	private float x, y;
	private double value;
	private boolean critical;
	private float timer;
	
	public EyeClickParticle(float x, float y, double value, boolean critical) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.critical = critical;
		
		timer = 1f; // in seconds
	}

	public void update(double dt) {
		y += 140.0 *dt;
		timer -= dt;
	}
	
	public boolean isDead() {
		return timer < 0.0;
	}
	
	public void render(SpriteBatch batch, BitmapFont font) {
		if(critical) font.setColor(Color.RED);
		else font.setColor(Color.WHITE);
		font.draw(batch, "+" + NumberFormatter.format(value), x, y);
	}
	
}
