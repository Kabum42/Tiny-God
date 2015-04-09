package net.piropanda.tinygod;

import java.util.HashMap;
import java.util.Iterator;

import net.piropanda.tinygod.helpers.ProducerInfo;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;

public class GameInfo {
	private static final String SERIAL_VERSION = "1.1";
   
   
	// achievements
	public static final String ID_ACH_SERVANT_1_NAME = "test";
	public static final String ID_ACH_SERVANT_1_QUOTE = "ID_ACH_SERVANT_1_QUOTE";
	public static final String ID_ACH_SERVANT_25_NAME = "ID_ACH_SERVANT_25";
	public static final String ID_ACH_SERVANT_25_QUOTE = "ID_ACH_SERVANT_25_QUOTE";
	public static final String ID_ACH_SERVANT_50_NAME = "ID_ACH_SERVANT_50";
	public static final String ID_ACH_SERVANT_50_QUOTE = "ID_ACH_SERVANT_50_QUOTE";
	public static final String ID_ACH_SERVANT_100_NAME = "ID_ACH_SERVANT_100";
	public static final String ID_ACH_SERVANT_100_QUOTE = "ID_ACH_SERVANT_100_QUOTE";
	public static final String ID_ACH_SERVANT_200_NAME = "ID_ACH_SERVANT_200";
	public static final String ID_ACH_SERVANT_200_QUOTE = "ID_ACH_SERVANT_200_QUOTE";

	public static final String ID_ACH_HUMAN_1_NAME = "ID_ACH_HUMAN_1";
	public static final String ID_ACH_HUMAN_1_QUOTE = "ID_ACH_HUMAN_1_QUOTE";
	public static final String ID_ACH_HUMAN_25_NAME = "ID_ACH_HUMAN_25";
	public static final String ID_ACH_HUMAN_25_QUOTE = "ID_ACH_HUMAN_25_QUOTE";
	public static final String ID_ACH_HUMAN_50_NAME = "ID_ACH_HUMAN_50";
	public static final String ID_ACH_HUMAN_50_QUOTE = "ID_ACH_HUMAN_50_QUOTE";
	public static final String ID_ACH_HUMAN_100_NAME = "ID_ACH_HUMAN_100";
	public static final String ID_ACH_HUMAN_100_QUOTE = "ID_ACH_HUMAN_100_QUOTE";
	public static final String ID_ACH_HUMAN_200_NAME = "ID_ACH_HUMAN_200";
	public static final String ID_ACH_HUMAN_200_QUOTE = "ID_ACH_HUMAN_200_QUOTE";

	// upgrades
	public static final String ID_UPG_SERVANT_1_NAME = "ID_UPG_SERVANT_1";
	public static final String ID_UPG_SERVANT_1_QUOTE = "UPG_SERVANT_QUOTE_1";
	public static final String ID_UPG_SERVANT_25_NAME = "ID_UPG_SERVANT_25";
	public static final String ID_UPG_SERVANT_25_QUOTE = "UPG_SERVANT_QUOTE_25";
	public static final String ID_UPG_SERVANT_50_NAME = "ID_UPG_SERVANT_50";
	public static final String ID_UPG_SERVANT_50_QUOTE = "UPG_SERVANT_QUOTE_50";
	public static final String ID_UPG_SERVANT_100_NAME = "ID_UPG_SERVANT_100";
	public static final String ID_UPG_SERVANT_100_QUOTE = "UPG_SERVANT_QUOTE_100";
	public static final String ID_UPG_SERVANT_200_NAME = "ID_UPG_SERVANT_200";
	public static final String ID_UPG_SERVANT_200_QUOTE = "UPG_SERVANT_QUOTE_200";

	// needs to be saved/loaded
	public static double love, totalLove;
	public static long clicks; // number of clicks since the beginning
	public static HashMap<String, Integer> producers = new HashMap<String, Integer>(); // producers owned
	public static HashMap<String, Boolean> upgrades = new HashMap<String, Boolean>(); // upgrades acquired
	public static HashMap<String, Boolean> achievements = new HashMap<String, Boolean>(); // achievements unlocked
	// auto-updates every frame
	public static double lps;
	public static double lovePerClick, criticalClickMultiplier, criticalClickChance;

	public static void addLove(double amount) {
		love += amount;
		totalLove += amount;
	}

	public static void addProducer(String name) {
		producers.put(name, producers.get(name) + 1);
	}

	public static boolean isAchievementUnlocked(String name) {
		return achievements.get(name);
	}

	public static void unlockAchievement(String name) {
		achievements.put(name, true);
	}

	public static boolean isUpgradeUnlocked(String name) {
		return upgrades.get(name);
	}

