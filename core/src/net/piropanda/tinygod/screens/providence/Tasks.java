package net.piropanda.tinygod.screens.providence;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.ScreenTab;

public class Tasks extends ScreenTab {

	public Tasks(float x) {
		super(x);
	}
	
	public void render(SpriteBatch batch, BitmapFont font){
		super.render(batch, font);
		
		for(int i=0; i<TG.Display.HEIGHT; i += 15) {
			font.draw(batch, "TASKS", x + 0, i);
			font.draw(batch, "TASKS", x + 120, i);
			font.draw(batch, "TASKS", x + 240, i);
		}
	}

}
