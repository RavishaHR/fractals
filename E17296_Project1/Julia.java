//E/17/296

//Julia class
public class Julia{
	
	private int n;
	/*
	n where;
			Zn+1 = Zn^2 + C
	*/
	
	public Julia (double cx, double cy, double zx, double zy, int max){
		
		//Temporary values
		double tempx = 0;
		double tempy = 0;
		
		for(int i = 0; i < max; i++){
			//Check whether (abs(z))^2 > 4
			if((zx*zx + zy*zy) > 4){
				//Get the iteration at the point where the for loop ends
				n = i;
				return;
			}
			else{
				//Update temp
				tempx = zx*zx - zy*zy + cx;
				tempy = 2*zx*zy + cy;
			}
			
			//Set z
			zx = tempx;
			zy = tempy;
		}
		//Give n the maximum number of iterations
		n = max;
		return;
		
	}
	
	//To get n
	public int getn(){
		
		return n;
	}
}