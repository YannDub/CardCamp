package com.cardcamp.card.effect;

import com.cardcamp.rounds.Round;

public class HugeGoodEffect extends GoodEffect {

	public HugeGoodEffect(String stat) {
		super(stat);
		this.percent = 20 + this.random.nextInt(10);
	}
	
	public String[] getMessages(Round round) {
		String[] messages = super.getMessages(round);
		for(int i = 0; i < messages.length; i++) {
			messages[i] = "[Urgent] " + messages[i];
		}
		return messages;
	}

}
