//Sarah Huang
//March 19
//formula cell class
package textExcel;

public class FormulaCell extends RealCell{
	Spreadsheet grid;
	public FormulaCell(String cellText) {
		super(cellText);
		this.grid=TextExcel.grid;
	}

	public double getDoubleValue() {
		//split the string by space to make an array of the operands and operators
		String text=fullCellText();
		String [] inputArray=text.split(" ");
		String result="";
		//for loop that does math for the first three spaces, and then sets the result equal to the first space, then adds/subtracts/multiplies/divides the result to the next number
		if(inputArray.length==3&&!(inputArray[1].equals("sum"))&&!(inputArray[1].equals("avg"))) {
			return Double.parseDouble(inputArray[1]);
		}else {
			if(inputArray[1].equals("sum")) {
				return sum(inputArray[2]);
			}else if(inputArray[1].equals("avg")) {
				String range=inputArray[2];
				int width=(range.charAt(range.indexOf("-")+1)-range.charAt(0)+1);
				int height=Integer.parseInt(range.substring(range.indexOf("-"+2)))-Integer.parseInt(range.substring(1, range.indexOf("-")))+1;
				int num=width*height;
				return sum(inputArray[2])/num;
			}else {
				for (int i=3; i<inputArray.length-1;i+=2) {
					String firstOperand=convertCell(inputArray[1]);
					String operator=inputArray[i-1];
					String secondOperand=convertCell(inputArray[i]);
				

					if(operator.equals("+")||operator.equals("-")) {
						if(firstOperand.equals("0")) {
							if(operator.equals("+")) {
								result=secondOperand;
							}else {
								result="-"+secondOperand;
							}
						}else if(secondOperand.equals("0")) {
							result=firstOperand;
						}else {
							result=addSubtract(firstOperand, secondOperand, operator)+"";
						}

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
		if(operator.equals("+")) {
			result=Double.parseDouble(firstOperand)+Double.parseDouble(secondOperand);
		}else {
			result=Double.parseDouble(firstOperand)-Double.parseDouble(secondOperand);
		}
		return result;
	}
	public double multiplyDivide(String firstOperand, String secondOperand, String operator) {
		double result;
		if(operator.equals("*")) {
			result=Double.parseDouble(firstOperand)*Double.parseDouble(secondOperand);
		}else {
			result=Double.parseDouble(firstOperand)/Double.parseDouble(secondOperand);
		}
		return result;
	}
	public String convertCell(String input) {
		String character=input.substring(0, 1).toUpperCase();
		if(character.charAt(0)>=65&&character.charAt(0)<=76) {
			Location loc=new SpreadsheetLocation(input);
			if(!(grid.getCell(loc) instanceof EmptyCell)){
				RealCell real=(RealCell)(grid.getCell(loc));
				return real.getDoubleValue()+"";
			}else {
				return 0+"";
			}
		}else {
			return input;
		}
	}
	public double sum(String input) {
		String range1=input.substring(0,input.indexOf("-"));
		String range2=input.substring(input.indexOf("-")+1);
		Location loc1=new SpreadsheetLocation(range1);
		Location loc2=new SpreadsheetLocation(range2);
		double sum=0;
		for(int i=loc1.getRow();i<=loc2.getRow();i++) {
			for(int j=loc1.getCol();j<=loc2.getCol();j++) {
				String location=(Character.toString((char)(j+65)))+i;
				Location finalloc=new SpreadsheetLocation (location);
				if(!(grid.getCell(finalloc) instanceof EmptyCell)){
					RealCell real=(RealCell)(grid.getCell(finalloc));
					sum+=real.getDoubleValue();
				}else {
					sum+=0;
				}
			}
		}
		return sum;
	}
}
