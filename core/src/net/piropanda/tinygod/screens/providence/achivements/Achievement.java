package net.piropanda.tinygod.screens.providence.achivements;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Achievement {

	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	
	private String nameId, quoteId, requirementId;
	
	public Achievement(String nameId, String quoteId, String requirementId) {
		this.nameId = nameId;
		this.quoteId = quoteId;
		this.requirementId = requirementId;
	}

	public String getName() { return GameInfo.isAchievementUnlocked(nameId) ? Lang.get(nameId) : "???"; }
	public String getQuote() { return GameInfo.isAchievementUnlocked(nameId) ? Lang.get(quoteId) : "???"; }
	public String getRequirement() { return GameInfo.isAchievementUnlocked(nameId) ? requirementId : "???"; }
	
	public void render(SpriteBatch batch, BitmapFont font, float x, float y) {
		Texture texture;
		
//		if(GameInfo.isAchievementUnlocked(nameId)) texture = TG.Graphics.assets.get("achievements/" + nameId, Texture.class);
		if(GameInfo.isAchievementUnlocked(nameId)) texture = TG.Graphics.assets.get("achievements/test.png", Texture.class);
		else texture = TG.Graphics.assets.get("achievements/locked-achievement.png", Texture.class);
		
		batch.draw(texture, x, y, WIDTH, HEIGHT);
	}
	
}
