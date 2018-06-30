package main;

import javax.swing.JFrame;

import gui.CoordinateSystemFrame;
import gui.MeinFenster;

public class Main {

	public static void main(String[] args) {
		
		JFrame meinFenster = new CoordinateSystemFrame();
		meinFenster.setVisible(true);
		meinFenster.setSize(1000, 850);
		meinFenster.setResizable(false);
	}

}
