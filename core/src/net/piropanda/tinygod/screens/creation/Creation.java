package net.piropanda.tinygod.screens.creation;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

public class Creation extends Screen {

	public Game gameParent;
	public static final int POSITION = 3;
	
	/** List of locked producers */
	private ArrayList<Producer> producers;
	
	public Producer lastProducerSelected = null;
	public Producer producerSelected = null;
	public float transition1 = 0f;
	public float transition2 = 0f;
	public float transition3 = 0f;
	public float transition_y = 0f;
	
	private float customScroll = 0f;
	private float customScrollMax = 290f;
	private float inertia = 0f;
	
	public Sound soundTap;
	
	public Creation(Game g) {
		super();
		
		gameParent = g;
		
		soundTap = TG.assets.get("common/tap.mp3", Sound.class);
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		producers = new ArrayList<Producer>();
		producers.add(new Producer(this, Lang.SERVANT_NAME));
		producers.add(new Producer(this, Lang.HUMAN_NAME));
		producers.add(new Producer(this, Lang.PROPHET_NAME));
		producers.add(new Producer(this, Lang.TEMPLE_NAME));
		producers.add(new Producer(this, Lang.SHIP_NAME));
		producers.add(new Producer(this, Lang.FACTORY_NAME));
		producers.add(new Producer(this, Lang.LABORATORY_NAME));
		producers.add(new Producer(this, Lang.SHOP_NAME));
		producers.add(new Producer(this, Lang.SPACESHIP_NAME));
		
	}
	

	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		
		if (producerSelected == null) {
			if (transition3 > 0f) {
				transition3 -= dt*10f;
				if (transition3 <= 0f) { transition3 = 0f;}
			}
			else if (transition2 > 0f) {
				transition2 -= dt*10f;
				if (transition2 <= 0f) { transition2 = 0f;}
				lastProducerSelected.background.setY((470-lastProducerSelected.background.getHeight()/2)*transition2 + transition_y*(1f - transition2));
			}
			else if (transition1 > 0f) {
				transition1 -= dt*10f;
				if (transition1 <= 0f) { transition1 = 0f;}
			}
			else {
				inertia = inertia/1.05f;
				customScroll += inertia;
				if (customScroll > customScrollMax) { customScroll = customScrollMax; }
				else if (customScroll < 0 ) { customScroll = 0; }
				for (int i = 0; i < producers.size(); i++) {
					producers.get(i).background.setY(producers.get(i).origin_y -producers.get(i).background.getHeight()/2 +customScroll);
				}
			}
		}
		else {
			if (transition1 < 1f) {
				transition1 += dt*10f;
				if (transition1 >= 1f) { transition1 = 1f; transition_y = producerSelected.origin_y -producerSelected.background.getHeight()/2 +customScroll;}
			}
			else if (transition2 < 1f) {
				transition2 += dt*10f;
				if (transition2 >= 1f) { transition2 = 1f;}
				producerSelected.background.setY((470-producerSelected.background.getHeight()/2)*transition2 + transition_y*(1f - transition2));
			}
			else if (transition3 < 1f) {
				transition3 += dt*10f;
				if (transition3 >= 1f) { transition3 = 1f;}
			}
		}
		
		int producersDrawed = 0;
		
		for (int i = 0; i < producers.size(); i++) {
			producers.get(i).act(dt);
			if (producers.get(i).state != "unexistant") {
				producersDrawed++;
			}
		}
		
		if (producersDrawed <= 5) {
			customScrollMax = 0;
		}
		else {
			customScrollMax = (producersDrawed - 6)*83 +45;
		}

		
		//unlockNewProducers();
	}
	
