package com.gandalf1209.main;

public class Player {

	public static int x = 100;
	public static int y = 100;
	public static int speed = 5;
	public static int level = 1;
	
	public static boolean mu;
	public static boolean md;
	public static boolean mr;
	public static boolean ml;
	
	public static void checkMovement() {
		if (mu) {
			y -= speed;
		}
		if (md) {
			y += speed;
		}
		if (ml) {
			x -= speed;
		}
		if (mr) {
			x += speed;
		}
	}
	
	public static void useWeapon(int mx, int my) {
		int dir = 1;
		int dx = mx - x;
		int dy = -(my - y);
		if ((int)Math.abs(dx) > (int)Math.abs(dy)) {
			if (dx <= 0) {
				dir = 4;
			} else {
				dir = 2;
			}
		} else {
			if (dy <= 0) {
				dir = 3;
			} else {
				dir = 1;
			}
		}
		new Ammo(x, y, dir);
	}
	
}