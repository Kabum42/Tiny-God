package net.piropanda.tinygod.screens.providence;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.ScreenTab;
import net.piropanda.tinygod.screens.providence.achivements.Achievement;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Achievements extends ScreenTab {

	private Achievement[] achievements;
	
	
	public Achievements(float x) {
		super(x);
		
		initAchievements();
		
		// achievement unlocking test
		GameInfo.unlockAchievement(GameInfo.ID_ACH_HUMAN_1_NAME);
		GameInfo.unlockAchievement(GameInfo.ID_ACH_HUMAN_25_NAME);
		GameInfo.unlockAchievement(GameInfo.ID_ACH_SERVANT_1_NAME);
		GameInfo.unlockAchievement(GameInfo.ID_ACH_SERVANT_25_NAME);
		GameInfo.unlockAchievement(GameInfo.ID_ACH_SERVANT_50_NAME);
	}
	
	private void initAchievements() {
		achievements = new Achievement[10];
		// human achievements
		achievements[0] = new Achievement(GameInfo.ID_ACH_HUMAN_1_NAME, GameInfo.ID_ACH_HUMAN_1_QUOTE, "requirement");
		achievements[1] = new Achievement(GameInfo.ID_ACH_HUMAN_25_NAME, GameInfo.ID_ACH_HUMAN_25_QUOTE, "requirement");
		achievements[2] = new Achievement(GameInfo.ID_ACH_HUMAN_50_NAME, GameInfo.ID_ACH_HUMAN_50_QUOTE, "requirement");
		achievements[3] = new Achievement(GameInfo.ID_ACH_HUMAN_100_NAME, GameInfo.ID_ACH_HUMAN_100_QUOTE, "requirement");
		achievements[4] = new Achievement(GameInfo.ID_ACH_HUMAN_200_NAME, GameInfo.ID_ACH_HUMAN_200_QUOTE, "requirement");
		
		achievements[5] = new Achievement(GameInfo.ID_ACH_SERVANT_1_NAME, GameInfo.ID_ACH_SERVANT_1_QUOTE, "requirement");
		achievements[6] = new Achievement(GameInfo.ID_ACH_SERVANT_25_NAME, GameInfo.ID_ACH_SERVANT_25_QUOTE, "requirement");
		achievements[7] = new Achievement(GameInfo.ID_ACH_SERVANT_50_NAME, GameInfo.ID_ACH_SERVANT_50_QUOTE, "requirement");
		achievements[8] = new Achievement(GameInfo.ID_ACH_SERVANT_100_NAME, GameInfo.ID_ACH_SERVANT_100_QUOTE, "requirement");
		achievements[9] = new Achievement(GameInfo.ID_ACH_SERVANT_200_NAME, GameInfo.ID_ACH_SERVANT_200_QUOTE, "requirement");
		
	}
	
	public void render(SpriteBatch batch, BitmapFont font){
		super.render(batch, font);
		
		float xx = this.x + 20; // the horizontal margin between the screen and the tab
		float yy = TG.Display.HEIGHT - 50 - 10 - 50 - 10 ; // the vertical margin between the screen and the tab
		
		int pos = 0;
		int row = 0;
		int col = 0;
		
		while(pos < achievements.length) {
			// get the current achievement
			Achievement ach = achievements[pos];
			// fins it's position on the screen
			float xxx = xx + 34 + row * (Achievement.WIDTH + 10);
			float yyy = yy - 15 - col * (Achievement.HEIGHT + 10) - Achievement.HEIGHT;
			// draw it
			ach.render(batch, font, xxx, yyy);
			// move the position, row and column indexes
			pos++;
			row++;
			if(row % 3 == 0) col++;
			if(row >= 3) row = 0;
		}
	}

}
