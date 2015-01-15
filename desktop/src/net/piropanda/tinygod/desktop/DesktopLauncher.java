package net.piropanda.tinygod.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.piropanda.tinygod.DesktopInterface;
import net.piropanda.tinygod.TinyGod;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// 2x3 ratio
		config.width = TinyGod.DEFAULT_WIDTH;
		config.height = TinyGod.DEFAULT_HEIGHT;
		
		//config.width = 480;
		//config.height = 600;
		
		config.title = TinyGod.TITLE;
		new LwjglApplication(new TinyGod(new DesktopInterface()), config);
	}
	
}
