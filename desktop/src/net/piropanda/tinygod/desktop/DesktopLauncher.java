package net.piropanda.tinygod.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.TinyGod;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = TG.Display.WIDTH;
		config.height = TG.Display.HEIGHT;
		
		new LwjglApplication(new TinyGod(), config);
	}
}
