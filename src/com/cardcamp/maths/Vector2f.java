package com.cardcamp.maths;

public class Vector2f {

	public float x, y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f add(Vector2f v) {
		return new Vector2f(this.x + v.x, this.y + v.y);
	}
	
	public Vector2f mul(float scalar) {
		return new Vector2f(scalar * x, scalar * y);
	}
	
	public float dot(Vector2i v) {
		return this.x * v.x + this.y * v.y;
	}
	
	public void interpolate(Vector2f target, float time) {
		this.x += (target.x - this.x) * time;
		this.y += (target.y - this.y) * time;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vector2f) {
			Vector2f v = (Vector2f) obj;
			return Math.round(this.x) == v.x && Math.round(this.y) == v.y;
		}
		return false;
	}
	
}
