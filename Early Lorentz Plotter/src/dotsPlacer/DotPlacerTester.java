package dotsPlacer;

public class DotPlacerTester {

	public static void main(String[] args) {
		// passes a t range to the pan function producer and the ND function
		// producer which return double array arrays, based on string args
		LorenzND diff = new LorenzND(0.01, 30, 84, 8, 1, 2, 1);
		DotPanner pan = new DotPanner();
		// passes those to the iterator along with the t range though probably
		// could get this from either of the arrays
		new DotMakerIterator(diff.eval(10000), pan.generate(20));
	}

}
