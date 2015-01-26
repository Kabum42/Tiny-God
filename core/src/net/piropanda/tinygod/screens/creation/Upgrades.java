package net.piropanda.tinygod.screens.creation;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.ScreenTab;

public class Upgrades extends ScreenTab {

	public Upgrades(float x) {
		super(x);
	}

	
	public void render(SpriteBatch batch, BitmapFont font){
		super.render(batch, font);
		
		for(int i=0; i<TG.Display.HEIGHT; i += 15) {
			font.draw(batch, "UPGRADES", x + 0, i);
			font.draw(batch, "UPGRADES", x + 120, i);
			font.draw(batch, "UPGRADES", x + 240, i);
		}
	}

}