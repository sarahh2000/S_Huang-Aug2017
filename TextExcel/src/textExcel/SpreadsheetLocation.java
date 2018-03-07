package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private char character;
    private int num;
    
    public int getRow()
    {
        return character-65;
    }

    public int getCol()
    {
       return num-1;
    }
    
    public SpreadsheetLocation(String place) {
    	character=place.charAt(0);
    	num=Integer.parseInt(place.substring(1));
    }

}
