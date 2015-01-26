package net.piropanda.tinygod.screens.creation;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

/**
 * Producers and upgrades 
 */
public class Creation extends Screen {
	
	public Creation() {
		// screen global position
		x = TG.Display.WIDTH * 3;
		// screen name
		name = "CREATION";
		// tabs
		tab1 = new Producers(x);
		tab2 = new Upgrades(x);
		currentTab = tab1;
	}
	
}
