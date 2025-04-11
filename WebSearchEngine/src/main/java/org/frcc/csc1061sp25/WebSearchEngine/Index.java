package main.java.org.frcc.csc1061sp25.WebSearchEngine;

	import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.select.Elements;

import java.util.Map;

public class Index {
	
	private Map<String, Set<TermCounter>> index = new HashMap<>();
	
	public void add(String term, TermCounter tc) {
		Set<TermCounter> set = index.get(term);
		
		if (set == null) {
			set = new HashSet<>();
		}
		set.add(tc);
		index.put(term, set);
	}
	
	public String get(String term) {
		Set<TermCounter> set = index.get(term);
		if (set == null) {
			return "";
		}
		String str = "";
		for(TermCounter tc : set) {
			str += tc.getLabel() + "\n";
		}
		return str;
	}
	
	public void indexPage(String url, Elements paras) {
		TermCounter counter = new TermCounter(url);
		counter.processElements(paras);
		for (String term : counter.getKeySet()) {
			add(term, counter);
		}
	}
	
	public void printIndex() {
		for (String term : index.keySet()) {
			System.out.println(term);
			Set<TermCounter> set = index.get(term);
			for (TermCounter tc : set) {
				System.out.println("\t\t" + tc.getLabel());
			}
		}
	}
	
}
