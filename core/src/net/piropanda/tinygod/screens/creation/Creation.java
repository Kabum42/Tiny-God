package net.piropanda.tinygod.screens.creation;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.codex.Codex;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Creation extends Screen {

	public static final int POSITION = 3;
	
	
	public Creation() {
		super();
		
		for(int i=0; i<10; i++) {
			ImageButton button = new ImageButton(new TextureRegionDrawable(new TextureRegion(TG.Graphics.assets.get("button-default-up.png", Texture.class))));
			button.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					Game.instance.easeTo(Codex.POSITION);
					Game.instance.codex.open(Codex.credits);
				}
			});
			table.add(button).pad(10);
			table.row();
		}
	}
	
}
