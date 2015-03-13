package net.piropanda.tinygod.screens.creation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

public class Creation extends Screen {

	public static final int POSITION = 3;
	
	/** List of locked producers */
	private ArrayList<Producer> producers;
	
	
	public Creation() {
		super();
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		producers = new ArrayList<Producer>();
		producers.add(new Producer(this, ProducerInfo.SERVANT_ID));
		producers.add(new Producer(this, ProducerInfo.HUMAN_ID));
		producers.add(new Producer(this, ProducerInfo.PROPHET_ID));
		producers.add(new Producer(this, ProducerInfo.TEMPLE_ID));
		producers.add(new Producer(this, ProducerInfo.SHIP_ID));
		producers.add(new Producer(this, ProducerInfo.FACTORY_ID));
		producers.add(new Producer(this, ProducerInfo.LABORATORY_ID));
		producers.add(new Producer(this, ProducerInfo.HIPPIEVAN_ID));
		producers.add(new Producer(this, ProducerInfo.SHOP_ID));
		producers.add(new Producer(this, ProducerInfo.SPACESHIP_ID));
		
		addProducer(producers.remove(0));
	}
	
	public void addProducer(Producer producer) {
		table.add(producer).pad(10);
		producer.unlock();
		table.row();
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		unlockNewProducers();
	}
	
	private void unlockNewProducers() {
		if(producers.size() > 0) { // if there's still producers to unlock
			if(producers.get(0).isUnlockable()) addProducer(producers.remove(0));
		}
	}
	
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		super.draw(batch, parentAlpha);
	}
	
}
