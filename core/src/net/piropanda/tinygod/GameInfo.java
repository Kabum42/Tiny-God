package net.piropanda.tinygod;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;

public class GameInfo {
   private static final String SERIAL_VERSION = "1.1";
   
   
   // producers
   public static final String ID_PROD_SERVANT = "servant";
   public static final double PROD_PRICE_SERVANT = 15.0;
   public static final double PROD_LPS_SERVANT = 0.1;
   
   public static final String ID_PROD_HUMAN = "human";
   public static final double PROD_PRICE_HUMAN = 100.0;
   public static final double PROD_LPS_HUMAN = 0.5;
   
   public static final String ID_PROD_PROPHET = "prophet";
   public static final double PROD_PRICE_PROPHET = 500.0;
   public static final double PROD_LPS_PROPHET = 4.0;
   
   public static final String ID_PROD_TEMPLE = "temple";
   public static final double PROD_PRICE_TEMPLE = 3000.0; // 3 K
   public static final double PROD_LPS_TEMPLE = 10.0;
   
   public static final String ID_PROD_SHIP = "ship";
   public static final double PROD_PRICE_SHIP = 10000.0; // 10 K
   public static final double PROD_LPS_SHIP = 40.0;
   
   public static final String ID_PROD_FACTORY = "factory";
   public static final double PROD_PRICE_FACTORY = 40000.0; // 40 K
   public static final double PROD_LPS_FACTORY = 100.0;
   
   public static final String ID_PROD_LABORATORY = "laboratory";
   public static final double PROD_PRICE_LABORATORY = 200000.0; // 200 K
   public static final double PROD_LPS_LABORATORY = 400.0;

   public static final String ID_PROD_HIPPIEVAN = "hippievan";
   public static final double PROD_PRICE_HIPPIEVAN = 1700000.0; // 1.7 M
   public static final double PROD_LPS_HIPPIEVAN = 7000.0; // 7K
   
   public static final String ID_PROD_SHOP = "shop";
   public static final double PROD_PRICE_SHOP = 125000000.0; // 125 M
   public static final double PROD_LPS_SHOP = 100000.0; // 100 K
   
   public static final String ID_PROD_SPACESHIP = "spaceship";
   public static final double PROD_PRICE_SPACESHIP = 4000000000.0; // 4 B
   public static final double PROD_LPS_SPACESHIP = 1000000.0; // 1 M
   
   // achievements
   public static final String ID_ACH_SERVANT_1_NAME = "ID_ACH_SERVANT_1";
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
   
   
   // needs to be saved/loaded
   public static double love, totalLove;
   public static int clicks; // number of clicks since the beginning
   public static HashMap<String, Integer> producers = new HashMap<String, Integer>(); // producers owned
   public static HashMap<String, Boolean> upgrades = new HashMap<String, Boolean>(); // upgrades acquired
   public static HashMap<String, Boolean> achievements = new HashMap<String, Boolean>(); // achievements unlocked
   // auto-updates every frame
   public static double lps; 
   public static double lovePerClick, criticalClickMultiplier, criticalClickChance;

   
   public GameInfo() {
	   reset();
   }
   
   public static void addLove(double amount) {
	   love += amount;
	   totalLove += amount;
   }
   
   public static void addBuilding(String name) { producers.put(name, producers.get(name) + 1); }
   
   public static boolean isAchievementUnlocked(String name) { return achievements.get(name); }
   public static void unlockAchievement(String name) { achievements.put(name, true); }
   
   public static boolean isUpgradeUnlocked(String name) { return upgrades.get(name); }
   public static void unlockUpgrade(String name) { upgrades.put(name, true); }
   
   public static void loadFromSnapshot (byte[] data) {
       if (data != null) {
    	   loadFromJson(new String(data));
       }
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
               achievements.put(achievementName, jsonAchievements.getBoolean(achievementName));
           }
           
       }
       catch (JSONException ex) {
           ex.printStackTrace();
       }
       catch (NumberFormatException ex) {
           ex.printStackTrace();
           throw new RuntimeException("Save data has an invalid number in it: " + json, ex);
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
           for(String buildingName : producers.keySet()) { jsonBuildings.put(buildingName, producers.get(buildingName)); }
           for(String upgradeName : upgrades.keySet()) { jsonUpgrades.put(upgradeName, producers.get(upgradeName)); }
           for(String achievementName : achievements.keySet()) { jsonAchievements.put(achievementName, producers.get(achievementName)); }

           JSONObject obj = new JSONObject();
           obj.put("version", SERIAL_VERSION);
           obj.put("love", jsonLove);
           obj.put("totalLove", jsonTotalLove);
           obj.put("buildings", jsonBuildings);
           obj.put("upgrades", jsonUpgrades);
           obj.put("achievements", jsonAchievements);
           
           return obj.toString();
       }
       catch (JSONException ex) {
           ex.printStackTrace();
           throw new RuntimeException("Error converting save data to JSON.", ex);
       }
   }
   
   public static void reset() {
       love = 0.0;
       totalLove = love;

       lovePerClick = 1.0;
       criticalClickMultiplier = 5.0; // 5x
       criticalClickChance = 1; // 1%
       
       clicks = 0;
	   
	   resetBuildings();
	   resetUpgrades();
	   resetAchievements();
   }
   
   private static void resetBuildings() {
	   producers.clear();
	   
	   producers.put(ID_PROD_SERVANT, 0);
	   producers.put(ID_PROD_HUMAN, 0);
	   producers.put(ID_PROD_PROPHET, 0);
	   producers.put(ID_PROD_TEMPLE, 0);
	   producers.put(ID_PROD_SHIP, 0);
	   producers.put(ID_PROD_FACTORY, 0);
	   producers.put(ID_PROD_LABORATORY, 0);
	   producers.put(ID_PROD_HIPPIEVAN, 0);
	   producers.put(ID_PROD_SHOP, 0);
	   producers.put(ID_PROD_SPACESHIP, 0);
   }
   
   private static void resetUpgrades() {
	   upgrades.clear();
	   
	   upgrades.put(ID_UPG_SERVANT_1_NAME, false);
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
	   
	  lps = 0.0;
	  criticalClickChance = 0.1;
	  criticalClickMultiplier = 10.0;
	  
	  lps += producers.get(ID_PROD_SERVANT) 	* PROD_LPS_SERVANT;
	  lps += producers.get(ID_PROD_HUMAN) 		* PROD_LPS_HUMAN;
	  lps += producers.get(ID_PROD_PROPHET) 	* PROD_LPS_PROPHET;
	  lps += producers.get(ID_PROD_TEMPLE) 		* PROD_LPS_TEMPLE;
	  lps += producers.get(ID_PROD_SHIP) 		* PROD_LPS_SHIP;
	  lps += producers.get(ID_PROD_FACTORY) 	* PROD_LPS_FACTORY;
	  lps += producers.get(ID_PROD_LABORATORY) 	* PROD_LPS_LABORATORY;
	  lps += producers.get(ID_PROD_HIPPIEVAN) 	* PROD_LPS_HIPPIEVAN;
	  lps += producers.get(ID_PROD_SHOP) 		* PROD_LPS_SHOP;
	  lps += producers.get(ID_PROD_SPACESHIP) 	* PROD_LPS_SPACESHIP;
	  
	  lovePerClick = 1.0;
	  
	  double gain = lps * dt;
	  totalLove += gain;
	  love += gain;
   }

}

