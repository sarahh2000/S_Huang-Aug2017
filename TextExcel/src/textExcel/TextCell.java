package textExcel;

public class TextCell implements Cell {
	private String cellText;
	public TextCell(String cellText) {
		this.cellText=cellText;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() { 
		if(cellText.length()<12) {
			String result=cellText.substring(1,cellText.length()-1);
			for(int i=0; i<(12-cellText.length());i++) {
				result+=" ";
			}
			return result;
		}else {
			return cellText.substring(1,11);
		}
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return cellText;
	}
}
