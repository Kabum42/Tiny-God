package net.piropanda.tinygod.screens.providence;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

public class Upgrade {
	
	private Providence providenceParent;
	public int id;
	
	public Sprite mini_bg;
	public Sprite icon;
	
	public String state = "unexistant";
	public int position = 0;
	
	public Upgrade (Screen screen, int id) {
		
		providenceParent = (Providence)screen;
		
		this.id = id;
		
//		System.out.println(Lang.getText(id));
//		System.out.println(Lang.getText(id+1));
//		System.out.println("");
		
		mini_bg = new Sprite(TG.assets.get("upgrades/mini-bg.png", Texture.class));
		mini_bg.setScale(1f/2.75f, 1f/2.75f);
		
		icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
		icon.setScale(1f/2.75f, 1f/2.75f);
		
		
	}
	
	public void act (float dt) {
		
		icon.setX(mini_bg.getX() +mini_bg.getWidth()/2 -icon.getWidth()/2);
		icon.setY(mini_bg.getY() +mini_bg.getHeight()/2 -icon.getHeight()/2);
		
	}

}
