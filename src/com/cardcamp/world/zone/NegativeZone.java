package com.cardcamp.world.zone;

import com.cardcamp.card.Card;
import com.cardcamp.maths.Vector2i;
import com.cardcamp.world.Board;

public class NegativeZone extends Zone {

	public NegativeZone(Board board, Vector2i pos, int width, int height) {
		super(board, pos, width, height);
	}
	
	protected void initColor() {
		this.color = 0x55ff0000;
	}

	@Override
	protected void updateZone(Card card) {
		card.getEffect().applyNegative(this.board.getPlayer());
	}

	@Override
	protected void changeColor() {
		this.color = 0xffff0000;
	}

}
