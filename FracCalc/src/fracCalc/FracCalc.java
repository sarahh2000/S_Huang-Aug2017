//Sarah Huang
//Nov 8 2017
//APCS2
//frac calc, parsing fractions

package fracCalc;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;

public class FracCalc {

    //gets data from the user and prints out the answer using a call to produceAnswer
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
   //parse the string and call a method to do math
	public static String produceAnswer(String input){
    	
    	//split the string by space to make an array of the operands and operators
		String [] inputArray=input.split(" ");
    	String result="";
    	//for loop that does math for the first three spaces, and then sets the result equal to the first space, then adds/subtracts/multiplies/divides the result to the next number
    	for (int i=2; i<inputArray.length;i+=2) {
    		
    		String firstOperand=inputArray[0];
        	String operator=inputArray[i-1];
        	String secondOperand=inputArray[i];
        	//turns the operands into arrays, and then perform math functions
        	int[] operand1Array=parseValues(firstOperand);
            int[] operand2Array=parseValues(secondOperand);
            if(operand1Array[2]==0||operand2Array[2]==0) {
            	result="ERROR: cannot divide by 0";
            	i=inputArray.length;
            }else if(!(operator.equals("+"))||!(operator.equals("-"))||!(operator.equals("*"))||!(operator.equals("/"))){
            	result="ERROR: Input is in an invalid format";
            	i=inputArray.length;
            }else {
            	if(operator.equals("+")||operator.equals("-")) {
                	if(firstOperand.equals("0")) {
                		if(operator.equals("+")) {
                			result=simplifyFrac(improperFrac(operand2Array));
                		}else {
                			result="-"+simplifyFrac(improperFrac(operand2Array));
                		}
                	}else if(secondOperand.equals("0")) {
                		result=simplifyFrac(improperFrac(operand1Array));
                	}else {
                		result=addSubtract(operand1Array, operand2Array, operator);
                	}
                	
                }else {
                	result=multiplyDivide(operand1Array, operand2Array, operator);
                }
                inputArray[0]=result;
            }
            
    	}
    	return result;
    	
	}      
    	
   //parse the operands into arrays 
    public static int[] parseValues(String input) {
    	String [] underscoreSplit=input.split("_");
    	String [] slashSplit=input.split("/");
    	String whole="0";
    	String numerator="0";
    	String denominator="1";
    	//case 1: mixed number
    	if(input.contains("_")==true&&input.contains("/")==true){
    		whole=underscoreSplit[0];
    		numerator=underscoreSplit[1].split("/")[0];
    		denominator=slashSplit[1];
    	//case 2: normal fraction 
    	}else if(input.contains("_")==false&&input.contains("/")==true) {
    		numerator=slashSplit[0];
    		denominator=slashSplit[1];
    	//case 3: only whole number
    	}else{
    		whole=input;
    	}
    	int[]parsedInputArray=new int[3];
    	//turn Strings into ints
    	parsedInputArray[0]=Integer.parseInt(whole);
    	parsedInputArray[1]=Integer.parseInt(numerator);
    	parsedInputArray[2]=Integer.parseInt(denominator);
    	return parsedInputArray;
    }
    //performs add/subtract
    public static String addSubtract(int[] operand1, int[] operand2, String operator) {
    	//turn into improper fraction
    	int [] improperFrac1=improperFrac(operand1);
    	int [] improperFrac2=improperFrac(operand2);
    	//find a common denominator by multiplying by the other denominator
    	int denominator1=improperFrac1[1];
    	int denominator2=improperFrac2[1];
    	improperFrac1[0]*=denominator2;
    	improperFrac1[1]*=denominator2;
    	improperFrac2[0]*=denominator1;
    	improperFrac2[1]*=denominator1;
    	int[] result= new int [2];
    	//do the math
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
    //does multiply/divide
    public static String multiplyDivide(int[] operand1, int[] operand2, String operator) {
    	//turn into improper fraction
    	int [] improperFrac1=improperFrac(operand1);
    	int [] improperFrac2=improperFrac(operand2);
    	
    	int[] result= new int [2];
    	//if it's divide, find the reciprocal of the second operand
    	if(operator.equals("/")) {
    		int temp=improperFrac2[0];
    		improperFrac2[0]=improperFrac2[1];
    		improperFrac2[1]=temp;
    	}
    	//do the math
    	result[0]=improperFrac1[0]*improperFrac2[0];
    	result[1]=improperFrac1[1]*improperFrac2[1];
    	//to eliminate error, if there's a negative sign, put it on the top
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
    //finds the greatest common factor
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
   //simplifies the fraction and converts to a mixed number when necessary
    public static String simplifyFrac(int[]improperFrac) {
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
    //converts to improper fraction
    public static int[] improperFrac(int[]fraction) {
    	int[]improper=new int[2];
    	improper[1]=absValue(fraction[2]);
    	//if the whole number is not 0
    	if(fraction[0]!=0) {
    		//if one of them is negative
    		if((fraction[0]<0&&fraction[1]>0)||(fraction[0]>0&&fraction[1]<0)) {
    			improper[0]=(-1)*(absValue(fraction[0])*absValue(fraction[2])+absValue(fraction[1]));
    		//if both are negative
    		}else if(fraction[0]<0&&fraction[1]<0){
    			improper[0]=absValue(fraction[0])*absValue(fraction[2])+absValue(fraction[1]);
    		//if both are positive
    		}else {
    			improper[0]=fraction[0]*fraction[2]+fraction[1];
    		}
    	//if the whole number is 0 and the numerator is not 0
    	}else if(fraction[0]==0&&fraction[1]!=0) {
    		//if one is negative
    		if((fraction[1]<0&&fraction[2]>0)||(fraction[1]>0&&fraction[2]<0)){
    			improper[0]=(-1)*absValue(fraction[1]);
    		//if both are negative
    		}else if(fraction[1]<0&&fraction[2]<0) {
    			improper[0]=absValue(fraction[1]);
    		//if both are positive
    		}else {
    			improper[0]=fraction[1];	
    		}    		
    	//if the whole number and numerator are 0
    	}else {
    		improper[0]=0;
    		improper[1]=1;
    	}
    	return improper;
    }
    //finds the absolute value 
    public static int absValue(int operand) {
		if(operand>=0) {
			return operand;
		}else {
			return -operand;
		}
	}
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
