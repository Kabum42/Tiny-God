package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.screens.AchievementsAndTasks;
import net.piropanda.tinygod.screens.CreditsAndSettings;
import net.piropanda.tinygod.screens.ProducersAndUpgrades;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.StoreAndSocial;
import net.piropanda.tinygod.screens.TheEyeAndStats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ingame extends GameState {

	private SpriteBatch batch;
	private BitmapFont font;
	
	private Screen[] screens;
	private int currentScreen;
	
	
	public Ingame() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		screens = new Screen[5];
		screens[0] = new CreditsAndSettings();
		screens[1] = new AchievementsAndTasks();
		screens[2] = new TheEyeAndStats();
		screens[3] = new ProducersAndUpgrades();
		screens[4] = new StoreAndSocial();
		
		currentScreen = 2;
	}
	
	@Override
	public void update() {
		for(int i=0; i<screens.length; i++) screens[i].update();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
			for(int i=0; i<screens.length; i++) screens[i].render(batch, font);
		batch.end();
	}
	
}
