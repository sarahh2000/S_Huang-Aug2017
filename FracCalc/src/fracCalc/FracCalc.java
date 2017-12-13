package fracCalc;

import java.util.Scanner;

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
        Fraction fraction1= new Fraction(inputArray[0]);
        Fraction fraction2= new Fraction (inputArray[2]);
        
        
        return fraction2.toString();
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
