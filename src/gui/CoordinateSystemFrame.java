package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ScorpionOrange on 2017/07/24.
 */
/**
 * A frame that contains a panel with Coordinate System drawings.
 */
public class CoordinateSystemFrame extends JFrame{
    
	private static final long serialVersionUID = 1L;
	private JTextField textField_XKoordinate;
	private JTextField textField_YKoordinate;
	
	  public ArrayList<Integer> X_A =new ArrayList<Integer>();
	    public ArrayList<Integer> Y_A =new ArrayList<Integer>();
	    private CoordinateSystemComponent cosc=new CoordinateSystemComponent(X_A,Y_A);
	
	
	
	public CoordinateSystemFrame(){

       
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Coordinate System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
        
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
		btnHinzufuegen.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int a=Integer.parseInt(textField_XKoordinate.getText());
		    	int b=Integer.parseInt(textField_YKoordinate.getText());
		    	X_A.add(a);
		    	Y_A.add(b);
		    	
		    	if(!textArea.getText().equals(""))
		    		textArea.setText(textArea.getText()+"\n"+"Point = "+X_A.size()+" X = "+a+" Y = "+b);
		    	else
		    		textArea.setText("Point  : "+X_A.size()+" X = "+a+" Y = "+b);
		    
		    	cosc=new CoordinateSystemComponent(X_A,Y_A);
		        
		        cosc.setVisible(true);
		        cosc.graphics2D.setColor(Color.red);
		        cosc.revalidate();
		        cosc.repaint();
		        add(cosc);
		        getContentPane().repaint();
		        revalidate();
		    }
		});
		panelAlleButton.add(btnHinzufuegen);
		
		JButton btnAlleLoeschen = new JButton("Alle Loeschen");
		btnAlleLoeschen.setBounds(394, 77, 234, 38);
		btnAlleLoeschen.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	X_A.clear();
		    	Y_A.clear();;
		    	cosc=new CoordinateSystemComponent(X_A,Y_A);
		        cosc.setVisible(true);
		        cosc.revalidate();
		        cosc.repaint();
		        add(cosc);
		        getContentPane().repaint();
		        revalidate();
		    
		    }
		  		});
		panelAlleButton.add(btnAlleLoeschen);
		
		//JPanel panelKoordinaten = new JPanel();
		//panelKoordinaten.setBounds(12, 160, 959, 533);
	//	panelKoordinaten.setBackground(Color.LIGHT_GRAY);
		
		//panelKoordinaten.setLayout(null);
		
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
		//getContentPane().add(panelKoordinaten);
		//cosc=new CoordinateSystemComponent();
		cosc.setBounds(12, 160, 959, 533);
		add(cosc);
		
        pack();
    }
}

/**
 * A component that draw Coordinate System.
 */
class CoordinateSystemComponent extends JComponent{
    //get screen dimensions
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int screenWidth = 959;
    int screenHeight = 533;
    int count =1;

    Point2D center = new Point2D.Double(screenWidth / 2, ((screenHeight - 150) / 2)+300);
    Point2D leftMiddle = new Point2D.Double(0, ((screenHeight - 150) / 2)+300);
    Point2D rightMiddle = new Point2D.Double(screenWidth, ((screenHeight - 150) / 2)+300);
    Point2D topMiddle = new Point2D.Double(screenWidth / 2,160);
    Point2D bottomMiddle = new Point2D.Double(screenWidth / 2, (screenHeight - 75)+300);

    //int X0, Y0;
    int X0 = (int)center.getX();
    int Y0 = (int)center.getY();
    
    public ArrayList<Integer> X_A =new ArrayList<Integer>();
    public ArrayList<Integer> Y_A =new ArrayList<Integer>();

   public static Graphics2D graphics2D;
   public CoordinateSystemComponent()
   {
	   super();
   }
   
   public CoordinateSystemComponent(ArrayList<Integer> x_A,ArrayList<Integer> y_A)
   {
	   super();
	   X_A=x_A;
	   Y_A=y_A;
	  
   }
    
    
    
