package org.frcc.csc1061sp25.SentimentAnalysis;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
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
    	File sentFile = new File(fileName);
    	//try {
    	//	sentFile.createNewFile();
    	//} catch (IOException e) {
    	//	System.out.println("Could not create " + fileName);
    	//}
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        int choice = 0;
        try {
        	//Pattern scorePattern = Pattern.compile("-?\\b([0-5])\\b"); //matches integer values -5 to 5, avoids bogus data
        	
        	/*Matcher matcher = null; */
        	FileReader wordRead = new FileReader(sentFile);
        	BufferedReader reader = new BufferedReader(wordRead); 
        	String thisLine = reader.readLine();
        	Integer score = 0;
			while (thisLine != null) {
	        	//matcher = scorePattern.matcher(thisLine);
				if (thisLine.charAt(thisLine.length() - 2) == '-') {
					 score = Integer.parseInt(thisLine.substring(thisLine.length() - 2, thisLine.length()));
				} else {
					score = Integer.parseInt(thisLine.substring(thisLine.length() - 1, thisLine.length()));
				}
					String word = thisLine.substring(0, thisLine.indexOf(','));
		        	words.put(word, score);
					 
				
       	        	if (!thisLine.contains(",")) {
	        		System.out.println("Ran into an import issue, stopped importing");
	        	}
	        	
	        	thisLine = reader.readLine();
	        }
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Word register successfully initiated!");
        System.out.println("Would you like to\n1)Add a word to the dictionary\n2)Evaluate a word\n3)Exit");
        choice = new Scanner(System.in).nextInt();
        while (choice != 3) {
	        if (choice == 1) {
	        	System.out.println("Enter your word: ");
	        		String wordChoice = new Scanner(System.in).nextLine();
	        	System.out.println("Enter your word's rating on a scale of -5 to 5");
	        	int scoreChoice = 0;
	        	while (scoreChoice >= -5 || scoreChoice <= 5) {
	        	scoreChoice = new Scanner(System.in).nextInt();
	        	words.put(wordChoice, scoreChoice);
	        	}
	        } else if (choice == 2) {
	        System.out.println("Enter your text: ");
	        Scanner scn = new Scanner(System.in);
	        String userSentence = scn.nextLine();
	        String[] sentence = userSentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
	        System.out.println("Words: " + sentence.length);
	        int sentiment = generateScore(sentence, words);
	        System.out.println("Sentiment: " + sentiment);
	        double overallScore = sentiment / sentence.length;
	        System.out.printf("Overall: %.2f", overallScore);
	        } else if (choice == 3) {
	        	System.exit(1);
	        } else {}
        }
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
