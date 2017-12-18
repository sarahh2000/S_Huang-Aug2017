package fracCalc;

public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;
	private int sign;


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
		if(this.numerator==0) {
			return this.whole+"";
		}else if(this.whole==0) {
			return numerator+"/"+denominator;
		}else {
			return whole+"_"+numerator+"/"+denominator;
		}

	}

	public void improperFrac() {
		numerator=absValue(whole*denominator+numerator)*sign;
		whole=0;
	}
	public String addSubtract(Fraction fraction2, String operator) {
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
		}
		return simplifyFrac(result);
	}
	public String multiplyDivide(Fraction fraction2, String operator) {
		//turn into improper fraction
		improperFrac();
		fraction2.improperFrac();
		Fraction result=new Fraction("0_0/1");
		//if it's divide, find the reciprocal of the second operand
		if(operator.equals("/")) {
			int temp=fraction2.numerator;
			fraction2.numerator=fraction2.denominator;
			fraction2.denominator=temp;
		}
		//do the math
		result.numerator=this.numerator*fraction2.numerator;
		result.denominator=this.denominator*fraction2.denominator;
		//to eliminate error, if there's a negative sign, put it on the top
		if((result.numerator<0&&result.denominator>0)||(result.numerator>0&&result.denominator<0)) {
			result.numerator=(-1)*absValue(this.numerator*fraction2.numerator);
			result.denominator=absValue(this.denominator*fraction2.denominator);
		}
		if(result.numerator==0||result.denominator==0) {
			return "0";
		}else {
			return simplifyFrac(result);
		}
	}
	public String simplifyFrac(Fraction result) {
		//find the gcf, and divide the numerator and the denominator by the gcf
		if (result.numerator==0) {
			return "0";
		}else {
			int greatestFactor=gcf(absValue(result.numerator), absValue(result.denominator));
			result.numerator/=greatestFactor;
			result.denominator/=greatestFactor;
			//if the numerator and the denominator are both negative, convert to positive
			if(result.numerator<0&&result.denominator<0) {
				result.numerator=absValue(result.numerator);
				result.denominator=absValue(result.denominator);
			}
			//if the numerator is divisible by the denominator, it is a whole number
			if(absValue(result.numerator)%absValue(result.denominator)==0) {
				result.whole=result.numerator/result.denominator;
				result.numerator=0;
				//if not, find the mixed number
			}else {
				if(absValue(result.numerator)>absValue(result.denominator)) {
					result.whole=result.numerator/result.denominator;
					result.numerator=absValue(result.numerator)-absValue(result.whole)*absValue(result.denominator);
				}
			}
		}
		return result.toString();
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
	public static int absValue(int operand) {
		if(operand>=0) {
			return operand;
		}else {
			return -operand;
		}
	}
}

