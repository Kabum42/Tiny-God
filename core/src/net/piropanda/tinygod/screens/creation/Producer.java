package net.piropanda.tinygod.screens.creation;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class Producer  {
	
	public Creation creationParent;
	
	protected Table table;
	protected ScrollPane scroll;
	
	public int id;
	public ProducerScreenTab tab;
	
	public Sprite background;
	public Sprite icon;
	public Label label;
	public Label amount;
	public Sprite buy;
	
	public float background_alpha = 1f;
	public float icon_alpha = 1f;
	public float label_alpha = 1f;
	public float amount_alpha = 1f;
	
	public Sprite background2;
	
	public Label info_outline;
	public Label info;
	
	public float origin_y = 0;
	
	public Sound buy1;
	public Sound buy2;
	public Sound buy3;
	
	public String state = "unexistant";
	
	
	public Producer(Screen screen, int id) {
		
		creationParent = (Creation)screen;

		this.id = id;
		
		buy1 = TG.assets.get("producers/buy1.mp3", Sound.class);
		buy2 = TG.assets.get("producers/buy2.mp3", Sound.class);
		buy3 = TG.assets.get("producers/buy3.mp3", Sound.class);

		background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		background.setScale(1f/2.75f, 1f/2.75f);
		background.setX(TG.Display.WIDTH*((float)3f+0.5f) -background.getWidth()/2);
		
		background2 = new Sprite(TG.assets.get("producers/bg2.png", Texture.class));
		background2.setScale(1f/2.75f, 1f/2.75f);
		background2.setX(TG.Display.WIDTH*((float)3f+0.5f) -background2.getWidth()/2);
		
		float base_y = 470;
		float distance_y = background.getHeight()*background.getScaleY() +10;
		
		if (id == Lang.SERVANT_NAME) {
			
			origin_y = base_y - distance_y*0;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/servant.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			icon.setY(origin_y -icon.getHeight()/2);
			
			label = new Label(Lang.getText(Lang.SERVANT_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.HUMAN_NAME) {
			
			origin_y = base_y - distance_y*1;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/human.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			icon.setY(370 -icon.getHeight()/2);
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.PROPHET_NAME) {
			
			origin_y = base_y - distance_y*2;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/prophet.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.TEMPLE_NAME) {
			
			origin_y = base_y - distance_y*3;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.SHIP_NAME) {
			
			origin_y = base_y - distance_y*4;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.FACTORY_NAME) {
			
			origin_y = base_y - distance_y*5;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.LABORATORY_NAME) {
			
			origin_y = base_y - distance_y*6;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.SHOP_NAME) {
			
			origin_y = base_y - distance_y*7;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}
		else if (id == Lang.SPACESHIP_NAME) {
			
			origin_y = base_y - distance_y*8;
			
			background.setY(origin_y -background.getHeight()/2);
			
			icon = new Sprite(TG.assets.get("producers/grandma.png", Texture.class));
			icon.setScale(1f/2.75f, 1f/2.75f);
			icon.setX(background.getX() +background.getWidth()/2 -icon.getWidth()/2 -background.getWidth()/2*background.getScaleX() +icon.getWidth()/2*icon.getScaleX());
			
			label = new Label(Lang.getText(Lang.HUMAN_NAME), TG.Graphics.font1);
			label.setColor(Color.WHITE);
			label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
			label.setY(origin_y -label.getHeight()/2);
		}

		amount = new Label(""+999, TG.Graphics.font1);
		amount.setColor(Color.WHITE);
		amount.setX(TG.Display.WIDTH*3.5f +background.getWidth()/2*background.getScaleX() -amount.getWidth() -10f);
		amount.setY(background.getY() +background.getHeight()/2 -amount.getHeight()/2);
		
		table = new Table();
		table.setFillParent(false);
		
		scroll = new ScrollPane(table);
		scroll.setFillParent(true);
		scroll.setScrollingDisabled(true, true);
		

		info = new Label("LOL", TG.Graphics.font1);
		info.setFontScale(0.9f);
		info.setWrap(true);
		info.setWidth(300);
		info.setX(TG.Display.WIDTH*3.5f -info.getWidth()/2);
		info.setY(300);
		
		info_outline = new Label("LOL", TG.Graphics.font1);
		info_outline.setFontScale(0.9f);
		info_outline.setWrap(true);
		info_outline.setWidth(300);
		info_outline.setX(info.getX() -1f);
		info_outline.setY(info.getY() -1f);
		info_outline.setColor(0, 0, 0, 0.7f);
		
		buy = new Sprite(TG.assets.get("producers/buy.png", Texture.class));
		buy.setScale(1f/2.75f, 1f/2.75f);
		buy.setX(background.getX() +background.getWidth()/2 -buy.getWidth()/2);
		buy.setY(0f -buy.getHeight()/2 +100f);

		//System.out.println(GameInfo.producers.get(id+""));	
		System.out.println("Cost: "+ (ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id]))));
		System.out.println("LPS: " + ProducerInfo.getLps(id) + " (" + ProducerInfo.getLps(id)*GameInfo.producers.get(Lang.ENGLISH_WORDS[id])+ ")");


	}
	
	
	//public float getCost() { return (float) (ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(id))); }
	
	//public float getLps() { return ProducerInfo.getLps(id); }
	
	//@Override
	public void act(float dt) {
		//super.act(dt);

		label.setText(Lang.getText(id));

		icon.setY(background.getY());
		label.setY(background.getY() +background.getHeight()/2 -label.getHeight()/2);
		
		amount.setText(GameInfo.producers.get(Lang.ENGLISH_WORDS[id])+"");
		amount.pack();
		amount.setX(TG.Display.WIDTH*3.5f +background.getWidth()/2*background.getScaleX() -amount.getWidth() -10f);
		amount.setY(background.getY() +background.getHeight()/2 -amount.getHeight()/2);
		
		background2.setY(background.getY() +background.getHeight()/2 -background2.getHeight()/2 -background2.getHeight()/2*background2.getScaleY() -30f);
		
		info.setText(Lang.getText(id+1) 
				+"\n \n" + "Cost: "+ Math.floor(ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id]))));

		//info.setText("дфц ‘no’ means 'yes' caçar où â ë construieşti * LoveCard® ");
		
		info_outline.setText(info.getText());
		
		
		
		if (state == "unexistant") {
			// NI APARECE
			
			if (id == Lang.SERVANT_NAME) {
				state = "undiscovered";
			}
			else if (id == Lang.PROPHET_NAME) {
				if (GameInfo.totalLove >= Math.floor(ProducerInfo.getBaseCost(Lang.HUMAN_NAME))) {
					state = "undiscovered";
				}
			}
			else if (GameInfo.totalLove >= Math.floor(ProducerInfo.getBaseCost(id-22))) {
				state = "undiscovered";
			}
			
		}
		else if (state == "undiscovered") {
			// APARECE BLOQUEADO
			
			if (GameInfo.totalLove >= Math.floor(ProducerInfo.getBaseCost(id))) {
				// SE DESBLOQUEA
				state = "discovered";
			}
			else {
				// SIGUE BLOQUEADO
				background_alpha = 0.7f;
				icon_alpha = 0.7f;
				label_alpha = 0.7f;
				amount_alpha = 0.7f;
				icon.setColor(0, 0, 0, 1f);
				label.setText("???");
			}
			
		}
		else if (state == "discovered") {
			// APARECE DESBLOQUEADO
			
			if (GameInfo.love >= Math.floor(ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id])))) {
				// PUEDE COMPRARLO
				state = "buyable";
			}
			else {
				// NO PUEDE COMPRARLO
				background_alpha = 0.7f;
				icon_alpha = 0.7f;
				label_alpha = 0.7f;
				amount_alpha = 0.7f;
				icon.setColor(0.6f, 0.6f, 0.6f, 1f);
			}
			
		}
		else if (state == "buyable") {
			
			if (GameInfo.love >= Math.floor(ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id])))) {
				// PUEDE COMPRARLO
				background_alpha = 1f;
				icon_alpha = 1f;
				label_alpha = 1f;
				amount_alpha = 1f;
				icon.setColor(1f, 1f, 1f, 1f);
			}
			else {
				// NO PUEDE COMPRARLO
				state = "discovered";
			}
			
		}
		

		
		label.pack();
		label.setX(TG.Display.WIDTH*3.5f -label.getWidth()/2);
		
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
	
	public boolean tap(float x, float y, int count, int button) {
		
		if (isOnSprite(buy, x, y)) {
			// QUIERE COMPRAR
			
			double cost = Math.floor(ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(Lang.ENGLISH_WORDS[id])));
			if (Math.floor(GameInfo.love) >= cost) {
				GameInfo.love -= cost;
				GameInfo.producers.put(Lang.ENGLISH_WORDS[id], GameInfo.producers.get(Lang.ENGLISH_WORDS[id]) +1);
				
				if (id == Lang.SERVANT_NAME) {
					creationParent.gameParent.god.addMouth();
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
		
		float modified_x = (x - TG.Display.whiteSpaceX)*(1f/TG.Display.scale) +TG.Display.WIDTH*creationParent.POSITION;
		float modified_y = -((y -TG.Display.whiteSpaceY)*(1f/TG.Display.scale) -TG.Display.HEIGHT);
		
		if (modified_x >= first_x && modified_x <= second_x &&
				modified_y <= first_y && modified_y >= second_y) {
			return true;
		}
		
		return false;
	}
	
	

}
