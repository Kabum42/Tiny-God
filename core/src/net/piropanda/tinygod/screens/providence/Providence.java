package net.piropanda.tinygod.screens.providence;

import java.util.ArrayList;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.creation.Producer;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Providence extends Screen {

	public static final int POSITION = 1;
	
	private ArrayList<Upgrade> upgrades;
	
	private int upgradesPerRow = 4;
	
	private float customScroll = 0f;
	private float customScrollMax = 2000f;
	
	private float inertia = 0f;
	
	public Sound soundTap;
	
	public Providence() {
		super();
		
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
		
	}
	
	@Override
	public void act(float dt) {
		
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
			
			upgrades.get(i).mini_bg.setX(1.5f*TG.Display.WIDTH -upgrades.get(i).mini_bg.getWidth()/2 +aux_x2*availableWidth/2f);
			upgrades.get(i).mini_bg.setY(TG.Display.HEIGHT/2 -upgrades.get(i).mini_bg.getHeight()/2 +120 -aux_y*100f +customScroll);
			upgrades.get(i).mini_bg.draw(batch, 1f);
			upgrades.get(i).icon.draw(batch, 1f);
			
		}
		
		//super.draw(batch, parentAlpha);
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		
		if (true) {
			inertia -= deltaY*(40f/480f);
			if (inertia > 60) { inertia = 60; }
			else if (inertia < -60) { inertia = -60; }
		}
		
	}
	
}
