package com.cardcamp.card;

import com.cardcamp.card.effect.CardEffect;
import com.cardcamp.card.effect.CardEffectGenerator;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.rounds.Round;

public class SocialCard extends Card{

	public SocialCard(Round round) {
		super(round);
	}

	@Override
	public Bitmap recto() {
		return Art.card_social;
	}

	@Override
	public CardEffect initEffect() {
		return CardEffectGenerator.generateSocial();
	}
	
	@Override
	protected Bitmap people() {
		return this.round.socialBitmaps()[this.rand.nextInt(this.round.socialBitmaps().length)];
	}

}
