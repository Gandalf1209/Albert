package com.gandalf1209.main;

import java.util.ArrayList;
import java.util.List;

public class Ammo {

	private int x;
	private int y;
	private int dir;
	private int it;
	
	private static int speed = 7;
	
	public static List<Ammo> list = new ArrayList<Ammo>();
	
	public Ammo(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.it = list.size();
		list.add(this);
	}
	
	public void move() {
		if (dir == 3) {
			y -= speed;
		}
		if (dir == 2) {
			x += speed;
		}
		if (dir == 1) {
			y += speed;
		}
		if (dir == 4) {
			x -= speed;
		}
		
		if (x - 50 < 0 ||
				x + 50 > MainGame.WIDTH ||
				y - 50 < 0 ||
				y + 50 > MainGame.HEIGHT) {
			remove();
		}
		
		for (int i = 0; i < Enemy.list.size(); i++) {
			Enemy e = Enemy.list.get(i);
			if (x + 10 > e.getX() &&
					x - 10 < e.getX() + 50 &&
					y + 10 > e.getY() &&
					y - 10 < e.getY() + 50) {
				e.remove();
				remove();
			}
		}
	}
	
	public void remove() {
		list.remove(it);
		for (int i = it; i < list.size(); i++) {
			list.get(i).it--;
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

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}
	
}