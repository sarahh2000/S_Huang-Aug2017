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
	    Scanner userInput=new Scanner(System.in);
	    Spreadsheet grid=new Spreadsheet();
	    boolean done=true;
	    while(done) {
        	String input=userInput.nextLine();
        	if(input.equals("quit")){
        		done=false;
        	}else{
        		System.out.println(grid.processCommand(input));
        	}
	    }
	    
	}
}
