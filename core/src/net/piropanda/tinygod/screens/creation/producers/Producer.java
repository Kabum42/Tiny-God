package net.piropanda.tinygod.screens.creation.producers;

public class Producer {

	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	
	private String producerId;
	private float cost;
	
	
	public Producer(String producerId, float cost) {
		this.producerId = producerId;
		this.cost = cost;
	}
	
}
