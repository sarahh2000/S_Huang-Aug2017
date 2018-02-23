//Sarah Huang
//February 10
//APCS2
//Prism superclass

/* Write this abstract class called Prism.  It has one private field (height) and a constructor.  
 * It contains the methods calcAreaOfBase, calcPerimeter, calcVolume, and calcSA.
 * None of these methods require parameters.   
 * A couple are abstract - can you tell which ones and why?
 * 
 * Math note:
 * The volume of any prism can be found by multiplying the area of the base by the height.
 * The surface area of any prism can be found by multiplying the perimeter of the base by the height
 *   and then adding on the areas of the 2 bases.
 */


public abstract class Prism  {
	private double height;
	public Prism(double height) {
		this.height=height;
	}
	public abstract double calcAreaOfBase();
	public abstract double calcPerimeter();
	public static double round2(double value) {
		int tempInt = (int) (value*1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt/10;
		if(roundNum>=5) {
			tempInt++;
		}else if(roundNum<= -5){
			tempInt--;
		}
		return tempInt/100.0;
	}
	public double calcVolume() {
		return round2(this.calcAreaOfBase()*height);
	}
	
	public double calcSA() {
		return round2(this.calcPerimeter()*height+this.calcAreaOfBase()*2);
	}		
}
	