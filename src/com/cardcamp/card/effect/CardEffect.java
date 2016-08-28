package com.cardcamp.card.effect;

import java.util.Random;

import com.cardcamp.entity.Player;
import com.cardcamp.rounds.Round;

public abstract class CardEffect {
	
	protected Random random;
	protected float percent;
	
	public CardEffect() {
		this.random = new Random();
		this.percent = 1 + random.nextInt(5);
	}
	
	protected String[] messageByType(Round round, String type) {
		if(type == "army") return round.aggressiveMessages();
		if(type == "social") return round.socialMessages();
		return round.passiveMessages();
	}
	
	public abstract void applyPositive(Player player);
	
	public abstract void applyNegative(Player player);
	
	public abstract String[] getMessages(Round round);
}
