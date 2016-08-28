package com.cardcamp.rounds;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.technos.Techno;
import com.cardcamp.world.Board;

public class RoundBronzeAge extends Round {

	public RoundBronzeAge(Board board) {
		super(board);
	}

	@Override
	protected Round nextRound() {
		if(this.board.getPlayer().getStat("techno").getPercent() == 100) return new RoundMiddleAge(this.board);
		return new RoundBronzeAge(this.board);
	}

	@Override
	public Bitmap[] aggressiveBitmaps() {
		return new Bitmap[] {
			Art.people[1][1]
		};
	}

	@Override
	public Bitmap[] passiveBitmaps() {
		return new Bitmap[] {
				Art.people[2][1]
			};
	}

	@Override
	public Bitmap[] socialBitmaps() {
		return new Bitmap[] {
				Art.people[0][1]
			};
	}

	@Override
	public String[] aggressiveMessages() {
		return new String[] {
				"Kill the Romans!", "Vikings!", "Hunt?", "Conquest", "Barbarous!"
		};
	}

	@Override
	public String[] passiveMessages() {
		return new String[] {
				"Find a treasure", "Economy", "More work", "Steal ennemy"
		};
	}

	@Override
	public String[] socialMessages() {
		return new String[] {
				"Talk to people", "More security", "Build house", "Make peace"
		};
	}

	@Override
	public Techno[] getTechno() {
		return new Techno[] {
				Techno.barrel, Techno.pants, Techno.sword
		};
	}

}
