package net.piropanda.tinygod.screens.providence.achievements;

import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.providence.ProvidenceItem;

public class Achievement extends ProvidenceItem {

	public Achievement(Screen screen, String id) {
		super(screen, id);
		
		tab = new AchievementScreenTab(screen);
	}

}
