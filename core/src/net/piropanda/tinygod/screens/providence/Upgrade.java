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
	
	public Sprite ribbon;
	public float variation_color = 0f;
	
	public Sprite background2;
	public Sprite buy;
	public Label info;
	
	public Sound buy1;
	public Sound buy2;
	public Sound buy3;
	
	public float custom_alpha = 1f;
	
	public String state = "unexistant";
	public int position = 0;
	
	public int type_required = 0;
	public int amount_required = 0;
	public int type_bonus = 0;
	
	public double cost = 0f;
	
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
		
		ribbon = new Sprite(TG.assets.get("producers/ribbon.png", Texture.class));
		ribbon.setScale(1f/2.75f, 1f/2.75f);
		ribbon.setAlpha(0f);
		variation_color = (float) (-1f + Math.random()*2f);
		
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
		
		
		if (id <= Lang.SERVANT_UPGRADE_10) {
			int aux_position = (id - Lang.SERVANT_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.SERVANT_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.SERVANT_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.HUMAN_UPGRADE_10) {
			int aux_position = (id - Lang.HUMAN_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.HUMAN_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.HUMAN_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.SPECIAL_HUMAN_10) {
			int aux_position = (id - Lang.SPECIAL_HUMAN_1)/2;
			if (aux_position == 0) {
				type_required = Lang.PROPHET_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.PROPHET_NAME));
			}
			else if (aux_position == 1) {
				type_required = Lang.TEMPLE_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.TEMPLE_NAME));
			}
			else if (aux_position == 2) {
				type_required = Lang.SHIP_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.SHIP_NAME));
			}
			else if (aux_position == 3) {
				type_required = Lang.FACTORY_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.FACTORY_NAME));
			}
			else if (aux_position == 4) {
				type_required = Lang.LABORATORY_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.LABORATORY_NAME));
			}
			else if (aux_position == 5) {
				type_required = Lang.SHOP_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.SHOP_NAME));
			}
			else if (aux_position == 6) {
				type_required = Lang.SPACESHIP_NAME;
				cost = Math.floor(ProducerInfo.getBaseCost(Lang.SPACESHIP_NAME));
			}
			type_bonus = Lang.HUMAN_NAME;
			amount_required = 5;
		}
		else if (id <= Lang.PROPHET_UPGRADE_10) {
			int aux_position = (id - Lang.PROPHET_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.PROPHET_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.PROPHET_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.TEMPLE_UPGRADE_10) {
			int aux_position = (id - Lang.TEMPLE_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.TEMPLE_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.TEMPLE_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.SHIP_UPGRADE_10) {
			int aux_position = (id - Lang.SHIP_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.SHIP_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.SHIP_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.FACTORY_UPGRADE_10) {
			int aux_position = (id - Lang.FACTORY_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.FACTORY_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.FACTORY_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.LABORATORY_UPGRADE_10) {
			int aux_position = (id - Lang.LABORATORY_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.LABORATORY_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.LABORATORY_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.SHOP_UPGRADE_10) {
			int aux_position = (id - Lang.SHOP_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.SHOP_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.SHOP_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		else if (id <= Lang.SPACESHIP_UPGRADE_10) {
			int aux_position = (id - Lang.SPACESHIP_UPGRADE_1)/2;
			cost = Math.floor(ProducerInfo.getBaseCost(Lang.SPACESHIP_NAME)*Math.pow(10f, aux_position));
			type_required = Lang.SPACESHIP_NAME;
			type_bonus = type_required;
			if (aux_position == 0) { amount_required = 1; }
			else if (aux_position == 1) { amount_required = 10; }
			else { amount_required = (aux_position-1)*25; }
		}
		
	}
	
	public void act (float dt) {
		
		if (state == "unexistant" && GameInfo.producers.get(Lang.ENGLISH_WORDS[type_required]) >= amount_required) {
			state = "discovered";
			custom_alpha = 0.7f;
			icon.setColor(0.6f, 0.6f, 0.6f, 1f);
		}
		
		if (state == "discovered" && GameInfo.love >= cost) {
			state = "buyable";
			custom_alpha = 1f;
			icon.setColor(1f, 1f, 1f, 1f);
		}
		else if (state == "buyable" && GameInfo.love < cost) {
			state = "discovered";
			custom_alpha = 0.7f;
			icon.setColor(0.6f, 0.6f, 0.6f, 1f);
		}
		
		if (GameInfo.upgrades.get(Lang.ENGLISH_WORDS[id])) {
			state = "bought";
			custom_alpha = 1f;
			icon.setColor(1f, 1f, 1f, 1f);
			ribbon.setAlpha(1f);
		}
		
		
		
		label.setText(Lang.getText(id));
		
		label.setFontScale(1f);
		
		if (label.getTextBounds().width >= 265) {
			label.setFontScale(265f/(float)label.getTextBounds().width);
		}
		
		
		//System.out.println(label.getTextBounds().width);
		
		icon.setX(mini_bg.getX() +mini_bg.getWidth()/2 -icon.getWidth()/2);
		icon.setY(mini_bg.getY() +mini_bg.getHeight()/2 -icon.getHeight()/2);
		
		ribbon.setX(mini_bg.getX() +mini_bg.getWidth()/2 -ribbon.getWidth()/2 +mini_bg.getWidth()/2*mini_bg.getScaleX() -10f);
		ribbon.setY(mini_bg.getY() +mini_bg.getHeight()/2 -ribbon.getHeight()/2 -mini_bg.getHeight()/2*mini_bg.getScaleY());
		

		String info_change = Lang.getText(Lang.PRODUCE_TWICE_LOVE);
		info_change = Lang.getText(type_bonus) + info_change.substring(1, info_change.length());
		
		info.setText(Lang.getText(id+1) +"\n \n"
 				+ info_change +"\n \n"
				+ "Cost: " +TG.formattedNumber(cost));
		
		//buy.setX(mini_bg.getX() +mini_bg.getWidth()/2 - buy.getWidth()/2 +100f);
		//buy.setY(mini_bg.getY() +mini_bg.getHeight()/2 -buy.getHeight()/2 +100f);
		
	}
	
	public boolean tap(float x, float y, int count, int button) {
		
		if (isOnSprite(buy, x, y)) {
			// QUIERE COMPRAR
			
			if (Math.floor(GameInfo.love) >= cost && !GameInfo.upgrades.get(Lang.ENGLISH_WORDS[id])) {
				GameInfo.love -= cost;
				GameInfo.upgrades.put(Lang.ENGLISH_WORDS[id], true);
				
				float random = (float) (Math.random()*100f);
				if (random >= 66.6f) {
					buy1.play(0.25f);
				}
				else if (random >= 33.3f) {
					buy2.play(0.25f);
				}
				else {
					buy3.play(0.25f);
				}
				
			}	
			
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