	public static void unlockUpgrade(String name) {
		upgrades.put(name, true);
	}

	public static void loadFromSnapshot(byte[] data) {
		// if (data != null) {
		// loadFromJson(new String(data));
		// }
	}

	public static void loadFromJson(String json) {
		 reset();
		
		 if (json == null || json.trim().equals("")) return;
		
		 try {
		 JSONObject obj = new JSONObject(json);
		 String format = obj.getString("version");
		
		 if (!format.equals(SERIAL_VERSION)) {
		 throw new RuntimeException("Unexpected loot format " + format);
		 }
		
		 JSONObject jsonLove = obj.getJSONObject("love");
		 JSONObject jsonTotalLove = obj.getJSONObject("totalLove");
		 JSONObject jsonBuildings = obj.getJSONObject("buildings");
		 JSONObject jsonUpgrades = obj.getJSONObject("upgrades");
		 JSONObject jsonAchievements = obj.getJSONObject("achievements");
		
		 Iterator<?> iterLove = jsonLove.keys();
		 Iterator<?> iterTotalLove = jsonTotalLove.keys();
		 Iterator<?> iterBuildings = jsonBuildings.keys();
		 Iterator<?> iterUpgrades = jsonUpgrades.keys();
		 Iterator<?> iterAchievements = jsonAchievements.keys();
		
		 while (iterLove.hasNext()) {
		 String loveName = (String)iterLove.next();
		 love = jsonLove.getDouble(loveName);
		 }
		
		 while (iterTotalLove.hasNext()) {
		 String totalLoveName = (String)iterTotalLove.next();
		 totalLove = jsonTotalLove.getDouble(totalLoveName);
		 }
		
		 while (iterBuildings.hasNext()) {
		 String buildingName = (String)iterBuildings.next();
		 producers.put(buildingName, jsonBuildings.getInt(buildingName));
		 }
		
		 while (iterUpgrades.hasNext()) {
		 String upgradeName = (String)iterUpgrades.next();
		 upgrades.put(upgradeName, jsonUpgrades.getBoolean(upgradeName));
		 }
		
		 while (iterAchievements.hasNext()) {
		 String achievementName = (String)iterAchievements.next();
		 achievements.put(achievementName,
		 jsonAchievements.getBoolean(achievementName));
		 }
		
		 }
		 catch (JSONException ex) {
		 ex.printStackTrace();
		 }
		 catch (NumberFormatException ex) {
		 ex.printStackTrace();
		 throw new RuntimeException("Save data has an invalid number in it: "
		 + json, ex);
		 }
	}

	public static byte[] toBytes() {
		return toString2().getBytes();
	}

	public static String toString2() {
		try {
			JSONObject jsonLove = new JSONObject();
			JSONObject jsonTotalLove = new JSONObject();
			JSONObject jsonBuildings = new JSONObject();
			JSONObject jsonUpgrades = new JSONObject();
			JSONObject jsonAchievements = new JSONObject();

			jsonLove.put("love", love);
			jsonTotalLove.put("totalLove", totalLove);
			for (String buildingName : producers.keySet()) {
				jsonBuildings.put(buildingName, producers.get(buildingName));
			}
			for (String upgradeName : upgrades.keySet()) {
				jsonUpgrades.put(upgradeName, producers.get(upgradeName));
			}
			for (String achievementName : achievements.keySet()) {
				jsonAchievements.put(achievementName,
						producers.get(achievementName));
			}

			JSONObject obj = new JSONObject();
			obj.put("version", SERIAL_VERSION);
			obj.put("love", jsonLove);
			obj.put("totalLove", jsonTotalLove);
			obj.put("buildings", jsonBuildings);
			obj.put("upgrades", jsonUpgrades);
			obj.put("achievements", jsonAchievements);

			return obj.toString();
		} catch (JSONException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Error converting save data to JSON.", ex);
		}
	}

	public static void reset() {
		love = 0.0;
		totalLove = love;

		lovePerClick = 1.0;
		criticalClickMultiplier = 5.0; // 5x
		criticalClickChance = 1.0; // 1%

		clicks = 0;

		resetBuildings();
		resetUpgrades();
		resetAchievements();
	}

