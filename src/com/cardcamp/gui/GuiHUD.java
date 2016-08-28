package com.cardcamp.gui;

import com.cardcamp.Game;
import com.cardcamp.entity.Player;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Screen;
import com.cardcamp.stats.Stat;

public class GuiHUD extends Gui{
	
	private Player player;
	
	public GuiHUD(Player player) {
		this.x = 0;
		this.y = 0;
		this.width = Game.getScreen().getWidth();
		this.height = 18;
		this.player = player;
	}

	@Override
	public void render(Screen screen) {
		int wSize = this.width / Art.hud[0][0].getWidth();
		int hSize = this.height / Art.hud[0][0].getHeight();
		
		for(int j = 0; j < hSize; j++) {
			screen.renderBitmap(0, j * Art.hud[0][0].getHeight(), Art.hud[0][j]);
			for(int i = 1; i < wSize - 1; i++) {
				screen.renderBitmap(i * Art.hud[0][0].getWidth(), j * Art.hud[0][0].getHeight(), Art.hud[1][j]);
			}
			screen.renderBitmap((wSize - 1) * Art.hud[0][0].getWidth(), j * Art.hud[0][0].getHeight(), Art.hud[2][j]);
		}
		
		int i = 0;
		for(Stat stat : this.player.getStats().values()) {
			stat.render(screen.getWidth() / 2 - i * 32 * 2 + 64, 6, screen);
			i++;
		}
	}

	@Override
	public void update() {
		
	}
}
