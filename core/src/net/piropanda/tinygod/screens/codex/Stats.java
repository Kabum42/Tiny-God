package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Stats extends ScreenTab {
	
	public Stats(Screen screen) {
		super(screen);
		
		addLabelToContent("Cookies in bank: ");
		addLabelToContent("Cookies baked (this game): ");
		addLabelToContent("Cookies baked (all time): ");
		addLabelToContent("Cookies forfeited by resetting: ");
		addLabelToContent("Legacy started: ");
		addLabelToContent("Session started: ");
		addLabelToContent("Buildings owned: ");
		addLabelToContent("Cookies per second: ");
		addLabelToContent("Cookies per click: ");
		addLabelToContent("Cookie clicks: ");
		addLabelToContent("Hand-made cookies: ");
		addLabelToContent("Golden cookie clicks: ");
		addLabelToContent("Running version: ");
	}

	private void addLabelToContent(String text) {
		Label label = new Label(text, TG.Graphics.skin);
		label.setFontScale(TG.Display.WIDTH / Gdx.graphics.getWidth()); // scale the font to a readable size
		label.setWrap(true);
		Container<Label> container = new Container<Label>(label);
		container.prefWidth(350);
		content.add(container);
		content.row();
	}
	
}
