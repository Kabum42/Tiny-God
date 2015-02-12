package net.piropanda.tinygod.screens.earth2;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class Tree {

	private Image image;
	private Image earth;
	private float radius;
	
	
	public Tree(Image earth) {
		this.earth = earth;
		
		this.image = new Image(TG.Graphics.assets.get("earth/tree.png", Texture.class));
		this.image.setScale(0.4f);
		image.setOrigin(Align.center);
		
		float angle = (float) (Math.random() * 360);
		float dist = (float) (Math.random() * 0.8f);
		radius = earth.getWidth()/2 - (earth.getWidth()/2 * dist);
		
		
	}
	
}
