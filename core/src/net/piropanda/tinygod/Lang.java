package net.piropanda.tinygod;

import java.util.HashMap;

public class Lang {
	
	public static boolean initialized = false;
	
	public static int CURRENT_VALUE = 0;
	
	public static int ENGLISH_VALUE = 0;
	public static int SPANISH_VALUE = 1;
	
	public static String[][]LANGUAGES = new String[15][];
	
	public static String[]ENGLISH_WORDS = new String[20];
	public static String[]SPANISH_WORDS = new String[20];
	
	public static int SERVANT_TEXT = 0;
	public static int HUMAN_TEXT = 1;

	//private static HashMap<String, Integer> languages = new HashMap<String, Integer>();

	public static void initialize() {
		initialized = true;
		//languages.put("ENGLISH", 0);
		
		LANGUAGES[ENGLISH_VALUE] = ENGLISH_WORDS;
		LANGUAGES[SPANISH_VALUE] = SPANISH_WORDS;
		
		//ENGLISH
		ENGLISH_WORDS[SERVANT_TEXT] = "These are servants";
		ENGLISH_WORDS[HUMAN_TEXT] = "These are humans";
		
		
		//SPANISH
		SPANISH_WORDS[SERVANT_TEXT] = "Estos son sirvientes";
		SPANISH_WORDS[HUMAN_TEXT] = "Estos son humanos";
		
		
		//END
		System.out.println("Languages initialized");
	}
	
	public static void setLanguage(int i) {
		CURRENT_VALUE = i;
	}
	
	public static String getLanguage() {
		if (CURRENT_VALUE == 0) {
			return "ENGLISH";
		}
		else if (CURRENT_VALUE == 1) {
			return "SPANISH";
		}
		else {
			return "NONE";
		}
	}
	
	public static String getText(int i) {
		return LANGUAGES[CURRENT_VALUE][i];
	}
	
	/*
	private static HashMap<String, String> language = new HashMap<String, String>();
	
	
	public static String get(String id) {
		if(language.containsKey(id)) language.get(id);
		return id + ": id not found";
	}
	*/
	
}
