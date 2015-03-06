package net.piropanda.tinygod.screens;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public abstract class Screen extends Group {

	public static int SCROLL_WIDTH = 372;
	public static int SCROLL_HEIGHT = 510;
	
	public Image bgTab;
	public Image bgTab2;
	protected Table table;
	protected ScrollPane scroll;
	protected ScreenTab currentScreenTab;
	
	
	public Screen() {
		// tab background (sub-screen)
		bgTab = new Image(TG.Graphics.assets.get("pixel.png", Texture.class));
		bgTab.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		bgTab.setColor(100f/255f, 130f/255f, 210f/255f, 1f);
		bgTab.setBounds(0, 0, TG.Display.WIDTH, TG.Display.HEIGHT);
		bgTab.setTouchable(Touchable.disabled);
		this.addActor(bgTab);
		
		bgTab2 = new Image(TG.Graphics.assets.get("pixel.png", Texture.class));
		//bgTab2.setScale(TG.Display.WIDTH, TG.Display.HEIGHT);
		//bgTab2.setColor(100f/255f, 1f, 1f, 1f);
		bgTab2.setBounds(0, 0, TG.Display.WIDTH, TG.Display.HEIGHT);
		bgTab2.setTouchable(Touchable.disabled);
		bgTab2.setVisible(false);
		this.addActor(bgTab2);
		
		
		// initialize table and scroll pane
		table = new Table();
		table.align(Align.top);
		table.padTop(50);
		table.padBottom(50);
		
		scroll = new ScrollPane(table);
		scroll.setBounds(30, 30, SCROLL_WIDTH, SCROLL_HEIGHT);
		scroll.setScrollingDisabled(true, false);
		this.addActor(scroll);
		
		this.setWidth(TG.Display.WIDTH);
		this.setHeight(TG.Display.HEIGHT);
	}
	
	public boolean canPan() {
		return true;
	}
	
	public void open(ScreenTab tab) {
		scroll.setVisible(false);
		currentScreenTab = tab;
		this.addActor(currentScreenTab);
	}
	
	public void close() {
		this.removeActor(currentScreenTab);
		scroll.setVisible(true);
	}

	public boolean tap(float x, float y, int count, int button) {
		return false;
	}
	
	public void pan(float x, float y, float deltaX, float deltaY) {
	}

	public ScrollPane getScrollPane() {
		return scroll;
	}
	
}
