package net.piropanda.tinygod.screens.codex;

import java.util.ArrayList;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.creation.Producer;
import net.piropanda.tinygod.screens.providence.Upgrade;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Codex extends Screen {

	public Game gameParent;
	public static final int POSITION = 0;
	
	private int upgradesPerRow = 4;
	
	private float customScroll = 0f;
	private float customScrollMax = 2000f;
	
	private float default_x = 0;
	private float default_y = 0;
	
	private float inertia = 0f;
	
	public Sound soundTap;
	
	private Sprite save_background;
	private Label save_label;
	
	private Sprite stats_background;
	private Label stats_label;
	private Sprite stats_background2;
	private Label stats_info;
	
	private Sprite language_background;
	private Label language_label;
	private Sprite language_background2;
	private Sprite language_english_background;
	private Sprite language_spanish_background;
	private Sprite language_russian_background;
	private Sprite language_german_background;
	private Sprite language_french_background;
	private Sprite language_italian_background;
	private Sprite language_romanian_background;
	private Sprite language_catalan_background;
	private Label language_english_label;
	private Label language_spanish_label;
	private Label language_russian_label;
	private Label language_german_label;
	private Label language_french_label;
	private Label language_italian_label;
	private Label language_romanian_label;
	private Label language_catalan_label;
	
	private Sprite credits_background;
	private Label credits_label;
	private Sprite credits_background2;
	private Label credits_info;
	
	public Sprite lastSpriteSelected = null;
	public Sprite spriteSelected = null;
	
	public float transition1 = 0f;
	public float transition2 = 0f;
	public float transition3 = 0f;
	public float transition_y = 0f;
	public float transition_x = 0f;
	
	public Codex(Game g) {
		super();
		
		gameParent = g;
		
		soundTap = TG.assets.get("common/tap.mp3", Sound.class);
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		default_x = 0.5f*TG.Display.WIDTH;
		default_y = TG.Display.HEIGHT/2  +120;
		
		float start_y = 60;
		float end_y = 500;
		float number_options = 4;
		number_options++;

		save_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		save_background.setScale(1f/2.75f, 1f/2.75f);
		save_background.setX(0.5f*TG.Display.WIDTH -save_background.getWidth()/2);
		save_background.setY((start_y + (end_y - start_y)*(1f - 1f/number_options)) -save_background.getHeight()/2);

		save_label = new Label("Save", TG.Graphics.font1);
		save_label.setColor(Color.WHITE);
		
		language_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_background.setScale(1f/2.75f, 1f/2.75f);
		language_background.setX(0.5f*TG.Display.WIDTH -language_background.getWidth()/2);
		language_background.setY((start_y + (end_y - start_y)*(1f - 2f/number_options)) -language_background.getHeight()/2);

		language_label = new Label("Language", TG.Graphics.font1);
		language_label.setColor(Color.WHITE);
		
		language_background2 = new Sprite(TG.assets.get("producers/bg2.png", Texture.class));
		language_background2.setScale(1f/2.75f, 1f/2.75f);
		language_background2.setX(TG.Display.WIDTH*0.5f -language_background2.getWidth()/2);
		language_background2.setY(260f -language_background2.getHeight()/2);
		
		float start_y2 = 100;
		float end_y2 = 460;
		float number_options2 = 8;
		
		language_english_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_english_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_english_background.setX(0.5f*TG.Display.WIDTH -language_english_background.getWidth()/2);
		language_english_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 1f/number_options2)) -language_english_background.getHeight()/2);
		
		language_english_label = new Label("ENGLISH", TG.Graphics.font1);
		language_english_label.setColor(Color.WHITE);
		language_english_label.setX(language_english_background.getX() +language_english_background.getWidth()/2 -language_english_label.getWidth()/2);
		language_english_label.setY(language_english_background.getY() +language_english_background.getHeight()/2 -language_english_label.getHeight()/2);
		
		language_spanish_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_spanish_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_spanish_background.setX(0.5f*TG.Display.WIDTH -language_spanish_background.getWidth()/2);
		language_spanish_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 2f/number_options2)) -language_spanish_background.getHeight()/2);
		
		language_spanish_label = new Label("ESPAÑOL", TG.Graphics.font1);
		language_spanish_label.setColor(Color.WHITE);
		language_spanish_label.setX(language_spanish_background.getX() +language_spanish_background.getWidth()/2 -language_spanish_label.getWidth()/2);
		language_spanish_label.setY(language_spanish_background.getY() +language_spanish_background.getHeight()/2 -language_spanish_label.getHeight()/2);
		
		language_russian_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_russian_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_russian_background.setX(0.5f*TG.Display.WIDTH -language_russian_background.getWidth()/2);
		language_russian_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 3f/number_options2)) -language_russian_background.getHeight()/2);
		
		language_russian_label = new Label("РОССИЯ", TG.Graphics.font1);
		language_russian_label.setColor(Color.WHITE);
		language_russian_label.setX(language_russian_background.getX() +language_russian_background.getWidth()/2 -language_russian_label.getWidth()/2);
		language_russian_label.setY(language_russian_background.getY() +language_russian_background.getHeight()/2 -language_russian_label.getHeight()/2);
		
		language_german_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_german_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_german_background.setX(0.5f*TG.Display.WIDTH -language_german_background.getWidth()/2);
		language_german_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 4f/number_options2)) -language_german_background.getHeight()/2);
		
		language_german_label = new Label("DEUTSCHE", TG.Graphics.font1);
		language_german_label.setColor(Color.WHITE);
		language_german_label.setX(language_german_background.getX() +language_german_background.getWidth()/2 -language_german_label.getWidth()/2);
		language_german_label.setY(language_german_background.getY() +language_german_background.getHeight()/2 -language_german_label.getHeight()/2);
		
		language_french_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_french_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_french_background.setX(0.5f*TG.Display.WIDTH -language_french_background.getWidth()/2);
		language_french_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 5f/number_options2)) -language_french_background.getHeight()/2);
		
		language_french_label = new Label("FRANÇAIS", TG.Graphics.font1);
		language_french_label.setColor(Color.WHITE);
		language_french_label.setX(language_french_background.getX() +language_french_background.getWidth()/2 -language_french_label.getWidth()/2);
		language_french_label.setY(language_french_background.getY() +language_french_background.getHeight()/2 -language_french_label.getHeight()/2);
		
		language_italian_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_italian_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_italian_background.setX(0.5f*TG.Display.WIDTH -language_italian_background.getWidth()/2);
		language_italian_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 6f/number_options2)) -language_italian_background.getHeight()/2);
		
		language_italian_label = new Label("ITALIANO", TG.Graphics.font1);
		language_italian_label.setColor(Color.WHITE);
		language_italian_label.setX(language_italian_background.getX() +language_italian_background.getWidth()/2 -language_italian_label.getWidth()/2);
		language_italian_label.setY(language_italian_background.getY() +language_italian_background.getHeight()/2 -language_italian_label.getHeight()/2);
		
		language_romanian_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_romanian_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_romanian_background.setX(0.5f*TG.Display.WIDTH -language_romanian_background.getWidth()/2);
		language_romanian_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 7f/number_options2)) -language_romanian_background.getHeight()/2);
		
		language_romanian_label = new Label("ROMÂNĂ", TG.Graphics.font1);
		language_romanian_label.setColor(Color.WHITE);
		language_romanian_label.setX(language_romanian_background.getX() +language_romanian_background.getWidth()/2 -language_romanian_label.getWidth()/2);
		language_romanian_label.setY(language_romanian_background.getY() +language_romanian_background.getHeight()/2 -language_romanian_label.getHeight()/2);
		
		language_catalan_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		language_catalan_background.setScale((1f/2.75f)*0.60f, (1f/2.75f)*0.60f);
		language_catalan_background.setX(0.5f*TG.Display.WIDTH -language_catalan_background.getWidth()/2);
		language_catalan_background.setY((start_y2 + (end_y2 - start_y2)*(1f - 8f/number_options2)) -language_catalan_background.getHeight()/2);
		
		language_catalan_label = new Label("CATALÀ", TG.Graphics.font1);
		language_catalan_label.setColor(Color.WHITE);
		language_catalan_label.setX(language_catalan_background.getX() +language_catalan_background.getWidth()/2 -language_catalan_label.getWidth()/2);
		language_catalan_label.setY(language_catalan_background.getY() +language_catalan_background.getHeight()/2 -language_catalan_label.getHeight()/2);
		
		stats_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		stats_background.setScale(1f/2.75f, 1f/2.75f);
		stats_background.setX(0.5f*TG.Display.WIDTH -stats_background.getWidth()/2);
		stats_background.setY((start_y + (end_y - start_y)*(1f - 3f/number_options)) -stats_background.getHeight()/2);

		stats_label = new Label("Statistics", TG.Graphics.font1);
		stats_label.setColor(Color.WHITE);
		
		stats_background2 = new Sprite(TG.assets.get("producers/bg2.png", Texture.class));
		stats_background2.setScale(1f/2.75f, 1f/2.75f);
		stats_background2.setX(TG.Display.WIDTH*0.5f -stats_background2.getWidth()/2);
		stats_background2.setY(260f -stats_background2.getHeight()/2);
		
		stats_info = new Label("WUT", TG.Graphics.font1);
		stats_info.setColor(Color.WHITE);
		stats_info.setFontScale(0.9f);
		stats_info.setWrap(true);
		stats_info.setWidth(300);
		stats_info.setX(TG.Display.WIDTH*0.5f -stats_info.getWidth()/2);
		stats_info.setY(250);
		
		credits_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		credits_background.setScale(1f/2.75f, 1f/2.75f);
		credits_background.setX(0.5f*TG.Display.WIDTH -credits_background.getWidth()/2);
		credits_background.setY((start_y + (end_y - start_y)*(1f - 4f/number_options)) -credits_background.getHeight()/2);

		credits_label = new Label("Credits", TG.Graphics.font1);
		credits_label.setColor(Color.WHITE);

		credits_background2 = new Sprite(TG.assets.get("producers/bg2.png", Texture.class));
		credits_background2.setScale(1f/2.75f, 1f/2.75f);
		credits_background2.setX(TG.Display.WIDTH*0.5f -credits_background2.getWidth()/2);
		credits_background2.setY(260f -credits_background2.getHeight()/2);
		
		credits_info = new Label("WUT", TG.Graphics.font1);
		credits_info.setColor(Color.WHITE);
		credits_info.setFontScale(0.9f);
		credits_info.setWrap(true);
		credits_info.setWidth(300);
		credits_info.setX(TG.Display.WIDTH*0.5f -credits_info.getWidth()/2);
		credits_info.setY(250);
		
	}
	
	@Override
	public void act(float dt) {
		
		save_label.setText(Lang.getText(Lang.SAVE_WORD));
		save_label.pack();
		
		stats_label.setText(Lang.getText(Lang.STATISTICS_WORD));
		stats_label.pack();
		
		credits_label.setText(Lang.getText(Lang.CREDITS_WORD));
		credits_label.pack();
		
		if (spriteSelected == null) {
			if (transition3 > 0f) {
				transition3 -= dt*10f;
				if (transition3 <= 0f) { transition3 = 0f;}
			}
			else if (transition2 > 0f) {
				transition2 -= dt*10f;
				if (transition2 <= 0f) { transition2 = 0f;}
				lastSpriteSelected.setY((default_y -lastSpriteSelected.getHeight()/2)*transition2 + transition_y*(1f - transition2));
				lastSpriteSelected.setX((default_x -lastSpriteSelected.getWidth()/2)*transition2 + transition_x*(1f - transition2));

			}
			else if (transition1 > 0f) {
				transition1 -= dt*10f;
				if (transition1 <= 0f) { 
					transition1 = 0f;
					lastSpriteSelected = null;
					}
			}
//			else {
//				inertia = inertia/1.05f;
//				customScroll += inertia;
//				if (customScroll > customScrollMax) { customScroll = customScrollMax; }
//				else if (customScroll < 0 ) { customScroll = 0; }
//			}
		}
		else {
			if (transition1 < 1f) {
				transition1 += dt*10f;
				if (transition1 >= 1f) { 
					transition1 = 1f; 
					transition_y = spriteSelected.getY();
					transition_x = spriteSelected.getX();
					}
			}
			else if (transition2 < 1f) {
				transition2 += dt*10f;
				if (transition2 >= 1f) { transition2 = 1f;}
				spriteSelected.setY((default_y -spriteSelected.getHeight()/2)*transition2 + transition_y*(1f - transition2));
				spriteSelected.setX((default_x -spriteSelected.getWidth()/2)*transition2 + transition_x*(1f - transition2));
			}
			else if (transition3 < 1f) {
				transition3 += dt*10f;
				if (transition3 >= 1f) { transition3 = 1f;}
			}
		}
		
		

		inertia = inertia/1.05f;
		customScroll += inertia;
		if (customScroll > customScrollMax) { customScroll = customScrollMax; }
		else if (customScroll < 0 ) { customScroll = 0; }
		
		
		save_label.pack();
		save_label.setX(save_background.getX() +save_background.getWidth()/2 - save_label.getWidth()/2);
		save_label.setY(save_background.getY() +save_background.getHeight()/2 - save_label.getHeight()/2);
		
		stats_label.pack();
		stats_label.setX(stats_background.getX() +stats_background.getWidth()/2 - stats_label.getWidth()/2);
		stats_label.setY(stats_background.getY() +stats_background.getHeight()/2 - stats_label.getHeight()/2);
		
		stats_info.setText(
				Lang.getText(Lang.LOVE_WORD)+": "+ TG.formattedNumber(GameInfo.love) +"\n"
 				+ Lang.getText(Lang.LOVE_SINCE_BEGINNING_TIMES) +": "+ TG.formattedNumber(GameInfo.totalLove) +"\n"
				+ Lang.getText(Lang.LOVE_PER_SECOND_WORD)+": " + TG.formattedNumber(GameInfo.lps) +"\n"
 				+ Lang.getText(Lang.CLICKS_WORD)+": " + GameInfo.clicks +"\n"
 				+ Lang.getText(Lang.LOVE_PER_CLICK_WORD)+": " + TG.formattedNumber(GameInfo.lovePerClick) +"\n"
 				+ Lang.getText(Lang.CRITICAL_CLICK_CHANCE)+ ": " + GameInfo.criticalClickChance +"\n"
 				+ Lang.getText(Lang.CRITICAL_CLICK_MULTIPLIER_WORD)+": " + GameInfo.criticalClickMultiplier
 				);
		
		language_label.setText(Lang.getText(Lang.LANGUAGE_WORD));
		language_label.pack();
		language_label.setX(language_background.getX() +language_background.getWidth()/2 - language_label.getWidth()/2);
		language_label.setY(language_background.getY() +language_background.getHeight()/2 - language_label.getHeight()/2);
		
		credits_label.pack();
		credits_label.setX(credits_background.getX() +credits_background.getWidth()/2 - credits_label.getWidth()/2);
		credits_label.setY(credits_background.getY() +credits_background.getHeight()/2 - credits_label.getHeight()/2);
		
		credits_info.setText(
				Lang.getText(Lang.TRANSLATORS_WORD) +"\n \n"
				+ Lang.getText(Lang.FRENCH_TRANSLATOR_WORD) +"\n"
 				+ Lang.getText(Lang.GERMAN_TRANSLATOR_WORD) +"\n"
				+ Lang.getText(Lang.ITALIAN_TRANSLATOR_WORD) +"\n"
 				+ Lang.getText(Lang.RUSSIAN_TRANSLATOR_WORD) +"\n"
 				+ Lang.getText(Lang.CATALAN_TRANSLATOR_WORD) +"\n"
 				+ Lang.getText(Lang.ROMANIAN_TRANSLATOR_WORD)
 				);
		
		language_english_background.setColor(1f, 1f, 1f, 1f);
		language_spanish_background.setColor(1f, 1f, 1f, 1f);
		language_russian_background.setColor(1f, 1f, 1f, 1f);
		language_german_background.setColor(1f, 1f, 1f, 1f);
		language_french_background.setColor(1f, 1f, 1f, 1f);
		language_italian_background.setColor(1f, 1f, 1f, 1f);
		language_romanian_background.setColor(1f, 1f, 1f, 1f);
		language_catalan_background.setColor(1f, 1f, 1f, 1f);
		
		if (Lang.CURRENT_VALUE == Lang.ENGLISH_VALUE) { language_english_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.SPANISH_VALUE) { language_spanish_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.RUSSIAN_VALUE) { language_russian_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.GERMAN_VALUE) { language_german_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.FRENCH_VALUE) { language_french_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.ITALIAN_VALUE) { language_italian_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.ROMANIAN_VALUE) { language_romanian_background.setColor(0f, 0f, 0f, 0.7f); }
		if (Lang.CURRENT_VALUE == Lang.CATALAN_VALUE) { language_catalan_background.setColor(0f, 0f, 0f, 0.7f); }
		
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		//bgTab.draw(batch);
		
		
		if (spriteSelected == null) {
			
			save_background.setAlpha(1f-transition1);
			stats_background.setAlpha(1f-transition1);
			language_background.setAlpha(1f-transition1);
			credits_background.setAlpha(1f-transition1);
			
			if (lastSpriteSelected != null) {
				lastSpriteSelected.setAlpha(1f);
			}
			
			stats_background2.setAlpha(0f);
			language_background2.setAlpha(0f);
			credits_background2.setAlpha(0f);
			
			if (lastSpriteSelected == stats_background) {
				stats_background2.setAlpha(transition3);
			}
			else if (lastSpriteSelected == language_background) {
				language_background2.setAlpha(transition3);
			}
			else if (lastSpriteSelected == credits_background) {
				credits_background2.setAlpha(transition3);
			}
			
			
		}
		else {
			if (transition1 < 1f) {
				
				save_background.setAlpha(1f-transition1);
				stats_background.setAlpha(1f-transition1);
				language_background.setAlpha(1f-transition1);
				credits_background.setAlpha(1f-transition1);
				
				spriteSelected.setAlpha(1f);

			}
			else if (transition2 < 1f) {
				
				spriteSelected.setAlpha(1f);
				
			}
			else {
				
				spriteSelected.setAlpha(1f);
				
				stats_background2.setAlpha(0f);
				language_background2.setAlpha(0f);
				credits_background2.setAlpha(0f);
				
				if (spriteSelected == stats_background) {
					stats_background2.setAlpha(transition3);
				}
				else if (spriteSelected == language_background) {
					language_background2.setAlpha(transition3);
				}
				else if (spriteSelected == credits_background) {
					credits_background2.setAlpha(transition3);
				}
				
				
			}
		}
		
		save_background.draw(batch, save_background.getColor().a);
		save_label.draw(batch, save_background.getColor().a);
		
		stats_background2.draw(batch, stats_background2.getColor().a);
		stats_info.draw(batch, stats_background2.getColor().a);
		stats_background.draw(batch, stats_background.getColor().a);
		stats_label.draw(batch, stats_background.getColor().a);
		
		language_background2.draw(batch, language_background2.getColor().a);
		language_english_background.draw(batch, language_background2.getColor().a);
		language_english_label.draw(batch, language_background2.getColor().a);
		language_spanish_background.draw(batch, language_background2.getColor().a);
		language_spanish_label.draw(batch, language_background2.getColor().a);
		language_russian_background.draw(batch, language_background2.getColor().a);
		language_russian_label.draw(batch, language_background2.getColor().a);
		language_german_background.draw(batch, language_background2.getColor().a);
		language_german_label.draw(batch, language_background2.getColor().a);
		language_french_background.draw(batch, language_background2.getColor().a);
		language_french_label.draw(batch, language_background2.getColor().a);
		language_italian_background.draw(batch, language_background2.getColor().a);
		language_italian_label.draw(batch, language_background2.getColor().a);
		language_romanian_background.draw(batch, language_background2.getColor().a);
		language_romanian_label.draw(batch, language_background2.getColor().a);
		language_catalan_background.draw(batch, language_background2.getColor().a);
		language_catalan_label.draw(batch, language_background2.getColor().a);
		language_background.draw(batch, language_background.getColor().a);
		language_label.draw(batch, language_background.getColor().a);
		
		credits_background2.draw(batch, credits_background2.getColor().a);
		credits_info.draw(batch, credits_background2.getColor().a);
		credits_background.draw(batch, credits_background.getColor().a);
		credits_label.draw(batch, credits_background.getColor().a);
		
		//super.draw(batch, parentAlpha);
	}
	
	public boolean tap(float x, float y, int count, int button) {

		if (spriteSelected == null && transition1 == 0f) {
			if (isOnSprite(save_background, x, y)) {
				//spriteSelected = save_background;
				soundTap.play(1f);
			}
			else if (isOnSprite(stats_background, x, y)) {
				spriteSelected = stats_background;
				soundTap.play(1f);
			}
			else if (isOnSprite(language_background, x, y)) {
				spriteSelected = language_background;
				soundTap.play(1f);
			}
			else if (isOnSprite(credits_background, x, y)) {
				spriteSelected = credits_background;
				soundTap.play(1f);
			}
		}
		else if (spriteSelected != null && transition3 == 1f) {
			//upgradeSelected.tap(x,  y, count, button);
			if (isOnSprite(spriteSelected, x, y)) {
				lastSpriteSelected = spriteSelected;
				spriteSelected = null;
				soundTap.play(1f);
			}
			
			if (spriteSelected == language_background) {
				if (isOnSprite(language_english_background, x, y)) {
					Lang.setLanguage(Lang.ENGLISH_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_spanish_background, x, y)) {
					Lang.setLanguage(Lang.SPANISH_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_russian_background, x, y)) {
					Lang.setLanguage(Lang.RUSSIAN_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_german_background, x, y)) {
					Lang.setLanguage(Lang.GERMAN_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_french_background, x, y)) {
					Lang.setLanguage(Lang.FRENCH_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_italian_background, x, y)) {
					Lang.setLanguage(Lang.ITALIAN_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_romanian_background, x, y)) {
					Lang.setLanguage(Lang.ROMANIAN_VALUE);
					soundTap.play(1f);
				}
				else if (isOnSprite(language_catalan_background, x, y)) {
					Lang.setLanguage(Lang.CATALAN_VALUE);
					soundTap.play(1f);
				}
			}
			
		}
		
		return false;
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		
		//if (upgradeSelected == null && transition1 == 0f) {
			inertia -= deltaY*(40f/480f);
			if (inertia > 60) { inertia = 60; }
			else if (inertia < -60) { inertia = -60; }
		//}
		
	}
	
		private boolean isOnSprite(Sprite s, float x, float y) {
		
		float first_x = s.getX() + s.getWidth()/2 -s.getWidth()/2*s.getScaleX();
		float second_x = s.getX() + s.getWidth()/2 +s.getWidth()/2*s.getScaleX();
		
		float first_y = s.getY() + s.getHeight()/2 +s.getHeight()/2*s.getScaleY();
		float second_y = s.getY() + s.getHeight()/2 -s.getHeight()/2*s.getScaleY();
		
		float modified_x = (x - TG.Display.whiteSpaceX)*(1f/TG.Display.scale) +TG.Display.WIDTH*POSITION;
		float modified_y = -((y -TG.Display.whiteSpaceY)*(1f/TG.Display.scale) -TG.Display.HEIGHT);
		
		if (modified_x >= first_x && modified_x <= second_x &&
				modified_y <= first_y && modified_y >= second_y) {
			return true;
		}
		
		return false;
	}
	
}
