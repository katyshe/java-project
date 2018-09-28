package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.geom.*;
import java.util.*;

public class MinMap extends JPanel{
	private HashMap<Integer, Color> shapeColors2 = new HashMap<Integer, Color>();
	private  Color[][]shapeColors=new  Color[11][11];
	private HashMap<Integer, Rectangle2D.Double> shapes2 = new HashMap<Integer, Rectangle2D.Double>();
	private  Rectangle2D.Double[][]shapes=new  Rectangle2D.Double[11][11];
	private JPanel contentPane;
		
	public MinMap(){
		
		repaint();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
	}
	
	public HashMap<Integer, Color> getShapeColors2() {
		return shapeColors2;
	}

	public void setShapeColors2(HashMap<Integer, Color> shapeColors2) {
		this.shapeColors2 = shapeColors2;
	}

	public Rectangle2D.Double[][] getShapes() {
		return shapes;
	}

	public void setShapes(Rectangle2D.Double[][] shapes) {
		this.shapes = shapes;
	}

	public void paint () {
		
		shapeColors[0][0]=new Color(224, 248, 230);
		shapeColors[1][0]=new Color(224, 248, 230);
		shapeColors[2][0]=new Color(224, 248, 230);
		shapeColors[3][0]=new Color(224, 248, 230);
		shapeColors[4][0]=new Color(224, 248, 230);
		shapeColors[5][0]=new Color(224, 248, 230);
		shapeColors[6][0]=new Color(224, 248, 230);
		shapeColors[7][0] =new Color(224, 248, 230);
		shapeColors[8][0]=new Color(224, 248, 230);
		shapeColors[9][0] =new Color(224, 248, 230);
		shapeColors[10][0]= new Color(224, 248, 230);
		
		shapeColors[10][1]=new Color(224, 248, 230);
		shapeColors[10][2]=new Color(224, 248, 230);
		shapeColors[10][3]=new Color(224, 248, 230);
		shapeColors[10][4]=new Color(224, 248, 230);
		shapeColors[10][5]=new Color(224, 248, 230);
		shapeColors[10][6]=new Color(224, 248, 230);
		shapeColors[10][7]=new Color(224, 248, 230);
		shapeColors[10][8]=new Color(224, 248, 230);
		shapeColors[10][9]=new Color(224, 248, 230);
		
		
		shapeColors[0][10]=new Color(224, 248, 230);
		shapeColors[1][10]=new Color(224, 248, 230);
		shapeColors[2][10]=new Color(224, 248, 230);
		shapeColors[3][10]=new Color(224, 248, 230);
		shapeColors[4][10]=new Color(224, 248, 230);
		shapeColors[5][10]=new Color(224, 248, 230);
		shapeColors[6][10]=new Color(224, 248, 230);
		shapeColors[7][10]=new Color(224, 248, 230);
		shapeColors[8][10]=new Color(224, 248, 230);
		shapeColors[9][10]=new Color(224, 248, 230);
		shapeColors[10][10]=new Color(224, 248, 230);
		
		shapeColors[0][1]=new Color(224, 248, 230);
		shapeColors[0][2]=new Color(224, 248, 230);
		shapeColors[0][3]=new Color(224, 248, 230);
		
		shapeColors[0][4]=new Color(224, 248, 230);
		shapeColors[0][5]=new Color(224, 248, 230);
		shapeColors[0][6]=new Color(224, 248, 230);
		shapeColors[0][7]=new Color(224, 248, 230);
		shapeColors[0][8]=new Color(224, 248, 230);
		shapeColors[0][9]=new Color(224, 248, 230);
		
		shapeColors2.put(0, Color.yellow);
		shapeColors2.put(1, Color.red);
		shapeColors2.put(2, Color.yellow);
		shapeColors2.put(3, Color.green);
		shapeColors2.put(4, Color.red);
		shapeColors2.put(5, Color.green);
		
		shapeColors2.put(6, Color.red);
		shapeColors2.put(7, Color.yellow);
		shapeColors2.put(8, Color.red);
		shapeColors2.put(9, Color.green);
		shapeColors2.put(10, Color.green);
		shapeColors2.put(11, Color.yellow);
		shapeColors2.put(12, Color.red);
		shapeColors2.put(13, Color.red);
		shapeColors2.put(14, Color.red);
		shapeColors2.put(15, Color.green);
		shapeColors2.put(16, Color.yellow);
		shapeColors2.put(17, Color.yellow);
		shapeColors2.put(18, Color.green);
		shapeColors2.put(19, Color.green);
		shapeColors2.put(20, Color.green);
		shapeColors2.put(21, Color.yellow);
		shapeColors2.put(22, Color.yellow);
		shapeColors2.put(23, Color.red);
		
		
		
		setVisible(true);
	}
	
