package net.piropanda.tinygod;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Lang {
	
	public static boolean initialized = false;
	
	public static int CURRENT_VALUE = 0;
	
	public static int ENGLISH_VALUE = 0;
	public static int SPANISH_VALUE = 1;
	
	public static String[][]LANGUAGES = new String[10][];
	
	public static String[]ENGLISH_WORDS = new String[300];
	public static String[]SPANISH_WORDS = new String[300];
	
	// MISCELLANEOUS
	public static int TRANSLATOR_MALE = 				0;
	public static int TRANSLATOR_FEMALE = 				1;
	public static int TRANSLATORS = 					2;
	public static int BUILDING = 						3;
	public static int BUILDINGS = 						4;
	public static int UPGRADE = 						5;
	public static int UPGRADES = 						6;
	public static int ACHIEVEMENT = 					7;
	public static int ACHIEVEMENTS = 					8;
	public static int LOVE_SINCE_BEGINNING_GAME = 		9;
	public static int LOVE_SINCE_BEGINNING_TIMES = 		10;
	public static int PRODUCTION_MULTIPLIER = 			11;
	public static int CURRENT_LOVE = 					12;
	public static int LOVE_PER_CLICK = 					13;
	public static int CRITICAL_CLICK = 					14;
	public static int CRITICAL_CLICK_CHANCE = 			15;
	public static int NUMBER_OF_CLICKS = 				16;
	public static int NUMBER_OF_MIRACLES = 				17;
	public static int GAIN_BASE_LOVE = 					18;
	public static int PRODUCE_TWICE_LOVE = 				19;
	
	// SERVANT
	public static int SERVANT_NAME = 					20;
	public static int SERVANT_DESCRIPTION = 			21;
	public static int SERVANT_UPGRADE_1 = 				22;
	public static int SERVANT_UPGRADE_1_JOKE =  		23;
	public static int SERVANT_UPGRADE_2 = 				24;
	public static int SERVANT_UPGRADE_2_JOKE =  		25;
	public static int SERVANT_UPGRADE_3 = 				26;
	public static int SERVANT_UPGRADE_3_JOKE =  		27;
	public static int SERVANT_UPGRADE_4 = 				28;
	public static int SERVANT_UPGRADE_4_JOKE =  		29;
	public static int SERVANT_UPGRADE_5 = 				30;
	public static int SERVANT_UPGRADE_5_JOKE =  		31;
	public static int SERVANT_UPGRADE_6 = 				32;
	public static int SERVANT_UPGRADE_6_JOKE =  		33;
	public static int SERVANT_UPGRADE_7 = 				34;
	public static int SERVANT_UPGRADE_7_JOKE =  		35;
	public static int SERVANT_UPGRADE_8 = 				36;
	public static int SERVANT_UPGRADE_8_JOKE =  		37;
	public static int SERVANT_UPGRADE_9 = 				38;
	public static int SERVANT_UPGRADE_9_JOKE =  		39;
	public static int SERVANT_UPGRADE_10 = 				40;
	public static int SERVANT_UPGRADE_10_JOKE = 		41;
	
	// HUMAN
	public static int HUMAN_NAME = 						42;
	public static int HUMAN_DESCRIPTION = 				43;
	public static int HUMAN_UPGRADE_1 = 				44;
	public static int HUMAN_UPGRADE_1_JOKE =  			45;
	public static int HUMAN_UPGRADE_2 = 				46;
	public static int HUMAN_UPGRADE_2_JOKE =  			47;
	public static int HUMAN_UPGRADE_3 = 				48;
	public static int HUMAN_UPGRADE_3_JOKE =  			49;
	public static int HUMAN_UPGRADE_4 = 				50;
	public static int HUMAN_UPGRADE_4_JOKE =  			51;
	public static int HUMAN_UPGRADE_5 = 				52;
	public static int HUMAN_UPGRADE_5_JOKE =  			53;
	public static int HUMAN_UPGRADE_6 = 				54;
	public static int HUMAN_UPGRADE_6_JOKE =  			55;
	public static int HUMAN_UPGRADE_7 = 				56;
	public static int HUMAN_UPGRADE_7_JOKE =  			57;
	public static int HUMAN_UPGRADE_8 = 				58;
	public static int HUMAN_UPGRADE_8_JOKE =  			59;
	public static int HUMAN_UPGRADE_9 = 				60;
	public static int HUMAN_UPGRADE_9_JOKE = 			61;
	public static int HUMAN_UPGRADE_10 = 				62;
	public static int HUMAN_UPGRADE_10_JOKE =  		63;
	
	// SPECIAL_HUMANS
	public static int SPECIAL_HUMAN_1 = 				64;
	public static int SPECIAL_HUMAN_1_JOKE =  			65;
	public static int SPECIAL_HUMAN_2 = 				66;
	public static int SPECIAL_HUMAN_2_JOKE =  			67;
	public static int SPECIAL_HUMAN_3 = 				68;
	public static int SPECIAL_HUMAN_3_JOKE =  			69;
	public static int SPECIAL_HUMAN_4 = 				70;
	public static int SPECIAL_HUMAN_4_JOKE =  			71;
	public static int SPECIAL_HUMAN_5 = 				72;
	public static int SPECIAL_HUMAN_5_JOKE =  			73;
	public static int SPECIAL_HUMAN_6 = 				74;
	public static int SPECIAL_HUMAN_6_JOKE =  			75;
	public static int SPECIAL_HUMAN_7 = 				76;
	public static int SPECIAL_HUMAN_7_JOKE =  			77;
	public static int SPECIAL_HUMAN_8 = 				78;
	public static int SPECIAL_HUMAN_8_JOKE =  			79;
	public static int SPECIAL_HUMAN_9 = 				80;
	public static int SPECIAL_HUMAN_9_JOKE =  			81;
	public static int SPECIAL_HUMAN_10 = 				82;
	public static int SPECIAL_HUMAN_10_JOKE =  			83;
	
	// PROPHET
	public static int PROPHET_NAME = 					84;
	public static int PROPHET_DESCRIPTION = 			85;
	public static int PROPHET_UPGRADE_1 = 				86;
	public static int PROPHET_UPGRADE_1_JOKE =  		87;
	public static int PROPHET_UPGRADE_2 = 				88;
	public static int PROPHET_UPGRADE_2_JOKE =  		89;
	public static int PROPHET_UPGRADE_3 = 				90;
	public static int PROPHET_UPGRADE_3_JOKE =  		91;
	public static int PROPHET_UPGRADE_4 = 				92;
	public static int PROPHET_UPGRADE_4_JOKE =  		93;
	public static int PROPHET_UPGRADE_5 = 				94;
	public static int PROPHET_UPGRADE_5_JOKE =  		95;
	public static int PROPHET_UPGRADE_6 = 				96;
	public static int PROPHET_UPGRADE_6_JOKE =  		97;
	public static int PROPHET_UPGRADE_7 = 				98;
	public static int PROPHET_UPGRADE_7_JOKE =  		99;
	public static int PROPHET_UPGRADE_8 = 				100;
	public static int PROPHET_UPGRADE_8_JOKE =  		101;
	public static int PROPHET_UPGRADE_9 = 				102;
	public static int PROPHET_UPGRADE_9_JOKE = 			103;
	public static int PROPHET_UPGRADE_10 = 				104;
	public static int PROPHET_UPGRADE_10_JOKE =  		105;
	
	// TEMPLE
	public static int TEMPLE_NAME = 					106;
	public static int TEMPLE_DESCRIPTION = 				107;
	public static int TEMPLE_UPGRADE_1 = 				108;
	public static int TEMPLE_UPGRADE_1_JOKE =  			109;
	public static int TEMPLE_UPGRADE_2 = 				110;
	public static int TEMPLE_UPGRADE_2_JOKE =  			111;
	public static int TEMPLE_UPGRADE_3 = 				112;
	public static int TEMPLE_UPGRADE_3_JOKE =  			113;
	public static int TEMPLE_UPGRADE_4 = 				114;
	public static int TEMPLE_UPGRADE_4_JOKE =  			115;
	public static int TEMPLE_UPGRADE_5 = 				116;
	public static int TEMPLE_UPGRADE_5_JOKE =  			117;
	public static int TEMPLE_UPGRADE_6 = 				118;
	public static int TEMPLE_UPGRADE_6_JOKE =  			119;
	public static int TEMPLE_UPGRADE_7 = 				120;
	public static int TEMPLE_UPGRADE_7_JOKE =  			121;
	public static int TEMPLE_UPGRADE_8 = 				122;
	public static int TEMPLE_UPGRADE_8_JOKE =  			123;
	public static int TEMPLE_UPGRADE_9 = 				124;
	public static int TEMPLE_UPGRADE_9_JOKE = 			125;
	public static int TEMPLE_UPGRADE_10 = 				126;
	public static int TEMPLE_UPGRADE_10_JOKE =  		127;
	
	// SHIP
	public static int SHIP_NAME = 						128;
	public static int SHIP_DESCRIPTION = 				129;
	public static int SHIP_UPGRADE_1 = 					130;
	public static int SHIP_UPGRADE_1_JOKE =  			131;
	public static int SHIP_UPGRADE_2 = 					132;
	public static int SHIP_UPGRADE_2_JOKE =  			133;
	public static int SHIP_UPGRADE_3 = 					134;
	public static int SHIP_UPGRADE_3_JOKE =  			135;
	public static int SHIP_UPGRADE_4 = 					136;
	public static int SHIP_UPGRADE_4_JOKE =  			137;
	public static int SHIP_UPGRADE_5 = 					138;
	public static int SHIP_UPGRADE_5_JOKE =  			139;
	public static int SHIP_UPGRADE_6 = 					140;
	public static int SHIP_UPGRADE_6_JOKE =  			141;
	public static int SHIP_UPGRADE_7 = 					142;
	public static int SHIP_UPGRADE_7_JOKE =  			143;
	public static int SHIP_UPGRADE_8 = 					144;
	public static int SHIP_UPGRADE_8_JOKE =  			145;
	public static int SHIP_UPGRADE_9 = 					146;
	public static int SHIP_UPGRADE_9_JOKE = 			147;
	public static int SHIP_UPGRADE_10 = 				148;
	public static int SHIP_UPGRADE_10_JOKE =  			149;
	
	// FACTORY
	public static int FACTORY_NAME = 					150;
	public static int FACTORY_DESCRIPTION = 			151;
	public static int FACTORY_UPGRADE_1 = 				152;
	public static int FACTORY_UPGRADE_1_JOKE =  		153;
	public static int FACTORY_UPGRADE_2 = 				154;
	public static int FACTORY_UPGRADE_2_JOKE =  		155;
	public static int FACTORY_UPGRADE_3 = 				156;
	public static int FACTORY_UPGRADE_3_JOKE =  		157;
	public static int FACTORY_UPGRADE_4 = 				158;
	public static int FACTORY_UPGRADE_4_JOKE =  		159;
	public static int FACTORY_UPGRADE_5 = 				160;
	public static int FACTORY_UPGRADE_5_JOKE =  		161;
	public static int FACTORY_UPGRADE_6 = 				162;
	public static int FACTORY_UPGRADE_6_JOKE =  		163;
	public static int FACTORY_UPGRADE_7 = 				164;
	public static int FACTORY_UPGRADE_7_JOKE =  		165;
	public static int FACTORY_UPGRADE_8 = 				166;
	public static int FACTORY_UPGRADE_8_JOKE =  		167;
	public static int FACTORY_UPGRADE_9 = 				168;
	public static int FACTORY_UPGRADE_9_JOKE = 			169;
	public static int FACTORY_UPGRADE_10 = 				170;
	public static int FACTORY_UPGRADE_10_JOKE =  		171;
	
	// LABORATORY
	public static int LABORATORY_NAME = 				172;
	public static int LABORATORY_DESCRIPTION = 			173;
	public static int LABORATORY_UPGRADE_1 = 			174;
	public static int LABORATORY_UPGRADE_1_JOKE =  		175;
	public static int LABORATORY_UPGRADE_2 = 			176;
	public static int LABORATORY_UPGRADE_2_JOKE =  		177;
	public static int LABORATORY_UPGRADE_3 = 			178;
	public static int LABORATORY_UPGRADE_3_JOKE =  		179;
	public static int LABORATORY_UPGRADE_4 = 			180;
	public static int LABORATORY_UPGRADE_4_JOKE =  		181;
	public static int LABORATORY_UPGRADE_5 = 			182;
	public static int LABORATORY_UPGRADE_5_JOKE =  		183;
	public static int LABORATORY_UPGRADE_6 = 			184;
	public static int LABORATORY_UPGRADE_6_JOKE =  		185;
	public static int LABORATORY_UPGRADE_7 = 			186;
	public static int LABORATORY_UPGRADE_7_JOKE =  		187;
	public static int LABORATORY_UPGRADE_8 = 			188;
	public static int LABORATORY_UPGRADE_8_JOKE =  		189;
	public static int LABORATORY_UPGRADE_9 = 			190;
	public static int LABORATORY_UPGRADE_9_JOKE = 		191;
	public static int LABORATORY_UPGRADE_10 = 			192;
	public static int LABORATORY_UPGRADE_10_JOKE =  	193;
	
	// SHOP
	public static int SHOP_NAME = 						194;
	public static int SHOP_DESCRIPTION = 				195;
	public static int SHOP_UPGRADE_1 = 					196;
	public static int SHOP_UPGRADE_1_JOKE =  			197;
	public static int SHOP_UPGRADE_2 = 					198;
	public static int SHOP_UPGRADE_2_JOKE =  			199;
	public static int SHOP_UPGRADE_3 = 					200;
	public static int SHOP_UPGRADE_3_JOKE =  			201;
	public static int SHOP_UPGRADE_4 = 					202;
	public static int SHOP_UPGRADE_4_JOKE =  			203;
	public static int SHOP_UPGRADE_5 = 					204;
	public static int SHOP_UPGRADE_5_JOKE =  			205;
	public static int SHOP_UPGRADE_6 = 					206;
	public static int SHOP_UPGRADE_6_JOKE =  			207;
	public static int SHOP_UPGRADE_7 = 					208;
	public static int SHOP_UPGRADE_7_JOKE =  			209;
	public static int SHOP_UPGRADE_8 = 					210;
	public static int SHOP_UPGRADE_8_JOKE =  			211;
	public static int SHOP_UPGRADE_9 = 					212;
	public static int SHOP_UPGRADE_9_JOKE = 			213;
	public static int SHOP_UPGRADE_10 = 				214;
	public static int SHOP_UPGRADE_10_JOKE =  			215;
	
	// SPACESHIP
	public static int SPACESHIP_NAME = 					216;
	public static int SPACESHIP_DESCRIPTION = 			217;
	public static int SPACESHIP_UPGRADE_1 = 			218;
	public static int SPACESHIP_UPGRADE_1_JOKE =  		219;
	public static int SPACESHIP_UPGRADE_2 = 			220;
	public static int SPACESHIP_UPGRADE_2_JOKE =  		221;
	public static int SPACESHIP_UPGRADE_3 = 			222;
	public static int SPACESHIP_UPGRADE_3_JOKE =  		223;
	public static int SPACESHIP_UPGRADE_4 = 			224;
	public static int SPACESHIP_UPGRADE_4_JOKE =  		225;
	public static int SPACESHIP_UPGRADE_5 = 			226;
	public static int SPACESHIP_UPGRADE_5_JOKE =  		227;
	public static int SPACESHIP_UPGRADE_6 = 			228;
	public static int SPACESHIP_UPGRADE_6_JOKE =  		229;
	public static int SPACESHIP_UPGRADE_7 = 			230;
	public static int SPACESHIP_UPGRADE_7_JOKE =  		231;
	public static int SPACESHIP_UPGRADE_8 = 			232;
	public static int SPACESHIP_UPGRADE_8_JOKE =  		233;
	public static int SPACESHIP_UPGRADE_9 = 			234;
	public static int SPACESHIP_UPGRADE_9_JOKE = 		235;
	public static int SPACESHIP_UPGRADE_10 = 			236;
	public static int SPACESHIP_UPGRADE_10_JOKE =  		237;
	
	// MORE MISCELLANEOUS
	public static int LANGUAGE_WORD =  					238;
	
	
	//private static HashMap<String, Integer> languages = new HashMap<String, Integer>();

	public static void initialize() {
		initialized = true;
		//languages.put("ENGLISH", 0);
		
		LANGUAGES[ENGLISH_VALUE] = ENGLISH_WORDS;
		LANGUAGES[SPANISH_VALUE] = SPANISH_WORDS;
		
		/**ENGLISH**/
		
		// MISCELLANEOUS
		ENGLISH_WORDS[TRANSLATOR_MALE] = "Translator";
		ENGLISH_WORDS[TRANSLATOR_FEMALE] = "Translator";
		ENGLISH_WORDS[TRANSLATORS] = "Translators";
		ENGLISH_WORDS[BUILDING] = "Building";
		ENGLISH_WORDS[BUILDINGS] = "Buildings";
		ENGLISH_WORDS[UPGRADE] = "Upgrade";
		ENGLISH_WORDS[UPGRADES] = "Upgrades";
		ENGLISH_WORDS[ACHIEVEMENT] = "Achievement";
		ENGLISH_WORDS[ACHIEVEMENTS] = "Achievements";
		ENGLISH_WORDS[LOVE_SINCE_BEGINNING_GAME] = "Love since beginning of this game";
		ENGLISH_WORDS[LOVE_SINCE_BEGINNING_TIMES] = "Love since beginning of times";
		ENGLISH_WORDS[PRODUCTION_MULTIPLIER] = "Production multiplier";
		ENGLISH_WORDS[CURRENT_LOVE] = "Current love";
		ENGLISH_WORDS[LOVE_PER_CLICK] = "Love per click";
		ENGLISH_WORDS[CRITICAL_CLICK] = "Critical click";
		ENGLISH_WORDS[CRITICAL_CLICK_CHANCE] = "Critical click chance";
		ENGLISH_WORDS[NUMBER_OF_CLICKS] = "Number of clicks";
		ENGLISH_WORDS[NUMBER_OF_MIRACLES] = "Number of miracles";
		ENGLISH_WORDS[GAIN_BASE_LOVE] = "X gain +Y base love per second";
		ENGLISH_WORDS[PRODUCE_TWICE_LOVE] = "X produce twice the love";
		
		// SERVANT
		ENGLISH_WORDS[SERVANT_NAME] = "Servant";
		ENGLISH_WORDS[SERVANT_DESCRIPTION] = "A loyal servant, it whispers nice things";
		ENGLISH_WORDS[SERVANT_UPGRADE_1] = "You are not alone";
		ENGLISH_WORDS[SERVANT_UPGRADE_1_JOKE] = "I'll take care of you";
		ENGLISH_WORDS[SERVANT_UPGRADE_2] = "Duckface";
		ENGLISH_WORDS[SERVANT_UPGRADE_2_JOKE] = "Adorably unbearable";
		ENGLISH_WORDS[SERVANT_UPGRADE_3] = "Polyglot";
		ENGLISH_WORDS[SERVANT_UPGRADE_3_JOKE] = "Omnia uincit amor, et nos cedamus amori";
		ENGLISH_WORDS[SERVANT_UPGRADE_4] = "Dental plan";
		ENGLISH_WORDS[SERVANT_UPGRADE_4_JOKE] = "Lisa needs braces";
		ENGLISH_WORDS[SERVANT_UPGRADE_5] = "Chronic stuttering";
		ENGLISH_WORDS[SERVANT_UPGRADE_5_JOKE] = "With all that babble I can’t hear me thinking";
		ENGLISH_WORDS[SERVANT_UPGRADE_6] = "Naughty whispers";
		ENGLISH_WORDS[SERVANT_UPGRADE_6_JOKE] = "Talk dirty to me";
		ENGLISH_WORDS[SERVANT_UPGRADE_7] = "Babylon curse";
		ENGLISH_WORDS[SERVANT_UPGRADE_7_JOKE] = "I taught them languages ​​I don't understand so I can ignore them";
		ENGLISH_WORDS[SERVANT_UPGRADE_8] = "Love, God & Rock and roll";
		ENGLISH_WORDS[SERVANT_UPGRADE_8_JOKE] = "The Holy Trinity";
		ENGLISH_WORDS[SERVANT_UPGRADE_9] = "Voices in your head";
		ENGLISH_WORDS[SERVANT_UPGRADE_9_JOKE] = "Are you talking to me?";
		ENGLISH_WORDS[SERVANT_UPGRADE_10] = "Awakening";
		ENGLISH_WORDS[SERVANT_UPGRADE_10_JOKE] = "Wake up, my children";
		
		// HUMAN
		ENGLISH_WORDS[HUMAN_NAME] = "Human";
		ENGLISH_WORDS[HUMAN_DESCRIPTION] = "A human who doesn’t quite understand your wisdom, but prays to you anyway";
		ENGLISH_WORDS[HUMAN_UPGRADE_1] = "Narcissistic";
		ENGLISH_WORDS[HUMAN_UPGRADE_1_JOKE] = "In your own image and likeness";
		ENGLISH_WORDS[HUMAN_UPGRADE_2] = "Rib companion";
		ENGLISH_WORDS[HUMAN_UPGRADE_2_JOKE] = "It’s funnier to play with someone else";
		ENGLISH_WORDS[HUMAN_UPGRADE_3] = "Vegetal lingerie";
		ENGLISH_WORDS[HUMAN_UPGRADE_3_JOKE] = "Sexy and ecological";
		ENGLISH_WORDS[HUMAN_UPGRADE_4] = "Knowledge apple";
		ENGLISH_WORDS[HUMAN_UPGRADE_4_JOKE] = "Now I know your fantasies";
		ENGLISH_WORDS[HUMAN_UPGRADE_5] = "Aphrodisiac plants";
		ENGLISH_WORDS[HUMAN_UPGRADE_5_JOKE] = "Where physique isn’t enough, leave it to the chemistry";
		ENGLISH_WORDS[HUMAN_UPGRADE_6] = "Eternal life tree";
		ENGLISH_WORDS[HUMAN_UPGRADE_6_JOKE] = "Who wants to live forever?";
		ENGLISH_WORDS[HUMAN_UPGRADE_7] = "Pro-life fanatics";
		ENGLISH_WORDS[HUMAN_UPGRADE_7_JOKE] = "Every sperm is sacred";
		ENGLISH_WORDS[HUMAN_UPGRADE_8] = "Storks union";
		ENGLISH_WORDS[HUMAN_UPGRADE_8_JOKE] = "It was necessary at this time";
		ENGLISH_WORDS[HUMAN_UPGRADE_9] = "Arrogant apes";
		ENGLISH_WORDS[HUMAN_UPGRADE_9_JOKE] = "No gods or kings, only man";
		ENGLISH_WORDS[HUMAN_UPGRADE_10] = "Soylent Green";
		ENGLISH_WORDS[HUMAN_UPGRADE_10_JOKE] = "100% recycled";
		
		// SPECIAL HUMANS
		ENGLISH_WORDS[SPECIAL_HUMAN_1] = "Zealot";
		ENGLISH_WORDS[SPECIAL_HUMAN_1_JOKE] = "God exists because that's what the book says, and the book is God’s word";
		ENGLISH_WORDS[SPECIAL_HUMAN_2] = "Crusader";
		ENGLISH_WORDS[SPECIAL_HUMAN_2_JOKE] = "That’s only a scratch, I still have another arm";
		ENGLISH_WORDS[SPECIAL_HUMAN_3] = "Slave driver";
		ENGLISH_WORDS[SPECIAL_HUMAN_3_JOKE] = "We give them permanent jobs and sometimes even food, they can’t complain";
		ENGLISH_WORDS[SPECIAL_HUMAN_4] = "Bourgeois";
		ENGLISH_WORDS[SPECIAL_HUMAN_4_JOKE] = "What's mine is mine and what’s yours will soon be mine";
		ENGLISH_WORDS[SPECIAL_HUMAN_5] = "Mad scientist";
		ENGLISH_WORDS[SPECIAL_HUMAN_5_JOKE] = "I call it the ‘L.A.S.E.R.’ Mwahahaha";
		ENGLISH_WORDS[SPECIAL_HUMAN_6] = "Televangelist";
		ENGLISH_WORDS[SPECIAL_HUMAN_6_JOKE] = "Hallelujah, brother, your bank transfer won’t be in vain";
		ENGLISH_WORDS[SPECIAL_HUMAN_7] = "Cyborg";
		ENGLISH_WORDS[SPECIAL_HUMAN_7_JOKE] = "I have… seen things you people wouldn't believe";
		
		// PROPHET
		ENGLISH_WORDS[PROPHET_NAME] = "Prophet";
		ENGLISH_WORDS[PROPHET_DESCRIPTION] = "A prophet is a human who understands even less, but thinks the exact opposite";
		ENGLISH_WORDS[PROPHET_UPGRADE_1] = "Fake beard";
		ENGLISH_WORDS[PROPHET_UPGRADE_1_JOKE] = "Essential for stoning";
		ENGLISH_WORDS[PROPHET_UPGRADE_2] = "Pessimistic oracle";
		ENGLISH_WORDS[PROPHET_UPGRADE_2_JOKE] = "I guess you’ll last for two weeks";
		ENGLISH_WORDS[PROPHET_UPGRADE_3] = "Apocalyptic prophecy";
		ENGLISH_WORDS[PROPHET_UPGRADE_3_JOKE] = "And when the seventh seal is opened she will say: ...We need to talk";
		ENGLISH_WORDS[PROPHET_UPGRADE_4] = "The Flood";
		ENGLISH_WORDS[PROPHET_UPGRADE_4_JOKE] = "Save two of each kind: two brunettes, two redheads and two blondes";
		ENGLISH_WORDS[PROPHET_UPGRADE_5] = "Shooting star";
		ENGLISH_WORDS[PROPHET_UPGRADE_5_JOKE] = "The moment is coming";
		ENGLISH_WORDS[PROPHET_UPGRADE_6] = "Miraculous duplication";
		ENGLISH_WORDS[PROPHET_UPGRADE_6_JOKE] = "This is against thermodynam-SHUT UP!";
		ENGLISH_WORDS[PROPHET_UPGRADE_7] = "Resurrection";
		ENGLISH_WORDS[PROPHET_UPGRADE_7_JOKE] = "You may take a shower after three days being dead";
		ENGLISH_WORDS[PROPHET_UPGRADE_8] = "Holy book of Love";
		ENGLISH_WORDS[PROPHET_UPGRADE_8_JOKE] = "Wait, what are all those positions for?";
		ENGLISH_WORDS[PROPHET_UPGRADE_9] = "Lovelogy";
		ENGLISH_WORDS[PROPHET_UPGRADE_9_JOKE] = "All you need to know to avoid it";
		ENGLISH_WORDS[PROPHET_UPGRADE_10] = "Unfair competition";
		ENGLISH_WORDS[PROPHET_UPGRADE_10_JOKE] = "If their god were real, wouldn’t he saved them?";
		
		// TEMPLE
		ENGLISH_WORDS[TEMPLE_NAME] = "Temple";
		ENGLISH_WORDS[TEMPLE_DESCRIPTION] = "A temple in the name of love, more or less";
		ENGLISH_WORDS[TEMPLE_UPGRADE_1] = "Love Sanctuary";
		ENGLISH_WORDS[TEMPLE_UPGRADE_1_JOKE] = "A place to give and receive";
		ENGLISH_WORDS[TEMPLE_UPGRADE_2] = "Generous almsgiving";
		ENGLISH_WORDS[TEMPLE_UPGRADE_2_JOKE] = "It never has been easier to earn a living";
		ENGLISH_WORDS[TEMPLE_UPGRADE_3] = "Divine visions";
		ENGLISH_WORDS[TEMPLE_UPGRADE_3_JOKE] = "No more cheap wine";
		ENGLISH_WORDS[TEMPLE_UPGRADE_4] = "Obedient altar boys";
		ENGLISH_WORDS[TEMPLE_UPGRADE_4_JOKE] = "These kids make more bearable the long and hard... masses at the monastery";
		ENGLISH_WORDS[TEMPLE_UPGRADE_5] = "Remorseful sinners";
		ENGLISH_WORDS[TEMPLE_UPGRADE_5_JOKE] = "Get on your knees and earn your absolution";
		ENGLISH_WORDS[TEMPLE_UPGRADE_6] = "Elder in a dress";
		ENGLISH_WORDS[TEMPLE_UPGRADE_6_JOKE] = "I am the voice of God on earth";
		ENGLISH_WORDS[TEMPLE_UPGRADE_7] = "Witch hunt";
		ENGLISH_WORDS[TEMPLE_UPGRADE_7_JOKE] = "These ladies need affection desperately";
		ENGLISH_WORDS[TEMPLE_UPGRADE_8] = "Punish heretics";
		ENGLISH_WORDS[TEMPLE_UPGRADE_8_JOKE] = "You have to spank them gently";
		ENGLISH_WORDS[TEMPLE_UPGRADE_9] = "Repulsive relic";
		ENGLISH_WORDS[TEMPLE_UPGRADE_9_JOKE] = "I hope that's a wrinkled thumb...";
		ENGLISH_WORDS[TEMPLE_UPGRADE_10] = "Violent pilgrimage";
		ENGLISH_WORDS[TEMPLE_UPGRADE_10_JOKE] = "We’re going to the Land of Love and will kill whoever stands in our way";
		
		// SHIP
		ENGLISH_WORDS[SHIP_NAME] = "Ship";
		ENGLISH_WORDS[SHIP_DESCRIPTION] = "A ship to bring love across the seas";
		ENGLISH_WORDS[SHIP_UPGRADE_1] = "Into the unknown";
		ENGLISH_WORDS[SHIP_UPGRADE_1_JOKE] = "Honey, I’m going out for tobacco";
		ENGLISH_WORDS[SHIP_UPGRADE_2] = "Obscene figurehead";
		ENGLISH_WORDS[SHIP_UPGRADE_2_JOKE] = "The crew looks excited";
		ENGLISH_WORDS[SHIP_UPGRADE_3] = "Intercultural exchange";
		ENGLISH_WORDS[SHIP_UPGRADE_3_JOKE] = "Enjoy the Amazons' coconuts";
		ENGLISH_WORDS[SHIP_UPGRADE_4] = "Contagious love flu";
		ENGLISH_WORDS[SHIP_UPGRADE_4_JOKE] = "Love is in the air";
		ENGLISH_WORDS[SHIP_UPGRADE_5] = "The chosen ones";
		ENGLISH_WORDS[SHIP_UPGRADE_5_JOKE] = "One race to rule them all";
		ENGLISH_WORDS[SHIP_UPGRADE_6] = "Convert infidels";
		ENGLISH_WORDS[SHIP_UPGRADE_6_JOKE] = "Teach them how to love properly";
		ENGLISH_WORDS[SHIP_UPGRADE_7] = "Pleasurable whiplashes";
		ENGLISH_WORDS[SHIP_UPGRADE_7_JOKE] = "Now with heart-shaped bruises";
		ENGLISH_WORDS[SHIP_UPGRADE_8] = "Pirates ahoy!";
		ENGLISH_WORDS[SHIP_UPGRADE_8_JOKE] = "Arr! Stealing love is easier than earning it!";
		ENGLISH_WORDS[SHIP_UPGRADE_9] = "Paradise map";
		ENGLISH_WORDS[SHIP_UPGRADE_9_JOKE] = "Ideal to find the G spot,  I mean, to spot the X";
		ENGLISH_WORDS[SHIP_UPGRADE_10] = "Invincible Fleet";
		ENGLISH_WORDS[SHIP_UPGRADE_10_JOKE] = "Definitively invincible";
		
		// FACTORY
		ENGLISH_WORDS[FACTORY_NAME] = "Factory";
		ENGLISH_WORDS[FACTORY_DESCRIPTION] = "A factory to manufacture love";
		ENGLISH_WORDS[FACTORY_UPGRADE_1] = "Teamwork";
		ENGLISH_WORDS[FACTORY_UPGRADE_1_JOKE] = "You sweat and I supervise";
		ENGLISH_WORDS[FACTORY_UPGRADE_2] = "Tiny hands";
		ENGLISH_WORDS[FACTORY_UPGRADE_2_JOKE] = "Tiny workers to manage even the tiniest details";
		ENGLISH_WORDS[FACTORY_UPGRADE_3] = "Lowered standards";
		ENGLISH_WORDS[FACTORY_UPGRADE_3_JOKE] = "We will have to settle for this";
		ENGLISH_WORDS[FACTORY_UPGRADE_4] = "Ignore nonsense";
		ENGLISH_WORDS[FACTORY_UPGRADE_4_JOKE] = "Some workers demand sleep";
		ENGLISH_WORDS[FACTORY_UPGRADE_5] = "Steam engines";
		ENGLISH_WORDS[FACTORY_UPGRADE_5_JOKE] = "Increased production at the expense of a few accidents";
		ENGLISH_WORDS[FACTORY_UPGRADE_6] = "Fair rights";
		ENGLISH_WORDS[FACTORY_UPGRADE_6_JOKE] = "You have the right to shut up";
		ENGLISH_WORDS[FACTORY_UPGRADE_7] = "Oversupply";
		ENGLISH_WORDS[FACTORY_UPGRADE_7_JOKE] = "Don't stop me now";
		ENGLISH_WORDS[FACTORY_UPGRADE_8] = "Toxic gas leaks";
		ENGLISH_WORDS[FACTORY_UPGRADE_8_JOKE] = "Dead employees will be fired";
		ENGLISH_WORDS[FACTORY_UPGRADE_9] = "Scab Monkeys";
		ENGLISH_WORDS[FACTORY_UPGRADE_9_JOKE] = "They demand a lot of bananas, but do not demand any right";
		ENGLISH_WORDS[FACTORY_UPGRADE_10] = "Acid Rivers";
		ENGLISH_WORDS[FACTORY_UPGRADE_10_JOKE] = "Catching fish bare-hands it’s easy when they float face up";
		
		// LABORATORY
		ENGLISH_WORDS[LABORATORY_NAME] = "Laboratory";
		ENGLISH_WORDS[LABORATORY_DESCRIPTION] = "A laboratory to understand the nature of love";
		ENGLISH_WORDS[LABORATORY_UPGRADE_1] = "First patent";
		ENGLISH_WORDS[LABORATORY_UPGRADE_1_JOKE] = "A revolutionary device, but it needs a lot of lube";
		ENGLISH_WORDS[LABORATORY_UPGRADE_2] = "Brilliant minds";
		ENGLISH_WORDS[LABORATORY_UPGRADE_2_JOKE] = "We invented a lot of things, but now we have to figure what are they for";
		ENGLISH_WORDS[LABORATORY_UPGRADE_3] = "Robo-maid";
		ENGLISH_WORDS[LABORATORY_UPGRADE_3_JOKE] = "Scientists are very pleased";
		ENGLISH_WORDS[LABORATORY_UPGRADE_4] = "Cute explosion";
		ENGLISH_WORDS[LABORATORY_UPGRADE_4_JOKE] = "Contains an enriched isotope love";
		ENGLISH_WORDS[LABORATORY_UPGRADE_5] = "General relativity";
		ENGLISH_WORDS[LABORATORY_UPGRADE_5_JOKE] = "Sometimes ‘no’ means ‘yes’";
		ENGLISH_WORDS[LABORATORY_UPGRADE_6] = "Love fundamental particle";
		ENGLISH_WORDS[LABORATORY_UPGRADE_6_JOKE] = "The model is perfect, but reality doesn’t fit well in it";
		ENGLISH_WORDS[LABORATORY_UPGRADE_7] = "Quantum love";
		ENGLISH_WORDS[LABORATORY_UPGRADE_7_JOKE] = "Entangled hearts";
		ENGLISH_WORDS[LABORATORY_UPGRADE_8] = "Violation of physical laws";
		ENGLISH_WORDS[LABORATORY_UPGRADE_8_JOKE] = "Inside this lab nobody will hear you scream";
		ENGLISH_WORDS[LABORATORY_UPGRADE_9] = "Broken spatiotemporal fabric";
		ENGLISH_WORDS[LABORATORY_UPGRADE_9_JOKE] = "We are developing a spatiotemporal needle to patch it";
		ENGLISH_WORDS[LABORATORY_UPGRADE_10] = "LoveOS";
		ENGLISH_WORDS[LABORATORY_UPGRADE_10_JOKE] = "The answer to your question is 69";
		
		// SHOP
		ENGLISH_WORDS[SHOP_NAME] = "Shop";
		ENGLISH_WORDS[SHOP_DESCRIPTION] = "A shop where you can buy love at a reasonable price";
		ENGLISH_WORDS[SHOP_UPGRADE_1] = "Selling affection";
		ENGLISH_WORDS[SHOP_UPGRADE_1_JOKE] = "Now you can buy your happiness without commitments";
		ENGLISH_WORDS[SHOP_UPGRADE_2] = "Crazy sales";
		ENGLISH_WORDS[SHOP_UPGRADE_2_JOKE] = "For that price… gimme seven!";
		ENGLISH_WORDS[SHOP_UPGRADE_3] = "Planned obsolescence";
		ENGLISH_WORDS[SHOP_UPGRADE_3_JOKE] = "Our relationship has no future";
		ENGLISH_WORDS[SHOP_UPGRADE_4] = "Disposable love";
		ENGLISH_WORDS[SHOP_UPGRADE_4_JOKE] = "Piles of rubbish as far as the eye can see";
		ENGLISH_WORDS[SHOP_UPGRADE_5] = "Product design";
		ENGLISH_WORDS[SHOP_UPGRADE_5_JOKE] = "Awesome, now with 87% more packing!";
		ENGLISH_WORDS[SHOP_UPGRADE_6] = "Invasive product placement";
		ENGLISH_WORDS[SHOP_UPGRADE_6_JOKE] = "Enjoy incredible ads while you’re dreaming";
		ENGLISH_WORDS[SHOP_UPGRADE_7] = "Imported love";
		ENGLISH_WORDS[SHOP_UPGRADE_7_JOKE] = "Developed by the third world for our joy";
		ENGLISH_WORDS[SHOP_UPGRADE_8] = "Make up new festivity";
		ENGLISH_WORDS[SHOP_UPGRADE_8_JOKE] = "Consume more, you bastards";
		ENGLISH_WORDS[SHOP_UPGRADE_9] = "Loveh*";
		ENGLISH_WORDS[SHOP_UPGRADE_9_JOKE] = "Almost* like the original";
		ENGLISH_WORDS[SHOP_UPGRADE_10] = "LoveCard®";
		ENGLISH_WORDS[SHOP_UPGRADE_10_JOKE] = "There are things that love can’t buy, for everything else: LoveCard®";
		
		// SPACESHIP
		ENGLISH_WORDS[SPACESHIP_NAME] = "Spaceship";
		ENGLISH_WORDS[SPACESHIP_DESCRIPTION] = "A spaceship to spread love to other galaxies";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_1] = "Astronaut dog";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_1_JOKE] = "Ouch, we forgot to give him his space food";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_2] = "Fake moon landing";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_2_JOKE] = "Raising the audience is also a giant leap";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_3] = "Cosmic jet";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_3_JOKE] = "Shake before use";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_4] = "Space junk";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_4_JOKE] = "Although you can throw it far away it’s not gonna disappear";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_5] = "International Space Station";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_5_JOKE] = "Zero gravity opens up new possibilities, we must update the Holy Book of Love";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_6] = "Pacifist colonies";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_6_JOKE] = "Full of leftover hippies";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_7] = "Open up pink hole";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_7_JOKE] = "Crossing it can cause a tear in the space-time";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_8] = "Close Encounters of the Third Kind";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_8_JOKE] = "They are a bit stupid, but we must learn to love them - Signed: The Aliens";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_9] = "Faster than light";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_9_JOKE] = "Hyperspatial jumping is awesome until the day you crash into a star";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_10] = "Galactic Empire";
		ENGLISH_WORDS[SPACESHIP_UPGRADE_10_JOKE] = "May the love be with you";
		
		// MORE MISCELLANEOUS
		ENGLISH_WORDS[LANGUAGE_WORD] = "Language";
		
		
		/** SPANISH **/
		
		// MISCELLANEOUS
		SPANISH_WORDS[TRANSLATOR_MALE] = "Traductor";
		SPANISH_WORDS[TRANSLATOR_FEMALE] = "Traductora";
		SPANISH_WORDS[TRANSLATORS] = "Traductores";
		SPANISH_WORDS[BUILDING] = "Edificio";
		SPANISH_WORDS[BUILDINGS] = "Edificios";
		SPANISH_WORDS[UPGRADE] = "Mejora";
		SPANISH_WORDS[UPGRADES] = "Mejoras";
		SPANISH_WORDS[ACHIEVEMENT] = "Logro";
		SPANISH_WORDS[ACHIEVEMENTS] = "Logros";
		SPANISH_WORDS[LOVE_SINCE_BEGINNING_GAME] = "Amor desde que comenzó esta partida";
		SPANISH_WORDS[LOVE_SINCE_BEGINNING_TIMES] = "Amor desde el comienzo de los tiempos";
		SPANISH_WORDS[PRODUCTION_MULTIPLIER] = "Multiplicador de producción";
		SPANISH_WORDS[CURRENT_LOVE] = "Amor actual";
		SPANISH_WORDS[LOVE_PER_CLICK] = "Amor por click";
		SPANISH_WORDS[CRITICAL_CLICK] = "Click crítico";
		SPANISH_WORDS[CRITICAL_CLICK_CHANCE] = "Probabilidad de click crítico";
		SPANISH_WORDS[NUMBER_OF_CLICKS] = "Número de clicks";
		SPANISH_WORDS[NUMBER_OF_MIRACLES] = "Número de milagros";
		SPANISH_WORDS[GAIN_BASE_LOVE] = "X gana +Y de amor base por segundo";
		SPANISH_WORDS[PRODUCE_TWICE_LOVE] = "X produce el doble de amor";
		
		// SERVANT
		SPANISH_WORDS[SERVANT_NAME] = "Sirviente";
		SPANISH_WORDS[SERVANT_DESCRIPTION] = "Un leal sirviente, te susurra cosas bonitas";
		SPANISH_WORDS[SERVANT_UPGRADE_1] = "No estás solo";
		SPANISH_WORDS[SERVANT_UPGRADE_1_JOKE] = "Yo cuidaré de ti";
		SPANISH_WORDS[SERVANT_UPGRADE_2] = "Poner morritos";
		SPANISH_WORDS[SERVANT_UPGRADE_2_JOKE] = "Adorablemente insoportable";
		SPANISH_WORDS[SERVANT_UPGRADE_3] = "Políglota";
		SPANISH_WORDS[SERVANT_UPGRADE_3_JOKE] = "Omnia uincit amor, et nos cedamus amori";
		SPANISH_WORDS[SERVANT_UPGRADE_4] = "Seguro dental";
		SPANISH_WORDS[SERVANT_UPGRADE_4_JOKE] = "Lisa necesita un aparato";
		SPANISH_WORDS[SERVANT_UPGRADE_5] = "Tartamudez crónica";
		SPANISH_WORDS[SERVANT_UPGRADE_5_JOKE] = "Con tanto balbuceo no me oigo pensar";
		SPANISH_WORDS[SERVANT_UPGRADE_6] = "Susurros traviesos";
		SPANISH_WORDS[SERVANT_UPGRADE_6_JOKE] = "Dime cochinadas";
		SPANISH_WORDS[SERVANT_UPGRADE_7] = "Maldición babilónica";
		SPANISH_WORDS[SERVANT_UPGRADE_7_JOKE] = "Les enseñé idiomas que no entiendo para poder ignorarlos";
		SPANISH_WORDS[SERVANT_UPGRADE_8] = "Amor, Dios y rock’n’roll";
		SPANISH_WORDS[SERVANT_UPGRADE_8_JOKE] = "La Santísima Trinidad";
		SPANISH_WORDS[SERVANT_UPGRADE_9] = "Voces en la cabeza";
		SPANISH_WORDS[SERVANT_UPGRADE_9_JOKE] = "¿Me estás hablando a mi?";
		SPANISH_WORDS[SERVANT_UPGRADE_10] = "Despertar";
		SPANISH_WORDS[SERVANT_UPGRADE_10_JOKE] = "Despertad, hijos míos";
		
		// HUMAN
		SPANISH_WORDS[HUMAN_NAME] = "Humano";
		SPANISH_WORDS[HUMAN_DESCRIPTION] = "Un humano que no entiende muy bien tu sabiduría, pero te reza de todas formas";
		SPANISH_WORDS[HUMAN_UPGRADE_1] = "Narcisista";
		SPANISH_WORDS[HUMAN_UPGRADE_1_JOKE] = "A tu imagen y semejanza";
		SPANISH_WORDS[HUMAN_UPGRADE_2] = "Compañero de costilla";
		SPANISH_WORDS[HUMAN_UPGRADE_2_JOKE] = "Es más divertido jugar en compañía";
		SPANISH_WORDS[HUMAN_UPGRADE_3] = "Lencería vegetal";
		SPANISH_WORDS[HUMAN_UPGRADE_3_JOKE] = "Sexy y ecológica";
		SPANISH_WORDS[HUMAN_UPGRADE_4] = "Manzana del conocimiento";
		SPANISH_WORDS[HUMAN_UPGRADE_4_JOKE] = "Ahora conozco tus fantasías";
		SPANISH_WORDS[HUMAN_UPGRADE_5] = "Plantas afrodisíacas";
		SPANISH_WORDS[HUMAN_UPGRADE_5_JOKE] = "Donde el físico no es suficiente, déjaselo a la química";
		SPANISH_WORDS[HUMAN_UPGRADE_6] = "Árbol de la vida eterna";
		SPANISH_WORDS[HUMAN_UPGRADE_6_JOKE] = "¿Quién quiere vivir para siempre?";
		SPANISH_WORDS[HUMAN_UPGRADE_7] = "Fanáticos pro-vida";
		SPANISH_WORDS[HUMAN_UPGRADE_7_JOKE] = "Todo el esperma es sagrado";
		SPANISH_WORDS[HUMAN_UPGRADE_8] = "Sindicato de cigüeñas";
		SPANISH_WORDS[HUMAN_UPGRADE_8_JOKE] = "Era necesario a estas alturas";
		SPANISH_WORDS[HUMAN_UPGRADE_9] = "Simios arrogantes";
		SPANISH_WORDS[HUMAN_UPGRADE_9_JOKE] = "Ni dioses ni reyes, solo el hombre";
		SPANISH_WORDS[HUMAN_UPGRADE_10] = "Soylent Green";
		SPANISH_WORDS[HUMAN_UPGRADE_10_JOKE] = "100% reciclado";
		
		// SPECIAL HUMANS
		SPANISH_WORDS[SPECIAL_HUMAN_1] = "Fanático";
		SPANISH_WORDS[SPECIAL_HUMAN_1_JOKE] = "Dios existe porque lo pone en el libro, y el libro es la palabra de Dios";
		SPANISH_WORDS[SPECIAL_HUMAN_2] = "Cruzado";
		SPANISH_WORDS[SPECIAL_HUMAN_2_JOKE] = "Es sólo un rasguño, aún tengo otro brazo";
		SPANISH_WORDS[SPECIAL_HUMAN_3] = "Esclavista";
		SPANISH_WORDS[SPECIAL_HUMAN_3_JOKE] = "Les damos empleo fijo y a veces hasta comida, no se pueden quejar";
		SPANISH_WORDS[SPECIAL_HUMAN_4] = "Burgués";
		SPANISH_WORDS[SPECIAL_HUMAN_4_JOKE] = "Lo mío es mío y lo tuyo pronto será mío";
		SPANISH_WORDS[SPECIAL_HUMAN_5] = "Científico loco";
		SPANISH_WORDS[SPECIAL_HUMAN_5_JOKE] = "Yo lo llamo el ‘L.A.S.E.R.’, Muajajajá";
		SPANISH_WORDS[SPECIAL_HUMAN_6] = "Telepredicador";
		SPANISH_WORDS[SPECIAL_HUMAN_6_JOKE] = "Aleluya, hermano, tu transferencia bancaria no será en vano";
		SPANISH_WORDS[SPECIAL_HUMAN_7] = "Cyborg";
		SPANISH_WORDS[SPECIAL_HUMAN_7_JOKE] = "Yo... he visto cosas que vosotros no creeríais";
		
		// PROPHET
		SPANISH_WORDS[PROPHET_NAME] = "Profeta";
		SPANISH_WORDS[PROPHET_DESCRIPTION] = "Un profeta es un humano que entiende aún menos, pero que piensa exactamente lo contrario";
		SPANISH_WORDS[PROPHET_UPGRADE_1] = "Barba postiza";
		SPANISH_WORDS[PROPHET_UPGRADE_1_JOKE] = "Imprescindible para las lapidaciones";
		SPANISH_WORDS[PROPHET_UPGRADE_2] = "Oráculo pesimista";
		SPANISH_WORDS[PROPHET_UPGRADE_2_JOKE] = "Os echo dos semanas";
		SPANISH_WORDS[PROPHET_UPGRADE_3] = "Profecía apocalíptica";
		SPANISH_WORDS[PROPHET_UPGRADE_3_JOKE] = "Y cuando se abra el séptimo sello ella dirá : ...Tenemos que hablar";
		SPANISH_WORDS[PROPHET_UPGRADE_4] = "Diluvio universal";
		SPANISH_WORDS[PROPHET_UPGRADE_4_JOKE] = "Salva dos de cada: dos morenas, dos pelirrojas y dos rubias";
		SPANISH_WORDS[PROPHET_UPGRADE_5] = "Estrella fugaz";
		SPANISH_WORDS[PROPHET_UPGRADE_5_JOKE] = "El momento se acerca";
		SPANISH_WORDS[PROPHET_UPGRADE_6] = "Duplicación milagrosa";
		SPANISH_WORDS[PROPHET_UPGRADE_6_JOKE] = "Eso va en contra de las leyes de la termodin-¡A CALLAR!";
		SPANISH_WORDS[PROPHET_UPGRADE_7] = "Resurrección";
		SPANISH_WORDS[PROPHET_UPGRADE_7_JOKE] = "Deberías ducharte después de pasar tres días muerto";
		SPANISH_WORDS[PROPHET_UPGRADE_8] = "Libro sagrado del Amor";
		SPANISH_WORDS[PROPHET_UPGRADE_8_JOKE] = "Espera, ¿para qué son todas esas posturas?";
		SPANISH_WORDS[PROPHET_UPGRADE_9] = "Amorología";
		SPANISH_WORDS[PROPHET_UPGRADE_9_JOKE] = "Todo lo que necesitas saber para evitarlo";
		SPANISH_WORDS[PROPHET_UPGRADE_10] = "Competencia desleal";
		SPANISH_WORDS[PROPHET_UPGRADE_10_JOKE] = "Si su Dios fuera real, ¿no los habría salvado?";
		
		// TEMPLE
		SPANISH_WORDS[TEMPLE_NAME] = "Templo";
		SPANISH_WORDS[TEMPLE_DESCRIPTION] = "Un templo en nombre del amor, más o menos";
		SPANISH_WORDS[TEMPLE_UPGRADE_1] = "Santuario del Amor";
		SPANISH_WORDS[TEMPLE_UPGRADE_1_JOKE] = "Un lugar en el que dar y recibir";
		SPANISH_WORDS[TEMPLE_UPGRADE_2] = "Ofrendas generosas";
		SPANISH_WORDS[TEMPLE_UPGRADE_2_JOKE] = "Nunca fue tan fácil ganarse la vida";
		SPANISH_WORDS[TEMPLE_UPGRADE_3] = "Visiones divinas";
		SPANISH_WORDS[TEMPLE_UPGRADE_3_JOKE] = "No más vino de garrafón";
		SPANISH_WORDS[TEMPLE_UPGRADE_4] = "Monaguillos obedientes";
		SPANISH_WORDS[TEMPLE_UPGRADE_4_JOKE] = "Estos chicos hacen más llevaderas las largas y duras misas en el monasterio";
		SPANISH_WORDS[TEMPLE_UPGRADE_5] = "Pecadores arrepentidos";
		SPANISH_WORDS[TEMPLE_UPGRADE_5_JOKE] = "Arrodíllate y gánate el perdón";
		SPANISH_WORDS[TEMPLE_UPGRADE_6] = "Anciano con vestido";
		SPANISH_WORDS[TEMPLE_UPGRADE_6_JOKE] = "Soy la voz de Dios en la Tierra";
		SPANISH_WORDS[TEMPLE_UPGRADE_7] = "Caza de brujas";
		SPANISH_WORDS[TEMPLE_UPGRADE_7_JOKE] = "Estas damas necesitan cariño desesperadamente";
		SPANISH_WORDS[TEMPLE_UPGRADE_8] = "Castigar herejes";
		SPANISH_WORDS[TEMPLE_UPGRADE_8_JOKE] = "Tienes que azotarles con dulzura";
		SPANISH_WORDS[TEMPLE_UPGRADE_9] = "Reliquia repulsiva";
		SPANISH_WORDS[TEMPLE_UPGRADE_9_JOKE] = "Espero que eso sea un dedo gordo arrugado…";
		SPANISH_WORDS[TEMPLE_UPGRADE_10] = "Peregrinación violenta";
		SPANISH_WORDS[TEMPLE_UPGRADE_10_JOKE] = "Vamos hacia la Tierra del Amor y mataremos a quien se interponga en nuestro camino";
		
		// SHIP
		SPANISH_WORDS[SHIP_NAME] = "Barco";
		SPANISH_WORDS[SHIP_DESCRIPTION] = "Un barco para llevar el amor por todos los mares";
		SPANISH_WORDS[SHIP_UPGRADE_1] = "Hacia lo desconocido";
		SPANISH_WORDS[SHIP_UPGRADE_1_JOKE] = "Cariño, me voy a por tabaco";
		SPANISH_WORDS[SHIP_UPGRADE_2] = "Mascarón obsceno";
		SPANISH_WORDS[SHIP_UPGRADE_2_JOKE] = "La tripulación parece animada";
		SPANISH_WORDS[SHIP_UPGRADE_3] = "Intercambio intercultural";
		SPANISH_WORDS[SHIP_UPGRADE_3_JOKE] = "Disfruta de los cocos de las Amazonas";
		SPANISH_WORDS[SHIP_UPGRADE_4] = "Gripe del amor contagioso";
		SPANISH_WORDS[SHIP_UPGRADE_4_JOKE] = "El amor está en el aire";
		SPANISH_WORDS[SHIP_UPGRADE_5] = "Los elegidos";
		SPANISH_WORDS[SHIP_UPGRADE_5_JOKE] = "Una raza para dominarlas a todas";
		SPANISH_WORDS[SHIP_UPGRADE_6] = "Convertir infieles";
		SPANISH_WORDS[SHIP_UPGRADE_6_JOKE] = "Enséñales a amar como es debido";
		SPANISH_WORDS[SHIP_UPGRADE_7] = "Latigazos placenteros";
		SPANISH_WORDS[SHIP_UPGRADE_7_JOKE] = "Ahora con moratones en forma de corazón";
		SPANISH_WORDS[SHIP_UPGRADE_8] = "¡Piratas a la vista!";
		SPANISH_WORDS[SHIP_UPGRADE_8_JOKE] = "¡Arr! ¡Robar amor es más fácil que ganárselo!";
		SPANISH_WORDS[SHIP_UPGRADE_9] = "Mapa del paraíso";
		SPANISH_WORDS[SHIP_UPGRADE_9_JOKE] = "Ideal para encontrar el punto G… digoo la X del tesoro";
		SPANISH_WORDS[SHIP_UPGRADE_10] = "Armada Invencible";
		SPANISH_WORDS[SHIP_UPGRADE_10_JOKE] = "Absolutamente invencible";
		
		// FACTORY
		SPANISH_WORDS[FACTORY_NAME] = "Fábrica";
		SPANISH_WORDS[FACTORY_DESCRIPTION] = "Una fábrica para producir amor";
		SPANISH_WORDS[FACTORY_UPGRADE_1] = "Trabajo en equipo";
		SPANISH_WORDS[FACTORY_UPGRADE_1_JOKE] = "Vosotros trabajáis y yo superviso";
		SPANISH_WORDS[FACTORY_UPGRADE_2] = "Manos pequeñas";
		SPANISH_WORDS[FACTORY_UPGRADE_2_JOKE] = "Pequeños trabajadores para prestar atención a los más pequeños detalles";
		SPANISH_WORDS[FACTORY_UPGRADE_3] = "Estándares reducidos";
		SPANISH_WORDS[FACTORY_UPGRADE_3_JOKE] = "Habrá que conformarse";
		SPANISH_WORDS[FACTORY_UPGRADE_4] = "Ignorar disparates";
		SPANISH_WORDS[FACTORY_UPGRADE_4_JOKE] = "Algunos obreros reclaman poder dormir";
		SPANISH_WORDS[FACTORY_UPGRADE_5] = "Máquinas a vapor";
		SPANISH_WORDS[FACTORY_UPGRADE_5_JOKE] = "Aumentan la producción a costa de unos pocos accidentes";
		SPANISH_WORDS[FACTORY_UPGRADE_6] = "Derechos justos";
		SPANISH_WORDS[FACTORY_UPGRADE_6_JOKE] = "Tienes derecho a callarte la boca";
		SPANISH_WORDS[FACTORY_UPGRADE_7] = "Exceso de oferta";
		SPANISH_WORDS[FACTORY_UPGRADE_7_JOKE] = "No me pares ahora";
		SPANISH_WORDS[FACTORY_UPGRADE_8] = "Fugas de gas tóxico";
		SPANISH_WORDS[FACTORY_UPGRADE_8_JOKE] = "Los empleados fallecidos serán despedidos";
		SPANISH_WORDS[FACTORY_UPGRADE_9] = "Monos esquiroles";
		SPANISH_WORDS[FACTORY_UPGRADE_9_JOKE] = "Consumen mucho plátano, pero no reclaman ningún derecho";
		SPANISH_WORDS[FACTORY_UPGRADE_10] = "Ríos ácidos";
		SPANISH_WORDS[FACTORY_UPGRADE_10_JOKE] = "Cazar peces con las manos es fácil cuando flotan boca arriba";
		
		// LABORATORY
		SPANISH_WORDS[LABORATORY_NAME] = "Laboratorio";
		SPANISH_WORDS[LABORATORY_DESCRIPTION] = "Un laboratorio para comprender la naturaleza del amor";
		SPANISH_WORDS[LABORATORY_UPGRADE_1] = "Primera patente";
		SPANISH_WORDS[LABORATORY_UPGRADE_1_JOKE] = "Un aparato revolucionario, pero necesita mucho lubricante";
		SPANISH_WORDS[LABORATORY_UPGRADE_2] = "Mentes brillantes";
		SPANISH_WORDS[LABORATORY_UPGRADE_2_JOKE] = "Hemos inventado un montón de cosas, ahora tenemos que averiguar para qué sirven";
		SPANISH_WORDS[LABORATORY_UPGRADE_3] = "Robo-sirvienta";
		SPANISH_WORDS[LABORATORY_UPGRADE_3_JOKE] = "Los científicos están encantados";
		SPANISH_WORDS[LABORATORY_UPGRADE_4] = "Explosión mona";
		SPANISH_WORDS[LABORATORY_UPGRADE_4_JOKE] = "Contiene un isótopo enriquecido con amor";
		SPANISH_WORDS[LABORATORY_UPGRADE_5] = "Relatividad general";
		SPANISH_WORDS[LABORATORY_UPGRADE_5_JOKE] = "A veces ‘no’ significa ‘sí’";
		SPANISH_WORDS[LABORATORY_UPGRADE_6] = "Partícula fundamental del amor";
		SPANISH_WORDS[LABORATORY_UPGRADE_6_JOKE] = "El modelo es perfecto, pero la realidad no se ajusta bien a él";
		SPANISH_WORDS[LABORATORY_UPGRADE_7] = "Amor cuántico";
		SPANISH_WORDS[LABORATORY_UPGRADE_7_JOKE] = "Corazones entrelezados";
		SPANISH_WORDS[LABORATORY_UPGRADE_8] = "Violación de leyes físicas";
		SPANISH_WORDS[LABORATORY_UPGRADE_8_JOKE] = "Dentro de este laboratorio nadie te oirá gritar";
		SPANISH_WORDS[LABORATORY_UPGRADE_9] = "Tejido espacio-temporal roto";
		SPANISH_WORDS[LABORATORY_UPGRADE_9_JOKE] = "Estamos desarrollando una aguja espacio-temporal para remendarlo";
		SPANISH_WORDS[LABORATORY_UPGRADE_10] = "LoveOS";
		SPANISH_WORDS[LABORATORY_UPGRADE_10_JOKE] = "La respuesta a tu pregunta es 69";
		
		// SHOP
		SPANISH_WORDS[SHOP_NAME] = "Tienda";
		SPANISH_WORDS[SHOP_DESCRIPTION] = "Una tienda donde puedes comprar amor a un precio razonable";
		SPANISH_WORDS[SHOP_UPGRADE_1] = "Vendiendo cariño";
		SPANISH_WORDS[SHOP_UPGRADE_1_JOKE] = "Ahora puedes comprar tu felicidad sin compromisos";
		SPANISH_WORDS[SHOP_UPGRADE_2] = "Rebajas alocadas";
		SPANISH_WORDS[SHOP_UPGRADE_2_JOKE] = "Por ese precio… póngame siete";
		SPANISH_WORDS[SHOP_UPGRADE_3] = "Obsolescencia programada";
		SPANISH_WORDS[SHOP_UPGRADE_3_JOKE] = "Lo nuestro no tiene futuro";
		SPANISH_WORDS[SHOP_UPGRADE_4] = "Amor de usar y tirar";
		SPANISH_WORDS[SHOP_UPGRADE_4_JOKE] = "Montañas de basura hasta donde alcanza la vista";
		SPANISH_WORDS[SHOP_UPGRADE_5] = "Diseño de producto";
		SPANISH_WORDS[SHOP_UPGRADE_5_JOKE] = "¡Increíble, ahora con un 87% más de envase!";
		SPANISH_WORDS[SHOP_UPGRADE_6] = "Anuncios invasivos";
		SPANISH_WORDS[SHOP_UPGRADE_6_JOKE] = "Disfruta de increíbles anuncios mientras sueñas";
		SPANISH_WORDS[SHOP_UPGRADE_7] = "Amor de importación";
		SPANISH_WORDS[SHOP_UPGRADE_7_JOKE] = "Fabricado en el tercer mundo, para nuestro disfrute";
		SPANISH_WORDS[SHOP_UPGRADE_8] = "Inventar nueva festividad";
		SPANISH_WORDS[SHOP_UPGRADE_8_JOKE] = "Consumid más, malditos";
		SPANISH_WORDS[SHOP_UPGRADE_9] = "Hamor*";
		SPANISH_WORDS[SHOP_UPGRADE_9_JOKE] = "Casi* como el original";
		SPANISH_WORDS[SHOP_UPGRADE_10] = "LoveCard®";
		SPANISH_WORDS[SHOP_UPGRADE_10_JOKE] = "Hay cosas que el amor no puede comprar, para todo lo demás: LoveCard®";
		
		// SPACESHIP
		SPANISH_WORDS[SPACESHIP_NAME] = "Nave espacial";
		SPANISH_WORDS[SPACESHIP_DESCRIPTION] = "Una nave espacial para expandir el amor a otras galaxias";
		SPANISH_WORDS[SPACESHIP_UPGRADE_1] = "Perro astronauta";
		SPANISH_WORDS[SPACESHIP_UPGRADE_1_JOKE] = "Vaya, se nos olvidó mandarle la comida espacial";
		SPANISH_WORDS[SPACESHIP_UPGRADE_2] = "Falso alunizaje";
		SPANISH_WORDS[SPACESHIP_UPGRADE_2_JOKE] = "Elevar la audiencia también puede ser un gran paso";
		SPANISH_WORDS[SPACESHIP_UPGRADE_3] = "Chorro cósmico";
		SPANISH_WORDS[SPACESHIP_UPGRADE_3_JOKE] = "Agitar antes de usar";
		SPANISH_WORDS[SPACESHIP_UPGRADE_4] = "Basura espacial";
		SPANISH_WORDS[SPACESHIP_UPGRADE_4_JOKE] = "Por muy alto que la tires no va a desaparecer";
		SPANISH_WORDS[SPACESHIP_UPGRADE_5] = "Estación Espacial Internacional";
		SPANISH_WORDS[SPACESHIP_UPGRADE_5_JOKE] = "La gravedad cero abre nuevas posibilidades, hay que actualizar el Libro Sagrado del Amor";
		SPANISH_WORDS[SPACESHIP_UPGRADE_6] = "Colonias pacifistas";
		SPANISH_WORDS[SPACESHIP_UPGRADE_6_JOKE] = "“Llenas de hippies que sobran";
		SPANISH_WORDS[SPACESHIP_UPGRADE_7] = "Abrir agujero rosa";
		SPANISH_WORDS[SPACESHIP_UPGRADE_7_JOKE] = "Atravesarlo puede producir un desgarro en el espacio-tiempo";
		SPANISH_WORDS[SPACESHIP_UPGRADE_8] = "Encuentros en la Tercera Fase";
		SPANISH_WORDS[SPACESHIP_UPGRADE_8_JOKE] = "Son un poco idiotas, pero tendremos que aprender a quererlos - Firmado : Los aliens";
		SPANISH_WORDS[SPACESHIP_UPGRADE_9] = "Más veloz que la luz";
		SPANISH_WORDS[SPACESHIP_UPGRADE_9_JOKE] = "El salto hiperespacial es genial hasta que un día te empotras contra una estrella";
		SPANISH_WORDS[SPACESHIP_UPGRADE_10] = "Imperio Galáctico";
		SPANISH_WORDS[SPACESHIP_UPGRADE_10_JOKE] = "Que el amor te acompañe";
		
		// MORE MISCELLANEOUS
		SPANISH_WORDS[LANGUAGE_WORD] = "Idioma";
		
		
		//END
		System.out.println("Languages initialized");
	}
	
	public static void setLanguage(int i) {
		CURRENT_VALUE = i;
	}
	
	public static int getLanguage() {
		return CURRENT_VALUE;
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
