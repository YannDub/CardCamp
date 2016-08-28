package com.cardcamp.technos;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;

public class TechnoBarrow extends Techno {

	@Override
	protected Bitmap recto() {
		return Art.card_defensive;
	}

	@Override
	protected Bitmap icon() {
		return Art.techno[0][2];
	}

	@Override
	public String getType() {
		return "money";
	}

	@Override
	public float getBonus() {
		return 3;
	}

	@Override
	public String getMessage() {
		return "Barrow";
	}

}
