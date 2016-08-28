package com.cardcamp.world;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.cardcamp.Game;
import com.cardcamp.card.Card;
import com.cardcamp.card.Deck;
import com.cardcamp.card.TutoCard;
import com.cardcamp.entity.Player;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Font;
import com.cardcamp.gfx.Screen;
import com.cardcamp.maths.Vector2i;
import com.cardcamp.rounds.Round;
import com.cardcamp.rounds.RoundTuto;
import com.cardcamp.stats.Stat;
import com.cardcamp.world.zone.NegativeZone;
import com.cardcamp.world.zone.PositiveZone;
import com.cardcamp.world.zone.Zone;

public class Board {
	
	private Deck deck;
	private Round round;
	private Player player;
	private Zone positiveZone, negativeZone;
	private Card card;
	private boolean win;
	
	public Board(Player player) {
		this.player = player;
		this.round = new RoundTuto(this);
		this.deck = new Deck(this, this.tutoDeck());
		this.positiveZone = new PositiveZone(this, new Vector2i(0,0), 64, Game.getScreen().getHeight());
		this.negativeZone = new NegativeZone(this, new Vector2i(Game.getScreen().getWidth() - 64, 0), 64, Game.getScreen().getHeight());
	}
	
	private List<Card> tutoDeck() {
		List<Card> cards = new ArrayList<Card>();
		
		TutoCard card1 = new TutoCard(this.round);
		card1.setMessage("Welcome to CardCamp, I will teach you");
		
		TutoCard card2 = new TutoCard(this.round);
		card2.setMessage("Each card has an effect on your stats");
		
		TutoCard card3 = new TutoCard(this.round);
		card3.setMessage("Green zone, equals positive things");
		
		TutoCard card4 = new TutoCard(this.round);
		card4.setMessage("Red zone, negative things but more techno");
		
		TutoCard card5 = new TutoCard(this.round);
		card5.setMessage("Sometime you need to make a compromise");
		
		TutoCard card6 = new TutoCard(this.round);
		card6.setMessage("Your goal is to survive until the Middle Age");
		
		TutoCard card7 = new TutoCard(this.round);
		card7.setMessage("Before each age, choose a techno, it get a bonus");
		
		TutoCard card8 = new TutoCard(this.round);
		card8.setMessage("Follow me on twitter @S0orax");
		
		TutoCard card9 = new TutoCard(this.round);
		card9.setMessage("Enjoy and good luck!");
		
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
		cards.add(card6);
		cards.add(card7);
		cards.add(card8);
		cards.add(card9);
		
		return cards;
	}
	
	public void generateDeck(int nbCards) {
		this.deck = new Deck(this, nbCards);
	}
	
	public void render(Screen screen) {
		screen.renderBitmap(screen.getWidth() / 2 - Art.city.getWidth() / 2, screen.getHeight() / 2 - Art.city.getHeight() / 2, Art.city);
		this.positiveZone.render(screen);
		this.negativeZone.render(screen);
		this.deck.render(screen);
		if(this.card != null) {
			this.card.render(screen);
			if(this.card.isRecto()) {
				int posX = screen.getWidth() / 2 - this.card.getMessage().length() * 8 / 2;
				int posY = screen.getHeight() / 2 + this.card.getBox().getHeight() / 2;
				screen.render(posX - 4, posY, this.card.getMessage().length() * 9 + 4, 16, 0x55000000);
				Font.render(this.card.getMessage(), posX - 1, posY + 4, screen, 0xffffffff);
			}
		}
		
		if(this.isRoundFinished() && this.player.getStat("techno").getPercent() == 100) {
			for(int i = 0; i < this.round.getTechno().length; i++) {
				this.round.getTechno()[i].setPosition(screen.getWidth() / 2 + (i - 1) * (Art.card_back.getWidth() + 8) - Art.card_back.getWidth() / 2, screen.getHeight() / 2 - Art.card_back.getHeight() / 2);
				this.round.getTechno()[i].render(screen);
			}
		}
	}
	
	public void update() {
		if(this.card != null) this.card.update();
		this.deck.update();
		this.positiveZone.update(this.card);
		this.negativeZone.update(this.card);
		
		if(this.isRoundFinished()) {
			if(this.player.getStat("techno").getPercent() == 100) {
				for(int i = 0; i < this.round.getTechno().length; i++) {
					if(Game.INPUT.buttonPressed(MouseEvent.BUTTON1) && this.round.getTechno()[i].getBox().contains(Game.INPUT.getMouseX() / 2, Game.INPUT.getMouseY() / 2)) {
						this.player.addBonus(this.round.getTechno()[i].getType(), this.round.getTechno()[i].getBonus());
						this.round.launchNextRound();
						this.player.setStat("techno", 0);
					}
				}
			} else {
				if(this.loose()) return;
				this.round.launchNextRound();
			}
		}
	}
	
	public void win() {
		this.win = true;
	}
	
	public boolean loose() {
		if(this.isRoundFinished()) {
			for(Entry<String, Stat> each : this.getPlayer().getStats().entrySet()) {
				if(each.getKey() != "techno" && each.getValue().getPercent() == 0) {
					return true;
				}
			}			
		}
		return false;
	}
	
	public boolean isRoundFinished() {
		return this.deck.isEmpty() && this.card == null;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	public Card getCard(Card card) {
		return this.card;
	}
	
	public void removeCard() {
		this.card = null;
		this.deck.desactive();
	}
	
	public boolean hasCard() {
		return this.card != null;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Round getRound() {
		return this.round;
	}
	
	public void setRound(Round round) {
		this.round = round;
	}
	
	public boolean isWin() {
		return this.win;
	}
}
