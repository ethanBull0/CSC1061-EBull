import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.random.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Song extends TimerTask {

	private Random rand = new Random();
	private int i = 0;
	private String artist;
	private String title;
	private int length;
	
	public Song(String artist, String title) {
		super();
		this.artist = artist;
		this.title = title;
		length = rand.nextInt(300); //any time between 0 and 500 seconds
	}
	
	public Song() {
		
	}

	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
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
		if (length == 0) {
			System.out.println("Length appears not to be intialized!");
		}
		Timer counter = new Timer();
		while (i != length) {
		counter.schedule(newTimerTask(), (long) 1000);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
		counter.cancel();
	}
	
	private TimerTask newTimerTask() {
		return new TimerTask() {
			@Override
			public void run() {
				if (i < length) {
					System.out.println(i / 60 + ":" + i % 60 + " " + length / 60 + ":" + length % 60);
				}
				i++;
			}
		};
	}


	@Override
	public void run() {
		  if (i < length) {
			System.out.println(i / 60 + ":" + i % 60 + " " + length / 60 + ":" + length % 60);
		}
		//i++;
	}
}
