package com.piropanda.projectx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.piropanda.projectx.DesktopInterface;
import com.piropanda.projectx.ProjectX;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// 2x3 ratio
		config.width = ProjectX.DEFAULT_WIDTH;
		config.height = ProjectX.DEFAULT_HEIGHT;
		
		//config.width = 480;
		//config.height = 600;
		
		config.title = ProjectX.TITLE;
		new LwjglApplication(new ProjectX(new DesktopInterface()), config);
	}
	
}
