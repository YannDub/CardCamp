package com.cardcamp.rounds;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.technos.Techno;
import com.cardcamp.world.Board;

public class RoundStoneAge extends Round {

	public RoundStoneAge(Board board) {
		super(board);
	}

	@Override
	public Bitmap[] aggressiveBitmaps() {
		return new Bitmap[] {
				Art.people[1][0]
		};
	}

	@Override
	public Bitmap[] passiveBitmaps() {
		return new Bitmap[] {
				Art.people[0][0]
		};
	}

	@Override
	public Bitmap[] socialBitmaps() {
		return new Bitmap[] {
				Art.people[2][0]
		};
	}

	@Override
	public String[] aggressiveMessages() {
		return new String[] {
				"CROM!", "FIGHT!", "EAT!", "Cudgel?"
		};
	}

	@Override
	public String[] passiveMessages() {
		return new String[] {
				"Sell", "Buy", "House?", "Food?"
		};
	}

	@Override
	public String[] socialMessages() {
		return new String[] {
				"Love", "Friend!", "Justice!", "Stone", "Heart"
		};
	}

	@Override
	protected Round nextRound() {
		if(this.board.getPlayer().getStat("techno").getPercent() == 100) return new RoundBronzeAge(this.board);
		return new RoundStoneAge(this.board);
	}

	@Override
	public Techno[] getTechno() {
		return new Techno[] {
				Techno.wheel, Techno.writing, Techno.bronzeAxe
		};
	}

}
