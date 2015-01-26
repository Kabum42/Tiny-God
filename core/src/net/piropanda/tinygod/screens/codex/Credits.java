package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Credits extends ScreenTab {
	
	public Credits(float x) {
		super(x);
	}
	
	@Override
	public void tap(float tapx, float tapy) {
	}

	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
	}

	@Override
	public void update() {
	}

	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		super.render(batch, font);
		
		float xx = 30;
		float yy = TG.Display.HEIGHT - 50 - 10 - 50 - 10 - 10; // status bar height - margin - tab space - margin - text margin
		
		font.draw(batch, "ALL THIS LOVE BROUGTH TO YOU BY", xx, yy);
		font.draw(batch, "the sons of Tiny God", xx, yy - 20);
	}
	
}
