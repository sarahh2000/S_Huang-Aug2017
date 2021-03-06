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
		if(dividend==0) throw new IllegalArgumentException("cannot divide by 0");
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
		return max(max(value1,value2),max(value1,value3));
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
	
	//raises a value to a positive integer power
	public static double exponent(double base, int power) {
		if(power<0)throw new IllegalArgumentException("negative power doesn't work for this algorithm");
		double result=base;
		if(power==0&&base!=0) {
			return 1;
		}else if(base==0) {
			return 0;
		}else if(power>0){
			for(int i=1; i<power;i++) {
				result=result*base;
			}
		}
		return result;		
	}
	
	//returns factorial of the value passed
	public static int factorial (int value) {
		if(value<0) throw new IllegalArgumentException ("cannot have negative factorial");
		if(value==0) {
			return 1;
		}else {
			int result=value;
			while ((value-1)>0) {
				result=result*(value-1);
				value=value-1;
			}
		return result;
		}
	}

	
	//determines whether or not an integer is prime
	public static boolean isPrime(int value) {
		int dividend=2;
		while(Calculate.isDivisibleBy(value,dividend)!=true) {
			dividend++;
		}
		if (dividend==value) {
			return true;
		}else {
			return false;
		}
		
	}
	//finds the greatest common factor of two integers
	//use euclidian algorithm
	public static int gcf(int value1, int value2) {
		if(value1==0||value2==0) {
			return 0;}
		while (value2!=0) {
			if (value1>value2) {
				value1=value1-value2;
			}else {
				value2=value2-value1;
			}
		}
		return value1;
	}
	//approximation of the square root
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
	
	//uses the coefficients of a quadratic formula in standard form to approximate real roots
	public static String quadForm(int a,int b,int c) {
		double discriminant=discriminant(a,b,c);
		double result;
		if(discriminant<0) {
			return "no real roots";
		}else if(discriminant==0) {
			result= (-b)/(2*a);
			return round2(result)+"";
		}else {
			double root1=((-b)+sqrt(discriminant))/(2*a);
			double root2=((-b)-sqrt(discriminant))/(2*a);
			double smallerNumber=min(root1,root2);
			double largerNumber=max(root1,root2);
			return round2(smallerNumber)+" and "+round2(largerNumber);
		}
	}

	//double version of min for use in quadform
	public static double min(double root1, double root2) {
		if(root1<root2) {
			return root1;
		}
		if(root2<root1) {
			return root2;
		}else {
			return root1;
	}

	}
		
}


