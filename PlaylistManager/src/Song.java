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
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		while (i != length) {
		//counter.schedule(newTimerTask(), (long) 1000);
		//counter.schedule(keyboardFuncsTask(counter), (long) 1000); //running too many times?
			
	        executor.scheduleAtFixedRate(newTimerTask(), 0, 1, TimeUnit.SECONDS); // Run every 2 seconds
	        executor.scheduleAtFixedRate(keyboardFuncsTask(executor), 0, 1, TimeUnit.SECONDS); // Run every 3 seconds, starting after 1 second
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
		executor.shutdown();
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
	
	private TimerTask keyboardFuncsTask(ScheduledExecutorService exec) {
		Scanner scan = new Scanner(System.in);
		return new TimerTask() {
			@Override
			public void run() {
				if (scan.nextLine().equals("S") || scan.nextLine().equals("s")) {
					i = length;
				} else if (scan.nextLine().equals("E") || scan.nextLine().equals("e")) {
					exec.shutdown();
				}
			}
		};
	}

	@Override
	public void run() {
		  if (i < length) {
			System.out.println(i / 60 + ":" + i % 60 + " " + length / 60 + ":" + length % 60);
		}
		i++;
	}
}
