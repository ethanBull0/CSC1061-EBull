package edu.frcc.csc1061jsp25.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;



public class FileTree implements Iterable <FileNode> {

	private FileNode root;
	
	
	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator 
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}
	
	/**
	 * 	TODO for Exam 2
	 *  Use recursion to build the tree from the directory structure.
	 *  For each of node starting from the root node use listFiles() from File to get 
	 *  the list of files in that directory/folder.
	 *  Create a node for each of the files and add it to a list of child nodes for the node
	 *  Do this recursively for all the nodes.  
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) { //?
		if (fileNode.getFile().isDirectory()) {
			buildTree(fileNode.getChildNodes().getFirst());
			ArrayList<FileNode> thisDir = new ArrayList<>();
			fileNode.setChildNodes(thisDir);
		} else {
			
		}
		fileNode.setChildNodes(null);
		
		
	
	}
	
	/**
	 * TODO for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here: 
	 * (2 arrayDeque objects)
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return 
	 */
	private class DepthFirstIterator implements Iterator<FileNode> {
		
		FileNode current = root;
		Deque<FileNode> stack;
		Deque<FileNode> storeStack;
		
		public DepthFirstIterator() {
			stack = new ArrayDeque<>();
			stack.push(root);
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		@Override
		public FileNode next() {
			FileNode node = stack.pop();
			storeStack.push(node);
			List<FileNode> children = node.getChildNodes();
			List<FileNode> childrenCopy = new ArrayList<>(children);
			Collections.reverse(childrenCopy);
			for (FileNode child : childrenCopy) {
				stack.push(child);
			}
			
			return node;
		}
	}
	
	/**
	 *  Returns an iterator that does a breadth first traversal of the tree using a queue.
	 * (arrayDeque)
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		
		return new BreadthFirstIterator();

	}	
	
	/** 
	 * TODO for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		
		public BreadthFirstIterator() {
				
		}
		
		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public FileNode next() {
			return null;
		}
		
	}
}
