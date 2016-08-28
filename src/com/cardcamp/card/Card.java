package com.cardcamp.card;

import java.awt.event.MouseEvent;
import java.util.Random;

import com.cardcamp.Game;
import com.cardcamp.card.effect.CardEffect;
import com.cardcamp.gfx.Art;
import com.cardcamp.gfx.Bitmap;
import com.cardcamp.gfx.Screen;
import com.cardcamp.maths.Vector2f;
import com.cardcamp.rounds.Round;
import com.cardcamp.utils.BoundingBox;

public abstract class Card {
	
	public static final int WIDTH = Art.card_back.getWidth();
	public static final int HEIGHT = Art.card_back.getHeight();
	
	protected boolean isRecto;
	protected boolean isInDeck;
	protected Vector2f pos;
	protected BoundingBox box;
	protected CardEffect effect;
	protected String message;
	protected Random rand = new Random();
	protected Round round;
	
	public Card(Round round) {
		this.isRecto = false;
		this.pos = new Vector2f(0, 0);
		this.box = new BoundingBox(this.pos, WIDTH, HEIGHT);
		this.effect = initEffect();
		this.rand = new Random();
		this.round = round;
		this.message = this.initMessage();
	}
	
	public String initMessage() {
		return this.effect.getMessages(this.round)[rand.nextInt(this.effect.getMessages(this.round).length)];
	}
	
	public abstract CardEffect initEffect();
	
	public void setPosition(int x, int y) {
		this.pos.x = x;
		this.pos.y = y;
	}
	
	public Bitmap verso() {
		return Art.card_back;
	}
	
	public abstract Bitmap recto();
	
	protected abstract Bitmap people();
	
	public void render(Screen screen) {
		if(this.isRecto) {
			screen.renderBitmap((int)pos.x, (int)pos.y, this.recto());
			screen.renderBitmap((int)this.pos.x + this.box.getWidth() / 2 - this.people().getWidth() / 2 - 1, (int)this.pos.y + 16, this.people());
		}
		else screen.renderBitmap((int)pos.x, (int)pos.y, this.verso());
	}
	
	public void update() {
		if(!this.isInDeck && Game.INPUT.buttonPressed(MouseEvent.BUTTON1) && box.contains(Game.INPUT.getMouseX() / 2, Game.INPUT.getMouseY() / 2)) {
			if(this.isRecto) {
				this.pos.x = Game.INPUT.getMouseX() / 2 - WIDTH / 2;
				this.pos.y = Game.INPUT.getMouseY() / 2 - HEIGHT / 2;				
			} else {
				this.isRecto = true;
			}
		}
		this.box.update(this.pos);
	}
	
	public void decked() {
		this.isInDeck = true;
	}
	
	public void unDecked() {
		this.isInDeck = false;
	}
	
	public int getX() {
		return (int)this.pos.x;
	}
	
	public int getY() {
		return (int)this.pos.y;
	}
	
	public Vector2f getPosition() {
		return this.pos;
	}
	
	public CardEffect getEffect() {
		return this.effect;
	}
	
	public BoundingBox getBox() {
		return this.box;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public boolean isRecto() {
		return this.isRecto;
	}

	public void setRound(Round round) {
		this.round = round;
	}
}
