package com.cardcamp.rounds;

import com.cardcamp.gfx.Bitmap;
import com.cardcamp.technos.Techno;
import com.cardcamp.world.Board;

public class RoundTuto extends Round {

	public RoundTuto(Board board) {
		super(board);
	}

	@Override
	protected Round nextRound() {
		return new RoundStoneAge(this.board);
	}

	@Override
	public Bitmap[] aggressiveBitmaps() {
		return null;
	}

	@Override
	public Bitmap[] passiveBitmaps() {
		return null;
	}

	@Override
	public Bitmap[] socialBitmaps() {
		return null;
	}

	@Override
	public String[] aggressiveMessages() {
		return null;
	}

	@Override
	public String[] passiveMessages() {
		return null;
	}

	@Override
	public String[] socialMessages() {
		return null;
	}

	@Override
	public Techno[] getTechno() {
		return null;
	}

}
