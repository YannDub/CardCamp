package com.cardcamp.technos;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;

public class TechnoWriting extends Techno{

	@Override
	protected Bitmap recto() {
		return Art.card_social;
	}

	@Override
	protected Bitmap icon() {
		return Art.techno[1][0];
	}

	@Override
	public String getType() {
		return "social";
	}

	@Override
	public float getBonus() {
		return 1;
	}

	@Override
	public String getMessage() {
		return "Writing";
	}

}
