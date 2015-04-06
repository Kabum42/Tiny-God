package net.piropanda.tinygod.screens.providence;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

public class Upgrade {
	
	private Providence providenceParent;
	public int id;
	
	public Sprite mini_bg;
	public Sprite background;
	public Sprite icon;
	public Label label;
	
	public Sprite background2;
	public Sprite buy;
	public Label info;
	
	public Sound buy1;
	public Sound buy2;
	public Sound buy3;
	
	public String state = "discovered";
	public int position = 0;
	
	public float origin_x = 0;
	public float origin_y = 0;
	
	public Upgrade (Screen screen, int id) {
		
		providenceParent = (Providence)screen;
		
		this.id = id;
		
		buy1 = TG.assets.get("producers/buy1.mp3", Sound.class);
		buy2 = TG.assets.get("producers/buy2.mp3", Sound.class);
		buy3 = TG.assets.get("producers/buy3.mp3", Sound.class);
		
//		System.out.println(Lang.getText(id));
//		System.out.println(Lang.getText(id+1));
//		System.out.println("");
		
		mini_bg = new Sprite(TG.assets.get("upgrades/mini-bg.png", Texture.class));
		mini_bg.setScale(1f/2.75f, 1f/2.75f);
		
		background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		background.setScale(1f/2.75f, 1f/2.75f);
		background.setX(TG.Display.WIDTH*1.5f -background.getWidth()/2);
		background.setY(TG.Display.HEIGHT/2  +120 -background.getHeight()/2);
		
		icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
		icon.setScale(1f/2.75f, 1f/2.75f);
		
		label = new Label(Lang.getText(id), TG.Graphics.font1);
		label.setColor(Color.WHITE);
		label.setX(TG.Display.WIDTH*1.5f -label.getWidth()/2 +icon.getWidth()/2*icon.getScaleX() +5f);
		label.setY(background.getY() +background.getHeight()/2 -label.getHeight()/2);
		label.setAlignment(0);
		
		background2 = new Sprite(TG.assets.get("producers/bg2.png", Texture.class));
		background2.setScale(1f/2.75f, 1f/2.75f);
		background2.setX(TG.Display.WIDTH*1.5f -background2.getWidth()/2);
		background2.setY(background.getY() +background.getHeight()/2 -background2.getHeight()/2 -background2.getHeight()/2*background2.getScaleY() -30f);
		
		buy = new Sprite(TG.assets.get("producers/buy.png", Texture.class));
		buy.setScale(1f/2.75f, 1f/2.75f);
		buy.setX(TG.Display.WIDTH*1.5f -buy.getWidth()/2);
		buy.setY(0f -buy.getHeight()/2 +100f);
		
		info = new Label("LOL", TG.Graphics.font1);
		info.setFontScale(0.9f);
		info.setWrap(true);
		info.setWidth(300);
		info.setX(TG.Display.WIDTH*1.5f -info.getWidth()/2);
		info.setY(300);
		
		
	}
	
	public void act (float dt) {
		
		label.setText(Lang.getText(id));
		
		label.setFontScale(1f);
		while (label.getTextBounds().width >= 265) {
			label.setFontScale(label.getFontScaleX()*0.99f);
		}
		//System.out.println(label.getTextBounds().width);
		
		icon.setX(mini_bg.getX() +mini_bg.getWidth()/2 -icon.getWidth()/2);
		icon.setY(mini_bg.getY() +mini_bg.getHeight()/2 -icon.getHeight()/2);
		
		info.setText(Lang.getText(id+1));
		
		//buy.setX(mini_bg.getX() +mini_bg.getWidth()/2 - buy.getWidth()/2 +100f);
		//buy.setY(mini_bg.getY() +mini_bg.getHeight()/2 -buy.getHeight()/2 +100f);
		
	}
	
	public boolean tap(float x, float y, int count, int button) {
		
		if (isOnSprite(buy, x, y)) {
			// QUIERE COMPRAR
			
//			double cost = Math.floor(ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id])));
//			if (Math.floor(GameInfo.love) >= cost) {
//				GameInfo.love -= cost;
//				GameInfo.producers.put(Lang.ENGLISH_WORDS[id], GameInfo.producers.get(Lang.ENGLISH_WORDS[id]) +1);
//				
//				if (id == Lang.SERVANT_NAME) {
//					providenceParent.gameParent.god.addMouth();
//				}
//				
//				float random = (float) (Math.random()*100f);
//				if (random >= 66.6f) {
//					buy1.play(0.25f);
//				}
//				else if (random >= 33.3f) {
//					buy2.play(0.25f);
//				}
//				else {
//					buy3.play(0.25f);
//				}
//				
//			}	
			
		}
		
		return false;
	}

	private boolean isOnSprite(Sprite s, float x, float y) {
	
	float first_x = s.getX() + s.getWidth()/2 -s.getWidth()/2*s.getScaleX();
	float second_x = s.getX() + s.getWidth()/2 +s.getWidth()/2*s.getScaleX();
	
	float first_y = s.getY() + s.getHeight()/2 +s.getHeight()/2*s.getScaleY();
	float second_y = s.getY() + s.getHeight()/2 -s.getHeight()/2*s.getScaleY();
	
	float modified_x = (x - TG.Display.whiteSpaceX)*(1f/TG.Display.scale) +TG.Display.WIDTH*providenceParent.POSITION;
	float modified_y = -((y -TG.Display.whiteSpaceY)*(1f/TG.Display.scale) -TG.Display.HEIGHT);
	
	if (modified_x >= first_x && modified_x <= second_x &&
			modified_y <= first_y && modified_y >= second_y) {
		return true;
	}
	
	return false;
}

}
