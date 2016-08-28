package com.cardcamp.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Art {
	
	public static final Bitmap card_back = Art.load("/card/back_card.png");
	public static final Bitmap card_aggresive = Art.load("/card/aggressive_card.png");
	public static final Bitmap card_defensive = Art.load("/card/defensive_card.png");
	public static final Bitmap card_social = Art.load("/card/social_card.png");
	public static final Bitmap card_tuto = Art.load("/card/card_tuto.png");
	public static final Bitmap city = Art.load("/board/city.png");
	public static final Bitmap title = Art.load("/gui/title.png");
	
	public static final Bitmap[][] font = Art.cut("/gui/font.png", 8, 8);
	public static final Bitmap[][] stats = Art.cut("/gui/stats.png", 16, 16);
	public static final Bitmap[][] hud = Art.cut("/gui/window.png", 6, 6);
	public static final Bitmap[][] people = Art.cut("/card/people.png", 42, 42);
	public static final Bitmap[][] techno = Art.cut("/techno/techno.png", 42, 42);
			
	public static Bitmap load(String path) {
		try {
			BufferedImage image = ImageIO.read(Art.class.getResourceAsStream(path));
			
			int width = image.getWidth();
			int height = image.getHeight();
			Bitmap result = new Bitmap(width, height);
			image.getRGB(0, 0, width, height, result.pixels, 0, width);
			return result;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	public static Bitmap[][] cut(String path, int w, int h) {
		try {
			BufferedImage image = ImageIO.read(Art.class.getResourceAsStream(path));
			int width = image.getWidth();
			int height = image.getHeight();
			int xTile = width / w;
			int yTile = height / h;
			Bitmap[][] bitmaps = new Bitmap[xTile][yTile];
			
			for(int x = 0; x < xTile; x++) {
				for(int y = 0; y < yTile; y++) {
					Bitmap bitmap = new Bitmap(w, h);
					image.getRGB(x * w, y * h, w, h, bitmap.pixels, 0, w);
					bitmaps[x][y] = bitmap;
				}
			}
			
			return bitmaps;
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
