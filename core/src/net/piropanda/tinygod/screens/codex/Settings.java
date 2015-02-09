package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Settings extends ScreenTab {

	public Settings(Screen screen) {
		super(screen);
		
		content.add("Save").width(100).expandX().pad(5);
		content.add(new TextButton("SAVE", TG.Graphics.skin));
		content.row();

		content.add("Reset").width(100).expandX().pad(5);
		content.add(new TextButton("RESET", TG.Graphics.skin));
		content.row();

		content.add("Volume").width(100).expandX().pad(5);
		content.add(new Slider(0, 10, 0.1f, false, TG.Graphics.skin));
		content.row();
	}
	
}
