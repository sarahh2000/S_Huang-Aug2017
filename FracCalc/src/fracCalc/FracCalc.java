//Sarah Huang
//Nov 8 2017
//APCS2
//fraccalc, parsing fractions

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput= new Scanner(System.in);
    	System.out.println("What is your input?");
    	String input=userInput.nextLine();
    	System.out.println(produceAnswer(input));
    	
    }
    
    public static String produceAnswer(String input){
    	String [] inputArray=input.split(" ");
    	String firstOperand=inputArray[0];
    	String operator=inputArray[1];
    	String secondOperand=inputArray[2];
   
        return secondOperand;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
