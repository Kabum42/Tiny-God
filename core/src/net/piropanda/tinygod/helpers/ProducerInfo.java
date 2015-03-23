package net.piropanda.tinygod.helpers;

import java.util.ArrayList;
import java.util.HashMap;

import net.piropanda.tinygod.Lang;
import net.piropanda.tinygod.screens.creation.Producer;

public class ProducerInfo {

	private static HashMap<Integer, Float> cost = new HashMap<Integer, Float>();
	private static HashMap<Integer, Float> lps = new HashMap<Integer, Float>();
	
	public static final String SERVANT_ID = "servant";
//    public static final float SERVANT_INITIAL_PRICE = 15f;
//   	public static final float SERVANT_BASE_LPS = 0.1f;
	
    public static final String HUMAN_ID = "human";
//    public static final float HUMAN_INITIAL_PRICE = 100f;
//    public static final float HUMAN_BASE_LPS = 1f;
	
    public static final String PROPHET_ID = "prophet";
//    public static final float PROPHET_INITIAL_PRICE = 500f;
//    public static final float PROPHET_BASE_LPS = 4f;
	   
    public static final String TEMPLE_ID = "temple";
//    public static final float TEMPLE_INITIAL_PRICE = 3000f; // 3 K
//    public static final float TEMPLE_BASE_LPS = 10f;
   
    public static final String SHIP_ID = "ship";
//    public static final float SHIP_INITIAL_PRICE = 10000f; // 10 K
//    public static final float SHIP_BASE_LPS = 40f;
   
    public static final String FACTORY_ID = "factory";
//    public static final float FACTORY_INITIAL_PRICE = 40000f; // 40 K
//    public static final float FACTORY_BASE_LPS = 100f;
   
    public static final String LABORATORY_ID = "laboratory";
//    public static final float LABORATORY_INITIAL_PRICE = 200000f; // 200 K
//    public static final float LABORATORY_BASE_LPS = 400f;

    public static final String HIPPIEVAN_ID = "hippievan";
//    public static final float HIPPIEVAN_INITIAL_PRICE = 1700000f; // 1.7 M
//    public static final float HIPPIEVAN_BASE_LPS = 7000f; // 7K
   
    public static final String SHOP_ID = "shop";
//    public static final float SHOP_INITIAL_PRICE = 125000000f; // 125 M
//    public static final float SHOP_BASE_LPS = 100000f; // 100 K
   
    public static final String SPACESHIP_ID = "spaceship";
//    public static final float SPACESHIP_INITIAL_PRICE = 4000000000f; // 4 B
//    public static final float SPACESHIP_BASE_LPS = 1000000f; // 1 M
    
    public static void init() {
    	
    	
    	cost.put(Lang.SERVANT_NAME, 	15f);
    	cost.put(Lang.HUMAN_NAME, 		100f);
    	cost.put(Lang.PROPHET_NAME, 	500f);
    	cost.put(Lang.TEMPLE_NAME, 	3000f);
    	cost.put(Lang.SHIP_NAME, 		10000f);
    	cost.put(Lang.FACTORY_NAME, 	40000f);
    	cost.put(Lang.LABORATORY_NAME, 200000f);
    	cost.put(Lang.SHOP_NAME, 	1700000f);
    	cost.put(Lang.SPACESHIP_NAME, 		125000000f);
    	
    	lps.put(Lang.SERVANT_NAME, 	0.1f);
    	lps.put(Lang.HUMAN_NAME, 		1f);
    	lps.put(Lang.PROPHET_NAME, 	4f);
    	lps.put(Lang.TEMPLE_NAME, 		10f);
    	lps.put(Lang.SHIP_NAME, 		40f);
    	lps.put(Lang.FACTORY_NAME, 	100f);
    	lps.put(Lang.LABORATORY_NAME, 	400f);
    	lps.put(Lang.SHOP_NAME, 	7000f);
    	lps.put(Lang.SPACESHIP_NAME, 		100000f);
    }
    
    public static float getBaseCost(int id) {
    	if(cost.containsKey(id)) return cost.get(id);
    	return 0f;
    }
    
    public static float getLps(int id) {
    	if(lps.containsKey(id)) return lps.get(id);
    	return 0f;
    }
    
}
