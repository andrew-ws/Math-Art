package udnswe;

import java.io.PrintWriter;

public class ThreeDeePattern {
	
	private PrintWriter writeTo;
	
	public ThreeDeePattern(PrintWriter writerIn) {
		writeTo = writerIn;
	}
	
	// drawPattern is a super cool method woo
	public void drawPattern() {
		writeTo.print("\n");
		writeTo.print("/design{\nnewpath\n10 neg unit 10 mul moveto\n");
		for(int j = 0; j<6; j++) {
			for(int i = 0; i<j; i++) {
				drawHexUp();
			}
			for(int i = 0; i<j; i++) {
				drawHexDown();
			}
			moveEast();
			moveSouth();
			moveEast();
		}
		writeTo.print("}def\ndesign\nstroke\n");
		writeTo.print("showpage\n%EOF");
	}
	
	private void drawHexUp() {
		writeTo.print("U W D E N U S W N E ");
	}
	
	private void drawHexDown() {
		writeTo.print("D E U W S D N E S W ");
	}
	
	private void moveDown() {
		writeTo.print("0 unit neg rmoveto ");
	}
	
	private void moveNorth() {
		writeTo.print("30 cos unit mul 30 sin unit mul rmoveto ");
	}
	
	private void moveUp() {
		writeTo.print("0 unit rmoveto ");
	}
	
	private void moveSouth() {
		writeTo.print("210 cos unit mul 210 sin unit mul rmoveto ");
	}
	
	private void moveWest() {
		writeTo.print("150 cos unit mul 150 sin unit mul rmoveto ");
	}
	
	private void moveEast() {
		writeTo.print("330 cos unit mul 330 sin unit mul rmoveto ");
	}
}