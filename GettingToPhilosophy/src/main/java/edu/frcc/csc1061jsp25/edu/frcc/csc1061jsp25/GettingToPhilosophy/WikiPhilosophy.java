package edu.frcc.csc1061jsp25.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.StringUtils;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	System.out.println("Hello!");
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
    	if (source.equals(destination)) {
    		System.out.println("Found philosophy! Woot!");
    		System.exit(1);
    	}
        Document doc = null;
        Connection conn = Jsoup.connect(source);
        try 
        {
            doc = conn.get();
        }
        catch (Exception e)
        {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");

        for (Element para : paragraphs) {
        	int parenLevel = 0;
            Iterable<Node> iter = new WikiNodeIterable(para);

            for (Node node : iter) {
            	String useMe = "https://en.wikipedia.org";
            	//It seems that element nodes specifically contain href, thus TextNode objects are not useful here
            	if (node instanceof Element) {
                    int openPar = StringUtils.countMatches(node.toString(), "(");
            		int closedPar = StringUtils.countMatches(node.toString(), ")");
            		int level = openPar - closedPar;
            		if (level >= 0) {
            			parenLevel += level;
            		} else {
            			parenLevel -= Math.abs(level);
            		}
            		if (node.attributes().hasKey("href")) {
            			if (node.attributes().get("href").charAt(0) != '#') {
            			useMe += node.attributes().get("href");
            			testConjecture(destination, useMe, 10);
            			}
            		}
            	}
            	/* Implementation using strings
            	 * 
            	 
                if (node instanceof TextNode) {
                	//System.out.println("This node: ");
                	//System.out.println(node.toString());
                	//System.out.println("This node END");
                } else if (node instanceof Element) {
                	System.out.println("This element node: ");
                	String nodeToString = node.toString();
                	System.out.println(nodeToString);
                	if (nodeToString.contains("<a href=")) {
                		String containsLink = nodeToString.substring(nodeToString.indexOf("<a href=") + 9);
                		int start = nodeToString.indexOf("=\"") + 2;
                		useMe += containsLink.substring(0, containsLink.indexOf(" ") - 1);
                	System.out.println("This node END");
                	System.out.println("Found page " + useMe);
                    testConjecture(destination, useMe, 10);
                    System.out.println("Couldn't find " + destination + "with depth " + limit + ".");
                	}
                } */
                
                // TODO: FILL THIS IN!
            	// If this node is a text node make sure you are not within parentheses
            	
            	// If this node has a link you can get it by accessing the href attribute in the node
            	
            	// If the link is not null and not an empty string and does not start with a # sign 
            	// and is not within parentheses, follow the link recursively by calling testConjecture() 
            	// until you reach your objective or run past the limit. 
            } 

        }
    }
}
