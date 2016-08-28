package com.cardcamp.technos;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;

public class TechnoHelmet extends Techno {

	@Override
	protected Bitmap recto() {
		return Art.card_aggresive;
	}

	@Override
	protected Bitmap icon() {
		return Art.techno[2][2];
	}

	@Override
	public String getType() {
		return "army";
	}

	@Override
	public float getBonus() {
		return 3;
	}

	@Override
	public String getMessage() {
		return "Helmet";
	}

}
