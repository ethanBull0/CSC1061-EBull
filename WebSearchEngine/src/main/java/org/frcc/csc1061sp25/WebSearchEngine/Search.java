package main.java.org.frcc.csc1061sp25.WebSearchEngine;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.select.Elements;

public class Search {
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		WikiFetcher wf = new WikiFetcher();
		Index index = new Index();

		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);
		index.indexPage(url, paragraphs);

		// index.printIndex();

		url = "https://en.wikipedia.org/wiki/Programming_Language";
		paragraphs = wf.fetchWikipedia(url);
		index.indexPage(url, paragraphs);

		// index.printIndex();

		while (true) {
			System.out.println("Enter search term");
			String searchTerm = scn.nextLine();
			searchTerm = searchTerm.toLowerCase();
			System.out.println(index.get(searchTerm));
		}
	}

}
