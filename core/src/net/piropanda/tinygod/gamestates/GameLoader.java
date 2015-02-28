package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class GameLoader extends Group {

	public static final String NAME = "GameLoader";
	
	public static GameLoader instance = new GameLoader();
	
	private Label label;
	

	public GameLoader() {
		this.setName(NAME);
	}
	
	public void init() {
		loadAssets();
		
		this.addActor(new Image(new Texture(Gdx.files.internal("piropanda-logo.png"))));
		label = new Label("Loading...", TG.Graphics.skin);
		label.setColor(Color.BLACK);
		label.setX(10);
		label.setY(10);
		this.addActor(label);
	}
	
	private void loadAssets() {
		// common
		TG.Graphics.assets.load("pixel.png", Texture.class);
		TG.Graphics.assets.load("lord-god.png", Texture.class);
		TG.Graphics.assets.load("screen-background_01.png", Texture.class);
		TG.Graphics.assets.load("screen-background_02.png", Texture.class);
		TG.Graphics.assets.load("tab-bg.png", Texture.class);
		TG.Graphics.assets.load("button-default-up.png", Texture.class);
		TG.Graphics.assets.load("button-default-down.png", Texture.class);
		// codex
		TG.Graphics.assets.load("codex/button-settings.png", Texture.class);
		TG.Graphics.assets.load("codex/button-credits.png", Texture.class);
		TG.Graphics.assets.load("codex/button-stats.png", Texture.class);
		// god
		TG.Graphics.assets.load("earth/AdamMini.png", Texture.class);
		TG.Graphics.assets.load("earth/earth.png", Texture.class);
		TG.Graphics.assets.load("earth/EveMini.png", Texture.class);
		TG.Graphics.assets.load("earth/sun.png", Texture.class);
		TG.Graphics.assets.load("earth/tree.png", Texture.class);
		// producers
		TG.Graphics.assets.load("producers/locked.png", Texture.class);
		TG.Graphics.assets.load("producers/servant.png", Texture.class);
		TG.Graphics.assets.load("producers/human.png", Texture.class);
		TG.Graphics.assets.load("producers/prophet.png", Texture.class);
		TG.Graphics.assets.load("producers/ship.png", Texture.class);
		TG.Graphics.assets.load("producers/shop.png", Texture.class);
		TG.Graphics.assets.load("producers/factory.png", Texture.class);
		TG.Graphics.assets.load("producers/temple.png", Texture.class);
		TG.Graphics.assets.load("producers/hippievan.png", Texture.class);
		TG.Graphics.assets.load("producers/laboratory.png", Texture.class);
		TG.Graphics.assets.load("producers/spaceship.png", Texture.class);
		// achievements
		TG.Graphics.assets.load("achievements/locked.png", Texture.class);
		TG.Graphics.assets.load("achievements/selector.png", Texture.class);
		TG.Graphics.assets.load("achievements/test.png", Texture.class); // test
	}
	
	@Override
	public void act(float dt) {
		if(!this.isVisible()) return;
		
		super.act(dt);
		
		if(TG.Graphics.assets.update()) {
			label.setText("Done!");
			
			if(Gdx.input.justTouched()) { // TODO: try to get a touch up event
				Game.instance.init();
				Game.instance.setVisible(true);
				this.setVisible(false);
			}
		}
	}
	
}
