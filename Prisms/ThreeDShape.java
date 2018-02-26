//Sarah Huang
//February 25
//3d shape class
public class ThreeDShape {
	private double volume;
	private double surfaceArea;

	public ThreeDShape(){
		this.volume = calcVolume();
		this.surfaceArea = calcSA();
	}

	public double calcVolume(){
		return 0;
	}

	public double calcSA(){
		return 0;
	}
	public static double round2(double value) {
		int tempInt = (int) (value*1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt/10;
		if(roundNum>=5) {
			tempInt++;
		}else if(roundNum<= -5){
			tempInt--;
		}
		return tempInt/100.0;
	}
}

