//Sarah Huang
//Oct 9 2017
//handle interactions with the user for quadratic
import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		boolean done=true;
		while(done) {
			Scanner userInput= new Scanner(System.in); 
			System.out.println("Type in the coefficient in front of x^2.");
			double a=userInput.nextDouble();
			System.out.println("Type in the coeffcient in front of x.");
			double b=userInput.nextDouble();
			System.out.println("Type in the last coefficient (the constant).");
			double c=userInput.nextDouble();
			System.out.println(Quadratic.direction(a));
			System.out.println(Quadratic.axisofsymmetry(a, b));
			System.out.println(Quadratic.vertex(a, b, c));
			System.out.println(Quadratic.xInts(a, b, c));
			System.out.println(Quadratic.yInt(c));
			System.out.println("Are you done yet? If yes, type \"quit\". If no, type \"no\".");
			String quit=userInput.next();
			if(quit.substring(0,1).equals("q")) {
				done=false;
			}
		}
	}
}
