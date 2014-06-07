package dotsPlacer;

public class DotThreeDee {
	private double x;
	private double y;
	private double z;
	
	public DotThreeDee(double[] coordIn){
		x = coordIn[0];
		y = coordIn[1];
		z = coordIn[2];
	}
	
	public double[] xyPlane(){
		double[] xyProj = new double[2];
		xyProj[0] = x;
		xyProj[1] = y;
		return xyProj;
	}
	
	public String projString(double thetaY, double phiY){
		double[] projCoords = polarProj(thetaY, phiY);
		String stringOut = "";
		for(double n:projCoords){
			stringOut += (int) n + " unit mul ";
		}
		stringOut += "lineto\n";
		return stringOut;
	}
	
	private double[] polarProj(double thetaY, double phiY){
		double[] proj = new double[2];
		double[] coord = {x,y,z};
		double[] xHat = {Math.cos(thetaY)*Math.sin(Math.PI/2 - phiY), Math.sin(thetaY)*Math.sin(Math.PI/2 - phiY), Math.cos(Math.PI/2 - phiY)};
		double[] yHat = {Math.cos(thetaY)*Math.sin(phiY), Math.sin(thetaY)*Math.sin(phiY), Math.cos(phiY)};
		double xPrime = dotProduct(xHat, coord);
		double yPrime = dotProduct(yHat, coord);
		proj[0] = xPrime;
		proj[1] = yPrime;
		return proj;
	}
	
	/*
	private double originDist(){
		double dist;
		dist = Math.sqrt(x*x + y*y + z*z);
		return dist;
	}
	*/
	
	private double dotProduct(double[] vect1, double[] vect2){
		double dotSum = 0;
		for(int i = 0; i < vect1.length; i++){
			dotSum += vect1[i]*vect2[i];
		}
		return dotSum;
	}
}
