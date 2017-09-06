/*Sarah Huang
 * Sept 6 2017
 * Self written math library, has a series of methods to do basic math functions
 */
public class Calculate {
	
	//squares the input
	public static int square(int operand) {
		return operand*operand;
	}
		
	//cubes the input
	public static int cube(int operand) {
		return operand*operand*operand;
	}
	
	//averages two values
	public static double average(double operand1,double operand2) {
		return (operand1+operand2)/2;
	}
	
	//averages three values
	public static double average(double operand1, double operand2, double operand3) {
		return (operand1+operand2+operand3)/3;
	}
	
	//converts an angle measure in radians into degrees
	public static double toDegrees(double radian) {
		return(radian/3.14159*180);
	}
	
	//converts an an angle measure in degrees into radians
	public static double toRadians(double degree) {
		return(degree*3.14159/180);
	}
	
	//provides the coefficients of a quadratic value in standard form and returns the discriminant
	public static double discriminant(double a, double b, double c) {
		return((b*b)+(-4)*a*c);
	}
	
	//converts a mixed number into an improper fraction
	public static double toImproperFrac(int wholeNumber,int numerator,int denominator) {
		double newNumerator=(wholenumber*denominator)+numerator;
		//fix string double
		return String(newNumerator/denominator);
	}
	
}


