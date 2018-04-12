//Sarah Huang
//March 7 2018
//Spreadsheet class

package textExcel;



public class Spreadsheet implements Grid
{
	private Cell[][] cellArray;
	//constructor for spreadsheet
	public Spreadsheet() {
		//make an array of cells
		cellArray=new Cell[20][12];
		for(int i=0;i<cellArray.length;i++) {
			for (int j=0;j<cellArray[i].length;j++) {
				//fill all with empty cells
				cellArray[i][j]=new EmptyCell();
			}
		}
	}

	public String processCommand(String command)
	{
		if(command.toLowerCase().equals("clear")) {
			//use clear method to clear all
			clear();
			return getGridText();
		}else if(command.contains("=")) {
			//assign cell if there is an equals sign
			assignCell(command);
			return getGridText();
		}else if(command.length()==2||command.length()==3) {
			//if there is only a location specified
			Location position=new SpreadsheetLocation(command);
			return inspectCell(position);
		//clear cell
		}else if (command.toLowerCase().contains("clear")&& command.length()>5){
			Location position=new SpreadsheetLocation(command.substring(6));
			clearCell(position);
			return getGridText();
		}else {
			return "";
		}
	}
	public String inspectCell(Location loc) {
		return getCell(loc).fullCellText();
	}
	public String assignCell(String input) {
		//split into 2 by the first time the equals appears
		String[] assignment=input.split("=", 2);
		Location loc=new SpreadsheetLocation(assignment[0].substring(0,assignment[0].indexOf(" ")));
		//if there are quotes it is a text cell
		if(assignment[1].contains("\"")) {
			cellArray[loc.getRow()][loc.getCol()]=new TextCell(assignment[1].substring(1));
		//if there are parentheses it is a formula
		}else if(assignment[1].contains("(")&&assignment[1].contains(")")){
			cellArray[loc.getRow()][loc.getCol()]=new FormulaCell(assignment[1].substring(1), this);
		//if it has a percent it is a percent cell
		}else if(assignment[1].contains("%")) {
			cellArray[loc.getRow()][loc.getCol()]=new PercentCell(assignment[1].substring(1));
		//all other cases are value cells
		}else {
			cellArray[loc.getRow()][loc.getCol()]=new ValueCell(assignment[1].substring(1));
		}
		
		return getGridText();
		
	}
	public String clear() {
		for (int i=0;i<cellArray.length;i++) {
			for (int j=0; j<cellArray[i].length;j++) {
				//change to all to empty cells
				cellArray[i][j]=new EmptyCell();
			}
		}
		return getGridText();
	}
	public String clearCell(Location loc) {
		//change the location to an empty cell
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
		result+="   |";
		for (int i=65; i<=76;i++) {
			result+=(char)i;
			for(int j=0; j<9; j++) {
				result+=" ";
			}
			result+="|";
		}
		result+="\n";
		//row labels
		for(int k=1;k<=20;k++) {
			if(k<10) {
				result+=k+"  ";
			}else {
				result+=k+" ";
			}
			result+="|";
			//put in abbreviated cell text
			for(int l=0;l<12;l++) {
				result+=cellArray[k-1][l].abbreviatedCellText();
				result+="|";
			}
			result+="\n";
		}
		return result;
	}

	public Cell[][] getCellArray() {
		return cellArray;
	}

	

}
