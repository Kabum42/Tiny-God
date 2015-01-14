package com.piropanda.projectx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.GameInfo;
import com.piropanda.projectx.states.IngameState;

public class AchievementScreen extends Screen {

	// temporal (buttons)
	private float saveButtonX, saveButtonY;
	private float loadButtonX, loadButtonY;
	private float resetButtonX, resetButtonY;
	// ---------------
	
	public AchievementScreen(float x) {
		super(x);

		// temporal (buttons)
		saveButtonX = loadButtonX = resetButtonX = x + 30;
		saveButtonY = ProjectX.DEFAULT_HEIGHT - 95;
		loadButtonY = saveButtonY - 95;
		resetButtonY = loadButtonY - 95;
		// ---------------
	}

	@Override
	public void update(IngameState gs, OrthographicCamera camera) {
		// temporal (buttons)
		if(gs.touchDownUp && !gs.movingOnX && !gs.movingOnY) {
			int mouseX = (int) (Gdx.input.getX() + camera.position.x - ProjectX.DEFAULT_WIDTH * 0.5f);
			int mouseY = ProjectX.DEFAULT_HEIGHT - Gdx.input.getY();
			
			if(mouseX >= saveButtonX && mouseX < saveButtonX+150 && mouseY >= saveButtonY && mouseY < saveButtonY+75) {
				ProjectX.googleInterface.save();
			}
			if(mouseX >= loadButtonX && mouseX < loadButtonX+150 && mouseY >= loadButtonY && mouseY < loadButtonY+75) {
				ProjectX.googleInterface.load(true);
			}
			if(mouseX >= resetButtonX && mouseX < resetButtonX+150 && mouseY >= resetButtonY && mouseY < resetButtonY+75) {
				System.out.println("resetting...");
				GameInfo.reset();		
			}
		}
		// ---------------
	}

	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(ProjectX.assetManager.get("bg-achievements.png", Texture.class), x, 0, ProjectX.DEFAULT_WIDTH, ProjectX.DEFAULT_HEIGHT);

		// temporal (buttons)
		batch.draw(ProjectX.assetManager.get("producer-black.png", Texture.class), saveButtonX, saveButtonY);
		font.draw(batch, "SAVE", saveButtonX+55, saveButtonY+43);
		batch.draw(ProjectX.assetManager.get("producer-black.png", Texture.class), loadButtonX, loadButtonY);
		font.draw(batch, "LOAD", loadButtonX+55, loadButtonY+43);
		batch.draw(ProjectX.assetManager.get("producer-black.png", Texture.class), resetButtonX, resetButtonY);
		font.draw(batch, "RESET", resetButtonX+50, resetButtonY+43);
		// ---------------
	}
}
