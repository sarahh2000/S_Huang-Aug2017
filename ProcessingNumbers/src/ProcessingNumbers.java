//Sarah Huang
//APCS2 
//Oct 4 2017
import java.util.*;
public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner userInput=new Scanner(System.in);
		boolean done=true;
		boolean isFirstNum=true;
		int nextNum;
		String completed;
		int min=0;
		int max=0;
		int sum=0;
		do {
			System.out.println("Type an integer.");
			nextNum=userInput.nextInt();
			System.out.println("Are you done yet? Type yes or no");
			completed=userInput.next(); 
			if(completed.equals("yes"))
				done=false;
			if(isFirstNum) {
				min=nextNum;
				max=nextNum;
				isFirstNum=false;
			}else{
				if(nextNum<min) {
					min=nextNum;
				}if(nextNum>max) {
					max=nextNum;
				}if(nextNum%2==0) {
					sum+=nextNum;
				}		
			}
		}while(done);
		System.out.println("The maximum is: "+max);
		System.out.println("The minimum is: "+min);
		System.out.println("The sum of all even numbers is: "+sum);
	}
}
