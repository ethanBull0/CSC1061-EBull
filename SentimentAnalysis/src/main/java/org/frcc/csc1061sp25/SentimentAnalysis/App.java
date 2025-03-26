package org.frcc.csc1061sp25.SentimentAnalysis;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
    	String fileName = "sentiments.txt";
    	System.out.println("Welcome to the sentiment analyzer! Add a text file named " + fileName + " of words in the format (Word,score) <-No parenthesis, split by a new line.");
    	System.out.println("If the file does not exist, I will create a new empty file named " + fileName);
    	File sentFile = new File(fileName);
    	try {
    		sentFile.createNewFile();
    	} catch (IOException e) {
    		System.out.println("Could not create " + fileName);
    	}
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        try {
        	//Pattern scorePattern = Pattern.compile("-?\\b([0-5])\\b"); //matches integer values -5 to 5, avoids bogus data
        	
        	/*Matcher matcher = null; */
        	FileReader wordRead = new FileReader(sentFile);
        	BufferedReader reader = new BufferedReader(wordRead); 
        	String thisLine = "";
			while ((thisLine = reader.readLine()) != null) {
	        	//matcher = scorePattern.matcher(thisLine);
	        	Integer score = Integer.parseInt(thisLine.substring(thisLine.length() - 2, thisLine.length()));
	        	if (!thisLine.contains(",")) {
	        		System.out.println("Ran into an import issue, stopped importing");
	        	}
	        	String word = thisLine.substring(0, thisLine.indexOf(','));
	        	words.put(word, score);
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Word register successfully initiated!");
        System.out.println("Enter your text: ");
        Scanner scn = new Scanner(System.in);
        String userSentence = scn.nextLine();
        String[] sentence = userSentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        System.out.println("Words: " + sentence.length);
        int sentiment = generateScore(sentence, words);
        System.out.println("Sentiment: " + sentiment);
        System.out.println("Overall: " + (sentiment / sentence.length));
        
        
    }
    
    public static int generateScore(String[] str, HashMap<String, Integer> words) {
    	int total = 0;
    	for (String s : str) {
    		if (words.containsKey(s)) {
    			if (words.get(s) >= 0) {
    				total += words.get(s);
    			} else {
    				total -= words.get(s);
    			}
    		}
    	}
    	return total;
    }
    
    
}
