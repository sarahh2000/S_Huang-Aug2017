//Sarah Huang
//March 19
//formula cell class
package textExcel;

public class FormulaCell extends RealCell{
	Spreadsheet grid;
	Cell [][] cellArray;
	//constructor for FormulaCell
	public FormulaCell(String cellText, Spreadsheet grid) {
		super(cellText);
		this.grid=grid;
		this.cellArray=grid.getCellArray();
	}
	

	public double getDoubleValue() {
		//split the string by space to make an array of the operands and operators
		String text=fullCellText().toLowerCase();
		String [] inputArray=text.split(" ");
		String result="";
		//for loop that does math for the first three spaces, and then sets the result equal to the first space, then adds/subtracts/multiplies/divides the result to the next number
		if(inputArray.length==3&&!(inputArray[1].equals("sum"))&&!(inputArray[1].equals("avg"))) {
			return Double.parseDouble(inputArray[1]);
		}else {
			if(inputArray[1].equals("sum")) {
				//uses the sum method described below
				return sum(inputArray[2]);
			}else if(inputArray[1].equals("avg")) {
				//gets the first range
				String range1=inputArray[2].substring(0,inputArray[2].indexOf("-"));
				//gets the second range
				String range2=inputArray[2].substring(inputArray[2].indexOf("-")+1);
				//makes a new location at the first range
				Location loc1=new SpreadsheetLocation(range1);
				//makes a location at the second range
				Location loc2=new SpreadsheetLocation(range2);
				//calculate the number of cells across
				int width=loc2.getCol()-loc1.getCol()+1;
				//calculate the number of cells down
				int height=loc2.getRow()-loc1.getRow()+1;
				//calculates total number of cells in the range
				int num=width*height;
				//if the range includes only 1 cell, return the sum only
				if(num==1) {
					return sum(inputArray[2]);
				//if the range is greater than 1 cell, return sum divided by the number of cells
				}else {
					return sum(inputArray[2])/num;
				}
				
			//not sum or average: normal computing
			}else {
				for (int i=3; i<inputArray.length-1;i+=2) {
					//convert cell gets the contents of the cell that is referenced
					String firstOperand=convertCell(inputArray[1]);
					String operator=inputArray[i-1];
					String secondOperand=convertCell(inputArray[i]);
				
					//add or subtract
					if(operator.equals("+")||operator.equals("-")) {
						//if one of them is 0
						if(firstOperand.equals("0")) {
							if(operator.equals("+")) {
								result=secondOperand;
							}else {
								result="-"+secondOperand;
							}
						}else if(secondOperand.equals("0")) {
							result=firstOperand;
							
						//use the method that adds/subtracts	
						}else {
							result=addSubtract(firstOperand, secondOperand, operator)+"";
						}
					//multiply or divide
					}else {
						result=multiplyDivide(firstOperand, secondOperand, operator)+"";
					}
					inputArray[1]=result;
				}
				return Double.parseDouble(result);
			}
		}

	}
	public double addSubtract(String firstOperand, String secondOperand, String operator) {
		double result;
		//add
		if(operator.equals("+")) {
			result=Double.parseDouble(firstOperand)+Double.parseDouble(secondOperand);
		//subtract
		}else {
			result=Double.parseDouble(firstOperand)-Double.parseDouble(secondOperand);
		}
		return result;
	}
	public double multiplyDivide(String firstOperand, String secondOperand, String operator) {
		double result;
		//multiply
		if(operator.equals("*")) {
			result=Double.parseDouble(firstOperand)*Double.parseDouble(secondOperand);
		//divide
		}else {
			result=Double.parseDouble(firstOperand)/Double.parseDouble(secondOperand);
		}
		return result;
	}
	//gets the contents of the cell at a given location
	public String convertCell(String input) {
		//gets the letter portion of the range
		String character=input.substring(0, 1).toUpperCase();
		//if it's an actual letter
		if(character.charAt(0)>=65&&character.charAt(0)<=76) {
			Location loc=new SpreadsheetLocation(input);
			//get the number if it's not an empty cell
			if(!(grid.getCell(loc) instanceof EmptyCell)){
				RealCell real=(RealCell)(grid.getCell(loc));
				return real.getDoubleValue()+"";
			//return 0 if it's an empty cell
			}else {
				return 0+"";
			}
		}else {
			return input;
		}
	}
	//sum method for sum of a cell range
	public double sum(String input) {
		//find ranges (before and after the hyphen)
		String range1=input.substring(0,input.indexOf("-"));
		String range2=input.substring(input.indexOf("-")+1);
		//make locations for each range
		Location loc1=new SpreadsheetLocation(range1);
		Location loc2=new SpreadsheetLocation(range2);
		double sum=0;
		//use of a nested for loop to traverse the 2d array that the range is in
		for(int i=loc1.getRow();i<=loc2.getRow();i++) {
			for(int j=loc1.getCol();j<=loc2.getCol();j++) {
				if(!(cellArray[i][j] instanceof EmptyCell)){
					//get the value of each cell in the range and add it to sum
					RealCell real=(RealCell)(cellArray[i][j]);
					sum+=real.getDoubleValue();
				}else {
					sum+=0;
				}
			}
		}
		return sum;
	}
	
}
