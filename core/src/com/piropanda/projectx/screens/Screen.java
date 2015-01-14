package com.piropanda.projectx.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.states.IngameState;

public abstract class Screen {

	public float x;
	public int height;
	public float offset;
	
	
	public Screen(float x) {
		this.x = x;
		
		height = ProjectX.DEFAULT_HEIGHT;
		offset = 0;
	}
	
	public abstract void update(IngameState gs, OrthographicCamera camera);
	
	public abstract void render(SpriteBatch batch, BitmapFont font);
	
}
