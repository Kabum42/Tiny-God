package net.piropanda.tinygod;

import net.piropanda.tinygod.gamestates.Game;
import net.piropanda.tinygod.gamestates.GameLoader;
import net.piropanda.tinygod.gamestates.MiniGames;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class TinyGod extends ApplicationAdapter {

	public static GoogleInterface googleInterface;
	
	private Stage stage;
	
	
	public TinyGod(GoogleInterface googleInterface) {
        TinyGod.googleInterface = googleInterface;
	}
	
	@Override
	public void create() {
        stage = new Stage(new FitViewport(TG.Display.WIDTH, TG.Display.HEIGHT));
        
        GameInfo.loadFromJson("");
        this.googleInterface.login();
        
        GameLoader.instance.init();
        GameLoader.instance.setVisible(true);
        Game.instance.setVisible(false);
        MiniGames.instance.setVisible(false);
        
        stage.addActor(GameLoader.instance);
        stage.addActor(Game.instance);
        stage.addActor(MiniGames.instance);
        
        Lang.initialize();
        
        Gdx.input.setInputProcessor(new InputMultiplexer(new GestureDetector(Game.instance), new GestureDetector(MiniGames.instance), stage));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
		//System.out.println("FPS: " +Gdx.graphics.getFramesPerSecond());
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
		
		if ((float)height/(float)width > (float)TG.Display.HEIGHT/(float)TG.Display.WIDTH) {
			
			//System.out.println("SOBRA VERTICAL");
			
			TG.Display.scale = (float)width/(float)TG.Display.WIDTH;
			TG.Display.whiteSpaceX = 0f;
			TG.Display.whiteSpaceY = ((float)height - (float)TG.Display.HEIGHT*(float)TG.Display.scale)/2;
			
		}
		else {
			
			//System.out.println("SOBRA HORIZONTAL");
			
			TG.Display.scale = (float)height/(float)TG.Display.HEIGHT;
			TG.Display.whiteSpaceY = 0f;
			TG.Display.whiteSpaceX = ((float)width - (float)TG.Display.WIDTH*(float)TG.Display.scale)/2;
			
		}
		
	}
	
	@Override
	public void pause() {
	}
	
	@Override
	public void resume() {
	}
	
	@Override
	public void dispose() {
	}
	
	/**
	 * @return true if the application should minimize on a back button press, false otherwise
	 */
	public boolean onBackPressed(){
		return true;
	}
	
}
