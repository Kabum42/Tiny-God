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
		
		description = new Label("", TG.Graphics.skin);
		//updateDescriptionText(producer);
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
		
//		TextButton purchase = new TextButton("Purchase", TG.Graphics.skin);
//		purchase.addListener(new ChangeListener() {
//			@Override
//			public void changed(ChangeEvent event, Actor actor) {
//				if(GameInfo.love >= producer.getCost()) {
//					GameInfo.love -= producer.getCost();
//					GameInfo.addProducer(producer.getId());
//					
//					updateDescriptionText(producer);
//				}
//			}
//		});
		//content.add(purchase);
	}
	
	/**
	 * updates the description label with the right amount of producers and it's current cost
	 * @param producer
	 */
//	private void updateDescriptionText(Producer producer) {
//		description.setText(
//			producer.getId() + "\n\n"
//			+ "<producer description here>\n\n"
//			+ "Amount: " + GameInfo.producers.get(producer.getId()) + "\n"
//			+ "Cost: " + producer.getCost() + "\n"
//			+ "LPS: " + producer.getLps() + " (" + producer.getLps()*GameInfo.producers.get(producer.getId()) + ")"
//		);
//	}
	
}
