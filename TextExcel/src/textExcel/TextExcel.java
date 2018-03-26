//Sarah Huang
//March 7 2018
//Client code

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextExcel
{
	static Spreadsheet grid=new Spreadsheet();
	public static void main(String[] args)
	{
	    Scanner userInput=new Scanner(System.in);
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
