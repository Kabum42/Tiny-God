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
	public Label amount;
	public Label info;
	
	public float origin_y = 0;
	
	
	public Producer(Screen screen, int id) {
		this.id = id;
		
		tab = new ProducerScreenTab(screen, this);

		background = new Sprite(TG.Graphics.assets.get("producers/bg.png", Texture.class));
		background.setScale(1f/2.75f, 1f/2.75f);
		background.setX(TG.Display.WIDTH*((float)3f+0.5f) -background.getWidth()/2);
		
		float base_y = 470;
		float distance_y = background.getHeight()*background.getScaleY() +10;
		
		if (id == Lang.SERVANT_NAME) {
			
			origin_y = base_y - distance_y*0;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/servant.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			icon.setY(origin_y -icon.getHeight()/2);
			
			label = new Label(Lang.getText(Lang.SERVANT_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO SERVANT", TG.Graphics.skin);
		}
		else if (id == Lang.HUMAN_NAME) {
			
			origin_y = base_y - distance_y*1;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/human.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			icon.setY(370 -icon.getHeight()/2);
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO HUMAN", TG.Graphics.skin);
		}
		else if (id == Lang.PROPHET_NAME) {
			
			origin_y = base_y - distance_y*2;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/prophet.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO PROPHET", TG.Graphics.skin);
		}
		else if (id == Lang.TEMPLE_NAME) {
			
			origin_y = base_y - distance_y*3;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO TEMPLE", TG.Graphics.skin);
		}
		else if (id == Lang.SHIP_NAME) {
			
			origin_y = base_y - distance_y*4;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO SHIP", TG.Graphics.skin);
		}
		else if (id == Lang.FACTORY_NAME) {
			
			origin_y = base_y - distance_y*5;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO SHIP", TG.Graphics.skin);
		}
		else if (id == Lang.LABORATORY_NAME) {
			
			origin_y = base_y - distance_y*6;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO SHIP", TG.Graphics.skin);
		}
		else if (id == Lang.SHOP_NAME) {
			
			origin_y = base_y - distance_y*7;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO SHIP", TG.Graphics.skin);
		}
		else if (id == Lang.SPACESHIP_NAME) {
			
			origin_y = base_y - distance_y*8;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.Graphics.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.skin);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
			
			info = new Label("INFO SHIP", TG.Graphics.skin);
		}
		
		amount = new Label(""+999, TG.Graphics.skin);
		amount.setColor(Color.WHITE);
		amount.setX(TG.Display.WIDTH*3.5f +background.getWidth()/2*background.getScaleX() -amount.getWidth() -10f);
		amount.setY(background.getY() +background.getHeight()/2 -amount.getHeight()/2);
		
		
		info.setColor(Color.WHITE);
		info.setX(TG.Display.WIDTH*3.5f -info.getWidth()/2);
		info.setY(background.getY() +background.getHeight()/2 -info.getHeight()/2 +100f);
		
		

		//System.out.println(GameInfo.producers.get(id+""));	
		System.out.println("Cost: "+ (ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(id+""))));
		System.out.println("LPS: " + ProducerInfo.getLps(id) + " (" + ProducerInfo.getLps(id)*GameInfo.producers.get(id+"")+ ")");

		//+ "LPS: " + producer.getLps() + " (" + producer.getLps()*GameInfo.producers.get(producer.getId()) + ")"

	}
	
	
	//public float getCost() { return (float) (ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(id))); }
	
	//public float getLps() { return ProducerInfo.getLps(id); }
	
	@Override
	public void act(float dt) {
		super.act(dt);

		label.setText(Lang.getText(id));
		label.pack();
		label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
		
		icon.setY(background.getY());
		label.setY(background.getY() +background.getHeight()/2 -label.getHeight()/2);
		
		amount.setText(GameInfo.producers.get(id+"")+"");
		amount.pack();
		amount.setX(TG.Display.WIDTH*3.5f +background.getWidth()/2*background.getScaleX() -amount.getWidth() -10f);
		amount.setY(background.getY() +background.getHeight()/2 -amount.getHeight()/2);
		
		info.setText(Lang.getText(id+1));
		info.pack();
		info.setX(TG.Display.WIDTH*3.5f -info.getWidth()/2);
		info.setY(background.getY() +background.getHeight()/2 -info.getHeight()/2 -200f);

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
