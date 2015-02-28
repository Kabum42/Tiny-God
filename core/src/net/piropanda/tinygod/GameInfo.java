package net.piropanda.tinygod;

import java.util.HashMap;

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
		// reset();
		//
		// if (json == null || json.trim().equals("")) return;
		//
		// try {
		// JSONObject obj = new JSONObject(json);
		// String format = obj.getString("version");
		//
		// if (!format.equals(SERIAL_VERSION)) {
		// throw new RuntimeException("Unexpected loot format " + format);
		// }
		//
		// JSONObject jsonLove = obj.getJSONObject("love");
		// JSONObject jsonTotalLove = obj.getJSONObject("totalLove");
		// JSONObject jsonBuildings = obj.getJSONObject("buildings");
		// JSONObject jsonUpgrades = obj.getJSONObject("upgrades");
		// JSONObject jsonAchievements = obj.getJSONObject("achievements");
		//
		// Iterator<?> iterLove = jsonLove.keys();
		// Iterator<?> iterTotalLove = jsonTotalLove.keys();
		// Iterator<?> iterBuildings = jsonBuildings.keys();
		// Iterator<?> iterUpgrades = jsonUpgrades.keys();
		// Iterator<?> iterAchievements = jsonAchievements.keys();
		//
		// while (iterLove.hasNext()) {
		// String loveName = (String)iterLove.next();
		// love = jsonLove.getfloat(loveName);
		// }
		//
		// while (iterTotalLove.hasNext()) {
		// String totalLoveName = (String)iterTotalLove.next();
		// totalLove = jsonTotalLove.getfloat(totalLoveName);
		// }
		//
		// while (iterBuildings.hasNext()) {
		// String buildingName = (String)iterBuildings.next();
		// producers.put(buildingName, jsonBuildings.getInt(buildingName));
		// }
		//
		// while (iterUpgrades.hasNext()) {
		// String upgradeName = (String)iterUpgrades.next();
		// upgrades.put(upgradeName, jsonUpgrades.getBoolean(upgradeName));
		// }
		//
		// while (iterAchievements.hasNext()) {
		// String achievementName = (String)iterAchievements.next();
		// achievements.put(achievementName,
		// jsonAchievements.getBoolean(achievementName));
		// }
		//
		// }
		// catch (JSONException ex) {
		// ex.printStackTrace();
		// }
		// catch (NumberFormatException ex) {
		// ex.printStackTrace();
		// throw new RuntimeException("Save data has an invalid number in it: "
		// + json, ex);
		// }
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

		producers.put(ProducerInfo.SERVANT_ID, 0);
		producers.put(ProducerInfo.HUMAN_ID, 0);
		producers.put(ProducerInfo.PROPHET_ID, 0);
		producers.put(ProducerInfo.TEMPLE_ID, 0);
		producers.put(ProducerInfo.SHIP_ID, 0);
		producers.put(ProducerInfo.FACTORY_ID, 0);
		producers.put(ProducerInfo.LABORATORY_ID, 0);
		producers.put(ProducerInfo.HIPPIEVAN_ID, 0);
		producers.put(ProducerInfo.SHOP_ID, 0);
		producers.put(ProducerInfo.SPACESHIP_ID, 0);
	}

	private static void resetUpgrades() {
		upgrades.clear();

		upgrades.put(ID_UPG_SERVANT_1_NAME, false);
		upgrades.put(ID_UPG_SERVANT_25_NAME, false);
		upgrades.put(ID_UPG_SERVANT_50_NAME, false);
		upgrades.put(ID_UPG_SERVANT_100_NAME, false);
		upgrades.put(ID_UPG_SERVANT_200_NAME, false);
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

		lps += producers.get(ProducerInfo.SERVANT_ID) 		* ProducerInfo.getLps(ProducerInfo.SERVANT_ID);
		lps += producers.get(ProducerInfo.HUMAN_ID) 		* ProducerInfo.getLps(ProducerInfo.HUMAN_ID);
		lps += producers.get(ProducerInfo.PROPHET_ID) 		* ProducerInfo.getLps(ProducerInfo.PROPHET_ID);
		lps += producers.get(ProducerInfo.TEMPLE_ID) 		* ProducerInfo.getLps(ProducerInfo.TEMPLE_ID);
		lps += producers.get(ProducerInfo.SHIP_ID) 			* ProducerInfo.getLps(ProducerInfo.SHIP_ID);
		lps += producers.get(ProducerInfo.FACTORY_ID) 		* ProducerInfo.getLps(ProducerInfo.FACTORY_ID);
		lps += producers.get(ProducerInfo.LABORATORY_ID) 	* ProducerInfo.getLps(ProducerInfo.LABORATORY_ID);
		lps += producers.get(ProducerInfo.HIPPIEVAN_ID) 	* ProducerInfo.getLps(ProducerInfo.HIPPIEVAN_ID);
		lps += producers.get(ProducerInfo.SHOP_ID) 			* ProducerInfo.getLps(ProducerInfo.SHOP_ID);
		lps += producers.get(ProducerInfo.SPACESHIP_ID) 	* ProducerInfo.getLps(ProducerInfo.SPACESHIP_ID);

		lovePerClick = 1f;

		double gain = lps * dt;
		love += gain;
		totalLove += gain;
	}

}
