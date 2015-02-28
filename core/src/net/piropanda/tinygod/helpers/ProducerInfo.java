package net.piropanda.tinygod.helpers;

import java.util.HashMap;

public class ProducerInfo {

	private static HashMap<String, Float> cost = new HashMap<String, Float>();
	private static HashMap<String, Float> lps = new HashMap<String, Float>();
	
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
    	cost.put(SERVANT_ID, 	15f);
    	cost.put(HUMAN_ID, 		100f);
    	cost.put(PROPHET_ID, 	500f);
    	cost.put(TEMPLE_ID, 	3000f);
    	cost.put(SHIP_ID, 		10000f);
    	cost.put(FACTORY_ID, 	40000f);
    	cost.put(LABORATORY_ID, 200000f);
    	cost.put(HIPPIEVAN_ID, 	1700000f);
    	cost.put(SHOP_ID, 		125000000f);
    	cost.put(SPACESHIP_ID, 	4000000000f);
    	
    	lps.put(SERVANT_ID, 	0.1f);
    	lps.put(HUMAN_ID, 		1f);
    	lps.put(PROPHET_ID, 	4f);
    	lps.put(TEMPLE_ID, 		10f);
    	lps.put(SHIP_ID, 		40f);
    	lps.put(FACTORY_ID, 	100f);
    	lps.put(LABORATORY_ID, 	400f);
    	lps.put(HIPPIEVAN_ID, 	7000f);
    	lps.put(SHOP_ID, 		100000f);
    	lps.put(SPACESHIP_ID, 	1000000f);
    }
    
    public static float getBaseCost(String id) {
    	if(cost.containsKey(id)) return cost.get(id);
    	return 0f;
    }
    
    public static float getLps(String id) {
    	if(lps.containsKey(id)) return lps.get(id);
    	return 0f;
    }
    
}
