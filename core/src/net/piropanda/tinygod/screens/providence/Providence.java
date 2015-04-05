package net.piropanda.tinygod.screens.providence;

import java.util.ArrayList;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.creation.Producer;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Providence extends Screen {

	public Game gameParent;
	public static final int POSITION = 1;
	
	private ArrayList<Upgrade> upgrades;
	
	private int upgradesPerRow = 4;
	
	private float customScroll = 0f;
	private float customScrollMax = 2000f;
	
	private float default_x = 0;
	private float default_y = 0;
	
	private float inertia = 0f;
	
	public Sound soundTap;
	
	public Upgrade lastUpgradeSelected = null;
	public Upgrade upgradeSelected = null;
	
	public float transition1 = 0f;
	public float transition2 = 0f;
	public float transition3 = 0f;
	public float transition_y = 0f;
	public float transition_x = 0f;
	
	public Providence(Game g) {
		super();
		
		gameParent = g;
		
		soundTap = TG.assets.get("common/tap.mp3", Sound.class);
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		// TODOS LOS UPGRADES SE ALMACENAN EN EL MISMO ARRAY, LA FORMA DE DIFERENCIAR LOS QUE
		// HAN SIDO DESBLOQUEADOS, ESTAN DISPONIBLES O COMPRADOS ES SU state
		
		upgrades = new ArrayList<Upgrade>();
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.SERVANT_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.HUMAN_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_1));
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_2));
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_3));
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_4));
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_5));
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_6));
		upgrades.add(new Upgrade(this, Lang.SPECIAL_HUMAN_7));
		
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.PROPHET_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.TEMPLE_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.SHIP_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.FACTORY_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.LABORATORY_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.SHOP_UPGRADE_10));
		
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_1));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_2));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_3));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_4));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_5));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_6));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_7));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_8));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_9));
		upgrades.add(new Upgrade(this, Lang.SPACESHIP_UPGRADE_10));
		
		int aux_x = -1;
		int aux_y = 0;
		float availableWidth = 260;
		
		for (int i = 0; i < upgrades.size(); i++) {
			aux_x ++;
			if (aux_x == upgradesPerRow) {
				aux_x = 0;
				aux_y++;
			}
			
			float aux_x2 = ((float)aux_x - ((float)upgradesPerRow-1f)/2f)/(((float)upgradesPerRow-1f)/2f);
			
			upgrades.get(i).origin_x = 1.5f*TG.Display.WIDTH +aux_x2*availableWidth/2f;
			upgrades.get(i).origin_y = TG.Display.HEIGHT/2  +120 -aux_y*100f +customScroll;
			
			if (i == 0) {
				default_x = upgrades.get(i).origin_x;
				default_y = upgrades.get(i).origin_y;
			}
			
		}
		
	}
	
	@Override
	public void act(float dt) {
		
		
		if (upgradeSelected == null) {
			if (transition3 > 0f) {
				transition3 -= dt*10f;
				if (transition3 <= 0f) { transition3 = 0f;}
			}
			else if (transition2 > 0f) {
				transition2 -= dt*10f;
				if (transition2 <= 0f) { transition2 = 0f;}
				lastUpgradeSelected.mini_bg.setY((default_y -lastUpgradeSelected.mini_bg.getHeight()/2)*transition2 + transition_y*(1f - transition2));
				lastUpgradeSelected.mini_bg.setX((default_x -lastUpgradeSelected.mini_bg.getWidth()/2)*transition2 + transition_x*(1f - transition2));

			}
			else if (transition1 > 0f) {
				transition1 -= dt*10f;
				if (transition1 <= 0f) { 
					transition1 = 0f;
					lastUpgradeSelected = null;
					}
			}
			else {
				inertia = inertia/1.05f;
				customScroll += inertia;
				if (customScroll > customScrollMax) { customScroll = customScrollMax; }
				else if (customScroll < 0 ) { customScroll = 0; }
//				for (int i = 0; i < producers.size(); i++) {
//					producers.get(i).background.setY(producers.get(i).origin_y -producers.get(i).background.getHeight()/2 +customScroll);
//				}
			}
		}
		else {
			if (transition1 < 1f) {
				transition1 += dt*10f;
				if (transition1 >= 1f) { 
					transition1 = 1f; 
					transition_y = upgradeSelected.origin_y -upgradeSelected.mini_bg.getHeight()/2 +customScroll;
					transition_x = upgradeSelected.origin_x -upgradeSelected.mini_bg.getWidth()/2;
					}
			}
			else if (transition2 < 1f) {
				transition2 += dt*10f;
				if (transition2 >= 1f) { transition2 = 1f;}
				upgradeSelected.mini_bg.setY((default_y -upgradeSelected.mini_bg.getHeight()/2)*transition2 + transition_y*(1f - transition2));
				upgradeSelected.mini_bg.setX((default_x -upgradeSelected.mini_bg.getWidth()/2)*transition2 + transition_x*(1f - transition2));
			}
			else if (transition3 < 1f) {
				transition3 += dt*10f;
				if (transition3 >= 1f) { transition3 = 1f;}
			}
		}
		
		
		
		
		inertia = inertia/1.05f;
		customScroll += inertia;
		if (customScroll > customScrollMax) { customScroll = customScrollMax; }
		else if (customScroll < 0 ) { customScroll = 0; }
		
		for (int i = 0; i < upgrades.size(); i++) {
			upgrades.get(i).act(dt);
		}
		
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		
		float availableWidth = 260;
		
		int aux_x = -1;
		int aux_y = 0;
		
		for (int i = 0; i < upgrades.size(); i++) {
			aux_x ++;
			if (aux_x == upgradesPerRow) {
				aux_x = 0;
				aux_y++;
			}
			
			float aux_x2 = ((float)aux_x - ((float)upgradesPerRow-1f)/2f)/(((float)upgradesPerRow-1f)/2f);
			
			if (upgradeSelected != upgrades.get(i) && lastUpgradeSelected != upgrades.get(i)) {
				upgrades.get(i).mini_bg.setX(1.5f*TG.Display.WIDTH -upgrades.get(i).mini_bg.getWidth()/2 +aux_x2*availableWidth/2f);
				upgrades.get(i).mini_bg.setY(TG.Display.HEIGHT/2 -upgrades.get(i).mini_bg.getHeight()/2 +120 -aux_y*100f +customScroll);
			}
			
			
//			upgrades.get(i).mini_bg.draw(batch, 1f);
//			upgrades.get(i).icon.draw(batch, 1f);
			
		}
		
		
		
		
		if (upgradeSelected == null) {
			
			if (transition3 > 0f) {
				
				Upgrade t = lastUpgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.background2.draw(batch, transition3);
					t.info.draw(batch, transition3);
					t.buy.draw(batch, transition3);
					
					t.mini_bg.draw(batch, 1f /* *t.background_alpha*/);
					t.background.draw(batch, transition3);
					t.label.draw(batch, transition3);
					t.icon.draw(batch, 1f /* *t.icon_alpha*/);

				}
				
			}
			else if (transition2 > 0f) {
				
				Upgrade t = lastUpgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.mini_bg.draw(batch, 1f /* *t.background_alpha*/);
					t.icon.draw(batch, 1f /* *t.icon_alpha*/);

				}
				
			}
			else {
				for (int i = 0; i < upgrades.size(); i++) {
					if (upgrades.get(i) == lastUpgradeSelected) {
						
						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, 1f /* *t.background_alpha*/);
							t.icon.draw(batch, 1f /* *t.icon_alpha*/);
							
						}
						
						
					}
					else {
						
						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, (1f - transition1) /* *t.background_alpha*/);
							t.icon.draw(batch, (1f - transition1) /* *t.icon_alpha*/);

						}
						
					}
				}
			}
			
			
		}
		else {
			if (transition1 < 1f) {
				for (int i = 0; i < upgrades.size(); i++) {
					if (upgrades.get(i) == upgradeSelected) {
						
						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, 1f /* *t.background_alpha*/);
							t.icon.draw(batch, 1f /* *t.icon_alpha*/);
							
						}
						
					}
					else {

						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, (1f - transition1) /* *t.background_alpha*/);
							t.icon.draw(batch, (1f - transition1) /* *t.icon_alpha*/);
							
						}
						
					}
				}

			}
			else if (transition2 < 1f) {
				
				Upgrade t = upgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.mini_bg.draw(batch, 1f /* *t.background_alpha*/);
					t.icon.draw(batch, 1f /* *t.icon_alpha*/);
					
				}
				
			}
			else {
				
				Upgrade t = upgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.background2.draw(batch, transition3);
					t.info.draw(batch, transition3);
					t.buy.draw(batch, transition3);

					t.mini_bg.draw(batch, 1f /* *t.background_alpha*/);
					t.background.draw(batch, transition3);
					t.label.draw(batch, transition3);
					t.icon.draw(batch, 1f /* *t.icon_alpha*/);
					
					
					
				}
				
			}
		}
		
		
		//super.draw(batch, parentAlpha);
	}
	
	public boolean tap(float x, float y, int count, int button) {

		if (upgradeSelected == null && transition1 == 0f) {
			for (int i = 0; i < upgrades.size(); i++) {
				if (isOnSprite(upgrades.get(i).mini_bg, x, y) && (upgrades.get(i).state == "discovered" || upgrades.get(i).state == "buyable") ) {
					upgradeSelected = upgrades.get(i);
					soundTap.play(1f);
				}
			}
		}
		else if (upgradeSelected != null && transition3 == 1f) {
			upgradeSelected.tap(x,  y, count, button);
			if (isOnSprite(upgradeSelected.background, x, y)) {
				lastUpgradeSelected = upgradeSelected;
				upgradeSelected = null;
				soundTap.play(1f);
			}
		}
		
		return false;
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		
		if (upgradeSelected == null && transition1 == 0f) {
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
