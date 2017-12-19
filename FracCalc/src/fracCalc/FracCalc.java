package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput= new Scanner(System.in);
    	boolean done=true;
    	//gets input from user
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
    
    //parses the input, turns it into the fraction, and does the math
    public static String produceAnswer(String input){ 
    	//get the different fractions and operator
    	String [] inputArray=input.split(" ");
    	String result="";
    	//makes the fractions
    	Fraction fraction1= new Fraction(inputArray[0]);
    	Fraction fraction2= new Fraction (inputArray[2]);
    	String operator=inputArray[1];
    	//do the math
    	if(operator.equals("+")||operator.equals("-")) {	
    		result=fraction1.addSubtract(fraction2, operator);

    	}else {
    		result=fraction1.multiplyDivide(fraction2, operator);
    	}
    	return result;
    }    
}
