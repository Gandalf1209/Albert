package com.gandalf1209.main;

import java.awt.image.BufferedImage;

import com.gandalf1209.yge2.graphics.GraphicsLoader;

public class Texture {

	private static GraphicsLoader gl;
	
	public static void init() {
		gl = new GraphicsLoader();
		gl.setDefaultLoadingDirectory("/textures/");
	}
	
	public static BufferedImage getByName(String name) {
		BufferedImage img = gl.loadGraphic("Missing.png");
		img = gl.loadGraphic(name + ".png");
		return img;
	}
	
}