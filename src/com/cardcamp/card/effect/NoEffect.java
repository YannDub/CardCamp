package com.cardcamp.card.effect;

import com.cardcamp.entity.Player;
import com.cardcamp.rounds.Round;

public class NoEffect extends CardEffect {

	@Override
	public void applyPositive(Player player) {
		
	}

	@Override
	public void applyNegative(Player player) {
		
	}

	@Override
	public String[] getMessages(Round round) {
		return new String[] {
				""
		};
	}

}
