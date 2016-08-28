package com.cardcamp.technos;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;

public class TechnoBronzeAxe extends Techno {

	@Override
	protected Bitmap recto() {
		return Art.card_aggresive;
	}

	@Override
	protected Bitmap icon() {
		return Art.techno[2][0];
	}

	@Override
	public String getType() {
		return "army";
	}

	@Override
	public float getBonus() {
		return 1;
	}

	@Override
	public String getMessage() {
		return "Bronze Axe";
	}

}
