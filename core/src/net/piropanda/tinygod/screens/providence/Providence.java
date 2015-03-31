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
	
	private float customScroll = 0f;
	private float customScrollMax = 0f;
	
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
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		//super.draw(batch, parentAlpha);
	}
	
}
