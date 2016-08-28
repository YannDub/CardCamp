package com.cardcamp.gfx;

public class Font {
	
	public static final String font = "ABCDEFGHIJKLMNOPQRSTUVWXYZ " + 
									  "1234567890@,.!?%[]";
	
	public static void render(String message, int x, int y, Screen screen, int color) {
		String msg = message.toUpperCase();
		for(int i = 0; i < msg.length(); i++) {
			int ix = font.indexOf(msg.charAt(i));
			if(ix >= 0)
				screen.renderBitmap(x + i * 9, y, Art.font[ix % 27][ix / 27], color);
		}
	}
}
