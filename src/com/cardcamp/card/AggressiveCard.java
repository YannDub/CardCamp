package com.cardcamp.card;

import com.cardcamp.card.effect.CardEffect;
import com.cardcamp.card.effect.CardEffectGenerator;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.rounds.Round;

public class AggressiveCard extends Card {

	public AggressiveCard(Round round) {
		super(round);
	}

	@Override
	public Bitmap recto() {
		return Art.card_aggresive;
	}

	@Override
	public CardEffect initEffect() {
		return CardEffectGenerator.generateOffenssive();
	}

	@Override
	protected Bitmap people() {
		return this.round.aggressiveBitmaps()[this.rand.nextInt(this.round.aggressiveBitmaps().length)];
	}

}
