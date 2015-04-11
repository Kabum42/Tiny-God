package net.piropanda.tinygod.gamestates;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
		TG.assets.load("pixel.png", Texture.class);
		//TG.Graphics.assets.load("aura.png", Texture.class);
		TG.assets.load("mouth.png", Texture.class);
		TG.assets.load("toEarth.png", Texture.class);
		TG.assets.load("toYahvy.png", Texture.class);
		TG.assets.load("transition.png", Texture.class);
		TG.assets.load("transition2.png", Texture.class);
		TG.assets.load("screen-background_01.png", Texture.class);
		TG.assets.load("screen-background_02.png", Texture.class);
		TG.assets.load("god-bg.png", Texture.class);
		TG.assets.load("top.png", Texture.class);
		TG.assets.load("god/base_timer.png", Texture.class);
		TG.assets.load("god/fill_timer.png", Texture.class);
		TG.assets.load("god/go_timer.png", Texture.class);
		
		TG.assets.load("common/slide.mp3", Sound.class);
		TG.assets.load("common/tap.mp3", Sound.class);
		//TG.Graphics.assets.load("button-default-up.png", Texture.class);
		//TG.Graphics.assets.load("button-default-down.png", Texture.class);
		// codex
		TG.assets.load("codex/button-settings.png", Texture.class);
		TG.assets.load("codex/button-credits.png", Texture.class);
		TG.assets.load("codex/button-stats.png", Texture.class);
		// god
		TG.assets.load("earth/AdamMini.png", Texture.class);
		TG.assets.load("earth/earth.png", Texture.class);
		TG.assets.load("earth/EveMini.png", Texture.class);
		TG.assets.load("earth/sun.png", Texture.class);
		TG.assets.load("earth/tree.png", Texture.class);
		
		TG.assets.load("earth/crickets.mp3", Sound.class);
		// producers
		TG.assets.load("producers/bg.png", Texture.class);
		TG.assets.load("producers/bg2.png", Texture.class);
		TG.assets.load("producers/buy.png", Texture.class);
		TG.assets.load("producers/grandma.png", Texture.class);
		TG.assets.load("producers/ribbon.png", Texture.class);
		
		TG.assets.load("producers/buy1.mp3", Sound.class);
		TG.assets.load("producers/buy2.mp3", Sound.class);
		TG.assets.load("producers/buy3.mp3", Sound.class);
		
		TG.assets.load("producers/locked.png", Texture.class);
		TG.assets.load("producers/servant.png", Texture.class);
		TG.assets.load("producers/human.png", Texture.class);
		TG.assets.load("producers/prophet.png", Texture.class);
		TG.assets.load("producers/ship.png", Texture.class);
		TG.assets.load("producers/shop.png", Texture.class);
		TG.assets.load("producers/factory.png", Texture.class);
		TG.assets.load("producers/temple.png", Texture.class);
		TG.assets.load("producers/hippievan.png", Texture.class);
		TG.assets.load("producers/laboratory.png", Texture.class);
		TG.assets.load("producers/spaceship.png", Texture.class);
		// achievements
		TG.assets.load("achievements/locked.png", Texture.class);
		TG.assets.load("achievements/selector.png", Texture.class);
		TG.assets.load("achievements/test.png", Texture.class); // test
		
		// upgrades
		TG.assets.load("upgrades/mini-bg.png", Texture.class);
		
		//bodies
		TG.assets.load("spriter/Yahvy/Yahvy_Body.png", Texture.class);
		//masks
		TG.assets.load("shaders/masks/mask001.png", Texture.class);
		TG.assets.load("shaders/masks/mask002.png", Texture.class);
		TG.assets.load("shaders/masks/mask003.png", Texture.class);
		TG.assets.load("shaders/masks/mask004.png", Texture.class);
		TG.assets.load("shaders/masks/mask005.png", Texture.class);
		TG.assets.load("shaders/masks/mask006.png", Texture.class);
		TG.assets.load("shaders/masks/mask007.png", Texture.class);
		
	}
	
	@Override
	public void act(float dt) {
		if(!this.isVisible()) return;
		
		super.act(dt);
		
		if(TG.assets.update()) {
			label.setText("Done!");
			
			if(Gdx.input.justTouched()) { // TODO: try to get a touch up event
				Game.instance.init();
				Game.instance.setVisible(true);
				this.setVisible(false);
			}
		}
	}
	
}
