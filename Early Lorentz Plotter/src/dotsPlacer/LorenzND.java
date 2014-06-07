package dotsPlacer;

public class LorenzND {
	double step;
	double sigma;
	double roh;
	double beta;
	double x;
	double y;
	double z;
	
	public LorenzND(double stepIn, double sigmaIn, double rohIn, double betaIn, double x0, double y0, double z0){
		step = stepIn;
		sigma = sigmaIn;
		roh = rohIn;
		beta = betaIn;
		x = x0;
		y = y0;
		z = z0;
	}
	
	public double[][] eval(int n){
		double[][] doubleArrayArray = new double[n+1][3];
		for (int i = 0; i < n; i++){
			doubleArrayArray[i][0] = x;
			doubleArrayArray[i][1] = y;
			doubleArrayArray[i][2] = z;
			x += step * sigma * (y - x);
			y += step * (x * (roh - z) - y);
			z += step * (x * y - beta * z);
		}
		doubleArrayArray[n][0] = x;
		doubleArrayArray[n][1] = y;
		doubleArrayArray[n][2] = z;
		return doubleArrayArray;
	}
}
