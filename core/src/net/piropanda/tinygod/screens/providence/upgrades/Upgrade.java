package net.piropanda.tinygod.screens.providence.upgrades;

import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.providence.ProvidenceItem;
import net.piropanda.tinygod.screens.providence.achievements.AchievementScreenTab;

public class Upgrade extends ProvidenceItem {

	public Upgrade(Screen screen, String id) {
		super(screen, id);
		
		tab = new AchievementScreenTab(screen);
	}

}
