package com.cardcamp.technos;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.gfx.Font;
import com.cardcamp.gfx.Screen;
import com.cardcamp.utils.BoundingBox;

public abstract class Techno {
	
	public static final Techno wheel = new TechnoWheel();
	public static final Techno writing = new TechnoWriting();
	public static final Techno bronzeAxe = new TechnoBronzeAxe();
	public static final Techno barrel = new TechnoBarrel();
	public static final Techno pants = new TechnoPants();
	public static final Techno sword = new TechnoSword();
	public static final Techno barrow = new TechnoBarrow();
	public static final Techno binoculars = new TechnoBinoculars();
	public static final Techno helmet = new TechnoHelmet();
	
	protected BoundingBox box;
	protected int x, y;
	
	public Techno() {
		this.x = 0;
		this.y = 0;
		this.box = new BoundingBox(x, y, Art.card_back.getWidth(), Art.card_back.getHeight());
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		this.box.update(x, y);
	}
	
	public void render(Screen screen) {
		screen.renderBitmap(x, y, this.recto());
		screen.renderBitmap(x + Art.card_back.getWidth() / 2 - Art.techno[0][0].getWidth() / 2 - 1, y + 16, this.icon());
		screen.render(this.x - 4, y + this.getBox().getHeight() + 16 - 4, this.getMessage().length() * 9 + 4, 18, 0x55000000);
		Font.render(this.getMessage(), this.x, y + this.getBox().getHeight() + 16, screen, 0xffffffff);
	}
	
	public BoundingBox getBox() {
		return this.box;
	}
	
	protected abstract Bitmap recto();
	
	protected abstract Bitmap icon();
	
	public abstract String getType();
	
	public abstract float getBonus();
	
	public abstract String getMessage();
}
