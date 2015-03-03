package net.piropanda.tinygod.screens.god;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.earth.Earth;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class God extends Screen {

	public static final int POSITION = 2;
	
	private Label label;
	private Earth earth;
	private boolean onYahvy = true;
	public float earth_distant = 8000f;
	
	public God() {
		super();
		
		this.bgTab.setDrawable(new SpriteDrawable(new Sprite(TG.Graphics.assets.get("transition.png", Texture.class))));
		this.bgTab.setScale(TG.Display.WIDTH, (earth_distant +TG.Display.WIDTH*2)*(1f/this.bgTab.getHeight()));
		
		this.bgTab2.setDrawable(new SpriteDrawable(new Sprite(TG.Graphics.assets.get("transition2.png", Texture.class))));
		this.bgTab2.setScale(TG.Display.WIDTH, (earth_distant +TG.Display.WIDTH*2)*(1f/this.bgTab.getHeight()));
		this.bgTab2.setVisible(true);

		table.pad(0);
		scroll.removeListener(scroll.getListeners().get(0)); // removes the CaptureListener that enables it to scroll manually
		
		// Yahvy image
		Image image = new Image(TG.Graphics.assets.get("lord-god.png", Texture.class));
		image.setTouchable(Touchable.enabled);
		table.add(image).size(TG.Display.WIDTH);
		
		// new row
		table.row();

		
		label = new Label("Love: ", TG.Graphics.skin); 
		table.add(label).row();
		
		// "To Earth" button
		TextButton button = new TextButton("To Earth", TG.Graphics.skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				scroll.scrollTo(0, 0, TG.Display.WIDTH, TG.Display.WIDTH);
				onYahvy = false;
			}
		});
		table.add(button);
		table.row();

		// space between Yahvy and the Earth
		table.row();
		table.add().padBottom(earth_distant);
		table.row();
		
		// "To Yahvy" button
		button = new TextButton("To Yahvy", TG.Graphics.skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				scroll.scrollTo(0, 9999, 480, 480);
				onYahvy = true;
			}
		});
		table.add(button);
		table.row();
		
		earth = new Earth(this);
		table.add(earth).size(TG.Display.WIDTH);
		
	}
	
	public boolean canPan() {
		return onYahvy;
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		label.setText("Love: " + GameInfo.love);
		
		this.bgTab.setY(-180 +this.bgTab.getHeight() -this.bgTab.getHeight()*this.bgTab.getScaleY() +this.getScrollPane().getVisualScrollY());
		this.bgTab2.setY(-180 +this.bgTab.getHeight() -this.bgTab.getHeight()*this.bgTab.getScaleY() +this.getScrollPane().getVisualScrollY());
		
		earth.light(earth.earth);
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		earth.pan(x, y, deltaX, deltaY);
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(onYahvy) {
			GameInfo.addLove(GameInfo.lovePerClick);
		}
		
		return false;
	}
	
}
