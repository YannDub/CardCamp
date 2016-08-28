package com.cardcamp.stats;

import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;

public class MoneyStat extends Stat {

	@Override
	public Bitmap bitmap() {
		return Art.stats[0][0];
	}

}
