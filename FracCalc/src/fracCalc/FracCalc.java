//Sarah Huang
//Nov 8 2017
//APCS2
//fraccalc, parsing fractions

package fracCalc;
import java.util.*;

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
    	parseValues(firstOperand);
    	return parseValues(secondOperand);
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
    	commonDenominator(improperFrac(operand1), improperFrac(operand2));
    	//finish
    	
    }
    public static int[] improperFrac(int[]fraction) {
    	int[]improper=new int[2];
    	if(fraction[0]!=0) {
    		improper[1]=fraction[2];
    		if(fraction[0]<0) {
    			improper[0]=(-1)*fraction[0]*fraction[2]+fraction[1];
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
    public static void commonDenominator(int[]operand1, int[] operand2) {
    	int denominator1=operand1[1];
    	int denominator2=operand2[2];
    	operand1[0]*=denominator2;
    	operand1[1]*=denominator2;
    	operand2[0]*=denominator1;
    	operand2[1]*=denominator1;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
