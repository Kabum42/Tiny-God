package com.piropanda.projectx.screens;

import java.util.LinkedHashMap;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.GameInfo;
import com.piropanda.projectx.helpers.NumberFormatter;
import com.piropanda.projectx.states.IngameState;

public class StatScreen extends Screen {

	private LinkedHashMap<String, String> stats = new LinkedHashMap<String, String>(); // not sorted
	
	
	public StatScreen(float x) {
		super(x);
	}

	@Override
	public void update(IngameState gs, OrthographicCamera camera) {
		stats.put("Love shared since the beginning of times", NumberFormatter.format(GameInfo.totalLove));
		stats.put("Current love", NumberFormatter.format(GameInfo.love));
		stats.put("Click value", NumberFormatter.format(GameInfo.loveClick));
		stats.put("Number of clicks", NumberFormatter.format(GameInfo.clicks));
	}

	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(ProjectX.assetManager.get("bg-stats.png", Texture.class), x, 0, ProjectX.DEFAULT_WIDTH, ProjectX.DEFAULT_HEIGHT);

		font.draw(batch, "STATS", 10, ProjectX.DEFAULT_HEIGHT - (20));
		int i=0;
		for(String s : stats.keySet()) {
			font.draw(batch, s + ": " + stats.get(s), 10, ProjectX.DEFAULT_HEIGHT - (50 + i * 30));
			i++;
		}
	}

}
