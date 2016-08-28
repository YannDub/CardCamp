package com.cardcamp.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class Input implements KeyListener, MouseInputListener {
	
	private boolean[] keys = new boolean[65535];
	private int mouseX, mouseY, deltaX, deltaY;
	private boolean[] mouseButtons = new boolean[3];
	private boolean mouseDragged = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public boolean isPressed(int keyCode) {
		return keys[keyCode];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.changeMousePos(e);
		mouseButtons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseButtons[e.getButton()] = false;
		this.mouseDragged = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.changeMousePos(e);
		this.mouseDragged = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.changeMousePos(e);
		this.mouseDragged = false;
	}
	
	private void changeMousePos(MouseEvent e) {
		int previousX = this.mouseX;
		int previousY = this.mouseY;
		this.mouseX = e.getX();
		this.mouseY = e.getY();
		this.deltaX = this.mouseX - previousX;
		this.deltaY = this.mouseY - previousY;
	}
	
	public int getMouseX() {
		return this.mouseX;
	}
	
	public int getMouseY() {
		return this.mouseY;
	}
	
	public boolean buttonPressed(int button) {
		return this.mouseButtons[button];
	}
	
	public boolean isMouseDragged() {
		return this.mouseDragged;
	}
	
	public int getDeltaX() {
		return this.deltaX;
	}
	
	public int getDeltaY() {
		return this.deltaY;
	}
	
}
