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
		ENGLISH_WORDS[LABORATORY_UPGRADE_5_JOKE] = "Sometimes ‘no’ means ‘yes";
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
		
		// TRANSLATION CHECKPOINT
		
		// HUMAN
		SPANISH_WORDS[HUMAN_NAME] = "Humano";
		SPANISH_WORDS[HUMAN_DESCRIPTION] = "A human who doesn’t quite understand your wisdom, but prays to you anyway";
		SPANISH_WORDS[HUMAN_UPGRADE_1] = "Narcissistic";
		SPANISH_WORDS[HUMAN_UPGRADE_1_JOKE] = "In your own image and likeness";
		SPANISH_WORDS[HUMAN_UPGRADE_2] = "Rib companion";
		SPANISH_WORDS[HUMAN_UPGRADE_2_JOKE] = "It’s funnier to play with someone else";
		SPANISH_WORDS[HUMAN_UPGRADE_3] = "Vegetal lingerie";
		SPANISH_WORDS[HUMAN_UPGRADE_3_JOKE] = "Sexy and ecological";
		SPANISH_WORDS[HUMAN_UPGRADE_4] = "Knowledge apple";
		SPANISH_WORDS[HUMAN_UPGRADE_4_JOKE] = "Now I know your fantasies";
		SPANISH_WORDS[HUMAN_UPGRADE_5] = "Aphrodisiac plants";
		SPANISH_WORDS[HUMAN_UPGRADE_5_JOKE] = "Where physique isn’t enough, leave it to the chemistry";
		SPANISH_WORDS[HUMAN_UPGRADE_6] = "Eternal life tree";
		SPANISH_WORDS[HUMAN_UPGRADE_6_JOKE] = "Who wants to live forever?";
		SPANISH_WORDS[HUMAN_UPGRADE_7] = "Pro-life fanatics";
		SPANISH_WORDS[HUMAN_UPGRADE_7_JOKE] = "Every sperm is sacred";
		SPANISH_WORDS[HUMAN_UPGRADE_8] = "Storks union";
		SPANISH_WORDS[HUMAN_UPGRADE_8_JOKE] = "It was necessary at this time";
		SPANISH_WORDS[HUMAN_UPGRADE_9] = "Arrogant apes";
		SPANISH_WORDS[HUMAN_UPGRADE_9_JOKE] = "No gods or kings, only man";
		SPANISH_WORDS[HUMAN_UPGRADE_10] = "Soylent Green";
		SPANISH_WORDS[HUMAN_UPGRADE_10_JOKE] = "100% recycled";
		
		// SPECIAL HUMANS
		SPANISH_WORDS[SPECIAL_HUMAN_1] = "Zealot";
		SPANISH_WORDS[SPECIAL_HUMAN_1_JOKE] = "God exists because that's what the book says, and the book is God’s word";
		SPANISH_WORDS[SPECIAL_HUMAN_2] = "Crusader";
		SPANISH_WORDS[SPECIAL_HUMAN_2_JOKE] = "That’s only a scratch, I still have another arm";
		SPANISH_WORDS[SPECIAL_HUMAN_3] = "Slave driver";
		SPANISH_WORDS[SPECIAL_HUMAN_3_JOKE] = "We give them permanent jobs and sometimes even food, they can’t complain";
		SPANISH_WORDS[SPECIAL_HUMAN_4] = "Bourgeois";
		SPANISH_WORDS[SPECIAL_HUMAN_4_JOKE] = "What's mine is mine and what’s yours will soon be mine";
		SPANISH_WORDS[SPECIAL_HUMAN_5] = "Mad scientist";
		SPANISH_WORDS[SPECIAL_HUMAN_5_JOKE] = "I call it the ‘L.A.S.E.R.’ Mwahahaha";
		SPANISH_WORDS[SPECIAL_HUMAN_6] = "Televangelist";
		SPANISH_WORDS[SPECIAL_HUMAN_6_JOKE] = "Hallelujah, brother, your bank transfer won’t be in vain";
		SPANISH_WORDS[SPECIAL_HUMAN_7] = "Cyborg";
		SPANISH_WORDS[SPECIAL_HUMAN_7_JOKE] = "I have… seen things you people wouldn't believe";
		
		// PROPHET
		SPANISH_WORDS[PROPHET_NAME] = "Prophet";
		SPANISH_WORDS[PROPHET_DESCRIPTION] = "A prophet is a human who understands even less, but thinks the exact opposite";
		SPANISH_WORDS[PROPHET_UPGRADE_1] = "Fake beard";
		SPANISH_WORDS[PROPHET_UPGRADE_1_JOKE] = "Essential for stoning";
		SPANISH_WORDS[PROPHET_UPGRADE_2] = "Pessimistic oracle";
		SPANISH_WORDS[PROPHET_UPGRADE_2_JOKE] = "I guess you’ll last for two weeks";
		SPANISH_WORDS[PROPHET_UPGRADE_3] = "Apocalyptic prophecy";
		SPANISH_WORDS[PROPHET_UPGRADE_3_JOKE] = "And when the seventh seal is opened she will say: ...We need to talk";
		SPANISH_WORDS[PROPHET_UPGRADE_4] = "The Flood";
		SPANISH_WORDS[PROPHET_UPGRADE_4_JOKE] = "Save two of each kind: two brunettes, two redheads and two blondes";
		SPANISH_WORDS[PROPHET_UPGRADE_5] = "Shooting star";
		SPANISH_WORDS[PROPHET_UPGRADE_5_JOKE] = "The moment is coming";
		SPANISH_WORDS[PROPHET_UPGRADE_6] = "Miraculous duplication";
		SPANISH_WORDS[PROPHET_UPGRADE_6_JOKE] = "This is against thermodynam-SHUT UP!";
		SPANISH_WORDS[PROPHET_UPGRADE_7] = "Resurrection";
		SPANISH_WORDS[PROPHET_UPGRADE_7_JOKE] = "You may take a shower after three days being dead";
		SPANISH_WORDS[PROPHET_UPGRADE_8] = "Holy book of Love";
		SPANISH_WORDS[PROPHET_UPGRADE_8_JOKE] = "Wait, what are all those positions for?";
		SPANISH_WORDS[PROPHET_UPGRADE_9] = "Lovelogy";
		SPANISH_WORDS[PROPHET_UPGRADE_9_JOKE] = "All you need to know to avoid it";
		SPANISH_WORDS[PROPHET_UPGRADE_10] = "Unfair competition";
		SPANISH_WORDS[PROPHET_UPGRADE_10_JOKE] = "If their god were real, wouldn’t he saved them?";
		
		// TEMPLE
		SPANISH_WORDS[TEMPLE_NAME] = "Temple";
		SPANISH_WORDS[TEMPLE_DESCRIPTION] = "A temple in the name of love, more or less";
		SPANISH_WORDS[TEMPLE_UPGRADE_1] = "Love Sanctuary";
		SPANISH_WORDS[TEMPLE_UPGRADE_1_JOKE] = "A place to give and receive";
		SPANISH_WORDS[TEMPLE_UPGRADE_2] = "Generous almsgiving";
		SPANISH_WORDS[TEMPLE_UPGRADE_2_JOKE] = "It never has been easier to earn a living";
		SPANISH_WORDS[TEMPLE_UPGRADE_3] = "Divine visions";
		SPANISH_WORDS[TEMPLE_UPGRADE_3_JOKE] = "No more cheap wine";
		SPANISH_WORDS[TEMPLE_UPGRADE_4] = "Obedient altar boys";
		SPANISH_WORDS[TEMPLE_UPGRADE_4_JOKE] = "These kids make more bearable the long and hard... masses at the monastery";
		SPANISH_WORDS[TEMPLE_UPGRADE_5] = "Remorseful sinners";
		SPANISH_WORDS[TEMPLE_UPGRADE_5_JOKE] = "Get on your knees and earn your absolution";
		SPANISH_WORDS[TEMPLE_UPGRADE_6] = "Elder in a dress";
		SPANISH_WORDS[TEMPLE_UPGRADE_6_JOKE] = "I am the voice of God on earth";
		SPANISH_WORDS[TEMPLE_UPGRADE_7] = "Witch hunt";
		SPANISH_WORDS[TEMPLE_UPGRADE_7_JOKE] = "These ladies need affection desperately";
		SPANISH_WORDS[TEMPLE_UPGRADE_8] = "Punish heretics";
		SPANISH_WORDS[TEMPLE_UPGRADE_8_JOKE] = "You have to spank them gently";
		SPANISH_WORDS[TEMPLE_UPGRADE_9] = "Repulsive relic";
		SPANISH_WORDS[TEMPLE_UPGRADE_9_JOKE] = "I hope that's a wrinkled thumb...";
		SPANISH_WORDS[TEMPLE_UPGRADE_10] = "Violent pilgrimage";
		SPANISH_WORDS[TEMPLE_UPGRADE_10_JOKE] = "We’re going to the Land of Love and will kill whoever stands in our way";
		
		// SHIP
		SPANISH_WORDS[SHIP_NAME] = "Ship";
		SPANISH_WORDS[SHIP_DESCRIPTION] = "A ship to bring love across the seas";
		SPANISH_WORDS[SHIP_UPGRADE_1] = "Into the unknown";
		SPANISH_WORDS[SHIP_UPGRADE_1_JOKE] = "Honey, I’m going out for tobacco";
		SPANISH_WORDS[SHIP_UPGRADE_2] = "Obscene figurehead";
		SPANISH_WORDS[SHIP_UPGRADE_2_JOKE] = "The crew looks excited";
		SPANISH_WORDS[SHIP_UPGRADE_3] = "Intercultural exchange";
		SPANISH_WORDS[SHIP_UPGRADE_3_JOKE] = "Enjoy the Amazons' coconuts";
		SPANISH_WORDS[SHIP_UPGRADE_4] = "Contagious love flu";
		SPANISH_WORDS[SHIP_UPGRADE_4_JOKE] = "Love is in the air";
		SPANISH_WORDS[SHIP_UPGRADE_5] = "The chosen ones";
		SPANISH_WORDS[SHIP_UPGRADE_5_JOKE] = "One race to rule them all";
		SPANISH_WORDS[SHIP_UPGRADE_6] = "Convert infidels";
		SPANISH_WORDS[SHIP_UPGRADE_6_JOKE] = "Teach them how to love properly";
		SPANISH_WORDS[SHIP_UPGRADE_7] = "Pleasurable whiplashes";
		SPANISH_WORDS[SHIP_UPGRADE_7_JOKE] = "Now with heart-shaped bruises";
		SPANISH_WORDS[SHIP_UPGRADE_8] = "Pirates ahoy!";
		SPANISH_WORDS[SHIP_UPGRADE_8_JOKE] = "Arr! Stealing love is easier than earning it!";
		SPANISH_WORDS[SHIP_UPGRADE_9] = "Paradise map";
		SPANISH_WORDS[SHIP_UPGRADE_9_JOKE] = "Ideal to find the G spot,  I mean, to spot the X";
		SPANISH_WORDS[SHIP_UPGRADE_10] = "Invincible Fleet";
		SPANISH_WORDS[SHIP_UPGRADE_10_JOKE] = "Definitively invincible";
		
		// FACTORY
		SPANISH_WORDS[FACTORY_NAME] = "Factory";
		SPANISH_WORDS[FACTORY_DESCRIPTION] = "A factory to manufacture love";
		SPANISH_WORDS[FACTORY_UPGRADE_1] = "Teamwork";
		SPANISH_WORDS[FACTORY_UPGRADE_1_JOKE] = "You sweat and I supervise";
		SPANISH_WORDS[FACTORY_UPGRADE_2] = "Tiny hands";
		SPANISH_WORDS[FACTORY_UPGRADE_2_JOKE] = "Tiny workers to manage even the tiniest details";
		SPANISH_WORDS[FACTORY_UPGRADE_3] = "Lowered standards";
		SPANISH_WORDS[FACTORY_UPGRADE_3_JOKE] = "We will have to settle for this";
		SPANISH_WORDS[FACTORY_UPGRADE_4] = "Ignore nonsense";
		SPANISH_WORDS[FACTORY_UPGRADE_4_JOKE] = "Some workers demand sleep";
		SPANISH_WORDS[FACTORY_UPGRADE_5] = "Steam engines";
		SPANISH_WORDS[FACTORY_UPGRADE_5_JOKE] = "Increased production at the expense of a few accidents";
		SPANISH_WORDS[FACTORY_UPGRADE_6] = "Fair rights";
		SPANISH_WORDS[FACTORY_UPGRADE_6_JOKE] = "You have the right to shut up";
		SPANISH_WORDS[FACTORY_UPGRADE_7] = "Oversupply";
		SPANISH_WORDS[FACTORY_UPGRADE_7_JOKE] = "Don't stop me now";
		SPANISH_WORDS[FACTORY_UPGRADE_8] = "Toxic gas leaks";
		SPANISH_WORDS[FACTORY_UPGRADE_8_JOKE] = "Dead employees will be fired";
		SPANISH_WORDS[FACTORY_UPGRADE_9] = "Scab Monkeys";
		SPANISH_WORDS[FACTORY_UPGRADE_9_JOKE] = "They demand a lot of bananas, but do not demand any right";
		SPANISH_WORDS[FACTORY_UPGRADE_10] = "Acid Rivers";
		SPANISH_WORDS[FACTORY_UPGRADE_10_JOKE] = "Catching fish bare-hands it’s easy when they float face up";
		
		// LABORATORY
		SPANISH_WORDS[LABORATORY_NAME] = "Laboratory";
		SPANISH_WORDS[LABORATORY_DESCRIPTION] = "A laboratory to understand the nature of love";
		SPANISH_WORDS[LABORATORY_UPGRADE_1] = "First patent";
		SPANISH_WORDS[LABORATORY_UPGRADE_1_JOKE] = "A revolutionary device, but it needs a lot of lube";
		SPANISH_WORDS[LABORATORY_UPGRADE_2] = "Brilliant minds";
		SPANISH_WORDS[LABORATORY_UPGRADE_2_JOKE] = "We invented a lot of things, but now we have to figure what are they for";
		SPANISH_WORDS[LABORATORY_UPGRADE_3] = "Robo-maid";
		SPANISH_WORDS[LABORATORY_UPGRADE_3_JOKE] = "Scientists are very pleased";
		SPANISH_WORDS[LABORATORY_UPGRADE_4] = "Cute explosion";
		SPANISH_WORDS[LABORATORY_UPGRADE_4_JOKE] = "Contains an enriched isotope love";
		SPANISH_WORDS[LABORATORY_UPGRADE_5] = "General relativity";
		SPANISH_WORDS[LABORATORY_UPGRADE_5_JOKE] = "Sometimes ‘no’ means ‘yes";
		SPANISH_WORDS[LABORATORY_UPGRADE_6] = "Love fundamental particle";
		SPANISH_WORDS[LABORATORY_UPGRADE_6_JOKE] = "The model is perfect, but reality doesn’t fit well in it";
		SPANISH_WORDS[LABORATORY_UPGRADE_7] = "Quantum love";
		SPANISH_WORDS[LABORATORY_UPGRADE_7_JOKE] = "Entangled hearts";
		SPANISH_WORDS[LABORATORY_UPGRADE_8] = "Violation of physical laws";
		SPANISH_WORDS[LABORATORY_UPGRADE_8_JOKE] = "Inside this lab nobody will hear you scream";
		SPANISH_WORDS[LABORATORY_UPGRADE_9] = "Broken spatiotemporal fabric";
		SPANISH_WORDS[LABORATORY_UPGRADE_9_JOKE] = "We are developing a spatiotemporal needle to patch it";
		SPANISH_WORDS[LABORATORY_UPGRADE_10] = "LoveOS";
		SPANISH_WORDS[LABORATORY_UPGRADE_10_JOKE] = "The answer to your question is 69";
		
		// SHOP
		SPANISH_WORDS[SHOP_NAME] = "Shop";
		SPANISH_WORDS[SHOP_DESCRIPTION] = "A shop where you can buy love at a reasonable price";
		SPANISH_WORDS[SHOP_UPGRADE_1] = "Selling affection";
		SPANISH_WORDS[SHOP_UPGRADE_1_JOKE] = "Now you can buy your happiness without commitments";
		SPANISH_WORDS[SHOP_UPGRADE_2] = "Crazy sales";
		SPANISH_WORDS[SHOP_UPGRADE_2_JOKE] = "For that price… gimme seven!";
		SPANISH_WORDS[SHOP_UPGRADE_3] = "Planned obsolescence";
		SPANISH_WORDS[SHOP_UPGRADE_3_JOKE] = "Our relationship has no future";
		SPANISH_WORDS[SHOP_UPGRADE_4] = "Disposable love";
		SPANISH_WORDS[SHOP_UPGRADE_4_JOKE] = "Piles of rubbish as far as the eye can see";
		SPANISH_WORDS[SHOP_UPGRADE_5] = "Product design";
		SPANISH_WORDS[SHOP_UPGRADE_5_JOKE] = "Awesome, now with 87% more packing!";
		SPANISH_WORDS[SHOP_UPGRADE_6] = "Invasive product placement";
		SPANISH_WORDS[SHOP_UPGRADE_6_JOKE] = "Enjoy incredible ads while you’re dreaming";
		SPANISH_WORDS[SHOP_UPGRADE_7] = "Imported love";
		SPANISH_WORDS[SHOP_UPGRADE_7_JOKE] = "Developed by the third world for our joy";
		SPANISH_WORDS[SHOP_UPGRADE_8] = "Make up new festivity";
		SPANISH_WORDS[SHOP_UPGRADE_8_JOKE] = "Consume more, you bastards";
		SPANISH_WORDS[SHOP_UPGRADE_9] = "Loveh*";
		SPANISH_WORDS[SHOP_UPGRADE_9_JOKE] = "Almost* like the original";
		SPANISH_WORDS[SHOP_UPGRADE_10] = "LoveCard®";
		SPANISH_WORDS[SHOP_UPGRADE_10_JOKE] = "There are things that love can’t buy, for everything else: LoveCard®";
		
		// SPACESHIP
		SPANISH_WORDS[SPACESHIP_NAME] = "Spaceship";
		SPANISH_WORDS[SPACESHIP_DESCRIPTION] = "A spaceship to spread love to other galaxies";
		SPANISH_WORDS[SPACESHIP_UPGRADE_1] = "Astronaut dog";
		SPANISH_WORDS[SPACESHIP_UPGRADE_1_JOKE] = "Ouch, we forgot to give him his space food";
		SPANISH_WORDS[SPACESHIP_UPGRADE_2] = "Fake moon landing";
		SPANISH_WORDS[SPACESHIP_UPGRADE_2_JOKE] = "Raising the audience is also a giant leap";
		SPANISH_WORDS[SPACESHIP_UPGRADE_3] = "Cosmic jet";
		SPANISH_WORDS[SPACESHIP_UPGRADE_3_JOKE] = "Shake before use";
		SPANISH_WORDS[SPACESHIP_UPGRADE_4] = "Space junk";
		SPANISH_WORDS[SPACESHIP_UPGRADE_4_JOKE] = "Although you can throw it far away it’s not gonna disappear";
		SPANISH_WORDS[SPACESHIP_UPGRADE_5] = "International Space Station";
		SPANISH_WORDS[SPACESHIP_UPGRADE_5_JOKE] = "Zero gravity opens up new possibilities, we must update the Holy Book of Love";
		SPANISH_WORDS[SPACESHIP_UPGRADE_6] = "Pacifist colonies";
		SPANISH_WORDS[SPACESHIP_UPGRADE_6_JOKE] = "Full of leftover hippies";
		SPANISH_WORDS[SPACESHIP_UPGRADE_7] = "Open up pink hole";
		SPANISH_WORDS[SPACESHIP_UPGRADE_7_JOKE] = "Crossing it can cause a tear in the space-time";
		SPANISH_WORDS[SPACESHIP_UPGRADE_8] = "Close Encounters of the Third Kind";
		SPANISH_WORDS[SPACESHIP_UPGRADE_8_JOKE] = "They are a bit stupid, but we must learn to love them - Signed: The Aliens";
		SPANISH_WORDS[SPACESHIP_UPGRADE_9] = "Faster than light";
		SPANISH_WORDS[SPACESHIP_UPGRADE_9_JOKE] = "Hyperspatial jumping is awesome until the day you crash into a star";
		SPANISH_WORDS[SPACESHIP_UPGRADE_10] = "Galactic Empire";
		SPANISH_WORDS[SPACESHIP_UPGRADE_10_JOKE] = "May the love be with you";
		
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