	public Color getColorNr(int i){
		Color c = Color.black;
		Set<Map.Entry<Integer, Color>> s = shapeColors2.entrySet();
		for(Map.Entry<Integer, Color> m : s)
			if(i == m.getKey())
				c = m.getValue();
		return c;
	}
	public Color getColorNr(int i,int j){
		Color c;	
		c =shapeColors[i][j];
		return c;
	}
	
	public void addRects(){
	
		shapes[0][0]=new Rectangle2D.Double(832,605,130,91);
		shapes[1][0]= new Rectangle2D.Double(754,605,78,91);
		shapes[2][0]= new Rectangle2D.Double(676,605,78,91);
		shapes[3][0]=new Rectangle2D.Double(598,605,78,91);
		shapes[4][0]=new Rectangle2D.Double(520,605,78,91);
		shapes[5][0]= new Rectangle2D.Double(442,605,78,91);
		shapes[6][0]= new Rectangle2D.Double(364,605,78,91);
		shapes[7][0]=new Rectangle2D.Double(286,605,78,91);
		shapes[8][0]=new Rectangle2D.Double(208,605,78,91);
		shapes[9][0]= new Rectangle2D.Double(130,605,78,91);
		shapes[10][0]= new Rectangle2D.Double(0,605,130,91);
	
		shapes[10][1]=new Rectangle2D.Double(0,548,130,57);
		shapes[10][2]=new Rectangle2D.Double(0,491,130,57);
		shapes[10][3]=new Rectangle2D.Double(0,434,130,57);
		shapes[10][4]=new Rectangle2D.Double(0,377,130,57);
		shapes[10][5]=new Rectangle2D.Double(0,320,130,57);
		shapes[10][6]=new Rectangle2D.Double(0,263,130,57);
		shapes[10][7]=new Rectangle2D.Double(0,206,130,57);
		shapes[10][8]=new Rectangle2D.Double(0,149,130,57);
		shapes[10][9]=new Rectangle2D.Double(0,92,130,57);
		
		
		shapes[0][10]=new Rectangle2D.Double(0,0,130,91);
		shapes[1][10]=new Rectangle2D.Double(130,0,78,91);
	    shapes[2][10]=new Rectangle2D.Double(208,0,78,91);
		shapes[3][10]=new Rectangle2D.Double(286,0,78,91);
		shapes[4][10]=new Rectangle2D.Double(364,0,78,91);
		shapes[5][10]=new Rectangle2D.Double(442,0,78,91);
		shapes[6][10]=new Rectangle2D.Double(520,0,78,91);
		shapes[7][10]=new Rectangle2D.Double(598,0,78,91);
		shapes[8][10]=new Rectangle2D.Double(676,0,78,91);
		shapes[9][10]=new Rectangle2D.Double(754,0,78,91);
	    shapes[10][10]=new Rectangle2D.Double(832,0,130,91);
		

	    shapes[0][1]=new Rectangle2D.Double(832,92,130,57);
		shapes[0][2]=new Rectangle2D.Double(832,149,130,57);
	    shapes[0][3]=new Rectangle2D.Double(832,206,130,57);
        shapes[0][4]=new Rectangle2D.Double(832,263,130,57);
		shapes[0][5]=new Rectangle2D.Double(832,320,130,57);
		shapes[0][6]=new Rectangle2D.Double(832,377,130,57);
	    shapes[0][7]=new Rectangle2D.Double(832,434,130,57);
		shapes[0][8]=new Rectangle2D.Double(832,491,130,57);
	    shapes[0][9]=new Rectangle2D.Double(832,548,130,57);
		
		
		shapes2.put(0, new Rectangle2D.Double(754,605,78,20));
		shapes2.put(1, new Rectangle2D.Double(598,605,78,20));
		shapes2.put(2, new Rectangle2D.Double(442,605,78,20));
		shapes2.put(3, new Rectangle2D.Double(364,605,78,20));
		shapes2.put(4, new Rectangle2D.Double(286,605,78,20));
		shapes2.put(5, new Rectangle2D.Double(130,605,78,20));
		
		shapes2.put(6, new Rectangle2D.Double(110,548,20,57));
		shapes2.put(7, new Rectangle2D.Double(110,434,20,57));
		shapes2.put(8, new Rectangle2D.Double(110,377,20,57));
		shapes2.put(9, new Rectangle2D.Double(110,263,20,57));
		shapes2.put(10, new Rectangle2D.Double(110,149,20,57));
		shapes2.put(11, new Rectangle2D.Double(110,92,20,57));
		shapes2.put(12, new Rectangle2D.Double(130,71,78,20));
		shapes2.put(13, new Rectangle2D.Double(286,71,78,20));
		shapes2.put(14, new Rectangle2D.Double(364,71,78,20));
		shapes2.put(15, new Rectangle2D.Double(520,71,78,20));
		shapes2.put(16, new Rectangle2D.Double(598,71,78,20));
		shapes2.put(17, new Rectangle2D.Double(754,71,78,20));
		
		shapes2.put(18, new Rectangle2D.Double(832,92,20,57));
		shapes2.put(19, new Rectangle2D.Double(832,149,20,57));
		shapes2.put(20, new Rectangle2D.Double(832,263,20,57));
		shapes2.put(21, new Rectangle2D.Double(832,320,20,57));
		shapes2.put(22, new Rectangle2D.Double(832,434,20,57));
		shapes2.put(23, new Rectangle2D.Double(832,548,20,57));
	}
	
