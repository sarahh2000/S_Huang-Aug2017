//Sarah Huang
//Sept 27 2017
//responsible for all of the calculations for Quadratic Describer
public class Quadratic {
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
	//returns the larger of the values passed (2 values)
	public static double max(double value1,double value2) {
		if(value1>value2) {
			return value1;
		}else {
			return value2;
		}
	}	

	//finds the discriminant of the given quadratic equation
	public static double discriminant(double a,double b,double c) {
		return((b*b)+(-4)*a*c);
	}
	//rounds a double to the hundredths place
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
	//approximates the squareroot to 2 decimal places
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
	//calculates the roots of the quadratic
	public static String quadForm(double a,double b,double c) {
		double discriminant=discriminant(a,b,c);
		double result;
		if(discriminant<0) {
			return "No x-intercepts";
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
	//returns the direction of the quadratic
	public static String direction(double a) {
		if(a>0) {
			return "Opens: Up";
		}else if(a<0) {
			return "Opens:Down";
		}else {
			return "The graph is linear";
		}
	}
	//calculates the axis of symmetry
	public static String axisofsymmetry(double a,double b) {
		return "x= "+(-b)/(2*a);
	}
	//calculates the vertex of the quadratic
	public static String vertex(double a,double b,double c) {
		double vx;
		double vy;
		vx= (-b)/(2*a);
		vy= a*vx*vx+b*vx+c;
		return "Vertex: ("+vx+" , "+vy+")";
		}
	//calculates the x-ints of the quadratic
	public static String xInts(double a, double b, double c) {
		String quadform=quadForm(a,b,c);
		if(discriminant(a,b,c)<0) {
			return "X-intercepts: No x-intercepts";
		}else if(discriminant(a,b,c)==0){
			return "X-intercept: ("+quadform+", 0)";
		}else{
			String firstnumber=quadform.substring(0,quadform.indexOf("a")-1);
			String secondnumber=quadform.substring(quadform.indexOf("d")+2);
			return "X-intercepts: ("+firstnumber+", 0), ("+secondnumber+", 0)";
		}
	}
	//calculates the y-intercepts 
	public static String yInt(double c) {
		return "Y-intercepts: (0, "+c+")";
	}
}