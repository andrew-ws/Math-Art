package dotsPlacer;

public class DotPanner {
	double theta;
	double phi;
	
	public DotPanner(){
		theta = 0;
		phi = 0;
	}
	
	public double[][] generate(int n){
		double [][] spherical = new double[n][2];
		for(int i = 0; i < n; i++){
			spherical[i][0] = theta;
			spherical[i][1] = phi;
			theta += 0.1;
		}
		return spherical;
	}
}
