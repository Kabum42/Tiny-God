package net.piropanda.tinygod.desktop;

import net.piropanda.tinygod.DesktopInterface;
import net.piropanda.tinygod.TG;
import net.piropanda.tinygod.TinyGod;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.y = 5;
		config.width = TG.Display.WIDTH;
		config.height = TG.Display.HEIGHT;
		config.title = TG.Display.TITLE;
		
		new LwjglApplication(new TinyGod(new DesktopInterface()), config);
	}
	
}
