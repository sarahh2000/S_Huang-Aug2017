//Sarah Huang
//March 16 2018
//real cell class
package textExcel;

public class RealCell implements Cell{
	private String cellText;
	public RealCell(String cellText) {
		this.cellText=cellText;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String result=cellText;
		if(cellText.length()<10) {
			for(int i=0; i<10-cellText.length();i++) {
				result+=" ";
			}
			return result;
		}else {
			return cellText.substring(0, 10);
		}
	} 
	public String getCellText() {
		return cellText;
	}
	public void setCellText(String cellText) {
		this.cellText = cellText;
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return cellText;
	}
	public double getDoubleValue() {
		return Double.parseDouble(cellText);
	}

}
