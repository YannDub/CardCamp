package com.cardcamp.stats;

import com.cardcamp.gfx.Bitmap;
import com.cardcamp.gfx.Font;
import com.cardcamp.gfx.Screen;

public abstract class Stat {
	
	private float percent;
	private float bonus;
	
	public Stat() {
		this.bonus = 0;
	}
	
	public void setPercent(float percent) {
		this.percent = percent;
	}
	
	public float getPercent() {
		return this.percent;
	}
	
	public void addBonus(float bonus) {
		this.bonus += bonus;
	}
	
	public void addPercent(float percent) {
		this.percent += percent + this.bonus;
		if(this.percent >= 100) this.percent = 100;
	}
	
	public void removePercent(float percent) {
		this.percent -= percent;
		if(this.percent <= 0) this.percent = 0;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderBitmap(x, y - 4, this.bitmap());
		Font.render(percent + "%", x + 17, y, screen, 0xffffffff);
	}
	
	public abstract Bitmap bitmap();
}
