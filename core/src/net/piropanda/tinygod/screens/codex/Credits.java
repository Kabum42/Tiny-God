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
		
		String text = "The standard Lorem Ipsum passage, used since the 1500s\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		Label label = new Label(text, TG.Graphics.skin);
		label.setFontScale(TG.Display.WIDTH / Gdx.graphics.getWidth()); // scale the font to a readable size
		label.setWrap(true);
		Container<Label> container = new Container<Label>(label);
		container.prefWidth(350);
		container.padBottom(25);
		content.add(container);
	}
	
}
