package com.piropanda.projectx;

public interface GoogleInterface {
	 
    public void login();
    public void logout();
	boolean isConnected();
	boolean isConnecting();
	void load(boolean changeGameInfo);
	void save();
	void unlockAchievement(String achievement);
   
   
}