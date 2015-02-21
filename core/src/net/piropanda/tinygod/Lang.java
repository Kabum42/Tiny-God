package net.piropanda.tinygod;

import java.util.HashMap;

public class Lang {

	private static HashMap<String, String> language = new HashMap<String, String>();
	
	
	public static String get(String id) {
		if(language.containsKey(id)) language.get(id);
		return id + ": id not found";
	}
	
}
