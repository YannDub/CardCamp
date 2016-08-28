package com.cardcamp.maths;

public class Vector2i {
	
	public int x, y;
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2i add(Vector2i v) {
		return new Vector2i(this.x + v.x, this.y + v.y);
	}
	
	public Vector2i mul(int scalar) {
		return new Vector2i(scalar * x, scalar * y);
	}
	
	public float dot(Vector2i v) {
		return this.x * v.x + this.y * v.y;
	}
	
	public void interpolate(Vector2i target, float time) {
		this.x += (target.x - this.x) * time;
		this.y += (target.y - this.y) * time;
	}
}
