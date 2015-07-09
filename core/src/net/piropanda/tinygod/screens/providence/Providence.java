package net.piropanda.tinygod.screens.providence;

import java.util.ArrayList;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.creation.Producer;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
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
	
	private Sprite available_background;
	private Label label_available;
	
	private Sprite bought_background;
	private Label label_bought;
	
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
		
		//this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
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
		
		int aux_x = 0;
		int aux_y = 0;
		float availableWidth = 260;

		float aux_x2 = ((float)aux_x - ((float)upgradesPerRow-1f)/2f)/(((float)upgradesPerRow-1f)/2f);

		default_x = 1.5f*TG.Display.WIDTH +aux_x2*availableWidth/2f;
		default_y = TG.Display.HEIGHT/2  +120 -aux_y*100f;

		available_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		available_background.setScale(1f/2.75f, (1f/2.75f)*0.5f);
		
		label_available = new Label("Available", TG.Graphics.font1);
		label_available.setColor(Color.WHITE);
		
		bought_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		bought_background.setScale(1f/2.75f, (1f/2.75f)*0.5f);
		
		label_bought = new Label("Bought", TG.Graphics.font1);
		label_bought.setColor(Color.WHITE);

		
	}
	
	@Override
	public void act(float dt) {
		
		label_available.setText(Lang.getText(Lang.AVAILABLE_WORD));
		label_available.pack();
		
		label_bought.setText(Lang.getText(Lang.BOUGHT_WORD));
		label_bought.pack();
		
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
		//bgTab.draw(batch);
		
		float occupied_y = 0;
		
		available_background.draw(batch, 1f - transition1);
		available_background.setX(TG.Display.WIDTH*((float)POSITION+0.5f) -available_background.getWidth()/2);
		available_background.setY(500f +customScroll -available_background.getHeight()/2);
		
		label_available.setX(TG.Display.WIDTH*((float)POSITION+0.5f) -label_available.getWidth()/2);
		label_available.setY(500f +customScroll -label_available.getHeight()/2);
		label_available.draw(batch, 1f-transition1);
		
		occupied_y += label_available.getHeight() +20f;
		
		float availableWidth = 260;
		
		int aux_x = -1;
		int aux_y = 0;
		
		for (int i = 0; i < upgrades.size(); i++) {
			
			if (upgrades.get(i).state == "discovered" || upgrades.get(i).state == "buyable") {
				aux_x ++;
				
				if (aux_x == upgradesPerRow) {
					aux_x = 0;
					aux_y++;
				}
				
			}
			
			
			float aux_x2 = ((float)aux_x - ((float)upgradesPerRow-1f)/2f)/(((float)upgradesPerRow-1f)/2f);
			
			if (upgradeSelected != upgrades.get(i) && lastUpgradeSelected != upgrades.get(i)) {
				upgrades.get(i).mini_bg.setX(1.5f*TG.Display.WIDTH -upgrades.get(i).mini_bg.getWidth()/2 +aux_x2*availableWidth/2f);
				upgrades.get(i).mini_bg.setY(-occupied_y + TG.Display.HEIGHT/2 -upgrades.get(i).mini_bg.getHeight()/2 +120 -aux_y*100f +customScroll);
				
				upgrades.get(i).origin_x = upgrades.get(i).mini_bg.getX() +upgrades.get(i).mini_bg.getWidth()/2;
				upgrades.get(i).origin_y = upgrades.get(i).mini_bg.getY() +upgrades.get(i).mini_bg.getHeight()/2 -customScroll;
			}
			
			
		}
		
		occupied_y += 20 +(aux_y +1)*100f;
		
		
		bought_background.draw(batch, 1f - transition1);
		bought_background.setX(TG.Display.WIDTH*((float)POSITION+0.5f) -bought_background.getWidth()/2);
		bought_background.setY(500f -occupied_y +customScroll -bought_background.getHeight()/2);
		
		label_bought.setX(TG.Display.WIDTH*((float)POSITION+0.5f) -label_bought.getWidth()/2);
		label_bought.setY(500f -occupied_y +customScroll -label_bought.getHeight()/2);
		label_bought.draw(batch, 1f-transition1);
		
		occupied_y += 20;
		
		aux_x = -1;
		aux_y = 0;
		
		for (int i = 0; i < upgrades.size(); i++) {
			
			if (upgrades.get(i).state == "bought") {
				aux_x ++;
				
				if (aux_x == upgradesPerRow) {
					aux_x = 0;
					aux_y++;
				}
				
				float aux_x2 = ((float)aux_x - ((float)upgradesPerRow-1f)/2f)/(((float)upgradesPerRow-1f)/2f);
				
				if (upgradeSelected != upgrades.get(i) && lastUpgradeSelected != upgrades.get(i)) {
					upgrades.get(i).mini_bg.setX(1.5f*TG.Display.WIDTH -upgrades.get(i).mini_bg.getWidth()/2 +aux_x2*availableWidth/2f);
					upgrades.get(i).mini_bg.setY(-occupied_y + TG.Display.HEIGHT/2 -upgrades.get(i).mini_bg.getHeight()/2 +100 -aux_y*100f +customScroll);
					
					upgrades.get(i).origin_x = upgrades.get(i).mini_bg.getX() +upgrades.get(i).mini_bg.getWidth()/2;
					upgrades.get(i).origin_y =  upgrades.get(i).mini_bg.getY() +upgrades.get(i).mini_bg.getHeight()/2 -customScroll;
				}
				
			}
			
		}
		
		occupied_y += 20 +(aux_y +1)*100f;
		
		customScrollMax = occupied_y -500f;
		if (customScrollMax < 0) { customScrollMax = 0; }
		
		
		if (upgradeSelected == null) {
			
			if (transition3 > 0f) {
				
				Upgrade t = lastUpgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.background2.draw(batch, transition3 *t.custom_alpha);
					t.info.draw(batch, transition3 *t.custom_alpha);
					t.buy.draw(batch, transition3 *t.custom_alpha);
					
					t.mini_bg.draw(batch, 1f *t.custom_alpha);
					t.background.draw(batch, transition3 *t.custom_alpha);
					t.label.draw(batch, transition3 *t.custom_alpha);
					t.icon.draw(batch, 1f *t.custom_alpha);
					
					if (gameParent.mode != 1) {
						batch.setShader(Shaders.instance.hueShader);
						Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
					}
					t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
					batch.setShader(gameParent.defaultShader);

				}
				
			}
			else if (transition2 > 0f) {
				
				Upgrade t = lastUpgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.mini_bg.draw(batch, 1f *t.custom_alpha);
					t.icon.draw(batch, 1f *t.custom_alpha);

					if (gameParent.mode != 1) {
						batch.setShader(Shaders.instance.hueShader);
						Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
					}
					t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
					batch.setShader(gameParent.defaultShader);

				}
				
			}
			else {
				for (int i = 0; i < upgrades.size(); i++) {
					if (upgrades.get(i) == lastUpgradeSelected) {
						
						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, 1f *t.custom_alpha);
							t.icon.draw(batch, 1f *t.custom_alpha);
							
							if (gameParent.mode != 1) {
								batch.setShader(Shaders.instance.hueShader);
								Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
							}
							t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
							batch.setShader(gameParent.defaultShader);
							
						}
						
						
					}
					else {
						
						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, (1f - transition1) *t.custom_alpha);
							t.icon.draw(batch, (1f - transition1) *t.custom_alpha);
							
							if (gameParent.mode != 1) {
								batch.setShader(Shaders.instance.hueShader);
								Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
							}
							t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
							batch.setShader(gameParent.defaultShader);

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
							
							t.mini_bg.draw(batch, 1f *t.custom_alpha);
							t.icon.draw(batch, 1f *t.custom_alpha);
							
							if (gameParent.mode != 1) {
								batch.setShader(Shaders.instance.hueShader);
								Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
							}
							t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
							batch.setShader(gameParent.defaultShader);
							
						}
						
					}
					else {

						Upgrade t = upgrades.get(i);
						
						if (t.state != "unexistant") {
							
							t.mini_bg.draw(batch, (1f - transition1) *t.custom_alpha);
							t.icon.draw(batch, (1f - transition1) *t.custom_alpha);
							
							if (gameParent.mode != 1) {
								batch.setShader(Shaders.instance.hueShader);
								Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
							}
							t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
							batch.setShader(gameParent.defaultShader);
							
						}
						
					}
				}

			}
			else if (transition2 < 1f) {
				
				Upgrade t = upgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.mini_bg.draw(batch, 1f *t.custom_alpha);
					t.icon.draw(batch, 1f *t.custom_alpha);

					if (gameParent.mode != 1) {
						batch.setShader(Shaders.instance.hueShader);
						Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
					}
					t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
					batch.setShader(gameParent.defaultShader);
					
				}
				
			}
			else {
				
				Upgrade t = upgradeSelected;
				
				if (t.state != "unexistant") {
					
					t.background2.draw(batch, transition3 *t.custom_alpha);
					t.info.draw(batch, transition3 *t.custom_alpha);
					t.buy.draw(batch, transition3 *t.custom_alpha);

					t.mini_bg.draw(batch, 1f *t.custom_alpha);
					t.background.draw(batch, transition3 *t.custom_alpha);
					t.label.draw(batch, transition3 *t.custom_alpha);
					t.icon.draw(batch, 1f *t.custom_alpha);
					
					if (gameParent.mode != 1) {
						batch.setShader(Shaders.instance.hueShader);
						Shaders.instance.hueShader.setUniformf("hue", t.variation_color);
					}
					t.ribbon.draw(batch, t.ribbon.getColor().a *transition3);
					batch.setShader(gameParent.defaultShader);
					
				}
				
			}
		}
		
		
		//super.draw(batch, parentAlpha);
	}
	
	public boolean tap(float x, float y, int count, int button) {

		if (upgradeSelected == null && transition1 == 0f) {
			for (int i = 0; i < upgrades.size(); i++) {
				if (isOnSprite(upgrades.get(i).mini_bg, x, y) && (upgrades.get(i).state != "unexistant") ) {
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
