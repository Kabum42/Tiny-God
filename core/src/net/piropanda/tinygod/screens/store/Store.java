package net.piropanda.tinygod.screens.store;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.MiniGames;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Store extends Screen {

	public static final int POSITION = 4;
	
	
	public Store() {
		super();
		
		this.bgTab.setX(TG.Display.WIDTH*POSITION);
		
		TextButton button = new TextButton("to minigame!", TG.Graphics.skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				MiniGames.instance.load(MiniGames.tRexAdam);
			}
		});
		table.add(button);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		bgTab.draw(batch);
		super.draw(batch, parentAlpha);
	}
	
}
