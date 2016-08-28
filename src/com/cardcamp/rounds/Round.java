package com.cardcamp.rounds;

import com.cardcamp.gfx.Bitmap;
import com.cardcamp.technos.Techno;
import com.cardcamp.world.Board;

public abstract class Round {
	
	protected Board board;
	
	public Round(Board board) {
		this.board = board;
	}
	
	public void launchNextRound() {
		Round nextRound = this.nextRound();
		this.board.setRound(nextRound);
		this.board.generateDeck(10);
	}
	
	protected abstract Round nextRound();
	
	public abstract Bitmap[] aggressiveBitmaps();
	
	public abstract Bitmap[] passiveBitmaps();
	
	public abstract Bitmap[] socialBitmaps();
	
	public abstract String[] aggressiveMessages();
	
	public abstract String[] passiveMessages();
	
	public abstract String[] socialMessages();
	
	public abstract Techno[] getTechno();
}
