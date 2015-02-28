package net.piropanda.tinygod.screens;

import net.piropanda.tinygod.TG;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class ScreenTab extends Group {
	
	protected Table table, content;
	protected ScrollPane scroll;
	
	
	public ScreenTab(final Screen screen) {
		this.setBounds(30, 30, Screen.SCROLL_WIDTH, Screen.SCROLL_HEIGHT);
		
		// main table
		table = new Table();
		table.setFillParent(false);
		table.padTop(50);
		table.padBottom(50);
		table.top();
		
		// table to be used by it's children
		content = new Table(TG.Graphics.skin);
		content.padBottom(25);
		table.add(content);
		
		// new row
		table.row();
		
		// back button
		TextButton backButton = new TextButton("back", TG.Graphics.skin);
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				screen.close();
			}
		});
		table.add(backButton).padTop(10);
		
		// scroll pane where the main table is going to go
		scroll = new ScrollPane(table);
		scroll.setFillParent(true);
		scroll.setScrollingDisabled(true, false);
		
		this.addActor(scroll);
	}

}
