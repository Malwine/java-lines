package ss2015.uebungen.uebung14;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

@SuppressWarnings("serial")
public class LinieZeichnen extends JFrame implements ActionListener, MouseListener, MouseMotionListener   {
	
	Canvas canvas;
	JButton beenden;
	JPanel buttonPanel;
	Point startPoint,endPoint;
	boolean isPainting;
	Set<Line2D> lines;
	
	public LinieZeichnen() {
		super("Draw lines");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas=new Canvas();
		getContentPane().add(canvas,BorderLayout.CENTER);
		buttonPanel=initbuttonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		lines = new HashSet<Line2D>();
		
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
				
			Graphics2D g2 = (Graphics2D)g;
			
			if(isPainting){
					g2.setStroke(new BasicStroke(3.0f));
					g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			}
			
			for ( Line2D line : lines) {
				g2.fill(line);
				
				System.out.println(line);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object source=e.getSource();
		if (source instanceof JButton){
			
			int n=JOptionPane.showConfirmDialog(this,"Do you want to cancel?","Choose option", JOptionPane.YES_NO_OPTION);
			
			if(n==JOptionPane.YES_OPTION){
				
				this.setVisible(false);
				this.dispose();
				System.exit(0);	
			}
		}		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) {
		isPainting=true;
		startPoint=e.getPoint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		isPainting=false;
		endPoint = e.getPoint();
		
		System.out.println(endPoint.getX());
		
		lines.add(new Line2D.Double(startPoint.x, startPoint.y, endPoint.x, endPoint.y));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
	public static void main(String[] args) {		
		new LinieZeichnen();
	}
}
