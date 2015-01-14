package com.piropanda.projectx.producers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.NumberFormatter;


public class Producer {

	private static final int WIDTH = 150;
	private static final int HEIGHT = 75;
	
	protected float x, y;
	public int amount;
	protected double baseProduction, baseCost;
	public boolean enoughResources, seen, unlocked;
	protected String name;
	
	
	public Producer(float x, float y, double baseProduction, double baseCost, String name) {
		this.x = (float) (ProjectX.DEFAULT_WIDTH*3 + x);
		this.y = y;
		this.baseProduction = baseProduction;
		this.baseCost = baseCost;
		this.name = name;
	}
	
	public String getName() { return name; }
	
	public boolean isOver(OrthographicCamera camera, float yOffset) {
		float mouseX = Gdx.input.getX() + camera.position.x - ProjectX.DEFAULT_WIDTH * 0.5f;
		float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		
		if(mouseX >= x && mouseX < x+WIDTH && mouseY >= y -yOffset && mouseY < y+HEIGHT -yOffset) {
			return true;
		}
		
		return false;
	}
	
	public void render(SpriteBatch batch, BitmapFont font, float yOffset) {
		if(unlocked) {
			if(enoughResources) batch.draw(ProjectX.assetManager.get("producer-" + name + ".png", Texture.class), x, y - yOffset); // normal image
			else {
				batch.setColor(Color.GRAY);
				batch.draw(ProjectX.assetManager.get("producer-" + name + ".png", Texture.class), x, y - yOffset); // grayed out image
				batch.setColor(Color.WHITE);
			}
		}
		else if(seen) {
			batch.draw(ProjectX.assetManager.get("producer-seen.png", Texture.class), x, y - yOffset);
		}
		
		if(unlocked || seen) {
			double lpsPerBuiding = baseProduction; // add upgrade multiplier and bonuses
			double totalLps = lpsPerBuiding * amount;
			
			font.setColor(Color.BLACK);
			// cost
			batch.draw(ProjectX.assetManager.get("heart16.png", Texture.class), x + WIDTH + 10, y - yOffset + 51);
			font.draw(batch, NumberFormatter.format(getCost()), x + WIDTH + 30, y - yOffset + 65);
			// lps per building
			batch.draw(ProjectX.assetManager.get("lps16.png", Texture.class), x + WIDTH + 10, y - yOffset + 31);
			font.draw(batch, NumberFormatter.format(lpsPerBuiding),  x + WIDTH + 30, y - yOffset + 45);
			// total lps
			batch.draw(ProjectX.assetManager.get("total-lps16.png", Texture.class), x + WIDTH + 10, y - yOffset + 11);
			font.draw(batch, NumberFormatter.format(totalLps), x + WIDTH + 30, y - yOffset + 25);
			// amount
			font.draw(batch, "x" + amount, x + WIDTH - 30, y - yOffset + 20);
			font.setColor(Color.WHITE);
		}
	}
	
	public float getRps() {
		return (float) (baseProduction * amount);
	}
	
	public float getPrevCost() {
		if(amount <= 1) return (float) baseCost;
		return (float) (baseCost * Math.pow(1.1f, amount-1));
	}
	
	public float getCost() {
		return (float) (baseCost * Math.pow(1.1f, amount));
	}

}
