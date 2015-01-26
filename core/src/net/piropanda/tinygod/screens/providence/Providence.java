package net.piropanda.tinygod.screens.providence;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

/**
 * Achievements and tasks 
 */
public class Providence extends Screen {
	
	public Providence() {
		// screen global position
		x = TG.Display.WIDTH * 1;
		// screen name
		name = "PROVIDENCE";
		// tabs
		tab1 = new Achievements(x);
		tab1name = "Achievements";
		tab2 = new Tasks(x);
		tab2name = "Tasks";
		currentTab = tab1;
	}
	
}
