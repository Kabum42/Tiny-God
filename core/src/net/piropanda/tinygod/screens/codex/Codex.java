package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

/**
 * Credits and settings
 */
public class Codex extends Screen {
	
	public Codex() {
		// screen global position
		x = TG.Display.WIDTH * 0;
		// screen name
		name = "CODEX";
		// tabs
		tab1 = new Settings(x);
		tab2 = new Credits(x);
		currentTab = tab1;
	}

}
