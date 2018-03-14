//Sarah Huang
//March 7 2018
//Spreadsheet class

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray;
	public Spreadsheet() {
		cellArray=new EmptyCell[20][12];
	}

	public String processCommand(String command)
	{
		if(command.equals("clear")) {
			clear();
			return getGridText();

		/*if(command.length()==2||command.length()==3) {
			Location position=new SpreadsheetLocation(command);
			return inspectCell(position);
		}else if(command.contains("=")) {
			assignCell(command);
			return getGridText();
		}else if(command.equals("clear")) {
			clear();
			return getGridText();
		//clear cell
		}else if (command.contains("clear")&& command.length()>5){
			Location position=new SpreadsheetLocation(command.substring(6));
			clearCell(position);
			return getGridText();*/
		}else {
			return "";
		}
	}
	public String inspectCell(Location loc) {
		return getCell(loc).fullCellText();
	}
	public String assignCell(String input) {
		String[] assignment=input.split(" ");
		Location loc=new SpreadsheetLocation(assignment[0]);
		cellArray[loc.getRow()][loc.getCol()]=new TextCell(assignment[2]);
		return getGridText();
		
	}
	public String clear() {
		for (int i=0;i<cellArray.length;i++) {
			for (int j=0; j<cellArray[i].length;j++) {
				cellArray[i][j]=new EmptyCell();
			}
		}
		return getGridText();
	}
	public String clearCell(Location loc) {
		cellArray[loc.getRow()][loc.getCol()]=new EmptyCell();
		return getGridText();
	}

	public int getRows()
	{
		return 20;
	}

	public int getCols()
	{
		return 12;
	}

	public Cell getCell(Location loc)
	{
		return cellArray[loc.getRow()][loc.getCol()];
	}

	public String getGridText()
	{
		String result="";
		//top row header
		result+="  |";
		for (int i=65; i<=76;i++) {
			result+=(char)i;
			for(int j=0; j<9; j++) {
				result+=" ";
			}
			result+="|";
		}
		result+="\n";
		for(int k=1;k<=20;k++) {
			if(k<10) {
				result+=k+" ";
			}else {
				result+=k;
			}
			result+="|";
			for(int l=0;l<12;l++) {
				result+=cellArray[k-1][l].abbreviatedCellText();
				result+="|";
			}
			result+="/n";
		}
		return result;
	}

}
