package com.cardcamp.card.effect;

import com.cardcamp.rounds.Round;

public class HugeCompromiseEffect extends CompromiseEffect {

	public HugeCompromiseEffect(String stat1, String stat2) {
		super(stat1, stat2);
		this.percent = 10 + random.nextInt(10);
	}
	
	public String[] getMessages(Round round) {
		String[] messages = super.getMessages(round);
		for(int i = 0; i < messages.length; i++) {
			messages[i] = "[Urgent] " + messages[i];
		}
		return messages;
	}
}
