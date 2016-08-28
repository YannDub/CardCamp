package com.cardcamp.card;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cardcamp.Game;
import com.cardcamp.gfx.Screen;
import com.cardcamp.maths.Vector2f;
import com.cardcamp.maths.Vector2i;
import com.cardcamp.utils.BoundingBox;
import com.cardcamp.world.Board;

public class Deck {
	
	private List<Card> cards;
	private Random rand;
	private Vector2i pos;
	private BoundingBox box;
	private boolean active;
	private int nbCards;
	private Card selectedCard;
	private Vector2f middle;
	private Board board;
	
	public Deck(Board board, int nbCards) {
		this.board = board;
		this.cards = new ArrayList<Card>();
		this.rand = new Random();
		int x = Card.WIDTH;
		int y = Game.getScreen().getHeight() - Card.HEIGHT - 5;
		
		this.pos = new Vector2i(x, y);
		int width = Game.getScreen().getWidth();
		int height = Card.HEIGHT;
		this.box = new BoundingBox(pos, width, height);
		this.nbCards = nbCards;
		
		float middleX = Game.getScreen().getWidth() / 2 - Card.WIDTH / 2;
		float middleY = Game.getScreen().getHeight() / 2 - Card.HEIGHT / 2;
		this.middle = new Vector2f(middleX, middleY);
		
		this.generate();
	}
	
	public Deck(Board board, List<Card> cards) {
		this.board = board;
		this.cards = cards;
		this.rand = new Random();
		
		int x = Card.WIDTH;
		int y = Game.getScreen().getHeight() - Card.HEIGHT - 5;
		
		this.pos = new Vector2i(x, y);
		int width = Game.getScreen().getWidth();
		int height = Card.HEIGHT;
		this.box = new BoundingBox(pos, width, height);
		this.nbCards = this.cards.size();
		
		float middleX = Game.getScreen().getWidth() / 2 - Card.WIDTH / 2;
		float middleY = Game.getScreen().getHeight() / 2 - Card.HEIGHT / 2;
		this.middle = new Vector2f(middleX, middleY);
		
		for(Card each : cards) {
			each.decked();
		}
	}
	
	public void generate() {
		for(int i = 0; i < this.nbCards; i++) {			
			Card card = new PassiveCard(this.board.getRound());
			if(rand.nextFloat() <= 0.33)
				card = new AggressiveCard(this.board.getRound());
			else if(rand.nextFloat() <= 0.66)
				card = new SocialCard(this.board.getRound());
			card.decked();
			this.cards.add(card);
		}
	}
	
	public void render(Screen screen) {
		int i = 0;
		for(Card card : this.cards) {
			int interval = (screen.getWidth() - 2 * Card.WIDTH) / this.nbCards;
			if(card != this.selectedCard) card.setPosition(i * interval + this.pos.x, this.pos.y);
			card.render(screen);
			i++;
		}
	}
	
	public void desactive() {
		this.active = false;
	}
	
	public void update() {
		for(Card card : this.cards) {
			card.update();
		}
		
		if(!active && !this.board.hasCard() && Game.INPUT.buttonPressed(MouseEvent.BUTTON1) && this.box.contains(Game.INPUT.getMouseX() / 2, Game.INPUT.getMouseY() / 2)) {
			this.active = true;
			this.selectedCard = this.cards.get(0);
		}
		
		if(this.selectedCard != null) {
			this.selectedCard.pos.interpolate(this.middle, 0.01f);
			if(this.selectedCard.getPosition().equals(this.middle)) {
				this.selectedCard.unDecked();
				this.board.setCard(this.selectedCard);
				this.cards.remove(this.selectedCard);
				this.selectedCard = null;
			}
		}
		
	}
	
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
}