//	private void unlockNewProducers() {
//		if(producers.size() > 0) { // if there's still producers to unlock
//			if(producers.get(0).isUnlockable()) addProducer(producers.remove(0));
//		}
//	}
	
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		
		if (producerSelected == null) {
			
			if (transition3 > 0f) {
				
				Producer t = lastProducerSelected;
				
				if (t.state != "unexistant") {
					t.background2.setAlpha(transition3);
					t.background2.draw(batch);
					t.buy.draw(batch, transition3);
					t.info_outline.draw(batch, transition3);
					t.info.draw(batch, transition3);
					
					t.background.draw(batch, 1f*t.background_alpha);
					t.icon.draw(batch, 1f*t.icon_alpha);
					t.label.draw(batch, 1f);
					t.amount.draw(batch, 1f);
				}
				
			}
			else if (transition2 > 0f) {
				
				Producer t = lastProducerSelected;
				
				if (t.state != "unexistant") {
					t.background.draw(batch, 1f*t.background_alpha);
					t.icon.draw(batch, 1f*t.icon_alpha);
					t.label.draw(batch, 1f*t.label_alpha);
					t.amount.draw(batch, 1f*t.amount_alpha);
				}
				
			}
			else {
				for (int i = 0; i < producers.size(); i++) {
					if (producers.get(i) == lastProducerSelected) {
						
						Producer t = producers.get(i);
						
						if (t.state != "unexistant") {
							t.background.draw(batch, 1f*t.background_alpha);
							t.icon.draw(batch, 1f*t.icon_alpha);
							t.label.draw(batch, 1f*t.label_alpha);
							t.amount.draw(batch, 1f*t.amount_alpha);
						}
						
						
					}
					else {
						
						Producer t = producers.get(i);
						
						if (t.state != "unexistant") {
							t.background.draw(batch, (1f - transition1)*t.background_alpha);
							t.icon.draw(batch, (1f - transition1)*t.icon_alpha);
							t.label.draw(batch, (1f - transition1)*t.label_alpha);
							t.amount.draw(batch, (1f - transition1)*t.amount_alpha);
						}
						
					}
				}
			}
			
			
		}
		else {
			if (transition1 < 1f) {
				for (int i = 0; i < producers.size(); i++) {
					if (producers.get(i) == producerSelected) {
						
						Producer t = producers.get(i);
						
						if (t.state != "unexistant") {
							t.background.draw(batch, 1f*t.background_alpha);
							t.icon.draw(batch, 1f*t.icon_alpha);
							t.label.draw(batch, 1f*t.label_alpha);
							t.amount.draw(batch, 1f*t.amount_alpha);
						}
						
					}
					else {

						Producer t = producers.get(i);
						
						if (t.state != "unexistant") {
							t.background.draw(batch, (1f - transition1)*t.background_alpha);
							t.icon.draw(batch, (1f - transition1)*t.icon_alpha);
							t.label.draw(batch, (1f - transition1)*t.label_alpha);
							t.amount.draw(batch, (1f - transition1)*t.amount_alpha);
						}
						
					}
				}

			}
			else if (transition2 < 1f) {
				
				Producer t = producerSelected;
				
				if (t.state != "unexistant") {
					t.background.draw(batch, 1f*t.background_alpha);
					t.icon.draw(batch, 1f*t.icon_alpha);
					t.label.draw(batch, 1f*t.label_alpha);
					t.amount.draw(batch, 1f*t.amount_alpha);
				}
				
			}
			else {
				
				Producer t = producerSelected;
				
				if (t.state != "unexistant") {
					t.background2.setAlpha(transition3);
					t.background2.draw(batch);
					t.buy.draw(batch, transition3);
					t.info_outline.draw(batch, transition3);
					t.info.draw(batch, transition3);
					
					t.background.draw(batch, 1f*t.background_alpha);
					t.icon.draw(batch, 1f*t.icon_alpha);
					t.label.draw(batch, 1f);
					t.amount.draw(batch, 1f);
				}
				
			}
		}
		

		super.draw(batch, parentAlpha);

		
		
		//super.draw(batch, parentAlpha);

	}
	
	public boolean tap(float x, float y, int count, int button) {

		if (producerSelected == null && transition1 == 0f) {
			for (int i = 0; i < producers.size(); i++) {
				if (isOnSprite(producers.get(i).background, x, y) && (producers.get(i).state == "discovered" || producers.get(i).state == "buyable") ) {
					producerSelected = producers.get(i);
					soundTap.play(1f);
				}
			}
		}
		else if (producerSelected != null && transition3 == 1f) {
			producerSelected.tap(x,  y, count, button);
			if (isOnSprite(producerSelected.background, x, y)) {
				lastProducerSelected = producerSelected;
				producerSelected = null;
				soundTap.play(1f);
			}
		}
		
//		if (Lang.getLanguage() == Lang.ENGLISH_VALUE) {
//			Lang.setLanguage(Lang.SPANISH_VALUE);
//		}
//		else if (Lang.getLanguage() == Lang.SPANISH_VALUE) {
//			Lang.setLanguage(Lang.ENGLISH_VALUE);
//		}
		
		return false;
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		
		if (producerSelected == null && transition1 == 0f) {
			inertia -= deltaY*(40f/480f);
			if (inertia > 60) { inertia = 60; }
			else if (inertia < -60) { inertia = -60; }
		}
		
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
