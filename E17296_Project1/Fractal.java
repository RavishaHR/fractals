//E/17/296

import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;
import java.lang.*;


//Main application
public class Fractal{
	
	//Method to check whether the inputs are numerical
	public static boolean isNumeric(String s) { 
	
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	
	//Main method
	public static void main(String [] args) { 
	
	
		//Default values
		
		//Maximum number of iterations
		int max = 1000;
		//Range for the imaginery axis
		double ypos = 1;
		double yneg = -1;
		//Range for the real axis
		double xpos = 1;
		double xneg = -1;
		//Value for c
		double cxforj = -0.4;
		double cyforj = 0.6;
	
	
		//Argument handling
		if(args.length > 0){
			//assuming its greater than zero
			//For the Mandelbrot set
			if(args[0].equals("Mandelbrot")){
				
				//Set variables
				if(args.length == 1){
					//No variables to set
					//Use default values
				}
				else if(args.length == 5  &&  isNumeric(args[1])  &&  isNumeric(args[2])  &&  isNumeric(args[3])  &&  isNumeric(args[4])){	//Set range of interest
					//Set the region of interest
					xneg = Double.parseDouble(args[1]);
					xpos = Double.parseDouble(args[2]);
					yneg = Double.parseDouble(args[3]);
					ypos = Double.parseDouble(args[4]);
					
				}
				else if(args.length == 6  &&  isNumeric(args[1])  &&  isNumeric(args[2])  &&  isNumeric(args[3])  &&  isNumeric(args[4]) && isNumeric(args[5])){ //Set roi and the max number of iterations
					//Set the roi and the maximum number of iterations
					xneg = Double.parseDouble(args[1]);
					xpos = Double.parseDouble(args[2]);
					yneg = Double.parseDouble(args[3]);
					ypos = Double.parseDouble(args[4]);
					max = Integer.parseInt(args[5]);
					
				}
				//Invalid values (non numerical) and invalid number of inputs
				else{
					System.out.println("Invalid");
					System.out.println("Usage: [ Mandelbrot :  real_min real_max img_min img_max iterations    | Julia :  c_real c_img iterations ]");
					return;	//Exit
				}
				
				//Proceed if the arguments are valid
				
				// create a frame
				JFrame frame = new JFrame("Mandelbrot test"); 
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

				// set the content of the frame as one of this panel
				frame.setContentPane(new Panel(800,800,xneg,xpos,yneg,ypos,max)); 

				frame.pack(); 
				frame.setLocationRelativeTo(null); 
				frame.setVisible(true); 
				
			}
			//For the Julia set
			else if(args[0].equals("Julia")){
				
				//Set variables
				if(args.length == 1){
					//No variables to set
					//Use default values
				}
				else if(args.length == 4  &&  isNumeric(args[1])  &&  isNumeric(args[2])  &&  isNumeric(args[3])){
					//Set c and maximum number of iterations
					cxforj = Double.parseDouble(args[1]);
					cyforj = Double.parseDouble(args[2]);
					max = Integer.parseInt(args[3]); 
				}
				//Invalid values (non numerical) and invalid number of inputs
				else{
					System.out.println("Invalid");
					System.out.println("Usage: [ Mandelbrot :  real_min real_max img_min img_max iterations    | Julia :  c_real c_img iterations ]");
					return;	//Exit
				}
				
				
				//Proceed if the arguments are valid
				
				
				// create a frame
				JFrame frame = new JFrame("Julia test"); 
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

				// set the content of the frame as one of this panel
				frame.setContentPane(new Panelnew(800,800,-1,1,-1,1, cxforj, cyforj, max)); 

				frame.pack(); 
				frame.setLocationRelativeTo(null); 
				frame.setVisible(true);  
				
			}
			//Other inputs are invalid
			else{
				System.out.println("Invalid");
				System.out.println("Usage: [ Mandelbrot :  real_min real_max img_min img_max iterations    | Julia :  c_real c_img iterations ]");
				return;	//Exit
			}
			
		}
		//Invalid inputs
		else{
			//Prints a message about the usage
			System.out.println("Usage: [ Mandelbrot :  real_min real_max img_min img_max iterations    | Julia :  c_real c_img iterations ]");
			return;	//Exit
		}
		
		
		
	
	
    } 
	
}