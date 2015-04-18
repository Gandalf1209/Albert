package com.gandalf1209.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lore {

	public static String[] lore = new String[10];
	
	public static void load() {
		Arrays.fill(lore, "");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(Lore.class.getResourceAsStream("/lore/lore.txt")));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				lore[i] = line;
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}