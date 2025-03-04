
public class FlipModel extends PhoneSpec implements Repairable {

	
	public FlipModel(int cpuMHZ, int cacheMB, int storageMB) {
		super(cpuMHZ, cacheMB, storageMB);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String howToRepair() {
		// TODO Auto-generated method stub
		return "Unscrew the 2 bolts holding in the battery cover.\nUnscrew the one bolt holding in the hinge.\nUndo the battery connector using a pair of tweezers\n"
				+ "Undo the ribbon cable holding in the screen.\nTo remove the motherboard, remove the four screws holding it in.";
	}

	@Override
	public double costToRepair() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "FlipModel [howToRepair()=" + howToRepair() + ", costToRepair()=" + costToRepair() + ", "
				+ super.toString() + "]";
	}

}
