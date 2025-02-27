
public class FeatureTest {
	public static void main(String[] args) {
		FlipModel horseRacer = new FlipModel(300, 3, 16000);
		FoldModel speedRacer = new FoldModel(800, 6, 64000);
		BarModel dragonSlayer = new BarModel(600, 8, 32);
		
		speedRacer.getImei().genUUID();
		horseRacer.getImei().genUUID();
		dragonSlayer.getImei().genUUID();
		
		System.out.println(speedRacer.getClass());
		speedRacer.getImei().printIMEI();
		System.out.println(horseRacer.getClass());
		horseRacer.getImei().printIMEI();
		System.out.println(dragonSlayer.getClass());
		dragonSlayer.getImei().printIMEI();
		
		System.out.println(speedRacer.toString());
		System.out.println(horseRacer.toString());
		System.out.println(dragonSlayer.toString());
		
		FoldModel speedRacerPlus = null;
		
		try {
			speedRacerPlus = ((FoldModel)speedRacer.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
