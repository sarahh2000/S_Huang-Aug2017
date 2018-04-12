//Sarah Huang
//March 19
//Percent Cell class
package textExcel;

public class PercentCell extends ValueCell{
	private double decimal;
	//constructor for PercentCell
	public PercentCell(String cellText) {
		super(cellText);
		//sets the field equal to the decimal version of the percent
		decimal=Double.parseDouble(cellText.substring(0,cellText.length()-1));
		String percentDecimal=(decimal/100.0)+"";
		//changes the cell text field to be equal to the percent as a decimal
		setCellText(percentDecimal);
	}
	public String abbreviatedCellText() {
		String realDecimal=decimal+"";
		//truncates the decimal
		String realDecimalPart=realDecimal.substring(0,realDecimal.indexOf("."));
		String result=realDecimalPart;
		//if the truncated version of the percent is less than 9
		if(realDecimal.length()<9) {
			//add in the percent and then pad
			result+="%";
			for(int i=0; i<9-realDecimalPart.length();i++) {
				result+=" ";
			}
			return result;
		}else {
			return realDecimal.substring(0, 9)+"%";
		}
	
	}
}
