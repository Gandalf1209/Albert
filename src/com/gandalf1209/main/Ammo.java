package com.gandalf1209.main;

import java.util.ArrayList;
import java.util.List;

public class Ammo {

	private int x;
	private int y;
	private int dir;
	
	private static int speed = 7;
	
	public static List<Ammo> list = new ArrayList<Ammo>();
	
	public Ammo(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		list.add(this);
	}
	
	public void move() {
		if (dir == 1) {
			y -= speed;
		}
		if (dir == 2) {
			x += speed;
		}
		if (dir == 3) {
			y += speed;
		}
		if (dir == 4) {
			x -= speed;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
}