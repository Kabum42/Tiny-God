package net.piropanda.tinygod.screens.god;

import java.util.ArrayList;

import net.piropanda.tinygod.GameInfo;
import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.gamestates.MiniGames;
import net.piropanda.tinygod.screens.Screen;
import net.piropanda.tinygod.screens.earth.Earth;
import net.piropanda.tinygod.screens.earth.Physical;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
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
	
	public Game gameParent;
	
	private Earth earth;
	private boolean onYahvy = true;
	public float earth_distant = 8000f;
	
	private Sprite message_background;
	private Label label_message;
	
	private int current_message = 0;
	private float message_frequency = 2f;
	private float message_duration = 2f;
	private float message_cooldown = message_frequency;
	
	public Sound soundTap;
	private Sprite aura;
	private Sprite aura2;
	private Yahvy yahvy;
	public ArrayList<Mouth> mouths = new ArrayList<Mouth>();
	public float mouth_rotation = 0f;
	public float mouth_rotation2 = 0f;
	public float mouth_rotation3 = 0f;
	public float mouth_rotation4 = 0f;
	
	public float timer = 0f;
	private Sprite base_timer;
	private Sprite fill_timer;
	private float rainbow_timer = 0f;
	private Sprite go_timer;
	private float go_timer_alpha = 0f;
	private float sinus_timer = 0f;
	private float scale_timer = 0f;
	
	public float spinning = 1f;
	public boolean clockwise = true;
	
	public God(Game g) {
		super();
		
		gameParent = g;
		
		soundTap = TG.assets.get("common/tap.mp3", Sound.class);
		
		/*
		this.bgTab = new Sprite(TG.assets.get("pixel.png", Texture.class));
		//this.bgTab.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		this.bgTab.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		this.bgTab.setX(TG.Display.WIDTH*2.5f - this.bgTab.getWidth()/2);
		//this.bgTab.setY(0 - this.bgTab.getHeight()/2 +this.bgTab.getHeight()/2*this.bgTab.getScaleY());
		this.bgTab.setY(TG.Display.HEIGHT*0.5f - this.bgTab.getHeight()/2);
		this.bgTab.setColor(100f/255f, 130f/255f, 210f/255f, 1f);
		
		this.bgTab2 = new Sprite(TG.assets.get("pixel.png", Texture.class));
		//this.bgTab2.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		this.bgTab2.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		this.bgTab2.setX(TG.Display.WIDTH*2.5f - this.bgTab2.getWidth()/2);
		//this.bgTab2.setY(0 - this.bgTab2.getHeight()/2 +this.bgTab2.getHeight()/2*this.bgTab2.getScaleY());
		this.bgTab2.setY(TG.Display.HEIGHT*0.5f - this.bgTab2.getHeight()/2);
		this.bgTab2.setColor(255f/255f, 0f/255f, 0f/255f, 1f);
		*/
		
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
		
		/*
		
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
		table.add().padBottom(TG.Display.WIDTH);
		
		*/
		
//		for (int i = 0; i < 300; i++) {
//			addMouth();
//		}
		
		message_background = new Sprite(TG.assets.get("producers/bg.png", Texture.class));
		message_background.setScale(1f/2.75f, (1f/2.75f)*1.5f);
		
		label_message = new Label("Message", TG.Graphics.font1);
		label_message.setColor(Color.WHITE);
		label_message.setWrap(true);
		label_message.setWidth(300);
		
		base_timer = new Sprite(TG.assets.get("god/base_timer.png", Texture.class));
		base_timer.setScale(1f/2.75f);
		base_timer.setX(TG.Display.WIDTH*2.5f -base_timer.getWidth()/2);
		
		fill_timer = new Sprite(TG.assets.get("god/fill_timer.png", Texture.class));
		fill_timer.setScale(1f/2.75f);
		
		go_timer = new Sprite(TG.assets.get("god/go_timer.png", Texture.class));
		go_timer.setScale(1f/2.75f);
		go_timer.setX(TG.Display.WIDTH*2.5f -go_timer.getWidth()/2);
		
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
		
		gameParent.background_parallax.setAlpha(alpha_1);
		//bgTab2.setAlpha(alpha_2);

		this.yahvy.origin_y = 300 +this.getScrollPane().getVisualScrollY();
		//earth.act(dt);
		
		message_cooldown -= dt;
		if (message_cooldown <= -message_frequency) {
			message_cooldown = message_duration;
			current_message = (int) (Math.random()*(float)Lang.MESSAGE_AMOUNT);
		}
		
		label_message.setText("\""+Lang.getText(Lang.MESSAGES[current_message]) + "\"");
		//label_message.pack();
		
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
		
		base_timer.setY(TG.Display.HEIGHT*0.10f -base_timer.getHeight()/2 +getScrollPane().getVisualScrollY());
		
		if (timer < 100f) { 
			timer += dt*10f;
			go_timer_alpha = 0f;
			if (timer >= 100f) {
				timer = 100f;
				rainbow_timer = 0f;
			}
		}
		else {
			rainbow_timer += dt*2.5f;
			if (rainbow_timer > 1f) {
				rainbow_timer -= 2f;
			}
			
			if (go_timer_alpha < 0.8f) { go_timer_alpha += dt; }
		}
		//if (timer >= 100f) { timer -= 100f; }
		fill_timer.setScale(timer*9.45f*(1f/2.75f), fill_timer.getScaleY());
		fill_timer.setY(base_timer.getY() +base_timer.getHeight()/2 -fill_timer.getHeight()/2);
		fill_timer.setX(-172f +base_timer.getX() +base_timer.getWidth()/2 -fill_timer.getWidth()/2 +fill_timer.getWidth()/2*fill_timer.getScaleX());
		
		sinus_timer += dt*100f;
		if (sinus_timer > 360) { sinus_timer -= 360f; }
		
		scale_timer += dt*66;
		if (scale_timer > 360) { scale_timer -= 360f; }
		
		go_timer.setScale((float) ((1f/2.75f)*(1 +Math.sin(Math.toRadians(scale_timer))*0.1f)));
		go_timer.setY((float) (base_timer.getY() +base_timer.getHeight()/2 -go_timer.getHeight()/2 +Math.sin(Math.toRadians(sinus_timer))*5f));
		go_timer.setAlpha(go_timer_alpha);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		/*
		if (bgTab2.getColor().a > 0) {
			bgTab2.draw(batch);
		}
		*/
		
		message_background.draw(batch, 1f);
		message_background.setX(TG.Display.WIDTH*((float)POSITION+0.5f) -message_background.getWidth()/2);
		message_background.setY(490f -message_background.getHeight()/2);
		
		label_message.setX(TG.Display.WIDTH*((float)POSITION+0.5f) -label_message.getWidth()/2);
		label_message.setY(490f -label_message.getHeight()/2);
		label_message.draw(batch, 1f);
		
		
		if (onYahvy) {
			
//			aura.draw(batch);
			for (int i = mouths.size()-1; i >= 0; i--) {
				mouths.get(i).draw(batch, parentAlpha);
			}
//			for (int i = 0; i < mouths.size(); i++) {
//				mouths.get(i).draw(batch, parentAlpha);
//			}
			
			base_timer.draw(batch, parentAlpha);
			
			if (timer < 100f) { fill_timer.draw(batch, parentAlpha); }
			else {
				batch.setShader(Shaders.instance.hueShader);
				Shaders.instance.hueShader.setUniformf("hue", rainbow_timer);
				fill_timer.draw(batch, parentAlpha);
				batch.setShader(null);
			}
			go_timer.draw(batch, parentAlpha);
			
			yahvy.draw(batch, parentAlpha);
			
		}
		else {
			earth.draw(batch, parentAlpha);
		}
		
		
		super.draw(batch, parentAlpha);
		
	}
	
	@Override
	public void pan(float x, float y, float deltaX, float deltaY) {
		//earth.pan(x, y, deltaX, deltaY);
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(onYahvy) {
			
			if (timer >= 100f && isOnSprite(go_timer, x, y)) {
				timer = 0f;
				MiniGames.instance.load(MiniGames.tRexAdam);
			}
			
			//GameInfo.addLove(GameInfo.lovePerClick);
			GameInfo.addLove(GameInfo.love);
			//addMouth();
		}
		
		return false;
	}
	
	public void addMouth() {
		
		//GameInfo.producers.put(Lang.ENGLISH_WORDS[Lang.SERVANT_NAME], GameInfo.producers.get(Lang.ENGLISH_WORDS[Lang.SERVANT_NAME]) +1);
		
		if (mouths.size() < 100) {
			mouths.add(new Mouth(this, mouths.size(), TG.Display.WIDTH*2.5f, 250));
		}
	}
	
	private boolean isOnSprite(Sprite s, float x, float y) {
		
		float first_x = s.getX() + s.getWidth()/2 -s.getWidth()/2*s.getScaleX();
		float second_x = s.getX() + s.getWidth()/2 +s.getWidth()/2*s.getScaleX();
		
		float first_y = s.getY() + s.getHeight()/2 +s.getHeight()/2*s.getScaleY();
		float second_y = s.getY() + s.getHeight()/2 -s.getHeight()/2*s.getScaleY();
		
		float modified_x = (x - TG.Display.whiteSpaceX)*(1f/TG.Display.scale) +TG.Display.WIDTH*POSITION;
		float modified_y = -((y -TG.Display.whiteSpaceY)*(1f/TG.Display.scale) -TG.Display.HEIGHT);
		
		if (modified_x >= first_x && modified_x <= second_x &&
				modified_y <= first_y && modified_y >= second_y) {
			return true;
		}
		
		return false;
	}
	
}
