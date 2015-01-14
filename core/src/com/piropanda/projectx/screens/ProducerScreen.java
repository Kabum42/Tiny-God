package com.piropanda.projectx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piropanda.projectx.ProjectX;
import com.piropanda.projectx.helpers.GameInfo;
import com.piropanda.projectx.producers.Producer;
import com.piropanda.projectx.states.IngameState;

public class ProducerScreen extends Screen {

	private Producer[] producers;
	
	
	public ProducerScreen(float x) {
		super(x);
		
		height = -324; // try to make it positive
		
		producers = new Producer[10];
		int xoffset = 5;
		int h = Gdx.graphics.getHeight();
		producers[0] = new Producer(xoffset, h - 80, 	GameInfo.LPSBASE_SERVANT, 		GameInfo.PRICE_SERVANT, 	GameInfo.BUILDING_SERVANT);
		producers[1] = new Producer(xoffset, h - 160, 	GameInfo.LPSBASE_HUMAN, 		GameInfo.PRICE_HUMAN, 		GameInfo.BUILDING_HUMAN);
		producers[2] = new Producer(xoffset, h - 240, 	GameInfo.LPSBASE_PROPHET, 		GameInfo.PRICE_PROPHET, 	GameInfo.BUILDING_PROPHET);
		producers[3] = new Producer(xoffset, h - 320, 	GameInfo.LPSBASE_TEMPLE, 		GameInfo.PRICE_TEMPLE, 		GameInfo.BUILDING_TEMPLE);
		producers[4] = new Producer(xoffset, h - 400, 	GameInfo.LPSBASE_SHIP, 			GameInfo.PRICE_SHIP, 		GameInfo.BUILDING_SHIP);
		producers[5] = new Producer(xoffset, h - 480, 	GameInfo.LPSBASE_FACTORY, 		GameInfo.PRICE_FACTORY, 	GameInfo.BUILDING_FACTORY);
		producers[6] = new Producer(xoffset, h - 560,	GameInfo.LPSBASE_LABORATORY,	GameInfo.PRICE_LABORATORY, 	GameInfo.BUILDING_LABORATORY);
		producers[7] = new Producer(xoffset, h - 640, 	GameInfo.LPSBASE_HIPPIE_VAN,	GameInfo.PRICE_HIPPIE_VAN, 	GameInfo.BUILDING_HIPPIE_VAN);
		producers[8] = new Producer(xoffset, h - 720, 	GameInfo.LPSBASE_SHOP, 			GameInfo.PRICE_SHOP, 		GameInfo.BUILDING_SHOP);
		producers[9] = new Producer(xoffset, h - 800, 	GameInfo.LPSBASE_SPACESHIP, 	GameInfo.PRICE_SPACESHIP, 	GameInfo.BUILDING_SPACESHIP);
		
		producers[0].seen = true;
	}

	@Override
	public void update(IngameState gs, OrthographicCamera camera) {
		for(int i=0; i<producers.length; i++) {
			// check for clicks if the producer is seen
			if(gs.touchDownUp && !gs.movingOnX && !gs.movingOnY && producers[i].isOver(camera, offset) && producers[i].seen) {
				// check if there is enough love to buy it
				if(producers[i].enoughResources) {
					GameInfo.love -= producers[i].getPrevCost(); // subtract the love
					producers[i].amount++; // add one producer
					GameInfo.addBuilding(producers[i].getName()); // update the GameInfo class
				}
			}
			// check for producer visibility and update the producer accordingly (seen / unlocked)
			if(!producers[i].seen && producers[i-1].unlocked) producers[i].seen = true; // "see" the producer if the previous one is unlocked
			if(producers[i].seen && GameInfo.totalLove >= producers[i].getCost()) producers[i].unlocked = true; // "unlock" the producer if the love since the beginning is higher than the love needed for the producer
			// set the "enoughResources" variable of the producer to true if the current love is higher than it's cost; else, set it to false
			if(GameInfo.love >= producers[i].getCost()) producers[i].enoughResources = true;
			else producers[i].enoughResources = false;
		}
	}

	@Override
	public void render(SpriteBatch batch, BitmapFont font) {
		batch.draw(ProjectX.assetManager.get("bg-producers.png", Texture.class), x, 0, ProjectX.DEFAULT_WIDTH, ProjectX.DEFAULT_HEIGHT);
		for(int i=0; i<producers.length; i++) producers[i].render(batch, font, offset);
	}
	
	public void load() {
		for(int i=0; i<producers.length; i++) {
			producers[i].amount = GameInfo.buildings.get(producers[i].getName());
		}
	}

}
