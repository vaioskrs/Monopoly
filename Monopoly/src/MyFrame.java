import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	private JLabel label;
	private MyGlassPane myGlassPane;
	private Player currentPlayer; 
	
	public MyFrame(Player p) {
		
		currentPlayer = p;
		
		ImageIcon icon = new ImageIcon("monopoly.gif");
		label = new JLabel(icon);
		this.setContentPane(label);
		
		myGlassPane = new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		MyListener listener = new MyListener();
		myGlassPane.addMouseListener(listener);
		
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyGlassPane extends JComponent {
		
		private int x = 50;
		private int y = 50;
		
		public void paintComponent(Graphics g) {		
			g.setColor(Color.RED);
			g.fillOval(x, y, 20, 20);	
		}
		
		public void drawAt(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	class MyListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("X = " + x + " Y= " + y);
			if(x>264 && y>35 && x<294 && y<83)
			{
			   currentPlayer.addSquare(new Square("Tsimiski"));
			   System.out.println("Square tsimiski added to P1");
				
			}
			myGlassPane.drawAt(x, y);
			myGlassPane.repaint();
		}
	}

}
