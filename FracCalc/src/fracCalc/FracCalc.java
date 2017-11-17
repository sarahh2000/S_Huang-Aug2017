//Sarah Huang
//Nov 8 2017
//APCS2
//fraccalc, parsing fractions

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
    	if(firstOperand.equals("")||secondOperand.equals("")) {
    		return "cannot compute";
    	}
    	else {
    		int[] operand1Array=parseValues(firstOperand);
        	int[] operand2Array=parseValues(secondOperand);
        	if(operator.equals("+")||operator.equals("-")) {
        		return addSubtract(operand1Array, operand2Array, operator);
        	}else {
        		return multiplyDivide(operand1Array, operand2Array, operator);
        	}
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
    	return result[0]+"/"+result[1]; 	
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
    	return result[0]+"/"+result[1];
    }
    
    public static int[] improperFrac(int[]fraction) {
    	int[]improper=new int[2];
    	if(fraction[0]!=0) {
    		improper[1]=fraction[2];
    		if(fraction[0]<0) {
    			improper[0]=(((-1)*fraction[0]*fraction[2])+fraction[1])*(-1);
    		}else {
    			improper[0]=fraction[0]*fraction[2]+fraction[1];
    		}
    	}else if(fraction[0]==0&&fraction[1]!=0) {
    		improper[0]=fraction[1];
    		improper[1]=fraction[2];
    	}else {
    		improper[0]=0;
    		improper[1]=1;
    	}
    	return improper;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
