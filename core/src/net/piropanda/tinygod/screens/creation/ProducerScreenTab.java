package net.piropanda.tinygod.screens.creation;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.ScreenTab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class ProducerScreenTab extends ScreenTab {

	private Label description;
	
	
	public ProducerScreenTab(Screen screen, final Producer producer) {
		super(screen);
		
		String text = producer.getId() + "\n\nLOREM IPSUM SHIT";
		description = new Label(text, TG.Graphics.skin);
		description.setFontScale(TG.Display.WIDTH / Gdx.graphics.getWidth()); // scale the font to a readable size
		description.setWrap(true);
		Container<Label> container = new Container<Label>(description);
		container.prefWidth(350);
		container.padBottom(25);
		content.add(container);
		
		content.row();
		
		TextButton upgrade = new TextButton("Upgrade", TG.Graphics.skin);
		content.add(upgrade);
		
		content.row();
		
		TextButton purchase = new TextButton("Purchase", TG.Graphics.skin);
		purchase.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if(GameInfo.love >= producer.getCost()) {
					GameInfo.addBuilding(producer.getId());
					// change text description
				}
			}
		});
		content.add(purchase);
	}

}
