package dotsPlacer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DotPlacer {

	double thetaY;
	double phiY;
	PrintWriter postWrite = null;
	double[][] doubleArrayArray;
	
	public DotPlacer(double[][] doubleArrayArrayIn, double thetaYIn, double phiYIn, String fileName) {
		try {
			postWrite = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		thetaY = thetaYIn;
		phiY = phiYIn;
		doubleArrayArray = doubleArrayArrayIn;
		//postWrite.print("%%BoundingBox: 0 0 8.5 72 mul 11 72 mul\n\n72 4.25 mul 72 5.5 mul translate\n0.0 0.0 1.0 setrgbcolor\n1 setlinewidth\n1 setlinejoin\n1 setlinecap\n\nnewpath\n0 0 moveto\n");;
		//DotThreeDee[] dotArray = new DotThreeDee[doubleArrayArray.length];
		//for(int i=0; i<doubleArrayArray.length; i++){
		//	dotArray[i] = new DotThreeDee(doubleArrayArray[i]);
		//}
		//for(DotThreeDee current : dotArray){
		//	postWrite.print(current.projString(thetaY, phiY));
		//	postWrite.flush();
		//}
		//postWrite.print("stroke\nshowpage\n%EOF");
		//postWrite.close();
	}
	
	public void create(){
		postWrite.print("%%BoundingBox: 0 0 8.5 72 mul 11 72 mul\n\n72 4.25 mul 72 3 mul translate\n0.0 0.0 1.0 setrgbcolor\n1 setlinewidth\n1 setlinejoin\n1 setlinecap\n\n/unit 3 def\n\nnewpath\n0 0 moveto\n");;
		DotThreeDee[] dotArray = new DotThreeDee[doubleArrayArray.length];
		for(int i=0; i<doubleArrayArray.length; i++){
			dotArray[i] = new DotThreeDee(doubleArrayArray[i]);
		}
		for(DotThreeDee current : dotArray){
			postWrite.print(current.projString(thetaY, phiY));
			postWrite.flush();
		}
		postWrite.print("stroke\nshowpage\n%EOF");
		postWrite.close();
	}

}
