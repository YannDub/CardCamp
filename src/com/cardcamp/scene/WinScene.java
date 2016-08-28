package com.cardcamp.scene;

import java.awt.event.KeyEvent;

import com.cardcamp.Game;
import com.cardcamp.gfx.Font;
import com.cardcamp.gfx.Screen;

public class WinScene extends Scene {

	public WinScene(Game game) {
		super(game);
	}

	@Override
	public void render(Screen screen) {
		screen.fill(0xff005555);
		
		Font.render("You win, press space to restart", screen.getWidth() / 2 - 9 * 30 / 2, screen.getHeight() / 2 - 4, screen, 0xffffffff);
	}

	@Override
	public void update() {
		if(Game.INPUT.isPressed(KeyEvent.VK_SPACE)) {
			this.game.setScene(new GameScene(this.game));
		}
	}

}