	private static void resetBuildings() {
		producers.clear();

		producers.put(Lang.ENGLISH_WORDS[Lang.SERVANT_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.HUMAN_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.PROPHET_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.SHIP_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.FACTORY_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.SHOP_NAME], 0);
		producers.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_NAME], 0);
	}

	private static void resetUpgrades() {
		upgrades.clear();
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_7], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_10], false);
		
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_1], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_2], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_3], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_4], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_5], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_6], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_7], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_8], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_9], false);
		upgrades.put(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_10], false);
	}

	private static void resetAchievements() {
		achievements.clear();

		achievements.put(ID_ACH_SERVANT_1_NAME, false);
		achievements.put(ID_ACH_SERVANT_25_NAME, false);
		achievements.put(ID_ACH_SERVANT_50_NAME, false);
		achievements.put(ID_ACH_SERVANT_100_NAME, false);
		achievements.put(ID_ACH_SERVANT_200_NAME, false);

		achievements.put(ID_ACH_HUMAN_1_NAME, false);
		achievements.put(ID_ACH_HUMAN_25_NAME, false);
		achievements.put(ID_ACH_HUMAN_50_NAME, false);
		achievements.put(ID_ACH_HUMAN_100_NAME, false);
		achievements.put(ID_ACH_HUMAN_200_NAME, false);
	}

	public static void update() {
		float dt = Gdx.graphics.getDeltaTime();

		lps = 0.0f;
		criticalClickChance = 0.1;
		criticalClickMultiplier = 10.0;
		
		double lps_servant = producers.get(Lang.ENGLISH_WORDS[Lang.SERVANT_NAME]) 		* ProducerInfo.getLps(Lang.SERVANT_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_1])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_2])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_3])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_4])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_5])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_6])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_7])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_8])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_9])) { lps_servant *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SERVANT_UPGRADE_10])) { lps_servant *= 2; }

		double lps_human = producers.get(Lang.ENGLISH_WORDS[Lang.HUMAN_NAME]) 		* ProducerInfo.getLps(Lang.HUMAN_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_1])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_2])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_3])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_4])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_5])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_6])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_7])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_8])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_9])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.HUMAN_UPGRADE_10])) { lps_human *= 2; }
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_1])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_2])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_3])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_4])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_5])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_6])) { lps_human *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPECIAL_HUMAN_7])) { lps_human *= 2; }
		
		double lps_prophet = producers.get(Lang.ENGLISH_WORDS[Lang.PROPHET_NAME]) 		* ProducerInfo.getLps(Lang.PROPHET_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_1])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_2])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_3])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_4])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_5])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_6])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_7])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_8])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_9])) { lps_prophet *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.PROPHET_UPGRADE_10])) { lps_prophet *= 2; }
		
		double lps_temple = producers.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_NAME]) 		* ProducerInfo.getLps(Lang.TEMPLE_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_1])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_2])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_3])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_4])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_5])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_6])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_7])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_8])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_9])) { lps_temple *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.TEMPLE_UPGRADE_10])) { lps_temple *= 2; }
		
		double lps_ship = producers.get(Lang.ENGLISH_WORDS[Lang.SHIP_NAME]) 			* ProducerInfo.getLps(Lang.SHIP_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_1])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_2])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_3])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_4])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_5])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_6])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_7])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_8])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_9])) { lps_ship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHIP_UPGRADE_10])) { lps_ship *= 2; }
		
		double lps_factory = producers.get(Lang.ENGLISH_WORDS[Lang.FACTORY_NAME]) 		* ProducerInfo.getLps(Lang.FACTORY_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_1])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_2])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_3])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_4])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_5])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_6])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_7])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_8])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_9])) { lps_factory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.FACTORY_UPGRADE_10])) { lps_factory *= 2; }
		
		double lps_laboratory = producers.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_NAME]) 	* ProducerInfo.getLps(Lang.LABORATORY_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_1])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_2])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_3])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_4])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_5])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_6])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_7])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_8])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_9])) { lps_laboratory *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.LABORATORY_UPGRADE_10])) { lps_laboratory *= 2; }
		
		double lps_shop = producers.get(Lang.ENGLISH_WORDS[Lang.SHOP_NAME]) 	* ProducerInfo.getLps(Lang.SHOP_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_1])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_2])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_3])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_4])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_5])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_6])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_7])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_8])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_9])) { lps_shop *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SHOP_UPGRADE_10])) { lps_shop *= 2; }
		
		double lps_spaceship = producers.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_NAME]) 			* ProducerInfo.getLps(Lang.SPACESHIP_NAME);
		
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_1])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_2])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_3])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_4])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_5])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_6])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_7])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_8])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_9])) { lps_spaceship *= 2; }
		if (upgrades.get(Lang.ENGLISH_WORDS[Lang.SPACESHIP_UPGRADE_10])) { lps_spaceship *= 2; }

		lps += lps_servant;
		lps += lps_human;
		lps += lps_prophet;
		lps += lps_temple;
		lps += lps_ship;
		lps += lps_factory;
		lps += lps_laboratory;
		lps += lps_shop;
		lps += lps_spaceship;

		lovePerClick = 1f;

		double gain = lps * dt;
		love += gain;
		totalLove += gain;
	}

}
