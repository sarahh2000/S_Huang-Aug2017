//Sarah Huang
//Nov 8 2017
//APCS2
//frac calc, parsing fractions

package fracCalc;
import java.util.*;
import java.util.Arrays;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput= new Scanner(System.in);
    	boolean done=true;
    	while(done) {
    		System.out.println("What is your input?");
        	String input=userInput.nextLine();
        	if(input.equals("quit")){
        		done=false;
        	}
        	else{
        		System.out.println(produceAnswer(input));
        	}
        	
    	}
    }
    public static String produceAnswer(String input){
    	
    	String [] inputArray=input.split(" ");
    	String firstOperand=inputArray[0];
    	String operator=inputArray[1];
    	String secondOperand=inputArray[2];
    	int[] operand1Array=parseValues(firstOperand);
        int[] operand2Array=parseValues(secondOperand);
        if(operator.equals("+")||operator.equals("-")) {
        	if(firstOperand.equals("0")) {
        		if(operator.equals("+")) {
        			return simplifyFrac(improperFrac(operand2Array));
        		}else {
        			return "-"+simplifyFrac(improperFrac(operand2Array));
        		}
        	}else if(secondOperand.equals("0")) {
        		return simplifyFrac(improperFrac(operand1Array));
        	}else {
        		return addSubtract(operand1Array, operand2Array, operator);
        	}
        	
        }else {
        	return multiplyDivide(operand1Array, operand2Array, operator);
        	
        }
    }
        
    	
    
    public static int[] parseValues(String input) {
    	String [] underscoreSplit=input.split("_");
    	String [] slashSplit=input.split("/");
    	String whole="0";
    	String numerator="0";
    	String denominator="1";
    	if(input.contains("_")==true&&input.contains("/")==true){
    		whole=underscoreSplit[0];
    		numerator=underscoreSplit[1].split("/")[0];
    		denominator=slashSplit[1];
    	}else if(input.contains("_")==false&&input.contains("/")==true) {
    		numerator=slashSplit[0];
    		denominator=slashSplit[1];
    	}else{
    		whole=input;
    	}
    	int[]parsedInputArray=new int[3];
    	parsedInputArray[0]=Integer.parseInt(whole);
    	parsedInputArray[1]=Integer.parseInt(numerator);
    	parsedInputArray[2]=Integer.parseInt(denominator);
    	return parsedInputArray;
    }
    public static String addSubtract(int[] operand1, int[] operand2, String operator) {
    	int [] improperFrac1=improperFrac(operand1);
    	int [] improperFrac2=improperFrac(operand2);
    	int denominator1=improperFrac1[1];
    	int denominator2=improperFrac2[1];
    	improperFrac1[0]*=denominator2;
    	improperFrac1[1]*=denominator2;
    	improperFrac2[0]*=denominator1;
    	improperFrac2[1]*=denominator1;
    	int[] result= new int [2];
    	if(operator.equals("+")) {
    		result[0]=improperFrac1[0]+improperFrac2[0];
    	}else {
    		result[0]=improperFrac1[0]-improperFrac2[0];
    	}
    	result[1]=improperFrac1[1];
    	if(result[0]==0) {
    		return "0";
    	}else {
    		return simplifyFrac(result); 	
    	}
    }
    
    public static String multiplyDivide(int[] operand1, int[] operand2, String operator) {
    	int [] improperFrac1=improperFrac(operand1);
    	int [] improperFrac2=improperFrac(operand2);
    	
    	int[] result= new int [2];
    	if(operator.equals("/")) {
    		int temp=improperFrac2[0];
    		improperFrac2[0]=improperFrac2[1];
    		improperFrac2[1]=temp;
    	}
    	result[0]=improperFrac1[0]*improperFrac2[0];
    	result[1]=improperFrac1[1]*improperFrac2[1];
    	if((result[0]<0&&result[1]>0)||(result[0]>0&&result[1]<0)) {
    		result[0]=(-1)*absValue(improperFrac1[0]*improperFrac2[0]);
    		result[1]=absValue(improperFrac1[1]*improperFrac2[1]);
    	}
    	if(result[0]==0||result[1]==0) {
    		return "0";
    	}else {
    		return simplifyFrac(result);
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
   
    public static String simplifyFrac(int[]improperFrac) {
    	int whole=0;
    	int numerator=improperFrac[0];
    	int denominator=improperFrac[1];
    	int greatestFactor=gcf(absValue(numerator), absValue(denominator));
		numerator/=greatestFactor;
		denominator/=greatestFactor;
		if(numerator<0&&denominator<0) {
			numerator=absValue(numerator);
			denominator=absValue(denominator);
		}
		if(absValue(numerator)%absValue(denominator)==0) {
			return numerator+"";
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
    public static int[] improperFrac(int[]fraction) {
    	int[]improper=new int[2];
    	improper[1]=absValue(fraction[2]);
    	if(fraction[0]!=0) {
    		if((fraction[0]<0&&fraction[1]>0)||(fraction[0]>0&&fraction[1]<0)) {
    			improper[0]=(-1)*(absValue(fraction[0])*absValue(fraction[2])+absValue(fraction[1]));
    		}else if(fraction[0]<0&&fraction[1]<0){
    			improper[0]=absValue(fraction[0])*absValue(fraction[2])+absValue(fraction[1]);
    		}else {
    			improper[0]=fraction[0]*fraction[2]+fraction[1];
    		}
    	}else if(fraction[0]==0&&fraction[1]!=0) {
    		if((fraction[1]<0&&fraction[2]>0)||(fraction[1]>0&&fraction[2]<0)){
    			improper[0]=(-1)*absValue(fraction[1]);
    		}else if(fraction[1]<0&&fraction[2]<0) {
    			improper[0]=absValue(fraction[1]);
    		}else {
    			improper[0]=fraction[1];	
    		}    		
    	}else {
    		improper[0]=0;
    		improper[1]=1;
    	}
    	return improper;
    }
    
    public static int absValue(int operand) {
		if(operand>=0) {
			return operand;
		}else {
			return -operand;
		}
	}
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
