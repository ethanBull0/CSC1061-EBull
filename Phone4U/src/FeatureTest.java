
public class FeatureTest extends PhoneSpec {
	public static void main(String[] args) {
		FlipModel horseRacer = new FlipModel();
		FoldModel speedRacer = new FoldModel();
		BarModel dragonSlayer = new BarModel();
		
		speedRacer.getImei().printIMEI(null); //should return a usage message
		horseRacer.getImei().genUUID();
		speedRacer.getImei().genUUID();
		dragonSlayer.getImei().genUUID();
		
		
	}
}
