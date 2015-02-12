package net.piropanda.tinygod.screens.god;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class God extends Screen {

	public static final int POSITION = 2;
	
	
	public God() {
		super();
		
		table.pad(0);
		scroll.removeListener(scroll.getListeners().get(0)); // removes the CaptureListener that enables it to scroll manually
		
		// Yahvy image
		Image image = new Image(TG.Graphics.assets.get("lord-god.png", Texture.class));
		image.setTouchable(Touchable.enabled);
		table.add(image).size(480);
		
		// new row
		table.row();
		
		// "To Earth" button
		TextButton button = new TextButton("To Earth", TG.Graphics.skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				scroll.scrollTo(0, 0, 480, 480);
				canPan = false;
			}
		});
		table.add(button);

		// space between Yahvy and the Earth
		table.row();
		table.add().padBottom(1000);
		table.row();
		
		// Earth image
		
		// "To Yahvy" button
		button = new TextButton("To Yahvy", TG.Graphics.skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				scroll.scrollTo(0, 1500, 480, 480);
				canPan = true;
			}
		});
		table.add(button);
		
		table.row();
		table.add().pad(2);
	}
	
}
