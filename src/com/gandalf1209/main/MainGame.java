package com.gandalf1209.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.graphics.Display;
import com.gandalf1209.yge2.graphics.GraphicsX;

public class MainGame implements Game {

	private Display d;
	
	public void init() {
		d = new Display("Albert", 800, 600, this);
		
		d.keyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		d.getWindow().setResizable(false);
		d.getWindow().setVisible(true);
		
		d.start(30);
	}
	
	@Override
	public void render(GraphicsX g) {
		g.setBGColor(g.hex("#5CCC72"));
		
		g.setColor(g.hex("#007AA3"));
		g.fillRect(Player.x, Player.y, 50, 50);
	}

	@Override
	public void update() {
		
	}
	
}