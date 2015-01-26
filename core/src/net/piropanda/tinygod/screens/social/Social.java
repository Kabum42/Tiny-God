package net.piropanda.tinygod.screens.social;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

/**
 * Store and social media
 */
public class Social extends Screen {

	public Social() {
		// screen global position
		x = TG.Display.WIDTH * 4;
		// screen name
		name = "SOCIAL";
		// tabs
		tab1 = new Store(x);
		tab2 = new Media(x);
		currentTab = tab1;
	}

}
