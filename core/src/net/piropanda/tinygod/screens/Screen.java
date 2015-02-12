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

	protected Image bgScreen, bgTab;
	protected Table table;
	protected ScrollPane scroll;
	
	public boolean canPan = true;
	
	
	public Screen() {
		// tab background (sub-screen)
		bgTab = new Image(TG.Graphics.assets.get("tab-bg.png", Texture.class));
		bgTab.setBounds(0, 0, TG.Display.WIDTH, TG.Display.HEIGHT);
		bgTab.setTouchable(Touchable.disabled);
		this.addActor(bgTab);
		
		// initialize table and scroll pane
		table = new Table();
		table.align(Align.top);
		table.padTop(50);
		table.padBottom(50);
		
		scroll = new ScrollPane(table);
		scroll.setBounds(30, 30, 420, 510);
		scroll.setScrollingDisabled(true, false);
		this.addActor(scroll);
	}
	
	public void open(ScreenTab tab) {
		close();
		scroll.setVisible(false);
	}
	
	public void close() {
		scroll.setVisible(true);
	}

	public void pan(float x, float y, float deltaX, float deltaY) {
	}
	
}
