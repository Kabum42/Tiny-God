package net.piropanda.tinygod.screens.providence;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.screens.Screen;

public class Upgrade {
	
	private Providence providenceParent;
	public int id;
	
	public Upgrade (Screen screen, int id) {
		
		providenceParent = (Providence)screen;
		
		this.id = id;
		
//		System.out.println(Lang.getText(id));
//		System.out.println(Lang.getText(id+1));
//		System.out.println("");
		
	}

}
