package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private char character;
    private int num;
    
    public int getRow()
    {
        return num-1;
    }

    public int getCol()
    {
       return character-65;
    }
    
    public SpreadsheetLocation(String place) {
    	String letter=place.substring(0,1).toUpperCase();
    	character=letter.charAt(0);
    	num=Integer.parseInt(place.substring(1));
    }

}
