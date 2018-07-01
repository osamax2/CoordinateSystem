package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MeinFenster extends JFrame{
	public MeinFenster() throws InterruptedException {
		getContentPane().setLayout(null);
		
		this.setSize(1000, 780);
		
		JPanel panelKoordinatenWerte = new JPanel();
		panelKoordinatenWerte.setBounds(12, 13, 279, 139);
		getContentPane().add(panelKoordinatenWerte);
		panelKoordinatenWerte.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 279, 139);
		panelKoordinatenWerte.add(textArea);
		
		JPanel panelAlleButton = new JPanel();
		panelAlleButton.setBounds(291, 13, 680, 139);
		getContentPane().add(panelAlleButton);
		panelAlleButton.setLayout(null);
		
		textField_XKoordinate = new JTextField();
		textField_XKoordinate.setBounds(190, 13, 131, 38);
		panelAlleButton.add(textField_XKoordinate);
		textField_XKoordinate.setColumns(10);
		
		textField_YKoordinate = new JTextField();
		textField_YKoordinate.setColumns(10);
		textField_YKoordinate.setBounds(190, 77, 131, 38);
		panelAlleButton.add(textField_YKoordinate);
		
		JLabel label_XKoordinate = new JLabel("X-Koordinate");
		label_XKoordinate.setBounds(68, 13, 118, 38);
		panelAlleButton.add(label_XKoordinate);
		
		JLabel lblYkoordinate = new JLabel("Y-Koordinate");
		lblYkoordinate.setBounds(68, 77, 118, 38);
		panelAlleButton.add(lblYkoordinate);
		
		JButton btnHinzufuegen = new JButton("Hinzufuegen");
		btnHinzufuegen.setBounds(394, 13, 234, 38);
		panelAlleButton.add(btnHinzufuegen);
		
		JButton btnAlleLoeschen = new JButton("Alle Loeschen");
		btnAlleLoeschen.setBounds(394, 77, 234, 38);
		panelAlleButton.add(btnAlleLoeschen);
		
		JPanel panelKoordinaten = new JPanel();
		panelKoordinaten.setBounds(12, 160, 959, 533);
		panelKoordinaten.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panelKoordinaten);
		panelKoordinaten.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProramm = new JMenu("Programm");
		menuBar.add(mnProramm);
		
		JMenuItem mnAlleLoeschen = new JMenuItem("Alle Loeschen");
		mnProramm.add(mnAlleLoeschen);
		
		JMenuItem mnBeenden = new JMenuItem("Beenden");
		mnProramm.add(mnBeenden);
		
		JButton info = new JButton("?");
		menuBar.add(info);
		
		 JFrame frame = new CoordinateSystemFrame();
         frame.setVisible(true);
         frame.setResizable(false);
		
		//SimpleGraphicsPanel sgp = new SimpleGraphicsPanel();
		
	}

	private static final long serialVersionUID = 1L;
	private JTextField textField_XKoordinate;
	private JTextField textField_YKoordinate;
}
