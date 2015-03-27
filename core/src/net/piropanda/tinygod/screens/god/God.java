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
	private Yahvy yahvy;
	public ArrayList<Mouth> mouths = new ArrayList<Mouth>();
	public float mouth_rotation = 0f;
	public float mouth_rotation2 = 0f;
	public float mouth_rotation3 = 0f;
	public float mouth_rotation4 = 0f;
	
	public float spinning = 1f;
	public boolean clockwise = true;
	
	public God() {
		super();
		
		soundTap = TG.assets.get("common/tap.mp3", Sound.class);
		
		this.bgTab = new Sprite(TG.assets.get("pixel.png", Texture.class));
		//this.bgTab.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		this.bgTab.setScale(1025f/2.75f +2f, 1405f/2.75f +2f);
		this.bgTab.setX(TG.Display.WIDTH*2.5f - this.bgTab.getWidth()/2);
		//this.bgTab.setY(0 - this.bgTab.getHeight()/2 +this.bgTab.getHeight()/2*this.bgTab.getScaleY());
		this.bgTab.setY(81f/2.75f - this.bgTab.getHeight()/2 +this.bgTab.getHeight()/2*this.bgTab.getScaleY());
		this.bgTab.setColor(100f/255f, 130f/255f, 210f/255f, 1f);
		
		this.bgTab2 = new Sprite(TG.assets.get("pixel.png", Texture.class));
		//this.bgTab2.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		this.bgTab2.setScale(1025f/2.75f +2f, 1405f/2.75f +2f);
		this.bgTab2.setX(TG.Display.WIDTH*2.5f - this.bgTab.getWidth()/2);
		//this.bgTab2.setY(0 - this.bgTab2.getHeight()/2 +this.bgTab2.getHeight()/2*this.bgTab2.getScaleY());
		this.bgTab2.setY(81f/2.75f - this.bgTab2.getHeight()/2 +this.bgTab2.getHeight()/2*this.bgTab2.getScaleY());
		this.bgTab2.setColor(255f/255f, 0f/255f, 0f/255f, 1f);
		
		table.pad(0);
		scroll.removeListener(scroll.getListeners().get(0)); // removes the CaptureListener that enables it to scroll manually
		
		
//		aura = new Sprite(TG.Graphics.assets.get("yahvy.png", Texture.class));
//		aura.setScale(1f/2.75f);
//		aura.setX(TG.Display.WIDTH*2.5f);
//		aura.setY(0);
		
		// Yahvy image
		yahvy = new Yahvy(this, TG.Display.WIDTH*2.5f, 0);
		table.add().padTop(480);
		
		
		
		
		
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
		
//		for (int i = 0; i < 300; i++) {
//			addMouth();
//		}
		
	}
	
	public boolean canPan() {
		return onYahvy;
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		float max_scroll = 8456f;
		
		float alpha_1 = 1f -((float)this.getScrollPane().getVisualScrollY()/max_scroll);
		float alpha_2 = (float)this.getScrollPane().getVisualScrollY()/max_scroll;
		
		bgTab.setAlpha(alpha_1);
		bgTab2.setAlpha(alpha_2);

		this.yahvy.origin_y = 300 +this.getScrollPane().getVisualScrollY();
		earth.act(dt);
		
		if (onYahvy) {
			yahvy.act(dt);
			
			if (clockwise) {
				spinning -= Gdx.graphics.getDeltaTime()/5;
				if (spinning <= -1f) {
					spinning = -1f;
					clockwise = false;
				}
			}
			else {
				spinning += Gdx.graphics.getDeltaTime()/5;
				if (spinning >= 1f) {
					spinning = 1f;
					clockwise = true;
				}
			}
			
			mouth_rotation += Gdx.graphics.getDeltaTime()*100f*spinning;
			mouth_rotation2 += Gdx.graphics.getDeltaTime()*50f*spinning;
			mouth_rotation3 += Gdx.graphics.getDeltaTime()*25f*spinning;
			mouth_rotation4 += Gdx.graphics.getDeltaTime()*25f/2f*spinning;
			
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
		
		
		if (bgTab2.getColor().a > 0) {
			bgTab2.draw(batch);
		}
		if (bgTab.getColor().a > 0) {
			bgTab.draw(batch);
		}
		

		
		if (onYahvy) {
			
//			aura.draw(batch);
			for (int i = mouths.size()-1; i >= 0; i--) {
				mouths.get(i).draw(batch, parentAlpha);
			}
//			for (int i = 0; i < mouths.size(); i++) {
//				mouths.get(i).draw(batch, parentAlpha);
//			}
			yahvy.draw(batch, parentAlpha);
		}
		else {
			earth.draw(batch, parentAlpha);
		}
		
		
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
			addMouth();
		}
		
		return false;
	}
	
	public void addMouth() {
		mouths.add(new Mouth(this, mouths.size(), TG.Display.WIDTH*2.5f, 250));
	}
	
}
