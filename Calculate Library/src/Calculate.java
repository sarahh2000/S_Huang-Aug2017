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
	public static double average(double operand1,double operand2,double operand3) {
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
	public static double discriminant(double a,double b,double c) {
		return((b*b)+(-4)*a*c);
	}
	
	//converts a mixed number into an improper fraction
	public static String toImproperFrac(int wholeNumber,int numerator,int denominator) {
		int newNumerator=(wholeNumber*denominator)+numerator;
				return(newNumerator+"/"+denominator);
	}
	
	//converts improper fraction to a mixed number
	public static String toMixedNum(int numerator,int denominator) {
		int wholeNumber=numerator/denominator;
		int newNumerator=numerator-wholeNumber*denominator;
		return(wholeNumber+"_"+newNumerator+"/"+denominator);
	}
	
	//converts a binomial multiplication into a quadratic formula
	public static String foil(int a,int b,int c,int d,String n) {
		return(a*c+"n^2"+"+"+(a*d+b*c)+"n"+"+"+b*d);
	}
	
	//determines whether or not one integer is evenly divisible by another
	public static boolean isDivisibleBy(int divisor,int dividend) {
		if (divisor%dividend==0) {
			return true;
		}else {
			return false;
		}
	}
	
	//returns the absolute value of a number
	public static double absValue(double operand) {
		if(operand>=0) {
			return operand;
		}else {
			return -operand;
		}
	}
	
	//returns the larger of the values passed (2 values)
	public static double max(double value1,double value2) {
		if(value1>value2) {
			return value1;
		}else {
			return value2;
		}
	}
	
	//returns the larger of the values passed (3 values)
	public static double max(double value1,double value2,double value3) {
		if(value1>value2&&value1>value3) {
			return value1;
			}
		if(value2>value1&&value2>value3) {
			return value2;
			}
		if(value3>value1&&value3>value2) {
			return value3;
			}
		if(value2==value1&&value1>value3) {
			return value1;
			}
		if(value1==value3&&value3>value2) {
			return value1;
			}
		if(value2==value3&&value2>value1) {
			return value3;
		}
		else {
			return value1;
		}
	}
	
	//returns the smaller of the values passed (2 integers)
	public static int min(int value1,int value2) {
		if(value1<value2) {
			return value1;
		}
		if(value2<value1) {
			return value2;
		}else {
			return value1;
		}
	}
	
	//rounds a double correctly to 2 decimal places
	public static double round2(double value) {
		double times100=value*100;
		int roundedtimes100=(int)times100;
		double new100=(double)roundedtimes100/100.0;
		if(value-new100<0.005) {
			return new100;
		}else {
			return new100+0.01;
		}
	}
}



