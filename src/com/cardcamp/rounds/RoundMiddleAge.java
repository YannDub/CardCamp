package com.cardcamp.rounds;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.technos.Techno;
import com.cardcamp.world.Board;

public class RoundMiddleAge extends Round {

	public RoundMiddleAge(Board board) {
		super(board);
	}

	@Override
	protected Round nextRound() {
		if(this.board.getPlayer().getStat("techno").getPercent() == 100) {
			this.board.win();
			return new RoundMiddleAge(this.board);
		}
		return new RoundMiddleAge(this.board);
	}

	@Override
	public Bitmap[] aggressiveBitmaps() {
		return new Bitmap[] {
				Art.people[1][2]
		};
	}

	@Override
	public Bitmap[] passiveBitmaps() {
		return new Bitmap[] {
				Art.people[0][2]
		};
	}

	@Override
	public Bitmap[] socialBitmaps() {
		return new Bitmap[] {
				Art.people[2][2]
		};
	}

	@Override
	public String[] aggressiveMessages() {
		return new String[] {
				"Never Surrender!", "Destroy cities", "Burn witches", "Kill war chief", "Red Wedding", "Purpil Wedding"
		};
	}

	@Override
	public String[] passiveMessages() {
		return new String[] {
				"Build church", "More tax", "Make a party", "Good Wedding"
		};
	}

	@Override
	public String[] socialMessages() {
		return new String[] {
				"Talk to a princess", "Build librairy", "Build castle", "People receive"
		};
	}

	@Override
	public Techno[] getTechno() {
		return new Techno[] {
				Techno.barrow, Techno.binoculars, Techno.helmet
		};
	}

}
