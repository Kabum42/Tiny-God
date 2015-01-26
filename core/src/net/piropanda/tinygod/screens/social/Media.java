package net.piropanda.tinygod.screens.social;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Media extends ScreenTab {

	public Media(float x) {
		super(x);
	}
	
	public void render(SpriteBatch batch, BitmapFont font){
		super.render(batch, font);
		
		for(int i=0; i<TG.Display.HEIGHT; i += 15) {
			font.draw(batch, "MEDIA", x + 0, i);
			font.draw(batch, "MEDIA", x + 120, i);
			font.draw(batch, "MEDIA", x + 240, i);
		}
	}

}
