
public class BarModel extends PhoneSpec implements Repairable {

	public BarModel(int cpuMHZ, int cacheMB, int storageMB) {
		super(cpuMHZ, cacheMB, storageMB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String howToRepair() {
		// TODO Auto-generated method stub
		return "Remove the back cover by gently heating the surface up with a heat gun, then using suction to remove it.\nRemove the ribbon cable to remove the screen.";
	}

	@Override
	public double costToRepair() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "BarModel [howToRepair()=" + howToRepair() + ", costToRepair()=" + costToRepair() + ", "
				+ super.toString() + "]";
	}

}
