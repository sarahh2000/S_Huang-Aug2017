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
    public static String parseValues(String input) {
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
    	return "whole:"+whole+" numerator:"+numerator+" denominator:"+denominator;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
