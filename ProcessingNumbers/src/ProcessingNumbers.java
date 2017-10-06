//Sarah Huang
//APCS2 
//Oct 4 2017
import java.util.*;
public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner userInput=new Scanner(System.in);
		boolean done=true;
		boolean isFirstNum=true;
		boolean isEvenNum=true;
		int nextNum;
		int largestEven=0;
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
			}if(!isFirstNum) {
				if(nextNum<min) {
					min=nextNum;
				}if(nextNum>max) {
					max=nextNum;
				}if(nextNum%2==0) {
					sum+=nextNum;
				}if(isEvenNum) {
					if(nextNum%2==0) {
					largestEven=nextNum;
					isEvenNum=false;
					}
				}if(nextNum>largestEven&&nextNum%2==0) {
					largestEven=nextNum;
				}
			}
		}while(done);
		System.out.println("The maximum is: "+max);
		System.out.println("The minimum is: "+min);
		System.out.println("The largest even number is: "+largestEven);
		System.out.println("The sum of all even numbers is: "+sum);
	}
}
