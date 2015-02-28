package net.piropanda.tinygod.screens.providence;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class ProvidenceItem extends Group {

	protected String id;
	protected ScreenTab tab;
	protected TextButton button;
	protected boolean unlocked, acquired;
	
	
	public ProvidenceItem(Screen screen, String id) {
		super();
		
		this.id = id;
		
		button = new TextButton(id, TG.Graphics.skin);
		
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Game.instance.providence.open(tab);
			}
		});
		button.setWidth(300);
		addActor(button);
		
		this.setSize(button.getWidth(), button.getHeight());
	}
	
	public void unlock() { unlocked = true; }
	
	public boolean isUnlocked() { return unlocked; }
	
	public boolean isAcquired() { return acquired; }

	@Override
	public void act(float dt) {
		super.act(dt);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
}
