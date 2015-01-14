package com.piropanda.projectx;

public class DesktopInterface implements GoogleInterface{
	 
    @Override
    public void login() {
        System.out.println("logging in...");
    }

    @Override
    public void logout() {
        System.out.println("logging out...");
    }

	@Override
	public boolean isConnected() {
		return false;
	}

	@Override
	public boolean isConnecting() {
		return false;
	}

	@Override
	public void load(boolean changeGameInfo) {
		System.out.println("loading...");
	}

	@Override
	public void save() {
		System.out.println("saving...");
	}

	@Override
	public void unlockAchievement(String achievement) {
	}

}