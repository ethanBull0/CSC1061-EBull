import java.math.*;

public abstract class PhoneSpec implements Cloneable,Comparable<PhoneSpec> {
	private int cpuMHZ;
	private int cacheMB;
	private int storageMB;
	private IMEI imei;
	
	public PhoneSpec(int cpuMHZ, int cacheMB, int storageMB) {
		super();
		this.cpuMHZ = cpuMHZ;
		this.cacheMB = cacheMB;
		this.storageMB = storageMB;
		imei = new IMEI();
	}

	public String toString() {
		String string = "CPU Frequency: ";
			string += unitStringFormat(cpuMHZ);
			if (cpuMHZ > 1000) {
				string += "GHz,";
			} else {
				string += "MHz,";
			}
		string += " Cache: " + unitStringFormat(cacheMB);
		if (cacheMB > 1024) {
			string += "GB,";
		} else {
			string += "MB,";
		}
		string += " Storage: " + unitStringFormat(storageMB);
		if (storageMB > 1024) {
			string += "GB";
		} else if (storageMB > 1000000) {
			string += "TB";
		}
			else {
			string += "MB";
			}
		return string;
	}
	
	private String unitStringFormat(int i) {
		if (i > 1000) {
			return String.format("%.2f", (double) i/1000);
		}
		return String.valueOf(i);
	}
	
	public PhoneSpec clone() throws CloneNotSupportedException {
		PhoneSpec clone = (PhoneSpec) super.clone();
		IMEI imeiClone = new IMEI();
		clone.imei = imeiClone;
		clone.imei.genUUID();
		return clone;
		
	}
	
	
	@Override
	public int compareTo(PhoneSpec p) {
		int cacheDif = this.cacheMB - p.cacheMB;
		int storageDif = this.storageMB - p.storageMB;
		return cacheDif / storageDif; //weird implementation
	}
	
	
	
	public IMEI getImei() {
		return imei;
	}

	
}
