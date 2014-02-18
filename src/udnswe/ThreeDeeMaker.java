package udnswe;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ThreeDeeMaker {
	public static void main(String[] args){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("udnsweGen.ps");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.print("%%BoundingBox: 0 0 512 512\n\n256 256 translate\n0.0 0.0 1.0 "
					+ "setrgbcolor\n\n0.0 setlinewidth\n1 setlinejoin\n1 setlinecap\n\n/unit 18 def\n"
					+ "/U{0 unit rlineto}def\n/D{0 unit neg rlineto}def\n/N{30 cos unit mul "
					+ "30 sin unit mul rlineto}def\n/S{210 cos unit mul 210 sin unit mul rlineto}def\n"
					+ "/E{330 cos unit mul 330 sin unit mul rlineto}def\n/W{150 cos unit mul 150 "
					+ "sin unit mul rlineto}def\n");
		ThreeDeePattern pattern = new ThreeDeePattern(writer);
		pattern.drawPattern();
		writer.close();
	}
}
