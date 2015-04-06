package net.piropanda.tinygod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TG {
	
	public static AssetManager assets = new AssetManager();

	public static class Display {
		public static final int WIDTH = 432;
		public static final int HEIGHT = 720;
		
		public static float whiteSpaceX = 0f;
		public static float whiteSpaceY = 0f;
		
		public static float scale = 1f;
		// EL ARTE TIENE PROPORCIONES DE 1188 x 1980	
		// ESO SON LAS ESTÁNDAR MULTIPLICADAS * 2.75
		public static final String TITLE = "Tiny God";
	}
	
	public static class Graphics {
        public static Skin skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
        public static LabelStyle font1 = new LabelStyle(new BitmapFont(Gdx.files.internal("fonts/font_Comfortaa.fnt")), Color.WHITE);
        public static LabelStyle font2 = new LabelStyle(new BitmapFont(Gdx.files.internal("fonts/font_Arial.fnt")), Color.WHITE);
	}

	
}
