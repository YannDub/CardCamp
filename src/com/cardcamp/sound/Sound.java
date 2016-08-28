package com.cardcamp.sound;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	public static final Sound music = new Sound("/music/ambiant.wav");
	
	private Clip clip;
	
	private Sound(String name) {
		try {
			this.clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(name));
			clip.open(ais);
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-40.0f); // Reduce volume by 10 decibels.
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		new Thread() {
			public void run() {
				clip.start();
			}
		}.start();
	}
	
	public void loop() {
		new Thread() {
			public void run() {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			}
		}.start();
	}
}
