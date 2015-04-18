package com.gandalf1209.main;

import java.util.ArrayList;
import java.util.List;

import com.gandalf1209.yge2.engine.Mathf;

public class Enemy {

	private String name;
	private int x;
	private int y;
	private int diff;
	
	public static List<Enemy> list = new ArrayList<Enemy>();
	
	public Enemy(String name, int x, int y, int diff) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.diff = diff;
		list.add(this);
	}
	
	public static void spawn(int times) {
		for (int i = 0; i < times; i++) {
			new Enemy("Syriven", Mathf.random(0, MainGame.WIDTH -100), Mathf.random(0, MainGame.HEIGHT -100), 1);
		}
	}
	
	public void followPlayer() {
		
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
	
}