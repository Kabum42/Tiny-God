package net.piropanda.tinygod.screens.god;

import java.text.DecimalFormat;
import java.util.Iterator;

import net.piropanda.tinygod.Shaders;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.spriter.LibGdxLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.brashmonkey.spriter.Data;
import com.brashmonkey.spriter.Player;
import com.brashmonkey.spriter.SCMLReader;
import com.brashmonkey.spriter.Timeline;
import com.brashmonkey.spriter.Entity.CharacterMap;

public class Yahvy {
	
	public God screen;
	public float origin_x;
	public float origin_y;
	
	public static int IdleBlink = 0;
	public static int TapEye = 1;
	public static int TapBody = 2;
	public static int TapScreen = 3;
	public static int Annoyed = 4;
	public static int EnterToSleepy = 5;
	public static int SleepyLoop = 6;
	public static int SleepyBlink = 7;
	public static int EnterToSleep = 8;
	public static int SleepLoop = 9;
	public static int TapCritical = 10;
	public static int IdleLoop = 11;
	public static int SadLoop = 12;
	
	private float maskAnimationTime = 0; 
	
	private int currentAnimation = IdleBlink;
	private Animation[]maskAnimations = new Animation[13];
	
	private Texture tex1;
	private Sprite body;
	public Player player;
	private LibGdxLoader loader;
	
	public Yahvy(God aux_screen, float aux_origin_x, float aux_origin_y) {
		
		screen = aux_screen;
		origin_x = aux_origin_x;
		origin_y = aux_origin_y;
		
		
		FileHandle handle = Gdx.files.internal("spriter/Yahvy/YahvyAnimation.scml");
		SCMLReader scml = new SCMLReader(handle.read());
		Data data = scml.getData();
		loader = new LibGdxLoader(data);
		loader.load(handle.file());
		player = new Player(data.getEntity(0));
		
		changeAnimation(IdleLoop);
		
		player.setScale(1f/2.75f);
		player.setPosition(TG.Display.WIDTH*2.5f, 300);
		
		DecimalFormat df = new DecimalFormat("00"); 
		TextureRegion[] frames;
		
		// 0. IDLE BLINK 
		/*
		frames = new TextureRegion[18];
		
		for (int i = 1; i <= 18; i++) {
			frames[i-1] = new TextureRegion(TG.assets.get("Secuencias/Mask_0/mask_0_00" + df.format(i) + ".png", Texture.class));
		}
		
		maskAnimations[IdleBlink] = new Animation(1f, frames);
		*/
		// 11. IDLE LOOP 
		frames = new TextureRegion[43];
		
		for (int i = 1; i <= 43; i++) {
			frames[i-1] = new TextureRegion(TG.assets.get("Secuencias/Mask_11/mask_11_00" + df.format(i) + ".png", Texture.class));
		}
		
		maskAnimations[IdleLoop] = new Animation(1f, frames);
		

		
		body = new Sprite(new Texture(Gdx.files.internal("spriter/Yahvy/Yahvy_Body.png")));

		tex1 = new Texture(Gdx.files.internal("shaders/aux_mask.png")); // ESTO ESTA POR SI QUEREMOS PINTAR ALGO EN EL HUECO
		tex1.bind(1);
		//now we need to reset glActiveTexture to zero!!!! since sprite batch does not do this for us
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
		
	}
	
	public void act(float dt) {
		
		player.setPosition(player.getX(), origin_y);
		
		player.setTime((player.getTime() + Gdx.graphics.getDeltaTime()*1000));
		player.update();
		
		maskAnimationTime = (player.getTime()/800f)*maskAnimations[currentAnimation].getAnimationDuration();

	}
	
	public void draw(Batch batch, float parentAlpha) {
		
		drawSpriter(player, batch);
		
	}
	
	public void drawSpriter(Player player2, Batch batch) {
			
			CharacterMap[] maps = player2.characterMaps;
			Iterator<Timeline.Key.Object> it = player2.objectIterator();
			
			while(it.hasNext()){
				Timeline.Key.Object object = it.next();
				if(object.ref.hasFile()){
					if(maps != null){
						for(CharacterMap map: maps)
							if(map != null)
								object.ref.set(map.get(object.ref));
					}
					
					Sprite sprite = loader.get(object.ref);
					float newPivotX = (sprite.getWidth() * object.pivot.x);
					float newX = object.position.x - newPivotX;
					float newPivotY = (sprite.getHeight() * object.pivot.y);
					float newY = object.position.y - newPivotY;
					
					sprite.setX(newX);
					sprite.setY(newY);
					
					sprite.setOrigin(newPivotX, newPivotY);
					sprite.setRotation(object.angle);
					
					sprite.setScale(object.scale.x, object.scale.y);
					
					
					
					if (object.ref.file == 0) {
					//if (sprite == body) {
						
						TextureRegion current = maskAnimations[currentAnimation].getKeyFrame(maskAnimationTime);
						current.getTexture().bind(2);
	
						Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
						
						batch.setShader(Shaders.instance.maskShader);
						
						
						body.setScale(player.getScale());
						body.setX(sprite.getX());
						body.setY(sprite.getY() +10);
						body.draw(batch);
						//sprite.draw(batch);
						batch.setShader(screen.gameParent.defaultShader);
						
						
					}
					else {
						sprite.draw(batch, object.alpha);
					}
					
					
					
				}
			}
			
		}
	
	
	public void changeAnimation (int numAnimation) {
		
		maskAnimationTime = 0;
		currentAnimation = numAnimation;
		player.setAnimation(numAnimation);
	
	}

}
