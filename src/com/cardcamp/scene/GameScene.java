package com.cardcamp.scene;

import com.cardcamp.Game;
import com.cardcamp.entity.Player;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Screen;
import com.cardcamp.gui.GuiHUD;
import com.cardcamp.sound.Sound;
import com.cardcamp.world.Board;

public class GameScene extends Scene {

	private GuiHUD hud;
	private Board board;
	private Player player;
	
	public GameScene(Game game) {
		super(game);
		this.player = new Player();
		this.board = new Board(this.player);
		this.hud = new GuiHUD(this.player);
		Sound.music.loop();
	}

	@Override
	public void render(Screen screen) {
		screen.fill(0xff005555);
		
		screen.renderBitmap(screen.getWidth() / 2 - Art.title.getWidth() / 2, 26, Art.title);
		
		this.board.render(screen);
		this.hud.render(screen);
	}

	@Override
	public void update() {
		this.board.update();
		this.hud.update();
		
		if(this.board.isWin()) {
			this.game.setScene(new WinScene(this.game));
		}
		
		if(this.board.loose()) {
			this.game.setScene(new GameOverScene(this.game));
		}
	}

}
