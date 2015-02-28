package net.piropanda.tinygod.screens.creation;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.helpers.ProducerInfo;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Producer extends Group {
	
	private String id;
	private ProducerScreenTab tab;
	private TextButton button;
	
	
	public Producer(Screen screen, String id) {
		this.id = id;
		
		tab = new ProducerScreenTab(screen, this);
		button = new TextButton(id, TG.Graphics.skin);
		
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Game.instance.creation.open(tab);
			}
		});
		button.setDisabled(true);
		button.setWidth(300);
		addActor(button);
		
		this.setSize(button.getWidth(), button.getHeight());
	}
	
	public String getId() { return id; }
	
	public float getCost() { return (float) (ProducerInfo.getBaseCost(id) * Math.pow(1.1f, GameInfo.producers.get(id))); }
	
	public float getLps() { return ProducerInfo.getLps(id); }
	
	@Override
	public void act(float dt) {
		super.act(dt);
	}
	
	/**
	 * @return true if the user's total love gained is bigger than this producer's love requirement
	 */
	public boolean isUnlockable() {
		return GameInfo.totalLove >= ProducerInfo.getBaseCost(id);
	}
	
	/**
	 * Makes this producer usable (a.k.a. enables the button so the user can purchase it)
	 */
	public void unlock() {
		button.setDisabled(false);
	}

}
