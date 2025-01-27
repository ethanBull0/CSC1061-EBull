
public class Radio {
	private boolean hasAppleCarplay;
	private boolean hasAndroidAuto;
	private boolean hasFM;
	
	public Radio(boolean hasAppleCarplay, boolean hasAndroidAuto) {
		this.hasAndroidAuto = hasAndroidAuto;
		this.hasAppleCarplay = hasAppleCarplay;
	}

	@Override
	public String toString() {
		return "Radio [hasAppleCarplay=" + hasAppleCarplay + ", hasAndroidAuto=" + hasAndroidAuto + ", hasFM=" + hasFM
				+ "]";
	}

	public boolean isHasAppleCarplay() {
		return hasAppleCarplay;
	}

	public void setHasAppleCarplay(boolean hasAppleCarplay) {
		this.hasAppleCarplay = hasAppleCarplay;
	}

	public boolean isHasAndroidAuto() {
		return hasAndroidAuto;
	}

	public void setHasAndroidAuto(boolean hasAndroidAuto) {
		this.hasAndroidAuto = hasAndroidAuto;
	}
}
