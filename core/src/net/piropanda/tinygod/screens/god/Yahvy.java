package net.piropanda.tinygod.screens.god;

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
	
	private Animation maskAnimation;
	private float maskAnimationTime = 0; 
	
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
		
		player.setAnimation(0);
		
		player.setScale(1f/2.75f);
		player.setPosition(TG.Display.WIDTH*2.5f, 300);
		
		TextureRegion[] frames = new TextureRegion[15];
		frames[0] = new TextureRegion(TG.assets.get("shaders/masks/mask001.png", Texture.class));
		frames[1] = new TextureRegion(TG.assets.get("shaders/masks/mask001.png", Texture.class));
		frames[2] = new TextureRegion(TG.assets.get("shaders/masks/mask002.png", Texture.class));
		frames[3] = new TextureRegion(TG.assets.get("shaders/masks/mask003.png", Texture.class));
		frames[4] = new TextureRegion(TG.assets.get("shaders/masks/mask004.png", Texture.class));
		frames[5] = new TextureRegion(TG.assets.get("shaders/masks/mask005.png", Texture.class));
		frames[6] = new TextureRegion(TG.assets.get("shaders/masks/mask006.png", Texture.class));
		frames[7] = new TextureRegion(TG.assets.get("shaders/masks/mask007.png", Texture.class));
		frames[8] = new TextureRegion(TG.assets.get("shaders/masks/mask006.png", Texture.class));
		frames[9] = new TextureRegion(TG.assets.get("shaders/masks/mask005.png", Texture.class));
		frames[10] = new TextureRegion(TG.assets.get("shaders/masks/mask004.png", Texture.class));
		frames[11] = new TextureRegion(TG.assets.get("shaders/masks/mask003.png", Texture.class));
		frames[12] = new TextureRegion(TG.assets.get("shaders/masks/mask002.png", Texture.class));
		frames[13] = new TextureRegion(TG.assets.get("shaders/masks/mask001.png", Texture.class));
		frames[14] = new TextureRegion(TG.assets.get("shaders/masks/mask001.png", Texture.class));

		maskAnimation = new Animation(1f, frames);
		
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
		
		maskAnimationTime = (player.getTime()/800f)*maskAnimation.getAnimationDuration();

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
						
						TextureRegion current = maskAnimation.getKeyFrame(maskAnimationTime);
						current.getTexture().bind(2);
	
						Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
						
						batch.setShader(Shaders.instance.maskShader);
						body.setScale(player.getScale());
						body.setX(sprite.getX());
						body.setY(sprite.getY());
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

}
