//Sarah Huang
//Oct 9 2017
//handle interactions with the user for quadratic
import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		boolean done=true;
		while(done) {
			Scanner userInput= new Scanner(System.in); 
			System.out.print("a: ");
			double a=userInput.nextDouble();
			System.out.print("b: ");
			double b=userInput.nextDouble();
			System.out.print("c: ");
			double c=userInput.nextDouble();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String quit=userInput.next();
			if(quit.substring(0,1).equals("q")) {
				done=false;
			}
		}
	}
}
