package net.piropanda.tinygod.screens.codex;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.ScreenTab;

public class Settings extends ScreenTab {
	
	public Settings(float x) {
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

		font.draw(batch, "Setting 1 ~", xx, yy);
		font.draw(batch, "Setting 2 ~", xx, yy - 20);
		font.draw(batch, "Setting 3 ~", xx, yy - 40);
		font.draw(batch, "Setting 4 ~", xx, yy - 60);
		font.draw(batch, "Setting 5 ~", xx, yy - 80);
		font.draw(batch, "Setting 6 ~", xx, yy - 100);
		font.draw(batch, "Setting 7 ~", xx, yy - 120);
		font.draw(batch, "Setting 8 ~", xx, yy - 140);
	}
	
}
