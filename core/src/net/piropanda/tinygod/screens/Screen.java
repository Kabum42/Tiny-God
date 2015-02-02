package net.piropanda.tinygod.screens;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Screen {

	// global position x
	protected float x;
	// screen name
	protected String name, tab1name, tab2name;
	// background image
	protected Texture bg;
	// tab buttons
	protected Texture btnTab1, btnTab2;
	protected float btnTab1X, btnTab2X, btnTabY; // change these to a Rectangle
	// screen tabs
	protected ScreenTab currentTab, tab1, tab2;
	
	public boolean canPan = true;
	
	
	public Screen() {
		bg = TG.Graphics.assets.get("bg.png", Texture.class);
		
		btnTab1X = 20; // first tab button x
		btnTab2X = btnTab1X + 140 + 20; // btnTab1 + it's width + a margin
		btnTabY = 50 + 30; // the status bar height + a margin

		btnTab1 = TG.Graphics.assets.get("tab-btn.png", Texture.class);
		btnTab2 = TG.Graphics.assets.get("tab-btn.png", Texture.class);
		
		tab1name = "tab1";
		tab2name = "tab2";
	}
	
	public void tap(float tapx, float tapy) {
		if(ScreenTab.inside(tapx, tapy)) currentTab.tap(tapx, tapy);
		else if(tab1BtnClicked(tapx, tapy)) currentTab = tab1;
		else if(tab2BtnClicked(tapx, tapy)) currentTab = tab2;
	}

	public boolean tab1BtnClicked(float tapx, float tapy) {
		if(tapx >= btnTab1X && tapx < btnTab1X + 130 && tapy >= btnTabY && tapy < btnTabY + 30) return true;
		return false;
	}
	
	public boolean tab2BtnClicked(float tapx, float tapy) {
		if(tapx >= btnTab2X && tapx < btnTab2X + 130 && tapy >= btnTabY && tapy < btnTabY + 30) return true;
		return false;
	}
	
	public void pan(float x, float y, float deltaX, float deltaY) {
		currentTab.pan(x, y, deltaX, deltaY);
	}
	
	public void update() {
		tab1.update();
		tab2.update();
	}
	
	public void render(SpriteBatch batch, BitmapFont font) {
		// we need to invert btnTabY since it's measured in input coordinates (0 = top) and subtract the button's height
		float yy = TG.Display.HEIGHT - btnTabY - 30;
		float textWidth;
		
		// current tab
		currentTab.render(batch, font);
		
		// screen background
		batch.draw(bg, x, 0);
		
		// tab1 button
		batch.draw(btnTab1, x + btnTab1X, yy);
		textWidth = font.getBounds(tab1name).width;
		font.draw(batch, tab1name, x + btnTab1X + (130-textWidth)/2, yy + 22);
		
		// tab2 button
		batch.draw(btnTab2, x + btnTab2X, yy);
		textWidth = font.getBounds(tab2name).width;
		font.draw(batch, tab2name, x + btnTab2X + (130-textWidth)/2, yy + 22);
		
		// screen name
		font.draw(batch, name, x + 20, TG.Display.HEIGHT - 50 - 10);
	}
	
}
