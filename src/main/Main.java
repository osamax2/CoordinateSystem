package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import gui.CoordinateSystemFrame;
import gui.MeinFenster;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		JFrame meinFenster;
		try {
			meinFenster = new CoordinateSystemFrame();
			meinFenster.setVisible(true);
			meinFenster.setSize(1000, 850);
			meinFenster.setResizable(false);
			int interval = 1000;
			
			   new Timer(interval, new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			            Calendar now = Calendar.getInstance();
			            meinFenster.setTitle("Nina Bakalova "+ now.getTime().toString());
			        }
			    }).start();

			    Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
