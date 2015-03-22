package net.piropanda.tinygod.screens.creation;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Producer extends Group {
	
	public int id;
	public ProducerScreenTab tab;
	
	public Sprite background;
	public Sprite icon;
	public Label label;
	
	
	public Producer(Screen screen, int id) {
		this.id = id;
		
		tab = new ProducerScreenTab(screen, this);


		
		background = new Sprite(TG.Graphics.assets.get("producers/bg.png", Texture.class));
		background.setScale(1f/2.75f, 1f/2.75f);
		background.setX(TG.Display.WIDTH*((float)3f+0.5f) -background.getWidth()/2);
		

		if (id == Lang.SERVANT_NAME) {
			background.setY(470 -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			icon.setY(470 -icon.getHeight()/2);
			
			label = new Label(Lang.getText(Lang.SERVANT_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(470 -label.getHeight()/2);
		}
		else if (id == Lang.HUMAN_NAME) {
			background.setY(370 -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			icon.setY(370 -icon.getHeight()/2);
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(370 -label.getHeight()/2);
		}
	}
	
	
	//public float getCost() { return (float) (ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(id))); }
	
	//public float getLps() { return ProducerInfo.getLps(id); }
	
	@Override
	public void act(float dt) {
		super.act(dt);

		label.setText(Lang.getText(id));

	}
	
	/**
	 * @return true if the user's total love gained is bigger than this producer's love requirement
	 */
//	public boolean isUnlockable() {
//		return GameInfo.totalLove >= ProducerInfo.getBaseCost(id);
//	}
	
	/**
	 * Makes this producer usable (a.k.a. enables the button so the user can purchase it)
	 */
	public void unlock() {
		//button.setDisabled(false);
	}
	
	public void draw(Batch batch, float parentAlpha) {
		
	}

}
