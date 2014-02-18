package udnswe;

import java.io.PrintWriter;

public class ThreeDeeRandomizer {
	
	private PrintWriter writeTo;
	
	public ThreeDeeRandomizer(PrintWriter writeIn) {
		writeTo = writeIn;
	}
	
	public void drawRandomPattern(int num) {
		writeTo.print("\n");
		writeTo.print("/design{\nnewpath\n10 neg unit 10 mul moveto\n");
		int dir;
		for(int i = 0; i < num; i++){
			dir = (int) (Math.random() * 6);
			switch (dir) {
			case 0: writeTo.print("U ");
			break;
			case 1: writeTo.print("D ");
			break;
			case 2: writeTo.print("N ");
			break;
			case 3: writeTo.print("S ");
			break;
			case 4: writeTo.print("E ");
			break;
			case 5: writeTo.print("W ");
			break;
			default: writeTo.print("oh crudsicles ");
			}
		}
		writeTo.print("}def\ndesign\nstroke\n");
		writeTo.print("showpage\n%EOF");
	}
}
