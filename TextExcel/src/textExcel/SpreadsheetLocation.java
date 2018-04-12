package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private char character;
    private int num;
    
    public int getRow()
    {
    	//bc array index
    	return num-1;
    }

    public int getCol()
    {
       //bc capital letters
    	return character-65;
    }
    //constructor for spreadsheet location
    public SpreadsheetLocation(String place) {
    	//change to uppercase
    	String letter=place.substring(0,1).toUpperCase();
    	character=letter.charAt(0);
    	num=Integer.parseInt(place.substring(1));
    }

}