    public void paintComponent(Graphics graphics) {
        graphics2D = (Graphics2D) graphics;
        setOrigin();
        graphics2D.setColor(Color.BLUE);
        System.out.println(X_A.size());
        for(int i=0;i<X_A.size();i++)
        {
        	if(i==0 )
        		drawPoint(X_A.get(i),Y_A.get(i));
        	else
        		drawLine(X_A.get(i-1),Y_A.get(i-1),X_A.get(i),Y_A.get(i));
        	
        }
        //drawPoint(250,260);
        
        //drawLine(100,100,-100,-100);
        /*int R = 200;;
        int A = -200, B = Circle(R, A);
        for(int i = 0; i < 2*R; i++){
            int a = A;
            int b = B;
            A++;
            B = Circle(R, A);
            graphics2D.drawLine(new Coordinate2D(a, b).getPixelPointX(), new Coordinate2D(a, b).getPixelPointY(),
                    new Coordinate2D(A, B).getPixelPointX(), new Coordinate2D(A, B).getPixelPointY());
            graphics2D.drawLine(new Coordinate2D(a, -b).getPixelPointX(), new Coordinate2D(a, -b).getPixelPointY(),
                    new Coordinate2D(A, -B).getPixelPointX(), new Coordinate2D(A, -B).getPixelPointY());
        }

        int M = -500, N = (int)Math.sin(M * 0.01) * 100;
        for(int i = 0; i < 2*M; i++){
            int m = M;
            int n = N;
            M++;
            N = (int)Math.sin(M * 0.01) * 100;
            graphics2D.drawLine(new Coordinate2D(m, n).getPixelPointX(), new Coordinate2D(m, n).getPixelPointY(),
                    new Coordinate2D(M, N).getPixelPointX(), new Coordinate2D(M, N).getPixelPointY());
        }*/
    }

    //switching Coordinate System to Origin point (X0, Y0)
    public class Coordinate2D{
        int x, y;
        public Coordinate2D(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getPixelPointX(){
            return X0 + x;
        }
        public int getPixelPointY(){
            return Y0 - y;
        }
    }

    // default Origin Point at Center
    public void setOrigin(){
    	
    	graphics2D.setColor(Color.GREEN);
        // draw X-axis
        graphics2D.draw(new Line2D.Double(leftMiddle, rightMiddle));

        // draw string "+X" and "-X"
        graphics2D.drawString("+X", (int) rightMiddle.getX() - 10, (int) rightMiddle.getY() - 5);
        graphics2D.drawString("-X", (int) leftMiddle.getX() + 10, (int) leftMiddle.getY() + 10);

        // draw Y-axis
        graphics2D.draw(new Line2D.Double(topMiddle, bottomMiddle));

        // draw string "+Y" and "-Y"
        graphics2D.drawString("+Y", (int) topMiddle.getX() + 5, (int) topMiddle.getY() + 10);
        graphics2D.drawString("-Y", (int) bottomMiddle.getX() - 15, (int) bottomMiddle.getY());

    }

    public void drawPoint(int x, int y){
        int X = new Coordinate2D(x, y).getPixelPointX();
        int Y = new Coordinate2D(x, y).getPixelPointY();
        graphics2D.drawLine(X, Y, X, Y);
    }
    public void drawPoint(Point2D point2D){
        int x = (int)point2D.getX();
        int y = (int)point2D.getY();
        drawPoint(x, y);
    }

    //new drawLine() for new Coordinate System which origin at center, not finish yet
    public void drawLine(int x1, int y1, int x2, int y2){
        int a1 = new Coordinate2D(x1, y1).getPixelPointX();
        int b1 = new Coordinate2D(x1, y1).getPixelPointY();
        int a2 = new Coordinate2D(x2, y2).getPixelPointX();
        int b2 = new Coordinate2D(x2, y2).getPixelPointY();
        graphics2D.drawLine(a1, b1, a2, b2);
        
        
    }
    public void drawLine(Point2D A, Point2D B){
        int x1 = (int)A.getX();
        int y1 = (int)A.getY();
        int x2 = (int)B.getX();
        int y2 = (int)B.getY();
        drawLine(x1, y1, x2, y2);
    }

    public int Circle(int r, int a){
        return (int)Math.sqrt(r*r - a*a);
    }

    public Dimension getPreferreiSize(){
        return new Dimension(screenWidth-100,screenHeight-100);
    }
}