package net.piropanda.tinygod.screens.creation;

import java.util.ArrayList;

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

	public static final int POSITION = 3;
	
	/** List of locked producers */
	private ArrayList<Producer> producers;
	
	private Producer lastProducerSelected = null;
	private Producer producerSelected = null;
	private float transition1 = 0f;
	private float transition2 = 0f;
	private float transition3 = 0f;
	private float transition_y = 0f;
	
	public Creation() {
		super();
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		producers = new ArrayList<Producer>();
		producers.add(new Producer(this, Lang.SERVANT_NAME));
		producers.add(new Producer(this, Lang.HUMAN_NAME));
		producers.add(new Producer(this, Lang.PROPHET_NAME));
//		producers.add(new Producer(this, ProducerInfo.TEMPLE_ID));
//		producers.add(new Producer(this, ProducerInfo.SHIP_ID));
//		producers.add(new Producer(this, ProducerInfo.FACTORY_ID));
//		producers.add(new Producer(this, ProducerInfo.LABORATORY_ID));
//		producers.add(new Producer(this, ProducerInfo.HIPPIEVAN_ID));
//		producers.add(new Producer(this, ProducerInfo.SHOP_ID));
//		producers.add(new Producer(this, ProducerInfo.SPACESHIP_ID));
		
		//addProducer(producers.get(0));

	}
	
	public void addProducer(Producer producer) {
		table.add(producer).pad(10);
		producer.unlock();
		table.row();
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		for (int i = 0; i < producers.size(); i++) {
			producers.get(i).act(dt);
		}
		
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
		}
		else {
			if (transition1 < 1f) {
				transition1 += dt*10f;
				if (transition1 >= 1f) { transition1 = 1f; transition_y = producerSelected.background.getY();}
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
				lastProducerSelected.background.draw(batch);
				lastProducerSelected.icon.draw(batch);
				lastProducerSelected.label.draw(batch, parentAlpha);
				lastProducerSelected.amount.draw(batch, parentAlpha);
				lastProducerSelected.info.draw(batch, transition3);
			}
			else if (transition2 > 0f) {
				lastProducerSelected.background.draw(batch);
				lastProducerSelected.icon.draw(batch);
				lastProducerSelected.label.draw(batch, parentAlpha);
				lastProducerSelected.amount.draw(batch, parentAlpha);
			}
			else {
				for (int i = 0; i < producers.size(); i++) {
					if (producers.get(i) == lastProducerSelected) {
						producers.get(i).background.draw(batch);
						producers.get(i).icon.draw(batch);
						producers.get(i).label.draw(batch, parentAlpha);
						producers.get(i).amount.draw(batch, parentAlpha);
					}
					else {
						producers.get(i).background.setAlpha(1f - transition1);
						producers.get(i).background.draw(batch);
						producers.get(i).icon.setAlpha(1f - transition1);
						producers.get(i).icon.draw(batch);
						producers.get(i).label.draw(batch, 1f - transition1);
						producers.get(i).amount.draw(batch, 1f - transition1);
					}
				}
			}
			
			
		}
		else {
			if (transition1 < 1f) {
				for (int i = 0; i < producers.size(); i++) {
					if (producers.get(i) == producerSelected) {
						producers.get(i).background.draw(batch);
						producers.get(i).icon.draw(batch);
						producers.get(i).label.draw(batch, parentAlpha);
						producers.get(i).amount.draw(batch, parentAlpha);
					}
					else {
						producers.get(i).background.setAlpha(1f - transition1);
						producers.get(i).background.draw(batch);
						producers.get(i).icon.setAlpha(1f - transition1);
						producers.get(i).icon.draw(batch);
						producers.get(i).label.draw(batch, 1f - transition1);
						producers.get(i).amount.draw(batch, 1f - transition1);
					}
				}

			}
			else if (transition2 < 1f) {
				producerSelected.background.draw(batch);
				producerSelected.icon.draw(batch);
				producerSelected.label.draw(batch, parentAlpha);
				producerSelected.amount.draw(batch, parentAlpha);
			}
			else {
				producerSelected.background.draw(batch);
				producerSelected.icon.draw(batch);
				producerSelected.label.draw(batch, parentAlpha);
				producerSelected.amount.draw(batch, parentAlpha);
				producerSelected.info.draw(batch, transition3);
			}
		}

	}
	
	public boolean tap(float x, float y, int count, int button) {

		if (producerSelected == null) {
			for (int i = 0; i < producers.size(); i++) {
				if (isOnSprite(producers.get(i).background, x, y)) {
					producerSelected = producers.get(i);
				}
			}
		}
		else {
			if (isOnSprite(producerSelected.background, x, y)) {
				lastProducerSelected = producerSelected;
				producerSelected = null;
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
