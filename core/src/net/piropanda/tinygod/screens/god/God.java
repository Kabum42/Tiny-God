package net.piropanda.tinygod.screens.god;

import java.util.ArrayList;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.earth.Earth;
import net.piropanda.tinygod.screens.earth.Physical;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
	
	private Earth earth;
	private boolean onYahvy = true;
	public float earth_distant = 8000f;
	
	public Sound soundTap;
	private Sprite aura;
	private Sprite aura2;
	private Sprite yahvy;
	public ArrayList<Mouth> mouths = new ArrayList<Mouth>();
	public float mouth_rotation = 0f;
	
	public God() {
		super();
		
		soundTap = Gdx.audio.newSound(Gdx.files.internal("audio/tap-mellow.mp3"));
		
		this.bgTab.setDrawable(new SpriteDrawable(new Sprite(TG.Graphics.assets.get("transition.png", Texture.class))));
		this.bgTab.setScale(TG.Display.WIDTH, (earth_distant +TG.Display.WIDTH*2)*(1f/this.bgTab.getHeight()));
		
		this.bgTab2.setDrawable(new SpriteDrawable(new Sprite(TG.Graphics.assets.get("transition2.png", Texture.class))));
		this.bgTab2.setScale(TG.Display.WIDTH, (earth_distant +TG.Display.WIDTH*2)*(1f/this.bgTab.getHeight()));
		this.bgTab2.setVisible(true);

		table.pad(0);
		scroll.removeListener(scroll.getListeners().get(0)); // removes the CaptureListener that enables it to scroll manually
		
		
//		aura = new Sprite(TG.Graphics.assets.get("yahvy.png", Texture.class));
//		aura.setScale(1f/2.75f);
//		aura.setX(TG.Display.WIDTH*2.5f);
//		aura.setY(0);
		
		// Yahvy image
		yahvy = new Sprite(TG.Graphics.assets.get("yahvy.png", Texture.class));
		yahvy.setScale(1f/2.75f);
		yahvy.setX(TG.Display.WIDTH*2.5f -yahvy.getWidth()/2 );
		//table.add(image).size(480);
		table.add().padTop(480);
		
		
		
//		for (int i = 0; i < 30; i++) {
//			addMouth();
//		}
		
		
		
		// new row
		table.row();

		
		
		//table.add(label).row();
		
		// "To Earth" button
		TextButton button = new TextButton("To Earth", TG.Graphics.skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				scroll.scrollTo(0, 0, TG.Display.WIDTH, TG.Display.WIDTH);
				onYahvy = false;
				
				soundTap.play(1f);
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
				
				earth.soundCrickets.stop();
				earth.soundCricketsPlaying = 0f;
				soundTap.play(1f);
			}
		});
		table.add(button);
		table.row();
		
		earth = new Earth(this);
//		table.add(earth).size(TG.Display.WIDTH);
		table.add().padBottom(TG.Display.WIDTH);
		
	}
	
	public boolean canPan() {
		return onYahvy;
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		this.bgTab.setY(-180 +this.bgTab.getHeight() -this.bgTab.getHeight()*this.bgTab.getScaleY() +this.getScrollPane().getVisualScrollY());
		this.bgTab2.setY(-280 +this.bgTab.getHeight() -this.bgTab.getHeight()*this.bgTab.getScaleY() +this.getScrollPane().getVisualScrollY());
		this.yahvy.setY(140 -yahvy.getHeight()/2 +yahvy.getHeight()/2*yahvy.getScaleY() +this.getScrollPane().getVisualScrollY());
		earth.act(dt);
		
		if (onYahvy) {
			mouth_rotation += Gdx.graphics.getDeltaTime()*100f;
			if (mouth_rotation >= 360) { mouth_rotation -= 360; }
			for (int i = 0; i < mouths.size(); i++) {
				mouths.get(i).act(dt);
			}
		}
		else {
			earth.light(earth.earth);
		}
		
		
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		if (onYahvy) {
			
//			aura.draw(batch);
			for (int i = 0; i < mouths.size(); i++) {
				mouths.get(i).draw(batch, parentAlpha);
			}
			yahvy.draw(batch, parentAlpha);
		}
		else {
			earth.draw(batch, parentAlpha);
		}
		
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		earth.pan(x, y, deltaX, deltaY);
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(onYahvy) {
			GameInfo.addLove(GameInfo.lovePerClick);
			addMouth();
		}
		
		return false;
	}
	
	public void addMouth() {
		mouths.add(new Mouth(this, mouths.size(), TG.Display.WIDTH*2.5f, 250));
	}
	
}
