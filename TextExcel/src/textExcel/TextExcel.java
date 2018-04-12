//Sarah Huang
//March 7 2018
//Client code

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextExcel
{
	public static void main(String[] args)
	{
	    //to gather data input
		Scanner userInput=new Scanner(System.in);
	    boolean done=true;
	    Spreadsheet grid=new Spreadsheet();
	    while(done) {
        	//reiterates input until the user says to quit
	    	String input=userInput.nextLine();
        	if(input.toLowerCase().equals("quit")){
        		done=false;
        	}else{
        		System.out.println(grid.processCommand(input));
        	}
	    }
	    
	}
}
