package com.piropanda.projectx.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.states.IngameState;

public class UpgradeScreen extends Screen {

	public UpgradeScreen(float x) {
		super(x);
	}

	@Override
	public void update(IngameState gs, OrthographicCamera camera) {
	}

	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(ProjectX.assetManager.get("bg-upgrades.png", Texture.class), x, 0, ProjectX.DEFAULT_WIDTH, ProjectX.DEFAULT_HEIGHT);
	}

}
