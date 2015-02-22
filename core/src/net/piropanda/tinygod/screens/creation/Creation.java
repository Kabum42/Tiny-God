package net.piropanda.tinygod.screens.creation;

import java.util.ArrayList;

import net.piropanda.tinygod.screens.Screen;

public class Creation extends Screen {

	public static final int POSITION = 3;
	
	/** List of locked producers */
	private ArrayList<Producer> producers;
	
	
	public Creation() {
		super();
		
		producers = new ArrayList<Producer>();
		producers.add(new Producer(this, "servant"));
		producers.add(new Producer(this, "human"));
		producers.add(new Producer(this, "prophet"));
		producers.add(new Producer(this, "temple"));
		producers.add(new Producer(this, "ship"));
		producers.add(new Producer(this, "factory"));
		producers.add(new Producer(this, "laboratory"));
		producers.add(new Producer(this, "hippievan"));
		producers.add(new Producer(this, "shop"));
		producers.add(new Producer(this, "spaceship"));
		
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
	
}
