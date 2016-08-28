package com.cardcamp.card;

import com.cardcamp.card.effect.CardEffect;
import com.cardcamp.card.effect.CardEffectGenerator;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.rounds.Round;

public class PassiveCard extends Card {

	public PassiveCard(Round round) {
		super(round);
	}

	@Override
	public Bitmap recto() {
		return Art.card_defensive;
	}

	@Override
	public CardEffect initEffect() {
		return CardEffectGenerator.generatePassive();
	}
	
	@Override
	protected Bitmap people() {
		return this.round.passiveBitmaps()[this.rand.nextInt(this.round.passiveBitmaps().length)];
	}

}
