package com.cardcamp.gui;

import com.cardcamp.gfx.Screen;

public abstract class Gui {
	
	protected int width, height, x, y;
	
	public abstract void render(Screen screen);
	
	public abstract void update();
}
