package math;

public class CGMath {

	
	public static double normalizeToRange(double x,double min,double max,double a,double b) {
		return a + x * (b - a) / (max - min);
	}
	
	
}
