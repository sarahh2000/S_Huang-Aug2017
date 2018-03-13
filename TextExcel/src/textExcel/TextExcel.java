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
	    while (!(userInput.nextLine().toLowerCase().equals("quit"))){
	    	String command=userInput.nextLine();
	    	System.out.println(grid.processCommand(command));
	    }
	    
	}
}
