package com.cardcamp.technos;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;

public class TechnoSword extends Techno {

	@Override
	protected Bitmap recto() {
		return Art.card_aggresive;
	}

	@Override
	protected Bitmap icon() {
		return Art.techno[2][1];
	}

	@Override
	public String getType() {
		return "army";
	}

	@Override
	public float getBonus() {
		return 2;
	}

	@Override
	public String getMessage() {
		return "Sword";
	}

}
