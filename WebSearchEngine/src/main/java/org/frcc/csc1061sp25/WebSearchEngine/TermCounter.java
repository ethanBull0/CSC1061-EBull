package main.java.org.frcc.csc1061sp25.WebSearchEngine;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;


public class TermCounter {

	private Map<String, Integer> map;
	private String url;
	
	public TermCounter(String url) {
		this.url = url;
		this.map = new HashMap<>();
	}
	
	public Set<String> getKeySet() {
		return map.keySet();
	}
	
	public String getLabel() {
		return url;
	}
	
	public void put(String term, int count) {
		map.put(term, count);
	}
	
	public void processElements(Elements paragraphs) {
		for (Node node : paragraphs) {
			processTree(node);
		}
	}
	
	public void processTree(Node root) {
		for (Node node : new WikiNodeIterable(root)) {
			if (node instanceof TextNode) {
				processText(((TextNode)node).text());
			}
		}
	}
	
	private void processText(String text) {
		String[] words = text.replace("\\pP", "").toLowerCase().split("\\s+"); //\\pP == all punctuation, \\s+ == one or more spaces (split every time there is 1+ spaces)
		for (String word : words) {
			incrementTermCount(word);
		}
	}
	
	public void incrementTermCount(String term) {
		Integer value = map.get(term);
		if (value == null) {
			map.put(term, 1);
		} else {
			map.put(term, value + 1);
		}
		
	}
	
	public void printCounts() {
		System.out.println(url);
		for (String key : map.keySet()) {
			int count = map.get(key);
			System.out.println(key + ", " + count);
		}
	}
	
	public static void main(String[] args) throws IOException {

		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.fetchWikipedia(url);
		TermCounter counter = new TermCounter(url);
		counter.processElements(paragraphs);
		counter.printCounts();
		
		
	}
}
