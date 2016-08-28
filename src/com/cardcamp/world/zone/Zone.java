package com.cardcamp.world.zone;

import java.awt.event.MouseEvent;

import com.cardcamp.Game;
import com.cardcamp.card.Card;
import com.cardcamp.gfx.Screen;
import com.cardcamp.maths.Vector2i;
import com.cardcamp.utils.BoundingBox;
import com.cardcamp.world.Board;

public abstract class Zone {
	
	protected Vector2i pos;
	protected BoundingBox box;
	protected Board board;
	protected int color;
	
	public Zone(Board board, Vector2i pos, int width, int height) {
		this.pos = pos;
		this.box = new BoundingBox(pos, width, height);
		this.board = board;
		this.initColor();
	}
	
	protected void initColor() {
		this.color = 0xffffffff;
	}
	
	public void render(Screen screen) {
		screen.render(this.pos.x, this.pos.y, this.box.getWidth(), this.box.getHeight(), color);
	}
	
	public void update(Card card) {		
		this.initColor();
		if(card != null && this.box.intersect(card.getBox())) {
			this.changeColor();
			if(!Game.INPUT.buttonPressed(MouseEvent.BUTTON1)) {
				this.updateZone(card);
				this.board.removeCard();
			}
		}
		this.box.update(pos);
	}
	
	protected abstract void changeColor();
	
	protected abstract void updateZone(Card card);
}
