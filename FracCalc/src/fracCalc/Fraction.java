package fracCalc;

public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;
	private int sign;
	
	public static int absValue(int operand) {
		if(operand>=0) {
			return operand;
		}else {
			return -operand;
		}
	}

	
	public Fraction(String input) {
		String [] underscoreSplit=input.split("_");
    	String [] slashSplit=input.split("/");
    	whole=0;
    	numerator=0;
    	denominator=1;
    	if(input.contains("-")) {
    		sign=-1;
    	}else {
    		sign=1;
    	}
    	//case 1:  mixed numbers
    	if(input.contains("_")==true&&input.contains("/")==true){
    		whole=absValue(Integer.parseInt(underscoreSplit[0]));
    		numerator=Integer.parseInt(underscoreSplit[1].split("/")[0]);
    		denominator=Integer.parseInt(slashSplit[1]);
    	//case 2: normal fraction 
    	}else if(input.contains("_")==false&&input.contains("/")==true) {
    		numerator=Integer.parseInt(slashSplit[0]);
    		denominator=Integer.parseInt(slashSplit[1]);
    	//case 3: only whole number
    	}else{
    		whole=absValue(Integer.parseInt(input));
    	}
	}


	public int getNumerator() {
		return numerator;
	}


	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}


	public int getDenominator() {
		return denominator;
	}


	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}


	public int getWhole() {
		return whole;
	}


	public void setWhole(int whole) {
		this.whole = whole;
	}
	
	public String toString() {
		return "whole:"+whole+" numerator:"+numerator+" denominator:"+denominator;
	}
	
	public void improperFrac() {
		numerator=whole*denominator+numerator*sign;
		whole=0;
	}
	public void addSubtract(Fraction fraction2, String operator) {
		improperFrac();
		fraction2.improperFrac();
		Fraction result=new Fraction("0_0/1");
    	//find a common denominator by multiplying by the other denominator
    	int denominator1=this.denominator;
    	int denominator2=fraction2.denominator;
    	this.numerator*=denominator2;
    	this.denominator*=denominator2;
    	fraction2.numerator*=denominator1;
    	fraction2.denominator*=denominator1;
    	//do the math
    	if(operator.equals("+")) {
    		result.numerator=this.numerator+fraction2.numerator;
    	}else {
    		result.numerator=this.numerator-fraction2.numerator;
    	}
    	result.denominator=this.denominator;
    	if(result.numerator==0) {
    		result.whole=0;
    		result.numerator=0;
    		result.denominator=1;
    	}else {
    		return simplifyFrac(result); 	
    	}
    }
	public static String simplifyFrac() {
    	int whole=0;
    	int numerator=improperFrac[0];
    	int denominator=improperFrac[1];
    	//find the gcf, and divide the numerator and the denominator by the gcf
    	int greatestFactor=gcf(absValue(numerator), absValue(denominator));
		numerator/=greatestFactor;
		denominator/=greatestFactor;
		//if the numerator and the denominator are both negative, convert to positive
		if(numerator<0&&denominator<0) {
			numerator=absValue(numerator);
			denominator=absValue(denominator);
		}
		//if the numerator is divisible by the denominator, it is a whole number
		if(absValue(numerator)%absValue(denominator)==0) {
			return numerator+"";
		//if not, find the mixed number
		}else {
			if(absValue(numerator)>absValue(denominator)) {
				whole=numerator/denominator;
				numerator=absValue(numerator)-absValue(whole)*absValue(denominator);
   		
				return whole+"_"+numerator+"/"+denominator;
			}else {
				return numerator+"/"+denominator;

    		}
		}
    }
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
}

