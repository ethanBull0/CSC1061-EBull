
public class FlipModel extends PhoneSpec implements Repairable {

	
	public FlipModel(int cpuMHZ, int cacheMB, int storageMB) {
		super(cpuMHZ, cacheMB, storageMB);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String howToRepair() {
		// TODO Auto-generated method stub
		return "flip";
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
