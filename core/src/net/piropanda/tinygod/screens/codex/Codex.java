package net.piropanda.tinygod.screens.codex;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Codex extends Screen {
	
	public static final int POSITION = 0;
	
	public static ScreenTab settings, credits, stats;
	
	public Codex() {
		super();
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		// screen tabs
		settings = new Settings(this);
		credits = new Credits(this);
		stats = new Stats(this);
		
		// common button variables
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
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		super.draw(batch, parentAlpha);
	}
	
}
