package com.cardcamp.card;

import com.cardcamp.card.effect.CardEffect;
import com.cardcamp.card.effect.NoEffect;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.rounds.Round;

public class TutoCard extends Card {

	public TutoCard(Round round) {
		super(round);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public CardEffect initEffect() {
		return new NoEffect();
	}

	@Override
	public Bitmap recto() {
		return Art.card_tuto;
	}

	@Override
	protected Bitmap people() {
		return Art.people[3][0];
	}

}
