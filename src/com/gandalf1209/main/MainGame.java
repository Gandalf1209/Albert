package com.gandalf1209.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.gandalf1209.yge2.engine.Application;
import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.graphics.Display;
import com.gandalf1209.yge2.graphics.GraphicsX;
import com.gandalf1209.yge2.input.Keys;

public class MainGame implements Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private Display d;
	
	public void init() {
		d = new Display("Albert - " + Application.VERSION, WIDTH, HEIGHT, this);
		
		d.keyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == Keys.UP || key == Keys.W) {
					Player.mu = true;
				}
				if (key == Keys.DOWN || key == Keys.S) {
					Player.md = true;
				}
				if (key == Keys.RIGHT || key == Keys.D) {
					Player.mr = true;
				}
				if (key == Keys.LEFT || key == Keys.A) {
					Player.ml = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == Keys.UP || key == Keys.W) {
					Player.mu = false;
				}
				if (key == Keys.DOWN || key == Keys.S) {
					Player.md = false;
				}
				if (key == Keys.RIGHT || key == Keys.D) {
					Player.mr = false;
				}
				if (key == Keys.LEFT || key == Keys.A) {
					Player.ml = false;
				}
			}
		});
		
		d.mouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					Player.useWeapon(e.getX() - d.getWindow().getInsets().left, e.getY() - d.getWindow().getInsets().top);
				}
			}
		});
		
		Enemy.spawn(3);
		
		d.getWindow().setResizable(false);
		d.getWindow().setVisible(true);
		
		d.start(30);
	}
	
	@Override
	public void render(GraphicsX g) {
		g.setBGColor(g.hex("#5CCC72"));
		
		g.setColor(g.hex("#007AA3"));
		g.fillRect(Player.x, Player.y, 50, 50);
		
		g.setColor(g.hex("#5A1D73"));
		for (int i = 0; i < Enemy.list.size(); i++) {
			Enemy e = Enemy.list.get(i);
			g.fillRect(e.getX(), e.getY(), 50, 50);
		}
		
		g.setColor(g.hex("#545454"));
		for (int i = 0; i < Ammo.list.size(); i++) {
			Ammo a = Ammo.list.get(i);
			g.fillRect(a.getX(), a.getY(), 10, 10);
		}
	}

	@Override
	public void update() {
		Player.checkMovement();
		
		for (int i = 0; i < Enemy.list.size(); i++) {
			Enemy e = Enemy.list.get(i);
			e.followPlayer();
		}
		
		for (int i = 0; i < Ammo.list.size(); i++) {
			Ammo a = Ammo.list.get(i);
			a.move();
		}
	}
	
}