//Sarah Huang
//February 10
//APCS2
//Triangular Prism subclass

/* Write this concrete (non-abstract) class called TriangularPrism.  
 * It has 3 private fields (sideA, sideB, and sideC).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 * 
 * Math Note:
 * Perimeter refers to the perimeter of the base - the sum of all the sides.
 * To find the area of a triangle given 3 side lengths, look up Heron's formula.  
 * It uses half the perimeter.  (Why might you want to use 0.5 instead of 1/2?)
 */


public class TriangularPrism extends Prism{
	private double sideA;
	private double sideB;
	private double sideC;
	
	public TriangularPrism(double sideA, double sideB, double sideC, double height) {
		super(height);
		this.sideA=sideA;
		this.sideB=sideB;
		this.sideC=sideC;
	}
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
	public static double sqrt(double value) {
		if(value<0)throw new IllegalArgumentException ("cannot take a negative root");
		double var1=value;
		double squareroot=value/2.0;
			while((var1-squareroot)!=0) {
				var1=squareroot;
				squareroot=(var1+(value/var1))/2;
			}
			return round2(squareroot);
	}
	
	public double calcPerimeter() {
		return sideA+sideB+sideC;
	}
	public double calcAreaOfBase() {
		double s=0.5*calcPerimeter();
		return sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	}
}
