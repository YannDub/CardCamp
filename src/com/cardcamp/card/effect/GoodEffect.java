package com.cardcamp.card.effect;

import com.cardcamp.entity.Player;
import com.cardcamp.rounds.Round;

public class GoodEffect extends CardEffect {
	
	private String stat;
	
	public GoodEffect(String stat) {
		super();
		this.stat = stat;
	}
	
	@Override
	public void applyPositive(Player player) {
		player.addPercent(stat, percent);
	}

	@Override
	public void applyNegative(Player player) {
		player.removePercent(stat, percent);
		player.addPercent("techno", percent / 2);
	}

	@Override
	public String[] getMessages(Round round) {
		return this.messageByType(round, this.stat);
	}

}
