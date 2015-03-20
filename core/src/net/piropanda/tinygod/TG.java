package net.piropanda.tinygod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TG {

	public static class Display {
		public static final int WIDTH = 432;
		public static final int HEIGHT = 720;
		// EL ARTE TIENE PROPORCIONES DE 1188 x 1980	
		// ESO SON LAS EST�NDAR MULTIPLICADAS * 2.75
		public static final String TITLE = "Tiny God";
	}
	
	public static class Graphics {
		public static AssetManager assets = new AssetManager();
        public static Skin skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
	}
	
}
