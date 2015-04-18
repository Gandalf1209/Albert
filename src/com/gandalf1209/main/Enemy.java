package com.gandalf1209.main;

import java.util.ArrayList;
import java.util.List;

import com.gandalf1209.yge2.engine.Mathf;

public class Enemy {

	private String name;
	private int x;
	private int y;
	private int diff;
	private int speed;
	private int it;
	
	public static List<Enemy> list = new ArrayList<Enemy>();
	
	public Enemy(String name, int x, int y, int diff, int speed) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.diff = diff;
		this.speed = speed;
		this.it = list.size();
		list.add(this);
	}
	
	public static void spawn(int times) {
		for (int i = 0; i < times; i++) {
			new Enemy("Syrivi", Mathf.random(0, MainGame.WIDTH -100), Mathf.random(0, MainGame.HEIGHT -100), 1, Mathf.random(2, 4));
		}
	}
	
	public void followPlayer() {
		if (x > Player.x) {
			x -= speed;
		}
		if (x < Player.x) {
			x += speed;
		}
		if (y > Player.y) {
			y -= speed;
		}
		if (y < Player.y) {
			y += speed;
		}
	}
	
	public void remove() {
		list.remove(it);
		for (int i = it; i < list.size(); i++) {
			list.get(i).it--;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}
	
}