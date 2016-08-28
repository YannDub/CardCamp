package com.cardcamp.card.effect;

import java.util.Random;

public class CardEffectGenerator {
	
	private static Random random = new Random();
	
	private static String randomKeyStat() {
		if(random.nextFloat() <= 0.33f) return "social";
		if(random.nextFloat() <= 0.66f) return "money";
		return "army";
	}
	
	private static CardEffect generate(String key) {
		if(random.nextFloat() <= 0.05f) return new HugeCompromiseEffect(key, randomKeyStat());
		if(random.nextFloat() <= 0.1f) return new HugeGoodEffect(key);
		if(random.nextFloat() <= 0.2f) return new CompromiseEffect(key, randomKeyStat());
		return new GoodEffect(key);
	}
	
	public static CardEffect generateOffenssive() {
		return generate("army");
	}
	
	public static CardEffect generatePassive() {
		return generate("money");
	}
	
	public static CardEffect generateSocial() {
		return generate("social");
	}
}
