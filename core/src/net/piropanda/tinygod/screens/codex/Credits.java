package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Credits extends ScreenTab {

	public Credits(Screen screen) {
		super(screen);
		
		String text = "Game brought to you by bla, bla and bla.\n\nThanks for all the translations made by:\nbli (blibli)\nblu (blublu)\n...\n\nA special mention to Kiba, we will never forget you.";
		
		Label label = new Label(text, TG.Graphics.skin);
		label.setFontScale(TG.Display.WIDTH / Gdx.graphics.getWidth()); // scale the font to a readable size
		label.setWrap(true);
		Container<Label> container = new Container<Label>(label);
		container.prefWidth(350);
		container.padBottom(25);
		content.add(container);
	}
	
}
