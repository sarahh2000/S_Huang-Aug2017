//Sarah Huang
//February 25
//sphere class
public class Sphere extends ThreeDShape{
	private double radius;
	public Sphere(double radius) {
		super();
		this.radius=radius;
	}
	public double calcVolume() {
		return round2(4/3*3.1415926535*radius*radius*radius);
	}
	public double calcSA() {
		return round2(4*3.1415926535*radius*radius);
	}
}
