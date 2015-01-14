package com.piropanda.projectx.helpers;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class GameInfo {
   private static final String SERIAL_VERSION = "1.1";
   
   
   // producers
   public static final String BUILDING_SERVANT = "servant";
   public static final String BUILDING_HUMAN = "human";
   public static final String BUILDING_PROPHET = "prophet";
   public static final String BUILDING_TEMPLE = "temple";
   public static final String BUILDING_SHIP = "ship";
   public static final String BUILDING_FACTORY = "factory";
   public static final String BUILDING_LABORATORY = "laboratory";
   public static final String BUILDING_HIPPIE_VAN = "hippievan";
   public static final String BUILDING_SHOP = "shop";
   public static final String BUILDING_SPACESHIP = "spaceship";
   
   public static final double PRICE_SERVANT = 15.0;
   public static final double PRICE_HUMAN = 100.0;
   public static final double PRICE_PROPHET = 500.0;
   public static final double PRICE_TEMPLE = 3000.0; // 3 K
   public static final double PRICE_SHIP = 10000.0; // 10 K
   public static final double PRICE_FACTORY = 40000.0; // 40 K
   public static final double PRICE_LABORATORY = 200000.0; // 200 K
   public static final double PRICE_HIPPIE_VAN = 1700000.0; // 1.7 M
   public static final double PRICE_SHOP = 125000000.0; // 125 M
   public static final double PRICE_SPACESHIP = 4000000000.0; // 4 B
   
   public static final double LPSBASE_SERVANT = 0.1;
   public static final double LPSBASE_HUMAN = 0.5;
   public static final double LPSBASE_PROPHET = 4.0;
   public static final double LPSBASE_TEMPLE = 10.0;
   public static final double LPSBASE_SHIP = 40.0;
   public static final double LPSBASE_FACTORY = 100.0;
   public static final double LPSBASE_LABORATORY = 400.0;
   public static final double LPSBASE_HIPPIE_VAN = 7000.0; // 7K
   public static final double LPSBASE_SHOP = 100000.0; // 100 K
   public static final double LPSBASE_SPACESHIP = 1000000.0; // 1 M
   
   // achievements
   
   // upgrades
   
   
   // needs to be saved/loaded
   public static double love, totalLove; 
   public static int clicks;
   public static HashMap<String,Integer> buildings = new HashMap<String, Integer>();
   public static HashMap<String,Boolean> upgrades = new HashMap<String, Boolean>();
   public static HashMap<String,Boolean> achievements = new HashMap<String, Boolean>();
   // auto-updates every frame
   public static double lps, loveClick; 

   
   public GameInfo() {
	   reset();
   }
   
   public static void addBuilding(String name) { buildings.put(name, buildings.get(name) + 1); }
   
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
               buildings.put(buildingName, jsonBuildings.getInt(buildingName));
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
       
       GameStateManager.load();
       
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
           for(String buildingName : buildings.keySet()) { jsonBuildings.put(buildingName, buildings.get(buildingName)); }
           for(String upgradeName : upgrades.keySet()) { jsonUpgrades.put(upgradeName, buildings.get(upgradeName)); }
           for(String achievementName : achievements.keySet()) { jsonAchievements.put(achievementName, buildings.get(achievementName)); }

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
       loveClick = 1.0;
       clicks = 0;
	   
	   resetBuildings();
	   resetUpgrades();
	   resetAchievements();	   
   }
   
   private static void resetBuildings() {
	   buildings.clear();
	   
	   buildings.put(BUILDING_SERVANT, 0);
	   buildings.put(BUILDING_HUMAN, 0);
	   buildings.put(BUILDING_PROPHET, 0);
	   buildings.put(BUILDING_TEMPLE, 0);
	   buildings.put(BUILDING_SHIP, 0);
	   buildings.put(BUILDING_FACTORY, 0);
	   buildings.put(BUILDING_LABORATORY, 0);
	   buildings.put(BUILDING_HIPPIE_VAN, 0);
	   buildings.put(BUILDING_SHOP, 0);
	   buildings.put(BUILDING_SPACESHIP, 0);
   }
   
   private static void resetUpgrades() {
	   upgrades.clear();
   }
   
   private static void resetAchievements() {
	   achievements.clear();
   }
   
   public static void update(float dt) {
	  lps = 0.0;
	  
	  lps += buildings.get(BUILDING_SERVANT) 	* LPSBASE_SERVANT;
	  lps += buildings.get(BUILDING_HUMAN) 		* LPSBASE_HUMAN;
	  lps += buildings.get(BUILDING_PROPHET) 	* LPSBASE_PROPHET;
	  lps += buildings.get(BUILDING_TEMPLE) 	* LPSBASE_TEMPLE;
	  lps += buildings.get(BUILDING_SHIP) 		* LPSBASE_SHIP;
	  lps += buildings.get(BUILDING_FACTORY) 	* LPSBASE_FACTORY;
	  lps += buildings.get(BUILDING_LABORATORY) * LPSBASE_LABORATORY;
	  lps += buildings.get(BUILDING_HIPPIE_VAN) * LPSBASE_HIPPIE_VAN;
	  lps += buildings.get(BUILDING_SHOP) 		* LPSBASE_SHOP;
	  lps += buildings.get(BUILDING_SPACESHIP) 	* LPSBASE_SPACESHIP;
	  
	  loveClick = 1.0;
	  
	  double gain = lps * dt;
	  totalLove += gain;
	  love += gain;
   }

}

