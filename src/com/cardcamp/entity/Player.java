package com.cardcamp.entity;

import java.util.HashMap;
import java.util.Map.Entry;

import com.cardcamp.stats.ArmyStat;
import com.cardcamp.stats.MoneyStat;
import com.cardcamp.stats.SocialStat;
import com.cardcamp.stats.Stat;
import com.cardcamp.stats.TechnoStat;

public class Player {
	
	private HashMap<String, Stat> stats;
	
	public Player() {
		this.stats = new HashMap<String, Stat>();
		this.initStats();
	}
	
	private void initStats() {
		stats.put("money", new MoneyStat());
		stats.put("social", new SocialStat());
		stats.put("army", new ArmyStat());
		stats.put("techno", new TechnoStat());
		
		for(Entry<String, Stat> each : this.stats.entrySet()) {
			each.getValue().setPercent(50);
		}
		stats.get("techno").setPercent(0);
	}
	
	public void setStat(String key, float value) {
		this.stats.get(key).setPercent(value);
	}
	
	public void addStat(String key, Stat stat) {
		this.stats.put(key, stat);
	}
	
	public void addBonus(String key, float bonus) {
		this.stats.get(key).addBonus(bonus);
	}
	
	public void addPercent(String key, float percent) {
		this.stats.get(key).addPercent(percent);
	}
	
	public void removePercent(String key, float percent) {
		this.stats.get(key).removePercent(percent);
	}
	
	public HashMap<String, Stat> getStats() {
		return this.stats;
	}
	
	public Stat getStat(String key) {
		return this.stats.get(key);
	}
}
