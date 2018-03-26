//Sarah Huang
//March 19
//formula cell class
package textExcel;

public class FormulaCell extends RealCell{
	public FormulaCell(String cellText) {
		super(cellText);
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
				return 0;
			}else if(inputArray[1].equals("avg")) {
				return 0;
			}else {
				for(int k=1;k<inputArray.length;k+=2) {
					String character=inputArray[k].substring(0, 1).toUpperCase();
					if(character.charAt(0)>=65&&character.charAt(0)<=76) {
						//get cell
					}
				}

				for (int i=3; i<inputArray.length-1;i+=2) {
					String firstOperand=inputArray[1];
					String operator=inputArray[i-1];
					String secondOperand=inputArray[i];

					
					
				


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
}
