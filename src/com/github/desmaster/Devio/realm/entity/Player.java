package com.github.desmaster.Devio.realm.entity;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;


import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.util.Position;

public class Player extends Mob {

	private int walkspeed = 1;
	boolean running = false;
	Thread thread;

	int fps;
	long lastFrame;
	long lastFPS;

	public InputHandler input;

	public Player(Texture texture, Position spawnPosition, double lives, InputHandler input) {
		super(spawnPosition, lives);
		this.input = input;
		entitySize = Realm.BLOCK_SIZE;
		setTexture(iTexture.PLAYER_BILLIE);
	}

	public void start() {
		
	}

	public void tick(int delta) {
		if (x < 0) {
			x = 0;
		}

		if (y < 0) {
			y = 0;
		}

		if (x + walkspeed > Display.getWidth()) {
			x = Display.getWidth() - walkspeed;
		}

		if (y + walkspeed > Display.getHeight()) {
			y = Display.getHeight() - walkspeed;
		}

		if (input.up.down) {
			input.releaseAll();
			walkUp();
		}

		if (input.left.down) {
			input.releaseAll();
			walkLeft();
		}

		if (input.down.down) {
			input.releaseAll();
			walkDown();
		}

		if (input.right.down) {
			input.releaseAll();
			walkRight();
		}

	}

	public void walkUp() {
		y -= walkspeed;
	}

	public void walkDown() {
		y += walkspeed;
	}

	public void walkLeft() {
		x -= walkspeed;
	}

	public void walkRight() {
		x += walkspeed;
	}

	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public int getXonScreen(){
		return (x - Realm.world.getVisibleMapOffsetPosition(this).getX()) * 32;
	}
	public int getYonScreen(){
		return (y - Realm.world.getVisibleMapOffsetPosition(this).getY()) * 32;
	}

}
