import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Files will look like this
 * Artist: _____
 * Song Title: _____
 */
public class Main {

	public static void main(String[] args) {
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<Song>();
		int choice = 0;
		Scanner scn = new Scanner(System.in);

		while (choice != 10) {
			System.out.println("***Ethan's Playlist Manager***");
			System.out.println("Choose an option: ");
			System.out.println(
					"1.add\n2.remove\n3.import\n4.export\n5. view\n6.count\n7.play\n8.shuffle\n9.reverse\n10.quit");

			choice = scn.nextInt();
			while (choice < 1 && choice > 9) {
				choice = scn.nextInt();
			}

			flush(scn);
			switch (choice) {
			case 1:
				System.out.println("Song artist: ");
				String songArtist = scn.nextLine();
				System.out.println("Song title:");
				String songTitle = scn.nextLine();
				Song thisSong = new Song(songArtist, songTitle);
				playlist.add(thisSong);
				break;
			case 2:
				if (playlist.size() <= 1) {
					System.out.println("Contains one or less elements. Deleting...");
					playlist.clear();
				} else {
				char yourChoice = ' ';
				String selection = "";
				System.out.println("select index of song to remove");
				int index = scn.nextInt();
				try {
					Song delSong = playlist.get(index);
					System.out.println("are you sure you would like to delete " + delSong.getTitle() + " by "
							+ delSong.getArtist() + "? (y/n):");
						scn.nextLine();
						selection = scn.nextLine();
						yourChoice = selection.charAt(0); //?
					if (yourChoice == 'Y' || yourChoice == 'y') {
						playlist.remove(index);
					}
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				}
				break;
			case 3:
				System.out.println("Enter the filename of your playlist (include extension): ");
				String playlistString = scn.nextLine();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(playlistString));
					String line;
					Song importSong = new Song(null, null);
					while ((line = reader.readLine()) != null) {
						String lineImport = line.substring(line.indexOf(':') + 2);
						if (line.charAt(line.indexOf(":") - 1) == ('t')) { //!
							importSong.setArtist(lineImport);
						} else {
							importSong.setTitle(lineImport);
							playlist.add(importSong);
							importSong = new Song(null, null);
						}
					}
					reader.close();
				} catch (FileNotFoundException e) {
					System.out.println("Could not find file that matches " + playlistString);
				} catch (IOException e) {
					System.out.println("Failed to read from file");
				} catch (NullPointerException e) {
					System.out.println("NullPointerException - likely Song object was not intitialized");
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println("Out of bounds");
				}
				break;
			case 4:
				BufferedWriter writer = null;
				System.out.println("Enter desired name of your playlist: ");
				String playlistName = scn.nextLine();
				try {
					if (playlistName.substring(playlistName.length() - 4, playlistName.length()).equals(".txt")) {
						writer = new BufferedWriter(new FileWriter(playlistName));
					} else {
						writer = new BufferedWriter(new FileWriter(playlistName + ".txt"));
					}
					for (Song s : playlist) {
						writer.write("Artist: " + s.getArtist() + "\n");
						writer.write("Song Title: " + s.getTitle() + "\n");
					}
					writer.flush();
				} catch (IOException e) {

				}
				break;
			case 5:
				System.out.println("Your playlist currently looks like this: ");
				printPlaylist(playlist);
				break;
			case 6:
				try {
				int amount = playlist.count() + 1;
				if (playlist.size() == 1) {
					System.out.println(amount + " song");
				} else {
					System.out.println(amount + " songs");
				}
				} catch (NullPointerException e) {
					System.out.println("No songs");
				}
				break;
			case 7:
				for (Song s : playlist) {
					System.out.println("Playing " + s.getTitle() + " by " + s.getArtist() + ".");
					s.play();
				}
				break;
			case 8:
				playlist.shuffle();
				System.out.println("Shuffled playlist");
				break;
			case 9:
				playlist.reverse();
				System.out.println("Reversed playlist");
				break;
			case 10:
				System.exit(1);
				break;
			}
		}
	}

	public static void printPlaylist(List<Song> playlist) {
		for (Song s : playlist) {
			System.out.println("Artist: " + s.getArtist());
			System.out.println("Song Title: " + s.getTitle() + "\n");
		}
	}
	
	private static void flush(Scanner scn) {
		String flush = scn.nextLine();
	}
}
