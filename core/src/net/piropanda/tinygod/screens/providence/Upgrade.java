package net.piropanda.tinygod.screens.providence;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

public class Upgrade {
	
	private Providence providenceParent;
	public int id;
	
	public Sprite mini_bg;
	public Sprite icon;
	public Sprite buy;
	
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
		
		icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
		icon.setScale(1f/2.75f, 1f/2.75f);
		
		buy = new Sprite(TG.assets.get("producers/buy.png", Texture.class));
		buy.setScale(1f/2.75f, 1f/2.75f);
		//buy.setX(background.getX() +background.getWidth()/2 -buy.getWidth()/2);
		buy.setY(0f -buy.getHeight()/2 +100f);
		
		
	}
	
	public void act (float dt) {
		
		icon.setX(mini_bg.getX() +mini_bg.getWidth()/2 -icon.getWidth()/2);
		icon.setY(mini_bg.getY() +mini_bg.getHeight()/2 -icon.getHeight()/2);
		
	}
	
	public boolean tap(float x, float y, int count, int button) {
		
		if (isOnSprite(buy, x, y)) {
			// QUIERE COMPRAR
			
			double cost = Math.floor(ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id])));
			if (Math.floor(GameInfo.love) >= cost) {
				GameInfo.love -= cost;
				GameInfo.producers.put(Lang.ENGLISH_WORDS[id], GameInfo.producers.get(Lang.ENGLISH_WORDS[id]) +1);
				
				if (id == Lang.SERVANT_NAME) {
					providenceParent.gameParent.god.addMouth();
				}
				
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
