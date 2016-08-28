package com.cardcamp.world.zone;

import com.cardcamp.card.Card;
import com.cardcamp.maths.Vector2i;
import com.cardcamp.world.Board;

public class PositiveZone extends Zone {

	public PositiveZone(Board board, Vector2i pos, int width, int height) {
		super(board, pos, width, height);
	}
	
	protected void initColor() {
		this.color = 0x5500ff00;		
	}

	@Override
	protected void updateZone(Card card) {
		card.getEffect().applyPositive(this.board.getPlayer());
	}

	@Override
	protected void changeColor() {
		this.color = 0xff00ff00;
	}

}
