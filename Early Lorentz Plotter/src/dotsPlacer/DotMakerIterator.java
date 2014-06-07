package dotsPlacer;

public class DotMakerIterator {
	public DotMakerIterator(double[][] doubleArrayArrayIn, double[][] panArrayArrayIn){
		double theta;
		double phi;
		DotPlacer placer;
		for(int i=0; i<panArrayArrayIn.length; i++){
			theta = panArrayArrayIn[i][0];
			phi = panArrayArrayIn[i][1];
			// TODO fix leading zeros
			placer = new DotPlacer(doubleArrayArrayIn, theta, phi, "dotPlace" + i + ".ps");
			placer.create();
		}
	}
}
