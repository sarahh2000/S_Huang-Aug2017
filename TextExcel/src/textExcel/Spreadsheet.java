//Sarah Huang
//March 7 2018
//Spreadsheet class

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private EmptyCell[][] cellArray;
	public Spreadsheet() {
		cellArray=new EmptyCell[20][12];
	}

	public String processCommand(String command)
	{
		return "";
	}

	public int getRows()
	{
		return 20;
	}

	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
