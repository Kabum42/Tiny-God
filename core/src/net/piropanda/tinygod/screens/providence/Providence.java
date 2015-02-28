package net.piropanda.tinygod.screens.providence;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.providence.achievements.Achievement;
import net.piropanda.tinygod.screens.providence.upgrades.Upgrade;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Providence extends Screen {

	public static final int POSITION = 1;
	
	private Table achievements, upgrades;
	
	public Providence() {
		super();
		
		achievements = new Table();
		
		table.add(new Label("Achievements", TG.Graphics.skin));
		table.row();
		table.add(achievements);
		
		table.row();
		table.add().padBottom(50);
		table.row();

		table.add(new Label("Upgrades", TG.Graphics.skin));
		table.row();
		upgrades = new Table();
		table.add(upgrades);

		addAchievement("achievement 1");
		addUpgrade("upgrade 2");
	}
	
	public void addAchievement(String id) {
		achievements.add(new Achievement(this, id)).pad(10);
		achievements.row();
	}
	
	public void addUpgrade(String id) {
		upgrades.add(new Upgrade(this, id)).pad(10);
		upgrades.row();
	}
	
}
