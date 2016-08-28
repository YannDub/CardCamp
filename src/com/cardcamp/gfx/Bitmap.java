package com.cardcamp.gfx;

import java.util.Arrays;

public class Bitmap {
	
	protected int[] pixels;
	protected int width, height;
	
	public Bitmap(int width, int height) {
		this.pixels = new int[width * height];
		this.width = width;
		this.height = height;
	}
	
	public void fill(int color) {
		Arrays.fill(this.pixels, color);
	}
	
	public void render(int x, int y, int w, int h, int color) {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				int posX = i + x;
				int posY = j + y;
				if(posX < 0) posX = 0;
				if(posY < 0) posY = 0;
				if(posY >= this.height) break;
				if(posX >= this.width) break;
				this.pixels[posX + posY * this.width] = this.blendPixel(this.pixels[posX + posY * this.width], color);
			}
		}
	}
	
	private int blendPixel(int backgroundColor, int pixelColor) {
		int alpha_blend = (pixelColor >> 24) & 0xff;
		int alpha_background = 256 - alpha_blend;
		
		int back_r = backgroundColor & 0xff0000;
		int back_g = backgroundColor & 0xff00;
		int back_b = backgroundColor & 0xff;
		
		int r = pixelColor & 0xff0000;
		int g = pixelColor & 0xff00;
		int b = pixelColor & 0xff;
		
		r = ((r * alpha_blend + back_r * alpha_background) >> 8) & 0xff0000;
		g = ((g * alpha_blend + back_g * alpha_background) >> 8) & 0xff00;
		b = ((b * alpha_blend + back_b * alpha_background) >> 8) & 0xff;
		
		return 0xff000000 | r | g | b;
	}
	
	public void renderBitmap(int x, int y, Bitmap bitmap) {
		int w = bitmap.width;
		int h = bitmap.height;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				int posX = i + x;
				int posY = j + y;
				if(posX < 0) break;
				if(posY < 0) continue;
				if(posX >= this.width) break;
				if(posY >= this.height) break;
				
				int col = bitmap.pixels[i + j * w];
				
				this.pixels[posX + posY * this.width] = this.blendPixel(this.pixels[posX + posY * this.width], col);
			}
		}
	}
	
	public void renderBitmap(int x, int y, Bitmap bitmap, int color) {
		int w = bitmap.width;
		int h = bitmap.height;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				int posX = i + x;
				int posY = j + y;
				if(posX < 0) break;
				if(posY < 0) continue;
				if(posX >= this.width) break;
				if(posY >= this.height) break;
				
				int col = bitmap.pixels[i + j * w];
				if(col == 0xffffffff) col = color;
				
				this.pixels[posX + posY * this.width] = this.blendPixel(this.pixels[posX + posY * this.width], col);
			}
		}
	}
	
	public int[] getPixels() {
		return this.pixels;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
}