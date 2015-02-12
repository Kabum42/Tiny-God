package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Codex extends Screen {
	
	public static final int POSITION = 0;
	
	public static final int ID_SETTINGS = 0;
	public static final int ID_CREDITS = 1;
	public static final int ID_STATS = 2;
	
	public static ScreenTab settings, credits, stats;
	
	public Codex() {
		super();
		
		// screen tabs
		settings = new Settings(this);
		credits = new Credits(this);
		stats = new Stats(this);
		
		// set initial visibility
		this.addActor(settings);
		settings.setVisible(false);
		this.addActor(credits);
		credits.setVisible(false);
		this.addActor(stats);
		stats.setVisible(false);
		
		ImageButton button;
		TextureRegionDrawable trd;

		// settings button
		trd = new TextureRegionDrawable(new TextureRegion(TG.Graphics.assets.get("codex/button-settings.png", Texture.class)));
		button = new ImageButton(trd);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				open(Codex.settings);
			}
		});
		table.add(button).pad(10);
		
		// credits button
		trd = new TextureRegionDrawable(new TextureRegion(TG.Graphics.assets.get("codex/button-credits.png", Texture.class)));
		button = new ImageButton(trd);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				open(Codex.credits);
			}
		});
		table.add(button).pad(10);
		
		// statistics button
		trd = new TextureRegionDrawable(new TextureRegion(TG.Graphics.assets.get("codex/button-stats.png", Texture.class)));
		button = new ImageButton(trd);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				open(Codex.stats);
			}
		});
		table.add(button).pad(10);
	}

	@Override
	public void open(ScreenTab tab) {
		super.open(tab);
		
		tab.setVisible(true);
	}
	
	@Override
	public void close() {
		super.close();
		
		Codex.settings.setVisible(false);
		Codex.credits.setVisible(false);
		Codex.stats.setVisible(false);
	}
	
}
