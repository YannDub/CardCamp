package com.cardcamp.card.effect;

import com.cardcamp.entity.Player;
import com.cardcamp.rounds.Round;

public class CompromiseEffect extends CardEffect {
	
	protected String stat1, stat2;
	
	public CompromiseEffect(String stat1, String stat2) {
		super();
		this.stat1 = stat1;
		this.stat2 = stat2;
	}
	
	@Override
	public void applyPositive(Player player) {
		player.addPercent(this.stat1, percent);
		player.removePercent(this.stat2, percent);
	}

	@Override
	public void applyNegative(Player player) {
		player.addPercent(this.stat2, percent);
		player.removePercent(this.stat1, percent);
		player.addPercent("techno", percent / 2);
	}

	@Override
	public String[] getMessages(Round round) {
		String[] messages1 = this.messageByType(round, stat1);
		String[] messages2 = this.messageByType(round, stat2);
		
		String[] results = new String[messages1.length * messages2.length];
		
		for(int i = 0; i < messages2.length; i++) {
			for(int j = 0; j < messages1.length; j++) {
				results[j + i * messages1.length] = messages1[j] + " or " + messages2[i];
			}
		}
		return results;
	}

}