	/*public void setColorOnBrick(int i, Color c){
		shapeColors.put(i, c);
	}*/
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		addRects();
		paint ();
		
		for(int i=0;i<11;i++)
		{		
			g2d.setPaint(getColorNr(i,0));
			g2d.fill(shapes[i][0]);
			g2d.setPaint(Color.lightGray);
			g2d.draw(shapes[i][0]);
		}
		for(int j=1;j<10;j++)
		{	
			g2d.setPaint(getColorNr(10,j));
			g2d.fill(shapes[10][j]);
			g2d.setPaint(Color.lightGray);
			g2d.draw(shapes[10][j]);
		}
		for(int i=10;i>0;i--)
		{	
			g2d.setPaint(getColorNr(i,10));
			g2d.fill(shapes[i][10]);
			g2d.setPaint(Color.lightGray);
			g2d.draw(shapes[i][10]);
		}
		for(int j=9;j>0;j--)
		{			
			g2d.setPaint(getColorNr(0,j));
			g2d.fill(shapes[0][j]);
			g2d.setPaint(Color.lightGray);
			g2d.draw(shapes[0][j]);
		}
		Set<Map.Entry<Integer, Rectangle2D.Double>> s = shapes2.entrySet();
		for(Map.Entry<Integer, Rectangle2D.Double> m : s){
			g2d.setPaint(getColorNr(m.getKey()));
			g2d.fill(m.getValue());
			g2d.setPaint(Color.black);
			g2d.draw(m.getValue());
		}
	
			
			
		repaint();	
	}
}