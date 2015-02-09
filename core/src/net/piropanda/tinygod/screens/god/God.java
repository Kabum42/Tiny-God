package net.piropanda.tinygod.screens.god;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class God extends Group {

	public static final int POSITION = 2;
	
	
	public God() {
		Image image = new Image(TG.Graphics.assets.get("lord-god.png", Texture.class));
		image.setTouchable(Touchable.enabled);
		this.addActor(image);
	}
	
}
