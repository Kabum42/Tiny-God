package net.piropanda.tinygod;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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
		// ESO SON LAS EST�NDAR MULTIPLICADAS * 2.75
		public static final String TITLE = "Tiny God";
	}
	
	public static class Graphics {
        public static Skin skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
        public static LabelStyle font1 = new LabelStyle(new BitmapFont(Gdx.files.internal("fonts/font_Comfortaa.fnt")), Color.WHITE);
        public static LabelStyle font2 = new LabelStyle(new BitmapFont(Gdx.files.internal("fonts/font_Arial.fnt")), Color.WHITE);
	}
	
	public static String formattedNumber(double d) {
		
		String result = "";
		String finalWord = "";
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator('.'); 
		DecimalFormat df = new DecimalFormat("0.000", otherSymbols); 
		
		int iterations = 0;
		
		while (d > 1000) {
			iterations++;
			d = d / 1000;
		}
		
		if (iterations == 1) {
			finalWord = "K";
		}
		else if (iterations == 2) {
			finalWord = "million";
		}
		else if (iterations == 3) {
			finalWord = "billion";
		}
		else if (iterations == 4) {
			finalWord = "trillion";
		}
		else if (iterations == 5) {
			finalWord = "quadrillion";
		}
		else if (iterations == 6) {
			finalWord = "quintillion";
		}
		else if (iterations == 7) {
			finalWord = "sextillion";
		}
		else if (iterations == 8) {
			finalWord = "septillion";
		}
		else if (iterations == 9) {
			finalWord = "octillion";
		}
		else if (iterations == 10) {
			finalWord = "nonillion";
		}
		
		result = df.format(d) + " " + finalWord;
		
		return result;
	}

	
}
