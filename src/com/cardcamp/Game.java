package com.cardcamp;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.cardcamp.gfx.Screen;
import com.cardcamp.scene.GameScene;
import com.cardcamp.scene.Scene;
import com.cardcamp.utils.Input;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH * 9 / 16;
	private Thread thread;
	private JFrame window;
	private BufferStrategy bs;
	
	private boolean running;
	public static final int SCALE = 2;
	
	private static Screen screen;
	private Scene scene;
	public static final Input INPUT = new Input();
	
	private Game() {
		screen = new Screen(WIDTH / SCALE, HEIGHT / SCALE);
		this.scene = new GameScene(this);
	}
	
	private void init() {
		Dimension dim = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);
		
		
		this.window = new JFrame("CardCamp");
		this.window.add(this);
		this.window.pack();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);
		this.window.setVisible(true);
		
		this.addKeyListener(INPUT);
		this.addMouseListener(INPUT);
		this.addMouseMotionListener(INPUT);
	}
	
	public void start() {
		this.thread = new Thread(this, "Screen");
		this.thread.start();
		this.running = true;
	}
	
	public void stop() {
		try {
			this.thread.join();
			this.running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.init();
		
		double ns = 1000000000.0 / 60.0;
		long lastTime = System.nanoTime();
		double delta = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				this.update();
				delta -= 1;
			}
			
			this.render();
			this.update();
		}
	}
	
	private synchronized void render() {
		this.bs = this.getBufferStrategy();
		if(this.bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		screen.fill(0xff000000);
		
		this.scene.render(screen);
		
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, WIDTH / SCALE, HEIGHT / SCALE);
		g.drawImage(screen.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
	}
	
	private synchronized void update() {
		this.scene.update();
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public static Screen getScreen() {
		return screen;
	}
	
	public static void main(String[] argv) {
		new Game().start();
	}

}
