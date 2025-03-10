import java.util.Timer;
import java.util.TimerTask;

public class Song {

	private TimerTask interval;
	private String artist;
	private String title;
	private int length;
	
	public Song(String artist, String title) {
		super();
		this.artist = artist;
		this.title = title;
	}
	
	public int getLength() {
		return length;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void play() {
		Timer counter = new Timer();
		counter.schedule(interval, (long) 1000);
		System.out.println("Playing " + getTitle() + " by " + getArtist());
	}
}
