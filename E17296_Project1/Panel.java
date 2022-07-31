//E/17/296

import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;
import java.lang.*;


//Panel for the Mandelbrot set
class Panel extends JPanel { // inherit JPanel 

    private int width, height; //For the panel size
	private int max = 1000;//Default value
	private double ypos, yneg, xpos, xneg;	//Axes
    

    public Panel(int width, int height, double X_N, double X_P, double Y_N, double Y_P, int max) { 
	//Set the panel size 
	this.width  = width; 
	this.height = height;
	//Imaginary axis
	this.ypos = Y_P;
	this.yneg = Y_N;
	//Real axis
	this.xpos = X_P;
	this.xneg = X_N;
	//Maximum number of iterations
	this.max = max;
	
	setPreferredSize(new Dimension(width, height)); 

    }
	
	//Used to print a point
    private static void printPoint(Graphics2D frame, Color c, Point p) {

	frame.setColor(c); //Set color
	frame.setBackground(Color.GRAY);	//Set background color
	frame.drawRect((int)p.getX(), (int)p.getY(),1,1);
    }

    public void paintComponent(Graphics g) { 
		//Call paintComponent from parent class 
		super.paintComponent(g); 

		//Get points for the canvas
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				
				//Get point
				Point t = new Point((double)i, (double)j);
				//Find the relevant location for C on the canvas
				double Cx = xneg + ((t.getX() / width)*(xpos - xneg));
				double Cy = ypos + ((t.getY() / height)*(yneg - ypos));
				
				//Create a Mandelbrot object
				Mandelbrot obj = new Mandelbrot(Cx, Cy, this.max);
				//System.out.println(Cx + " " + Cy + "--------> " + obj.getn() );
				
				int color;	//To set color for each point
				
				//If the number of iterations is the max amount
				if(obj.getn() == max){//black
					color = 0;
				}
				//If the number of iterations is less than the max amount
				else{
					//color = (int)(16777215/(Math.log((double)obj.getn())*50));
					
					//Set color for the other points
					color = (int)((16777215*obj.getn())/(max));
					//color = 6388607 + (int)((9000*obj.getn())/ max);
					
						
				}
				
				
				//Set the relevant color to s
				Color s = new Color(color).brighter();
				
				//Print point with the appropriate color
				printPoint((Graphics2D)g, s, t);
				
				
				
			}
		}


    }


}