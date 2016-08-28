package com.cardcamp.utils;

import com.cardcamp.maths.Vector2f;
import com.cardcamp.maths.Vector2i;

public class BoundingBox {
	
	protected int x, y, width, height;
	
	public BoundingBox(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public BoundingBox(Vector2i v, int width, int height) {
		this(v.x, v.y, width, height);
	}
	
	public BoundingBox(Vector2f v, int width, int height) {
		this((int)v.x, (int)v.y, width, height);
	}
	
	public boolean contains(int posX, int posY) {
		return posX >= this.x && posX <= this.x + width && posY >= this.y && posY <= this.y + height;
	}
	
	public boolean intersect(BoundingBox box) {
		return this.contains(box.x, box.y) || this.contains(box.x + width, box.y) || this.contains(box.x + width, box.y + height) ||
				this.contains(box.x, box.y + height);
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(Vector2i v) {
		this.update(v.x, v.y);
	}
	
	public void update(Vector2f v) {
		this.update((int)v.x, (int)v.y);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
