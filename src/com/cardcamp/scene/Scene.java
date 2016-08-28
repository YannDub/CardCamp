package com.cardcamp.scene;

import com.cardcamp.Game;
import com.cardcamp.gfx.Screen;

public abstract class Scene {
	
	protected Game game;
	
	public Scene(Game game) {
		this.game = game;
	}
	
	public abstract void render(Screen screen);
	
	public abstract void update();
}
