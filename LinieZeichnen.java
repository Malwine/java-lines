package ss2015.uebungen.uebung14;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.Set;

import javax.swing.*;

@SuppressWarnings("serial")
public class LinieZeichnen extends JFrame implements ActionListener, MouseListener, MouseMotionListener   {
	

Canvas canvas;
JButton beenden;
JPanel buttonPanel;
Point starPoint,endPonit;

boolean isPainting;
//Set <Graphics2D> LinienSet;	
	
	public LinieZeichnen() {
		super("Linie Zeichnen");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas=new Canvas();
		getContentPane().add(canvas,BorderLayout.CENTER);
		buttonPanel=initbuttonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		
		this.setVisible(true);
	}
	
	
	
	private JPanel initbuttonPanel() {
		JPanel buttonPanel=new JPanel();
		
		beenden=new JButton("Beenden");
		beenden.addActionListener(this);
		buttonPanel.add(beenden);
		
		return buttonPanel;
	}



	public class Canvas extends JPanel{
		
		public Canvas() {
			super();
			this.setBackground(Color.white);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Graphics2D g2=(Graphics2D)g;
			if(isPainting){
				
//				for (Graphics2D linie : LinienSet) {
					
//					linie.drawLine(x1, y1, x2, y2);
					g2.setStroke(new BasicStroke(3.0f));
					g2.drawLine(starPoint.x, starPoint.y, endPonit.x, endPonit.y);
					
//				}
			
			
			
			}

		}
		
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object source=e.getSource();
		if (source instanceof JButton){
			
			int n=JOptionPane.showConfirmDialog(this,"Wirklich beenden?","Option auswaehlen", JOptionPane.YES_NO_OPTION);
			
			if(n==JOptionPane.YES_OPTION){
				
				this.setVisible(false);
				this.dispose();
				System.exit(0);	
			}
		}
		
		
		
		
	}
	

	
	
	




	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		isPainting=true;
		starPoint=e.getPoint();
		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		isPainting=false;
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		
		endPonit=e.getPoint();
//		LinienSet.add(new drawLine(starPoint.x, starPoint.y, endPonit.x, endPonit.y));
		canvas.repaint();
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	
	
	public static void main(String[] args) {
		
		new LinieZeichnen();

	}


}
